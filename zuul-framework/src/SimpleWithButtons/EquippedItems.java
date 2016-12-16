/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleWithButtons;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Mathias
 */
public class EquippedItems {

    private final SimpleStringProperty itemNames;
    private final SimpleStringProperty itemSlots;
    private final SimpleDoubleProperty itemAttack;
    private final SimpleDoubleProperty itemDefence;

    /**
     *
     * @param iName String Item name
     * @param iSlot String Item slot
     * @param attackValue double attack value
     * @param defenceValue double defence value
     */
    public EquippedItems(String iName, String iSlot, double attackValue, double defenceValue) {
        this.itemNames = new SimpleStringProperty(iName);
        this.itemSlots = new SimpleStringProperty(iSlot);
        this.itemAttack = new SimpleDoubleProperty(attackValue);
        this.itemDefence = new SimpleDoubleProperty(defenceValue);
    }

    /**
     *
     * @return Item names
     */
    public String getItemNames() {
        return itemNames.get();
    }

    /**
     * Sets the item name
     *
     * @param iName String
     */
    public void setItemNames(String iName) {
        itemNames.set(iName);
    }

    /**
     * @return Item slot
     */
    public String getItemSlots() {
        return itemSlots.get();
    }

    /**
     * Sets the item slot
     *
     * @param iType String
     */
    public void setItemSlots(String iType) {
        itemSlots.set(iType);
    }

    /**
     * @return attack value of item
     */
    public double getItemAttack() {
        return itemAttack.get();
    }

    /**
     * sets the attack value
     *
     * @param attackValue double
     */
    public void setItemAttack(double attackValue) {
        itemAttack.set(attackValue);
    }

    /**
     * @return defence value of item
     */
    public double getItemDefence() {
        return itemDefence.get();
    }

    /**
     * sets the defence item
     *
     * @param defenceValue double
     */
    public void setItemDefence(double defenceValue) {
        itemDefence.set(defenceValue);
    }
}
