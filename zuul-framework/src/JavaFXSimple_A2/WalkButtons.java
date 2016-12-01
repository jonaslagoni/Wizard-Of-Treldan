/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFXSimple_A2;

import TWoT_A1.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Mathias
 */
public class WalkButtons {
    
    CommandWords commandword = new CommandWords();
    
    public Group updateButtons(TWoT twot, TextArea textArea) {
        Group group = new Group();
            
        switch (twot.getCurrentRoomId()) {
            case 1:
                group = cellarButtons(twot, textArea);
                break;
            case 2:
                group = villageButtons(twot, textArea);
                break;
            case 3:
                group = house1Buttons(twot, textArea);
                break;
            case 4:
                group = house2Buttons(twot, textArea);
                break;
            case 5:
                group = house3Buttons(twot, textArea);
                break;
            case 6:
                group = forestButtons(twot, textArea);
                break;
            case 7:
                group = wizardHouseButtons(twot, textArea);
                break;
            case 8:
                group = caveButtons(twot, textArea);
                break;
            case 9:
                group = lairButtons(twot, textArea);
                break;
            case 10:
                group = clearingButtons(twot, textArea);
                break;
            case 11:
                group = dungeonButtons(twot, textArea);
                break;
            case 12:
                group = libraryButtons(twot, textArea);
                break;
            case 13:
                group = evilWizardsButtons(twot, textArea);
                break;
        }
        return group;
    }
    
    private Group cellarButtons(TWoT twot, TextArea textArea) {
        
        Button button_haystack = new Button("Haystack");
        Button button_table = new Button("Table");
        Button button_door = new Button("Door");
        
        VBox cellarButtons = new VBox(20);
        cellarButtons.setLayoutX(0);
        
        cellarButtons.getChildren().addAll(button_haystack, button_table, button_door);
        
        Group root = new Group(cellarButtons);
        
        button_haystack.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "haystack");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
        });
        button_table.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "table");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_door.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "door");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        return root;
    }
    
    private Group villageButtons(TWoT twot, TextArea textArea) {
        
        Button button_reborn = new Button("Reborn");
        Button button_riches = new Button("Riches");
        Button button_hOfGuard = new Button("Guards House");
        Button button_guard = new Button("The Guard");
        Button button_axe = new Button("Axe");
        Button button_forest = new Button("Forest");
        
        VBox villageButtons = new VBox(20);
        //if guard children not delivered.
        villageButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe);
        /*else
        villageButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe, button_forest);
        */
        Group root = new Group(villageButtons);
        
        
        button_reborn.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "house1");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_riches.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "house2");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_hOfGuard.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "house3");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_guard.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "guard");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_axe.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "axe");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_forest.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "forest");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        
        return root;
    }
    private Group house1Buttons(TWoT twot, TextArea textArea) {
        
        Button button_man = new Button("Man");
        Button button_chest = new Button("Chest");
        Button button_door = new Button("Door");
        
        VBox house1Buttons = new VBox(20);
        house1Buttons.getChildren().addAll(button_man, button_chest, button_door);
        Group root = new Group(house1Buttons);
        
        
        button_man.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "man");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_chest.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "chest");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_door.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "door");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        
        return root;
    }
    private Group house2Buttons(TWoT twot, TextArea textArea) {
        
        Button button_door = new Button("Door");
        Button button_wardrobe = new Button("Wardrobe");
        Button button_bed = new Button("Bed");
        Button button_table = new Button("Table");
        
        VBox house2Buttons = new VBox(20);
        house2Buttons.getChildren().addAll(button_door, button_wardrobe, button_bed, button_table);
        Group root = new Group(house2Buttons);
        
        
        button_door.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "door");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_wardrobe.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Riches");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_bed.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Guard House");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_table.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "guard");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        
        return root;
    }
    private Group house3Buttons(TWoT twot, TextArea textArea) {
        
        Button button_door = new Button("Door");
        Button button_kitchen = new Button("Kitchen");
        Button button_woman = new Button("Woman");
        Button button_chest = new Button("Chest");
        
        VBox house3Buttons = new VBox(20);
        house3Buttons.getChildren().addAll(button_door, button_kitchen, button_woman, button_chest);
        Group root = new Group(house3Buttons);
        
        
        button_door.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "door");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_kitchen.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "kitchen");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_woman.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "woman");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_chest.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "chest");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        
        return root;
    }
    private Group forestButtons(TWoT twot, TextArea textArea) {
        
        Button button_mushroom = new Button("Mushroom");
        Button button_goblin = new Button("Dead goblin");
        Button button_house = new Button("Wiz House");
        Button button_cave = new Button("Cave");
        Button button_clearing = new Button("Clearing");
        Button button_village = new Button("Village");
        
        VBox forestButtons = new VBox(20);
        forestButtons.getChildren().addAll(button_mushroom, button_goblin, button_house, button_cave, button_clearing, button_village);
        
        Group root = new Group(forestButtons);
        
        
        button_mushroom.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "mushroom");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_goblin.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "goblin");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_house.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "house");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_cave.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "cave");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_clearing.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "clearing");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_village.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "village");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        
        return root;
    }
    private Group wizardHouseButtons(TWoT twot, TextArea textArea) {
        
        Button button_upstairs = new Button("Upstairs");
        Button button_box = new Button("Box");
        Button button_lab = new Button("Lab");
        Button button_wizard = new Button("Wizard");
        Button button_door = new Button("Door");
        
        VBox wizardHouseButtons = new VBox(20);
        wizardHouseButtons.getChildren().addAll(button_upstairs, button_box, button_lab, button_wizard, button_door);
        
        Group root = new Group(wizardHouseButtons);
        
        
        button_upstairs.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "upstairs");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_box.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "box");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_lab.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "lab");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_wizard.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "wizard");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_door.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "door");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        
        return root;
    }
    private Group caveButtons(TWoT twot, TextArea textArea) {
        
        Button button_troll1 = new Button("Troll");
        Button button_troll2 = new Button("Troll");
        Button button_troll3 = new Button("Troll");
        Button button_forest = new Button("Forest");
        Button button_lair = new Button("Lair");
        
        VBox caveButtons = new VBox(20);
        caveButtons.getChildren().addAll(button_troll1, button_troll2, button_troll3, button_forest, button_lair);
        
        Group root = new Group(caveButtons);
        
        
        button_troll1.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "troll");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_troll2.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "troll");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_troll3.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "troll");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_forest.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "forest");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_lair.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "lair");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        
        return root;
    }
    private Group lairButtons(TWoT twot, TextArea textArea) {
        
        Button button_gruul = new Button("Gruul");
        Button button_cave = new Button("Cave");
        
        VBox lairButtons = new VBox(20);
        lairButtons.getChildren().addAll(button_gruul, button_cave);
        Group root = new Group(lairButtons);
        
        
        button_gruul.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "gruul");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_cave.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "cave");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        
        return root;
    }
    
    private Group clearingButtons(TWoT twot, TextArea textArea) {
        
        Button button_forest = new Button("Forest");
        Button button_unicorn = new Button("Unicorn");
        Button button_tree = new Button("Tree");
        
        VBox clearingButtons = new VBox(20);
        clearingButtons.getChildren().addAll(button_forest, button_unicorn, button_tree);
        Group root = new Group(clearingButtons);
        
        
        button_forest.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Forest");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_unicorn.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Unicorn");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_tree.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Tree");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        
        return root;
    }
    private Group dungeonButtons(TWoT twot, TextArea textArea) {
        
        Button button_skeleton1 = new Button("Skeleton");
        Button button_skeleton2 = new Button("Skeleton");
        Button button_skeleton3 = new Button("Skeleton");
        Button button_pathway = new Button("Pathway");
        
        VBox dungeonButtons = new VBox(20);
        dungeonButtons.getChildren().addAll(button_skeleton1, button_skeleton2, button_skeleton3, button_pathway);
        Group root = new Group(dungeonButtons);
        
        
        button_skeleton1.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "skeleton1");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_skeleton2.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "skeleton2");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_skeleton3.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "skeleton3");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_pathway.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "pathway");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        
        return root;
    }
    private Group libraryButtons(TWoT twot, TextArea textArea) {
        
        Button button_librarian = new Button("Librarian");
        Button button_door = new Button("Door");
        Button button_chest = new Button("Chest");
	
        VBox libraryButtons = new VBox(20);
        libraryButtons.getChildren().addAll(button_librarian, button_door, button_chest);
        Group root = new Group(libraryButtons);
        
        
        button_librarian.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Librarian");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_door.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Door");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_chest.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Chest");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
	
        return root;
    }
    private Group evilWizardsButtons(TWoT twot, TextArea textArea) {
        
        Button button_evilWizard = new Button("Evil Wizard");
        Button button_minion1 = new Button("Minion1");
        Button button_minion2 = new Button("Minion2");
        
        VBox evilWizardsButtons = new VBox(20);
        evilWizardsButtons.getChildren().addAll(button_evilWizard, button_minion1, button_minion2);
        Group root = new Group(evilWizardsButtons);
        
        
        button_evilWizard.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Evil Wizard");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_minion1.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Minion1");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_minion2.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Minion2");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }

        });
        
        return root;
    }
}
