
// Use package zuulframework
package TWoT;

import java.util.HashMap;
import java.util.List;

public class TWoT{
    // Init variabels
    private Parser parser;
    private Room currentRoom;
    private Player player;
    
    // Create the constructor for TWoT class
    public TWoT(){
        // Create the different rooms used
        createRooms();
        
        player = new Player("BOB", 1.0, 1.0, 100, new Inventory());
        
        // Create a parser object from class Parser.
        parser = new Parser();
    }
    
    public void testMatch(){
        Player p = new Player("kaj", 2.0, 2.0, 100);
        Monster m = new Monster("Monster", 1.9, 2.0, 100, 100);
        Combat c = new Combat(p, m);
        List<String> combatText;
        combatText = c.fight();
        for(String s: combatText){
            System.out.println(s);
        }
        System.out.println("You have: " + p.getHealth() + " health left.");
    }
    
    
    /**
     * Creates all the rooms in the game.
     */
    private void createRooms(){
        // Deffine rooms
        Room roomCellar, roomVillage, roomHouse1, roomHouse2, roomHouse3, roomForrest, roomTower, roomCave, roomClearing, roomDungeon, roomLibrary, roomHollowTree;
        
        
        roomCellar = new Room("Cellar", "test");
        roomVillage = new Room("Treldan", "test");
        roomHouse1 = new Room("House of the guard", "test");
        roomHouse2 = new Room("House of riches", "test");
        roomHouse3 = new Room("House of reborn", "test");
        roomForrest = new Room("The Treldan forrest", "test");
        roomTower = new Room("TWoT tower", "test");
        roomCave = new Room("Grulls lair", "test");
        roomClearing = new Room("Clearing of unicorns", "test");
        roomDungeon = new Room("Dungeon of suffering", "test");
        roomLibrary = new Room("The neverending library", "test");
        roomHollowTree = new Room("The hollow tree", "test");
        
        // roomCellar
        Interior roomCellarExit = new Exit(roomVillage);
        Interior roomCellarStick = new QuestItem("The niddle in the Hay stack", 1, "Nothing interresting happens");
        Interior roomCellarCheeseSandwich = new UseableItem("The sandwich of gold", 20, "dare eat it?");
        Interior roomCellarCheeseSandwich = new EquippableItem();
        roomCellar.addMapInterior("north", roomCellarExit);
        roomCellar.addMapInterior("west", roomCellarStick);
        roomCellar.addMapInterior("east", roomCellarCheeseSandwich);
        
        //roomVillage
        Interior roomVillageExit1 = new Exit(roomHouse1);
        Interior roomVillageExit2 = new Exit(roomHouse2);
        Interior roomVillageExit3 = new Exit(roomHouse3);
        Interior roomVillageNPC = new Npc("Guard", "Help!", true);
        roomVillage.addMapInterior("house1", roomVillageExit1);
        roomVillage.addMapInterior("house2", roomVillageExit2);
        roomVillage.addMapInterior("house3", roomVillageExit3);
        roomVillage.addMapInterior("west", roomVillageNPC);
        
        
        
        //set which room you start in.
        currentRoom = roomCellar;
    }
    
    /**
     * Returns the command the user entered.
     * @return 
     */
    public Command getCommand(){
        return parser.getCommand();
    }
    
    /**
     * Return the WelcomeMessage hashmap which contains the welcome messages.
     * The keys are:
     * welcomeMessage1
     * welcomeMessage2
     * needHelp
     * getRooms
     * @return 
     */
    public HashMap<String, String> getWelcomeMessages(){
        HashMap<String, String> welcomeList = new HashMap<String, String>();
        welcomeList.put("welcomeMessage1", "Welcome to the World of Zuul!");
        welcomeList.put("welcomeMessage2", "World of Zuul is a new, incredibly boring adventure game.");
        welcomeList.put("needHelp", "Type '" + CommandWord.HELP + "' if you need help.");
        welcomeList.put("getRooms", currentRoom.getDescription());
        return welcomeList;
    }

     /**
     * Return the HelpMessage hashmap which contains the help messages.
     * The keys are:
     * helpMessage1 : "You are lost. You are alone. You wander"
     * helpMessage2 : "around at the university."
     * helpMessage3 : "Your command words are:"
     * commands : display all the commands posible
     * @return 
     */
    public HashMap<String, String> getHelpMessages(){
        //init a new object of type hashmap
        HashMap<String, String> helpList = new HashMap<String, String>();
        helpList.put("helpMessage1", "You are lost. You are alone. You wander");
        helpList.put("helpMessage2", "around at the university.");
        helpList.put("helpMessage3", "Your command words are:");
        //get all the commands we can do.
        HashMap<String, CommandWord> commands = parser.showCommands();
        //init the empty string
        String s = "";
        //go through each set of values and insert the key to the string.
        for (String key: commands.keySet()) {
            s += key + " ";
        }
        helpList.put("commands", s);
        
        //return the helplist when done.
        return helpList;
    }
    
    /**
     * Go to the desired room defined from the command param.
     * @param command
     * @return String
     */
    public String goTo(Command command){
        
        // Get the direction where the user wants to go.
        String direction = command.getSecondWord();
        if(!command.hasSecondWord()) {
            return "Go where?";
        }
        // Create an object of klass Room and return if the exit is correct.
        Interior interior = currentRoom.getMapInterior(direction);
        // If the nextroom is null it means that there was no next room in that direction.
        if (interior == null) {
            return "place dosent exist";
        }else {
            if(interior instanceof Exit){
                //If there is a room go to the room by setting the currentRoom to nextRoom.
                currentRoom = ((Exit) interior).getNewRoom();
                //Print the longDesc from the room to know where to go.
                return currentRoom.getDescription();
            }else if(interior instanceof Item){
                player.addItemToInventory((Item)interior);
                if(interior instanceof EquippableItem){
                    
                }
            }
        }
        return "nothing here";
    }
    
    public List<Item> getInventoryItems(){
        return player.getInventoryItems();
    }
    
    public List<Item> getEquippableItems(){
        return player.getEquippableItems();
    }
    /**
     * Returns false if the user entered more then "quit" and return true otherwise
     * @param command
     * @return Boolean
     */
    public boolean quit(Command command){
        //if the command is quit and has a second word do nothing. Else quit.
        if(command.hasSecondWord()) {
            return false;
        }
        else {
            return true;
        }
    }
}
