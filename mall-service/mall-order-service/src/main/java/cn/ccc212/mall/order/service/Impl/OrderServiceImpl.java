package cn.ccc212.mall.order.service.Impl;

import cn.ccc212.mall.cart.feign.CartFeign;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ccc212.mall.cart.model.Cart;
import cn.ccc212.mall.goods.feign.SkuFeign;
import cn.ccc212.mall.order.bean.Order;
import cn.ccc212.mall.order.bean.OrderSku;
import cn.ccc212.mall.order.mapper.OrderMapper;
import cn.ccc212.mall.order.mapper.OrderSkuMapper;
import cn.ccc212.mall.order.service.OrderService;
import cn.ccc212.mall.util.RespResult;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.keyvalue.core.IterableConverter;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
        implements OrderService {
    
    private final OrderMapper orderMapper;
    private final OrderSkuMapper orderSkuMapper;
    private final SkuFeign skuFeign;
    private final CartFeign cartFeign;

    // 添加订单
    @Override
    @GlobalTransactional
    public Boolean add(Order order) {
        order.setOrderStatus(0);
        order.setPayStatus(0);
        order.setIsDelete(0);
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        order.setId(IdWorker.getIdStr());

        // 查询购物车并组建订单
        RespResult<List<Cart>> cartsRes = cartFeign.list(order.getCartIds());
        List<Cart> carts = IterableConverter.toList(cartsRes.getData());

        if (carts.isEmpty()) {
            return false;
        }
        // 根据购物车商品进行更新库存
        skuFeign.reduce(carts);

        // 更新成功入库OrderSku
        int totalNum = 0;
        int payMoney = 0;
        for (Cart cart : carts) {
            OrderSku orderSku = JSON.parseObject(JSON.toJSONString(cart), OrderSku.class);
            orderSku.setId(IdWorker.getIdStr());
            orderSku.setMoney(orderSku.getPrice()*orderSku.getNum());
            orderSku.setSkuId(cart.getSkuId());
            orderSku.setOrderId(order.getId());
            orderSkuMapper.insert(orderSku) ;
            totalNum += cart.getNum();
            payMoney += cart.getPrice();
        }

        order.setTotalNum(totalNum);
        order.setMoneys(payMoney);
        orderMapper.insert(order);

//        int i = 1/0;

        // 清除购物车
        cartFeign.delete(order.getCartIds());
        return true;
    }
}
