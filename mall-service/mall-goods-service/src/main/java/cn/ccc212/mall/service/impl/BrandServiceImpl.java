package cn.ccc212.mall.service.impl;

import cn.ccc212.mall.dto.brand.BrandAddDTO;
import cn.ccc212.mall.goods.model.Brand;
import cn.ccc212.mall.goods.model.CategoryBrand;
import cn.ccc212.mall.mapper.BrandMapper;
import cn.ccc212.mall.mapper.CategoryBrandMapper;
import cn.ccc212.mall.service.IBrandService;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author ccc212
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

    private final BrandMapper brandMapper;
    private final CategoryBrandMapper categoryBrandMapper;

    @Override
    public List<Brand> queryList(Brand brand) {
        return lambdaQuery()
                .eq(brand.getId() != null, Brand::getId, brand.getId())
                .like(StringUtils.isNotBlank(brand.getName()), Brand::getName, brand.getName())
                .eq(brand.getImage() != null, Brand::getImage, brand.getImage())
                .eq(brand.getInitial() != null, Brand::getInitial, brand.getInitial())
                .eq(brand.getSort() != null, Brand::getSort, brand.getSort())
                .list();
    }

    @Override
    public Page<Brand> queryPageList(Long currentPage, Long size, Brand brand) {
        return lambdaQuery()
                .eq(brand.getId() != null, Brand::getId, brand.getId())
                .like(StringUtils.isNotBlank(brand.getName()), Brand::getName, brand.getName())
                .eq(brand.getImage() != null, Brand::getImage, brand.getImage())
                .eq(brand.getInitial() != null, Brand::getInitial, brand.getInitial())
                .eq(brand.getSort() != null, Brand::getSort, brand.getSort())
                .page(new Page<>(currentPage, size));
    }

    @Override
    public List<Brand> queryByCategoryId(Integer id) {
        List<Integer> brandIds = brandMapper.queryByCategoryId(id);
        return brandMapper.selectByIds(brandIds);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addBrand(BrandAddDTO brandAddDTO) {
        Brand brand = BeanUtil.copyProperties(brandAddDTO, Brand.class);
        save(brand);

        List<Map<String, Integer>> categories = brandAddDTO.getCategories();
        List<Integer> categoryIds = categories.stream().map(category -> category.get("id")).collect(Collectors.toList());
        categoryBrandMapper.saveBatch(brand.getId(), categoryIds);
    }

    @Override
    public void deleteBrand(Integer brandId) {
        removeById(brandId);
        categoryBrandMapper.delete(new LambdaQueryWrapper<CategoryBrand>()
                .eq(CategoryBrand::getBrandId, brandId));
    }
}
