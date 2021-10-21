package com.accenture.questionbank.model.supply;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SupplyResponse {
    private String productId;
    private String updateTimeStamp;
    private double quantity;
    private String status;
}
