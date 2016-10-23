
// Use package zuulframework
package TWoT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TWoT{
    // Init variabels
    private Room currentRoom;
    private Player player;
    
    // Create the constructor for TWoT class
    public TWoT(){
        // Create the different rooms used
        createRooms();
        
        player = new Player("StartName", 1.0, 1.0, 100, new Inventory());
        
    }
    
    public void testMatch(){
        player = new Player("Test player1", 2.0, 1.0, 100, new Inventory());
        Monster monster = new Monster("Test monster1", 1.0, 1.0, 100, 100);
        Combat c = new Combat(player, monster);
        List<Fight> fight = c.AFight();
        for(Fight f: fight){
            System.out.println("Who won: " + f.winner());
            System.out.println("Player rolled: " + f.getPlayerRoll());
            System.out.println("Monster rolled: " + f.getMonsterRoll());
            System.out.println(f.winner() + " took " + f.getDamage() + " damage.");
            if(f.isDone()){
                if(f.getMonster().getHealth() <= 0){
                    System.out.println("\nPlayer won!");
                    System.out.println("Monster dropped: " + f.getMonster().getGoldDrop() + " gold.");
                }else{
                    System.out.println("Monster won!");
                }
            }
            System.out.println();
        }
    }
    
    
    /**
     * Creates all the rooms in the game.
     */
    private void createRooms(){
        // Deffine rooms
        Room roomCellar, roomVillage, roomHouse1, roomHouse2, roomHouse3, roomForrest, roomWizardHouse, roomCave, roomCaveGruul, roomClearing, roomDungeon, roomLibrary, roomEvilWizardsLair;

        roomCellar = new Room("Cellar", "You wake up in a dull cellar. Light is emitting from a torch on the wall "
                + "and you barely get on your feet. You’ve been laying on a haystack for God knows how long and "
                + "your feet are extremely sore. To your right you see a table with multiple drawers and right in "
                + "front of you an old door with a lock. You can choose to inspect the door, the table or the haystack behind you.");
        roomVillage = new Room("Treldan", "t’s dark outside. You seem to be familiar with this part of the village. "
                + "You still wonder why you were locked up in that cell, but your thoughts are quickly interrupted "
                + "by a sobbing by the gate. A guard seems to be crying, and something doesn’t seem right in the "
                + "village. All houses seem to be empty and the doors are wide open. You gasp as you see several "
                + "people lying dead in the side of the road. \n\"You enter the town of Treldan, you can choose to "
                + "inspect the guard at the gate, house one, house two or house three.\"");
        roomHouse1 = new Room("House of the reborn", "The house you venture into is dark – very dark. It seems like "
                + "there is a man in a corner of the room close you and a woman in the other end of the room.\" "
                + "You enter the house, you can choose to inspect the woman, the man or leave through the door "
                + "behind you.");
        roomHouse2 = new Room("House of riches", "You use your bloody key to get in. This house is lit up by a "
                + "candle on the table. There’s a blood-stained bed in the corner of the room. A bunch of sacks "
                + "are placed up against a poorly build wardrobe. The other corner is not lit up by the candle and "
                + "you can’t see what is there. You enter the house, you can choose to inspect the wardrobe, the "
                + "bed, the dark corner or leave through the door behind you.");
        roomHouse3 = new Room("House of the guard", "The door is barred from the inside, you jump through an open "
                + "window in the house, cutting yourself on a sharp piece of glass. Loose 5 HP. The house is neatly "
                + "decorated, and the infected clearly havent been in here, in the left corner of the room there is "
                + "a dusty set of armor and lying in an open chest at the end of a double-bed. Additionally, there "
                + "is also a small kitchen area with knives, pots, pans, and the like.   You enter the house, you "
                + "can chose to inspect the Kitchen, the bed, or the chest.");
        roomForrest = new Room("The forrest of Treldan", "As you ride through the forest you are ambushed by a pack "
                + "of goblins who try to murder you and take your valuables. You almost fall prey to the savages, "
                + "as you are saved by a wizard who zaps! the goblins with magic and scare them away. He heals your "
                + "wounds and helps you back on your feet. You thank the wizard and ask him if there is anything "
                + "you can do to repay him. Come meet me in my house when you're ready, its the Large Tree-house "
                + "over there. I have need of help in order to save Treldan! You enter the Forest of Treldan, you "
                + "scout around and look for anything, and spot a dead goblin and a couple of suspicious looking "
                + "mushrooms. \nYou can go to the wizards house, look at the mushrooms, and search the dead "
                + "goblin. Alternatively, you can also go back to the village.");
        roomWizardHouse = new Room ("The wizards house","The wizards house is more like a hollow tree with doors "
                + "and windows, you can see a number of magical artifacts, a staircase to a upstairs part of the "
                + "house, there is also what looks to be an alchemy lab. The wizard sits quietly in a comfy chair "
                + "with his legs up, snoring. You enter the Wizards house, you can chose to interact with the "
                + "wizard, the alchemy lab, the magical items, or go upstairs.");
        roomCave = new Room("Troll cave", "You enter the troll cave, and immediately get sorrounded by 3 trolls,"
                + " one directly in fron of you, one to the left, and one to your right. in the back "
                + "you can see a larger shadowy figure in the back of the cave, but you need to "
                + "get rid of the trolls to get to him first. \nYou can interact with the 3 trolls in front of "
                + "you but you need to kill all of them in order to get further into the cave");
        roomCaveGruul = new Room("","You approach the shadowy figure and as you come closer, the giant troll rises"
                + " up, easily towering 2 meters above you, opens its mouth and roars fiercely at you.");
        roomClearing = new Room("Clearing of unicorns", "You enter the clearing of unicorns and are immediately"
                + " blinded by a bright light. As you regain your sight you lay eyes upon the most magnificent "
                + "create you have ever seen. The unicorn looks at you curiously and goes back to eating grass. "
                + "You scout the surrounding area for anything else, and spot an old tree. ");
        roomDungeon = new Room("Dungeon of suffering", "A big whoosh and you find yourself in some kind of dungeon "
                + "– probably the one belonging to the evil wizard of Treldan. You realise you must be in his Tower."
                + " You get up on your feet and sees that the room your in is barely lit by torches, the walls are "
                + "slimy and there are no windows. To no surprise you find three heavely armored skeletons. You "
                + "sigh. You can choose to inspect either skeleton one, skeleton two or skeleton three.");
        roomLibrary = new Room("The neverending library", "You find yourself in the biggest room you’ve ever been "
                + "in. Books and books is all you see, and bookcases fill up the gigantic room. It would take ages "
                + "to go through every single book, you think to yourself.");
        roomEvilWizardsLair = new Room("The evil wizards lair", "s you ascend the stairs your legs feel heavier and "
                + "heavier. You can barely walk as you make it up to the final step – the pain is then suddenly "
                + "relieved. You open a large door and you see the Evil Wizard of Treldan standing in the room with "
                + "a giant dragon.");

        // roomCellar
        Interior roomCellarExit = new Exit(roomVillage);
        Interior roomCellarStick = new QuestItem("The niddle in the Hay stack", 1, "Nothing interresting happens");
        Interior roomCellarCheeseSandwich = new UseableItem("The sandwich of gold", 20, "dare eat it?");
        roomCellar.addMapInterior("north", roomCellarExit);
        roomCellar.addMapInterior("west", roomCellarStick);
        roomCellar.addMapInterior("east", roomCellarCheeseSandwich);

        //roomVillage
        Interior roomVillageExit1 = new Exit(roomHouse1);
        Interior roomVillageExit2 = new Exit(roomHouse2);
        Interior roomVillageExit3 = new Exit(roomHouse3);
        Interior roomVillageExit4 = new Exit(roomForrest);
        Npc mogens = new Npc("Mogens", true);
        mogens.addConversation("g");
        Interior roomVillageNPC = mogens;
        roomVillage.addMapInterior("house1", roomVillageExit1);
        roomVillage.addMapInterior("house2", roomVillageExit2);
        roomVillage.addMapInterior("house3", roomVillageExit3);
        roomVillage.addMapInterior("west", roomVillageNPC);
        
        
        //roomForrest
        Interior roomForrestExit1 = new Exit(roomWizardHouse);
        Interior roomForrestExit2 = new Exit(roomCave);
        Interior roomForrestExit3 = new Exit(roomClearing);
        Interior roomForrestMushroom = new UseableItem("Mushroom", 286, "It stinks, but it might come in handy scaring off weaker foes.");
        Interior roomForrestDeadGoblin = new EquippableItem("Handaxe", 293811, "Sturdy, and propably packs a punch.", 1.0, 0.0);
        roomForrest.addMapInterior("Mushrooms", roomForrestMushroom);
        roomForrest.addMapInterior("Dead goblin", roomForrestDeadGoblin);
        roomForrest.addMapInterior("Wizard's house", roomForrestExit1);
        roomForrest.addMapInterior("Gruul's lair", roomForrestExit2);
        roomForrest.addMapInterior("Clearing of unicorns", roomForrestExit3);
        
        //roomWizardHouse
        Interior roomWizardHouseExit = new Exit(roomForrest);
        Interior roomWizardHouseUpstairs = new UseableItem("Smooth ruby.", 200, "A valueable stone.");
        Interior roomWizardHouseBox = new UseableItem("Mysterious Ring",150,"Odd looking ring with a curiously intricate design, you decide to hold onto it.");
        Interior roomWizardHouseLab = new UseableItem("Health Potion",20,"Regenerates health points");
        Npc wizard = new Npc("Wizard", true);
        wizard.addConversation("g");
        Interior roomWizardHouseNPC = wizard;
        roomWizardHouse.addMapInterior("Upstairs", roomWizardHouseUpstairs);
        roomWizardHouse.addMapInterior("Box of items", roomWizardHouseBox);
        roomWizardHouse.addMapInterior("Alchemy lab", roomWizardHouseLab);
        roomWizardHouse.addMapInterior("Wizard", roomWizardHouseNPC);
        roomWizardHouse.addMapInterior("Forrest", roomWizardHouseExit);
        
        //roomCave
        Interior roomCaveExit1 = new Exit(roomForrest);
        Interior roomCaveExit2 = new Exit(roomCaveGruul);
        Monster troll = new Monster("Troll", 1.0, 1.0, 50, 3000);
        Interior roomWizardHouseMonster1 = troll;
        Interior roomWizardHouseMonster2 = troll;
        Interior roomWizardHouseMonster3 = troll;
        roomCave.addMapInterior("Troll numero uno",roomWizardHouseMonster1);
        roomCave.addMapInterior("Troll numero dos",roomWizardHouseMonster2);
        roomCave.addMapInterior("Troll numero tres",roomWizardHouseMonster3);
        roomCave.addMapInterior("Forrest",roomCaveExit1);
        roomCave.addMapInterior("Gruuls lair",roomCaveExit2);
        
        //roomCaveGrull
        Interior roomCaveGruulExit1 = new Exit(roomCave);
        Monster gruul = new Monster("Gruul", 1.8, 2.0, 100, 5);
        Interior roomCaveGruulMonster = gruul;
        roomCave.addMapInterior("Attack Gruul", roomCaveGruulMonster);
        roomCave.addMapInterior("Troll Cave", roomCaveGruulExit1);
        
        //roomClearing
        Interior roomClearingExit1 = new Exit(roomForrest);
        Monster giant_troll_boss = new Monster("Humongous troll", 2.1, 1.5, 200, 100);
        Monster unicorn = new Monster("Unicorn", 1.6, 1.5, 400, 2000000000);
        Interior roomClearingMonster1 = unicorn;
        Interior roomClearingTree = new UseableItem("Doorknob", 0, "You don't have a door");
        Interior roomClearingBoss = giant_troll_boss;
        roomClearing.addMapInterior("Giant troll", roomClearingBoss);
        roomClearing.addMapInterior("Forrest", roomClearingExit1);
        roomClearing.addMapInterior("Unicorn", roomClearingMonster1);
        roomClearing.addMapInterior("Old tree", roomClearingTree);
        
        
        //roomDungeon
        Interior roomDungeonExit = new Exit(roomLibrary);
        Interior roomDungeonSkeleton1 = new UseableItem("",0,"");
        Interior roomDungeonSkeleton2 = new UseableItem("",0,"");
        Interior roomDungeonSkeleton3 = new QuestItem("Broken handle",50,"Couldn't handle it");
        roomDungeon.addMapInterior("Dead skeleton numero uno", roomDungeonSkeleton1);
        roomDungeon.addMapInterior("Dead skeleton numero dos", roomDungeonSkeleton2);
        roomDungeon.addMapInterior("Dead skeleton numero tres", roomDungeonSkeleton3);
        roomDungeon.addMapInterior("Hidden pathway", roomDungeonExit);
        
        //roomLibrary
        Interior roomLibraryExit = new Exit(roomEvilWizardsLair);
        roomLibrary.addMapInterior("Book on da shelf", roomLibraryExit);
        
        //roomEvilWizardsLair
        /*
        Interior roomEvilWizardsLairDevice = new OuchItem(TBA);
        Interior roomEvilWizardsLairDevice2 = new OuchItem(TBA);
        Monster evil_wizard_f_boss = new Monster("Evil wizard!!1!", 3.0, 3.0, 1, 900);
        roomEvilWizardsLair.addMapInterior("It looks like a pot, but it's a landmine, ouch.",roomEvilWizardsLairDevice);
        roomEvilWizardsLair.addMapInterior("It looks like a glass, but it's a samsung note7, ouch.",roomEvilWizardsLairDevice2);
        roomEvilWizardsLair.addMapInterior("It looks like a pot, but it's really the evil wizard.",evil_wizard_f_boss);
        */
        
        //set which room you start in.
        currentRoom = roomCellar;
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
     * commands : display all the commands possible
     * @return 
     */
    public HashMap<String, String> getHelpMessages(){
        //init a new object of type hashmap
        HashMap<String, String> helpList = new HashMap<String, String>();
        helpList.put("helpMessage1",  "You are at " + currentRoom.getName());
        helpList.put("helpMessage2", "Here is where you can go: " + currentRoom.getFullDescription());
        helpList.put("helpMessage3", "Your command words are:");
        
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
        if(interior == null) {
            return "place dosent exist";
        }else if(interior instanceof Exit){
            currentRoom = ((Exit)interior).getNewRoom();
            return currentRoom.getFullDescription();
        }else{
            return "nothing here";
        }
    }
    /**
     * 
     * @return 
     */
    public List<Item> getInventoryItems(){
        return player.getInventoryItems();
    }
    /**
     * 
     * @return 
     */
    public List<EquippableItem> getEquippableItems(){
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
    
    
    /**
     * 
     * @return 
     */
    public static List<String> getMenuSelections(){
        List<String> menu = new ArrayList();
        menu.add("NEW GAME ");
        menu.add("LOAD GAME");
        menu.add("EXIT GAME");
        return menu;
    }
    
    /**
     * 
     * @param playerName 
     */
    public void setPlayerName(String playerName){
        player.setPlayerName(playerName);
    }
    
    /**
     * 
     * @return 
     */
    public String getPlayerName(){
        return player.getPlayerName();
    }
}
