/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.WizardOfTreldan;
import TWoT.TWoT;
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
public class Load implements Map {

    private Text status;
    private boolean canLoad;
    private final Scene SCENE;

    /**
     * Creates the load scene
     */
    public Load() {
        Group menuGroup = new Group();
        Scene menuScene = new Scene(menuGroup);

        //add a canvas for the background
        Canvas canvas_movealbe_sprites = new Canvas(1024, 512);
        canvas_movealbe_sprites.relocate(0, 0);
        GraphicsContext background_context = canvas_movealbe_sprites.getGraphicsContext2D();
        //draw out image to the GraphicsContext.
        background_context.drawImage(new Image("load_background.png"), 0, 0);

        Pane anchorpane = new Pane();
        anchorpane.setPrefSize(1024, 512);

        status = new Text();
        status.relocate(50, 350);
        status.setFill(Color.RED);
        anchorpane.getChildren().add(status);
        /**
         * add listView with anchorpanels Adding Text component and using it for
         * name of the file. Then getting that child when wanted to get the
         * selected file.
         */
        ListView<AnchorPane> list = new ListView();
        list.relocate(170, 140);
        list.setPrefWidth(300);
        list.setPrefHeight(210);

        //adding observableList with type AnchorPane
        ObservableList<AnchorPane> loads = FXCollections.observableArrayList();
        //Getting an arraylist of load files,
        List<String> loadList = getLoadList();
        //Go through each String in the list
        for (String i : loadList) {
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
        anchorpane.getChildren().add(list);

        /**
         * Adding a new button component which loads the selected saved game
         * from the ListView.
         */
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
                    @Override
                    public void run() {
                        //get the game from the selected save
                        TWoT loadedGame = getLoad((((Text) list.getSelectionModel().getSelectedItem().getChildren().get(0)).getText()));
                        //set the game to the loaded instance
                        WizardOfTreldan.setGame(loadedGame);
                        //check which scene the player is in.
                        if (canLoad) {
                            switch (loadedGame.getCurrentRoomId()) {
                                case 1:
                                    WizardOfTreldan.setCellarScene();
                                    break;
                                case 2:
                                    WizardOfTreldan.setVillageScene();
                                    break;
                                case 3:
                                    WizardOfTreldan.setHouse1Scene();
                                    break;
                                case 4:
                                    WizardOfTreldan.setHouse2Scene();
                                    break;
                                case 5:
                                    WizardOfTreldan.setHouse3Scene();
                                    break;
                                case 6:
                                    WizardOfTreldan.setForestScene();
                                    break;
                                case 7:
                                    WizardOfTreldan.setWizardHouseScene();
                                    break;
                                case 8:
                                    WizardOfTreldan.setCaveScene();
                                    break;
                                case 9:
                                    WizardOfTreldan.setGruulsLairScene();
                                    break;
                                case 10:
                                    WizardOfTreldan.setClearingScene();
                                    break;
                                case 11:
                                    WizardOfTreldan.setDungeonScene();
                                    break;
                                case 12:
                                    WizardOfTreldan.setLibraryScene();
                                    break;
                                case 13:
                                    WizardOfTreldan.setEvilWizardsLairScene();
                                    break;
                                default:
                                    WizardOfTreldan.setMenuScene();
                                    break;
                            }
                        }
                    }
                });
            }
        });
        //add the button to the pane.
        anchorpane.getChildren().add(load);

        /**
         * Adding a cancel button to return to the main menu. This just sets the
         * scene to the menu.
         */
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
                    @Override
                    public void run() {
                        WizardOfTreldan.setMenuScene();
                    }
                });
            }
        });
        //add the button to the pane.
        anchorpane.getChildren().add(cancel);

        //add the canvas(background) to the scene group.
        menuGroup.getChildren().add(canvas_movealbe_sprites);
        //add the pane to the scene group.
        menuGroup.getChildren().add(anchorpane);

        //Set the global
        SCENE = menuScene;
    }

    /**
     * Returns the scene for the load menu.
     *
     * @return Scene
     */
    @Override
    public Scene getScene() {
        return SCENE;
    }

    /**
     * Returns the List of Strings of saved files.
     *
     * @return List of Strings
     */
    private List<String> getLoadList() {
        //create empty arraylist.
        List<String> loadList = new ArrayList();
        //try to get each file in the directory "loads" by using Files.walk
        try {
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
            status.setText("Is the file there?");
        }
        //return the List
        return loadList;
    }

    /**
     * Returns the Game file corresponding to which file the user selected
     *
     * @param filename
     * @return TWoT game file
     */
    private TWoT getLoad(String filename) {
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
            canLoad = true;
            //returns the gamefile
            return twot;
        } catch (FileNotFoundException e) {
            status.setText("File was not found...");
        } catch (IOException e) {
            status.setText("This save is a wrong version of the game..");
        } catch (ClassNotFoundException e) {
            status.setText("The game was not found.");
        }
        canLoad = false;
        return null;
    }
}
