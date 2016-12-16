package TWoT;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

public class Room implements Serializable {

    private String description;
    private String name;
    private HashMap<String, Interior> mapInterior = new HashMap();
    private int roomId;

    /**
     * Creates a room
     *
     * @param name name of the room
     * @param description description of the room
     * @param roomId id for the room
     */
    public Room(String name, String description, int roomId) {
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
     * Adds an interior key and value to HashMap
     *
     * @param key direction
     * @param value Interior
     */
    public void addMapInterior(String key, Interior value) {
        mapInterior.put(key, value);

    }

    /**
     * Returns a string of the keys from HashMap
     *
     * @return String
     */
    public String getMapInterior() {
        Set<String> rs = mapInterior.keySet();
        String returnString = "";
        String interact = "\nYou can interact with: ";
        for (String s : rs) {
            returnString += s + " ";
        }
        return interact + returnString;

    }

    /**
     * Returns the value to the key
     *
     * @param key String
     * @return Interior
     */
    public Interior getMapInterior(String key) {
        return mapInterior.get(key);
    }

    /**
     * removes an interior from the key String
     *
     * @param s String
     */
    public void removeInterior(String s) {
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
