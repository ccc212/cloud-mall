package cn.ccc212.mall.service.impl;

import cn.ccc212.mall.goods.api.SkuAttribute;
import cn.ccc212.mall.mapper.SkuAttributeMapper;
import cn.ccc212.mall.service.ISkuAttributeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ccc212
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SkuAttributeServiceImpl extends ServiceImpl<SkuAttributeMapper, SkuAttribute> implements ISkuAttributeService {

    private final SkuAttributeMapper skuAttributeMapper;

    @Override
    public List<SkuAttribute> queryListByCategoryId(Integer categoryId) {
        return skuAttributeMapper.queryListByCategoryId(categoryId);
    }
}
