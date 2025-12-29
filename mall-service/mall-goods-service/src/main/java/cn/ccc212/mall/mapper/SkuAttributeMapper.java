package cn.ccc212.mall.mapper;

import cn.ccc212.mall.goods.model.SkuAttribute;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ccc212
 * @since 2025-12-24
 */
public interface SkuAttributeMapper extends BaseMapper<SkuAttribute> {

    @Select("select * from sku_attribute where id in (select attr_id from category_attr where category_id = #{categoryId})")
    List<SkuAttribute> queryListByCategoryId(Integer categoryId);
}
