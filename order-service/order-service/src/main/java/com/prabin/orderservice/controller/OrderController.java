package com.prabin.orderservice.controller;

import com.prabin.basedomains.dto.Order;
import com.prabin.basedomains.dto.OrderEvent;
import com.prabin.orderservice.service.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    private OrderProducer orderProducer;
    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("Pending");
        orderEvent.setMessage("order status is in pending state.");
        orderEvent.setOrder(order);
        orderProducer.sendMessage(orderEvent);
        return "Order Placed successfully.....";
    }
}
