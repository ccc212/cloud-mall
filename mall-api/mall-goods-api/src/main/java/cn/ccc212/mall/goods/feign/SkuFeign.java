package cn.ccc212.mall.goods.feign;

import cn.ccc212.mall.goods.model.Sku;
import cn.ccc212.mall.util.RespResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "mall-goods", path = "/sku")
public interface SkuFeign {

    @GetMapping("/aditems/type")
    RespResult<?> typeitems(@RequestParam Integer id);

    @DeleteMapping("/deleteAditems/type")
    RespResult<?> deleteTypeItems(@RequestParam Integer id);

    @PutMapping("/updateAitems/type")
    RespResult<?> updateTypeItems(@RequestParam Integer id);

    @GetMapping(value = "/{id}")
    RespResult<Sku> getById(@PathVariable(value = "id") String id);
}
