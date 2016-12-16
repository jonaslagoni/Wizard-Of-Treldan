//use package zuulframework
package TWoT;

/**
 * 
 * @author Lagoni
 */
public class Command {

    private CommandWord commandWord;
    private String secondWord;

    /**
     * Create constructor with arguments CommandWord and String
     * @param commandWord CommandWord
     * @param secondWord String
     */
    public Command(CommandWord commandWord, String secondWord) {
        // Set the variables to the arguments in the constructor
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    /**
     * @return the commandWord of type CommandWord
     */
    public CommandWord getCommandWord() {
        return commandWord;
    }

    /**
     * @return secondWord of type String
     */
    public String getSecondWord() {
        return secondWord;
    }

    /**
     * Return true if the commandWord of type CommandWord is UNKNOWN
     * @return boolean
     */
    public boolean isUnknown() {
        return (commandWord == CommandWord.UNKNOWN);
    }

    /**
     * Return true if the word != null
     * @return boolean
     */
    public boolean hasSecondWord() {
        return (secondWord != null);
    }
}
