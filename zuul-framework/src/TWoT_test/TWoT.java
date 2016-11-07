
// Use package zuulframework
package TWoT_test;

import static TWoT_test.EquippableItem.EItem.*;
import static TWoT_test.UseableItem.Usables.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TWoT implements Serializable{
    // Init variabels
    private Room currentRoom;
    private Player player;
    private Npc stranger = new Npc("Stranger", true, 22203);
    private long startTime;
    private boolean isOver;
    
    // Deffine rooms
    private Room roomCellar, roomVillage, roomHouse1, roomHouse2, roomHouse3, roomForest, roomWizardHouse, roomCave, roomCaveGruul, roomClearing, roomDungeon, roomLibrary, roomEvilWizardsLair;

    // Create the constructor for TWoT class
    public TWoT(){
        // Create the different rooms used
        createRooms();
        player = new Player("StartName", 1.0, 1.0, 100, new Inventory());
        startTime = (long)(System.currentTimeMillis() / 1000L);
    }
    public void testMatch(){
        player = new Player("Test player1", 2.0, 1.0, 100, new Inventory());
        Monster monster = new Monster("Test monster1", 1.0, 1.0, 100, 100, "Test monster");
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
                + "front of you an old door with a lock.");
        roomVillage = new Room("Village of Treldan", "\n\n***Village of Treldan*** \nIt’s dark outside. You seem to be familiar with this part of the village. "
                + "\nYou still wonder why you were locked up in that cell, but your thoughts are quickly interrupted "
                + "by a sobbing by the gate.\nA guard seems to be crying, and something doesn’t seem right in the "
                + "village. All houses seem to be empty and the doors are wide open.\nYou gasp as you see several "
                + "people lying dead in the side of the road.\nYou enter the town of Treldan.");
        roomHouse1 = new Room("House of the Reborn", "\n\n***House of the Reborn*** \nThe house you venture into is dark – very dark. It seems like "
                + "there is a man in a corner of the room close you and a woman in the other end of the room."
                + "\nYou enter the house.");
        roomHouse2 = new Room("House of Riches", "\n\n***House of Riches*** \n You use your bloody key to get in. This house is lit up by a "
                + "candle on the table.\nThere’s a blood-stained bed in the corner of the room. A bunch of sacks "
                + "are placed up against a poorly build wardrobe.\nThe other corner is not lit up by the candle and "
                + "you can’t see what is there.\nYou enter the house.");
        roomHouse3 = new Room("House of the Guard", "\n\n***House of the Guard*** \nThe door is barred from the inside, you jump through an open "
                + "window in the house, cutting yourself on a sharp piece of glass. You lose 5 HP.\nThe house is neatly "
                + "decorated, and the infected clearly havent been in here, in the left corner of the room there is "
                + "a dusty set of armor and lying in an open chest at the end of a double-bed.\nAdditionally, there "
                + "is also a small kitchen area with knives, pots, pans, and the like.\nYou enter the house.");
        roomForest = new Room("The Forest of Treldan", "\n\n***The Forest of Treldan*** \nAs you ride through the forest you are ambushed by a pack "
                + "of goblins who try to murder you and take your valuables.\nYou almost fall prey to the savages, "
                + "as you are saved by a wizard who zaps! the goblins with magic and scare them away.\nHe heals your "
                + "wounds and helps you back on your feet.\nYou thank the wizard and ask him if there is anything "
                + "you can do to repay him. Come meet me in my house when you're ready, its the Large Tree-house "
                + "over there.\nI have need of help in order to save Treldan! You enter the Forest of Treldan, you "
                + "scout around and look for anything, and spot a dead goblin and a couple of suspicious looking "
                + "mushrooms.");
        roomWizardHouse = new Room ("The Nice Wizard's House","\n\n***The Wizard's House*** \nThe wizard's house is better described as a hollow tree with doors "
                + "and windows, you can see a number of magical artifacts, a staircase to a upstairs part of the "
                + "house, there is also what looks to be an alchemy lab.\nThe wizard sits quietly in a comfy chair "
                + "with his legs up, snoring.");
        roomCave = new Room("Troll Cave", "\n\n***Troll Cave*** \nYou enter the troll cave, and immediately get sorrounded by 3 trolls,"
                + " one directly in fron of you, one to the left, and one to your right.\nIn the back "
                + "you can see a larger shadowy figure in the back of the cave, but you need to "
                + "get rid of the trolls to get to him first.");
        roomCaveGruul = new Room("Gruul's Lair","\n\n***Gruul's Lair*** \n You approach the shadowy figure and as you come closer, the giant troll rises"
                + " up, easily towering 2 meters above you, opens its mouth and roars fiercely at you.");
        roomClearing = new Room("Clearing of Unicorns", "***Clearing of Unicorns*** \nYou enter the clearing of unicorns and are immediately"
                + " blinded by a bright light.\nAs you regain your sight you lay eyes upon the most magnificent "
                + "create you have ever seen.\nThe unicorn looks at you curiously and goes back to eating grass. "
                + "\nYou scout the surrounding area for anything else, and spot an old tree.");
        roomDungeon = new Room("Dungeon of Suffering", "\n\n***Dungeon of Suffering*** \nA loud whoosh and you find yourself in some kind of dungeon "
                + "– probably the one belonging to the evil wizard of Treldan.\nYou realise you must be in his Tower."
                + "\nYou get up on your feet and sees that the room your in is barely lit by torches, the walls are "
                + "slimy and there are no windows. To no surprise you find three heavely armored skeletons.\nYou "
                + "sigh.");
        roomLibrary = new Room("The Neverending Library", "\n\n***The Neverending Library*** \nYou find yourself in the biggest room you’ve ever been "
                + "in. Books upon books is all you see, and bookcases fill up the gigantic room.\nIt would take ages "
                + "to go through every single book, you think to yourself. A librarian is sitting in the library.");
        roomEvilWizardsLair = new Room("The Evil Wizard's Lair", "\n\n***The Evil Wizard's Lair*** \nAs you ascend the stairs your legs feel heavier and "
                + "heavier.\nYou can barely walk as you make it up to the final step – the pain is then suddenly "
                + "relieved.\nYou open a large door and you see the Evil Wizard of Treldan standing in the room.");

        // roomCellar
        Interior roomCellarExit = new Exit(roomVillage);
        Interior roomCellarStick = new QuestItem("A needle", 1, "It was found in the haystack", 99901, "It must have been super uncomfortable laying on the haystack.\nYou search around the haystack and end up finding a strong needle. The needle has been added to your inventory.");
        Interior roomCellarCheeseSandwich = new UseableItem("Cheese sandwhich", 20, "Do you dare eat it?", "The table has several books and journals that are of no interest to you. In the drawer you find a cheese sandwich for eating.", 55501,FOOD);
        roomCellar.addMapInterior("door", roomCellarExit);
        roomCellar.addMapInterior("haystack", roomCellarStick);
        roomCellar.addMapInterior("table", roomCellarCheeseSandwich);
        

        //roomVillage
        Interior roomVillageExit1 = new Exit(roomHouse1);
        Interior roomVillageExit2 = new Exit(roomHouse2);
        Interior roomVillageExit3 = new Exit(roomHouse3);
        Interior roomVillageAxe = new QuestItem("Lumberjack axe", 1, "Could be useful later.", 99904, "You pickup the axe from the road.");
        Npc mogens = new Npc("Mogens", true, 22201);
        Interior roomVillageNPC = mogens;
        roomVillage.addMapInterior("house1", roomVillageExit1);
        roomVillage.addMapInterior("house2", roomVillageExit2);
        roomVillage.addMapInterior("house3", roomVillageExit3);
        roomVillage.addMapInterior("guard", roomVillageNPC);
        roomVillage.addMapInterior("axe", roomVillageAxe);
        
        //roomHouse1
        Interior roomHouse1Exit = new Exit(roomVillage);
        Interior roomHouse1Man = new Monster("Zombie man", 0.7, 0.7, 50, 50, "A dead man is half-sitting in a chair. He gets on his feet and attacks you.");
        Interior roomHouse1LooseStone = new UseableItem("Cheese sandwhich", 20, "Nom nom nom", "You move the loose stone and to your surprise you find a cheese sandwhich", 55501,FOOD);
        roomHouse1.addMapInterior("man", roomHouse1Man);
        roomHouse1.addMapInterior("stone", roomHouse1LooseStone);
        roomHouse1.addMapInterior("door", roomHouse1Exit);
        
        //roomHouse2
        Interior roomHouse2Exit = new Exit(roomVillage);
        Interior roomHouse2Wardrobe = new EquippableItem("Mega Sword", 842,"It looks mega.",2.1,1.0, WEAPON_SLOT, "You find nothing of interest in the wardrobe. You tear open the sacks with your bare hands and cut your fingers on something. You lift up a dull but usable sword.", 33301); //Tag 10 skade
        Interior roomHouse2Bed = new QuestItem("Kids", 2, "Small and crying", 99902, "As you approach the bed, you hear muffled sniffling and crying, you quickly duck down and lift the duvey covers -  you find two children around the age of 10 and 7 huddled up tears on their cheecks.\n\"Please mister, don’t hurt us\" - you reassure the children that you are not going to hurt them, but taking them back to their father, the guard. ");
        Interior roomHouse2DarkCorner = new UseableItem("Cinnamon Roll",5,"Cinnamon roll with cinnamon", "As you approach the dark corner you fear the worst, but to your surprise you find a cinnamon roll on a shelf.", 55502,FOOD);

        roomHouse2.addMapInterior("door", roomHouse2Exit);
        roomHouse2.addMapInterior("wardrobe", roomHouse2Wardrobe);
        roomHouse2.addMapInterior("bed", roomHouse2Bed);
        roomHouse2.addMapInterior("corner", roomHouse2DarkCorner);
        
        //roomHouse3
        Interior roomHouse3Exit = new Exit(roomVillage);
        Interior roomHouse3Kitchen = new UseableItem("Old rusty coin", 366, "It's old and rusty.", "The knives are all rusty and dull, you cant use them for anything, but you find a rusty coin stashed away in a secret compartment of the oven.", 55503,MAGIC_ITEM);
        Monster woman = new Monster("Woman", 1.0, 1.0, 50, 50, "The woman is lying on the floor but quickly gets up as you near her. You realize that the woman must be the guard’s wife. She seems furious, her face all molested – almost like a zombie. She charges at you.");
        Interior roomHouse3Woman = woman;
        woman.addDropItem(new QuestItem("Bloody key", 8273, "This key looks bloody", 99907, ""));
        Interior roomHouse3Chest = new EquippableItem("Old leather armor", 32819, "Quite fabulous", 1.0, 1.3, CHEST_SLOT, "There is a set of leather armor  in the chest, it's old and rusty but durable, you  put it on and it suits you surprisingly well.", 33302);
        roomHouse3.addMapInterior("door", roomHouse3Exit);
        roomHouse3.addMapInterior("woman", roomHouse3Woman);
        roomHouse3.addMapInterior("kitchen", roomHouse3Kitchen);
        roomHouse3.addMapInterior("chest", roomHouse3Chest);
        
        //roomForrest
        Interior roomForrestExit1 = new Exit(roomWizardHouse);
        Interior roomForrestExit2 = new Exit(roomCave);
        Interior roomForrestExit3 = new Exit(roomClearing);
        Interior roomForrestExit4 = new Exit(roomVillage);
        Interior roomForrestMushroom = new UseableItem("Mushroom", 286, "It stinks, but it might come in handy scaring off weaker foes.", "You go pick up a mushroom, it stinks, but it might come in handy scaring off weaker foes.", 55504,MAGIC_ITEM);
        Interior roomForrestDeadGoblin = new EquippableItem("Handaxe", 293811, "Sturdy, and propably packs a punch.", 1.0, 0.0, WEAPON_SLOT, "You search the dead goblin. Its skin is charred from the wizards light magic and its black blood is slowly seeping out its mouth. You find 25 gold and a well kept short handaxe, its sturdy and probably packs quite a punch.", 55504);
        roomForest.addMapInterior("mushroom", roomForrestMushroom);
        roomForest.addMapInterior("goblin", roomForrestDeadGoblin);
        roomForest.addMapInterior("house", roomForrestExit1);
        roomForest.addMapInterior("cave", roomForrestExit2);
        roomForest.addMapInterior("clearing", roomForrestExit3);
        roomForest.addMapInterior("village", roomForrestExit4);
        
        //roomWizardHouse
        Interior roomWizardHouseExit = new Exit(roomForest);
        Interior roomWizardHouseUpstairs = new UseableItem("Smooth ruby", 200, "A valueable stone.", "You check the wizards room for any valuables, find a piece of jewelry, and go downstairs again.", 55505,MAGIC_ITEM);
        Interior roomWizardHouseBox = new UseableItem("Mysterious Ring",150,"Odd looking ring with a curiously intricate design, you decide to hold onto it.", "You rummage through the box of magical artifacts, and find a odd looking ring with a curiously intricate design, you decide to hold onto it.", 55506,MAGIC_ITEM);
        Interior roomWizardHouseLab = new UseableItem("Health Potion",20,"Regenerates health points", "You search the alchemy lab and find a health potion.", 55507,FOOD);
        Npc wizard = new Npc("Wizard", true, 22202);
        Interior roomWizardHouseNPC = wizard;
        roomWizardHouse.addMapInterior("upstairs", roomWizardHouseUpstairs);
        roomWizardHouse.addMapInterior("box", roomWizardHouseBox);
        roomWizardHouse.addMapInterior("lab", roomWizardHouseLab);
        roomWizardHouse.addMapInterior("wizard", roomWizardHouseNPC);
        roomWizardHouse.addMapInterior("forest", roomWizardHouseExit);
        
        //roomCave
        Interior roomCaveExit1 = new Exit(roomForest);
        Interior roomCaveExit2 = new Exit(roomCaveGruul);
        Monster troll1 = new Monster("Nasty troll", 1.0, 1.0, 50, 3000, "The troll gets on its feet and starts attacking you.");
        Monster troll2 = new Monster("Ugly troll", 1.0, 1.0, 50, 3000, "The troll gets on its feet and starts attacking you.");
        Monster troll3 = new Monster("Beautifull troll", 1.0, 1.0, 50, 3000, "The troll gets on its feet and starts attacking you.");
        Interior roomWizardHouseMonster1 = troll1;
        Interior roomWizardHouseMonster2 = troll2;
        Interior roomWizardHouseMonster3 = troll3;
        roomCave.addMapInterior("troll1",roomWizardHouseMonster1);
        roomCave.addMapInterior("troll2",roomWizardHouseMonster2);
        roomCave.addMapInterior("troll3",roomWizardHouseMonster3);
        roomCave.addMapInterior("forest",roomCaveExit1);
        roomCave.addMapInterior("lair",roomCaveExit2);
        
        //roomCaveGrull
        Interior roomCaveGruulExit1 = new Exit(roomCave);
        Interior gruul = new Monster("Gruul", 1.8, 2.0, 100, 5, "You approach the shadowy figure and as you come closer, the giant troll it rises up, easily towering 2 meters above you, opens its mouth and roars fiercely at you.");
        ((Monster)gruul).addDropItem(new QuestItem("Magic staff", 700, "Magic staff the wizard told you to get", 99906, ""));
        roomCaveGruul.addMapInterior("gruul", gruul);
        roomCaveGruul.addMapInterior("cave", roomCaveGruulExit1);
        
        //roomClearing
        Interior roomClearingExit1 = new Exit(roomForest);
        Monster giant_troll_boss = new Monster("Humongous troll", 2.1, 1.5, 200, 100, "A humongous troll attacks you.");
        Monster unicorn = new Monster("Unicorn", 1.6, 1.5, 400, 200, "The unicorn doesent like you so it charges at you.");
        unicorn.addDropItem(new QuestItem("Vial of Rainbow", 1, "Vial of good", 99905, ""));
        Interior roomClearingMonster1 = unicorn;
        Interior roomClearingTree = new Npc("Old Tree", false, 22204);
        Interior roomClearingBoss = giant_troll_boss;
        roomClearing.addMapInterior("troll", roomClearingBoss);
        roomClearing.addMapInterior("forest", roomClearingExit1);
        roomClearing.addMapInterior("unicorn", roomClearingMonster1);
        roomClearing.addMapInterior("tree", roomClearingTree);
        
        
        //roomDungeon
        Interior roomDungeonExit = new Exit(roomLibrary);
        Monster skeleton1 = new Monster("Skeleton", 1.5, 1.5, 175, 300, "The skeleton attacks you.");
        Monster skeleton2 = new Monster("Skeleton", 1.5, 1.5, 175, 300, "The skeleton attacks you.");
        Monster skeleton3 = new Monster("Skeleton", 1.5, 1.5, 175, 300, "The skeleton attacks you.");
        roomDungeon.addMapInterior("skeleton1", skeleton1);
        roomDungeon.addMapInterior("skeleton2", skeleton2);
        roomDungeon.addMapInterior("skeleton3", skeleton3);
        skeleton2.addDropItem(new QuestItem("Broken handle", 545, "Couldn't handle it.", 99903, ""));
        roomDungeon.addMapInterior("pathway", roomDungeonExit);
        
        //roomLibrary
        Interior roomLibraryDoor = new Exit(roomEvilWizardsLair);
        Monster librarian = new Monster("Evil Librarian", 2.2, 2.0, 250, 500, "A librarian gets up from his seat - \"Hey, leave this place immdiately! You book is due!\".\nThe librarian starts throwing books at you. ");
        librarian.addDropItem(new EquippableItem("Fancy librarian-hotpants", 677, "These pants are pretty tight.", 0.0, 1.2, LEG_SLOT, "", 33304));
        roomLibrary.addMapInterior("librarian", librarian);
        roomLibrary.addMapInterior("door", roomLibraryDoor);
        
        //roomEvilWizardsLair
        
        Monster roomEvilWizardsLairWizard = new Monster("Evil Wizard of Doom", 2.5, 2.5, 800, 3500, "There's no turning back now, thief!\n Face me in a final battle!");
        roomEvilWizardsLairWizard.setMobId(1);
        roomEvilWizardsLair.addMapInterior("wizard", roomEvilWizardsLairWizard);
        
        
        //set which room you start in.
        currentRoom = roomCellar;
        currentRoom.setDescription(currentRoom.getDescription() + currentRoom.getMapInterior());
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
        helpList.put("helpMessage1",  "\nYou are at " + currentRoom.getName());
        helpList.put("helpMessage2", "Here is where you can go: " + currentRoom.getMapInterior());
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
        moveNpc();
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
                            description.add(currentRoom.getDescription() + currentRoom.getMapInterior());
                            return description;
                        }
                    }
                }
                description.add("A giant lock is on the door and it seems indestructible.");
                description.add("Some sort of lockpick would come in handy.");
                return description;
            }else if(currentRoom == roomCave){
                currentRoom.setDescription("***Troll Cave***\nThe place is still dark.");
                if(roomCave.getMapInterior("troll1") == null && roomCave.getMapInterior("troll2") == null && roomCave.getMapInterior("troll3") == null){
                    currentRoom = ((Exit)interior).getNewRoom();
                    description.add(currentRoom.getDescription() + currentRoom.getMapInterior());
                    return description;
                }else{
                    description.add("You have to defeat the 3 trolls to continue.");
                    return description;
                }
            }else if(currentRoom == roomVillage){
                currentRoom.setDescription("***Village of Treldan***\nThe village looks beautiful in the night.");
                if(command.getSecondWord().equals("house2")){
                    for(Item i: getInventoryItems()){
                        if(i instanceof QuestItem){
                            if(((QuestItem)i).getItemId() == 99907){
                                currentRoom = ((Exit)interior).getNewRoom();
                                description.add("You inserted the key, and the door unlocked.");
                                description.add(currentRoom.getDescription() + currentRoom.getMapInterior());
                                return description;
                            }
                        }
                    }
                    description.add("The door's locked, maybe a key's lying around.");
                    return description;
                }
            }else if(currentRoom == roomHouse1){
                currentRoom.setDescription("***House of the Reborn***\nThe house looks spooky.");
            }else if(currentRoom == roomHouse2){
                currentRoom.setDescription("***House of Riches***\nThe house looks creepy.");
            }else if(currentRoom == roomHouse3){
                currentRoom.setDescription("***House of the Guard***\nThe house looks cozy.");
            }else if(currentRoom == roomForest){
                currentRoom.setDescription("***The Forest of Treldan***\nThe forest is much more quiet than before.");
            }else if(currentRoom == roomWizardHouse){
                currentRoom.setDescription("***The Nice Wizard's House***\nThe wizard's house is wierd but nice.");
            }else if(currentRoom == roomCaveGruul){
                currentRoom.setDescription("***Gruul's Lair**\nThe cave where Gruul lives.");
            }else if(currentRoom == roomClearing){
                currentRoom.setDescription("***Clearing of Unicorns***\nFor some reason the sun shines bright in the clearing.");
            }else if(currentRoom == roomDungeon){
                currentRoom.setDescription("***Dungeon of Suffering***\nYou wouldn't like to live here.");
                if(roomDungeon.getMapInterior("skeleton1") == null && roomDungeon.getMapInterior("skeleton2") == null && roomDungeon.getMapInterior("skeleton3") == null){
                    currentRoom = ((Exit)interior).getNewRoom();
                    description.add(currentRoom.getDescription() + currentRoom.getMapInterior());
                    return description;
                }else{
                    description.add("You have to defeat the 3 skeleton to continue.");
                    return description;
                }
            }else if(currentRoom == roomLibrary){
                currentRoom.setDescription("***The Neverending Library***\nThere's still a trillion books in the library.");
                 if(command.getSecondWord().equals("door")){
                    for(Item i: getInventoryItems()){
                        if(i instanceof QuestItem){
                            if(((QuestItem)i).getItemId() == 99903){
                                currentRoom = ((Exit)interior).getNewRoom();
                                description.add("You attach the broken handle to the door and it will now open,");
                                description.add(currentRoom.getDescription() + currentRoom.getMapInterior());
                                return description;
                            }
                        }
                    }
                    description.add("The door's handle is broken.");
                    return description;
                }
            }
            currentRoom = ((Exit)interior).getNewRoom();
            description.add(currentRoom.getDescription() + currentRoom.getMapInterior());
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
            switch(((Npc) interior).getNpcID()){
                case 22201:
                    for(Item i: getInventoryItems()){
                        if(i instanceof QuestItem){
                            if(((QuestItem)i).getItemId() == 99902){
                                inspectActions.add("Thank you, thank you so much, i dont know what I would do without them \"Please, leave the village with us, this place is lost to 	the undead anyway, nothing is left for the living\" You exit the village through the back gate and 'aquire' a horse from the stables nearby and ride it to the forest of Treldan where your hideout is.");
                                player.removeInventoryItem(i);
                                Interior roomVillageExit4 = new Exit(roomForest);
                                roomVillage.addMapInterior("forest", roomVillageExit4);
                                return inspectActions;
                            }
                        }
                    }
                    inspectActions.add("The guard stops his sobbing as you near him. “Who’s there?!” he yells. You decide not to reveal your identity, and the guard continues: ”Oh, why does it matter? I’ll letout of the Treldan if you find my wife and kids. I have orders to stay at my post.” The guard sits down and continues his sobbing.");
                    break;
                case 22202:
                    Item item1 = null;
                    Item item2 = null;
                    for(Item i: getInventoryItems()){
                        if(i instanceof QuestItem){
                            if(((QuestItem)i).getItemId() == 99905){
                                item1 = i;
                            } else if(((QuestItem)i).getItemId() == 99906){
                                item2 = i;
                            }
                        }
                    }
                    if(item1 != null && item2 != null){
                        inspectActions.add("Thank you for bringing me the items the I asked for! Go find the stranger in the village. He is known for hiding in the houses or the village. He may move his position.");
                        player.removeInventoryItem(item1);
                        player.removeInventoryItem(item2);
                        roomVillage.addMapInterior("stranger", stranger);
                    }else{
                        inspectActions.add("zzzzzzzzzzzzzzzz\" You wake up the wizard \"zzz..oo.ahwhat? who? oh it's you traveler, thank you for coming to see me. As i mentioned i have need of help to defeat the evil Wizard, first of all i can't get inside his evil castle, buta stranger in the village will be able to teleport you inside if you want to help me, but the evil troll Gruul has taken my magic staff, so go get that for me! He's inside his lair in the forest. Additionally I need some liquid rainbow that is inside the heart of a unicorn, go kill one in the clearing nearby.");
                    }
                    break;
                
                case 22203:
                    inspectActions.add("The wizard told me to teleport you to the evil wizard's tower of doom. Get ready.");
                    currentRoom = roomDungeon;
                    inspectActions.add(currentRoom.getDescription() + currentRoom.getMapInterior());
                    break;
                case 22204:
                    for(Item i: getInventoryItems()){
                        if(i instanceof QuestItem){
                            if(((QuestItem)i).getItemId() == 99904){
                                inspectActions.add("You hack at the old tree for a while and finally it snaps in half, and tilts inwards towards the unicorn, who sadly, but fortunately for you doesn’t react in time and gets smashed by the tree");
                                ((Monster)roomClearing.getMapInterior("unicorn")).setRoomDescription("The tree that fell on the unicorn exposes the unicorns heart and innards. You finish the unicorn off and hold out a vial and watch in marvel as the liquid rainbow gathers in it");
                                ((Monster)roomClearing.getMapInterior("unicorn")).setHealth(1);
                                ((Monster)roomClearing.getMapInterior("unicorn")).setAttValue(0.1);
                                ((Monster)roomClearing.getMapInterior("unicorn")).setDefValue(0.1);
                                player.addHighscore(1000);
                                return inspectActions;
                            }
                        }
                    }
                    inspectActions.add("You approach the old tree, it looks like it can be cut down fairly easily with 	the right tool");
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
                if(((Monster) interior).getMobId() == 1){
                    isOver = true;
                }
            }
            return inspectActions;
        }
        else{
            inspectActions.add("Use \"go\" to go to an exit");
            return inspectActions;
        }
    }
    
    public List<String> useItem(Command command){
        List<String> use = new ArrayList();
        boolean check = false;
        Item usedItem = null;
        for (Item i : getInventoryItems()) {
            if (i instanceof UseableItem) {
                if (i.getItemName().equals(command.getSecondWord())) {

                    int itemID = i.getItemId();  

                    switch(itemID){
                        case 55501: //cheese sandwhich
                            if(getPlayerHealth() != 100){
                                use.add("You used " + i.getItemName() + " and regenerated " + ((UseableItem) i).getHealthRegen() + " hp back.");
                                playerRegenHealth(((UseableItem) i).getHealthRegen());

                            }else{
                                use.add("You're already at full health");
                            }
                            break;
                            
                        case 55502: //cinnamon roll
                            if(getPlayerHealth() != 100){
                                use.add("You used " + i.getItemName() + " and regenerated " + ((UseableItem) i).getHealthRegen() + " hp back.");
                                playerRegenHealth(((UseableItem) i).getHealthRegen());
                            }else{
                                use.add("You're already at full health");
                            }
                            break;
                            
                        case 55503: //old rusty coin
                            use.add("Old dusty coin, not good for anything except highscore");
                            break;
                                
                        case 55504: //mushroom
                            if(currentRoom.equals(roomCave)){
                                currentRoom.removeInterior("troll1");
                                currentRoom.removeInterior("troll2");
                                currentRoom.removeInterior("troll3");
                                use.add("The stinking mushroom scares off the trolls and they flee out the cave");

                            } else {
                                use.add("Can't use that here");
                            }

                        case 55505: //smooth ruby
                            use.add("A smooth looking ruby");
                            break;
                            
                        case 55506: //mysterius ring
                            use.add("You examine the ring, and suddenly a bright light shines out, and you ");
                            currentRoom = roomVillage;
                            break;
                            
                        case 55507: //health potion
                            if(getPlayerHealth() != 100){
                                use.add("You used " + i.getItemName() + " and regenerated " + ((UseableItem) i).getHealthRegen() + " hp back.");
                                playerRegenHealth(((UseableItem) i).getHealthRegen());
                            }else{
                                use.add("You're already at full health");
                            }
                            break;
                            
                        default:

                    }

                    usedItem = i;
                    check = true;
                }
            }
        }
        if(usedItem != null){
            removeItemFromInventory(usedItem);
        }
        if(!check){
            use.add("You carry no item with that name");
        }
    
    return use;
}
    
    
    
    
    
    /**
     * 
     * @return 
     */
    public List<Item> getInventoryItems(){
        return player.getInventoryItems();
    }
    
    public void removeItemFromInventory(Item i){
        player.removeInventoryItem(i);
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
    
    public void writeHighScore() {
        long endTime = (System.currentTimeMillis() / 1000L);
        
          try (FileWriter fw = new FileWriter("Highscore.txt", true);
          BufferedWriter bw = new BufferedWriter(fw);
          PrintWriter out = new PrintWriter(bw)) {
              
                out.println(player.getPlayerName() + ":" + player.getHighscore() + ":" + (endTime - startTime));
    
          } catch (IOException e) {
                System.out.println("Error at writing to Highscore.txt" + e);
        } 
    }
    
    public List<Score> readHighScore() {
        List <Score> scoreList = new ArrayList();
        try  {
            for (String line : Files.readAllLines(Paths.get("Highscore.txt"))) {
                 String playerName = Arrays.asList(line.split(":")).get(0);
                 int playerScore = Integer.parseInt(Arrays.asList(line.split(":")).get(1));
                 int playerTime = Integer.parseInt(Arrays.asList(line.split(":")).get(2));
                 scoreList.add(new Score(
                         playerName, 
                         playerScore, 
                         playerTime));
            }
        } catch (IOException e){
                
        }
        return scoreList;
    }
    
    /**
     * 
     * @return 
     */
    public static List<String> getMenuSelections(){
        List<String> menu = new ArrayList();
        menu.add("NEW GAME ");
        menu.add("LOAD GAME");
        menu.add("HOW TO PLAY");
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
    
    public void moveNpc(){
        if(roomVillage.getMapInterior("stranger") != null){
            roomVillage.removeInterior("stranger");
            roomHouse1.addMapInterior("stranger", stranger);
        } else if(roomHouse1.getMapInterior("stranger") != null){
            roomHouse1.removeInterior("stranger");
            roomHouse2.addMapInterior("stranger", stranger);
        }else if(roomHouse2.getMapInterior("stranger") != null){
            roomHouse2.removeInterior("stranger");
            roomHouse3.addMapInterior("stranger", stranger);
        }else if(roomHouse3.getMapInterior("stranger") != null){
            roomHouse3.removeInterior("stranger");
            roomHouse1.addMapInterior("stranger", stranger);
        }
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
    public void playerRegenHealth(int healthToRegen){
        player.regenHealth(healthToRegen);
    }

    /**
     * @return the isOver
     */
    public boolean isIsOver() {
        return isOver;
    }
}
