package cn.ccc212.mall.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.ccc212.mall.user.model.Address;

import java.util.List;

public interface AddressService extends IService<Address> {
    // 根据用户名查询地址列表
    List<Address> list(String username);
}
