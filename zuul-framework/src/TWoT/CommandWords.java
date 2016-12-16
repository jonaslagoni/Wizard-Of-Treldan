//use package zuulframework
package TWoT;

//import the hashmap
import java.util.HashMap;

public class CommandWords {

    // Init HashMap of key type String and value of type CommandWOrd
    private HashMap<String, CommandWord> validCommands;

    /**
     * The constructor finds all the commands that are deffined
     * in CommandWord class and puts it in a hashmap.
     */
    public CommandWords() {
        // Create the HashMap.
        validCommands = new HashMap<String, CommandWord>();

        // Go through each of the enum values
        for (CommandWord command : CommandWord.values()) {

            // As long as the command value is not equal UNKNOWN.
            if (command != CommandWord.UNKNOWN) {

                // Put the command
                validCommands.put(command.toString(), command);
            }
        }
    }

    /**
     * @param commandWord String
     * @return the CommandWord command according to the argument String
     */
    public CommandWord getCommandWord(String commandWord) {

        // Gets the value from the Key in the hashmap validCommands
        CommandWord command = validCommands.get(commandWord);

        //if there is nothing found (=null) then the command you entered was wrong.
        if (command != null) {
            //return the command
            return command;
        } else {
            //return the CommandWord UNKNOWN.
            return CommandWord.UNKNOWN;
        }
    }

    /**
     * return true of its a valid command 
     * @param aString String
     * @return boolean 
     */
    public boolean isCommand(String aString) {
        return validCommands.containsKey(aString);
    }

    /**
     * Returns the valid commands for this game.
     *
     * @return HashMap
     */
    public HashMap<String, CommandWord> showAll() {
        return validCommands;
    }
}
