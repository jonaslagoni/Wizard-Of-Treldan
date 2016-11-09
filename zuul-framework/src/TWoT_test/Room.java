
package TWoT_test;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Room{
    private String description;
    private String name;
    private HashMap<String, Interior> mapInterior = new HashMap();
    private int roomId;
    public Room (String name, String description, int roomId){
        this.description = description;
        this.name = name;
        this.roomId = roomId;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * Adds a key and value to HashMap
     * @param key
     * @param value 
     */
    public void addMapInterior(String key, Interior value){
       mapInterior.put(key, value);
       
    }
    /**
     * Returns a string of the keys from HashMap
     * @return 
     */
    public String getMapInterior(){
        Set<String> rs = mapInterior.keySet();
        String returnString = "";
        String interact = "\nYou can interact with: ";
        for (String s: rs){
            returnString += s + " ";
        }
        return interact + returnString;
       
    }
    /**
     * Returns the value to the key
     * @param key
     * @return 
     */
    public Interior getMapInterior(String key){
        return mapInterior.get(key);
    }
    
    /**
     * 
     * @return 
     */
    public String getFullDescription(){
        String returnString = "";
        for(Map.Entry<String, Interior> entry : mapInterior.entrySet()){
            if(entry.getValue() instanceof Item){
                returnString += "| Direction: " + entry.getKey() + ", Item: " + ((Item)entry.getValue()).getItemName() + "|";
            }else if(entry.getValue() instanceof Exit){
                returnString += "| Direction: " + entry.getKey() + ", Exit: " + ((Exit)entry.getValue()).getNewRoom().getName()+ "|";
            }else if(entry.getValue() instanceof Npc){
                returnString += "| Direction: " + entry.getKey() + ", Npc: " + ((Npc)entry.getValue()).getName()+ "|";
            }else if(entry.getValue() instanceof Monster){
                returnString += "| Direction: " + entry.getKey() + ", Monster: " + ((Monster)entry.getValue()).getMonsterName()+ "|";
            }
        }
        return returnString;
    }
    
    public void removeInterior(String s){
        mapInterior.remove(s);
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the roomId
     */
    public int getRoomId() {
        return roomId;
    }
}

