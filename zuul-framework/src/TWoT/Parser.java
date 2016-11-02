package TWoT;

import java.util.HashMap;
import java.util.Scanner;

public class Parser{
    // Init the variables
    private CommandWords commands;
    private Scanner reader;

    // Create the constructor 
    public Parser(){
        // Create a new object of class CommandWords
        commands = new CommandWords();
        // Create a new Scanner object.
        reader = new Scanner(System.in);
    }

    // Returns the command the user entered.
    public Command getCommand(){
        // Init variables
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        // Read the next line from the user.
        inputLine = reader.nextLine();

        // Create a new Scanner object from the input
        Scanner tokenizer = new Scanner(inputLine);
        // If the user has entered 1 word set word1 to the word.
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next().toLowerCase();
            // If the user has entered 2'n word set word2 to the 2'n word.
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next().toLowerCase();
            }
        }
        // Return the Command object.
        return new Command(commands.getCommandWord(word1), word2);
    }

    /**
     * Returns hashmap of valid commands.
     * @return HashMap
     */
    public HashMap<String, CommandWord> showCommands(){
        return commands.showAll();
    }
}
