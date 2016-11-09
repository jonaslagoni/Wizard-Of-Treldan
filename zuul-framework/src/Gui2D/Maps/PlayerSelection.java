/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.WizardOfTreldan;
import Gui2D.SpriteController.SpriteController;
import TWoT_test.TWoT;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author jonas
 */
public class PlayerSelection extends Map{
    private TWoT game;
    public PlayerSelection(SpriteController world, TWoT game){
        super();
        //set the world constructor
        super.setWorld(world);
        this.game = game;
    }
    
    @Override
    public Scene getScene(){        
        Group playerSelectionGroup = new Group();
        Scene playerScene = new Scene( playerSelectionGroup );
        playerScene.setFill(javafx.scene.paint.Color.rgb(83, 83, 83));
        
        
        Group testGroup = new Group();
        Scene testScene = new Scene( testGroup );
        testScene.setFill(javafx.scene.paint.Color.rgb(83, 83, 83));
        
        playerSelectionGroup.getChildren().addAll(testGroup.getChildren());
        
        Pane anchorpane = new Pane();
        anchorpane.setPrefSize(1024, 512);
        
        TextField playerName = new TextField();
        playerName.setPrefSize(300, 50);
        playerName.relocate(362, 200);
        playerName.setFont(new Font(20));
        playerName.setAlignment(Pos.CENTER);
        anchorpane.getChildren().add(playerName);
        
        Text playernameText = new Text();
        playernameText.setFont(new Font(27));
        playernameText.setText("Insert your player name");
        playernameText.relocate(250, 160);
        playernameText.setFill(Color.WHITE);
        anchorpane.getChildren().add(playernameText);
        
        
        
        Button start = new Button();
        start.setText("Start Game");
        start.setFont(new Font("Tahoma", 20));
        start.setPrefSize(150, 50);
        start.relocate(437, 260);
        start.addEventHandler(MouseEvent.MOUSE_CLICKED, 
            new EventHandler<MouseEvent>() {
                @Override 
                public void handle(MouseEvent e) {
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                            if(playerName.getText().equals("")){
                                game.setPlayerName("John Doe");
                            }else{
                                game.setPlayerName(playerName.getText());
                            }
                            WizardOfTreldan.setCellarScene();
                        }
                    });
                }
        });
        
        playerScene.setOnKeyPressed(
            new EventHandler<KeyEvent>(){
                @Override
                public void handle(KeyEvent e){
                    if(e.getCode().toString().equals("ENTER")){
                        if(playerName.getText().equals("")){
                            game.setPlayerName("John Doe");
                        }else{
                            game.setPlayerName(playerName.getText());
                        }
                        WizardOfTreldan.setCellarScene();
                    }
                }
            });
        
        anchorpane.getChildren().add(start);
        
        playerSelectionGroup.getChildren().add(anchorpane);
        return playerScene;
    }
}
