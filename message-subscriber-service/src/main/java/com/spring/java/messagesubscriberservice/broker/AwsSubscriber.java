package com.spring.java.messagesubscriberservice.broker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class AwsSubscriber {

    private static final Logger log = LoggerFactory.getLogger(AwsSubscriber.class);
    @Autowired
    AmqpTemplate rabbitTemplate;

    @RabbitListener(queues = "MessageInterceptorQueue")
    public  void receiveMessage(@Payload String message) {

            log.info("RabbitMQ Subscriber receiving messages:"+message);

    }

}
