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
public class QuestItem extends Item implements Serializable {

    public QuestItem(String itemName, int itemValue, String itemDescription, int questItemId, String interiorDescription) {
        super.setItemName(itemName);
        super.setItemValue(itemValue);
        super.setItemDescription(itemDescription);
        super.setRoomDescription(interiorDescription);
        super.setItemId(questItemId);
    }
}
