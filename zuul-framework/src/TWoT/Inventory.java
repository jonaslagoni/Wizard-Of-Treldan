/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT;

import java.util.ArrayList;

/**
 *
 * @author Kasper
 */
public class Inventory {
    private ArrayList Equip = new ArrayList();
    private ArrayList Inventory = new ArrayList();

    public Inventory(ArrayList Equip, ArrayList Inventory) {
        this.Equip = Equip;
        this.Inventory = Inventory;
    }

    /**
     * @return the EquippableItem
     */
    public ArrayList getEquippableItem() {
        return Equip;
    }

    /**
     * @return the UseableItem
     */
    public ArrayList getUseableItem() {
        return Inventory;
    }
    
    public void addInventoryItem(Item i){
        Inventory.add(i);
    }
    
   /* public void addEquipItem(Inventory i){
        Equip.add(i);
    }*/
}
