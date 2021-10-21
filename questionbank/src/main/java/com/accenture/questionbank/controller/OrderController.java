package com.accenture.questionbank.controller;

import com.accenture.questionbank.model.Order.OrderInput;
import com.accenture.questionbank.model.Order.OrderResponse;
import com.accenture.questionbank.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/getOrderStats")
    public OrderResponse getOrderStats(@RequestBody OrderInput orderInput){
        orderService.initializeOrders();
        OrderResponse orderResponse = null;
        if(orderInput.getStatName().equals("MAX_SALE")){
            orderResponse = orderService.getMaxOrderSales();
        }
        else{
            orderResponse = orderService.getMinOrderSales();
        }
        return orderResponse;
    }

}
