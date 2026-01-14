package cn.ccc212;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication()
@EnableDiscoveryClient
@MapperScan(basePackages = "cn.ccc212.mall.order.mapper")
@EnableFeignClients(basePackages = {"cn.ccc212.mall.goods.feign", "cn.ccc212.mall.cart.feign"})
public class MallOrderApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(MallOrderApplication.class, args);
    }
}
