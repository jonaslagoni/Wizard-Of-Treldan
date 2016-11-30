/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import TWoT_A1.TWoT;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author jonas
 */
public class MiniMap {
    //all image files for minimaps
    private static final Image cellarImage = new Image("minimap/cellar.png");
    private static final Image playerImage = new Image("minimap/cellar.png");
    private Group root;
    private Canvas miniMap_background;
    private Canvas miniMap_player;
    private GraphicsContext miniMapContext; 
    private GraphicsContext miniMap_playerContext; 
    private int width = 200, height = 120;
    private int width_player = 8, height_player = 8;
    private int posX = 0, posY = 0;
    private TWoT game;
    
    /**
     * 
     */
    public MiniMap(TWoT game){
        this.game = game;
        root = new Group();
        
        miniMap_background = new Canvas(width, height);
        miniMap_background.relocate(posX, posY);
        miniMapContext = miniMap_background.getGraphicsContext2D();
        
        miniMap_player = new Canvas(width, height);
        miniMap_player.relocate(posX, posY);
        miniMap_playerContext = miniMap_player.getGraphicsContext2D();
        
        
        root.getChildren().add(miniMap_background);
        root.getChildren().add(miniMap_player);
    }
    /**
     * 
     */
    private void clearMiniMap_background(){
        miniMapContext.clearRect(posX, posY, width, height);
    }
    
    /**
     * 
     */
    private void clearMiniMap_player(){
        miniMap_playerContext.clearRect(posX, posY, width, height);
    }
    
    /**
     * 
     */
    private void setCellar(){
        miniMapContext.drawImage(cellarImage, 0, 0, width, height);
    }

    /**
     * 
     */
    public void updateMiniMap(){
        clearMiniMap_background();
        switch(game.getCurrentRoomId()){
            case 1:
                setCellar();
                break;
        }
    }
    
    public void updateMiniMap_player(double posX, double posY){
        clearMiniMap_player();
        miniMapContext.drawImage(cellarImage, posX, posY, width_player, height_player);
    }
    
    public Group getMinimap(){
        return root;
    }
}
