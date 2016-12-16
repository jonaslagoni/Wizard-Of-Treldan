/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleWithCommands;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Kasper
 */
public class InventoryItems {

    private final SimpleStringProperty itemName;
    private final SimpleStringProperty itemType;
    private final SimpleStringProperty itemDesc;

    /**
     *
     * @param iName String
     * @param iType String
     * @param iDesc String
     */
    public InventoryItems(String iName, String iType, String iDesc) {
        this.itemName = new SimpleStringProperty(iName);
        this.itemType = new SimpleStringProperty(iType);
        this.itemDesc = new SimpleStringProperty(iDesc);
    }

    /**
     * @return String
     */
    public String getItemName() {
        return itemName.get();
    }

    /**
     * Sets the Item name property
     *
     * @param iName String
     */
    public void setItemName(String iName) {
        itemName.set(iName);
    }

    /**
     * @return String Item type
     */
    public String getItemType() {
        return itemType.get();
    }

    /**
     * Sets the Item name property
     *
     * @param iType String
     */
    public void setItemType(String iType) {
        itemType.set(iType);
    }

    /**
     * @return String Item description
     */
    public String getItemDesc() {
        return itemDesc.get();
    }

    /**
     * sets the Item description
     *
     * @param iDesc String
     */
    public void setItemDesc(String iDesc) {
        itemDesc.set(iDesc);
    }
}
