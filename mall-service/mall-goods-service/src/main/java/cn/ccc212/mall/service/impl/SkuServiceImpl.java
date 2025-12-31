package cn.ccc212.mall.service.impl;

import cn.ccc212.mall.goods.enums.RedisKeyConstant;
import cn.ccc212.mall.goods.model.AdItems;
import cn.ccc212.mall.goods.model.Sku;
import cn.ccc212.mall.mapper.AdItemsMapper;
import cn.ccc212.mall.mapper.SkuMapper;
import cn.ccc212.mall.service.ISkuService;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
@Slf4j
@CacheConfig(cacheNames = RedisKeyConstant.AD_ITEMS_SKUS)
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements ISkuService {

    private final SkuMapper skuMapper;
    private final AdItemsMapper adItemsMapper;

    @Cacheable(key = "#type")
    @Override
    public List<Sku> findSkuListByAdItemsType(Integer type) {
        List<AdItems> adItemsList = adItemsMapper.selectList(new LambdaQueryWrapper<AdItems>()
                .eq(AdItems::getType, type));
        List<String> skuids = adItemsList.stream().map(AdItems::getSkuId).collect(Collectors.toList());
        return skuMapper.selectByIds(skuids);
    }

    @CacheEvict(key = "#type")
    @Override
    public void deleteAditemsByType(Integer type) {
        log.info("用 @CacheEvict 注解，执行了删除redis缓存操作");
    }

    @CachePut(key = "#type")
    @Override
    public List<Sku> updateAditemsByType(Integer type) {
        List<AdItems> adItemsList = adItemsMapper.selectList(new LambdaQueryWrapper<AdItems>()
                .eq(AdItems::getType, type));
        List<String> skuids = adItemsList.stream().map(AdItems::getSkuId).collect(Collectors.toList());
        return CollUtil.isNotEmpty(skuids) ? skuMapper.selectByIds(skuids) : Collections.emptyList();
    }
}
