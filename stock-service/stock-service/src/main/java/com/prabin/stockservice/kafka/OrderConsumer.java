package com.prabin.stockservice.kafka;

import com.prabin.basedomains.dto.OrderEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = AppConstant.topic, groupId = AppConstant.groupId)
    public void consume(OrderEvent event){
        LOGGER.info(String.format("Order event received in stock service => %s", event.toString()));

        //save the order event data into database if you want.
    }
}
