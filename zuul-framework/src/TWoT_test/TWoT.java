
// Use package zuulframework
package TWoT_test;

import static TWoT_test.EquippableItem.EItem.CHEST_SLOT;
import static TWoT_test.EquippableItem.EItem.WEAPON_SLOT;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TWoT implements Serializable{
    // Init variabels
    private Room currentRoom;
    private Player player;
    
    // Deffine rooms
    private Room roomCellar, roomVillage, roomHouse1, roomHouse2, roomHouse3, roomForest, roomWizardHouse, roomCave, roomCaveGruul, roomClearing, roomDungeon, roomLibrary, roomEvilWizardsLair;

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
        roomCellar = new Room("Cellar", "***Cellar*** \nYou wake up in a dull cellar. Light is emitting from a torch on the wall "
                + "and you barely get on your feet.\nYou’ve been laying on a haystack for God knows how long and "
                + "your feet are extremely sore.\nTo your right you see a table with multiple drawers and right in "
                + "front of you an old door with a lock.\nYou can choose to inspect the door, the table or the haystack behind you.");
        roomVillage = new Room("Village of Treldan", "\n\n***Village of Treldan*** \nIt’s dark outside. You seem to be familiar with this part of the village. "
                + "\nYou still wonder why you were locked up in that cell, but your thoughts are quickly interrupted "
                + "by a sobbing by the gate.\nA guard seems to be crying, and something doesn’t seem right in the "
                + "village. All houses seem to be empty and the doors are wide open.\nYou gasp as you see several "
                + "people lying dead in the side of the road.\nYou enter the town of Treldan; you can choose to "
                + "inspect the guard at the gate, house one, house two or house three.\"");
        roomHouse1 = new Room("House of the Reborn", "\n\n***House of the Reborn*** \nThe house you venture into is dark – very dark. It seems like "
                + "there is a man in a corner of the room close you and a woman in the other end of the room."
                + "\nYou enter the house, you can choose to inspect the woman, the man or leave through the door "
                + "behind you.");
        roomHouse2 = new Room("House of Riches", "\n\n***House of Riches*** \n You use your bloody key to get in. This house is lit up by a "
                + "candle on the table.\nThere’s a blood-stained bed in the corner of the room. A bunch of sacks "
                + "are placed up against a poorly build wardrobe.\nThe other corner is not lit up by the candle and "
                + "you can’t see what is there.\nYou enter the house, you can choose to inspect the wardrobe, the "
                + "bed, the dark corner or leave through the door behind you.");
        roomHouse3 = new Room("House of the Guard", "\n\n***House of the Guard*** \nThe door is barred from the inside, you jump through an open "
                + "window in the house, cutting yourself on a sharp piece of glass. You lose 5 HP.\nThe house is neatly "
                + "decorated, and the infected clearly havent been in here, in the left corner of the room there is "
                + "a dusty set of armor and lying in an open chest at the end of a double-bed.\nAdditionally, there "
                + "is also a small kitchen area with knives, pots, pans, and the like.\nYou enter the house, you "
                + "can chose to inspect the kitchen, the bed, the chest or go back through the door behind you.");
        roomForest = new Room("The Forest of Treldan", "\n\n***The Forest of Treldan*** \nAs you ride through the forest you are ambushed by a pack "
                + "of goblins who try to murder you and take your valuables.\nYou almost fall prey to the savages, "
                + "as you are saved by a wizard who zaps! the goblins with magic and scare them away.\nHe heals your "
                + "wounds and helps you back on your feet.\nYou thank the wizard and ask him if there is anything "
                + "you can do to repay him. Come meet me in my house when you're ready, its the Large Tree-house "
                + "over there.\nI have need of help in order to save Treldan! You enter the Forest of Treldan, you "
                + "scout around and look for anything, and spot a dead goblin and a couple of suspicious looking "
                + "mushrooms.\nYou can go to the wizards house, look at the mushrooms, and search the dead "
                + "goblin. Alternatively, you can also go back to the village.");
        roomWizardHouse = new Room ("The Nice Wizard's House","\n\n***The Wizard's House*** \nThe wizard's house is better described as a hollow tree with doors "
                + "and windows, you can see a number of magical artifacts, a staircase to a upstairs part of the "
                + "house, there is also what looks to be an alchemy lab.\nThe wizard sits quietly in a comfy chair "
                + "with his legs up, snoring.\nYou can chose to interact with the "
                + "wizard, the alchemy lab, the magical items, or go upstairs.");
        roomCave = new Room("Troll Cave", "\n\n***Troll Cave*** \nYou enter the troll cave, and immediately get sorrounded by 3 trolls,"
                + " one directly in fron of you, one to the left, and one to your right.\nIn the back "
                + "you can see a larger shadowy figure in the back of the cave, but you need to "
                + "get rid of the trolls to get to him first.\nYou can interact with the 3 trolls in front of "
                + "you but you need to kill all of them in order to get further into the cave");
        roomCaveGruul = new Room("Gruul's Lair","\n\n***Gruul's Lair*** \n You approach the shadowy figure and as you come closer, the giant troll rises"
                + " up, easily towering 2 meters above you, opens its mouth and roars fiercely at you.");
        roomClearing = new Room("Clearing of Unicorns", "***Clearing of Unicorns*** \nYou enter the clearing of unicorns and are immediately"
                + " blinded by a bright light.\nAs you regain your sight you lay eyes upon the most magnificent "
                + "create you have ever seen.\nThe unicorn looks at you curiously and goes back to eating grass. "
                + "\nYou scout the surrounding area for anything else, and spot an old tree. ");
        roomDungeon = new Room("Dungeon of Suffering", "\n\n***Dungeon of Suffering*** \nA loud whoosh and you find yourself in some kind of dungeon "
                + "– probably the one belonging to the evil wizard of Treldan.\nYou realise you must be in his Tower."
                + "\nYou get up on your feet and sees that the room your in is barely lit by torches, the walls are "
                + "slimy and there are no windows. To no surprise you find three heavely armored skeletons.\nYou "
                + "sigh. You can choose to inspect either skeleton one, skeleton two or skeleton three.");
        roomLibrary = new Room("The Neverending Library", "\n\n***The Neverending Library*** \nYou find yourself in the biggest room you’ve ever been "
                + "in. Books upon books is all you see, and bookcases fill up the gigantic room.\nIt would take ages "
                + "to go through every single book, you think to yourself.");
        roomEvilWizardsLair = new Room("The Evil Wizard's Lair", "\n\n***The Evil Wizard's Lair*** \nAs you ascend the stairs your legs feel heavier and "
                + "heavier.\nYou can barely walk as you make it up to the final step – the pain is then suddenly "
                + "relieved.\nYou open a large door and you see the Evil Wizard of Treldan standing in the room with "
                + "a giant dragon.");

        // roomCellar
        Interior roomCellarExit = new Exit(roomVillage);
        Interior roomCellarStick = new QuestItem("A needle", 1, "It was found in the haystack", 99901, "It must have been super uncomfortable laying on the haystack.\nYou search around the haystack and end up finding a strong needle. The needle has been added to your inventory.");
        Interior roomCellarCheeseSandwich = new UseableItem("Cheese sandwhich", 20, "Do you dare eat it?", "The table has several books and journals that are of no interest to you. In the drawer you find a cheese sandwich for eating.", 55501);
        roomCellar.addMapInterior("door", roomCellarExit);
        roomCellar.addMapInterior("haystack", roomCellarStick);
        roomCellar.addMapInterior("table", roomCellarCheeseSandwich);
        

        //roomVillage
        Interior roomVillageExit1 = new Exit(roomHouse1);
        Interior roomVillageExit2 = new Exit(roomHouse2);
        Interior roomVillageExit3 = new Exit(roomHouse3);
        Npc mogens = new Npc("Mogens", true, 22201);
        mogens.addConversation("g");
        Interior roomVillageNPC = mogens;
        roomVillage.addMapInterior("house1", roomVillageExit1);
        roomVillage.addMapInterior("house2", roomVillageExit2);
        roomVillage.addMapInterior("house3", roomVillageExit3);
        roomVillage.addMapInterior("guard", roomVillageNPC);
        
        //roomHouse1
        Interior roomHouse1Exit = new Exit(roomVillage);
        Monster woman = new Monster("Woman", 1.0, 1.0, 50, 50);
        Interior roomHouse1Woman = woman;
        Interior roomHouse1Man = new UseableItem("Cheese sandwhich", 20, "Nom nom nom", "A dead man is half-sitting in a chair. In his pockets you find a cheese sandwhich.", 55501);
        roomHouse1.addMapInterior("woman", roomHouse1Woman);
        roomHouse1.addMapInterior("man", roomHouse1Man);
        roomHouse1.addMapInterior("door", roomHouse1Exit);
        
        //roomHouse2
        Interior roomHouse2Exit = new Exit(roomVillage);
        Interior roomHouse2Wardrobe = new EquippableItem("Dull Sword", 842,"Dull and a sword.",1.7,1.0, WEAPON_SLOT, "You find nothing of interest in the wardrobe. You tear open the sacks with your bare hands and cut your fingers on something. You lift up a dull but usable sword.", 33301); //Tag 10 skade
        Interior roomHouse2Bed = new QuestItem("Kids", 2, "Small and crying", 99902, "As you approach the bed, you hear muffled sniffling and crying, you quickly duck down and lift the duvey covers -  you find two children around the age of 10 and 7 huddled up tears on their cheecks.\n\"Please mister, don’t hurt us\" - you reassure the children that you are not going to hurt them, but taking them back to their father, the guard. ");
        Interior roomHouse2DarkCorner = new UseableItem("Cinnamon Roll",5,"Cinnamon roll with cinnamon", "As you approach the dark corner you fear the worst, but to your surprise you find a cinnamon roll on a shelf.", 55502);

        roomHouse2.addMapInterior("door", roomHouse2Exit);
        roomHouse2.addMapInterior("wardrobe", roomHouse2Wardrobe);
        roomHouse2.addMapInterior("bed", roomHouse2Bed);
        roomHouse2.addMapInterior("corner", roomHouse2DarkCorner);
        
        //roomHouse3
        Interior roomHouse3Exit = new Exit(roomVillage);
        Interior roomHouse3Kitchen = new UseableItem("Old rusty coin", 366, "It's old and rusty.", "The knives are all rusty and dull, you cant use them for anything, but you find a rusty coin stashed away in a secret compartment of the oven.", 55503);
        //Interior roomHouse3Bed = new PlayerHealth;
        Interior roomHouse3Chest = new EquippableItem("Old leather armor", 32819, "Quite fabulous", 1.0, 1.3, CHEST_SLOT, "There is a set of leather armor  in the chest, it's old and rusty but durable, you  put it on and it suits you surprisingly well.", 33302);
        roomHouse3.addMapInterior("door", roomHouse3Exit);
        roomHouse3.addMapInterior("kitchen", roomHouse3Kitchen);
        //roomHouse3.addMapInterior("Bed", roomHouse3Bed);
        roomHouse3.addMapInterior("chest", roomHouse3Chest);
        
        //roomForrest
        Interior roomForrestExit1 = new Exit(roomWizardHouse);
        Interior roomForrestExit2 = new Exit(roomCave);
        Interior roomForrestExit3 = new Exit(roomClearing);
        Interior roomForrestMushroom = new UseableItem("Mushroom", 286, "It stinks, but it might come in handy scaring off weaker foes.", "You go pick up a mushroom, it stinks, but it might come in handy scaring off weaker foes.", 55504);
        Interior roomForrestDeadGoblin = new EquippableItem("Handaxe", 293811, "Sturdy, and propably packs a punch.", 1.0, 0.0, WEAPON_SLOT, "You search the dead goblin. Its skin is charred from the wizards light magic and its black blood is slowly seeping out its mouth. You find 25 gold and a well kept short handaxe, its sturdy and probably packs quite a punch.", 55504);
        roomForest.addMapInterior("mushroom", roomForrestMushroom);
        roomForest.addMapInterior("goblin", roomForrestDeadGoblin);
        roomForest.addMapInterior("house", roomForrestExit1);
        roomForest.addMapInterior("cave", roomForrestExit2);
        roomForest.addMapInterior("clearing", roomForrestExit3);
        
        //roomWizardHouse
        Interior roomWizardHouseExit = new Exit(roomForest);
        Interior roomWizardHouseUpstairs = new UseableItem("Smooth ruby", 200, "A valueable stone.", "You check the wizards room for any valuables, find a piece of jewelry, and go downstairs again.", 55505);
        Interior roomWizardHouseBox = new UseableItem("Mysterious Ring",150,"Odd looking ring with a curiously intricate design, you decide to hold onto it.", "You rummage through the box of magical artifacts, and find a odd looking ring with a curiously intricate design, you decide to hold onto it.", 55506);
        Interior roomWizardHouseLab = new UseableItem("Health Potion",20,"Regenerates health points", "You search the alchemy lab and find a health potion.", 55507);
        Npc wizard = new Npc("Wizard", true, 22202);
        wizard.addConversation("g");
        Interior roomWizardHouseNPC = wizard;
        roomWizardHouse.addMapInterior("upstairs", roomWizardHouseUpstairs);
        roomWizardHouse.addMapInterior("box", roomWizardHouseBox);
        roomWizardHouse.addMapInterior("lab", roomWizardHouseLab);
        roomWizardHouse.addMapInterior("wizard", roomWizardHouseNPC);
        roomWizardHouse.addMapInterior("forest", roomWizardHouseExit);
        
        //roomCave
        Interior roomCaveExit1 = new Exit(roomForest);
        Interior roomCaveExit2 = new Exit(roomCaveGruul);
        Monster troll = new Monster("Troll", 1.0, 1.0, 50, 3000);
        Interior roomWizardHouseMonster1 = troll;
        Interior roomWizardHouseMonster2 = troll;
        Interior roomWizardHouseMonster3 = troll;
        roomCave.addMapInterior("troll1",roomWizardHouseMonster1);
        roomCave.addMapInterior("troll2",roomWizardHouseMonster2);
        roomCave.addMapInterior("troll3",roomWizardHouseMonster3);
        roomCave.addMapInterior("forest",roomCaveExit1);
        roomCave.addMapInterior("gruuls lair",roomCaveExit2);
        
        //roomCaveGrull
        Interior roomCaveGruulExit1 = new Exit(roomCave);
        Monster gruul = new Monster("Gruul", 1.8, 2.0, 100, 5);
        Interior roomCaveGruulMonster = gruul;
        roomCave.addMapInterior("gruul", roomCaveGruulMonster);
        roomCave.addMapInterior("cave", roomCaveGruulExit1);
        
        //roomClearing
        Interior roomClearingExit1 = new Exit(roomForest);
        Monster giant_troll_boss = new Monster("Humongous troll", 2.1, 1.5, 200, 100);
        Monster unicorn = new Monster("Unicorn", 1.6, 1.5, 400, 2000000000);
        Interior roomClearingMonster1 = unicorn;
        Interior roomClearingTree = new UseableItem("Doorknob", 0, "You don't have a door", "", 55508);
        Interior roomClearingBoss = giant_troll_boss;
        roomClearing.addMapInterior("troll", roomClearingBoss);
        roomClearing.addMapInterior("forest", roomClearingExit1);
        roomClearing.addMapInterior("unicorn", roomClearingMonster1);
        roomClearing.addMapInterior("Tree", roomClearingTree);
        
        
        //roomDungeon
        Interior roomDungeonExit = new Exit(roomLibrary);
        Interior roomDungeonSkeleton1 = new UseableItem("",0,"", "", 0);
        Interior roomDungeonSkeleton2 = new UseableItem("",0,"", "", 0);
        Interior roomDungeonSkeleton3 = new QuestItem("Broken handle",50,"Couldn't handle it", 99903, "");
        roomDungeon.addMapInterior("skeleton1", roomDungeonSkeleton1);
        roomDungeon.addMapInterior("skeleton2", roomDungeonSkeleton2);
        roomDungeon.addMapInterior("skeleton3", roomDungeonSkeleton3);
        roomDungeon.addMapInterior("pathway", roomDungeonExit);
        
        //roomLibrary
        Interior roomLibraryExit = new Exit(roomEvilWizardsLair);
        roomLibrary.addMapInterior("book on da shelf", roomLibraryExit);
        
        //roomEvilWizardsLair
        /*
        Interior roomEvilWizardsLairDevice = new OuchItem(TBA);
        Interior roomEvilWizardsLairDevice2 = new OuchItem(TBA);
        Monster evil_wizard_f_boss = new Monster("Evil wizard!!!!", 3.0, 3.0, 1, 900);
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
        HashMap<String, String> welcomeList = new HashMap();
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
        HashMap<String, String> helpList = new HashMap();
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
    public List<String> goTo(Command command){
        List<String> description = new ArrayList<>();
        if(!command.hasSecondWord()) {
            description.add("\"Go where?\"");
            return description;
        }
        // Create an object of klass Room and return if the exit is correct.
        Interior interior = currentRoom.getMapInterior(command.getSecondWord());
        // If the nextroom is null it means that there was no next room in that direction.
        if(interior == null) {
            description.add("Place doesn't exist.");
            return description;
        }else if(interior instanceof Exit){
            if(currentRoom == roomCellar){
                for(Item i: getInventoryItems()){
                    if(i instanceof QuestItem){
                        if(((QuestItem)i).getItemId() == 99901){
                            currentRoom = ((Exit)interior).getNewRoom();
                            description.add("You manage to pick the lock with the needle, but sadly the needle breaks and cannot be used later.");
                            player.removeInventoryItem(i);
                            description.add(currentRoom.getDescription());
                            return description;
                        }
                    }
                }
                description.add("A giant lock is on the door and it seems indestructible.");
                description.add("Some sort of lockpick would come in handy.");
                return description;
            }
            currentRoom = ((Exit)interior).getNewRoom();
            description.add(currentRoom.getDescription());
            return description;
        }else{
            description.add("Nothing here.");
            return description;
        }
    }
    
    public List<String> inspectThing(Command command){
        List<String> inspectActions = new ArrayList();
        if(!command.hasSecondWord()){
            inspectActions.add("Inspect what?");
            return inspectActions;
        }
        Interior interior = currentRoom.getMapInterior(command.getSecondWord());
        if(interior == null){
            inspectActions.add("This interior doesn't exist");
            return inspectActions;
        }
        else if(interior instanceof Item){
            if(interior instanceof EquippableItem){
                currentRoom.removeInterior(command.getSecondWord());
                player.addItemToEquippableInventory((EquippableItem)interior, player);
                inspectActions.add(((EquippableItem) interior).getRoomDescription());
                player.addHighscore(((EquippableItem) interior).getItemValue());
                return inspectActions;
            }
            else if(interior instanceof QuestItem){
                currentRoom.removeInterior(command.getSecondWord());
                player.addItemToInventory((Item)interior);
                inspectActions.add(((QuestItem) interior).getRoomDescription());
                player.addHighscore(((QuestItem) interior).getItemValue());
                return inspectActions;
            }
            else if(interior instanceof UseableItem){
                currentRoom.removeInterior(command.getSecondWord());
                player.addItemToInventory((Item)interior);
                inspectActions.add(((UseableItem) interior).getRoomDescription());
                player.addHighscore(((UseableItem) interior).getItemValue());
                return inspectActions;
            }
            else{
                inspectActions.add("mystery Item nothing happend");
                return inspectActions;
            }
        }
        else if(interior instanceof Npc){
            inspectActions.add("This is an Npc");
            switch(((Npc) interior).getNpcID()){
                case 22201:
                    for(Item i: getInventoryItems()){
                        if(i instanceof QuestItem){
                            if(((QuestItem)i).getItemId() == 99902){
                                inspectActions.add("You found my kids!?");
                                player.removeInventoryItem(i);
                                inspectActions.add("As a reword i let you pass to the forrest.");
                                Interior roomVillageExit4 = new Exit(roomForest);
                                roomVillage.addMapInterior("forest", roomVillageExit4);
                                return inspectActions;
                            }
                        }
                    }
                    inspectActions.add("Hello my name is " + ((Npc) interior).getName());
                    inspectActions.add("I cant find my kids anywhere, can you?");
                    break;
            }
            return inspectActions;
        }
        else if(interior instanceof Monster){
            Combat combat = new Combat(player, (Monster)interior);
            inspectActions.add("You found a monster! It's a " + ((Monster) interior).getMonsterName() + ".");
            for(Fight f : combat.AFight()){
                if(!f.isDone()){
                    inspectActions.add(f.toString());
                } else {
                    inspectActions.add(f.toString());
                    inspectActions.add("The winner of the fight is " + f.winner());
                }
            }
            if(player.getHealth() < 1){
                inspectActions.add("YOU DIED! You lost highscore points.");
                player.removeHighscore(69);
                player.setHealth(100);
            } else {
                for(Item i: combat.getMonster().getItemDrop()){
                    inspectActions.add("You got item " + i.getItemName());
                    player.addItemToInventory(i);
                }
                int goldDrop = combat.getMonster().getGoldDrop();
                inspectActions.add("You got " + goldDrop + " gold.");
                player.addGold(goldDrop);
                currentRoom.removeInterior(command.getSecondWord());
                inspectActions.add("Your remaining hp: " + player.getHealth());
            }
            return inspectActions;
        }
        else{
            inspectActions.add("Use \"Go to\" to go to an exit");
            return inspectActions;
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
    public HashMap<EquippableItem.EItem, EquippableItem> getEquippableItems(){
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
    
    public static List<String> getInventoryMenu(){
        List<String> menu = new ArrayList();
        menu.add("FULL INVENTORY");
        menu.add("EQUIPPED ITEMS");
        menu.add("QUEST ITEMS IN INVENTORY");
        menu.add("USEABLE ITEMS IN INVENTORY");
        menu.add("EQUIPPED ITEMS IN INVENTORY");
        menu.add("PLAYER STATS");
        return menu;
    }
    
     /**
     * 
     * @return 
     */
    public double getPlayerAtt(){
        return player.getAttValue();
    }
     /**
     * 
     * @return 
     */
    public double getPlayerDeff(){
        return player.getDefValue();
    }
    /**
     * 
     * @return 
     */
    public double getPlayerHealth(){
        return player.getHealth();
    }
    /**
     * 
     * @return 
     */
    public double getPlayerGold(){
        return player.getGold();
    }
    
}