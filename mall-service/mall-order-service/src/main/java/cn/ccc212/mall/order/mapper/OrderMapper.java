package cn.ccc212.mall.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.ccc212.mall.order.bean.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
