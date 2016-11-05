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
public class Cellar extends Map{
    
    // Arraylist for player movement
    private ArrayList<String> input;
    
    // ArrayList for menu key strokes.
    private ArrayList<String> menu_input;
    
    private Cellar_sprites s;
    /**
     * Constructor for Cellar
     * @param world 
     */
    public Cellar(SpriteController world){
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
        
        s = new Cellar_sprites(world);
        s.setCellar_background_SingleSprites();
    }
    
    public Scene getScene(){
        Group root = new Group();
        Scene theScene = new Scene( root );
        theScene.setFill(Color.rgb(83, 83, 83));
        
        Canvas canvas_background = new Canvas( 512, 256);
        canvas_background.relocate(256, 128);
        root.getChildren().add( canvas_background );
        
        //add a canvas only for the player
        Canvas player_canvas = new Canvas(512, 256 );
        player_canvas.relocate(256, 128);
        root.getChildren().add( player_canvas );
        
        Canvas canvas_menu_sprites = new Canvas( 1024, 512 );
        canvas_menu_sprites.relocate(0, 0);
        root.getChildren().add( canvas_menu_sprites );
        
        
        
        //get our player from super class since no inheritence in AnimationTimer
        PlayerSprite player = super.getPlayer();
        player.setPosition(100, 100);
        
        theScene.setOnKeyReleased(getOnKeyRelease(player));
        theScene.setOnKeyPressed(getOnKeyPress());
        
        GraphicsContext moveable_gc = player_canvas.getGraphicsContext2D();
        GraphicsContext menu_gc = canvas_menu_sprites.getGraphicsContext2D();
        GraphicsContext background_gc = canvas_background.getGraphicsContext2D();
       
        
        List<Sprite> sprites_still = s.getCellar_background_sprites();
        
        for(Sprite sprite: sprites_still){
            sprite.render(background_gc);
        }
        Rectangle2D worldBoundRight = new Rectangle2D(479, 0, 1, 512);
        Rectangle2D worldBoundLeft = new Rectangle2D(-2, 0, 1, 512);
        Rectangle2D worldBoundBottom = new Rectangle2D(0, 216, 512, 1);
        Rectangle2D worldBoundTop = new Rectangle2D(0, 0, 512, 1);
        
        new AnimationTimer(){
            private int animationDelay = 0;
            private long lastNanoTime = System.nanoTime();
            public void handle(long currentNanoTime){
                double elapsedTime = (currentNanoTime - lastNanoTime) / 1000000000.0;
                lastNanoTime = currentNanoTime;
                player.setDirection(PlayerSprite.Direction.STANDSTILL);
                if (input.contains("LEFT")){
                    if(player.intersects_left(worldBoundLeft)){
                        player.setVelocity(0, 0);
                    }else if(player.intersects_left(sprites_still.get(1))){
                        player.setVelocity(0, 0);
                    }else{
                        player.setVelocity(-100,0);
                    }
                    player.setDirection(PlayerSprite.Direction.WALK_LEFT);
                }
                if(input.contains("RIGHT")){
                    if(player.intersects_right(worldBoundRight)){
                        player.setVelocity(0, 0);
                    }else if(player.intersects_right(sprites_still.get(1))){
                        player.setVelocity(0, 0);
                    }else{
                        player.setVelocity(100,0);
                    }
                    player.setDirection(PlayerSprite.Direction.WALK_RIGHT);
                }
                if(input.contains("UP")){
                    if(player.intersects_top(worldBoundTop)){
                        player.setVelocity(0, 0);
                    }else if(player.intersects_top(sprites_still.get(1))){
                        player.setVelocity(0, 0);
                    }else{
                        player.setVelocity(0,-100);
                    }
                    player.setDirection(PlayerSprite.Direction.WALK_UP);
                }
                if(input.contains("DOWN")){
                    if(player.intersects_bottom(worldBoundBottom)){
                        player.setVelocity(0, 0);
                    }else if(player.intersects_bottom(sprites_still.get(1))){
                        player.setVelocity(0, 0);
                    }else{
                        player.setVelocity(0,100);
                    }
                    player.setDirection(PlayerSprite.Direction.WALK_DOWN);
                }
                player.update(elapsedTime);
                moveable_gc.clearRect(0, 0, 1024,512);
                player.render(moveable_gc);
                
                /*
                // draw the boundaries for test
                //bottom
                moveable_gc.setFill(Color.CADETBLUE);
                moveable_gc.fillRect(player.getPositionX()+15, player.getPositionY()+player.getHeight()-14, player.getWidth()-47, 5);

                //top
                moveable_gc.setFill(Color.BEIGE);
                moveable_gc.fillRect(player.getPositionX()+15, player.getPositionY()+player.getHeight()-22, player.getWidth()-47, 5);

                //left
                moveable_gc.setFill(Color.DARKGREEN);
                moveable_gc.fillRect(player.getPositionX()+11, player.getPositionY()+player.getWidth()-20, 5, 10);

                //right
                moveable_gc.setFill(Color.CRIMSON);
                moveable_gc.fillRect(player.getPositionX()+player.getWidth()-32,  player.getPositionY()+player.getWidth()-20, 5, 10);
                */
                if(menu_input.contains("I")){
                    menu_gc.setFill(Color.CADETBLUE);
                    menu_gc.fillRect(1024-250, 0, 250, 512);
                }else{
                    menu_gc.clearRect(0, 0, 1024,512);
                }
            }
        }.start();
        return theScene;
    }
}
