package com.accenture.questionbank.model.store;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StoreCapacity {
    private String storeNo;
    private String productId;
    private String date;
    private double noOfOrdersAccepted;

}
