package com.eastfair.bztapi.controller;

import com.eastfair.bztapi.entity.AppPushInfoEntity;
import com.eastfair.bztapi.model.JsonFlag;
import com.eastfair.bztapi.service.IAppPushInfoService;
import com.siyuyou.customstarter.siyuyouspringbootstarterautoconfigurer.HelloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@Api(tags = "自定义starter测试")
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    HelloService helloService;

    @Autowired
    private IAppPushInfoService appPushInfoService;

    @ApiOperation("返回配置siyuyou.hello 的相关信息")
    @GetMapping("/ttt")
    @Cacheable("hello")
    public JsonFlag<String> getById(@RequestParam("pkid") String pkid){
        String s = helloService.sayHello();
        return new JsonFlag<String>(s);
    }
}
