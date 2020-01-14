package com.eastfair.bztapi.controller;

import com.eastfair.bztapi.service.IRabbitProducerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = {"消息队列"})
@Controller
@RequestMapping("rabbit")
public class RabbitController {

    @Autowired
    private IRabbitProducerService rabbitProducerService;

    @ApiOperation(value = "发布订阅")
    @GetMapping("/fanout")
    public void fanout() {
        for (int i = 0; i < 5; i++) {
            this.rabbitProducerService.producerFanout("发布订阅模式下的第" + i + "条信息");
        }
    }

    @ApiOperation(value = "路由模式")
    @GetMapping("/direct")
    public void direct() {
        for (int i = 0; i < 5; i++) {
            this.rabbitProducerService.producerDirect("路由模式下的第" + i + "条信息");
        }
    }

}
