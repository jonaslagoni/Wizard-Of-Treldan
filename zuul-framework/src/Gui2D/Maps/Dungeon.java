/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.SpriteController.Maps.Dungeon_sprites;
import Gui2D.SpriteController.Maps.Forest_sprites;
import Gui2D.SpriteController.Sprite;
import Gui2D.SpriteController.SpriteController;
import TWoT_test.TWoT;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 *
 * @author Mads
 */
public class Dungeon extends Map{
    
    // Arraylist for player movement
    private ArrayList<String> input;
    
    // ArrayList for menu key strokes.
    private ArrayList<String> menu_input;
    
    private Dungeon_sprites dungeon_sprites;
    
    /**
     * Constructor for Cellar
     * @param world 
     */
    public Dungeon(SpriteController world){
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
        
        dungeon_sprites = new Dungeon_sprites(world);
        dungeon_sprites.setDungeon_background_SingleSprites();
    }
    
    @Override
    public Scene getScene(){
        Group root = new Group();
        Scene theScene = new Scene( root );
        theScene.setFill(Color.rgb(83, 83, 83));
        Canvas background = new Canvas(1024, 512);
        root.getChildren().add(background);
        GraphicsContext backgroundContext = background.getGraphicsContext2D();
        List<Sprite> spriteList = dungeon_sprites.getSpriteList();
        
        for(Sprite s : spriteList) {
            s.render(backgroundContext);
        }
        
        return theScene;
    }
}
