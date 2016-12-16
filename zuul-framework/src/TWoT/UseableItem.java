/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT;

import java.io.Serializable;

/**
 *
 * @author Lagoni
 */
public class UseableItem extends Item implements Serializable {

    private int healthRegen;

    /**
     *
     * @param itemName The name of the item
     * @param itemValue The value for the item
     * @param itemDescription The item description
     * @param roomDescription The item description for when you interact with
     * this item
     * @param itemId The item id
     * @param healthRegen The health regen for this item
     */
    public UseableItem(String itemName, int itemValue, String itemDescription, String roomDescription, int itemId, int healthRegen) {
        super.setItemName(itemName);
        super.setItemValue(itemValue);
        super.setItemDescription(itemDescription);
        super.setRoomDescription(roomDescription);
        super.setItemId(itemId);
        this.healthRegen = healthRegen;
    }

    /**
     * @return the healthRegen
     */
    public int getHealthRegen() {
        return healthRegen;
    }

    /**
     * @param healthRegen the healthRegen to set
     */
    public void setHealthRegen(int healthRegen) {
        this.healthRegen = healthRegen;
    }
}
