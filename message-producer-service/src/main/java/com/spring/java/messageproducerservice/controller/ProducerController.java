package com.spring.java.messageproducerservice.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProducerController {

    @Autowired
    AmqpTemplate rabbitTemplate;

    @PostMapping("sendMessage")
    public ResponseEntity<String> sendMessageToSubscriber(@RequestBody String message){
        rabbitTemplate.convertAndSend("CustomDirectExchange", "book.order", message);
        return  new ResponseEntity<String>("Message sent to the subscriber.", HttpStatus.OK);
    }
}
