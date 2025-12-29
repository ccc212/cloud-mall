package cn.ccc212.mall.controller;


import cn.ccc212.mall.dto.skuAttribute.SkuAttributeAddDTO;
import cn.ccc212.mall.dto.skuAttribute.SkuAttributePageDTO;
import cn.ccc212.mall.goods.api.SkuAttribute;
import cn.ccc212.mall.goods.api.Spu;
import cn.ccc212.mall.service.ISkuAttributeService;
import cn.ccc212.mall.util.RespResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 前端控制器
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
    public RespResult<List<SkuAttribute>> categoryAttributeList(@PathVariable(value = "id") Integer categoryId) {
        return RespResult.ok(skuAttributeService.queryListByCategoryId(categoryId));
    }

    @PostMapping("/list/{page}/{size}")
    public RespResult<Page<SkuAttribute>> queryPageList(@RequestBody @Valid SkuAttributePageDTO skuAttributePageDTO) {
        return RespResult.ok(skuAttributeService.queryPageList(skuAttributePageDTO));
    }

    @PostMapping
    public RespResult<?> addSkuAttribute(@RequestBody SkuAttributeAddDTO skuAttributeAddDTO) {
        skuAttributeService.addSkuAttribute(skuAttributeAddDTO);
        return RespResult.ok();
    }

    @DeleteMapping("/{id}")
    public RespResult<Page<Spu>> deleteSkuAttribute(@PathVariable Integer id) {
        skuAttributeService.deleteSkuAttribute(id);
        return RespResult.ok();
    }

}
