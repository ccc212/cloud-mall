package cn.ccc212.mall.service.impl;

import cn.ccc212.mall.goods.api.AdItems;
import cn.ccc212.mall.goods.api.Sku;
import cn.ccc212.mall.mapper.AdItemsMapper;
import cn.ccc212.mall.mapper.SkuMapper;
import cn.ccc212.mall.service.ISkuService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author ccc212
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements ISkuService {

    private final SkuMapper skuMapper;
    private final AdItemsMapper adItemsMapper;

    @Override
    public List<Sku> findSkuListByAdItemsType(Integer type) {
        List<AdItems> adItemsList = adItemsMapper.selectList(new LambdaQueryWrapper<AdItems>()
                .eq(AdItems::getType, type));
        List<String> skuids = adItemsList.stream().map(AdItems::getSkuId).collect(Collectors.toList());
        return skuMapper.selectByIds(skuids);
    }
}
