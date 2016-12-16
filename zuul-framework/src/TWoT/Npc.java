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
public class Npc extends Interior implements Serializable {

    private String name;
    private Item itemToGive, itemToGet;
    private int npcID;

    /**
     * This is used to representate an NPC
     *
     * @param name the name for this
     * @param npcID The ID for this object
     */
    public Npc(String name, int npcID) {
        this.name = name;
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
