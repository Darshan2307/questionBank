package com.accenture.questionbank.service;

import com.accenture.questionbank.model.inventory.Inventory;
import com.accenture.questionbank.model.inventory.InventoryInput;
import java.text.ParseException;
import java.util.List;

/***
 *
 */
public interface InventoryService {

    public void setInventory() throws ParseException;
    public List<Inventory> getAllInventory();
    public double getInventory(InventoryInput inventoryInput) throws ParseException;

}
