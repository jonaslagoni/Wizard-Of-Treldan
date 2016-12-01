/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleWithButtons;

import Gui2D.WizardOfTreldan;
import TWoT_A1.*;
import static TWoT_A1.EquippableItem.EItem.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
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
import static javafx.application.Application.launch;

/**
 *
 * @author Mathias
 */
public class GUIFX extends Application {

    private static TWoT twot;
    
    private TextArea textArea;
    private TextArea statsArea;
    private ProgressBar healthbar;
    private String help;
    private TextField nameArea;
    private VBox statsField = new VBox(20);
    private Label label1;
    private Group walkButtons = new Group();
    private int pos = 120;
    
    private TableView<InventoryItems> invTable = new TableView();
    private final ObservableList<InventoryItems> invData = FXCollections.observableArrayList();
        
    private TableView<EquippedItems> equipTable = new TableView();
    private final ObservableList<EquippedItems> equipData = FXCollections.observableArrayList();
    
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
        statsArea = new TextArea();
        nameArea = new TextField();
        Label endScore = new Label();
        
        Button button_play = new Button("NEW GAME");
        Button button_load = new Button("LOAD GAME");
        Button button_how = new Button("HOW TO PLAY");
        Button button_exitMenu = new Button("EXIT GAME");
        
        Button button_loadGame = new Button("Load Game");
        Button button_exitToMenu = new Button("Exit To Menu");
        
        Button button_exitGame = new Button("Exit Game");
        
        
        button_loadGame.setMinWidth(180);
        button_exitToMenu.setMinWidth(180);
        button_loadGame.setMinHeight(40);
        button_exitToMenu.setMinHeight(40);
        
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
        Button button_save = new Button("Save");
        Button button_use = new Button("Use Item");
        Button button_equip = new Button("Equip Item");
        
        button_help.setMaxWidth(90);
        button_exit.setMaxWidth(90);
        button_clear.setMaxWidth(90);
        button_use.setMaxWidth(90);
        button_equip.setMaxWidth(90);
        button_save.setMaxWidth(90);
        
        VBox gameButtons = new VBox(20);
        gameButtons.setLayoutX(591 + pos);
        gameButtons.setLayoutY(10);
        gameButtons.getChildren().addAll(button_clear, button_help, button_save, button_exit);
        
        //end menu
        button_exitGame.setMinWidth(180);
        button_exitGame.setMinHeight(40);
                
        endScore.setLayoutX(110);
        endScore.setLayoutY(80);
        
        button_exitGame.setLayoutX(170);
        button_exitGame.setLayoutY(150);
        
        //load Menu
        Pane anchorpane = new Pane();
        
        ListView<AnchorPane> list = new ListView();
        ObservableList<AnchorPane> loads = FXCollections.observableArrayList ();
        List<String> loadList = getLoadList();
        
         for(String i: loadList){
            //add a new anchorpane with a Text component to the ObservableList
            AnchorPane t = new AnchorPane();
            Text itemName = new Text(i);
            itemName.relocate(0, 3);
            t.getChildren().add(itemName);
            loads.add(t);
        }
        //add the ObservableList to the ListView
        list.setItems(loads);
        //add the ListView to the pane.
        list.setPrefWidth(250);
        list.setPrefHeight(288);
        anchorpane.getChildren().add(list);
                
        VBox loadMenuButtons = new VBox(20);
        loadMenuButtons.setLayoutX(295);
        loadMenuButtons.setLayoutY(70);
        loadMenuButtons.getChildren().addAll(button_loadGame, button_exitToMenu);
        
        //smth else
        
        HBox invButtons = new HBox(20);
        invButtons.setLayoutX(770 + pos);
        invButtons.setLayoutY(420);
        invButtons.getChildren().addAll(button_use, button_equip);

        VBox menuButtons = new VBox(20);
        menuButtons.setLayoutX(166);
        menuButtons.setLayoutY(30);
        menuButtons.getChildren().addAll(button_play, button_load, button_how, button_exitMenu);
                      
        invTable.setEditable(true);
        List<Item> l = twot.getInventoryItems();
        for(Item i: l){
            if(i instanceof UseableItem){
                invData.add(new InventoryItems(i.getItemName(), "Usable Item", i.getItemDescription()));
            } else if (i instanceof QuestItem) {
                invData.add(new InventoryItems(i.getItemName(), "Quest Item", i.getItemDescription()));
            } else if(i instanceof EquippableItem) {
                invData.add(new InventoryItems(i.getItemName(), "Equippable Item", i.getItemDescription()));
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
 
        invTable.setItems(invData);
        invTable.getColumns().addAll(itemName, itemType, itemDescription);
        invTable.setLayoutX(652 + pos);
        equipTable.setEditable(false);
        HashMap<EquippableItem.EItem, EquippableItem> k = twot.getEquippableItems();
        for(Map.Entry<EquippableItem.EItem, EquippableItem> entry : k.entrySet()){
            if(entry.getKey() == AMULET_SLOT) {
                equipData.add(new EquippedItems(entry.getValue().getItemName(), "Amulet Slot", entry.getValue().getAttackBuff(), entry.getValue().getDefenseBuff()));
            }else if(entry.getKey() == (HEAD_SLOT)) {
                equipData.add(new EquippedItems(entry.getValue().getItemName(), "Head slot", entry.getValue().getAttackBuff(), entry.getValue().getDefenseBuff()));
            }else if(entry.getKey() == (WEAPON_SLOT)) {
                equipData.add(new EquippedItems(entry.getValue().getItemName(), "Weapon Slot", entry.getValue().getAttackBuff(), entry.getValue().getDefenseBuff()));
            }else if(entry.getKey() == (CHEST_SLOT)) {
                equipData.add(new EquippedItems(entry.getValue().getItemName(), "Chest Slot", entry.getValue().getAttackBuff(), entry.getValue().getDefenseBuff()));
            }else if(entry.getKey() == (LEG_SLOT)) {
                equipData.add(new EquippedItems(entry.getValue().getItemName(), "Leg Slot", entry.getValue().getAttackBuff(), entry.getValue().getDefenseBuff()));
            }else if(entry.getKey() == (BOOT_SLOT)) {
                equipData.add(new EquippedItems(entry.getValue().getItemName(), "Boot Slot", entry.getValue().getAttackBuff(), entry.getValue().getDefenseBuff()));
            }else if(entry.getKey() == (GLOVES_SLOT)) {
                equipData.add(new EquippedItems(entry.getValue().getItemName(), "Glove Slot", entry.getValue().getAttackBuff(), entry.getValue().getDefenseBuff()));
            }else if(entry.getKey() == (RING_SLOT)) {
                equipData.add(new EquippedItems(entry.getValue().getItemName(), "Ring Slot", entry.getValue().getAttackBuff(), entry.getValue().getDefenseBuff()));
            }
        }
        
        TableColumn itemNames = new TableColumn("Item Name");
        itemNames.setMinWidth(100);
        itemNames.setCellValueFactory(
                new PropertyValueFactory<EquippedItems, String>("itemNames"));
 
        TableColumn itemSlot = new TableColumn("Item Slot");
        itemSlot.setMinWidth(90);
        itemSlot.setCellValueFactory(
                new PropertyValueFactory<EquippedItems, String>("itemSlots"));
 
        TableColumn itemAttack = new TableColumn("Attack");
        itemAttack.setMaxWidth(90);
        itemAttack.setMinWidth(90);
        itemAttack.setCellValueFactory(
                new PropertyValueFactory<EquippedItems, String>("itemAttack"));
        
        TableColumn itemDefence = new TableColumn("Defence");
        itemDefence.setMaxWidth(90);
        itemDefence.setMinWidth(90);
        itemDefence.setCellValueFactory(
                new PropertyValueFactory<EquippedItems, String>("itemDefence"));
        
        equipTable.setItems(equipData);
        equipTable.getColumns().addAll(itemNames, itemSlot, itemAttack, itemDefence);
        equipTable.setLayoutX(264 + pos);
        equipTable.setLayoutY(265);
        equipTable.setMinWidth(370);
        equipTable.setMaxWidth(370);
        equipTable.setMinHeight(235);
        equipTable.setMaxHeight(235);
        
        VBox outputField = new VBox(20);
        textArea.setMaxWidth(572);
        outputField.setLayoutX(pos);
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
        statsField.relocate(0 + pos, 300);
        statsField.getChildren().addAll(statsArea);
        
        healthbar = new ProgressBar(twot.getPlayerHealth()/100);
        healthbar.setStyle("-fx-accent: red;");
        healthbar.setPrefSize(256, 26);
        healthbar.relocate(0 + pos, 265);
                       
        label1 = new Label("Health "+ twot.getPlayerHealth());
        label1.setTextFill(Color.web("BLACK"));
        label1.relocate(10 + pos, 269);
        
        
        Label setNamePls = new Label("ENTER YOUR NAME: ");
        
        VBox nameField = new VBox();
        nameField.setMaxWidth(300);
        nameField.setMinWidth(300);
        nameField.setMaxHeight(50);
        nameField.setMinHeight(50);
        nameField.relocate(106, 119);
        nameField.getChildren().addAll(setNamePls, nameArea);
        
        Pane root = new Pane(equipTable, invButtons, gameButtons, outputField, healthbar, invTable, label1, statsField, walkButtons);
        Pane root2 = new Pane(menuButtons);
        Pane root3 = new Pane(nameField);
        Pane root4 = new Pane(loadMenuButtons, anchorpane);
        Pane root5 = new Pane(endScore, button_exitGame);
        
        
        Scene scene1 = new Scene(root, 1052 + pos, 512);
        Scene menu = new Scene(root2, 512, 288);
        Scene nameScene = new Scene(root3, 512, 288);
        Scene loadMenu = new Scene(root4, 512, 288);
        Scene endMenu = new Scene(root5, 512, 288);
                
        DropShadow shade = new DropShadow();
        root.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            root.setEffect(shade);
        });
        root.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            root.setEffect(null);
        });
        
        button_equip.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            
            for(String s: twot.equipItem(new Command(CommandWord.USE, invTable.getSelectionModel().getSelectedItem().getItemName()))){
                if(invTable.getSelectionModel().getSelectedItem().getItemType() == "Equippable Item"){
                textArea.appendText("\n" + s);
                updateGUI();
                } else {
                    textArea.appendText("\nThis item cannot be equipped.");
                }
            }
        });
        button_loadGame.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            TWoT loadedGame = getLoad((((Text)list.getSelectionModel().getSelectedItem().getChildren().get(0)).getText()));
            //set the game to the loaded instance
            setGame(loadedGame);
            primaryStage.setScene(scene1);
            primaryStage.centerOnScreen();
            textArea.clear();
            textArea.appendText(loadedGame.getCurrentRoomDescription());
            updateGUI();
        });
        button_load.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            primaryStage.setScene(loadMenu);
        });
        button_save.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            saveGame();
            textArea.appendText("\n\nGame has been saved. It can be loaded from the start menu.\n\n");
        });
        button_use.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            for(String s: twot.useItem(new Command(CommandWord.USE, invTable.getSelectionModel().getSelectedItem().getItemName()))){
                if(invTable.getSelectionModel().getSelectedItem().getItemType() == "Usable Item"){
                textArea.appendText("\n" + s);
                updateGUI();
                } else {
                    textArea.appendText("\nThis item cannot be used.");
                }
            }
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
                    updateGUI();
                }
            }
        });
        button_how.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e){
                    PopUps.display("HOW TO PLAY", "Move around with the 'go [interactable object]' "
                            + "command. \nYou automatically pick up items if the "
                            + "interior have any available.\n"
                            + "You lose score points when you die but you are free to continue the game as if nothing happened.");
            }
        });
        button_exitToMenu.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            primaryStage.setScene(menu);
        });
                
        button_exit.setOnAction(actionEvent -> Platform.exit());        
        button_exitMenu.setOnAction(actionEvent -> Platform.exit());  
        button_exitGame.setOnAction(actionEvent -> Platform.exit());
        
        primaryStage.setScene(menu);
        primaryStage.centerOnScreen();
        primaryStage.show();
        
        String welcome = "";
        for(HashMap.Entry<Integer, String> entry : twot.getWelcomeMessages().entrySet()){
            welcome = welcome + entry.getValue();
        }
        textArea.appendText(welcome);
    }
    
    public void updateGUI(){
        updatePlayer();
        updateHealth();
        updateInventory();
        updateEquipInventory();
        updateButtons();
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
        if(twot.getPlayerHealth() <= 100 && twot.getPlayerHealth() > 66){
            healthbar.setStyle("-fx-accent: green;");
        } else if (twot.getPlayerHealth() <= 66 && twot.getPlayerHealth() > 33){
            healthbar.setStyle("-fx-accent: yellow;");
        } else if (twot.getPlayerHealth() <= 33 && twot.getPlayerHealth() > 0){
            healthbar.setStyle("-fx-accent: red;");
        }
    }
    
    public void updateInventory(){
        List<Item> l = twot.getInventoryItems();
        invData.removeAll(invData);
        for(Item i: l){
            if(i instanceof UseableItem){
                invData.add(new InventoryItems(i.getItemName(), "Usable Item", i.getItemDescription()));
            } else if (i instanceof QuestItem) {
                invData.add(new InventoryItems(i.getItemName(), "Quest Item", i.getItemDescription()));
            } else if(i instanceof EquippableItem) {
                invData.add(new InventoryItems(i.getItemName(), "Equippable Item", i.getItemDescription()));
            }
        }
    }
    
    public void updateEquipInventory(){
        HashMap<EquippableItem.EItem, EquippableItem> k = twot.getEquippableItems();
        equipData.removeAll(equipData);
        for(Map.Entry<EquippableItem.EItem, EquippableItem> entry : k.entrySet()){
            if(entry.getKey() == AMULET_SLOT) {
                equipData.add(new EquippedItems(entry.getValue().getItemName(), "Amulet Slot", entry.getValue().getAttackBuff(), entry.getValue().getDefenseBuff()));
            }else if(entry.getKey() == (HEAD_SLOT)) {
                equipData.add(new EquippedItems(entry.getValue().getItemName(), "Head slot", entry.getValue().getAttackBuff(), entry.getValue().getDefenseBuff()));
            }else if(entry.getKey() == (WEAPON_SLOT)) {
                equipData.add(new EquippedItems(entry.getValue().getItemName(), "Weapon Slot", entry.getValue().getAttackBuff(), entry.getValue().getDefenseBuff()));
            }else if(entry.getKey() == (CHEST_SLOT)) {
                equipData.add(new EquippedItems(entry.getValue().getItemName(), "Chest Slot", entry.getValue().getAttackBuff(), entry.getValue().getDefenseBuff()));
            }else if(entry.getKey() == (LEG_SLOT)) {
                equipData.add(new EquippedItems(entry.getValue().getItemName(), "Leg Slot", entry.getValue().getAttackBuff(), entry.getValue().getDefenseBuff()));
            }else if(entry.getKey() == (BOOT_SLOT)) {
                equipData.add(new EquippedItems(entry.getValue().getItemName(), "Boot Slot", entry.getValue().getAttackBuff(), entry.getValue().getDefenseBuff()));
            }else if(entry.getKey() == (GLOVES_SLOT)) {
                equipData.add(new EquippedItems(entry.getValue().getItemName(), "Glove Slot", entry.getValue().getAttackBuff(), entry.getValue().getDefenseBuff()));
            }else if(entry.getKey() == (RING_SLOT)) {
                equipData.add(new EquippedItems(entry.getValue().getItemName(), "Ring Slot", entry.getValue().getAttackBuff(), entry.getValue().getDefenseBuff()));
            }
        }
    }
    
     public void updateButtons() {
                      
        switch (twot.getCurrentRoomId()) {
            case 1:
                walkButtons.getChildren().removeAll(walkButtons.getChildren());
                walkButtons.getChildren().add(cellarButtons());
                break;
            case 2:
                walkButtons.getChildren().removeAll(walkButtons.getChildren());
                walkButtons.getChildren().add(villageButtons());
                break;
            case 3:
                walkButtons.getChildren().removeAll(walkButtons.getChildren());
                walkButtons.getChildren().add(house1Buttons());
                break;
            case 4:
                walkButtons.getChildren().removeAll(walkButtons.getChildren());
                walkButtons.getChildren().add(house2Buttons());
                break;
            case 5:
                walkButtons.getChildren().removeAll(walkButtons.getChildren());
                walkButtons.getChildren().add(house3Buttons());
                break;
            case 6:
                walkButtons.getChildren().removeAll(walkButtons.getChildren());
                walkButtons.getChildren().add(forestButtons());
                break;
            case 7:
                walkButtons.getChildren().removeAll(walkButtons.getChildren());
                walkButtons.getChildren().add(wizardHouseButtons());
                break;
            case 8:
                walkButtons.getChildren().removeAll(walkButtons.getChildren());
                walkButtons.getChildren().add(caveButtons());
                break;
            case 9:
                walkButtons.getChildren().removeAll(walkButtons.getChildren());
                walkButtons.getChildren().add(lairButtons());
                break;
            case 10:
                walkButtons.getChildren().removeAll(walkButtons.getChildren());
                walkButtons.getChildren().add(clearingButtons());
                break;
            case 11:
                walkButtons.getChildren().removeAll(walkButtons.getChildren());
                walkButtons.getChildren().add(dungeonButtons());
                break;
            case 12:
                walkButtons.getChildren().removeAll(walkButtons.getChildren());
                walkButtons.getChildren().add(libraryButtons());
                break;
            case 13:
                walkButtons.getChildren().removeAll(walkButtons.getChildren());
                walkButtons.getChildren().add(evilWizardsButtons());
                break;
            default:
                break;
        }      
    }
     
    public void saveGame(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        Date date = new Date();
        String strDate = sdf.format(date);
        try {
            FileOutputStream fos = new FileOutputStream("loads/" + twot.getCurrentRoomName() + "-" + strDate + ".data");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(twot);
            oos.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } 
    }
    public void saveGame(String name) {
        try {
            FileOutputStream fos = new FileOutputStream("loads/" + name +  ".data");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(twot);
            oos.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public List<String> getLoadList(){
        //create empty arraylist.
        List<String> loadList = new ArrayList();
        //try to get each file in the directory "loads" by using Files.walk
        try{
            //Go through each Path in the Stream.
            Stream<Path> paths = Files.walk(Paths.get("loads/"));
            paths.forEach(filePath -> {
                //if the file is a FILE continue
                if (Files.isRegularFile(filePath)) {
                    //add the filename with extenstion to the List.
                    loadList.add(filePath.getFileName().toString());
                }
            });
        } catch (IOException ex) {
            System.out.println("FAIL");
        }
        //return the List
        return loadList;
    }
    
     public TWoT getLoad(String filename){
        //Try loading the file. 
        try {
            //Read from the stored file in folder "loads"
            FileInputStream fileInputStream = new FileInputStream(new File("loads/" + filename));
            //Create a ObjectInputStream object from the FileInputStream
            ObjectInputStream input = new ObjectInputStream(fileInputStream);
            //load the TWoT file into object
            TWoT twot = (TWoT) input.readObject();
            //close the objects
            input.close();
            fileInputStream.close();
            //returns the gamefile
            return twot;
        } catch (FileNotFoundException e) {
                System.out.println("File not found");
        } catch (IOException e) {
                System.out.println("Wrong version of game");
        } catch (ClassNotFoundException e) {
                System.out.println("Game was not found.");
        }
        return null;
    }
     
    public void setGame(TWoT loaded){
        twot = loaded;
    }


//WALK BUTTONS
    
    CommandWords commandword = new CommandWords();
      
    private Group cellarButtons() {
        
        Button button_haystack = new Button("Haystack");
        Button button_table = new Button("Table");
        Button button_door = new Button("Door");
        
        button_haystack.setPrefSize(110, 10);
        button_table.setPrefSize(110, 10);
        button_door.setPrefSize(110, 10);
        
        VBox cellarButtons = new VBox(20);
        cellarButtons.setLayoutX(5);
        cellarButtons.setLayoutY(10);
        
        cellarButtons.getChildren().addAll(button_haystack, button_table, button_door);
        
        walkButtons = new Group(cellarButtons);
        
        button_haystack.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "haystack");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
                
            }
            updateGUI();
        });
        button_table.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "table");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_door.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "door");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
                
            }
            updateGUI();
        });
        return walkButtons;
    }
    
    private Group villageButtons() {
        
        Button button_reborn = new Button("House 1");
        Button button_riches = new Button("House 2");
        Button button_hOfGuard = new Button("House 3");
        Button button_guard = new Button("The Guard");
        Button button_axe = new Button("Axe");
        Button button_forest = new Button("Forest");
        
        button_reborn.setPrefSize(110, 10);
        button_riches.setPrefSize(110, 10);
        button_hOfGuard.setPrefSize(110, 10);
        button_guard.setPrefSize(110, 10);
        button_axe.setPrefSize(110, 10);
        button_forest.setPrefSize(110, 10);
        
        VBox villageButtons = new VBox(20);
        //if guard children not delivered.
        
        
        
        villageButtons.getChildren().addAll(button_reborn, button_riches, button_hOfGuard, button_guard, button_axe);
        
        walkButtons = new Group(villageButtons);
        
        button_reborn.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "house1");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_riches.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "house2");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_hOfGuard.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "house3");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_guard.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "guard");
           /* for(Item i : twot.getInventoryItems()){
                if(i.getItemId() == 99902){
                villageButtons.getChildren().add(button_forest);
            }
                updateGUI();*/
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_axe.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "axe");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_forest.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "forest");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        return walkButtons;
    }

    private Group house1Buttons() {
        
        Button button_man = new Button("Man");
        Button button_chest = new Button("Chest");
        Button button_door = new Button("Door");
        
        button_man.setPrefSize(110, 10);
        button_chest.setPrefSize(110, 10);
        button_door.setPrefSize(110, 10);
        
        VBox house1Buttons = new VBox(20);
        house1Buttons.getChildren().addAll(button_man, button_chest, button_door);
        Group root = new Group(house1Buttons);
        
        
        button_man.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "man");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_chest.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "chest");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_door.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "door");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        
        return root;
    }
    private Group house2Buttons() {
        
        Button button_door = new Button("Door");
        Button button_wardrobe = new Button("Wardrobe");
        Button button_bed = new Button("Bed");
        Button button_table = new Button("Table");
        
        button_door.setPrefSize(110, 10);
        button_wardrobe.setPrefSize(110, 10);
        button_bed.setPrefSize(110, 10);
        button_table.setPrefSize(110, 10);
        
        VBox house2Buttons = new VBox(20);
        house2Buttons.getChildren().addAll(button_door, button_wardrobe, button_bed, button_table);
        Group root = new Group(house2Buttons);
        
        
        button_door.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "door");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_wardrobe.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "wardrobe");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_bed.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "bed");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_table.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "table");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        
        return root;
    }
    private Group house3Buttons() {
        
        Button button_door = new Button("Door");
        Button button_kitchen = new Button("Kitchen");
        Button button_woman = new Button("Woman");
        Button button_chest = new Button("Chest");
        
        button_door.setPrefSize(110, 10);
        button_kitchen.setPrefSize(110, 10);
        button_woman.setPrefSize(110, 10);
        button_chest.setPrefSize(110, 10);
        
        VBox house3Buttons = new VBox(20);
        house3Buttons.getChildren().addAll(button_door, button_kitchen, button_woman, button_chest);
        Group root = new Group(house3Buttons);
        
        
        button_door.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "door");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_kitchen.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "kitchen");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_woman.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "woman");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_chest.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "chest");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        
        return root;
    }
    private Group forestButtons() {
        
        Button button_mushroom = new Button("Mushroom");
        Button button_goblin = new Button("Dead goblin");
        Button button_house = new Button("Wiz House");
        Button button_cave = new Button("Cave");
        Button button_clearing = new Button("Clearing");
        Button button_village = new Button("Village");
        
        button_mushroom.setPrefSize(110, 10);
        button_goblin.setPrefSize(110, 10);
        button_house.setPrefSize(110, 10);
        button_cave.setPrefSize(110, 10);
        button_clearing.setPrefSize(110, 10);
        button_village.setPrefSize(110, 10);
        
        VBox forestButtons = new VBox(20);
        forestButtons.getChildren().addAll(button_mushroom, button_goblin, button_house, button_cave, button_clearing, button_village);
        
        Group root = new Group(forestButtons);
        
        
        button_mushroom.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "mushroom");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_goblin.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "goblin");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_house.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "house");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_cave.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "cave");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_clearing.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "clearing");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_village.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "village");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        
        return root;
    }
    private Group wizardHouseButtons() {
        
        Button button_upstairs = new Button("Upstairs");
        Button button_box = new Button("Box");
        Button button_lab = new Button("Lab");
        Button button_wizard = new Button("Wizard");
        Button button_door = new Button("Door");
        
        button_upstairs.setPrefSize(110, 10);
        button_box.setPrefSize(110, 10);
        button_lab.setPrefSize(110, 10);
        button_wizard.setPrefSize(110, 10);
        button_door.setPrefSize(110, 10);
        
        VBox wizardHouseButtons = new VBox(20);
        wizardHouseButtons.getChildren().addAll(button_upstairs, button_box, button_lab, button_wizard, button_door);
        
        Group root = new Group(wizardHouseButtons);
        
        
        button_upstairs.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "upstairs");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_box.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "box");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_lab.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "lab");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_wizard.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "wizard");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_door.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "door");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        
        return root;
    }
    private Group caveButtons() {
        
        Button button_troll1 = new Button("Troll");
        Button button_troll2 = new Button("Troll");
        Button button_troll3 = new Button("Troll");
        Button button_forest = new Button("Forest");
        Button button_lair = new Button("Lair");
        
        button_troll1.setPrefSize(110, 10);
        button_troll2.setPrefSize(110, 10);
        button_troll3.setPrefSize(110, 10);
        button_forest.setPrefSize(110, 10);
        button_lair.setPrefSize(110, 10);
        
        VBox caveButtons = new VBox(20);
        caveButtons.getChildren().addAll(button_troll1, button_troll2, button_troll3, button_forest, button_lair);
        
        Group root = new Group(caveButtons);
        
        
        button_troll1.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "troll");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_troll2.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "troll");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_troll3.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "troll");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_forest.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "forest");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_lair.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "lair");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        
        return root;
    }
    private Group lairButtons() {
        
        Button button_gruul = new Button("Gruul");
        Button button_cave = new Button("Cave");
        
        button_gruul.setPrefSize(110, 10);
        button_cave.setPrefSize(110, 10);
        
        VBox lairButtons = new VBox(20);
        lairButtons.getChildren().addAll(button_gruul, button_cave);
        Group root = new Group(lairButtons);
        
        
        button_gruul.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "gruul");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_cave.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "cave");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        
        return root;
    }
    
    private Group clearingButtons() {
        
        Button button_forest = new Button("Forest");
        Button button_unicorn = new Button("Unicorn");
        Button button_tree = new Button("Tree");
        
        button_forest.setPrefSize(110, 10);
        button_unicorn.setPrefSize(110, 10);
        button_tree.setPrefSize(110, 10);
        
        VBox clearingButtons = new VBox(20);
        clearingButtons.getChildren().addAll(button_forest, button_unicorn, button_tree);
        Group root = new Group(clearingButtons);
        
        
        button_forest.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Forest");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_unicorn.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Unicorn");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_tree.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Tree");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        
        return root;
    }
    private Group dungeonButtons() {
        
        Button button_skeleton1 = new Button("Skeleton");
        Button button_skeleton2 = new Button("Skeleton");
        Button button_skeleton3 = new Button("Skeleton");
        Button button_pathway = new Button("Pathway");
        
        button_skeleton1.setPrefSize(110, 10);
        button_skeleton2.setPrefSize(110, 10);
        button_skeleton3.setPrefSize(110, 10);
        button_pathway.setPrefSize(110, 10);
        
        VBox dungeonButtons = new VBox(20);
        dungeonButtons.getChildren().addAll(button_skeleton1, button_skeleton2, button_skeleton3, button_pathway);
        Group root = new Group(dungeonButtons);
        
        
        button_skeleton1.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "skeleton1");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_skeleton2.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "skeleton2");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_skeleton3.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "skeleton3");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_pathway.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "pathway");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        
        return root;
    }
    private Group libraryButtons() {
        
        Button button_librarian = new Button("Librarian");
        Button button_door = new Button("Door");
        Button button_chest = new Button("Chest");
        
        button_librarian.setPrefSize(110, 10);
        button_door.setPrefSize(110, 10);
        button_chest.setPrefSize(110, 10);
	
        VBox libraryButtons = new VBox(20);
        libraryButtons.getChildren().addAll(button_librarian, button_door, button_chest);
        Group root = new Group(libraryButtons);
        
        
        button_librarian.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Librarian");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_door.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Door");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_chest.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Chest");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
	
        return root;
    }
    private Group evilWizardsButtons() {
        
        Button button_evilWizard = new Button("Evil Wizard");
        Button button_minion1 = new Button("Minion1");
        Button button_minion2 = new Button("Minion2");
        
        button_evilWizard.setPrefSize(110, 10);
        button_minion1.setPrefSize(110, 10);
        button_minion2.setPrefSize(110, 10);
        
        VBox evilWizardsButtons = new VBox(20);
        evilWizardsButtons.getChildren().addAll(button_evilWizard, button_minion1, button_minion2);
        Group root = new Group(evilWizardsButtons);
        
        
        button_evilWizard.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Evil Wizard");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_minion1.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Minion1");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        button_minion2.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Command command = new Command(commandword.getCommandWord("go"), "Minion2");
            for(String s: twot.goTo(command)){
                textArea.appendText("\n" + s + "\n");
            }
            updateGUI();
        });
        
        return root;
    }
}
