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
    //add all constant image files for minimaps
    private static final Image cellarImage = new Image("minimap/cellar.png");
    private static final Image villageImage = new Image("minimap/village.png");
    private static final Image house1Image = new Image("minimap/house1.png");
    private static final Image house2Image = new Image("minimap/house2.png");
    private static final Image house3Image = new Image("minimap/house3.png");
    private static final Image forrestImage = new Image("minimap/forrest.png");
    private static final Image wizardhouseImage = new Image("minimap/WizzardHouse.png");
    private static final Image caveImage = new Image("minimap/cave.png");
    private static final Image lairImage = new Image("minimap/lair.png");
    private static final Image clearingImage = new Image("minimap/clearing.png");
    private static final Image dungeonImage = new Image("minimap/Dungeon.png");
    private static final Image libraryImage = new Image("minimap/library.png");
    private static final Image wizardlairImage = new Image("minimap/wizardLair.png");
    //the playerhead image
    private static final Image playerImage = new Image("minimap/player.png");
    //global group for the canvases
    private Group root;
    //the two global graphics context's
    private GraphicsContext miniMapContext; 
    private GraphicsContext miniMap_playerContext; 
    //set the width and height of the minimap
    private int width = 160, height = 64;
    //set the width and height of the player icon
    private int width_player = 16, height_player = 16;
    //set the start position of the player image
    private int posX = 0, posY = 0;
    //set the start ratio's for the width and height
    private double constWidthRatio = 0.0, constHeightRatio = 0.0;
    
    //our global TWoT ref.
    private TWoT game;
    
    /**
     * constructor for the minimap
     * @param game 
     */
    public MiniMap(TWoT game){
        //save the game object ref
        this.game = game;
        //init a new group object
        root = new Group();
        
        //init the background canvas
        Canvas miniMap_background = new Canvas(width, height);
        miniMap_background.relocate(posX, posY);
        miniMapContext = miniMap_background.getGraphicsContext2D();
        
        //init the player canvas
        Canvas miniMap_player = new Canvas(width, height);
        miniMap_player.relocate(posX, posY);
        miniMap_playerContext = miniMap_player.getGraphicsContext2D();
        
        //add the canvases to the group
        root.getChildren().add(miniMap_background);
        root.getChildren().add(miniMap_player);
    }
    
    

    /**
     * Updates the minimap background canvas
     * 
     * @param playerCanvasWidth
     * @param playerCanvasHeight 
     */
    public void updateMiniMap(double playerCanvasWidth, double playerCanvasHeight){
        //get the ratio of width and height of the minimap and the player canvas
        constWidthRatio = playerCanvasWidth/width;
        constHeightRatio = playerCanvasHeight/height;
        //clear the background
        clearMiniMap_background();
        
        //draw the new minimap
        switch(game.getCurrentRoomId()){
            case 1:
                this.setCellar();
                break;
            case 2:
                this.setVillage();
                break;
            case 3:
                this.setHouse1();
                break;
            case 4:
                this.setHouse2();
                break;
            case 5:
                this.setHouse3();
                break;
            case 6:
                this.setForrest();
                break;
            case 7:
                this.setWizardHouse();
                break;
            case 8:
                this.setCave();
                break;
            case 9:
                this.setLair();
                break;
            case 10:
                this.setClearing();
                break;
            case 11:
                this.setDungeon();
                break;
            case 12:
                this.setLibrary();
                break;
            case 13:
                this.setWizardLair();
                break;
        }
    }
    
    /**
     * Updates the minimap player position
     * @param posX
     * @param posY 
     */
    public void updateMiniMap_player(double posX, double posY){
        //first clear the minimap
        clearMiniMap_player();
        //draw a new image
        miniMap_playerContext.drawImage(playerImage, posX/constWidthRatio, posY/constHeightRatio, width_player, height_player);
    }
    
    /**
     * Returns the group of canvases in the minimap
     * @return 
     */
    public Group getMinimap(){
        return root;
    }
    
    
    /**
     * clears the background canvas
     */
    private void clearMiniMap_background(){
        miniMapContext.clearRect(posX, posY, width, height);
    }
    
    /**
     *  Clears the player canvas
     */
    private void clearMiniMap_player(){
        miniMap_playerContext.clearRect(posX, posY, width, height);
    }
    
    /**
     * Sets the cellar minimap image
     */
    private void setCellar(){
        miniMapContext.drawImage(cellarImage, 0, 0, width, height);
    }
    
    /**
     * Sets the village minimap image
     */
    private void setVillage(){
        miniMapContext.drawImage(villageImage, 0, 0, width, height);
    }
    
    /**
     * Sets the house1 minimap image
     */
    private void setHouse1(){
        miniMapContext.drawImage(house1Image, 0, 0, width, height);
    }
    
    /**
     * Sets the house2 minimap image
     */
    private void setHouse2(){
        miniMapContext.drawImage(house2Image, 0, 0, width, height);
    }
    
    /**
     * Sets the house3 minimap image
     */
    private void setHouse3(){
        miniMapContext.drawImage(house3Image, 0, 0, width, height);
    }
    
    /**
     * Sets the forrest minimap image
     */
    private void setForrest(){
        miniMapContext.drawImage(forrestImage, 0, 0, width, height);
    }
    
    /**
     * Sets the wizard house minimap image
     */
    private void setWizardHouse(){
        miniMapContext.drawImage(wizardhouseImage, 0, 0, width, height);
    }
    
    /**
     * Sets the cave minimap image
     */
    private void setCave(){
        miniMapContext.drawImage(caveImage, 0, 0, width, height);
    }
    
    /**
     * Sets the lair minimap image
     */
    private void setLair(){
        miniMapContext.drawImage(lairImage, 0, 0, width, height);
    }
    
    /**
     * Sets the lair minimap image
     */
    private void setClearing(){
        miniMapContext.drawImage(clearingImage, 0, 0, width, height);
    }
    
    /**
     * Sets the dungeon minimap image
     */
    private void setDungeon(){
        miniMapContext.drawImage(dungeonImage, 0, 0, width, height);
    }
    
    /**
     * Sets the library minimap image
     */
    private void setLibrary(){
        miniMapContext.drawImage(libraryImage, 0, 0, width, height);
    }
    
    /**
     * Sets the Wizard lair minimap image
     */
    private void setWizardLair(){
        miniMapContext.drawImage(wizardlairImage, 0, 0, width, height);
    }
}
