/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFXSimple;

import TWoT_A1.*;
import java.util.HashMap;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.event.HyperlinkEvent;

/**
 *
 * @author Mathias
 */
public class GUIFX extends Application {

    private TWoT twot;
    
    private TextArea textArea;
    private TextArea statsArea;
    private TextField inputArea;
    private ProgressBar healthbar;
    private Label label;
    private String help;
    private TextField nameArea;
    private VBox statsField = new VBox(20);
    private Label label1;
    
    private TableView<InventoryItems> table = new TableView();
    private final ObservableList<InventoryItems> data = FXCollections.observableArrayList();
    
    private int health;
    
    private String printHelp() {
        HashMap<String, String> printHelpMSG = twot.getHelpMessages();
            return printHelpMSG.get("helpMessage1") + printHelpMSG.get("helpMessage2") + printHelpMSG.get("helpMessage3");
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
        inputArea = new TextField();
        label = new Label();
        statsArea = new TextArea();
        nameArea = new TextField();
        
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
        
        Button button_clear = new Button("Clear");
        Button button_help = new Button("Help");
        Button button_exit = new Button("Exit");
        
        button_help.setMaxWidth(90);
        button_exit.setMaxWidth(90);
        button_clear.setMaxWidth(90);
        
        VBox gameButtons = new VBox(20);
        gameButtons.setLayoutX(591);
        gameButtons.setLayoutY(5);
        gameButtons.getChildren().addAll(button_clear, button_help, button_exit);
        
        VBox menuButtons = new VBox(20);
        menuButtons.setLayoutX(166);
        menuButtons.setLayoutY(30);
        menuButtons.getChildren().addAll(button_play, button_load, button_how, button_exitMenu);
                      
        table.setEditable(true);
        List<Item> l = twot.getInventoryItems();
        for(Item i: l){
            if(i instanceof UseableItem){
                data.add(new InventoryItems(i.getItemName(), "Usable Item", i.getItemDescription()));
            } else if (i instanceof QuestItem) {
                data.add(new InventoryItems(i.getItemName(), "Quest Item", i.getItemDescription()));
            } else if(i instanceof EquippableItem) {
                data.add(new InventoryItems(i.getItemName(), "Equippable Item", i.getItemDescription()));
            }
        }
        TableColumn itemName = new TableColumn("Item Name");
        itemName.setMinWidth(100);
        itemName.setCellValueFactory(
                new PropertyValueFactory<InventoryItems, String>("itemName"));
 
        TableColumn itemType = new TableColumn("Item Type");
        itemType.setMinWidth(100);
        itemType.setCellValueFactory(
                new PropertyValueFactory<InventoryItems, String>("itemType"));
 
        TableColumn itemDescription = new TableColumn("Description");
        itemDescription.setMinWidth(200);
        itemDescription.setCellValueFactory(
                new PropertyValueFactory<InventoryItems, String>("itemDesc"));
 
        table.setItems(data);
        table.getColumns().addAll(itemName, itemType, itemDescription);
        table.setLayoutX(652);
        
        VBox outputField = new VBox(20);
        textArea.setMaxWidth(572);
        textArea.setMinWidth(572);
        textArea.setMinHeight(258);
        textArea.setMaxHeight(258);
        textArea.setWrapText(true);
        textArea.setEditable(false);
        outputField.getChildren().addAll(textArea);
        
        statsArea.appendText("****************************\n");
        statsArea.appendText("** Player name: " + twot.getPlayerName() + "\n");
        statsArea.appendText("** Attack value: " + twot.getPlayerAtt() + "\n");
        statsArea.appendText("** Defense value: " + twot.getPlayerDeff() + "\n");
        statsArea.appendText("** Gold: " + twot.getPlayerGold() + "\n");
        statsArea.appendText("****************************");
        statsField.setMaxWidth(256);
        statsField.setMaxHeight(110);
        statsField.relocate(0, 300);
        statsField.getChildren().addAll(statsArea);
        
        healthbar = new ProgressBar(twot.getPlayerHealth()/100);
        healthbar.setPrefSize(256, 26);
        healthbar.relocate(0, 265);
                       
        label1 = new Label("Health "+ twot.getPlayerHealth());
        label1.setTextFill(Color.web("RED"));
        label1.relocate(10, 269);
        
        VBox inputField = new VBox(20);
        inputField.setPrefSize(308, 28);
        inputField.relocate(264, 265);
        inputField.getChildren().addAll(inputArea);
        
        Label setNamePls = new Label("ENTER YOUR NAME: ");
        
        VBox nameField = new VBox();
        nameField.setMaxWidth(300);
        nameField.setMinWidth(300);
        nameField.setMaxHeight(50);
        nameField.setMinHeight(50);
        nameField.relocate(106, 119);
        nameField.getChildren().addAll(setNamePls, nameArea);
        
        Pane root = new Pane(gameButtons, outputField, inputField, healthbar, table, label1, statsField);
        Pane root2 = new Pane(menuButtons);
        Pane root3 = new Pane(nameField);
        
        Scene scene1 = new Scene(root, 1052, 512);
        Scene menu = new Scene(root2, 512, 288);
        Scene nameScene = new Scene(root3, 512, 288);
                
        DropShadow shade = new DropShadow();
        root.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            root.setEffect(shade);
        });
        
        root.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            root.setEffect(null);
        });
        button_play.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            primaryStage.setScene(nameScene);
        });
        button_help.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            help=printHelp();
            textArea.appendText(help);
        });
        button_clear.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            textArea.clear();
        });
        nameField.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent k){
                if(k.getCode().equals(KeyCode.ENTER)){
                    twot.setPlayerName(nameArea.getText());
                    primaryStage.setScene(scene1);
                    primaryStage.centerOnScreen();
                    updatePlayer();
                }
            }
        });
        button_how.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e){
                    PopUps.display("HOW TO PLAY", "Move around with the 'GO' "
                            + "command. \nYou automatically pick up items if the "
                            + "interior have any available.\n");
            }
        });
        button_exit.setOnAction(actionEvent -> Platform.exit());
        
        inputField.setOnKeyPressed(new EventHandler<KeyEvent>(){
            public void handle(KeyEvent k){
                if(k.getCode().equals(KeyCode.ENTER)){
                        String temp = inputArea.getText().toLowerCase();
                        String[] word = temp.split(" ");
                        CommandWords commandWordd = new CommandWords();
                        if(word.length >= 2){
                        Command command = new Command(commandWordd.getCommandWord(word[0]), word[1]);
                        CommandWord commandWord = command.getCommandWord();
                        
                            switch(commandWord){
                                case GO:
                                    for(String s: twot.goTo(command)){
                                        textArea.appendText("\n" + s + "\n");
                                    }
                                    inputArea.clear();
                                    updateInventory();
                                    updatePlayer();
                                    updateHealth();
                                    break;
                                
                                case USE:
                                    for(String s: twot.useItem(command)){
                                        textArea.appendText("\n" + s + "\n");
                                    }
                                    inputArea.clear();
                                    updateInventory();
                                    updatePlayer();
                                    updateHealth();
                                    break;
                                
                                default:
                                    textArea.appendText("\ndoes not compute ");
                                    inputArea.clear();
                                    break;
                                
                            }
                        }
                        else{
                            textArea.appendText("\nYou must enter the commandword, and direction!");
                            inputArea.clear();
                        }
                }     
            }
        });
                
        button_exit.setOnAction(actionEvent -> Platform.exit());
        button_exitMenu.setOnAction(actionEvent -> Platform.exit());       
        
        primaryStage.setScene(menu);
        primaryStage.centerOnScreen();
        primaryStage.show();
        
        String welcome = "";
        for(HashMap.Entry<Integer, String> entry : twot.getWelcomeMessages().entrySet()){
            welcome = welcome + entry.getValue();
        }
        textArea.appendText(welcome);
    }
    
    public void updatePlayer(){
        statsArea.clear();
        statsArea.appendText("****************************\n");
        statsArea.appendText("** Player name: " + twot.getPlayerName() + "\n");
        statsArea.appendText("** Attack value: " + twot.getPlayerAtt() + "\n");
        statsArea.appendText("** Defense value: " + twot.getPlayerDeff() + "\n");
        statsArea.appendText("** Gold: " + twot.getPlayerGold() + "\n");
        statsArea.appendText("****************************");
    }
    
    public void updateHealth(){
        label1.setText("Health "+ twot.getPlayerHealth());
        healthbar.setProgress(twot.getPlayerHealth()/100);
    }
    
    public void updateInventory(){
        List<Item> l = twot.getInventoryItems();
        data.removeAll(data);
        for(Item i: l){
            if(i instanceof UseableItem){
                data.add(new InventoryItems(i.getItemName(), "Usable Item", i.getItemDescription()));
            } else if (i instanceof QuestItem) {
                data.add(new InventoryItems(i.getItemName(), "Quest Item", i.getItemDescription()));
            } else if(i instanceof EquippableItem) {
                data.add(new InventoryItems(i.getItemName(), "Equippable Item", i.getItemDescription()));
            }
        }
    }
}