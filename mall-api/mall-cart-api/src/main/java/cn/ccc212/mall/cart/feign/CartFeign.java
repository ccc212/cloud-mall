package cn.ccc212.mall.cart.feign;

import cn.ccc212.mall.cart.model.Cart;
import cn.ccc212.mall.util.RespResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "mall-cart")
public interface CartFeign {
    @PostMapping("/cart/list")
    RespResult<List<Cart>> list(@RequestBody List<String> cartIds);

    @DeleteMapping("/cart")
    RespResult delete(@RequestBody List<String> ids);
}
