/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT_A1;

import java.io.Serializable;

/**
 *
 * @author Lagoni
 */
public class Npc extends Interior  implements Serializable{
    private String name;
    private Item itemToGive, itemToGet;
    private boolean passiv;
    private int npcID;
    /**
     * Constructor.
     * @param name
     * @param dialog
     * @param passiv 
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