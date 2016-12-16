/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT;

import TWoT.EquippableItem.EItem;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lagoni
 */
public class Player implements Serializable {

    private String playerName;
    private double attValue;
    private double defValue;
    private int health;
    private int gold = 0;
    private int highscore = 0;
    private Inventory playersInventory;

    /**
     * Empty player
     */
    public Player() {

    }

    /**
     * A player
     *
     * @param playerName the players name
     * @param attValue start attack value
     * @param defValue start deff value
     * @param health start health
     * @param playersInventory the start inventory
     */
    public Player(String playerName, double attValue, double defValue, int health, Inventory playersInventory) {
        this.playerName = playerName;
        this.attValue = attValue;
        this.defValue = defValue;
        this.health = health;
        this.playersInventory = playersInventory;
    }

    /**
     * A player
     *
     * @param playerName the players name
     * @param attValue start attack value
     * @param defValue start deff value
     * @param health start health
     */
    public Player(String playerName, double attValue, double defValue, int health) {
        this.playerName = playerName;
        this.attValue = attValue;
        this.defValue = defValue;
        this.health = health;
    }

    /**
     * adds an item to the inventory
     *
     * @param i Item
     */
    public void addItemToInventory(Item i) {
        playersInventory.addInventoryItem(i);
    }

    /**
     * Equips an item to a player
     *
     * @param i EquippableItem to be equipped
     * @param p The player to equip item on
     */
    public void addItemToEquippableInventory(EquippableItem i, Player p) {
        playersInventory.addEquipItem(i, p);
    }

    /**
     * Removes an item from inventory and puts in equipped inventory
     *
     * @param i EquippableItem
     */
    public void removeItemToEquippableInventory(EquippableItem i) {
        playersInventory.removeEquipItem(i);
        this.removeAtt(i.getAttackBuff());
        this.removeDef(i.getDefenseBuff());
    }

    /**
     * Returns the list of items in the inventory-
     *
     * @return List of items
     */
    public List<Item> getInventoryItems() {
        return playersInventory.getInventoryItems();
    }

    /**
     * returns the current equipped items
     *
     * @return Hashmap of equiped items
     */
    public HashMap<EquippableItem.EItem, EquippableItem> getEquippableItems() {
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

    /**
     * add health to the current health
     *
     * @param healthToRegen to add to current health
     */
    public void regenHealth(int healthToRegen) {
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
     * adds attack to the current attack value
     *
     * @param att double
     */
    public void addAtt(double att) {
        this.attValue += att;
    }

    /**
     * removes attack value
     *
     * @param att double
     */
    public void removeAtt(double att) {
        this.attValue -= att;
    }

    /**
     * adds deff value to current
     *
     * @param def double
     */
    public void addDef(double def) {
        this.defValue += def;
    }

    /**
     * removes def from current def value
     *
     * @param def double
     */
    public void removeDef(double def) {
        this.defValue -= def;
    }

    /**
     * adds gold to current gold
     *
     * @param gold int
     */
    public void addGold(int gold) {
        this.gold += gold;
    }

    /**
     * Sets the playername for this object
     *
     * @param playerName String
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * @return the highscore
     */
    public int getHighscore() {
        int value = 0;
        for (Item i : playersInventory.getInventoryItems()) {
            value = value + i.getItemValue();
        }

        for (Map.Entry<EItem, EquippableItem> i : playersInventory.getEquippableItem().entrySet()) {
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

    /**
     * Highscore to add to the player
     *
     * @param h int highscore
     */
    public void addHighscore(int h) {
        this.highscore = this.highscore + h;
    }

    /**
     * Removes highscore from current
     *
     * @param h int highscore
     */
    public void removeHighscore(int h) {
        this.highscore = this.highscore - h;
    }

    /**
     * Item to be removed from the players inventory.
     *
     * @param i Item
     */
    public void removeInventoryItem(Item i) {
        playersInventory.removeInventoryItem(i);
    }
}
