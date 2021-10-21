package com.accenture.questionbank.service;

import com.accenture.questionbank.model.store.StoreAvailability;
import com.accenture.questionbank.model.store.StoreCapacity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class StoreService {

    private static List<StoreAvailability> storeAvailabilityList = new ArrayList<>();
    private static List<StoreCapacity> storeCapacityList = new ArrayList<>();

    public void setStoreAvailability() {
        storeAvailabilityList.add(new StoreAvailability("Store001", "Prod1", "2021-02-19", 0));
        storeAvailabilityList.add(new StoreAvailability("Store001", "Prod2", "2021-02-20", 3.0));
        storeAvailabilityList.add(new StoreAvailability("Store001", "Prod2", "2021-02-21",0));
    }

    public void setStoreCapacity() {
        storeCapacityList.add(new StoreCapacity("Store001", "Prod1", "2021-02-19", 0));
        storeCapacityList.add(new StoreCapacity("Store001", "Prod1", "2021-02-20", 2.0));
        storeCapacityList.add(new StoreCapacity("Store001", "Prod1", "2021-02-21", 2.0));
        storeCapacityList.add(new StoreCapacity("Store001", "Prod1", "2021-02-22", 0));
    }

    @Async
    public CompletableFuture<StoreAvailability> getAvailabilty(String storeNo) {
        Optional<StoreAvailability> storeAvailability = storeAvailabilityList.stream()
                .filter(i->i.getStoreNo().equals(storeNo))
                .findFirst();
        return CompletableFuture.completedFuture(storeAvailability.get());
    }

    public CompletableFuture<StoreCapacity> getCapacity(String storeNo) {
        Optional<StoreCapacity> storeCapacity = storeCapacityList.stream()
                .filter(i->i.getStoreNo().equals(storeNo)).findFirst();
        return CompletableFuture.completedFuture(storeCapacity.get());

    }

    public String getStatus(String reqDate) {
        double availability = 0;
        availability = storeAvailabilityList.stream().filter(i->i.getDate().equals(reqDate))
                .mapToDouble(i->i.getAvailQty()).sum();

        double capacity = 0;
        capacity = storeCapacityList.stream().filter(i->i.getDate().equals(reqDate))
                .mapToDouble(i->i.getNoOfOrdersAccepted()).sum();

        if(availability == 0 && capacity == 0){
            return "No Content";
        }
        else if(capacity == 0){
            return "No Capacity";
        }
        else if(availability == 0){
            return "No Availability";
        }
        else{
            return "Available";
        }
    }
}
