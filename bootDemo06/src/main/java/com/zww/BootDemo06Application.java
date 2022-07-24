package com.zww;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.zww.dao")    // 用来找到对应的dao接口，和对应的xml文件
public class BootDemo06Application {
    public static void main(String[] args) {
        SpringApplication.run(BootDemo06Application.class, args);
    }

}
