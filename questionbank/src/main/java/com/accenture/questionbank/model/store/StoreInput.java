package com.accenture.questionbank.model.store;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StoreInput {
    private String storeNo;
    private String productId;
    private String reqDate;
    private double reqQty;
}
