package cn.ccc212.mall.cart.controller;

import cn.ccc212.mall.cart.model.Cart;
import cn.ccc212.mall.cart.service.CartService;
import cn.ccc212.mall.util.RespResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/{id}/{num}")
    public RespResult<?> add(@PathVariable(value = "id") String skuId, @PathVariable(value = "num") Integer num) {
        cartService.add(skuId, "ccc212", num);
        return RespResult.ok();
    }

    @GetMapping(value = "/list")
    public RespResult<List<Cart>> list(){
        return RespResult.ok(cartService.list("ccc212"));
    }
}