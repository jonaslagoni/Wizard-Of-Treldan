/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.SpriteController.Maps.Clearing_sprites;
import Gui2D.SpriteController.Maps.Village_sprites;
import Gui2D.SpriteController.SingleSprite.PlayerSprite;
import Gui2D.SpriteController.Sprite;
import Gui2D.SpriteController.SpriteController;
import Gui2D.WizardOfTreldan;
import TWoT_test.TWoT;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 *
 * @author jonas
 */
public class Village extends Map{
    
    // Arraylist for player movement
    private ArrayList<String> input;
    
    // ArrayList for menu key strokes.
    private ArrayList<String> menu_input;
    

    private TWoT game;
    private Village_sprites s;
    
    /**
     * Constructor for Cellar
     * @param world 
     */
    public Village(SpriteController world){
        //init our super constructor
        super();
        
        super.setWorld(world);
        
        s = new Village_sprites(world);
        s.setVillage_background_SingleSprites();
        
        
        
       
    }
    
    public Scene getScene(){
        this.game = WizardOfTreldan.getGame();
        //add group
        Group root = new Group();
        //set the scene
        Scene theScene = new Scene( root );
        //set background color
        theScene.setFill(Color.rgb(83, 83, 83));
        //set canvas of our background
        Canvas village_background = new Canvas(1024,512);
        //add the canvas to the group
        root.getChildren().add(village_background);
        GraphicsContext background_gc = village_background.getGraphicsContext2D();
        
       
        List<Sprite> sprites_still = s.getVillage_background_sprites();
        for(Sprite sprite : sprites_still){
            sprite.render(background_gc);
        }
        
        
        
        return theScene;
    }
}
