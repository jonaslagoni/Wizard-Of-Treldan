//use package zuulframework
package TWoT_test;



 public enum CommandWord{
    // Set the enums that the CommandWord can be.
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), INSPECT("inspect");
    
    // Init the commandString of type String
    private String commandString;
    
    // create a Constructor for the "enum" class and take argument of type String
    CommandWord(String commandString){
        this.commandString = commandString;
    }
    
    //create method toString to return which commandstring this object contains.
    public String toString(){
        return commandString;
    }
}
