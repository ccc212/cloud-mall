package cn.ccc212.mall.cart.controller;

import cn.ccc212.mall.cart.model.Cart;
import cn.ccc212.mall.cart.service.CartService;
import cn.ccc212.mall.util.RespResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/list")
    public RespResult<List<Cart>> list(@RequestBody List<String> ids){
        return RespResult.ok(cartService.list(ids));
    }

    @DeleteMapping
    public RespResult<?> delete(@RequestBody List<String> ids){
        cartService.delete(ids);
        return RespResult.ok();
    }
}