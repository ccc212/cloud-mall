package cn.ccc212.mall.goods.feign;

import cn.ccc212.mall.goods.model.Category;
import cn.ccc212.mall.util.RespResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("mall-goods")
public interface CategoryFeign {

    @GetMapping(value = "/category/{id}")
    RespResult<Category> getByCategoryId(@PathVariable(value = "id") Integer id);
}