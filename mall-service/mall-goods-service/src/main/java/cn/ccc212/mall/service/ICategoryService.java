package cn.ccc212.mall.service;

import cn.ccc212.mall.goods.api.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品类目 服务类
 * </p>
 *
 * @author ccc212
 * @since 2025-12-24
 */
public interface ICategoryService extends IService<Category> {

    List<Category> queryByParentId(Integer pid);
}
