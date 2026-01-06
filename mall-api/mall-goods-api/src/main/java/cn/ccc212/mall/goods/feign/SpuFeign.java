package cn.ccc212.mall.goods.feign;

import cn.ccc212.mall.goods.model.Product;
import cn.ccc212.mall.util.RespResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "mall-goods")
public interface SpuFeign {

    @GetMapping(value = "/spu/product/{id}")
    RespResult<Product> getBySpuId(@PathVariable(value = "id") String id);
}