/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.WizardOfTreldan;
import Gui2D.SpriteController.SpriteController;
import TWoT_A1.TWoT;
import TWoT_test.EquippableItem;
import TWoT_test.Item;
import TWoT_test.QuestItem;
import TWoT_test.UseableItem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author jonas
 */
public class Load extends Map{
    public Load(SpriteController world){
        super();
        //set the world constructor
        super.setWorld(world);
    }
    
    @Override
    public Scene getScene(){
        Group menuGroup = new Group();
        Scene menuScene = new Scene( menuGroup );
        
        Canvas canvas_movealbe_sprites = new Canvas( 1024, 512 );
        canvas_movealbe_sprites.relocate(0, 0);
        GraphicsContext background_context = canvas_movealbe_sprites.getGraphicsContext2D();
        //set our  menu image
        background_context.drawImage(new Image("load_background.png"), 0, 0);
        
        Pane anchorpane = new Pane();
        anchorpane.setPrefSize(1024, 512);
        
        ListView<AnchorPane> list = new ListView();
        list.relocate(170, 140);
        list.setPrefWidth(300-8);
        list.setPrefHeight(210);
        
        ObservableList<AnchorPane> loads = FXCollections.observableArrayList ();
        List<String> loadList = getLoadList();
        for(String i: loadList){
            AnchorPane t = new AnchorPane();
            Text itemName = new Text(i);
            itemName.relocate(0, 3);
            t.getChildren().add(itemName);
            loads.add(t);
        }
        list.setItems(loads);
        anchorpane.getChildren().add(list);
        
        
        
        Button load = new Button();
        load.setText("Load Selected Game");
        load.setFont(new Font("Tahoma", 20));
        load.setPrefSize(250, 50);
        load.relocate(100, 400);
        load.addEventHandler(MouseEvent.MOUSE_CLICKED, 
            new EventHandler<MouseEvent>() {
                @Override 
                public void handle(MouseEvent e) {
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                            TWoT loadedGame = getLoad((((Text)list.getSelectionModel().getSelectedItem().getChildren().get(0)).getText()));
                            WizardOfTreldan.setGame(loadedGame);
                            switch(loadedGame.getCurrentRoomId()){
                                case 1: WizardOfTreldan.setCellarScene();
                                    break;
                                default: WizardOfTreldan.setVillageScene();
                                    break; 
                            }
                        }
                    });
                }
        });
        anchorpane.getChildren().add(load);
        
        
        Button cancel = new Button();
        cancel.setText("Cancel");
        cancel.setFont(new Font("Tahoma", 20));
        cancel.setPrefSize(150, 50);
        cancel.relocate(400, 400);
        cancel.addEventHandler(MouseEvent.MOUSE_CLICKED, 
            new EventHandler<MouseEvent>() {
                @Override 
                public void handle(MouseEvent e) {
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                            WizardOfTreldan.setMenuScene();
                        }
                    });
                }
        });
        anchorpane.getChildren().add(cancel);
        
        menuGroup.getChildren().add( canvas_movealbe_sprites );
        menuGroup.getChildren().add(anchorpane);
        return menuScene;
    }
    
    public List<String> getLoadList(){
        List<String> loadList = new ArrayList();
        try(Stream<Path> paths = Files.walk(Paths.get("loads/"))) {
            paths.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    loadList.add(filePath.getFileName().toString());
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return loadList;
    }
    
    public TWoT getLoad(String filename){
        System.out.println(filename);
        try {
            //Read from the stored file
            FileInputStream fileInputStream = new FileInputStream(new File("loads/" + filename));
            ObjectInputStream input = new ObjectInputStream(fileInputStream);
            TWoT twot = (TWoT) input.readObject();
            input.close();
            return twot;
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        }
        return null;
    }
}
