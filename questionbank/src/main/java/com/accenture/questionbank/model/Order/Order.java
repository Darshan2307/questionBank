package com.accenture.questionbank.model.Order;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private String orderId;
    private String productId;
    private String date;
    private double quantity;
}
