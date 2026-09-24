package com.nickolss.Produto.event;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.nickolss.Produto.event.dto.SellListenerResponse;

@Component 
public class SellListener {
    @RabbitListener(queues = "fatec-queue")
    public void receiveMessage(@Payload SellListenerResponse listener) {
        System.out.println("MENSAGEM RECEBIDA: " + listener.message());
    }
}
