package com.eastfair.bztapi.service.impl;

import com.eastfair.bztapi.service.IRabbitProducerService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitProducerServiceIml implements IRabbitProducerService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public void producerFanout(String message) {
        rabbitTemplate.convertAndSend("fanoutExchange", null, message);
    }

    @Override
    public void producerDirect(String message) {
        rabbitTemplate.convertAndSend("directExchange", "directRoutingkey", message);
    }

}
