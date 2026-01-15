package cn.ccc212.mall.mapper;

import cn.ccc212.mall.goods.model.Sku;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author ccc212
 * @since 2025-12-24
 */
public interface SkuMapper extends BaseMapper<Sku> {

    void saveBatch(List<Sku> skuDOList);

    // 库存递减
    @Update("UPDATE sku SET num = num - #{num} WHERE id = #{skuId} AND num >= #{num}")
    int reduce(@Param("skuId") String skuId, @Param("num") Integer num);
}
