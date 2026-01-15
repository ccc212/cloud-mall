package cn.ccc212.mall.order;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication()
@MapperScan(basePackages = "cn.ccc212.mall.order.mapper")
@EnableFeignClients(basePackages = {"cn.ccc212.mall.goods.feign", "cn.ccc212.mall.cart.feign"})
@Slf4j
public class MallOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallOrderApplication.class, args);
        log.info("\n========================\n" +
                "\t\t启动成功\n" +
                "========================");
    }
}
