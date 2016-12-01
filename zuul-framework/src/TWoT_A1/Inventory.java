/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT_A1;

import SimpleWithCommands.EquippedItems;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Kasper
 */
public class Inventory implements Serializable{
    private HashMap<EquippableItem.EItem, EquippableItem> equippedInventory = new HashMap();
    private List<Item> itemInventory = new ArrayList();

    /**
     * @return the EquippableItem
     */
    public HashMap<EquippableItem.EItem, EquippableItem> getEquippableItem() {
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
    public void addEquipItem(EquippableItem i, Player p){
        if(equippedInventory.containsKey(i.geteItem())){
            EquippableItem currentEItem = equippedInventory.get(i.geteItem());
            if(currentEItem.geteItem() == EquippableItem.EItem.WEAPON_SLOT && i.geteItem() == EquippableItem.EItem.WEAPON_SLOT){
                if(currentEItem.getAttackBuff() < i.getAttackBuff()){
                    addInventoryItem(currentEItem);
                    equippedInventory.remove(i.geteItem());
                    equippedInventory.put(i.geteItem(), i);
                    p.removeAtt(currentEItem.getAttackBuff());
                    p.addAtt(i.getAttackBuff());
                }else{
                    addInventoryItem(i);
                }
            }else{
                if(currentEItem.getDefenseBuff() < i.getDefenseBuff()){
                    addInventoryItem(currentEItem);
                    equippedInventory.remove(i.geteItem());
                    equippedInventory.put(i.geteItem(), i);
                    p.removeDef(currentEItem.getDefenseBuff());
                    p.addDef(i.getDefenseBuff());
                }else{
                    addInventoryItem(i);
                }
            }
        }else{
            if(i.geteItem() == EquippableItem.EItem.WEAPON_SLOT){
                p.addAtt(i.getAttackBuff());
            }else{
                p.addDef(i.getDefenseBuff());
            }
            equippedInventory.put(i.geteItem(), i);
            itemInventory.remove(i);
        }
    }
    public void equipItem(EquippableItem i, Player p){
        if(equippedInventory.containsKey(i.geteItem())){
            EquippableItem currentEItem = equippedInventory.get(i.geteItem());
            if(currentEItem.geteItem() == EquippableItem.EItem.WEAPON_SLOT && i.geteItem() == EquippableItem.EItem.WEAPON_SLOT){
                addInventoryItem(currentEItem);
                equippedInventory.remove(i.geteItem());
                equippedInventory.put(i.geteItem(), i);
                p.removeAtt(currentEItem.getAttackBuff());
                p.addAtt(i.getAttackBuff());
            }else{
                addInventoryItem(currentEItem);
                equippedInventory.remove(i.geteItem());
                equippedInventory.put(i.geteItem(), i);
                p.removeDef(currentEItem.getDefenseBuff());
                p.addDef(i.getDefenseBuff());
            }
            itemInventory.remove(i);
        }else{
            if(i.geteItem() == EquippableItem.EItem.WEAPON_SLOT){
                p.addAtt(i.getAttackBuff());
            }else{
                p.addDef(i.getDefenseBuff());
            }
            equippedInventory.put(i.geteItem(), i);
            itemInventory.remove(i);
        }
    }
    public void removeEquipItem(EquippableItem i){
        equippedInventory.remove(i);
    }
}
