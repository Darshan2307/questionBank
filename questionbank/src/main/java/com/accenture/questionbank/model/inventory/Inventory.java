package com.accenture.questionbank.model.inventory;

import lombok.AllArgsConstructor;
import lombok.Data;

/***
 *
 */
@Data
@AllArgsConstructor
public class Inventory {

    private String productId;
    private String productName;
    private String UOM;
    private double availQty;
    private String availDate;

}
