/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.SpriteController.Maps.Cellar_sprites;
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
    
    /**
     * Constructor for Cellar
     * @param world 
     */
    public Village(SpriteController world){
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
        Canvas village_background = new Canvas();
        //add the canvas to the group
        root.getChildren().add(village_background);
        
        
        //add a canvas only for the player
        Canvas player_canvas = new Canvas(512, 256 );
        //relocate the canvas so its centered.
        player_canvas.relocate(256, 128);
        //add the canvas to the group
        root.getChildren().add( player_canvas );
        
        //add a canvas only for the menu
        Canvas canvas_menu_sprites = new Canvas( 1024, 512 );
        canvas_menu_sprites.relocate(0, 0);
        //add the canvas to the group
        root.getChildren().add( canvas_menu_sprites );
        
        
        
        
        
        return theScene;
    }
}
