
// Use package zuulframework
package TWoT;

import java.util.HashMap;
import java.util.List;

public class TWoT{
    // Init variabels
    private Parser parser;
    private Room currentRoom;
    
    // Create the constructor for TWoT class
    public TWoT(){
        // Create the different rooms used
        createRooms();
        
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
        // Deffine the 5 rooms from klass Room
        Room outside, theatre, pub, lab, office;
      
        // Create objects from the class Room.
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        // Set the exits for outside
        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        // Set the exit for Theatre.
        theatre.setExit("west", outside);

        // Set the exit for the Pub
        pub.setExit("east", outside);

        // Set the exits for the Lab
        lab.setExit("north", outside);
        lab.setExit("east", office);

        //set the exit for the office.
        office.setExit("west", lab);

        //set which room you start in.
        currentRoom = outside;
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
        welcomeList.put("getRooms", currentRoom.getLongDescription());
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
    public String goRoom(Command command){
        
        // Get the direction where the user wants to go.
        String direction = command.getSecondWord();
        if(!command.hasSecondWord()) {
            return "Go where?";
        }
        // Create an object of klass Room and return if the exit is correct.
        Room nextRoom = currentRoom.getExit(direction);

        // If the nextroom is null it means that there was no next room in that direction.
        if (nextRoom == null) {
            return "Room dosent exist";
        }else {
            //If there is a room go to the room by setting the currentRoom to nextRoom.
            currentRoom = nextRoom;
            //Print the longDesc from the room to know where to go.
            return currentRoom.getLongDescription();
        }
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
