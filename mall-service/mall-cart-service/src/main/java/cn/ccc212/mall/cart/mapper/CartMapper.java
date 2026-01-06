package cn.ccc212.mall.cart.mapper;

import cn.ccc212.mall.cart.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartMapper extends MongoRepository<Cart, String> {
}