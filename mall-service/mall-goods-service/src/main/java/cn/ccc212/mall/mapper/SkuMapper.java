package cn.ccc212.mall.mapper;

import cn.ccc212.mall.goods.api.Sku;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
}
