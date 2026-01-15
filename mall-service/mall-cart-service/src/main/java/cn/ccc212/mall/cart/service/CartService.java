package cn.ccc212.mall.cart.service;

import cn.ccc212.mall.cart.model.Cart;

import java.util.List;

public interface CartService{

    void add(String skuId,String userName,Integer num);

    List<Cart> list(List<String> ids);

    void delete(List<String> ids);
}