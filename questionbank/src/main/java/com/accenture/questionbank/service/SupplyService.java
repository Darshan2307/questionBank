package com.accenture.questionbank.service;

import com.accenture.questionbank.model.supply.Supply;
import com.accenture.questionbank.model.supply.SupplyResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplyService {

    private static List<Supply> supplies = new ArrayList<>();

    /***
     * sets supply data
     */
    public void initializeSupply(){
        supplies.add(new Supply("Product1","2021-03-16T08:53:48.616Z",10));
        supplies.add(new Supply("Product2","2021-03-16T08:59:48.616Z",5));
        supplies.add(new Supply("Product3","2021-03-16T09:10:48.616Z",30));
        supplies.add(new Supply("Product4","2021-03-16T09:10:48.616Z",20));
    }

    public SupplyResponse updateStatus(Supply supply){
        List<Supply> supplyList = supplies.stream().filter(i->i.getProductId().equals(supply.getProductId()))
                .collect(Collectors.toList());
        double sum = 0;
        SupplyResponse supplyResponse=null;
        if(supplyList!=null){
            sum = supplyList.stream().filter(i->i.getUpdateTimeStamp().compareTo(supply.getUpdateTimeStamp())<0)
                    .mapToDouble(i->i.getQuantity()).sum();
            if(sum > 0){
                sum = sum + supply.getQuantity();
                supplyResponse = new SupplyResponse(supply.getProductId(),supply.getUpdateTimeStamp(),sum,"Updated");
            }
            else{
                supplyResponse = new SupplyResponse(supply.getProductId(),supply.getUpdateTimeStamp(),supply.getQuantity(),"Out of sync update");
            }
        }
        return supplyResponse;

    }

}
