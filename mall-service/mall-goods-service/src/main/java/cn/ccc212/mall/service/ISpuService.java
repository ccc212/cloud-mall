package cn.ccc212.mall.service;

import cn.ccc212.mall.goods.api.Product;
import cn.ccc212.mall.goods.api.Spu;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ccc212
 * @since 2025-12-24
 */
public interface ISpuService extends IService<Spu> {

    void saveProduct(Product product);

    Page<Spu> queryPageList(Long currentPage, Long size, Spu spu);
}
