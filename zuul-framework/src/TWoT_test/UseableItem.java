/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT_test;

/**
 *
 * @author Lagoni
 */
public class UseableItem extends Item{
    
    private int healthRegen;
    private Usables usables;
    
    /**
     * 
     * @param itemName
     * @param itemValue
     * @param itemDescription 
     * @param roomDescription 
     * @param itemId 
     * @param usables 
     */
    public UseableItem(String itemName, int itemValue, String itemDescription, String roomDescription, int itemId, Usables usables ){
        super.setItemName(itemName);
        super.setItemValue(itemValue);
        super.setItemDescription(itemDescription);
        super.setRoomDescription(roomDescription);
        super.setItemId(itemId);
        this.usables= usables;
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
    
    public enum Usables {
        FOOD,MAGIC_ITEM,ITEM_USE,RARE;
    }
    
    public Usables getUsables() {
        return usables;
    }

    public void setUsables(Usables usables) {
        this.usables = usables;
    }
}
