package com.accenture.questionbank.controller;

import com.accenture.questionbank.model.inventory.Inventory;
import com.accenture.questionbank.model.inventory.InventoryInput;
import com.accenture.questionbank.model.inventory.InventoryOutput;
import com.accenture.questionbank.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

/***
 *
 */
@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    private static List<Inventory> inventoryList;

    /***
     * sets and displays inventory
     * @return list of inventory items
     * @throws ParseException
     */
    @GetMapping("/getInventory")
    public List<Inventory> getInventory() throws ParseException {
        inventoryService.setInventory();
        List<Inventory> inventoryList = inventoryService.getAllInventory();
        return inventoryList;
    }

    /***
     * sets inventory and finds quantity,
     * if quantity is 0 then returns bad request
     * else returns InventoryOutput object
     * @param inventoryInput the inventoryInput contains attributes such as
     *                       productId, productName, availDate
     * @return Object of InventoryOutput which contains productId, productName, availQty
     * @throws ParseException
     */
    @PostMapping("/getInvPicture")
    public ResponseEntity<InventoryOutput> quantityAvailable(@RequestBody InventoryInput inventoryInput) throws ParseException {
        inventoryService.setInventory();
        double quantity= inventoryService.getInventory(inventoryInput);
        if(quantity != 0){
            InventoryOutput inventoryOutput = new InventoryOutput(inventoryInput.getProductId(),inventoryInput.getProductName(),quantity);
            return new ResponseEntity<InventoryOutput>(inventoryOutput,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<InventoryOutput>(HttpStatus.BAD_REQUEST);
        }
    }
}
