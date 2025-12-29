package cn.ccc212.mall.controller;


import cn.ccc212.mall.goods.api.Product;
import cn.ccc212.mall.goods.api.Spu;
import cn.ccc212.mall.service.ISpuService;
import cn.ccc212.mall.util.RespResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ccc212
 * @since 2025-12-24
 */
@RestController
@RequestMapping("/spu")
@RequiredArgsConstructor
public class SpuController {

    private final ISpuService spuService;

    @PostMapping("/save")
    public RespResult<?> save(@RequestBody Product product) {
        spuService.saveProduct(product);
        return RespResult.ok();
    }

    @PostMapping("/list/{page}/{size}")
    public RespResult<Page<Spu>> list(@PathVariable(value = "page") Long currentPage,
                                      @PathVariable(value = "size") Long size,
                                      @RequestBody(required = false) Spu spu) {
        return RespResult.ok(spuService.queryPageList(currentPage, size, spu));
    }

    @GetMapping("/product/{spuId}")
    public RespResult<Product> getProduct(@PathVariable Long spuId) {
        return RespResult.ok(spuService.getProduct(spuId));
    }

    @PutMapping("/audit/{spuId}")
    public RespResult<Boolean> audit(@RequestBody Spu spu) {
        return RespResult.ok(spuService.audit(spu));
    }

    @DeleteMapping("/logic/delete/{spuId}")
    public RespResult<Boolean> logicDelete(@PathVariable Long spuId) {
        return RespResult.ok(spuService.logicDelete(spuId));
    }

    @PutMapping("/pull/{spuId}")
    public RespResult<Boolean> pull(@PathVariable Long spuId) {
        return RespResult.ok(spuService.pull(spuId));
    }

    @PutMapping("/put/{spuId}")
    public RespResult<Boolean> put(@PathVariable Long spuId) {
        return RespResult.ok(spuService.put(spuId));
    }


}
