package cn.ccc212.mall.service.impl;

import cn.ccc212.mall.dto.skuAttribute.SkuAttributeAddDTO;
import cn.ccc212.mall.dto.skuAttribute.SkuAttributePageDTO;
import cn.ccc212.mall.goods.model.CategoryAttr;
import cn.ccc212.mall.goods.model.SkuAttribute;
import cn.ccc212.mall.mapper.CategoryAttrMapper;
import cn.ccc212.mall.mapper.SkuAttributeMapper;
import cn.ccc212.mall.service.ISkuAttributeService;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
public class SkuAttributeServiceImpl extends ServiceImpl<SkuAttributeMapper, SkuAttribute> implements ISkuAttributeService {

    private final SkuAttributeMapper skuAttributeMapper;
    private final CategoryAttrMapper categoryAttrMapper;

    @Override
    public List<SkuAttribute> queryListByCategoryId(Integer categoryId) {
        return skuAttributeMapper.queryListByCategoryId(categoryId);
    }

    @Override
    public Page<SkuAttribute> queryPageList(SkuAttributePageDTO skuAttributePageDTO) {
        String name = skuAttributePageDTO.getName();
        return lambdaQuery()
                .like(StringUtils.hasText(name), SkuAttribute::getName, name)
                .page(new Page<>(skuAttributePageDTO.getPage(), skuAttributePageDTO.getSize()));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addSkuAttribute(SkuAttributeAddDTO skuAttributeAddDTO) {
        SkuAttribute skuAttribute = BeanUtil.copyProperties(skuAttributeAddDTO, SkuAttribute.class);
        save(skuAttribute);

        List<Map<String, Integer>> categories = skuAttributeAddDTO.getCategories();
        List<Integer> categoryIds = categories.stream().map(category -> category.get("id")).collect(Collectors.toList());
        categoryAttrMapper.saveBatch(skuAttribute.getId(), categoryIds);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSkuAttribute(Integer id) {
        removeById(id);
        categoryAttrMapper.delete(new LambdaQueryWrapper<CategoryAttr>()
                .eq(CategoryAttr::getAttrId, id));
    }
}
