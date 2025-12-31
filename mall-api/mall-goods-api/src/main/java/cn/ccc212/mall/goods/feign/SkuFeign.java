package cn.ccc212.mall.goods.feign;

import cn.ccc212.mall.util.RespResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "mall-goods", path = "/sku")
public interface SkuFeign {
    
    @GetMapping("/aditems/type")
    RespResult<?> typeitems(@RequestParam Integer id);

    @DeleteMapping("/deleteAditems/type")
    RespResult<?> deleteTypeItems(@RequestParam Integer id);

    @PutMapping("/updateAitems/type")
    RespResult<?> updateTypeItems(@RequestParam Integer id);
}
