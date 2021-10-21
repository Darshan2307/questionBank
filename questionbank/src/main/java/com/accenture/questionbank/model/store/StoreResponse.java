package com.accenture.questionbank.model.store;

import com.accenture.questionbank.model.store.StoreInput;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StoreResponse {
    private StoreInput storeInput;
    private String status;
}
