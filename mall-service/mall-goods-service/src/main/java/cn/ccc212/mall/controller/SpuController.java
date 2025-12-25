package cn.ccc212.mall.controller;


import cn.ccc212.mall.goods.api.Product;
import cn.ccc212.mall.goods.api.Spu;
import cn.ccc212.mall.service.ISpuService;
import cn.ccc212.mall.util.RespResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
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
    public RespResult save(@RequestBody Product product){
        spuService.saveProduct(product);
        return RespResult.ok();
    }

    @PostMapping("/list/{page}/{size}")
    public RespResult list(@PathVariable(value = "page")Long currentPage,
                           @PathVariable(value = "size")Long size,
                           @RequestBody(required = false) Spu spu){
        return RespResult.ok(spuService.queryPageList(currentPage, size, spu));
    }

}
