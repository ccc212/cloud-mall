package cn.ccc212.mall.mapper;

import cn.ccc212.mall.goods.api.CategoryBrand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ccc212
 * @since 2025-12-29
 */
public interface CategoryBrandMapper extends BaseMapper<CategoryBrand> {

    void saveBatch(Integer brandId, List<Integer> categoryIds);
}
