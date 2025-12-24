package cn.ccc212.mall.controller;


import cn.ccc212.mall.goods.api.Brand;
import cn.ccc212.mall.service.IBrandService;
import cn.ccc212.mall.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author ccc212
 * @since 2025-12-24
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    @PostMapping("/addBrand")
    public RespResult<?> addBrand(@RequestBody Brand brand){
        this.brandService.save(brand);
        return RespResult.ok();
    }

    @GetMapping("/getBrandById/{id}")
    public RespResult<?> getBrandById(@PathVariable String id){
        Brand brand = this.brandService.getById(id);
        return RespResult.ok(brand);
    }

    @PostMapping("/upateBrand")
    public RespResult<?> upateBrand(@RequestBody Brand brand){
        this.brandService.updateById(brand);
        return RespResult.ok();
    }

    @DeleteMapping("/deleteBrand/{id}")
    public RespResult<?> deleteBrand(@PathVariable String id){
        this.brandService.removeById(id);
        return RespResult.ok();
    }

}
