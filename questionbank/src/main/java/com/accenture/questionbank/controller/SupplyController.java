package com.accenture.questionbank.controller;

import com.accenture.questionbank.model.supply.Supply;
import com.accenture.questionbank.model.supply.SupplyResponse;
import com.accenture.questionbank.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplyController {

    @Autowired
    private SupplyService supplyService;

    @PostMapping("/updateSupply")
    public SupplyResponse updateSupply(@RequestBody Supply supply){
        supplyService.initializeSupply();
        SupplyResponse supplyResponse = supplyService.updateStatus(supply);
        return supplyResponse;
    }
}
