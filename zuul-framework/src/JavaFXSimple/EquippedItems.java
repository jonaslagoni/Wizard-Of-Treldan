/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFXSimple;

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
 
        public EquippedItems(String iNames, String iSlots, double attackValue, double defenceValue) {
            this.itemNames = new SimpleStringProperty(iNames);
            this.itemSlots = new SimpleStringProperty(iSlots);
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
 
        public void setItemAttack(double iAttV) {
            itemAttack.set(iAttV);
        }
        
        public double getItemDefence() {
            return itemAttack.get();
        }
 
        public void setItemDefence(double iDefV) {
            itemDefence.set(iDefV);
        }
    
}
