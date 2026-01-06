package cn.ccc212.mall.controller;


import cn.ccc212.mall.goods.model.Sku;
import cn.ccc212.mall.service.ISkuService;
import cn.ccc212.mall.util.RespResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public RespResult<List<Sku>> typeitems(@RequestParam(value = "id") Integer type) {
        return RespResult.ok(skuService.findSkuListByAdItemsType(type));
    }

    @DeleteMapping("/deleteAditems/type")
    public RespResult<?> deleteTypeItems(@RequestParam(value = "id") Integer type) {
        skuService.deleteAditemsByType(type);
        return RespResult.ok();
    }

    @PutMapping("/updateAitems/type")
    public RespResult<List<Sku>> updateTypeItems(@RequestParam(value = "id") Integer type) {
        skuService.updateAditemsByType(type);
        return RespResult.ok();
    }

    @GetMapping("/{id}")
    public RespResult<Sku> one(@PathVariable(value = "id") String id) {
        return RespResult.ok(skuService.getById(id));
    }

}
