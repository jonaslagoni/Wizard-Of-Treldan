/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT;

/**
 *
 * @author Lagoni
 */
public class UseableItem extends Item{
    
    private int healthRegen;
    
    
    /**
     * 
     * @param itemName
     * @param itemValue
     * @param itemDescription 
     */
    public UseableItem(String itemName, int itemValue, String itemDescription){
        super.setItemName(itemName);
        super.setItemValue(itemValue);
        super.setItemDescription(itemDescription);
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
