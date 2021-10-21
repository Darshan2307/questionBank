package com.accenture.questionbank.model.Order;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderList {
    private String orderNo;
    private String date;
    private double quantity;
}
