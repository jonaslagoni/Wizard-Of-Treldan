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
public class EquippableItem extends Item implements Serializable {

    private double attackBuff;
    private double defenseBuff;
    private EItem eItem;

    /**
     *
     * @param itemName Name of the item
     * @param itemValue Value of the item
     * @param itemDescription Description of the item
     * @param attackBuff Start attack buff
     * @param defenseBuff Start deff buff
     * @param eItem Type of this item
     * @param roomDescription The description for when picked up
     * @param itemId Id of the item
     */
    public EquippableItem(String itemName, int itemValue, String itemDescription, double attackBuff, double defenseBuff, EItem eItem, String roomDescription, int itemId) {
        super.setItemName(itemName);
        super.setItemValue(itemValue);
        super.setItemDescription(itemDescription);
        super.setRoomDescription(roomDescription);
        this.attackBuff = attackBuff;
        this.defenseBuff = defenseBuff;
        this.eItem = eItem;
        super.setItemId(itemId);
    }

    /**
     * @return the eItem
     */
    public EItem geteItem() {
        return eItem;
    }

    /**
     * @param eItem the eItem to set
     */
    public void seteItem(EItem eItem) {
        this.eItem = eItem;
    }

    /**
     * Item types
     */
    public enum EItem {
        HEAD_SLOT, WEAPON_SLOT, CHEST_SLOT, LEG_SLOT, BOOT_SLOT, GLOVES_SLOT, RING_SLOT, AMULET_SLOT;
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
