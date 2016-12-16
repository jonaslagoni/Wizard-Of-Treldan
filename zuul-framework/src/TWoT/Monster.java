/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kasper
 */
public class Monster extends Interior implements Serializable {

    private String monsterName;
    private double attValue;
    private double defValue;
    private int health;
    private int goldDrop;
    private List<Item> itemDrop = new ArrayList();
    private String roomDescription;
    private int mobId;

    /**
     * empty monster
     */
    public Monster() {

    }

    /**
     *
     * @param monsterName monster name
     * @param attValue start attack value
     * @param defValue start def value
     * @param health start health
     * @param goldDrop start gold drop
     * @param roomDescription start room description
     */
    public Monster(String monsterName, double attValue, double defValue, int health, int goldDrop, String roomDescription) {
        this.monsterName = monsterName;
        this.attValue = attValue;
        this.defValue = defValue;
        this.health = health;
        this.goldDrop = goldDrop;
        this.roomDescription = roomDescription;
    }

    /**
     * Adds a Item to the drop list.
     *
     * @param i Item
     */
    public void addDropItem(Item i) {
        itemDrop.add(i);
    }

    /**
     * @return the monsterName
     */
    public String getMonsterName() {
        return monsterName;
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
     * @param damage the damage to take
     */
    public void setDamage(int damage) {
        health -= damage;
    }

    /**
     * @return the goldDrop
     */
    public int getGoldDrop() {
        return goldDrop;
    }

    /**
     * @param goldDrop the goldDrop to set
     */
    public void setGoldDrop(int goldDrop) {
        this.goldDrop = goldDrop;
    }

    /**
     * @return the itemDrop
     */
    public List<Item> getItemDrop() {
        return itemDrop;
    }

    /**
     * @return the roomDescription
     */
    public String getRoomDescription() {
        return roomDescription;
    }

    /**
     * @param roomDescription the roomDescription to set
     */
    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    /**
     * @return the mobId
     */
    public int getMobId() {
        return mobId;
    }

    /**
     * @param mobId the mobId to set
     */
    public void setMobId(int mobId) {
        this.mobId = mobId;
    }
}
