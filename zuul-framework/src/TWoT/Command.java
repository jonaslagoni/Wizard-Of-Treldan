
//use package zuulframework
package TWoT;


public class Command{
    
    // Init variables
    private CommandWord commandWord;
    private String secondWord;

    // Create constructor with arguments CommandWord and String,
    public Command(CommandWord commandWord, String secondWord){
        // Set the variables to the arguments in the constructor
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }
    
    // Return the commandWord of type CommandWord
    public CommandWord getCommandWord(){
        return commandWord;
    }

    // Return secondWord of type String
    public String getSecondWord(){
        return secondWord;
    }

    // Return true if the commandWord of type CommandWord is UNKNOWN
    public boolean isUnknown(){
        return (commandWord == CommandWord.UNKNOWN);
    }

    // Return true if the word != null
    public boolean hasSecondWord(){
        return (secondWord != null);
    }
}

