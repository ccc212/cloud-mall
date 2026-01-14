package cn.ccc212.mall.user.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ccc212.mall.user.bean.Address;
import cn.ccc212.mall.user.mapper.AddressMapper;
import cn.ccc212.mall.user.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address>
        implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> list(String username) {
        QueryWrapper<Address> queryWrapper = new QueryWrapper<Address>();
        queryWrapper.eq("username", username);
        return addressMapper.selectList(queryWrapper);
    }

}
