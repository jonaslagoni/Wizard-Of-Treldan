/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Kasper
 */
public class Inventory implements Serializable {

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
     * Add item to the inventory
     *
     * @param i Item
     */
    public void addInventoryItem(Item i) {
        itemInventory.add(i);
    }

    /**
     * Remove Item from the inventory
     *
     * @param i Item
     */
    public void removeInventoryItem(Item i) {
        itemInventory.remove(i);
    }

    /**
     * adds an EquippableItem to the equiped inventory and makes sure the attack
     * and def values stay instact.
     *
     * @param i EquippableItem
     * @param p Player
     */
    public void addEquipItem(EquippableItem i, Player p) {
        if (equippedInventory.containsKey(i.geteItem())) {
            EquippableItem currentEItem = equippedInventory.get(i.geteItem());
            if (currentEItem.geteItem() == EquippableItem.EItem.WEAPON_SLOT && i.geteItem() == EquippableItem.EItem.WEAPON_SLOT) {
                if (currentEItem.getAttackBuff() < i.getAttackBuff()) {
                    addInventoryItem(currentEItem);
                    equippedInventory.remove(i.geteItem());
                    equippedInventory.put(i.geteItem(), i);
                    p.removeAtt(currentEItem.getAttackBuff());
                    p.addAtt(i.getAttackBuff());
                } else {
                    addInventoryItem(i);
                }
            } else if (currentEItem.getDefenseBuff() < i.getDefenseBuff()) {
                addInventoryItem(currentEItem);
                equippedInventory.remove(i.geteItem());
                equippedInventory.put(i.geteItem(), i);
                p.removeDef(currentEItem.getDefenseBuff());
                p.addDef(i.getDefenseBuff());
            } else {
                addInventoryItem(i);
            }
        } else {
            if (i.geteItem() == EquippableItem.EItem.WEAPON_SLOT) {
                p.addAtt(i.getAttackBuff());
            } else {
                p.addDef(i.getDefenseBuff());
            }
            equippedInventory.put(i.geteItem(), i);
            itemInventory.remove(i);
        }
    }

    /**
     * removes EquippableItem from the equippedInventory
     *
     * @param i EquippableItem
     */
    public void removeEquipItem(EquippableItem i) {
        equippedInventory.remove(i);
    }
}
