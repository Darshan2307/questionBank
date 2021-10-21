package com.accenture.questionbank.controller;

import com.accenture.questionbank.model.store.StoreAvailability;
import com.accenture.questionbank.model.store.StoreCapacity;
import com.accenture.questionbank.model.store.StoreInput;
import com.accenture.questionbank.model.store.StoreResponse;
import com.accenture.questionbank.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping("/getProdAvailability")
    public ResponseEntity<StoreResponse> getProductAvailability(@RequestBody StoreInput storeInput){
        storeService.setStoreAvailability();
        storeService.setStoreCapacity();
        CompletableFuture<StoreAvailability> storeAvailabilityCompletableFuture = storeService.getAvailabilty(storeInput.getStoreNo());
        CompletableFuture<StoreCapacity> storeCapacityCompletableFuture = storeService.getCapacity(storeInput.getStoreNo());
        CompletableFuture.allOf(storeAvailabilityCompletableFuture,storeCapacityCompletableFuture).join();
        String status = storeService.getStatus(storeInput.getReqDate());
        if(status.equals("No Capacity") || status.equals("No Availability") || status.equals("Available")){
            StoreResponse storeResponse = new StoreResponse(storeInput,status);
            return new ResponseEntity<StoreResponse>(storeResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
