/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kasper
 */
public class Inventory {
    private List<EquippableItem> equipedInventory = new ArrayList();
    private List<Item> itemInventory = new ArrayList();

    /**
     * @return the EquippableItem
     */
    public List<EquippableItem> getEquippableItem() {
        return equipedInventory;
    }

    /**
     * @return the UseableItem
     */
    public List<Item> getInventoryItems() {
        return itemInventory;
    }
    
    /**
     * 
     * @param i 
     */
    public void addInventoryItem(Item i){
        itemInventory.add(i);
    }
    
    /**
     * 
     * @param i 
     */
    public void addEquipItem(EquippableItem i){
        equipedInventory.add(i);
    }
}
