/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT_A1;

import TWoT_test.*;
import java.io.Serializable;


/**
 *
 * @author Mads
 */
public class Item extends Interior  implements Serializable{
    
    // creating variables for Items
    private String itemName;
    private int itemValue;
    private String itemDescription;
    private String interiorDescription;
    private int itemId;

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the itemValue
     */
    public int getItemValue() {
        return itemValue;
    }

    /**
     * @param itemValue the itemValue to set
     */
    public void setItemValue(int itemValue) {
        this.itemValue = itemValue;
    }

    /**
     * @return the itemDescription
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * @param itemDescription the itemDescription to set
     */
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    /**
     * @return the roomDescription
     */
    public String getRoomDescription() {
        return interiorDescription;
    }

    /**
     * @param roomDescription the roomDescription to set
     */
    public void setRoomDescription(String roomDescription) {
        this.interiorDescription = roomDescription;
    }

    /**
     * @return the itemId
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

}
