package com.accenture.questionbank.model.store;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class StoreAvailability {
    private String storeNo;
    private String productId;
    private String date;
    private double availQty;
}
