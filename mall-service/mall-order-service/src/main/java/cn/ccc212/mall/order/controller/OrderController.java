package cn.ccc212.mall.order.controller;

import cn.ccc212.mall.order.bean.Order;
import cn.ccc212.mall.order.service.OrderService;
import cn.ccc212.mall.util.RespCode;
import cn.ccc212.mall.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public RespResult add(@RequestBody Order order) {
        Boolean bo = orderService.add(order);
        return bo ? RespResult.ok() : RespResult.error(RespCode.SYSTEM_ERROR);
    }
}
