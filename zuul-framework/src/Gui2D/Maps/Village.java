/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.SpriteController.Maps.Village_sprites;
import Gui2D.SpriteController.Sprite;
import Gui2D.SpriteController.SpriteController;
import Gui2D.WizardOfTreldan;
import TWoT_A1.TWoT;
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
        
        
<<<<<<< HEAD
=======
        //get all the sprites used in the village
        List<Sprite> sprites_foreground = villageSprites.getVillage_foreground_sprites();
        //render all the sprites
        for(Sprite sprite : sprites_foreground){
            sprite.render(foreground_gc);
        }
        Sprite well = sprites_foreground.get(0);
        background_gc.setGlobalBlendMode(BlendMode.SOFT_LIGHT);
        background_gc.fillRect(well.getPositionX()+5, well.getPositionY()+well.getHeight()-50, well.getWidth()-20, 50);
        
        //set our world boundaries
        Rectangle2D worldBoundRight = new Rectangle2D(995, 0, 1, 512);
        Rectangle2D worldBoundLeft = new Rectangle2D(-2, 0, 1, 512);
        Rectangle2D worldBoundBottom = new Rectangle2D(0, 477, 1024, 1);
        Rectangle2D worldBoundTop = new Rectangle2D(0, 0, 1024, 1);
        
        new AnimationTimer(){
            //set the current time we started.
            private long lastNanoTime = System.nanoTime();
            private boolean hasPrinted_door2 = false;
            private boolean hasPrinted_door3 = false;
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
                    //check if the player walks into a sprite
                    }else if(player.intersects_left(sprites_foreground.get(0)) ||
                             player.intersects_left(sprites_still.get(10)) ||
                             player.intersects_left(sprites_still.get(11)) ||
                             player.intersects_left(sprites_still.get(12)) ||
                             player.intersects_left(sprites_still.get(19)) ||
                             player.intersects_left(sprites_still.get(20)) ||
                             player.intersects_left(sprites_still.get(21)) ||
                             player.intersects_left(sprites_still.get(22)) ||
                             player.intersects_left(sprites_still.get(23))){
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    //check if the player walks into house1
                    }else if(player.intersects_left(sprites_still.get(15))){
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        for(String s: game.goTo(new Command(CommandWord.GO, "house1"))){
                            infobox.appendText("\n" + s + "\n");
                        }
                        //remove all the inputs
                        input.removeAll(input);
                        //stop this AnimationTimer
                        this.stop();
                        //clear the textarea
                        infobox.clear();
                        //set the menu as a scene instead.
                        setNewScene();
                        //save the game when we walk out
                        WizardOfTreldan.saveGame();
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    //if no collission
                    }else if(player.intersects_left(sprites_still.get(16))){
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        if(!hasPrinted_door2){
                            int oldId = game.getCurrentRoomId();
                            for(String s: game.goTo(new Command(CommandWord.GO, "house2"))){
                                infobox.appendText("\n" + s + "\n");
                            }
                            hasPrinted_door2 = true;
                            if(game.getCurrentRoomId() != oldId){
                                //remove all the inputs
                                input.removeAll(input);
                                //stop this AnimationTimer
                                this.stop();
                                //clear the textarea
                                infobox.clear();
                                //set the menu as a scene instead.
                                setNewScene();
                                //save the game when we walk out
                                WizardOfTreldan.saveGame();
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
                    //check if the player walks a sprite
                    }else if(player.intersects_right(sprites_foreground.get(0)) ||
                             player.intersects_right(sprites_still.get(10)) ||
                             player.intersects_right(sprites_still.get(11)) ||
                             player.intersects_right(sprites_still.get(12)) ||
                             player.intersects_right(sprites_still.get(19)) ||
                             player.intersects_right(sprites_still.get(20)) ||
                             player.intersects_right(sprites_still.get(21)) ||
                             player.intersects_right(sprites_still.get(22)) ||
                             player.intersects_right(sprites_still.get(23))){
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    }else if(player.intersects_right(sprites_still.get(15))){
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        for(String s: game.goTo(new Command(CommandWord.GO, "door"))){
                            infobox.appendText("\n" + s + "\n");
                        }
                        //remove all the inputs
                        input.removeAll(input);
                        //stop this AnimationTimer
                        this.stop();
                        //clear the textarea
                        infobox.clear();
                        //set the menu as a scene instead.
                        setNewScene();
                        //save the game when we walk out
                        WizardOfTreldan.saveGame();
                        //Reset the velocity
                        player.setVelocity(0, 0);
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
                    //check if the player walks into a sprite
                    }else if(player.intersects_top(sprites_foreground.get(0)) ||
                             player.intersects_top(sprites_still.get(10)) ||
                             player.intersects_top(sprites_still.get(11)) ||
                             player.intersects_top(sprites_still.get(12)) ||
                             player.intersects_top(sprites_still.get(19)) ||
                             player.intersects_top(sprites_still.get(20)) ||
                             player.intersects_top(sprites_still.get(21)) ||
                             player.intersects_top(sprites_still.get(22)) ||
                             player.intersects_top(sprites_still.get(23))){
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    }else if(player.intersects_top(sprites_still.get(15))){
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        for(String s: game.goTo(new Command(CommandWord.GO, "door"))){
                            infobox.appendText("\n" + s + "\n");
                        }
                        //remove all the inputs
                        input.removeAll(input);
                        //stop this AnimationTimer
                        this.stop();
                        //clear the textarea
                        infobox.clear();
                        //set the menu as a scene instead.
                        setNewScene();
                        //save the game when we walk out
                        WizardOfTreldan.saveGame();
                        //Reset the velocity
                        player.setVelocity(0, 0);
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
                        
                    //check if the player walks into a sprite
                    }else if(player.intersects_bottom(sprites_foreground.get(0)) ||
                             player.intersects_bottom(sprites_still.get(10)) ||
                             player.intersects_bottom(sprites_still.get(11)) ||
                             player.intersects_bottom(sprites_still.get(12)) ||
                             player.intersects_bottom(sprites_still.get(19)) ||
                             player.intersects_bottom(sprites_still.get(20)) ||
                             player.intersects_bottom(sprites_still.get(21)) ||
                             player.intersects_bottom(sprites_still.get(22)) ||
                             player.intersects_bottom(sprites_still.get(23))){
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    }else if(player.intersects_bottom(sprites_still.get(15))){
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        for(String s: game.goTo(new Command(CommandWord.GO, "door"))){
                            infobox.appendText("\n" + s + "\n");
                        }
                        //remove all the inputs
                        input.removeAll(input);
                        //stop this AnimationTimer
                        this.stop();
                        //clear the textarea
                        infobox.clear();
                        //set the menu as a scene instead.
                        setNewScene();
                        //save the game when we walk out
                        WizardOfTreldan.saveGame();
                        //Reset the velocity
                        player.setVelocity(0, 0);
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
                        playerinventory.update(game);
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
                    if(!playerinventory.isShown()){
                        root.getChildren().add(menu);
                        playerinventory.setShown(true);
                    }
                }else{
                    if(playerinventory.isShown()){
                        root.getChildren().remove(menu);
                        playerinventory.setShown(false);
                    }
                }
            }
            public void setNewScene(){
                switch(game.getCurrentRoomId()){
                    case 3:
                        WizardOfTreldan.setHouse1Scene();
                        break;
                    case 4:
                        WizardOfTreldan.setHouse2Scene();
                        break;
                }
            }
        }.start();
>>>>>>> origin/master
        
        return theScene;
    }
}
