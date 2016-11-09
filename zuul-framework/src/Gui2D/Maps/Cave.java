/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.SpriteController.Maps.Cave_sprites;
import Gui2D.SpriteController.SingleSprite.PlayerSprite;
import Gui2D.SpriteController.Sprite;
import Gui2D.SpriteController.SpriteController;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 *
 * @author jonas
 */
public class Cave extends Map{
    
    // Arraylist for player movement
    private ArrayList<String> input;
    
    // ArrayList for menu key strokes.
    private ArrayList<String> menu_input;
    
    private Cave_sprites g;
    /**
     * Constructor for Cellar
     * @param world 
     */
    public Cave(SpriteController world){
        //init our super constructor
        super();
        
        //set the ArrayList's from the super class Map
        super.setInput(new ArrayList<String>());
        super.setMenu_input(new ArrayList<String>());
        
        // Link our globals to super class user inputs since no inheritence in AnimationTimer
        input = super.getInput();
        menu_input = super.getMenu_input();
        
        //set the world constructor
        super.setWorld(world);
        
        g = new Cave_sprites(world);
        g.setCave_background_SingleSprites();
    }
    
    public Scene getScene(){
        Group root = new Group();
        Scene theScene = new Scene( root );
        Canvas background = new Canvas(1024, 512);
        theScene.setFill(Color.rgb(83, 83, 83));
        
        root.getChildren().add(background);
        GraphicsContext background_context = background.getGraphicsContext2D();
        List<Sprite> sprites_Cave = g.getCave_background_sprites();
        
        for(Sprite s: sprites_Cave){
            s.render(background_context);
        }
        
        return theScene;
    }
}
