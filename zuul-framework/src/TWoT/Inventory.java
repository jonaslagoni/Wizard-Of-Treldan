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
    private List<Item> Equip = new ArrayList();
    private List<Item> Inventory = new ArrayList();

    /**
     * @return the EquippableItem
     */
    public List<Item> getEquippableItem() {
        return Equip;
    }

    /**
     * @return the UseableItem
     */
    public List<Item> getInventoryItems() {
        return Inventory;
    }
    
    public void addInventoryItem(Item i){
        Inventory.add(i);
    }
    
    public void addEquipItem(EquippableItem i){
        Equip.add(i);
    }
}
