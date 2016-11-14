/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import TWoT_A1.EquippableItem;
import TWoT_A1.Item;
import TWoT_A1.QuestItem;
import TWoT_A1.TWoT;
import TWoT_A1.UseableItem;
import java.util.HashMap;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
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
    public PlayerInventory(TWoT game){
        shown = false;
        menu = new AnchorPane();
        menu.getStyleClass().add("inventory");
        menu.relocate(724, 0);
        menu.setPrefSize(300, 512);
        
        
        Text health = new Text("Health: " + game.getPlayerHealth());
        health.relocate(5, 28);
        health.setFont(Font.font("Verdana", javafx.scene.text.FontWeight.SEMI_BOLD, 15));
        menu.getChildren().add(health);
        
        pb = new ProgressBar(game.getPlayerHealth()/100);
        pb.setPrefSize(292, 10);
        pb.relocate(4, 25);
        menu.getChildren().add(pb);
        
        attv = new Text("" + game.getPlayerAtt());
        attv.relocate(60, 64);
        attv.setFont(Font.font("Verdana", javafx.scene.text.FontWeight.SEMI_BOLD, 15));
        attv.setFill(Color.WHITE);
        menu.getChildren().add(attv);
        
        deffv = new Text("" + game.getPlayerDeff());
        deffv.relocate(216, 64);
        deffv.setFont(Font.font("Verdana", javafx.scene.text.FontWeight.SEMI_BOLD, 15));
        deffv.setFill(Color.WHITE);
        menu.getChildren().add(deffv);
        
        list = new ListView();
        list.getStyleClass().add("inventoryList");
        list.relocate(4, 245);
        list.setPrefWidth(300-8);
        list.setPrefHeight(210);
        items = FXCollections.observableArrayList ();
        List<Item> items_ingame = game.getInventoryItems();
        for(Item i: items_ingame){
            AnchorPane t = new AnchorPane();
            Text itemName = new Text(i.getItemName());
            itemName.setFill(Color.ORANGERED);
            itemName.relocate(0, 3);
            t.getChildren().add(itemName);
            Text itemType;
            if(i instanceof EquippableItem){
                itemType = new Text("EI");
            }else if(i instanceof UseableItem){
                itemType = new Text("UI");
            }else if(i instanceof QuestItem){
                itemType = new Text("QI");
            }else{
                itemType = new Text("I");
            }
            itemType.setFill(Color.ORANGERED);
            itemType.relocate(250, 3);
            t.getChildren().add(itemType);
            
            items.add(t);
        }
        list.setItems(items);
        menu.getChildren().add(list);
        
        
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
    }

    /**
     * @return the menu
     */
    public AnchorPane getMenu() {
        return menu;
    }
    
    public void update(TWoT game){
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
        
        
        items.removeAll(items);
        List<Item> items_ingame = game.getInventoryItems();
        for(Item i: items_ingame){
            AnchorPane t = new AnchorPane();
            Text itemName = new Text(i.getItemName());
            itemName.setFill(Color.ORANGERED);
            itemName.relocate(0, 3);
            t.getChildren().add(itemName);
            Text itemType;
            if(i instanceof EquippableItem){
                itemType = new Text("EI");
            }else if(i instanceof UseableItem){
                itemType = new Text("UI");
            }else if(i instanceof QuestItem){
                itemType = new Text("QI");
            }else{
                itemType = new Text("I");
            }
            itemType.setFill(Color.ORANGERED);
            itemType.relocate(250, 3);
            t.getChildren().add(itemType);
            items.add(t);
        }
        
        pb.setProgress(game.getPlayerHealth()/100);
        
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
    
    public AnchorPane getSelected(){
        return list.getSelectionModel().getSelectedItem();
    }
}
