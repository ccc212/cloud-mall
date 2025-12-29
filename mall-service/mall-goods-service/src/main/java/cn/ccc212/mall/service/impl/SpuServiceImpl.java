package cn.ccc212.mall.service.impl;

import cn.ccc212.mall.enums.AuditStatusEnum;
import cn.ccc212.mall.enums.CommonConstant;
import cn.ccc212.mall.enums.GoodsStatusEnum;
import cn.ccc212.mall.goods.api.*;
import cn.ccc212.mall.mapper.BrandMapper;
import cn.ccc212.mall.mapper.CategoryMapper;
import cn.ccc212.mall.mapper.SkuMapper;
import cn.ccc212.mall.mapper.SpuMapper;
import cn.ccc212.mall.service.ISpuService;
import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ccc212
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SpuServiceImpl extends ServiceImpl<SpuMapper, Spu> implements ISpuService {

    private final SpuMapper spuMapper;
    private final SkuMapper skuMapper;
    private final BrandMapper brandMapper;
    private final CategoryMapper categoryMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveProduct(Product product) {
        Spu spu = product.getSpu();

        if (StringUtils.isEmpty(spu.getId())) {
            spu.setIsMarketable(CommonConstant.TRUE)
                    .setIsDelete(CommonConstant.TRUE)
                    .setStatus(AuditStatusEnum.NOT_AUDIT.getCode());
            spuMapper.insert(spu);
        } else {
            //ID 不为空，则修改
            spuMapper.updateById(spu);
            skuMapper.delete(new LambdaQueryWrapper<Sku>()
                    .eq(Sku::getSpuId, spu.getId()));
        }

        Brand brand = brandMapper.selectById(spu.getBrandId());
        Category category = categoryMapper.selectById(spu.getCategoryThreeId());
        LocalDateTime now = LocalDateTime.now();
        List<Sku> skus = product.getSkus();
        if (CollUtil.isNotEmpty(skus)) {
            List<Sku> skuDOList = new ArrayList<>(skus.size());

            skus.forEach(sku -> {
                String skuName = spu.getName();
                Map<String, String> attrMap = JSON.parseObject(sku.getSkuAttribute(), Map.class);
                for (Map.Entry<String, String> entry : attrMap.entrySet()) {
                    skuName += "   " + entry.getValue();
                }
                sku.setName(skuName)
                        .setImages(spu.getImages())
                        .setStatus(GoodsStatusEnum.NORMAL.getCode())
                        .setCategoryId(spu.getCategoryThreeId())
                        .setCategoryName(category.getName())
                        .setBrandId(brand.getId())
                        .setBrandName(brand.getName())
                        .setSpuId(spu.getId())
                        .setCreateTime(now)
                        .setUpdateTime(now);
                skuDOList.add(sku);
            });

            skuMapper.saveBatch(skuDOList);
        }
    }

    @Override
    public Page<Spu> queryPageList(Long currentPage, Long size, Spu spu) {
        return lambdaQuery()
                .eq(Spu::getIsDelete, CommonConstant.FALSE)
                .eq(spu.getBrandId() != null, Spu::getBrandId, spu.getBrandId())
                .eq(spu.getCategoryOneId() != null, Spu::getCategoryOneId, spu.getCategoryOneId())
                .eq(spu.getCategoryTwoId() != null, Spu::getCategoryTwoId, spu.getCategoryTwoId())
                .eq(spu.getCategoryThreeId() != null, Spu::getCategoryThreeId, spu.getCategoryThreeId())
                .like(StringUtils.hasText(spu.getName()), Spu::getName, spu.getName())
                .page(new Page<>(currentPage, size));
    }

    @Override
    public Product getProduct(Long spuId) {
        Spu spu = getById(spuId);
        List<Sku> skus = skuMapper.selectList(new LambdaQueryWrapper<Sku>()
                .eq(Sku::getSpuId, spuId));
        return new Product()
                .setSpu(spu)
                .setSkus(skus);
    }

    @Override
    public Boolean audit(Spu spu) {
        return updateById(spu);
    }

    @Override
    public Boolean logicDelete(Long spuId) {
        return spuMapper.update(new LambdaUpdateWrapper<Spu>()
                .eq(Spu::getId, spuId)
                .set(Spu::getIsDelete, CommonConstant.TRUE)) > 0;
    }

    @Override
    public Boolean pull(Long spuId) {
        return update(new LambdaUpdateWrapper<Spu>()
                .eq(Spu::getId, spuId)
                .set(Spu::getIsMarketable, CommonConstant.FALSE));
    }

    @Override
    public Boolean put(Long spuId) {
        return update(new LambdaUpdateWrapper<Spu>()
                .eq(Spu::getId, spuId)
                .set(Spu::getIsMarketable, CommonConstant.TRUE));
    }
}
