
package TWoT;

import java.util.HashMap;
import java.util.Set;


public class Room{
    private String description;
    private String name;
    private HashMap<String, Interior> mapInterior = new HashMap();
    
    public Room (String description, String name){
        this.description = description;
        this.name = name;
               
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
        String returnString = "Exits: ";
        for (String s: rs){
            returnString += s + " ";
        }
        return returnString;
       
    }
    /**
     * Returns the value to the key
     * @param key
     * @return 
     */
    public Interior getMapInt(String key){
        return mapInterior.get(key);
    }
}

