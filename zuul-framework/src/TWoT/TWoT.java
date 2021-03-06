// Use package zuulframework
package TWoT;

import static TWoT.EquippableItem.EItem.AMULET_SLOT;
import static TWoT.EquippableItem.EItem.BOOT_SLOT;
import static TWoT.EquippableItem.EItem.CHEST_SLOT;
import static TWoT.EquippableItem.EItem.GLOVES_SLOT;
import static TWoT.EquippableItem.EItem.HEAD_SLOT;
import static TWoT.EquippableItem.EItem.LEG_SLOT;
import static TWoT.EquippableItem.EItem.WEAPON_SLOT;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TWoT implements Serializable {

    // Init variabels
    private Room currentRoom;
    private int lastRoomId;
    private Player player;
    private Npc stranger = new Npc("Stranger", 22203);
    private long startTime;
    private boolean isOver;
    private static final long serialVersionUID = 6L;
    // Deffine rooms
    private Room roomCellar, roomVillage, roomHouse1, roomHouse2, roomHouse3, roomForest, roomWizardHouse, roomCave, roomCaveGruul, roomClearing, roomDungeon, roomLibrary, roomEvilWizardsLair;

    /**
     * Create the constructor for TWoT class
     */
    public TWoT() {
        // Create the different rooms used
        createRooms();
        player = new Player("StartName", 1.0, 1.0, 100, new Inventory());
        startTime = (long) (System.currentTimeMillis() / 1000L);
        player.addItemToEquippableInventory(new EquippableItem("Dagger", 291, "Small dagger.", 0.2, 0.0, WEAPON_SLOT, "", 33305), player);
        player.addItemToEquippableInventory(new EquippableItem("Tattered Shirt", 291, "Smells awful.", 0.0, 0.2, CHEST_SLOT, "", 33306), player);
        player.addItemToEquippableInventory(new EquippableItem("Tattered Pants", 291, "Uncomfortable to wear.", 0.0, 0.1, LEG_SLOT, "", 33307), player);
    }

    /**
     * Creates all the rooms in the game.
     */
    private void createRooms() {
        roomCellar = new Room("Cellar", "***Cellar*** \nYou wake up in a dull cellar. Light is emitting from a torch on the wall "
                + "and you barely get on your feet.\nYou’ve been laying on a haystack for God knows how long and "
                + "your feet are extremely sore.", 1);
        roomVillage = new Room("Village of Treldan", "***Village of Treldan*** \nIt’s dark outside. You seem to be familiar with this part of the village. "
                + "\nYou still wonder why you were locked up in that cell, but your thoughts are quickly interrupted "
                + "by a sobbing by the gate.\nA guard seems to be crying, and something doesn’t seem right in the "
                + "village. \nYou gasp as you see several people lying dead in the side of the road.", 2);
        roomHouse1 = new Room("House of the Reborn", "***House of the Reborn*** \nYou slightly regret entering as you see a skeleton as soon as you enter the house", 3);
        roomHouse2 = new Room("House of Riches", "***House of Riches*** \nYou use your bloody key to get in. Now it's time to save those kids", 4);
        roomHouse3 = new Room("House of the Guard", "***House of the Guard*** \nThe interior of the house looks normal, but at the back of the house "
                + "you see a woman that doesn't look like she is in her right mind.", 5);
        roomForest = new Room("The Forest of Treldan", "***The Forest of Treldan*** \nYou see a lot of different paths as soon as you enter the forest."
                + " It might be a good idea to enter the house to find out what is happening.", 6);
        roomWizardHouse = new Room("The Nice Wizard's House", "***The Wizard's House*** \nYou enter the wizards house and see him in "
                + "the far corner by his bed. There are multiple places in the house where you might find goods to help you on your journey.", 7);
        roomCave = new Room("Troll Cave", "***Troll Cave*** \nAs soon as you enter the cave you notice three golems standing by a bigger entrance. ", 8);
        roomCaveGruul = new Room("Gruul's Lair", "***Gruul's Lair*** \nThis must be the Gruul the wizard was talking about. I have to get that staff of his.", 9);
        roomClearing = new Room("Clearing of Unicorns", "***Clearing of Unicorns*** \nYou enter the clearing of unicorns and are immediately"
                + " blinded by a bright light.\nAs you regain your sight you lay eyes upon the most magnificent "
                + "create you have ever seen."
                + "\nYou scout the surrounding area for anything else, and spot an old tree.", 10);
        roomDungeon = new Room("Dungeon of Suffering", "***Dungeon of Suffering*** \nA loud whoosh and you find yourself in some kind of dungeon "
                + "– probably the one belonging to the evil wizard of Treldan.\nYou realise you must be in his Tower."
                + "\nTo no surprise you find three skeletons.\nYou sigh.", 11);
        roomLibrary = new Room("The Neverending Library", "***The Neverending Library*** \nBooks upon books is all you see, and bookcases fill up the gigantic room.\nIt would take ages "
                + "to go through every single book, you think to yourself. A librarian is sitting in the library.", 12);
        roomEvilWizardsLair = new Room("The Evil Wizard's Lair", "***The Evil Wizard's Lair*** \nYou open a large door and you see the Evil Wizard of Treldan standing in the room.", 13);

        // <editor-fold defaultstate="collapsed" desc=" Creating Interior for rooms ">
        // roomCellar
        Interior roomCellarExit = new Exit(roomVillage);
        Interior roomCellarStick = new QuestItem("A needle", 1, "Can be used to lockpick doors", 99901, "It must have been super uncomfortable laying on the haystack.\nYou search around the haystack and end up finding a strong needle. The needle has been added to your inventory.");
        Interior roomCellarCheeseSandwich = new UseableItem("Cheese sandwich", 20, "Do you dare eat it?", "You find a cheese sandwich on the table", 55501, 50);
        roomCellar.addMapInterior("door", roomCellarExit);
        roomCellar.addMapInterior("haystack", roomCellarStick);
        roomCellar.addMapInterior("table", roomCellarCheeseSandwich);

        //roomVillage
        Interior roomVillageExit1 = new Exit(roomHouse1);
        Interior roomVillageExit2 = new Exit(roomHouse2);
        Interior roomVillageExit3 = new Exit(roomHouse3);
        Interior roomVillageAxe = new QuestItem("Lumberjack axe", 1, "Could be useful for cutting old trees down.", 99904, "You pickup the axe from the road.");
        Npc mogens = new Npc("Mogens", 22201);
        Interior roomVillageNPC = mogens;
        roomVillage.addMapInterior("house1", roomVillageExit1);
        roomVillage.addMapInterior("house2", roomVillageExit2);
        roomVillage.addMapInterior("house3", roomVillageExit3);
        roomVillage.addMapInterior("guard", roomVillageNPC);
        roomVillage.addMapInterior("axe", roomVillageAxe);

        //roomHouse1
        Interior roomHouse1Exit = new Exit(roomVillage);
        Monster zombie = new Monster("Living Skeleton", 0.7, 0.7, 50, 50, "A skeleton attacks you, defend yourself!");
        Interior roomHouse1Man = zombie;
        zombie.addDropItem(new EquippableItem("Amulet of Protection", 465, "Cold to the touch", 0.4, 0.4, AMULET_SLOT, "", 33308));
        Interior roomHouse1Chest = new UseableItem("Health Potion", 20, "Refreshing", "You search the chest and pick up at health potion", 55508, 50);
        roomHouse1.addMapInterior("man", roomHouse1Man);
        roomHouse1.addMapInterior("chest", roomHouse1Chest);
        roomHouse1.addMapInterior("door", roomHouse1Exit);

        //roomHouse2
        Interior roomHouse2Exit = new Exit(roomVillage);
        Interior roomHouse2Wardrobe = new EquippableItem("Mega Sword", 342, "It looks mega.", 1.9, 0.0, WEAPON_SLOT, "You find nothing of interest in the wardrobe. You tear open the sacks with your bare hands and cut your fingers on something. A sword.", 33301);
        Interior roomHouse2Bed = new QuestItem("Kids", 2, "The kids of the guard in the village", 99902, "As you approach the bed, you hear muffled sniffling and crying, you quickly duck down and lift the duvey covers -  you find two children around the age of 10 "
                + "and 7 huddled up tears on their cheecks.\n\"Please mister, don’t hurt us\" - you reassure the children that you are not going to hurt them, but taking them back to their father, the guard. ");
        Interior roomHouse2Table = new UseableItem("Cinnamon Roll", 5, "Cinnamon roll", "As you approach the dark corner you fear the worst, but to your surprise you find a cinnamon roll on a shelf.", 55502, 50);

        roomHouse2.addMapInterior("door", roomHouse2Exit);
        roomHouse2.addMapInterior("wardrobe", roomHouse2Wardrobe);
        roomHouse2.addMapInterior("bed", roomHouse2Bed);
        roomHouse2.addMapInterior("table", roomHouse2Table);

        //roomHouse3
        Interior roomHouse3Exit = new Exit(roomVillage);
        Interior roomHouse3Kitchen = new UseableItem("Old rusty coin", 366, "It's old and rusty.", "The knives are all rusty and dull, you cant use them for anything, but you find a rusty coin stashed away in a secret compartment of the oven.", 55503, 0);
        Monster woman = new Monster("Woman", 1.0, 1.0, 50, 50, "The woman must be the guards wife, she has gone mad.");
        Interior roomHouse3Woman = woman;
        woman.addDropItem(new QuestItem("Bloody key", 83, "Used to unlock a house in the village of treldan", 99907, ""));
        Interior roomHouse3Chest = new EquippableItem("Old leather armor", 329, "Quite fabulous", 0, 1.3, CHEST_SLOT, "There is a set of leather armor  in the chest, it's old and rusty but durable, you  put it on and it suits you surprisingly well.", 33302);
        roomHouse3.addMapInterior("door", roomHouse3Exit);
        roomHouse3.addMapInterior("woman", roomHouse3Woman);
        roomHouse3.addMapInterior("kitchen", roomHouse3Kitchen);
        roomHouse3.addMapInterior("chest", roomHouse3Chest);

        //roomForest
        Interior roomForestExit1 = new Exit(roomWizardHouse);
        Interior roomForestExit2 = new Exit(roomCave);
        Interior roomForestExit3 = new Exit(roomClearing);
        Interior roomForestExit4 = new Exit(roomVillage);
        Interior roomForestMushroom = new UseableItem("Mushroom", 286, "", "You go pick up a mushroom", 55504, 0);
        Interior roomForestDeadGoblin = new EquippableItem("Handaxe", 291, "Sturdy, and propably packs a punch.", 1.9, 0.0, WEAPON_SLOT, "You search the dead goblin. Its skin is charred from the wizards light magic and its black blood is slowly seeping out its mouth."
                + " You a well kept short handaxe, its sturdy and probably packs quite a punch.", 55504);
        roomForest.addMapInterior("mushroom", roomForestMushroom);
        roomForest.addMapInterior("goblin", roomForestDeadGoblin);
        roomForest.addMapInterior("house", roomForestExit1);
        roomForest.addMapInterior("cave", roomForestExit2);
        roomForest.addMapInterior("clearing", roomForestExit3);
        roomForest.addMapInterior("village", roomForestExit4);

        //roomWizardHouse
        Interior roomWizardHouseExit = new Exit(roomForest);
        Interior roomWizardHouseUpstairs = new UseableItem("Smooth ruby", 200, "A valueable stone.", "You check the sacks in the wizards house and find a piece of jewelry", 55505, 0);
        Interior roomWizardHouseBox = new UseableItem("Mysterious Ring", 150, "Odd looking ring with a curiously intricate design, you decide to hold onto it.", "You rummage through the box of magical artifacts, and find a odd looking ring with a curiously intricate design,"
                + " you decide to hold onto it.", 55506, 0);
        Interior roomWizardHouseLab = new UseableItem("Health Potion", 20, "Regenerates health points", "You search the alchemy lab and find a health potion.", 55507, 50);
        Npc wizard = new Npc("Wizard", 22202);
        Interior roomWizardHouseNPC = wizard;
        roomWizardHouse.addMapInterior("upstairs", roomWizardHouseUpstairs);
        roomWizardHouse.addMapInterior("box", roomWizardHouseBox);
        roomWizardHouse.addMapInterior("lab", roomWizardHouseLab);
        roomWizardHouse.addMapInterior("wizard", roomWizardHouseNPC);
        roomWizardHouse.addMapInterior("door", roomWizardHouseExit);

        //roomCave
        Interior roomCaveExit1 = new Exit(roomForest);
        Interior roomCaveExit2 = new Exit(roomCaveGruul);
        Monster troll1 = new Monster("Nasty troll", 1.0, 1.0, 50, 3000, "Defend yourself against this savage monstrosity");
        Monster troll2 = new Monster("Ugly troll", 1.0, 1.0, 50, 3000, "Defend yourself against this savage monstrosity");
        Monster troll3 = new Monster("Beautifull troll", 1.0, 1.0, 50, 3000, "Defend yourself against this savage monstrosity");
        Interior roomWizardHouseMonster1 = troll1;
        Interior roomWizardHouseMonster2 = troll2;
        Interior roomWizardHouseMonster3 = troll3;
        troll1.addDropItem(new EquippableItem("Troll Helmet", 298, "It's way too big for you.", 0.0, 1.1, HEAD_SLOT, "", 33309));
        troll2.addDropItem(new UseableItem("Health Potion", 20, "Regenerates health points", "", 55507, 50));
        troll3.addDropItem(new EquippableItem("Spurs of Speed", 296, "Fast and furious.", 0.0, 0.6, BOOT_SLOT, "", 33310));
        roomCave.addMapInterior("troll1", roomWizardHouseMonster1);
        roomCave.addMapInterior("troll2", roomWizardHouseMonster2);
        roomCave.addMapInterior("troll3", roomWizardHouseMonster3);
        roomCave.addMapInterior("forest", roomCaveExit1);
        roomCave.addMapInterior("lair", roomCaveExit2);

        //roomCaveGrull
        Interior roomCaveGruulExit1 = new Exit(roomCave);
        Interior gruul = new Monster("Gruul", 1.8, 2.0, 100, 5, "An even bigger golem stands before you. Slay it.");
        ((Monster) gruul).addDropItem(new QuestItem("Magic staff", 100, "The Magic staff the wizard told you to get", 99906, ""));
        ((Monster) gruul).addDropItem(new EquippableItem("Gruul's Giant Club", 230, "Huge club.", 2.6, 0.0, WEAPON_SLOT, "", 33311));
        roomCaveGruul.addMapInterior("gruul", gruul);
        roomCaveGruul.addMapInterior("cave", roomCaveGruulExit1);

        //roomClearing
        Interior roomClearingExit1 = new Exit(roomForest);
        Monster unicorn = new Monster("Unicorn", 1.6, 1.5, 400, 200, "The unicorn charges at you.");
        unicorn.addDropItem(new QuestItem("Vial of Rainbow", 1, "Vial of rainbow the wizard told you to get", 99905, ""));
        unicorn.addDropItem(new UseableItem("Health Potion", 20, "Regenerates health points", "", 55507, 50));
        unicorn.addDropItem(new UseableItem("Health Potion", 20, "Regenerates health points", "", 55507, 50));
        unicorn.addDropItem(new UseableItem("Health Potion", 20, "Regenerates health points", "", 55507, 50));
        unicorn.addDropItem(new UseableItem("Health Potion", 20, "Regenerates health points", "", 55507, 50));
        unicorn.addDropItem(new UseableItem("Health Potion", 20, "Regenerates health points", "", 55507, 50));
        Interior roomClearingMonster1 = unicorn;
        Interior roomClearingTree = new Npc("Old Tree", 22204);
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
        skeleton1.addDropItem(new UseableItem("Health Potion", 20, "Regenerates health points", "", 55507, 50));
        skeleton3.addDropItem(new EquippableItem("Giant's Gloves", 234, "You could fit two hands in one of these.", 0.0, 0.5, GLOVES_SLOT, "", 33312));
        roomDungeon.addMapInterior("pathway", roomDungeonExit);

        //roomLibrary
        Interior roomLibraryDoor = new Exit(roomEvilWizardsLair);
        Monster librarian = new Monster("Evil Librarian", 2.2, 2.0, 250, 500, "A lonely and aggressive librarian attacks you.");
        librarian.addDropItem(new EquippableItem("Fancy librarian-hotpants", 477, "These pants are pretty tight.", 0.0, 1.2, LEG_SLOT, "", 33304));
        librarian.addDropItem(new QuestItem("Broken handle", 545, "Opens the door in the library", 99903, ""));
        Interior roomLibraryChest = new UseableItem("Health Potion", 20, "Regenerates health points", "You search the chest and find a health potion", 55507, 50);
        roomLibrary.addMapInterior("librarian", librarian);
        roomLibrary.addMapInterior("door", roomLibraryDoor);
        roomLibrary.addMapInterior("chest", roomLibraryChest);

        //roomEvilWizardsLair
        Monster roomEvilWizardsLairWizard = new Monster("Evil Wizard of Doom", 2.5, 2.5, 800, 3500, "There's no turning back now, thief!\n Face me in a final battle!");
        Monster roomEvilWizardsLairMinion1 = new Monster("Minion of the evil Wizard", 1.5, 1.5, 400, 1500, "*horrible noises*");
        Monster roomEvilWizardsLairMinion2 = new Monster("Minion of the evil Wizard", 1.5, 1.5, 400, 1500, "*horrible screams*");
        roomEvilWizardsLairWizard.setMobId(1);
        roomEvilWizardsLairMinion1.setMobId(2);
        roomEvilWizardsLairMinion2.setMobId(3);
        roomEvilWizardsLair.addMapInterior("wizard", roomEvilWizardsLairWizard);
        roomEvilWizardsLair.addMapInterior("minion1", roomEvilWizardsLairMinion1);
        roomEvilWizardsLair.addMapInterior("minion2", roomEvilWizardsLairMinion2);

        // </editor-fold>
        //set which room you start in.
        currentRoom = roomCellar;
        lastRoomId = currentRoom.getRoomId();
        currentRoom.setDescription(currentRoom.getDescription() + currentRoom.getMapInterior());
    }

    /**
     * Return the WelcomeMessage hashmap which contains the welcome messages.
     * The keys are: 1, 2, 3
     *
     * @return Hashmap Integer String
     */
    public HashMap<Integer, String> getWelcomeMessages() {
        HashMap<Integer, String> welcomeList = new HashMap();
        welcomeList.put(1, "Welcome to The Wizard of Treldan!\n");
        welcomeList.put(2, "The Wizard of Treldan is a new, incredibly boring adventure game.\n\n");
        welcomeList.put(3, currentRoom.getDescription());
        return welcomeList;
    }

    /**
     * Return the HelpMessage hashmap which contains the help messages. The keys
     * are: helpMessage1 helpMessage2 helpMessage3
     *
     * @return Hashmap of String, String
     */
    public HashMap<String, String> getHelpMessages() {
        //init a new object of type hashmap
        HashMap<String, String> helpList = new HashMap();
        helpList.put("helpMessage1", "\nYou are at " + currentRoom.getName() + "\n");
        helpList.put("helpMessage2", currentRoom.getMapInterior() + "\n");
        helpList.put("helpMessage3", "You can type 'go [interactable object]' to move around in rooms.");

        //return the helplist when done.
        return helpList;
    }

    /**
     * Check if the interior is in the map
     *
     * @param direction the direction we wanna check
     * @return boolean if there is an interior.
     */
    public boolean checkExisting(String direction) {
        // Create an object of klass Room and return if the exit is correct.
        Interior interior = currentRoom.getMapInterior(direction);
        // If the nextroom is null it means that there was no next room in that direction.
        if (interior == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Go to the desired room defined from the command param.
     *
     * @param command the command to use
     * @return list of string of what happened.
     */
    public List<String> goTo(Command command) {

        List<String> description = new ArrayList<>();
        if (!command.hasSecondWord()) {
            description.add("\"Go where?\"");
            return description;
        }
        // Create an object of klass Room and return if the exit is correct.
        Interior interior = currentRoom.getMapInterior(command.getSecondWord());
        // If the nextroom is null it means that there was no next room in that direction.
        if (interior == null) {
            description.add("Nothing here.");
            return description;
        } else if (interior instanceof Exit) {
            moveNpc();
            if (currentRoom == roomCellar) {
                for (Item i : getInventoryItems()) {
                    if (i instanceof QuestItem) {
                        if (((QuestItem) i).getItemId() == 99901) {
                            description.add("You manage to pick the lock with the needle, but sadly the needle breaks and cannot be used later.");
                            player.removeInventoryItem(i);
                            description.add(currentRoom.getDescription() + currentRoom.getMapInterior());
                            lastRoomId = currentRoom.getRoomId();
                            currentRoom = ((Exit) interior).getNewRoom();
                            return description;
                        }
                    }
                }
                description.add("A giant lock is on the door and it seems indestructible.");
                description.add("Some sort of lockpick would come in handy.");
                return description;
            } else if (currentRoom == roomCave) {
                currentRoom.setDescription("***Troll Cave***\nThe place is still dark.");
                if (roomCave.getMapInterior("troll1") == null && roomCave.getMapInterior("troll2") == null && roomCave.getMapInterior("troll3") == null) {
                    description.add(currentRoom.getDescription() + currentRoom.getMapInterior());
                    lastRoomId = currentRoom.getRoomId();
                    currentRoom = ((Exit) interior).getNewRoom();
                    return description;
                } else {
                    description.add("You have to defeat the 3 trolls to continue.");
                    return description;
                }
            } else if (currentRoom == roomVillage) {
                currentRoom.setDescription("***Village of Treldan***\nThe village looks beautiful in the night.");
                if (command.getSecondWord().equals("house2")) {
                    for (Item i : getInventoryItems()) {
                        if (i instanceof QuestItem) {
                            if (((QuestItem) i).getItemId() == 99907) {
                                description.add("You inserted the key, and the door unlocked.");
                                description.add(currentRoom.getDescription() + currentRoom.getMapInterior());
                                lastRoomId = currentRoom.getRoomId();
                                currentRoom = ((Exit) interior).getNewRoom();
                                return description;
                            }
                        }
                    }
                    description.add("The door's locked, maybe a key's lying around.");
                    return description;
                }
            } else if (currentRoom == roomHouse1) {
                currentRoom.setDescription("***House of the Reborn***\nThe house looks spooky.");
            } else if (currentRoom == roomHouse2) {
                currentRoom.setDescription("***House of Riches***\nThe house looks creepy.");
            } else if (currentRoom == roomHouse3) {
                currentRoom.setDescription("***House of the Guard***\nThe house looks cozy.");
            } else if (currentRoom == roomForest) {
                currentRoom.setDescription("***The Forest of Treldan***\nThe forest is much more quiet than before.");
            } else if (currentRoom == roomWizardHouse) {
                currentRoom.setDescription("***The Nice Wizard's House***\nThe wizard's house is wierd but nice.");
            } else if (currentRoom == roomCaveGruul) {
                currentRoom.setDescription("***Gruul's Lair**\nThe cave where Gruul lives.");
            } else if (currentRoom == roomClearing) {
                currentRoom.setDescription("***Clearing of Unicorns***\nFor some reason the sun shines bright in the clearing.");
            } else if (currentRoom == roomDungeon) {
                currentRoom.setDescription("***Dungeon of Suffering***\nYou wouldn't like to live here.");
                if (roomDungeon.getMapInterior("skeleton1") == null && roomDungeon.getMapInterior("skeleton2") == null && roomDungeon.getMapInterior("skeleton3") == null) {
                    description.add(currentRoom.getDescription() + currentRoom.getMapInterior());
                    lastRoomId = currentRoom.getRoomId();
                    currentRoom = ((Exit) interior).getNewRoom();
                    return description;
                } else {
                    description.add("You have to defeat the 3 skeletons to continue.");
                    return description;
                }
            } else if (currentRoom == roomLibrary) {
                currentRoom.setDescription("***The Neverending Library***\nThere's still a trillion books in the library.");
                if (command.getSecondWord().equals("door")) {
                    for (Item i : getInventoryItems()) {
                        if (i instanceof QuestItem) {
                            if (((QuestItem) i).getItemId() == 99903) {
                                description.add("You attach the broken handle to the door and it opens easily,");
                                description.add(currentRoom.getDescription() + currentRoom.getMapInterior());
                                lastRoomId = currentRoom.getRoomId();
                                currentRoom = ((Exit) interior).getNewRoom();
                                return description;
                            }
                        }
                    }
                    description.add("The door's handle is broken.");
                    return description;
                }
            }
            lastRoomId = currentRoom.getRoomId();
            currentRoom = ((Exit) interior).getNewRoom();
            description.add(currentRoom.getDescription() + currentRoom.getMapInterior());
            return description;
        } else if (interior instanceof Item) {
            if (interior instanceof EquippableItem) {
                currentRoom.removeInterior(command.getSecondWord());
                player.addItemToInventory((EquippableItem) interior);
                description.add(((EquippableItem) interior).getRoomDescription());
                player.addHighscore(((EquippableItem) interior).getItemValue());
                return description;
            } else if (interior instanceof QuestItem) {
                currentRoom.removeInterior(command.getSecondWord());
                player.addItemToInventory((Item) interior);
                description.add(((QuestItem) interior).getRoomDescription());
                player.addHighscore(((QuestItem) interior).getItemValue());
                return description;
            } else if (interior instanceof UseableItem) {
                currentRoom.removeInterior(command.getSecondWord());
                player.addItemToInventory((Item) interior);
                description.add(((UseableItem) interior).getRoomDescription());
                player.addHighscore(((UseableItem) interior).getItemValue());
                return description;
            } else {
                description.add("mystery Item nothing happend");
                return description;
            }
        } else if (interior instanceof Npc) {
            switch (((Npc) interior).getNpcID()) {
                case 22201:
                    for (Item i : getInventoryItems()) {
                        if (i instanceof QuestItem) {
                            if (((QuestItem) i).getItemId() == 99902) {
                                description.add("Thank you, thank you so much, I dont know what I would do without them \"Please, leave the village through the gate.");
                                player.removeInventoryItem(i);
                                Interior roomVillageExit4 = new Exit(roomForest);
                                roomVillage.addMapInterior("forest", roomVillageExit4);
                                return description;
                            }
                        }
                    }
                    description.add("The guard stops his sobbing as you near him. “Who’s there?!” he yells. You decide not to reveal your identity, and the guard continues:"
                            + " ”Oh, why does it matter? I’ll letout of the Treldan if you find my wife and kids."
                            + " I have orders to stay at my post.” The guard sits down and continues his sobbing.");
                    break;
                case 22202:
                    Item item1 = null;
                    Item item2 = null;
                    for (Item i : getInventoryItems()) {
                        if (i instanceof QuestItem) {
                            if (((QuestItem) i).getItemId() == 99905) {
                                item1 = i;
                            } else if (((QuestItem) i).getItemId() == 99906) {
                                item2 = i;
                            }
                        }
                    }
                    if (item1 != null && item2 != null) {
                        description.add("Thank you for bringing me the items the I asked for! Go find the stranger in the village."
                                + " He is known for hiding in the houses or the village. He may move his position.");
                        player.removeInventoryItem(item1);
                        player.removeInventoryItem(item2);
                        roomWizardHouse.removeInterior("wizard");
                        roomVillage.addMapInterior("stranger", stranger);
                    } else {
                        description.add("Greetings traveler. I am in need of your help. There is an evil wizard that you need to slay. First of all I can't get inside his evil castle, but a stranger in the village will be able to"
                                + " teleport you inside if you want to help me, but the evil Gruul has taken my magic staff, so go get that for me! He's inside his lair in the forest. "
                                + "Additionally I need some liquid rainbow that is inside the heart of a unicorn, go kill one in the clearing nearby.");
                    }
                    break;

                case 22203:
                    description.add("The wizard told me to teleport you to the evil wizard's tower of doom. Get ready.");
                    currentRoom = roomDungeon;
                    description.add(currentRoom.getDescription() + currentRoom.getMapInterior());
                    break;

                case 22204:
                    for (Item i : getInventoryItems()) {
                        if (i instanceof QuestItem) {
                            if (((QuestItem) i).getItemId() == 99904) {
                                description.add("You hack at the old tree for a while and finally it snaps in half, and tilts inwards towards the unicorn, who sadly, but fortunately for you doesn’t react in time and gets smashed by the tree");
                                ((Monster) roomClearing.getMapInterior("unicorn")).setRoomDescription("The tree that fell on the unicorn exposes the unicorns heart and innards. You finish the unicorn off and hold out a vial and watch in marvel as the liquid rainbow gathers in it");
                                ((Monster) roomClearing.getMapInterior("unicorn")).setHealth(1);
                                ((Monster) roomClearing.getMapInterior("unicorn")).setAttValue(0.1);
                                ((Monster) roomClearing.getMapInterior("unicorn")).setDefValue(0.1);
                                player.addHighscore(1000);
                                currentRoom.removeInterior(command.getSecondWord());
                                return description;
                            }
                        }
                    }
                    description.add("You approach the old tree, it looks like it can be cut down fairly easily with 	the right tool");
                    break;

            }
            return description;
        } else if (interior instanceof Monster) {

            Combat combat = new Combat(player, (Monster) interior);
            description.add("***** You found a monster! It's a " + ((Monster) interior).getMonsterName() + ".");
            for (Fight f : combat.AFight()) {
                if (!f.isDone()) {
                    description.add(f.toString());
                } else {
                    description.add(f.toString());
                    description.add("** The winner of the fight is " + f.winner());
                }
            }
            if (player.getHealth() < 1) {
                description.add("***** YOU DIED! You lost highscore points.");
                //player loses 10% of current highscore if player dies
                player.removeHighscore(player.getHighscore() / 10);
                player.setHealth(100);
            } else {
                for (Item i : combat.getMonster().getItemDrop()) {
                    description.add("** You got item " + i.getItemName());
                    player.addItemToInventory(i);
                }
                int goldDrop = combat.getMonster().getGoldDrop();
                description.add("** You got " + goldDrop + " gold.");
                player.addGold(goldDrop);
                currentRoom.removeInterior(command.getSecondWord());
                description.add("***** Your remaining hp: " + player.getHealth());
                if (((Monster) interior).getMobId() == 1) {
                    isOver = true;
                }
            }
            return description;

        } else {
            description.add("Nothing here.");
            return description;
        }
    }

    /**
     * Equip an item from the inventory.
     *
     * @param command The command to use
     * @return List of strings of what happened.
     */
    public List<String> equipItem(Command command) {
        List<String> equip = new ArrayList();
        //for (Item i : player.getInventoryItems()) {
        for (int i = 0; i < player.getInventoryItems().size(); i++) {
            Item item = player.getInventoryItems().get(i);
            if (item instanceof EquippableItem) {
                if (item.getItemName().equals(command.getSecondWord())) {
                    player.addItemToEquippableInventory((EquippableItem) item, player);
                    equip.add(item.getItemName() + " was added to your equippable items");
                }
            }
        }
        if (equip.isEmpty()) {
            equip.add("This item is not equippable");
        }
        return equip;
    }

    /**
     * Use an item in the players inventory.
     *
     * @param command The command to use
     * @return List of strings of what happened.
     */
    public List<String> useItem(Command command) {
        List<String> use = new ArrayList();
        //no items used yet
        boolean check = false;
        Item usedItem = null;
        for (Item i : getInventoryItems()) {
            if (i instanceof UseableItem) {
                if (i.getItemName().equals(command.getSecondWord())) {

                    int itemID = i.getItemId();
                    usedItem = i;

                    switch (itemID) {
                        case 55501: //cheese sandwhich
                            if (getPlayerHealth() != 100) {
                                use.add("You used " + i.getItemName() + " and regenerated " + ((UseableItem) i).getHealthRegen() + " hp back.");
                                playerRegenHealth(((UseableItem) i).getHealthRegen());

                            } else {
                                use.add("You're already at full health");
                                usedItem = null;
                            }
                            break;

                        case 55502: //cinnamon roll
                            if (getPlayerHealth() != 100) {
                                use.add("You used " + i.getItemName() + " and regenerated " + ((UseableItem) i).getHealthRegen() + " hp back.");
                                playerRegenHealth(((UseableItem) i).getHealthRegen());
                            } else {
                                use.add("You're already at full health");
                                usedItem = null;
                            }
                            break;

                        case 55503: //old rusty coin
                            use.add("Old dusty coin, not good for anything except highscore");
                            break;

                        case 55504: //mushroom
                            if (currentRoom.equals(roomCave)) {
                                player.addHighscore(3000);
                                currentRoom.removeInterior("troll1");
                                currentRoom.removeInterior("troll2");
                                currentRoom.removeInterior("troll3");
                                use.add("The stinking mushroom scares off the trolls and they flee out the cave");

                            } else {
                                use.add("You don't find any monsters that would be scared of a stinking mushroom.");
                                usedItem = null;
                            }
                            break;
                        case 55505: //smooth ruby
                            use.add("A smooth looking ruby, only good for high score");
                            break;

                        case 55506: //mysterious ring
                            if (currentRoom != roomVillage) {
                                use.add("You examine the ring, and suddenly a bright light shines out, and you get teleported to the village.");
                                player.addHighscore(1000);
                                currentRoom = roomVillage;
                            } else {
                                use.add("The mysterious ring's magic seems to have faded. You cannot find a use for the ring in the village.");
                                usedItem = null;
                            }
                            break;

                        case 55507: //health potion
                            if (getPlayerHealth() != 100) {
                                use.add("You used " + i.getItemName() + " and regenerated " + ((UseableItem) i).getHealthRegen() + " hp back.");
                                playerRegenHealth(((UseableItem) i).getHealthRegen());
                            } else {
                                use.add("You're already at full health");
                                usedItem = null;
                            }

                            break;

                        case 55508: //Cheese Sandwhich
                            if (getPlayerHealth() != 100) {
                                use.add("You used " + i.getItemName() + " and regenerated " + ((UseableItem) i).getHealthRegen() + " hp back.");
                                playerRegenHealth(((UseableItem) i).getHealthRegen());

                            } else {
                                use.add("You're already at full health");
                                usedItem = null;
                            }
                            break;
                    }
                    //an item is used
                    check = true;
                    //break the loop so only one item is used
                    break;

                }
            }
            if (i instanceof QuestItem) {
                if (i.getItemName().equals(command.getSecondWord())) {

                    int itemID = i.getItemId();
                    usedItem = i;

                    switch (itemID) {

                        //needle
                        case 99901:
                            use.add("\n" + i.getItemDescription());
                            usedItem = null;
                            check = true;
                            break;

                        //bloody key
                        case 99907:
                            use.add(i.getItemDescription());
                            usedItem = null;
                            check = true;
                            break;

                        //Kids
                        case 99902:
                            use.add("\n" + i.getItemDescription());
                            usedItem = null;
                            check = true;
                            break;

                        //lumberjack axe
                        case 99904:
                            use.add("\n" + i.getItemDescription());
                            usedItem = null;
                            check = true;
                            break;

                        //magic staff
                        case 99905:
                            use.add("\n" + i.getItemDescription());
                            usedItem = null;
                            check = true;
                            break;

                        //vial of liquid rainbow
                        case 99906:
                            use.add("\n" + i.getItemDescription());
                            usedItem = null;
                            check = true;
                            break;

                        //Broken handle to the library
                        case 99903:
                            use.add("\n" + i.getItemDescription());
                            usedItem = null;
                            check = true;
                            break;
                    }
                }
            }
        }
        //if the item is used remove it from player inventory
        if (usedItem != null) {
            removeItemFromInventory(usedItem);
        }
        //error message
        if (!check) {
            use.add("You carry no item with that name");
        }

        return use;
    }

    /**
     * Check if the game is over.
     *
     * @return Boolean
     */
    public boolean endGame() {
        if (currentRoom == roomEvilWizardsLair) {
            if (currentRoom.getMapInterior("wizard") == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a list containing all items in the players inventory.
     *
     * @return List of Items
     */
    public List<Item> getInventoryItems() {
        return player.getInventoryItems();
    }

    /**
     * Removes an item from the players inventory.
     *
     * @param i Item to be removed
     */
    public void removeItemFromInventory(Item i) {
        player.removeInventoryItem(i);
    }

    /**
     * Returns the hashmap of all equipped items
     *
     * @return Hashmap over the equipped item
     */
    public HashMap<EquippableItem.EItem, EquippableItem> getEquippableItems() {
        return player.getEquippableItems();
    }

    /**
     * Write the highscore
     */
    public void writeHighScore() {
        long endTime = (System.currentTimeMillis() / 1000L);
        try {
            FileWriter fw = new FileWriter("Highscore.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(player.getPlayerName() + ":" + player.getHighscore() + ":" + (endTime - getStartTime()));
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error at writing to Highscore.txt" + e);
        }
    }

    /**
     * Returns the current highscore list containing Score object
     *
     * @return list of scores
     */
    public List<Score> readHighScore() {
        List<Score> scoreList = new ArrayList();
        try {
            for (String line : Files.readAllLines(Paths.get("Highscore.txt"))) {
                if(!line.isEmpty()){
                    String playerName = Arrays.asList(line.split(":")).get(0);
                    int playerScore = Integer.parseInt(Arrays.asList(line.split(":")).get(1));
                    int playerTime = Integer.parseInt(Arrays.asList(line.split(":")).get(2));
                    scoreList.add(new Score(playerName, playerScore, playerTime));
                }
            }
        } catch (IOException e) {
            scoreList.add(new Score("Error", 0, 0));
        }
        return scoreList;
    }

    /**
     * @param playerName set the player name to this string
     */
    public void setPlayerName(String playerName) {
        player.setPlayerName(playerName);
    }

    /**
     * @return the player name
     */
    public String getPlayerName() {
        return player.getPlayerName();
    }

    /**
     * Method to move the 'Stranger' NPC if it is not null. Is moved from house
     * to house
     */
    public void moveNpc() {
        if (roomVillage.getMapInterior("stranger") != null) {
            roomVillage.removeInterior("stranger");
            roomHouse1.addMapInterior("stranger", stranger);
        } else if (roomHouse1.getMapInterior("stranger") != null) {
            roomHouse1.removeInterior("stranger");
            roomHouse2.addMapInterior("stranger", stranger);
        } else if (roomHouse2.getMapInterior("stranger") != null) {
            roomHouse2.removeInterior("stranger");
            roomHouse3.addMapInterior("stranger", stranger);
        } else if (roomHouse3.getMapInterior("stranger") != null) {
            roomHouse3.removeInterior("stranger");
            roomHouse1.addMapInterior("stranger", stranger);
        }
    }

    /**
     * @return Arraylist of Strings of the current player description.
     */
    public ArrayList<String> getPlayer() {
        ArrayList<String> player = new ArrayList();
        player.add("\n");
        player.add("******************\n");
        player.add("Name    : " + getPlayerName() + "\n");
        player.add("Health  : " + getPlayerHealth() + "\n");
        player.add("Attack  : " + getPlayerAtt() + "\n");
        player.add("Defense : " + getPlayerDeff() + "\n");
        player.add("Gold    : " + getPlayerGold() + "\n");
        player.add("******************\n");
        player.add("**EQUIPPED ITEMS**\n");
        if (!getEquippableItems().isEmpty()) {
            for (Map.Entry<EquippableItem.EItem, EquippableItem> ei : getEquippableItems().entrySet()) {
                player.add(ei.getKey() + ": " + ei.getValue().getItemName() + " : ATTV " + ei.getValue().getAttackBuff() + " : DEFFV " + ei.getValue().getDefenseBuff());
            }
        } else {
            player.add("No equipped items..");
        }
        return player;
    }

    /**
     *
     * @return the players att value
     */
    public double getPlayerAtt() {
        return player.getAttValue();
    }

    /**
     *
     * @return the players deff value
     */
    public double getPlayerDeff() {
        return player.getDefValue();
    }

    /**
     * @return the player health
     */
    public double getPlayerHealth() {
        return player.getHealth();
    }

    /**
     * @return the player gold
     */
    public int getPlayerGold() {
        return player.getGold();
    }

    /**
     * @param healthToRegen health to regen.
     */
    public void playerRegenHealth(int healthToRegen) {
        if (player.getHealth() == 100) {
            System.out.println("You're already at max health");
        } else {
            player.regenHealth(healthToRegen);
            if (player.getHealth() >= 100) {
                player.setHealth(100);
            }
        }
    }

    /**
     * @return the isOver
     */
    public boolean isIsOver() {
        return isOver;
    }

    /**
     * @return current room id
     */
    public int getCurrentRoomId() {
        return currentRoom.getRoomId();
    }

    /**
     * @return the room description
     */
    public String getCurrentRoomDescription() {
        return currentRoom.getDescription();
    }

    /**
     * @return the current room name.
     */
    public String getCurrentRoomName() {
        return currentRoom.getName();
    }

    /**
     * @return the lastRoomId
     */
    public int getLastRoomId() {
        return lastRoomId;
    }

    /**
     * @return the startTime
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * @return the highscore
     */
    public int getHighscore() {
        return player.getHighscore();
    }
}
