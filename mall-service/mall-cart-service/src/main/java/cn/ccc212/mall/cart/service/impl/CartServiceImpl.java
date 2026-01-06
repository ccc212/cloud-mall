package cn.ccc212.mall.cart.service.impl;


import cn.ccc212.mall.cart.mapper.CartMapper;
import cn.ccc212.mall.cart.model.Cart;
import cn.ccc212.mall.cart.service.CartService;
import cn.ccc212.mall.goods.feign.SkuFeign;
import cn.ccc212.mall.goods.model.Sku;
import cn.ccc212.mall.util.RespResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartMapper cartMapper;
    private final SkuFeign skuFeign;

    @Override
    public void add(String skuId, String userName, Integer num) {
        //删除购物车中当前商品
        cartMapper.deleteById(userName + skuId);

        if (num <= 0) {
            return;
        }
        RespResult<Sku> skuResp = skuFeign.getById(skuId);
        Cart cart = new Cart();
        cart.setUserName(userName);
        cart.setSkuId(skuId);
        cart.setNum(num);
        sku2cart(skuResp.getData(), cart);
        cartMapper.save(cart);
    }

    @Override
    public List<Cart> list(String userName) {
        return cartMapper.findAll(Example.of(new Cart().setUserName(userName)),
                Sort.by("_id"));
    }

    public void sku2cart(Sku sku, Cart cart) {
        cart.setImage(sku.getImage());
        cart.set_id(cart.getUserName() + cart.getSkuId());
        cart.setName(sku.getName());
        cart.setPrice(sku.getPrice());
        cart.setSkuId(sku.getId());
    }
}
