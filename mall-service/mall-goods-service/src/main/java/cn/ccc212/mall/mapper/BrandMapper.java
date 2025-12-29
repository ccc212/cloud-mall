package cn.ccc212.mall.mapper;

import cn.ccc212.mall.goods.model.Brand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 品牌表 Mapper 接口
 * </p>
 *
 * @author ccc212
 * @since 2025-12-24
 */
public interface BrandMapper extends BaseMapper<Brand> {

    @Select("select brand_id from category_brand cb where cb.category_id = #{id}")
    List<Integer> queryByCategoryId(Integer id);
}
