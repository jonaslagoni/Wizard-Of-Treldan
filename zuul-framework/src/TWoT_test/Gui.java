/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TWoT_test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author jonas
 */

public class Gui{
    //init game class
    private TWoT twot;
    private Parser parser;
    /**
     * Starts the game
     */
    
    
    public Gui(){
        //Create the object from gameclass
        twot = new TWoT();
        // Create a parser object from class Parser.
        parser = new Parser();
        
        setPlayerName();
        printWelcome();
        play();
    }
    /**
     * Player enters a name for their character.
     */
    private void setPlayerName(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a name for your character:");
        String nextName = scanner.next();
        twot.setPlayerName(nextName);
    }
    
    /**
     * Prints the welcome text.
     */
    private void printWelcome(){
        //get the welcome hashmap from gameclass
        HashMap<String, String> welcomeList = twot.getWelcomeMessages();
        System.out.println("Welcome " + twot.getPlayerName());
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
    private void printHelp() {
        //Get the helplist hashmap from gameclass
        HashMap<String, String> helpList = twot.getHelpMessages();
        System.out.println(helpList.get("helpMessage1"));
        System.out.println(helpList.get("helpMessage2"));
        System.out.println();
        System.out.println(helpList.get("helpMessage3"));
        //get all the commands we can do.
        HashMap<String, CommandWord> commands = parser.showCommands();
        //init the empty string
        String s = "";
        //go through each set of values and insert the key to the string.
        for (String key: commands.keySet()) {
            s += key + " ";
        }
        helpList.put("commands", s);
        System.out.println(helpList.get("commands"));
    }
    
    /**
     * Starts the game from scratch
     */
    private void play(){
        // Set our initial finish to false since the game just started.
        boolean finished = false;
        boolean quit = false;
        while(!quit){
            // As long as the game has not finished yet.
            while (! finished) {
                if(twot.isIsOver()){
                    finished = true;
                }else{
                    finished = processCommand(parser.getCommand());
                }
            }
            twot.writeHighScore();
            // Print goodbye
            System.out.println("Thank you for playing. Good bye.");
            System.out.println("");
            callMenu();
        }
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
        }else if (commandWord == CommandWord.GO) {
            // If commandWord is go go the room defined in the command.
            // If the command does not have a second word the user intered "go" without a where.
            for(String s: twot.goTo(command)){
                System.out.println(s);
            }
        }else if (commandWord == CommandWord.QUIT) {
            // If the user wants to quit quit.
            wantToQuit = twot.quit(command);
            if(!wantToQuit){
                System.out.println("Quit what?");
            }
        }else if (commandWord == CommandWord.INVENTORY){
            List<Item> questItems = new ArrayList();
            List<Item> usableItems = new ArrayList();
            List<Item> equippableItems = new ArrayList();
            System.out.println("\n|--INVENTORY---");
            for(Item i: twot.getInventoryItems()){
                if(i instanceof QuestItem){
                    questItems.add(i);
                } else if (i instanceof UseableItem){
                    usableItems.add(i);
                } else if (i instanceof EquippableItem){
                    equippableItems.add(i);
                }
            }
            System.out.println("|QUEST ITEMS|");
            if(!questItems.isEmpty()){
                for(Item q: questItems){
                    System.out.println(q.getItemName() + " - " + q.getItemDescription());
                }
            }else{
                System.out.println("No items");
            }
            
            System.out.println("|USABLE ITEMS|");
            
            if(!usableItems.isEmpty()){
                for(Item u: usableItems){
                    System.out.println(u.getItemName() + " - " + u.getItemDescription());
                }
            }else{
                System.out.println("No items");
            }
            
            System.out.println("|EQUIPPABLE ITEMS|");
            if(!equippableItems.isEmpty()){
                for(Item e: equippableItems){
                    System.out.println(e.getItemName() + " - " + e.getItemDescription());
                }
            }else{
                System.out.println("No items");
            }
        }else if (commandWord == CommandWord.PLAYER){
            System.out.println("");
            System.out.println("******************");
            System.out.println("Name    : "+twot.getPlayerName());
            System.out.println("Health  : "+twot.getPlayerHealth());
            System.out.println("Attack  : "+twot.getPlayerAtt());
            System.out.println("Defense : "+twot.getPlayerDeff());
            System.out.println("Gold    : "+twot.getPlayerGold());
            System.out.println("******************");
            System.out.println("**EQUIPPED ITEMS**");
            if(!twot.getEquippableItems().isEmpty()){
                for(Map.Entry<EquippableItem.EItem, EquippableItem> ei: twot.getEquippableItems().entrySet()){
                    System.out.println(ei.getKey() + ": " + ei.getValue().getItemName() + " : ATTV " + ei.getValue().getAttackBuff() + " : DEFFV " + ei.getValue().getDefenseBuff());
                }
            }else{
                System.out.println("No equipped items..");
            }
        }else if (commandWord == CommandWord.USE) {
           for(String use: twot.useItem(command)){
                System.out.println(use);
            }
        }
        return wantToQuit;
    }

    /**
     * 
     * @return 
     */
    public static boolean callMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to The Wizard of Treldan!");
        System.out.println("******************");
        
        for(String s: TWoT.getMenuSelections()){
            System.out.println("----" + s + "----");
        }
        System.out.println("******************");
        System.out.println("Please enter either 'new game', 'load game', 'how to play' or 'exit game'.");
        String menuChoice = scanner.nextLine();
        menuChoice = menuChoice.toLowerCase();
        
        while(!menuChoice.equals("new game") || !menuChoice.equals("load game") || menuChoice.equals("how to play") || !menuChoice.equals("exit game")){
            if(menuChoice.equals("new game") || menuChoice.equals("load game") || menuChoice.equals("how to play") || menuChoice.equals("exit game")){
                break;
            }
            System.out.println("Looks like you entered something wrong. Please try again:");
            menuChoice = scanner.nextLine();
            menuChoice = menuChoice.toLowerCase();
        }
        switch (menuChoice) {
            case "new game":
                Gui g = new Gui();
                break;
            case "load game":
                callMenu();
                break;
            case "how to play":
                System.out.println("\nYour command words are: help, go, use, player, inventory, quit");
                System.out.println("");
                callMenu();
                break;
            case "exit game":
                System.out.println("Thank you for atleast consider playing The Wizard of Treldan.\n");
                System.exit(1);
                break;
        }
        return true;
    }
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args){
        //make an object of this class.
        callMenu();
    }
}
