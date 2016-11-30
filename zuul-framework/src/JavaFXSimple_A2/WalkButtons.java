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
    private List<String> button_description = new ArrayList<>();
    
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
        
        VBox cellarButtons = new VBox(20);
        //if guard children not delivered.
        cellarButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe);
        /*else
        cellarButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe, button_forest);
        */
        Group root = new Group(cellarButtons);
        
        
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
        //if guard children not delivered.
        house1Buttons.getChildren().addAll(button_man, button_chest, button_door);
        /*else
        cellarButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe, button_forest);
        */
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
        //if guard children not delivered.
        house2Buttons.getChildren().addAll(button_door, button_wardrobe, button_bed, button_table);
        /*else
        cellarButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe, button_forest);
        */
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
        //if guard children not delivered.
        house3Buttons.getChildren().addAll(button_door, button_kitchen, button_woman, button_chest);
        /*else
        cellarButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe, button_forest);
        */
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
        Button button_hOfGuard = new Button("Guards House");
        Button button_guard = new Button("The Guard");
        Button button_axe = new Button("Axe");
        Button button_forest = new Button("Forest");
        
        VBox forestButtons = new VBox(20);
        //if guard children not delivered.
        forestButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe);
        /*else
        cellarButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe, button_forest);
        */
        Group root = new Group(forestButtons);
        
        
        button_reborn.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Reborns");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_riches.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Riches");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_hOfGuard.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Guard House");
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
    private Group wizardHouseButtons(TWoT twot, TextArea textArea) {
        
        Button button_reborn = new Button("Reborn");
        Button button_riches = new Button("Riches");
        Button button_hOfGuard = new Button("Guards House");
        Button button_guard = new Button("The Guard");
        Button button_axe = new Button("Axe");
        Button button_forest = new Button("Forest");
        
        VBox cellarButtons = new VBox(20);
        //if guard children not delivered.
        cellarButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe);
        /*else
        cellarButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe, button_forest);
        */
        Group root = new Group(cellarButtons);
        
        
        button_reborn.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Reborns");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_riches.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Riches");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_hOfGuard.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Guard House");
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
    private Group caveButtons(TWoT twot, TextArea textArea) {
        
        Button button_reborn = new Button("Reborn");
        Button button_riches = new Button("Riches");
        Button button_hOfGuard = new Button("Guards House");
        Button button_guard = new Button("The Guard");
        Button button_axe = new Button("Axe");
        Button button_forest = new Button("Forest");
        
        VBox cellarButtons = new VBox(20);
        //if guard children not delivered.
        cellarButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe);
        /*else
        cellarButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe, button_forest);
        */
        Group root = new Group(cellarButtons);
        
        
        button_reborn.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Reborns");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_riches.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Riches");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_hOfGuard.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Guard House");
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
    private Group lairButtons(TWoT twot, TextArea textArea) {
        
        Button button_reborn = new Button("Reborn");
        Button button_riches = new Button("Riches");
        Button button_hOfGuard = new Button("Guards House");
        Button button_guard = new Button("The Guard");
        Button button_axe = new Button("Axe");
        Button button_forest = new Button("Forest");
        
        VBox cellarButtons = new VBox(20);
        //if guard children not delivered.
        cellarButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe);
        /*else
        cellarButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe, button_forest);
        */
        Group root = new Group(cellarButtons);
        
        
        button_reborn.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Reborns");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_riches.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Riches");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_hOfGuard.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Guard House");
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
    
    private Group clearingButtons(TWoT twot, TextArea textArea) {
        
        Button button_reborn = new Button("Reborn");
        Button button_riches = new Button("Riches");
        Button button_hOfGuard = new Button("Guards House");
        Button button_guard = new Button("The Guard");
        Button button_axe = new Button("Axe");
        Button button_forest = new Button("Forest");
        
        VBox cellarButtons = new VBox(20);
        //if guard children not delivered.
        cellarButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe);
        /*else
        cellarButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe, button_forest);
        */
        Group root = new Group(cellarButtons);
        
        
        button_reborn.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Reborns");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_riches.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Riches");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_hOfGuard.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Guard House");
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
    private Group dungeonButtons(TWoT twot, TextArea textArea) {
        
        Button button_reborn = new Button("Reborn");
        Button button_riches = new Button("Riches");
        Button button_hOfGuard = new Button("Guards House");
        Button button_guard = new Button("The Guard");
        Button button_axe = new Button("Axe");
        Button button_forest = new Button("Forest");
        
        VBox cellarButtons = new VBox(20);
        //if guard children not delivered.
        cellarButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe);
        /*else
        cellarButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe, button_forest);
        */
        Group root = new Group(cellarButtons);
        
        
        button_reborn.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Reborns");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_riches.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Riches");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_hOfGuard.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Guard House");
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
    private Group libraryButtons(TWoT twot, TextArea textArea) {
        
        Button button_reborn = new Button("Reborn");
        Button button_riches = new Button("Riches");
        Button button_hOfGuard = new Button("Guards House");
        Button button_guard = new Button("The Guard");
        Button button_axe = new Button("Axe");
        Button button_forest = new Button("Forest");
        
        VBox cellarButtons = new VBox(20);
        //if guard children not delivered.
        cellarButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe);
        /*else
        cellarButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe, button_forest);
        */
        Group root = new Group(cellarButtons);
        
        
        button_reborn.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Reborns");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_riches.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Riches");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_hOfGuard.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Guard House");
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
    private Group evilWizardsButtons(TWoT twot, TextArea textArea) {
        
        Button button_reborn = new Button("Reborn");
        Button button_riches = new Button("Riches");
        Button button_hOfGuard = new Button("Guards House");
        Button button_guard = new Button("The Guard");
        Button button_axe = new Button("Axe");
        Button button_forest = new Button("Forest");
        
        VBox cellarButtons = new VBox(20);
        //if guard children not delivered.
        cellarButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe);
        /*else
        cellarButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe, button_forest);
        */
        Group root = new Group(cellarButtons);
        
        
        button_reborn.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Reborns");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_riches.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Riches");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            
        });
        button_hOfGuard.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Guard House");
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
}
