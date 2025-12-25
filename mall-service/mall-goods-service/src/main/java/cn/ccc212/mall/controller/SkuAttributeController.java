package cn.ccc212.mall.controller;


import cn.ccc212.mall.goods.api.SkuAttribute;
import cn.ccc212.mall.service.ISkuAttributeService;
import cn.ccc212.mall.util.RespResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ccc212
 * @since 2025-12-24
 */
@RestController
@RequestMapping("/skuAttribute")
@RequiredArgsConstructor
public class SkuAttributeController {

    private final ISkuAttributeService skuAttributeService;

    @GetMapping("/category/{id}")
    public RespResult<List<SkuAttribute>> categoryAttributeList(@PathVariable(value = "id")Integer categoryId){
        return RespResult.ok(skuAttributeService.queryListByCategoryId(categoryId));
    }

}
