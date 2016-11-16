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
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    private Parser parser;
    private TextArea textArea;
    private TextField inputArea;
    private String help;
    private String inventory;
    private int counter;
    private String printHelp() {
        HashMap<String, String> printHelpMSG = twot.getHelpMessages();
            return printHelpMSG.get("helpMessage1") + printHelpMSG.get("helpMessage2") + printHelpMSG.get("helpMessage3");
        }
    private String printInventory() {
        inventory = "";
        ArrayList<Item> inv = new ArrayList<>();
        for(Item i : twot.getInventoryItems()){
            inv.add(i);
        }
            if(inv.isEmpty()){
                    return "Your inventory is empty\n";
            }
            else if(inv.size() >= 1){
                for(Item j : inv){
                    inventory += j.getItemName() + "\n";
                }
            }
        
        return inventory;
}
    
    public GUIFX () {
        
        twot = new TWoT();
        parser = new Parser();
        
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage primaryStage) {
        
        primaryStage.setTitle("The Wizard of Treldan");
        textArea = new TextArea();
        inputArea = new TextField();
        
        Button button_play = new Button("NEW GAME");
        Button button_load = new Button("LOAD GAME");
        Button button_how = new Button("HOW TO PLAY");
        Button button_exitMenu = new Button("EXIT GAME");
        
        button_play.setMinWidth(180);
        button_load.setMinWidth(180);
        button_how.setMinWidth(180);
        button_exitMenu.setMinWidth(180);
        button_play.setMinHeight(40);
        button_load.setMinHeight(40);
        button_how.setMinHeight(40);
        button_exitMenu.setMinHeight(40);
                
        Button button_inventory = new Button("Inventory");
        Button button_clear = new Button("Clear");
        Button button_help = new Button("Help");
        Button button_exit = new Button("Exit");
        
        button_inventory.setMaxWidth(90);
        button_help.setMaxWidth(90);
        button_exit.setMaxWidth(90);
        button_clear.setMaxWidth(90);
        
        VBox gameButtons = new VBox(20);
        gameButtons.setLayoutX(422);
        gameButtons.getChildren().addAll(button_inventory, button_clear, button_help, button_exit);
        
        VBox menuButtons = new VBox(20);
        menuButtons.setLayoutX(166);
        menuButtons.setLayoutY(30);
        menuButtons.getChildren().addAll(button_play, button_load, button_how, button_exitMenu);
              
        
        VBox outputField = new VBox(20);
        textArea.setMaxWidth(422);
        textArea.setMinHeight(258);
        textArea.setMaxHeight(258);
        textArea.setWrapText(true);
        textArea.setEditable(false);
        outputField.getChildren().addAll(textArea);
        
        VBox inputField = new VBox(20);
        inputArea.setMaxWidth(422);
        inputArea.setMaxHeight(30);
        inputField.relocate(0, 260);
        inputField.getChildren().addAll(inputArea);
        
        Pane root = new Pane(gameButtons, outputField, inputField);
        Pane root2 = new Pane(menuButtons);
        
        Scene scene1 = new Scene(root, 512, 288);
        Scene menu = new Scene(root2, 512, 288);
                
        DropShadow shade = new DropShadow();
        root.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            root.setEffect(shade);
        });
        
        root.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            root.setEffect(null);
        });
        button_play.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            primaryStage.setScene(scene1);
        });
        button_help.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            help=printHelp();
            textArea.appendText(help);
        });
        button_inventory.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            inventory = printInventory();
            textArea.appendText(inventory);
        });
        button_clear.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            textArea.clear();
        });
        
        button_exit.setOnAction(actionEvent -> Platform.exit());
        
        inputField.setOnKeyPressed(new EventHandler<KeyEvent>(){
            public void handle(KeyEvent k){
                if(k.getCode().equals(KeyCode.ENTER)){
                        CommandWords commandWord = new CommandWords();
                        Command command = new Command(commandWord.getCommandWord(k.getText()), k.getText());
                        twot.goTo(command);
                        parser.getCommand();
                        textArea.appendText("Hello\n");
                        inputArea.clear();
                }
            }
        });
<<<<<<< HEAD
=======
                
        button_exit.setOnAction(actionEvent -> Platform.exit());
        button_exitMenu.setOnAction(actionEvent -> Platform.exit());

>>>>>>> origin/master
        
        
        primaryStage.setScene(menu);
        primaryStage.show();
        
        String welcome = "";
        for(HashMap.Entry<String, String> entry : twot.getWelcomeMessages().entrySet()){
            welcome = welcome + entry.getValue();
        }
        textArea.appendText(welcome);
        
    }
}

