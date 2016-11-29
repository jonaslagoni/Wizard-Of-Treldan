/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import TWoT_A1.TWoT;
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
    
    
    private Canvas miniMap;
    private GraphicsContext miniMapContext; 
    private int width = 200, height = 120;
    private int posX = 0, posY = 0;
    private TWoT game;
    
    /**
     * 
     */
    public MiniMap(TWoT game){
        this.game = game;
        miniMap = new Canvas(width, height);
        miniMap.relocate(posX, posY);
        miniMapContext = miniMap.getGraphicsContext2D();
    }
    /**
     * 
     */
    private void clearMiniMap(){
        miniMapContext.clearRect(posX, posY, width, height);
    }
    /**
     * 
     */
    private void setCellar(){
        miniMapContext.drawImage(cellarImage, 0, 0, width, height);
    }

    public void updateMiniMap(){
        clearMiniMap();
        switch(game.getCurrentRoomId()){
            case 1:
                setCellar();
                break;
        }
    }
    /**
     * @return the miniMap
     */
    public Canvas getMiniMap() {
        return miniMap;
    }
}
