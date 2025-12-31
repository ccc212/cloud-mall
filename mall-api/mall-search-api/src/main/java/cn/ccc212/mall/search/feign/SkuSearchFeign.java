package cn.ccc212.mall.search.feign;

import cn.ccc212.mall.util.RespResult;
import cn.ccc212.mall.search.model.SkuEs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "mall-search-service", path = "/search")
public interface SkuSearchFeign {

    @PostMapping(value = "/add")
    RespResult<?> add(@RequestBody SkuEs skuEs);

    @DeleteMapping(value = "/del/{id}")
    RespResult<?> delete(@PathVariable("id") String id);

}