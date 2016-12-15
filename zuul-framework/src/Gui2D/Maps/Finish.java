/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.WizardOfTreldan;
import TWoT_A1.TWoT;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author jonas
 */
public class Finish implements Map{
    private TWoT game;
    private final Scene SCENE;
    private final Long startTime;
    private Text timeTakenText;
    private Pane anchorpane;
    
    /**
     * Create the scene for Finish
     */
    public Finish(){
        this.game = WizardOfTreldan.getGame();
        Group menuGroup = new Group();
        Scene menuScene = new Scene( menuGroup );
        
        Canvas canvas_movealbe_sprites = new Canvas( 1024, 512 );
        canvas_movealbe_sprites.relocate(0, 0);
        GraphicsContext background_context = canvas_movealbe_sprites.getGraphicsContext2D();
        //set our  menu image
        background_context.drawImage(new Image("won_scene.png"), 0, 0);
        
        anchorpane = new Pane();
        anchorpane.setPrefSize(768, 512);
        
        startTime = game.getStartTime();
        
        Button start = new Button();
        start.setText("New Game");
        start.setFont(new Font("Tahoma", 20));
        start.setPrefSize(150, 50);
        start.relocate(450, 430);
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
        load.setText("Go to menu");
        load.setFont(new Font("Tahoma", 20));
        load.setPrefSize(150, 50);
        load.relocate(620, 430);
        load.addEventHandler(MouseEvent.MOUSE_CLICKED, 
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
        anchorpane.getChildren().add(load);
        
        
        Button exit = new Button();
        exit.setText("Exit game");
        exit.setFont(new Font("Tahoma", 20));
        exit.setPrefSize(150, 50);
        exit.relocate(790, 430);
        exit.addEventHandler(MouseEvent.MOUSE_CLICKED, 
            new EventHandler<MouseEvent>() {
                @Override 
                public void handle(MouseEvent e) {
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                            System.exit(0);
                        }
                    });
                }
        });
        anchorpane.getChildren().add(exit);
        
        menuGroup.getChildren().add( canvas_movealbe_sprites );
        menuGroup.getChildren().add(anchorpane);
        SCENE = menuScene;
    }
    
    /**
     * Returns the scene for the end game.
     * @return Scene
     */
    @Override
    public Scene getScene(){
        
        this.game = WizardOfTreldan.getGame();
        Long endTime = (long)(System.currentTimeMillis() / 1000L);
        Long timeTaken = endTime-startTime;
        timeTakenText = new Text("Time taken: " + timeTaken.toString() + " sec");
        timeTakenText.relocate(450, 200);
        timeTakenText.setFont(new Font("Verdana", 20));
        timeTakenText.setFill(Color.CHOCOLATE);
        anchorpane.getChildren().add(timeTakenText);
        
        
        
        Text totalScore = new Text("Score: " + game.getHighscore());
        totalScore.relocate(450, 250);
        totalScore.setFont(new Font("Verdana", 20));
        totalScore.setFill(Color.CHOCOLATE);
        anchorpane.getChildren().add(totalScore);
        
        return SCENE;
    }
}
