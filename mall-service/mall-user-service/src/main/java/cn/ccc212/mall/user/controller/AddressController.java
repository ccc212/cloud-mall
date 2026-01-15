package cn.ccc212.mall.user.controller;

import cn.ccc212.mall.user.model.Address;
import cn.ccc212.mall.user.service.AddressService;
import cn.ccc212.mall.util.RespResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/list")
    public RespResult<List<Address>> list(String username) {
        return RespResult.ok(addressService.list(username));
    }
}
