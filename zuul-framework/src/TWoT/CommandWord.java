//use package zuulframework
package TWoT;

public enum CommandWord {
    // Set the enums that the CommandWord can be.
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), INVENTORY("inventory"), PLAYER("player"), USE("use");

    // Init the commandString of type String
    private String commandString;

    /**
     * Constructor for the "enum" class and take argument of type String
     * @param commandString String
     */
    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    /**
     * @return which commandstring this object contains.
     */
    public String toString() {
        return commandString;
    }
}
