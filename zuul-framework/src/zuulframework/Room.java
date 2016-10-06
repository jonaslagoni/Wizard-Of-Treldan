
package zuulframework;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


public class Room{
    // Init the variables
    private String description;
    private HashMap<String, Room> exits;

    //create the constructor with argument of type String
    public Room(String description){
        // Set the description of the room to the variable
        this.description = description;
        
        // Create an object of hashmap with types String, Room.
        exits = new HashMap<String, Room>();
    }
    
    // Set the exit of the room to the direction and which room it is.
    public void setExit(String direction, Room neighbor){
        exits.put(direction, neighbor);
    }

    // Returns the short description of the room
    public String getShortDescription(){
        return description;
    }

    // Returns the long descrtion of the room
    public String getLongDescription(){
        return "You are " + description + ".\n" + getExitString();
    }

    // Returns a string with each exit of this room.
    private String getExitString(){
        String returnString = "Exits:";
        // Create a set of String of the hashmpas keys
        Set<String> keys = exits.keySet();
        // For each of the keys add the exit to the string.
        for(String exit : keys) {
            returnString += " " + exit;
        }
        // Return the string
        return returnString;
    }

    // Return the room at String direction, null if no exit there.
    public Room getExit(String direction){
        return exits.get(direction);
    }
}

