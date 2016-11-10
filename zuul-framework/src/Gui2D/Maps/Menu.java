/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.WizardOfTreldan;
import Gui2D.SpriteController.SpriteController;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 *
 * @author jonas
 */
public class Menu extends Map{
    public Menu(SpriteController world){
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
        background_context.drawImage(new Image("menu_background.png"), 0, 0);
        
        Pane anchorpane = new Pane();
        anchorpane.setPrefSize(768, 512);
        Button start = new Button();
        start.setText("New Game");
        start.setFont(new Font("Tahoma", 20));
        start.setPrefSize(150, 50);
        start.relocate(100, 150);
        start.addEventHandler(MouseEvent.MOUSE_CLICKED, 
            new EventHandler<MouseEvent>() {
                @Override 
                public void handle(MouseEvent e) {
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                            WizardOfTreldan.resetGame();
                            WizardOfTreldan.setPlayerSelectionScene();
                        }
                    });
                }
        });
        anchorpane.getChildren().add(start);
        
        Button load = new Button();
        load.setText("Load Game");
        load.setFont(new Font("Tahoma", 20));
        load.setPrefSize(150, 50);
        load.relocate(100, 250);
        load.addEventHandler(MouseEvent.MOUSE_CLICKED, 
            new EventHandler<MouseEvent>() {
                @Override 
                public void handle(MouseEvent e) {
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                            WizardOfTreldan.setCellarScene();
                        }
                    });
                }
        });
        anchorpane.getChildren().add(load);
        
        
        Button exit = new Button();
        exit.setText("Exit game");
        exit.setFont(new Font("Tahoma", 20));
        exit.setPrefSize(150, 50);
        exit.relocate(100, 350);
        exit.addEventHandler(MouseEvent.MOUSE_CLICKED, 
            new EventHandler<MouseEvent>() {
                @Override 
                public void handle(MouseEvent e) {
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                            System.exit(1);
                        }
                    });
                }
        });
        anchorpane.getChildren().add(exit);
        
        menuGroup.getChildren().add( canvas_movealbe_sprites );
        menuGroup.getChildren().add(anchorpane);
        return menuScene;
    }
}
