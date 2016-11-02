/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT_test;
import java.util.*;
/**
 *
 * @author Lagoni
 */
public class Npc extends Interior {
    private String name;
    private Item itemToGive, itemToGet;
    private boolean passiv;
    private List<String> conversation = new ArrayList();
    private int npcID;
    /**
     * Constructor.
     * @param name
     * @param dialog
     * @param passiv 
     * @param conversation
     */
    public Npc(String name, boolean passiv, int npcID){
        this.name = name;
        this.passiv = passiv;
        this.npcID = npcID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }



    /**
     * @return the itemToGive
     */
    public Item getItemToGive() {
        return itemToGive;
    }

    /**
     * @param itemToGive the itemToGive to set
     */
    public void setItemToGive(Item itemToGive) {
        this.itemToGive = itemToGive;
    }

    /**
     * @return the itemToGet
     */
    public Item getItemToGet() {
        return itemToGet;
    }

    /**
     * @param itemToGet the itemToGet to set
     */
    public void setItemToGet(Item itemToGet) {
        this.itemToGet = itemToGet;
    }

    /**
     * @return the passiv
     */
    public boolean isPassiv() {
        return passiv;
    }

    /**
     * @param passiv the passiv to set
     */
    public void setPassiv(boolean passiv) {
        this.passiv = passiv;
    }
    
    /**
     * 
     * @return 
     */
    public List<String> getConversation() {
        return conversation;
    }
    
    /**
     * 
     * @param dialog 
     */
    public void addConversation(String dialog) {
        conversation.add(dialog);
    }

    /**
     * @return the npcID
     */
    public int getNpcID() {
        return npcID;
    }

    /**
     * @param npcID the npcID to set
     */
    public void setNpcID(int npcID) {
        this.npcID = npcID;
    }
}
