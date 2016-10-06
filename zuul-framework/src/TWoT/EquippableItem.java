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
public class EquippableItem extends Item {
    
    private double attackBuff;
    private double defenseBuff;
    private ItemType itemType;
    
    public EquippableItem (String itemName, int itemValue, String itemDescription, double attackBuff, double defenseBuff, ItemType itemType){
        setItemName(itemName);
        setItemValue(itemValue);
        setItemDescription(itemDescription);
        this.attackBuff = attackBuff;
        this.defenseBuff = defenseBuff;
        this.itemType = itemType;
    }

    /**
     * @return the attackBuff
     */
    public double getAttackBuff() {
        return attackBuff;
    }

    /**
     * @param attackBuff the attackBuff to set
     */
    public void setAttackBuff(double attackBuff) {
        this.attackBuff = attackBuff;
    }

    /**
     * @return the defenseBuff
     */
    public double getDefenseBuff() {
        return defenseBuff;
    }

    /**
     * @param defenseBuff the defenseBuff to set
     */
    public void setDefenseBuff(double defenseBuff) {
        this.defenseBuff = defenseBuff;
    }

    
}
