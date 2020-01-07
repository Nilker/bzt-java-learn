package com.eastfair.bztapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@MapperScan({"com.eastfair.bztapi.mapper","com.baomidou.mybatisplus.samples.quickstart.mapper"})
@SpringBootApplication
public class BztapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BztapiApplication.class, args);
    }

}
