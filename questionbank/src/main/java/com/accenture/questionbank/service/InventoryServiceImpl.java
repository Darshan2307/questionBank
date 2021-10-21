package com.accenture.questionbank.service;

import com.accenture.questionbank.model.inventory.Inventory;
import com.accenture.questionbank.model.inventory.InventoryInput;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 *
 */
@Service
public class InventoryServiceImpl implements InventoryService {

    private static List<Inventory> inventoryList = new ArrayList<>();

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

    /***
     * sets inventory items
     * @throws ParseException
     */
    public void setInventory() throws ParseException {
        Date availDate1 = formatter.parse("2021-03-19");
        Date availDate2 = formatter.parse("2021-03-21");
        Date availDate3 = formatter.parse("2021-03-29");
        inventoryList.add(new Inventory("Prod1", "Shirt", "EACH", 10, formatter.format(availDate1)));
        inventoryList.add(new Inventory("Prod1", "Trousers", "EACH", 20, formatter.format(availDate2)));
        inventoryList.add(new Inventory("Prod1", "Trousers", "EACH", 20, formatter.format(availDate3)));

    }

    /***
     * displays the inventory
     * @return list of inventory items
     */
    public List<Inventory> getAllInventory(){
        return inventoryList;
    }

    /***
     * finds quantity which is available between request date + 10 days,
     * also if requested date is out of given range then it will throw error
     * @param inventoryInput  the inventoryInput contains attributes such as
     *                        productId, productName, availDate
     * @return sum of quantity if date is valid
     *          otherwise returns 0
     * @throws ParseException if date is not in valid format which is mentioned
     */
    public double getInventory(InventoryInput inventoryInput) throws ParseException {
        Date inputDate = new SimpleDateFormat("yyyy-mm-dd").parse(inventoryInput.getAvailDate());
        double ans = 0;
        Date beforeDate = formatter.parse("2021-03-19");
        Date afterDate = formatter.parse("2021-03-29");
        if(inputDate.compareTo(beforeDate) >= 0 && inputDate.compareTo(afterDate) <= 0){
            if(inventoryInput.getAvailDate().equals("2021-03-19"))
            {
                ans = inventoryList.stream().mapToDouble(i -> i.getAvailQty()).sum();
            }
            else if(inventoryInput.getAvailDate().equals("2021-03-29")) {
                ans = inventoryList.stream().filter(i -> i.getAvailDate().equals("2021-03-29"))
                        .mapToDouble(i -> i.getAvailQty()).sum();
            }
        }
        return ans;
    }
}
