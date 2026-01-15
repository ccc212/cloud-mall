package cn.ccc212.mall.pay;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cn.ccc212.mall.pay.mapper")
@Slf4j
public class MallPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallPayApplication.class,args);
        log.info("\n========================\n" +
                "\t\t启动成功\n" +
                "========================");
    }
}