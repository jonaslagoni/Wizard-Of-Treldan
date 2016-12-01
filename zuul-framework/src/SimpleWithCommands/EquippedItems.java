/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleWithCommands;

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
 
        public EquippedItems(String iName, String iSlot, double attackValue, double defenceValue) {
            this.itemNames = new SimpleStringProperty(iName);
            this.itemSlots = new SimpleStringProperty(iSlot);
            this.itemAttack = new SimpleDoubleProperty(attackValue);
            this.itemDefence = new SimpleDoubleProperty(defenceValue);
        }
 
        public String getItemNames() {
            return itemNames.get();
        }
 
        public void setItemNames(String iName) {
            itemNames.set(iName);
        }
 
        public String getItemSlots() {
            return itemSlots.get();
        }
 
        public void setItemSlots(String iType) {
            itemSlots.set(iType);
        }
 
        public double getItemAttack() {
            return itemAttack.get();
        }
 
        public void setItemAttack(double attackValue) {
            itemAttack.set(attackValue);
        }
        
        public double getItemDefence() {
            return itemDefence.get();
        }
 
        public void setItemDefence(double defenceValue) {
            itemDefence.set(defenceValue);
        }
    
}
