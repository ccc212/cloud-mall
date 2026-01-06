package cn.ccc212.mall.page;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"cn.ccc212.mall.goods.feign"})
@Slf4j
public class MallPageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallPageApplication.class, args);
        log.info("\n========================\n" +
                "\t\t启动成功\n" +
                "========================");
    }

}