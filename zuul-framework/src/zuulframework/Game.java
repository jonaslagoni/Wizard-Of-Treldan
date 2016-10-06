
// Use package zuulframework
package zuulframework;

public class Game{
    // Init variabels
    private Parser parser;
    private Room currentRoom;
    
    // Create the constructor for Game class
    public Game(){
        // Create the different rooms used
        createRooms();
        
        // Create a parser object from class Parser.
        parser = new Parser();
    }

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

    // Method play which start the game.
    public void play(){            
        // Print the welcome text
        printWelcome();
               
        // Set our initial finish to false since the game just started.
        boolean finished = false;
        
        // As long as the game has not finished yet.
        while (! finished) {
            // Get the return command from the parser.
            Command command = parser.getCommand();
            
            // Update the variable with the processedcommand. If "quit" the quit method is called.
            finished = processCommand(command);
        }
        // Print goodbye
        System.out.println("Thank you for playing.  Good bye.");
    }

    // Print the welcome text.
    private void printWelcome(){
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    // Process our argument Command.
    private boolean processCommand(Command command) 
    {
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
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            // If the user wants to quit quit.
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }
 
    // Print the help
    private void printHelp(){
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    // Go to the room deffined by the Command.
    private void goRoom(Command command){
        // If the command does not have a second word the user intered "go" without a where.
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }
        // Get the direction where the user wants to go.
        String direction = command.getSecondWord();
        
        // Create an object of klass Room and return if the exit is correct.
        Room nextRoom = currentRoom.getExit(direction);

        // If the nextroom is null it means that there was no next room in that direction.
        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            //If there is a room go to the room by setting the currentRoom to nextRoom.
            currentRoom = nextRoom;
            //Print the longDesc from the room to know where to go.
            System.out.println(currentRoom.getLongDescription());
        }
    }
    
    //if the user wants to quit
    private boolean quit(Command command){
        //if the command is quit and has a second word do nothing. Else quit.
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
}
