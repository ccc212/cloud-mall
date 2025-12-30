package cn.ccc212.mall.canal;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients(basePackages = {"cn.ccc212.mall.goods.feign"})
@Slf4j
public class MallCanalApp {

    public static void main(String[] args) {
        SpringApplication.run(MallCanalApp.class, args);
        log.info("\n========================\n" +
                "\t\t启动成功\n" +
                "========================");
    }

}

