package cn.ccc212.mall.controller;


import cn.ccc212.mall.goods.api.Sku;
import cn.ccc212.mall.service.ISkuService;
import cn.ccc212.mall.util.RespResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author ccc212
 * @since 2025-12-24
 */
@RestController
@RequestMapping("/sku")
@RequiredArgsConstructor
public class SkuController {

    private final ISkuService skuService;

    @GetMapping("/aditems/type")
    public RespResult<List<Sku>> typeitems(@RequestParam Integer type){
        return RespResult.ok(skuService.findSkuListByAdItemsType(type));
    }

}
