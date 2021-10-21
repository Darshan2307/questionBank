package com.accenture.questionbank.model.supply;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Supply {
    private String productId;
    private String updateTimeStamp;
    private double quantity;
}
