package com.eastfair.bztapi.controller;

import com.siyuyou.customstarter.siyuyouspringbootstarterautoconfigurer.HelloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "自定义starter测试")
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    HelloService helloService;

    @ApiOperation("返回配置siyuyou.hello 的相关信息")
    @GetMapping("/ttt")
    public String hello(){
        String s = helloService.sayHello();
        return s;
    }
}
