package cn.ccc212.mall.user.service.Impl;

import cn.ccc212.mall.user.mapper.AddressMapper;
import cn.ccc212.mall.user.model.Address;
import cn.ccc212.mall.user.service.AddressService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address>
        implements AddressService {

    private final AddressMapper addressMapper;

    @Override
    public List<Address> list(String username) {
        return addressMapper.selectList(new LambdaQueryWrapper<Address>()
                .eq(Address::getUsername, username));
    }

}
