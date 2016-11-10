/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFXSimple;

import TWoT_test.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Mathias
 */
public class GUIFX extends Application {

    private TWoT twot;
    private TextArea textArea;
    private String help;
    private String inventory;
    
    private String printHelp() {
        HashMap<String, String> printHelpMSG = twot.getHelpMessages();
            return printHelpMSG.get("helpMessage1") + printHelpMSG.get("helpMessage2") + printHelpMSG.get("helpMessage3");
        }
    private String printInventory() {
        
    }
    
    public GUIFX () {
        
        twot = new TWoT();
        
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage primaryStage) {
        
        
        primaryStage.setTitle("The Wizard of Treldan");
        textArea = new TextArea();
        
        Button button_inventory = new Button("Inventory");
        Button button_clear = new Button("Clear");
        Button button_help = new Button("Help");
        Button button_exit = new Button("Exit");
        
        button_inventory.setMaxWidth(90);
        button_help.setMaxWidth(90);
        button_exit.setMaxWidth(90);
        button_clear.setMaxWidth(90);
        
        VBox root1 = new VBox(20);
        root1.setLayoutX(422);
        root1.getChildren().addAll(button_inventory, button_clear, button_help, button_exit);
        
        VBox root2 = new VBox(20);
        textArea.setMaxWidth(422);
        textArea.setMinHeight(288);
        textArea.setWrapText(true);
        textArea.setEditable(false);
        root2.getChildren().addAll(textArea);
        
        Pane root = new Pane(root1, root2);
        
        DropShadow shade = new DropShadow();
        root.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            root.setEffect(shade);
        });
        
        root.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            root.setEffect(null);
        });
        button_help.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            help=printHelp();
            textArea.appendText(help);
        });
        button_clear.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            textArea.clear();
        });
        button_clear.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            
            textArea.clear();
        });
                
        button_exit.setOnAction(actionEvent -> Platform.exit());
 
        
        Scene scene1 = new Scene(root, 512, 288);
        
        primaryStage.setScene(scene1);
        primaryStage.show();
        
        
    }
}

