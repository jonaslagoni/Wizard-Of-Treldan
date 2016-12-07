/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT_A1;

import TWoT_A1.EquippableItem.EItem;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lagoni
 */
public class Player implements Serializable{
    private String playerName;
    private double attValue;
    private double defValue;
    private int health;
    private int gold = 0;
    private int highscore = 0;
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
    public void addItemToEquippableInventory(EquippableItem i, Player p){
        playersInventory.addEquipItem(i, p);
    }
    public void equipItem(EquippableItem i, Player p){
        playersInventory.equipItem(i, p);
    }
    public void removeItemToEquippableInventory(EquippableItem i){
        playersInventory.removeEquipItem(i);
        this.removeAtt(i.getAttackBuff());
        this.removeDef(i.getDefenseBuff());
    }
    
    public List<Item> getInventoryItems(){
        return playersInventory.getInventoryItems();
    }
    
    public HashMap<EquippableItem.EItem, EquippableItem> getEquippableItems(){
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
        this.health += healthToRegen;
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
     * 
     * @param playerName 
     */
    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }

    /**
     * @return the highscore
     */
    public int getHighscore() {
        int value = 0;
        for(Item i: playersInventory.getInventoryItems()){
            value = value + i.getItemValue();
        }
        
        for(Map.Entry<EItem, EquippableItem> i : playersInventory.getEquippableItem().entrySet()){
            value = value + i.getValue().getItemValue();
        }
        
        return gold + value + highscore;
    }

    /**
     * @param highscore the highscore to set
     */
    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }
    
    public void addHighscore(int h){
        this.highscore = this.highscore + h;
    }
    
    public void removeHighscore(int h){
        this.highscore = this.highscore - h;
    }
    
    public void removeInventoryItem(Item i){
        playersInventory.removeInventoryItem(i);
    }
}
