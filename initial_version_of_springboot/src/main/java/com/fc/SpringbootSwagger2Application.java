package com.fc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 功能描述：springboot2
 * @author gxy
 * @date 2018/11/16 14:30
 * @param
 * @return
 */
@SpringBootApplication
@MapperScan(value = "com.fc.test.mapper")
public class SpringbootSwagger2Application {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootSwagger2Application.class, args);
        System.out.println("=================================");
        System.out.println("=============启动成功===============");
        System.out.println("=================================");
    }
}
