package com.accenture.questionbank.model.inventory;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InventoryInput {
    private String productId;
    private String productName;
    private String availDate;
}
