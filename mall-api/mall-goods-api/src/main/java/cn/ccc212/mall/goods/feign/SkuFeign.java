package cn.ccc212.mall.goods.feign;

import cn.ccc212.mall.cart.model.Cart;
import cn.ccc212.mall.goods.model.Sku;
import cn.ccc212.mall.util.RespResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "mall-goods", path = "/sku")
public interface SkuFeign {

    /**
     * 根据ID获取Sku
     */
    @GetMapping(value = "/{id}")
    RespResult<Sku> one(@PathVariable(value = "id") String id);

    /**
     * 库存递减*/
    @PostMapping("/reduce")
    RespResult reduce(@RequestBody List<Cart> carts);

    @GetMapping("/aditems/type")
    RespResult<?> typeitems(@RequestParam Integer id);

    @DeleteMapping("/deleteAditems/type")
    RespResult<?> deleteTypeItems(@RequestParam Integer id);

    @PutMapping("/updateAitems/type")
    RespResult<?> updateTypeItems(@RequestParam Integer id);

    @GetMapping(value = "/{id}")
    RespResult<Sku> getById(@PathVariable(value = "id") String id);
}
