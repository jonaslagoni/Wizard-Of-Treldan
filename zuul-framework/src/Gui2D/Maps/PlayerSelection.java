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
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author jonas
 */
public class PlayerSelection implements Map{
    private TWoT game;
    private final Scene SCENE;
    
    /**
     * Creates the scene for player selection
     */
    public PlayerSelection(){
        
        game = WizardOfTreldan.getGame();
        
        Group playerSelectionGroup = new Group();
        Scene playerScene = new Scene( playerSelectionGroup );
        playerScene.setFill(javafx.scene.paint.Color.rgb(83, 83, 83));
        
        
        Group testGroup = new Group();
        Scene testScene = new Scene( testGroup );
        testScene.setFill(javafx.scene.paint.Color.rgb(83, 83, 83));
        
        playerSelectionGroup.getChildren().addAll(testGroup.getChildren());
        
        Pane anchorpane = new Pane();
        anchorpane.setPrefSize(1024, 512);
        
        Label controlsMOVING = new Label();
        controlsMOVING.setPrefSize(400, 50);
        controlsMOVING.relocate(50, 50);
        controlsMOVING.setFont(new Font("Verdana",20));
        controlsMOVING.setText("Use Arrow Keys to move");
        controlsMOVING.setTextFill(Color.WHITE);
        anchorpane.getChildren().add(controlsMOVING);
        
        Label controlsESC = new Label();
        controlsESC.setPrefSize(400, 50);
        controlsESC.relocate(50, 100);
        controlsESC.setFont(new Font("Verdana",20));
        controlsESC.setText("Press ESCAPE to exit game");
        controlsESC.setTextFill(Color.WHITE);
        anchorpane.getChildren().add(controlsESC);
        
        Label controlsINTERACT = new Label();
        controlsINTERACT.setPrefSize(400, 50);
        controlsINTERACT.relocate(50, 150);
        controlsINTERACT.setFont(new Font("Verdana",20));
        controlsINTERACT.setText("Use \"E\" to interact");
        controlsINTERACT.setTextFill(Color.WHITE);
        anchorpane.getChildren().add(controlsINTERACT);
        
        TextField playerName = new TextField();
        playerName.setPrefSize(300, 50);
        playerName.relocate(362, 200);
        playerName.setFont(new Font(20));
        playerName.setAlignment(Pos.CENTER);
        anchorpane.getChildren().add(playerName);
        
        Text playernameText = new Text();
        playernameText.setFont(new Font(27));
        playernameText.setText("Insert your player name");
        playernameText.relocate(365, 160);
        playernameText.setFill(Color.WHITE);
        anchorpane.getChildren().add(playernameText);
        
        
        //back to menu button
        Button Back = new Button();
        Back.setText("Back");
        Back.setFont(new Font("Tahoma", 20));
        Back.setPrefSize(100, 50);
        Back.relocate(562,260);
        Back.addEventHandler(MouseEvent.MOUSE_CLICKED, 
            new EventHandler<MouseEvent>() {
                @Override 
                public void handle(MouseEvent a) {
                
                    WizardOfTreldan.setMenuScene();
                   
                }
        });
        anchorpane.getChildren().add(Back);
        
        //start game button
        Button start = new Button();
        start.setText("Start Game");
        start.setFont(new Font("Tahoma", 20));
        start.setPrefSize(150, 50);
        start.relocate(362, 260);
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
        SCENE = playerScene;
    }
    
    /**
     * Returns the scene where the player can select a name.
     * @return Scene
     */
    @Override
    public Scene getScene(){
        return SCENE;
    }
}
