package cn.ccc212.mall.user.controller;

import cn.ccc212.mall.user.bean.Address;
import cn.ccc212.mall.user.service.AddressService;
import cn.ccc212.mall.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/list")
    public RespResult<List<Address>> list(String username) {
        List<Address> res = addressService.list(username);
        return RespResult.ok(res);
    }
}
