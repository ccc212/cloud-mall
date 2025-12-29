package cn.ccc212.mall.service;

import cn.ccc212.mall.dto.brand.BrandAddDTO;
import cn.ccc212.mall.goods.api.Brand;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author ccc212
 * @since 2025-12-24
 */
public interface IBrandService extends IService<Brand> {

    List<Brand> queryList(Brand brand);

    Page<Brand> queryPageList(Long currentPage, Long size, Brand brand);

    List<Brand> queryByCategoryId(Integer id);

    void addBrand(BrandAddDTO brandAddDTO);

    void deleteBrand(Integer brandId);
}
