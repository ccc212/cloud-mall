package cn.ccc212.mall.page.feign;

import cn.ccc212.mall.util.RespResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "mall-web-page")
public interface PageFeign {

    @GetMapping(value = "/page/{id}")
    RespResult<?> generateHtml(@PathVariable(value = "id") String spuId);
}