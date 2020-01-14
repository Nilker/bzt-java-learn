package com.eastfair.bztapi.service.impl;

import com.eastfair.bztapi.service.IRabbitConsumerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class RabbitConsumerServiceIml implements IRabbitConsumerService {
    @Override
    @RabbitListener(queues = "fanoutQueueA")
    public void consumerFanoutA(String message) {
        System.out.println("消费者收到队列A中的消息:" + message);
    }

    @Override
    @RabbitListener(queues = "fanoutQueueB")
    public void consumerFanoutB(String message) {
        System.out.println("消费者收到队列B中的消息:" + message);
    }

    @Override
    @RabbitListener(queues = "routingQueueC")
    public void consumerDirectC(String message) {
        System.out.println("消费者收到队列C中的消息:" + message);
    }

    @Override
    @RabbitListener(queues = "routingQueueD")
    public void consumerDirectD(String message) {
        System.out.println("消费者收到队列D中的消息:" + message);
    }
}
