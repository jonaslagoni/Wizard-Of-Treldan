/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT;

import java.util.HashMap;

/**
 *
 * @author jonas
 */

public class Gui{
    //init game class
    private TWoT twot;
    
    /**
     * Starts the game
     */
    public Gui(){
        //Create the object from gameclass
        twot = new TWoT();
        twot.testMatch();
    }
    
    /**
     * Prints the welcome text.
     */
    private void printWelcome(){
        //get the welcome hashmap from gameclass
        HashMap<String, String> welcomeList = twot.getWelcomeMessages();
        System.out.println(welcomeList.get("welcomeMessage1"));
        System.out.println(welcomeList.get("welcomeMessage2"));
        System.out.println();
        System.out.println(welcomeList.get("needHelp"));
        System.out.println();
        System.out.println(welcomeList.get("getRooms"));
    }
    
    /**
     * Prints the help text.
     */
    private void printHelp(){
        //Get the helplist hashmap from gameclass
        HashMap<String, String> helpList = twot.getHelpMessages();
        System.out.println(helpList.get("helpMessage1"));
        System.out.println(helpList.get("helpMessage2"));
        System.out.println();
        System.out.println(helpList.get("helpMessage3"));
        System.out.println(helpList.get("commands"));
    }
    
    /**
     * Starts the game from scratch
     */
    private void play(){
        // Set our initial finish to false since the game just started.
        boolean finished = false;
        
        // As long as the game has not finished yet.
        while (! finished) {
            // Update the variable with the processedcommand. If "quit" the quit method is called.
            finished = processCommand(twot.getCommand());
        }
        // Print goodbye
        System.out.println("Thank you for playing.  Good bye.");
    }
    
    /**
     * Process the command from the parser.
     * @param command
     * @return 
     */
    public boolean processCommand(Command command){
        boolean wantToQuit = false;
        // Make an object of type CommandWord from the command.getCommandWord()
        CommandWord commandWord = command.getCommandWord();

        // Check if the commandword is unknown.
        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        // Check if commandword is help
        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            // If commandWord is go go the room defined in the command.
            // If the command does not have a second word the user intered "go" without a where.
            System.out.println(twot.goRoom(command));
        }
        else if (commandWord == CommandWord.QUIT) {
            // If the user wants to quit quit.
            wantToQuit = twot.quit(command);
            if(!wantToQuit){
                System.out.println("Quit what?");
            }
        }
        return wantToQuit;
    }
    
    
    public static void main(String[] args){
        //make an object of this class.
        Gui g = new Gui();
    }
}
