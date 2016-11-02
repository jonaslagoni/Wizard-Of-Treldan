/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT_test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kasper
 */
public class Inventory {
    private List<EquippableItem> equippedInventory = new ArrayList();
    private List<Item> itemInventory = new ArrayList();

    /**
     * @return the EquippableItem
     */
    public List<EquippableItem> getEquippableItem() {
        return equippedInventory;
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
    
    public void removeInventoryItem(Item i){
        itemInventory.remove(i);
    }
    
    /**
     * 
     * @param i 
     */
    public void addEquipItem(EquippableItem i){
        equippedInventory.add(i);
        
    }
    
    public void removeEquipItem(EquippableItem i){
        equippedInventory.remove(i);
        
    }
}
