/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFXSimple;

import TWoT_A1.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Mathias
 */
public class WalkButtons {
    
    TWoT twot = new TWoT();
    CommandWords commandword = new CommandWords();
    private List<String> button_description = new ArrayList<>();
    
    public Group updateButtons() {
        
        
        Group group = new Group();
        group = cellarButtons();
        return group;
    }
    
    private Group cellarButtons() {
        
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
                button_description.add("\n" + s + "\n");
            }
        });
        return root;
    }
    
    private Group VillageButtons() {
        
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
        Pane root = new Pane(cellarButtons);
        
        return root;
    }
    
}
