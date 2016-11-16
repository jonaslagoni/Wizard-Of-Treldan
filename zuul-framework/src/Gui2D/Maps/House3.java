/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.SpriteController.Maps.House3_sprites;
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

public class House3 extends Map{
    
    // Arraylist for player movement
    private ArrayList<String> input;
    
    // ArrayList for menu key strokes.
    private ArrayList<String> menu_input;
    
    private House3_sprites s;
    /**
     * Constructor for Cellar
     * @param world 
     */
    public House3(SpriteController world){
        //init our super constructor
        super();
        
        //set the world constructor
        super.setWorld(world);
        
        s = new House3_sprites(world);
        s.setHouse3_background_SingleSprites();
    }
    
    @Override
    public Scene getScene(){
        Group root = new Group();
        Scene theScene = new Scene( root );
        theScene.setFill(Color.rgb(0, 0, 0));
        
        Canvas canvas_background = new Canvas( 400, 300);
        //relocate the canvas so its centered.
        canvas_background.relocate(325, 75);
        root.getChildren().add(canvas_background);
        GraphicsContext background_gc = canvas_background.getGraphicsContext2D();
        
        List<Sprite> sprites_still = s.getHouse3();
        for(Sprite sprite : sprites_still){
            sprite.render(background_gc);
        }
            
        return theScene;
    }
}
