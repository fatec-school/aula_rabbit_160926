package com.nickolss.Produto.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.nickolss.Produto.controller.dto.SellResponse;

@Component 
public class ProductEvent {
    public final RabbitTemplate rabbitTemplate;

    public ProductEvent(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(SellResponse message) {
        rabbitTemplate.convertAndSend("fatec-queue", message);
    }
}
