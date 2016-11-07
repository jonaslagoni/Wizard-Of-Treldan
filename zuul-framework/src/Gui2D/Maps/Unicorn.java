/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.SpriteController.Maps.Unicorn_sprites;
import Gui2D.SpriteController.Sprite;
import Gui2D.SpriteController.SpriteController;
import static java.lang.System.gc;
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
public class Unicorn extends Map{
    
    // Arraylist for player movement
    private ArrayList<String> input;
    
    // ArrayList for menu key strokes.
    private ArrayList<String> menu_input;
    
    private Unicorn_sprites s;
    /**
     * Constructor for Cellar
     * @param world 
     */
    public Unicorn(SpriteController world){
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
        
        s = new Unicorn_sprites(world);
        s.setUnicorn();
    }
    
    public Scene getScene(){
        Group root = new Group();
        Scene theScene = new Scene( root );
        theScene.setFill(Color.rgb(83, 83, 83));
        
        Canvas canvas = new Canvas(1024,512);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        List<Sprite> unicornSprites = s.getUnicorn();
        
        
        for(Sprite sprite : unicornSprites){
            sprite.render(gc);
        }
        
    
        return theScene;
    }
}