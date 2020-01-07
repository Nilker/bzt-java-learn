package com.eastfair.bztapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


//@MapperScan({"com.eastfair.bztapi.mapper","com.baomidou.mybatisplus.samples.quickstart.mapper"})
@SpringBootApplication
@EnableCaching
public class BztapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BztapiApplication.class, args);
    }

}
