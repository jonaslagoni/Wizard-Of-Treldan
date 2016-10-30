/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT_test;


/**
 *
 * @author Lagoni
 */
public class QuestItem extends Item {
    private int questItemId;
    public QuestItem(String itemName, int itemValue, String itemDescription, int questItemId){
        super.setItemName(itemName);
        super.setItemValue(itemValue);
        super.setItemDescription(itemDescription);
        this.questItemId = questItemId;
    }

    /**
     * @return the questItemId
     */
    public int getQuestItemId() {
        return questItemId;
    }
}
