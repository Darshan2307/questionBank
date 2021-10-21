package com.accenture.questionbank.service;

import com.accenture.questionbank.model.Order.Order;
import com.accenture.questionbank.model.Order.OrderList;
import com.accenture.questionbank.model.Order.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private static List<Order> orders = new ArrayList<>();

    /***
     * sets orders
     */
    public void initializeOrders() {
        orders.add(new Order("Order1","Product1","2021-03-16",10));
        orders.add(new Order("Order2","Product2","2021-03-19",5));
        orders.add(new Order("Order3","Product1","2021-03-16",30));
        orders.add(new Order("Order4","Product4","2021-03-20",20));
        orders.add(new Order("Order5","Product2","2021-03-16",20));
    }

    public OrderResponse getMaxOrderSales() {
        double sum=0,max=0;
        String product,maxProduct=null;
        for(int i=0;i<orders.size();i++){
            max=0;
            product = orders.get(i).getProductId();
            String finalProduct = product;
            max = orders.stream().filter(p->p.getProductId().equals(finalProduct))
                    .mapToDouble(p->p.getQuantity()).sum();
            if(max>sum){
                sum = max;
                maxProduct = product;
            }
        }
        String finalMaxProduct = maxProduct;
        List<OrderList> orderLists = orders.stream().filter(p->p.getProductId().equals(finalMaxProduct))
                .map(p-> new OrderList(p.getOrderId(),p.getDate(),p.getQuantity()))
                .collect(Collectors.toList());
        OrderResponse orderResponse = new OrderResponse(finalMaxProduct,orderLists);
        return orderResponse;
    }

    public OrderResponse getMinOrderSales() {
        double sum=999,min=0;
        String product,minProduct=null;
        for(int i=0;i<orders.size();i++){
            min=0;
            product = orders.get(i).getProductId();
            String finalProduct = product;
            min = orders.stream().filter(p->p.getProductId().equals(finalProduct))
                    .mapToDouble(p->p.getQuantity()).sum();
            if(min<sum){
                sum = min;
                minProduct = product;
            }
        }
        String finalMinProduct = minProduct;
        List<OrderList> orderLists = orders.stream().filter(p->p.getProductId().equals(finalMinProduct))
                .map(p-> new OrderList(p.getOrderId(),p.getDate(),p.getQuantity()))
                .collect(Collectors.toList());
        OrderResponse orderResponse = new OrderResponse(finalMinProduct,orderLists);
        return orderResponse;
    }
}
