/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFXSimple_A2;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Kasper
 */
public class InventoryItems {
 
        private final SimpleStringProperty itemName;
        private final SimpleStringProperty itemType;
        private final SimpleStringProperty itemDesc;
 
        public InventoryItems(String iName, String iType, String iDesc) {
            this.itemName = new SimpleStringProperty(iName);
            this.itemType = new SimpleStringProperty(iType);
            this.itemDesc = new SimpleStringProperty(iDesc);
        }
 
        public String getItemName() {
            return itemName.get();
        }
 
        public void setItemName(String iName) {
            itemName.set(iName);
        }
 
        public String getItemType() {
            return itemType.get();
        }
 
        public void setItemType(String iType) {
            itemType.set(iType);
        }
 
        public String getItemDesc() {
            return itemDesc.get();
        }
 
        public void setItemDesc(String iDesc) {
            itemDesc.set(iDesc);
        }
    }
