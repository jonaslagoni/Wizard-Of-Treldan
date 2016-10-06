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
public class Item {
    
    // creating variables for Items
    private String ITEMNAME;
    private int VALUE;
    private String DESCRIPTION;
    
    // creating the Constructor
    public Item(String ITEMNAME, int VALUE, String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
        this.ITEMNAME = ITEMNAME;
        this.VALUE = VALUE;
        
    }

    /**
     * @return the ITEMNAME
     */
    public String getITEMNAME() {
        return ITEMNAME;
    }

    /**
     * @return the VALUE
     */
    public int getVALUE() {
        return VALUE;
    }

    /**
     * @return the DESCRIPTION
     */
    public String getDESCRIPTION() {
        return DESCRIPTION;
    }
}
