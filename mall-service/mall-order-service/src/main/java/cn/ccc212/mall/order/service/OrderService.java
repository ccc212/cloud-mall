package cn.ccc212.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.ccc212.mall.order.bean.Order;

public interface OrderService extends IService<Order> {
    // 添加订单
    Boolean add(Order order);
}
