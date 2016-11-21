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
        private final SimpleDoubleProperty itemStats;
 
        public EquippedItems(String iNames, String iSlots, double itemStats) {
            this.itemNames = new SimpleStringProperty(iNames);
            this.itemSlots = new SimpleStringProperty(iSlots);
            this.itemStats = new SimpleDoubleProperty(itemStats);
        }
 
        public String getItemName() {
            return itemNames.get();
        }
 
        public void setItemName(String iName) {
            itemNames.set(iName);
        }
 
        public String getItemType() {
            return itemSlots.get();
        }
 
        public void setItemType(String iType) {
            itemSlots.set(iType);
        }
 
        public double getItemStats() {
            return itemStats.get();
        }
 
        public void setItemStats(double iAttV, double iDefV) {
            itemStats.set(iAttV + iDefV);
        }
    
}
