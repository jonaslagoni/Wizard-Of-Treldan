/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT;

/**
 *
 * @author Mads
 */
public class Item extends Interior{
    
    // creating variables for Items
    private String itemName;
    private int itemValue;
    private String itemDescription;

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

}
