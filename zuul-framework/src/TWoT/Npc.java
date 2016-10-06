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
public class Npc extends Interior {
    private String name, dialog;
    private Item itemToGive, itemToGet;
    private boolean passiv;
    /**
     * Constructor.
     * @param name
     * @param dialog
     * @param passiv 
     */
    public Npc(String name, String dialog, boolean passiv){
        this.name = name;
        this.dialog = dialog;
        this.passiv = passiv;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the dialog
     */
    public String getDialog() {
        return dialog;
    }

    /**
     * @param dialog the dialog to set
     */
    public void setDialog(String dialog) {
        this.dialog = dialog;
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
}
