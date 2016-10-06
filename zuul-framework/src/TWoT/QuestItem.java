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
public class QuestItem extends Item {
    
    public QuestItem(String itemName, int itemValue, String itemDescription){
        setItemName(itemName);
        setItemValue(itemValue);
        setItemDescription(itemDescription);
    }
}
