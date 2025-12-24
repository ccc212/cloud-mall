package cn.ccc212.mall.service.impl;

import cn.ccc212.mall.goods.api.Brand;
import cn.ccc212.mall.mapper.BrandMapper;
import cn.ccc212.mall.service.IBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author ccc212
 * @since 2025-12-24
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {
}
