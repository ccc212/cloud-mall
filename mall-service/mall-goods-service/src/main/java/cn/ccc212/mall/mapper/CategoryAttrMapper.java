package cn.ccc212.mall.mapper;

import cn.ccc212.mall.goods.model.CategoryAttr;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ccc212
 * @since 2025-12-28
 */
public interface CategoryAttrMapper extends BaseMapper<CategoryAttr> {

    void saveBatch(Integer attrId, List<Integer> categoryIds);
}
