/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.WizardOfTreldan;
import Gui2D.SpriteController.SpriteController;
import TWoT_A1.Score;
import TWoT_A1.TWoT;
import java.util.ArrayList;
import java.util.List;
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
public class Highscore extends Map {

    private Text status;
    private boolean canLoad;
    private TWoT game;

    public Highscore(SpriteController world) {
        super();
        //set the world constructor
        super.setWorld(world);
    }

    @Override
    public Scene getScene() {
        game = WizardOfTreldan.getGame();
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
        List<String> loadList = getHishscoreList();
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
         * Adding a cancel button to return to the main menu. This just sets the
         * scene to the menu.
         */
        Button cancel = new Button();
        cancel.setText("Menu");
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

        //returns the scene.
        return menuScene;
    }

    /**
     * Returns the List of Strings of saved files.
     *
     * @return List of Strings
     */
    public List<String> getHishscoreList() {
        //create empty arraylist.
        List<String> loadList = new ArrayList();
        //try to get each file in the directory "loads" by using Files.walk
        List<Score> highscores = game.readHighScore();
        for(Score s : highscores){
            loadList.add("Name: " + s.getName() + " | Score: " + s.getScore() + " | Time: " + s.getTime());
        }
        //return the List
        return loadList;
    }

}
