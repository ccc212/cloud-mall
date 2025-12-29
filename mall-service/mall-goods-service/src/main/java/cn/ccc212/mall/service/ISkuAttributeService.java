package cn.ccc212.mall.service;

import cn.ccc212.mall.dto.skuAttribute.SkuAttributeAddDTO;
import cn.ccc212.mall.dto.skuAttribute.SkuAttributePageDTO;
import cn.ccc212.mall.goods.api.SkuAttribute;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ccc212
 * @since 2025-12-24
 */
public interface ISkuAttributeService extends IService<SkuAttribute> {

    List<SkuAttribute> queryListByCategoryId(Integer categoryId);

    Page<SkuAttribute> queryPageList(SkuAttributePageDTO skuAttributePageDTO);

    void addSkuAttribute(SkuAttributeAddDTO skuAttributeAddDTO);

    void deleteSkuAttribute(Integer id);
}
