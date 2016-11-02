/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT;

import java.util.List;

/**
 *
 * @author Lagoni
 */
public class Player{
    private String playerName;
    private double attValue;
    private double defValue;
    private int health;
    private int gold = 0;
    private Inventory playersInventory;
    
    /**
     * 
     */
    public Player(){
        
    }
    
    /**
     * 
     * @param playerName
     * @param attValue
     * @param defValue
     * @param health
     * @param playersInventory 
     */
    public Player(String playerName, double attValue, double defValue, int health, Inventory playersInventory){
        this.playerName = playerName;
        this.attValue = attValue;
        this.defValue = defValue;
        this.health = health;
        this.playersInventory = playersInventory;
    }
    
    public Player(String playerName, double attValue, double defValue, int health){
        this.playerName = playerName;
        this.attValue = attValue;
        this.defValue = defValue;
        this.health = health;
    }
    
    public void addItemToInventory(Item i){
        playersInventory.addInventoryItem(i);
    }
    
    public void addItemToEquippableInventory(EquippableItem i){
        playersInventory.addEquipItem(i);
    }
    
    public List<Item> getInventoryItems(){
        return playersInventory.getInventoryItems();
    }
    
    public List<EquippableItem> getEquippableItems(){
        return playersInventory.getEquippableItem();
    }
            
    /**
     * @return the monsterName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @return the attValue
     */
    public double getAttValue() {
        return attValue;
    }

    /**
     * @param attValue the attValue to set
     */
    public void setAttValue(double attValue) {
        this.attValue = attValue;
    }

    /**
     * @return the defValue
     */
    public double getDefValue() {
        return defValue;
    }

    /**
     * @param defValue the defValue to set
     */
    public void setDefValue(double defValue) {
        this.defValue = defValue;
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }
    
    public void regenHealth(int healthToRegen){
        this.health = health + healthToRegen;
    }

    /**
     * @param damage the damage to take
     */
    public void setDamage(int damage) {
        health -= damage;
    }

    /**
     * @return the gold
     */
    public int getGold() {
        return gold;
    }

    /**
     * @param gold the gold to set
     */
    public void setGold(int gold) {
        this.gold = gold;
    }
    
    /**
     * 
     * @param att 
     */
    public void addAtt(double att) {
        this.attValue += att;
    }
    
    /**
     * 
     * @param att 
     */
    public void removeAtt(double att) {
        this.attValue -= att;
    }

    
    /**
     * 
     * @param def 
     */
    public void addDef(double def) {
        this.defValue += def;
    }
    
    /**
     * 
     * @param def 
     */
    public void removeDef(double def) {
        this.defValue -= def;
    }
    
    
    /**
     * 
     * @param gold 
     */
    public void addGold(int gold) {
        this.gold += gold;
    }
    
    /**
     * Returns the total item value of player's WHOLE inventory as an integer.
     * @return 
     */
    public int getTotalItemValue(){
        int totalItemValue = 0;
        int totalEquipValue= 0;
        
        //Making a new list equal to the list of items the player has in inventory.
        List<Item> Inventory = playersInventory.getInventoryItems();
        List<EquippableItem> Equip = playersInventory.getEquippableItem();
        
        //Traverses through every item in inventory and counts each item's values
        for(Item item: Inventory){
            int iValue = item.getItemValue();
            totalItemValue = totalItemValue + iValue;
        }
        for(EquippableItem equip: Equip){
            int eValue = equip.getItemValue();
            totalEquipValue = totalEquipValue + eValue;
        }
        //Returns the total item value as integer.
        return totalEquipValue + totalItemValue;
        
    }
    
    /**
     * 
     * @return 
     */
    @Override
    protected Object clone(){
        try {
            return super.clone();
        }catch (CloneNotSupportedException e) {
            // This should never happen
            throw new InternalError(e.toString());
        }
    }
    
    /**
     * 
     * @param playerName 
     */
    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }
}
