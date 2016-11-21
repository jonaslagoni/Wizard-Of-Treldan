/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import TWoT_A1.Command;
import TWoT_A1.CommandWord;
import TWoT_A1.EquippableItem;
import TWoT_A1.Item;
import TWoT_A1.QuestItem;
import TWoT_A1.TWoT;
import TWoT_A1.UseableItem;
import java.util.HashMap;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Lagoni
 */
public class PlayerInventory {
    private AnchorPane menu;
    private Text weaponValue;
    private Text bootsValue;
    private Text pantsValue;
    private Text ringValue;
    private Text chestValue;
    private Text glovesValue;
    private Text headValue;
    private Text amuletValue;
    private ObservableList<AnchorPane> items;
    private ListView<AnchorPane> list;
    private ProgressBar pb;
    private boolean shown;
    private Text deffv;
    private Text attv;
    /**
     * PlayerInventory object
     * @param game 
     */
    public PlayerInventory(TWoT game, TextArea infobox){
        //since not shown from start set the boolean to false
        shown = false;
        
        //create a new main AnchorPane for the components
        menu = new AnchorPane();
        menu.getStyleClass().add("inventory");
        menu.relocate(724, 0);
        menu.setPrefSize(300, 512);
        
        /**
         * Create a ProgressBar to indicate the players health.
         * From start set the bar to playerhealth divided by 100
         */
        pb = new ProgressBar(game.getPlayerHealth()/100);
        pb.setPrefSize(292, 10);
        pb.relocate(4, 25);
        menu.getChildren().add(pb);
        
        //Adding a Text component to indicate the player's attack value.
        attv = new Text("" + game.getPlayerAtt());
        attv.relocate(60, 64);
        attv.setFont(Font.font("Verdana", javafx.scene.text.FontWeight.SEMI_BOLD, 15));
        attv.setFill(Color.WHITE);
        menu.getChildren().add(attv);
        
        //Adding a Text component to indicate the player's deffensive value.
        deffv = new Text("" + game.getPlayerDeff());
        deffv.relocate(216, 64);
        deffv.setFont(Font.font("Verdana", javafx.scene.text.FontWeight.SEMI_BOLD, 15));
        deffv.setFill(Color.WHITE);
        menu.getChildren().add(deffv);
        
        //Adding a ListView containting AnchorPane's
        list = new ListView();
        //adding css style to the ListView
        list.getStyleClass().add("inventoryList");
        list.relocate(4, 245);
        list.setPrefWidth(292);
        list.setPrefHeight(210);
        //adding the ObservableList which contains an achorpane to each Item in the player's inventory
        items = FXCollections.observableArrayList ();
        //get the List of Items the player have in the inventory
        List<Item> items_ingame = game.getInventoryItems();
        //Go through each Item in the List
        for(Item i: items_ingame){
            //create a new achorpane to each Item
            AnchorPane t = new AnchorPane();
            //Add a Text component with th name of the item
            Text itemName = new Text(i.getItemName());
            itemName.setFill(Color.AZURE);
            itemName.relocate(0, 3);
            t.getChildren().add(itemName);
            //Add a Text component which indicated the type of item
            Text itemType;
            if(i instanceof EquippableItem){
                switch (((EquippableItem) i).geteItem()){
                    case AMULET_SLOT:
                        itemType = new Text("Amulet");
                        break;
                    case BOOT_SLOT:
                        itemType = new Text("Boots");
                        break;
                    case CHEST_SLOT:
                        itemType = new Text("Chest");
                        break;
                    case GLOVES_SLOT:
                        itemType = new Text("Gloves");
                        break;
                    case HEAD_SLOT:
                        itemType = new Text("Helmet");
                        break;
                    case LEG_SLOT:
                        itemType = new Text("Leggings");
                        break;
                    case RING_SLOT:
                        itemType = new Text("Ring");
                        break;
                    case WEAPON_SLOT:
                        itemType = new Text("Weapon");
                        break;
                    default:
                        itemType = new Text("Item");
                        break;
                }
            }else if(i instanceof UseableItem){
                itemType = new Text("UI");
            }else if(i instanceof QuestItem){
                itemType = new Text("QI");
            }else{
                itemType = new Text("I");
            }
            itemType.setFill(Color.GOLDENROD);
            itemType.relocate(220, 3);
            t.getChildren().add(itemType);
            
            //add the pane to the ObservableList
            items.add(t);
        }
        //add the ObservableList to the ListView
        list.setItems(items);
        //add the ListView to the pane
        menu.getChildren().add(list);
        
        //create a Text component for each of the enum types of equippable items a player can have
        weaponValue = new Text("0");
        weaponValue.relocate(110, 117);
        weaponValue.setFont(Font.font("Verdana", javafx.scene.text.FontWeight.SEMI_BOLD, 15));
        weaponValue.setFill(Color.WHITE);
        menu.getChildren().add(weaponValue);
        
        bootsValue = new Text("0");
        bootsValue.relocate(110, 144);
        bootsValue.setFont(Font.font("Verdana", javafx.scene.text.FontWeight.SEMI_BOLD, 15));
        bootsValue.setFill(Color.WHITE);
        menu.getChildren().add(bootsValue);
        
        pantsValue = new Text("0");
        pantsValue.relocate(110, 171);
        pantsValue.setFont(Font.font("Verdana", javafx.scene.text.FontWeight.SEMI_BOLD, 15));
        pantsValue.setFill(Color.WHITE);
        menu.getChildren().add(pantsValue);
        
        ringValue = new Text("0");
        ringValue.relocate(110, 198);
        ringValue.setFont(Font.font("Verdana", javafx.scene.text.FontWeight.SEMI_BOLD, 15));
        ringValue.setFill(Color.WHITE);
        menu.getChildren().add(ringValue);
        
        chestValue = new Text("0");
        chestValue.relocate(260, 117);
        chestValue.setFont(Font.font("Verdana", javafx.scene.text.FontWeight.SEMI_BOLD, 15));
        chestValue.setFill(Color.WHITE);
        menu.getChildren().add(chestValue);
        
        glovesValue = new Text("0");
        glovesValue.relocate(260, 144);
        glovesValue.setFont(Font.font("Verdana", javafx.scene.text.FontWeight.SEMI_BOLD, 15));
        glovesValue.setFill(Color.WHITE);
        menu.getChildren().add(glovesValue);
        
        headValue = new Text("0");
        headValue.relocate(260, 171);
        headValue.setFont(Font.font("Verdana", javafx.scene.text.FontWeight.SEMI_BOLD, 15));
        headValue.setFill(Color.WHITE);
        menu.getChildren().add(headValue);
        
        amuletValue = new Text("0");
        amuletValue.relocate(260, 198);
        amuletValue.setFont(Font.font("Verdana", javafx.scene.text.FontWeight.SEMI_BOLD, 15));
        amuletValue.setFill(Color.WHITE);
        menu.getChildren().add(amuletValue);
        
        //return the HashMap of equipped items
        HashMap<EquippableItem.EItem, EquippableItem> eqItems = game.getEquippableItems();
        //go through each of the entries in the HashMap
        for(java.util.Map.Entry<EquippableItem.EItem, EquippableItem> entry: eqItems.entrySet()){
            //check if the entry is not null
            if(null != entry.getKey()){
                //check the enum type of the equipped item and set the corresponding value.
                switch (entry.getKey()){
                    case AMULET_SLOT:
                        amuletValue.setText("" + entry.getValue().getDefenseBuff());
                        break;
                    case BOOT_SLOT:
                        bootsValue.setText("" + entry.getValue().getDefenseBuff());
                        break;
                    case CHEST_SLOT:
                        chestValue.setText("" + entry.getValue().getDefenseBuff());
                        break;
                    case GLOVES_SLOT:
                        glovesValue.setText("" + entry.getValue().getDefenseBuff());
                        break;
                    case HEAD_SLOT:
                        headValue.setText("" + entry.getValue().getDefenseBuff());
                        break;
                    case LEG_SLOT:
                        pantsValue.setText("" + entry.getValue().getDefenseBuff());
                        break;
                    case RING_SLOT:
                        ringValue.setText("" + entry.getValue().getDefenseBuff());
                        break;
                    case WEAPON_SLOT:
                        weaponValue.setText("" + entry.getValue().getAttackBuff());
                        break;
                    default:
                        break;
                }
            }
        }
        
        Button use = new Button("Use");
        use.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                AnchorPane t = getSelected();
                if (t != null) {
                    Text text = (Text) t.getChildren().get(0);
                    for (String s : game.useItem(new Command(CommandWord.USE, text.getText()))) {
                        infobox.appendText(s + "\n");
                    }
                    update(game);
                }
            }
        });
        use.relocate(10, 470);
        menu.getChildren().add(use);

        Button equip = new Button("equip");
        equip.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                AnchorPane t = getSelected();
                if (t != null) {
                    Text text = (Text) t.getChildren().get(0);
                    for (String s : game.equipItem(new Command(CommandWord.USE, text.getText()))) {
                        infobox.appendText(s + "\n");
                    }
                    update(game);
                }
            }
        });
        equip.relocate(90, 470);
        menu.getChildren().add(equip);
        
    }

    /**
     * @return the menu
     */
    public AnchorPane getMenu() {
        return menu;
    }
    
    /**
     * Updates all relevent information.
     * @param game 
     */
    public void update(TWoT game){
        /**
         * Update the equipped items
         */
        HashMap<EquippableItem.EItem, EquippableItem> eqItems = game.getEquippableItems();
        for(java.util.Map.Entry<EquippableItem.EItem, EquippableItem> entry: eqItems.entrySet()){
            if(null != entry.getKey()){
                switch (entry.getKey()){
                    case AMULET_SLOT:
                        amuletValue.setText("" + entry.getValue().getDefenseBuff());
                        break;
                    case BOOT_SLOT:
                        bootsValue.setText("" + entry.getValue().getDefenseBuff());
                        break;
                    case CHEST_SLOT:
                        chestValue.setText("" + entry.getValue().getDefenseBuff());
                        break;
                    case GLOVES_SLOT:
                        glovesValue.setText("" + entry.getValue().getDefenseBuff());
                        break;
                    case HEAD_SLOT:
                        headValue.setText("" + entry.getValue().getDefenseBuff());
                        break;
                    case LEG_SLOT:
                        pantsValue.setText("" + entry.getValue().getDefenseBuff());
                        break;
                    case RING_SLOT:
                        ringValue.setText("" + entry.getValue().getDefenseBuff());
                        break;
                    case WEAPON_SLOT:
                        weaponValue.setText("" + entry.getValue().getAttackBuff());
                        break;
                    default:
                        break;
                }
            }
        }
        
        /**
         * Remove all the items in the ListView and then them again.
         */
        items.removeAll(items);
        List<Item> items_ingame = game.getInventoryItems();
        for(Item i: items_ingame){
            AnchorPane t = new AnchorPane();
            Text itemName = new Text(i.getItemName());
            itemName.setFill(Color.AZURE);
            itemName.relocate(0, 3);
            t.getChildren().add(itemName);
            Text itemType;
            if(i instanceof EquippableItem){
                switch (((EquippableItem) i).geteItem()){
                    case AMULET_SLOT:
                        itemType = new Text("Amulet");
                        break;
                    case BOOT_SLOT:
                        itemType = new Text("Boots");
                        break;
                    case CHEST_SLOT:
                        itemType = new Text("Chest");
                        break;
                    case GLOVES_SLOT:
                        itemType = new Text("Gloves");
                        break;
                    case HEAD_SLOT:
                        itemType = new Text("Helmet");
                        break;
                    case LEG_SLOT:
                        itemType = new Text("Leggings");
                        break;
                    case RING_SLOT:
                        itemType = new Text("Ring");
                        break;
                    case WEAPON_SLOT:
                        itemType = new Text("Weapon");
                        break;
                    default:
                        itemType = new Text("Item");
                        break;
                }
            }else if(i instanceof UseableItem){
                itemType = new Text("UI");
            }else if(i instanceof QuestItem){
                itemType = new Text("QI");
            }else{
                itemType = new Text("I");
            }
            itemType.setFill(Color.GOLDENROD);
            itemType.relocate(220, 3);
            t.getChildren().add(itemType);
            items.add(t);
        }
        
        //Update the healthbar
        pb.setProgress(game.getPlayerHealth()/100);
        
        //update the user's attack and deff values
        attv.setText(""+game.getPlayerAtt());
        deffv.setText(""+game.getPlayerDeff());
    }

    /**
     * @return the shown
     */
    public boolean isShown() {
        return shown;
    }

    /**
     * @param shown the shown to set
     */
    public void setShown(boolean shown) {
        this.shown = shown;
    }
    
    /**
     * Returns the selected Pane from the ListView.
     * @return 
     */
    public AnchorPane getSelected(){
        return list.getSelectionModel().getSelectedItem();
    }
    
}
