package cn.ccc212.mall.service.impl;

import cn.ccc212.mall.goods.model.Category;
import cn.ccc212.mall.mapper.CategoryMapper;
import cn.ccc212.mall.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品类目 服务实现类
 * </p>
 *
 * @author ccc212
 * @since 2025-12-24
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Override
    public List<Category> queryByParentId(Integer pid) {
        return lambdaQuery()
                .eq(Category::getParentId, pid)
                .list();
    }
}
