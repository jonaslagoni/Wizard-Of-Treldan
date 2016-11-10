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
import TWoT_test.Command;
import TWoT_test.CommandWord;
import TWoT_test.TWoT;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 *
 * @author jonas
 */
public class Cellar extends Map{
    
    // Arraylist for player movement
    private final ArrayList<String> input;
    
    // ArrayList for menu key strokes.
    private final ArrayList<String> menu_input;
    
    // Contains all the sprites to this map
    private final Cellar_sprites cellar_sprites;
    
    private TWoT game;
    
    /**
     * Constructor for Cellar
     * @param world 
     * @param game 
     */
    public Cellar(SpriteController world){
        //init our super constructor first
        super();
        // Link our globals to super class user inputs since no inheritence in AnimationTimer
        input = super.getInput();
        menu_input = super.getMenu_input();
        
        //init our Cellar_sprites
        cellar_sprites = new Cellar_sprites(world);
        //init our Cellar's sprites
        cellar_sprites.setCellar_background_SingleSprites();
    }
    
    /**
     * Returns the scene for the map Cellar
     * @return 
     */
    @Override
    public Scene getScene(){
        
        this.game = WizardOfTreldan.getGame();
        //add our group
        Group root = new Group();
        //add a scene from the group
        Scene theScene = new Scene( root );
        //set a darker background
        theScene.setFill(Color.rgb(83, 83, 83));
        //set the styleScheet
        theScene.getStylesheets().add("TextAreaStyle.css");
        
        Canvas canvas_background = new Canvas( 512, 256);
        //relocate the canvas so its centered.
        canvas_background.relocate(256, 128);
        //add the canvas to the group
        root.getChildren().add( canvas_background );
        
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
        
        TextArea infobox = Infobox.getInfoBox();
        StackPane s = new StackPane(infobox);
        s.setPrefSize(300, 150);
        s.relocate(0, 362);
        root.getChildren().add(s);
        HashMap<String, String> welcome = game.getWelcomeMessages();
        infobox.appendText(welcome.get("getRooms") + "\n");
        
        
        //get our player from super class since no inheritence in AnimationTimer
        PlayerSprite player = super.getPlayer();
        player.setPosition(100, 100);
        
        //set the keylisteners to the scene.
        theScene.setOnKeyReleased(getOnKeyRelease(player));
        theScene.setOnKeyPressed(getOnKeyPress());
        
        //create GraphicsContext from our player_canvas
        GraphicsContext moveable_gc = player_canvas.getGraphicsContext2D();
        //create GraphicsContext from our canvas_menu_sprites
        GraphicsContext menu_gc = canvas_menu_sprites.getGraphicsContext2D();
        //create GraphicsContext from our canvas_background
        GraphicsContext background_gc = canvas_background.getGraphicsContext2D();
       
        
        //get all sprites in cellar
        List<Sprite> sprites_still = cellar_sprites.getCellar_background_sprites();
        
        //generate all normal sprites from the cellar
        for(Sprite sprite: sprites_still){
            sprite.render(background_gc);
        }
        
        //set our world boundaries
        Rectangle2D worldBoundRight = new Rectangle2D(479, 0, 1, 512);
        Rectangle2D worldBoundLeft = new Rectangle2D(-2, 0, 1, 512);
        Rectangle2D worldBoundBottom = new Rectangle2D(0, 216, 512, 1);
        Rectangle2D worldBoundTop = new Rectangle2D(0, 0, 512, 1);
        
        new AnimationTimer(){
            //set the current time we started.
            private long lastNanoTime = System.nanoTime();
            private boolean hasPrinted = false;
            //what to do each cycle
            @Override
            public void handle(long currentNanoTime){
                //request the focus back
                root.requestFocus();
                //get how many sec have passed
                double elapsedTime = (currentNanoTime - lastNanoTime) / 1000000000.0;
                //set the lastNanoTime to the nano time from parameter
                lastNanoTime = currentNanoTime;
                
                
                //set our initial direction standstill
                player.setDirection(PlayerSprite.Direction.STANDSTILL);
                //now check for the users input
                //check if the user wants to walk left.
                if (input.contains("LEFT")){
                    //check if the user walks into a world boundary
                    if(player.intersects_left(worldBoundLeft)){
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    //check if the player walks into the bed
                    }else if(player.intersects_left(sprites_still.get(1)) ||
                             player.intersects_left(sprites_still.get(7)) || 
                             player.intersects_left(sprites_still.get(8)) ||
                             player.intersects_left(sprites_still.get(9)) ||
                             player.intersects_left(sprites_still.get(10))|| 
                             player.intersects_left(sprites_still.get(11))||
                             player.intersects_left(sprites_still.get(12))||
                             player.intersects_left(sprites_still.get(13))){
                        player.setVelocity(0, 0);
                    //check if the player walks into the door
                    }else if(player.intersects_left(sprites_still.get(4))){
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        if(!hasPrinted){
                            int oldId = game.getCurrentRoomId();
                            for(String s: game.goTo(new Command(CommandWord.GO, "door"))){
                                infobox.appendText("\n" + s + "\n");
                            }
                            hasPrinted = true;
                            if(game.getCurrentRoomId() != oldId){
                                //remove all the inputs
                                input.removeAll(input);
                                //stop this AnimationTimer
                                this.stop();
                                //clear the textarea
                                infobox.clear();
                                //set the menu as a scene instead.
                                setNewScene();
                            }
                        }
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    //if no collission
                    }else{
                        player.setVelocity(-100,0);
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_LEFT);
                }
                
                //check if the user wants to walk right.
                if(input.contains("RIGHT")){
                    //check if the user walks into a world boundary
                    if(player.intersects_right(worldBoundRight)){
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    //check if the player walks into the bed
                    }else if(player.intersects_right(sprites_still.get(1)) ||
                             player.intersects_right(sprites_still.get(7)) || 
                             player.intersects_right(sprites_still.get(8)) ||
                             player.intersects_right(sprites_still.get(9)) ||
                             player.intersects_right(sprites_still.get(10))|| 
                             player.intersects_right(sprites_still.get(11))||
                             player.intersects_right(sprites_still.get(12))||
                             player.intersects_right(sprites_still.get(13))){
                        player.setVelocity(0, 0);
                    //check if the player walks into the door
                    }else if(player.intersects_right(sprites_still.get(4))){
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        if(!hasPrinted){
                            int oldId = game.getCurrentRoomId();
                            for(String s: game.goTo(new Command(CommandWord.GO, "door"))){
                                infobox.appendText("\n" + s + "\n");
                            }
                            hasPrinted = true;
                            if(game.getCurrentRoomId() != oldId){
                                //remove all the inputs
                                input.removeAll(input);
                                //stop this AnimationTimer
                                this.stop();
                                //clear the textarea
                                infobox.clear();
                                //set the menu as a scene instead.
                                setNewScene();
                            }
                        }
                    //if no collission
                    }else{
                        player.setVelocity(100,0);
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_RIGHT);
                }
                
                //check if the user wants to walk up.
                if(input.contains("UP")){
                    //check if the user walks into a world boundary
                    if(player.intersects_top(worldBoundTop)){
                        player.setVelocity(0, 0);
                    //check if the player walks into the bed
                    }else if(player.intersects_top(sprites_still.get(1)) ||
                             player.intersects_top(sprites_still.get(7)) || 
                             player.intersects_top(sprites_still.get(8)) ||
                             player.intersects_top(sprites_still.get(9)) ||
                             player.intersects_top(sprites_still.get(10))|| 
                             player.intersects_top(sprites_still.get(11))||
                             player.intersects_top(sprites_still.get(12))||
                             player.intersects_top(sprites_still.get(13))){
                        player.setVelocity(0, 0);
                    //check if the player walks into the door
                    }else if(player.intersects_top(sprites_still.get(4))){
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        if(!hasPrinted){
                            int oldId = game.getCurrentRoomId();
                            for(String s: game.goTo(new Command(CommandWord.GO, "door"))){
                                infobox.appendText("\n" + s + "\n");
                            }
                            hasPrinted = true;
                            if(game.getCurrentRoomId() != oldId){
                                //remove all the inputs
                                input.removeAll(input);
                                //stop this AnimationTimer
                                this.stop();
                                //clear the textarea
                                infobox.clear();
                                //set the menu as a scene instead.
                                setNewScene();
                            }
                        }
                    //if no collission
                    }else{
                        player.setVelocity(0,-100);
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_UP);
                }
                
                //check if the user wants to walk down.
                if(input.contains("DOWN")){
                    //check if the user walks into a world boundary
                    if(player.intersects_bottom(worldBoundBottom)){
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        
                    //check if the player walks into the bed
                    }else if(player.intersects_bottom(sprites_still.get(1)) ||
                             player.intersects_bottom(sprites_still.get(7)) || 
                             player.intersects_bottom(sprites_still.get(8)) ||
                             player.intersects_bottom(sprites_still.get(9)) ||
                             player.intersects_bottom(sprites_still.get(10))|| 
                             player.intersects_bottom(sprites_still.get(11))||
                             player.intersects_bottom(sprites_still.get(12))||
                             player.intersects_bottom(sprites_still.get(13))){
                        player.setVelocity(0, 0);
                        
                    //check if the player walks into the door
                    }else if(player.intersects_bottom(sprites_still.get(4))){
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        if(!hasPrinted){
                            int oldId = game.getCurrentRoomId();
                            for(String s: game.goTo(new Command(CommandWord.GO, "door"))){
                                infobox.appendText("\n" + s + "\n");
                            }
                            hasPrinted = true;
                            if(game.getCurrentRoomId() != oldId){
                                //remove all the inputs
                                input.removeAll(input);
                                //stop this AnimationTimer
                                this.stop();
                                //clear the textarea
                                infobox.clear();
                                //set the menu as a scene instead.
                                setNewScene();
                            }
                        }
                    //if no collission
                    }else{
                        player.setVelocity(0,100);
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_DOWN);
                }
                
                if(menu_input.contains("E")){
                    if(player.intersect(sprites_still.get(1))){
                        for(String s: game.goTo(new Command(CommandWord.GO, "haystack"))){
                            infobox.appendText("\n" + s + "\n");
                        }
                        hasPrinted = false;
                    }
                    menu_input.remove("E");
                }
                //update the players velocity
                player.update(elapsedTime);
                //clear our player
                moveable_gc.clearRect(0, 0, 1024,512);
                //render our new player
                player.render(moveable_gc);
                
                
                //check if the user wants to see a menu.
                if(menu_input.contains("I")){
                    menu_gc.setFill(Color.CADETBLUE);
                    menu_gc.fillRect(1024-250, 0, 250, 512);
                }else{
                    menu_gc.clearRect(0, 0, 1024,512);
                }
            }
            public void setNewScene(){
                switch(game.getCurrentRoomId()){
                    case 2: 
                        WizardOfTreldan.setMenuScene();
                        break;
                }
            }
        }.start();
        
        //return our created scene
        return theScene;
    }
}
