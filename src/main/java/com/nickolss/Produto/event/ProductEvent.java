package com.nickolss.Produto.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component 
public class ProductEvent {
    public final RabbitTemplate rabbitTemplate;

    public ProductEvent(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String message) {
        rabbitTemplate.convertAndSend("fatec-queue", message);
    }
}
