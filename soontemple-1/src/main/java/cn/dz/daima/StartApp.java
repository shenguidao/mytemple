package cn.dz.daima;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//启动-导入web包
@SpringBootApplication(scanBasePackages = "cn.dz.daima")
//开启注解-spring-tx包
@EnableTransactionManagement
//mapper包扫描,mybatis包
@MapperScan("cn.dz.daima.mapper")
public class StartApp {
    public static void main(String[] args) {
        SpringApplication.run(StartApp.class);
    }
}
