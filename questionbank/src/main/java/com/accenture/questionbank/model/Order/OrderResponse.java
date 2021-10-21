package com.accenture.questionbank.model.Order;

import com.accenture.questionbank.model.Order.OrderList;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderResponse {
    private String productId;
    private List<OrderList> orderList;
}
