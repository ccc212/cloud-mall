package cn.ccc212.mall.controller;


import cn.ccc212.mall.dto.brand.BrandAddDTO;
import cn.ccc212.mall.goods.api.Brand;
import cn.ccc212.mall.service.IBrandService;
import cn.ccc212.mall.util.RespResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@RequiredArgsConstructor
public class BrandController {

    private final IBrandService brandService;

    @PostMapping
    public RespResult<?> addBrand(@RequestBody BrandAddDTO brandAddDTO){
        this.brandService.addBrand(brandAddDTO);
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

    @DeleteMapping("/{brandId}")
    public RespResult<?> deleteBrand(@PathVariable Integer brandId){
        this.brandService.deleteBrand(brandId);
        return RespResult.ok();
    }

    @PostMapping("/list")
    public RespResult<List<Brand>> list(@RequestBody(required = false) Brand brand){
        return RespResult.ok(brandService.queryList(brand));
    }

    @PostMapping("/list/{page}/{size}")
    public RespResult<Page<Brand>> queryPageList(
            @PathVariable(value = "page")Long currentPage,
            @PathVariable(value = "size")Long size,
            @RequestBody(required = false) Brand brand){
        return RespResult.ok(brandService.queryPageList(currentPage,size,brand));
    }

    @GetMapping("/category/{id}")
    public RespResult<List<Brand>> categoryBrands(@PathVariable(value = "id")Integer id){
        return RespResult.ok(brandService.queryByCategoryId(id));
    }

    @GetMapping
    public RespResult<List<Brand>> listAll(){
        return RespResult.ok(brandService.list());
    }

}
