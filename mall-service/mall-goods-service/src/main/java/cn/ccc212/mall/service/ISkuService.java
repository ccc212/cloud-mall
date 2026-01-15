package cn.ccc212.mall.service;

import cn.ccc212.mall.cart.model.Cart;
import cn.ccc212.mall.goods.model.Sku;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author ccc212
 * @since 2025-12-24
 */
public interface ISkuService extends IService<Sku> {

    List<Sku> findSkuListByAdItemsType(Integer type);

    void deleteAditemsByType(Integer type);

    List<Sku> updateAditemsByType(Integer type);

    void reduce(List<Cart> carts);
}
