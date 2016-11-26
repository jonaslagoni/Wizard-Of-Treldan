/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.SpriteController.Maps.Library_sprites;
import Gui2D.SpriteController.SingleSprite.PlayerSprite;
import Gui2D.SpriteController.Sprite;
import Gui2D.SpriteController.SpriteController;
import Gui2D.WizardOfTreldan;
import TWoT_A1.Command;
import TWoT_A1.CommandWord;
import TWoT_A1.TWoT;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
/**
 *
 * @author Mads
 */
public class Library extends Map{
    
    // Arraylist for player movement
    private ArrayList<String> input;
    
    // ArrayList for menu key strokes.
    private ArrayList<String> menu_input;
    private TWoT game;
    private Library_sprites library_sprites;
    /**
     * Constructor for Library
     * @param world 
     */
    public Library(SpriteController world){
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
        
        library_sprites = new Library_sprites(world);
        library_sprites.setLibrary_background_SingleSprites();
    }
    
    @Override
    public Scene getScene(){
        this.game = WizardOfTreldan.getGame();
        Group root = new Group();
        Scene theScene = new Scene( root );
        
        theScene.setFill(Color.rgb(83, 83, 83));
        Canvas canvas_background = new Canvas(770,385);
        canvas_background.relocate(126,66);
        root.getChildren().add(canvas_background);
       
        //get our player from super class since no inheritence in AnimationTimer
        PlayerSprite player = super.getPlayer();
        player.setPosition(600,350 );
        Canvas player_canvas = new Canvas(1024, 512);
        root.getChildren().add(player_canvas);
        
        //set canvas of our items
        Canvas library_monsters = new Canvas(1024, 512);
        //add the canvas to the group
        library_monsters.relocate(126,66);
        root.getChildren().add(library_monsters);
        
        /**
         * TextArea used to give the user more information about the game. What
         * to do and and what happens.
         */
        TextArea infobox = Infobox.getInfoBox();
        //adding stackPane with the textarea component.
        StackPane s = new StackPane(infobox);
        s.setPrefSize(300, 150);
        s.relocate(0, 362);
        root.getChildren().add(s);
        theScene.getStylesheets().add("TextAreaStyle.css");
        
        //get some of the games welcome message and add to the infobox
        HashMap<Integer, String> welcome = game.getWelcomeMessages();
        infobox.appendText(welcome.get(11) + "\n");
        
        //add our player inventory
        PlayerInventory playerinventory = new PlayerInventory(game, infobox);
        //player menu visuals
        AnchorPane menu = playerinventory.getMenu();
        
        //escape menu start
        GameMenu escmenu = new GameMenu();
        AnchorPane gameMenu = escmenu.getMenu();
        //escape menu stop
        
   
        //set the keylisteners to the scene.
        theScene.setOnKeyReleased(getOnKeyRelease(player));
        theScene.setOnKeyPressed(getOnKeyPress());
        
        //draw graphicscontext for our diffrent kinds of sprites
        GraphicsContext backgroundContext = canvas_background.getGraphicsContext2D();
        //create GraphicsContext from our player canvas 
        GraphicsContext moveable_gc = player_canvas.getGraphicsContext2D();
        //create GraphicsContext from our monster canvas containing all interactable sprites that needs to be unset
        GraphicsContext monster_gc = library_monsters.getGraphicsContext2D();
        
       
        
        
        List<Sprite> sprites_still = library_sprites.getSpriteList_background();
        //render sprites via a for each loop of the sprites contained in the sprite list
        for (Sprite i : sprites_still) {
            i.render(backgroundContext);
            
        }
        
        //get all the sprites of monsters
        List<Sprite> sprites_interact = library_sprites.getSpriteList_monsters();
        //render them if they exist in the game world
        if(game.checkExisting("librarian")){
            sprites_interact.get(0).render(monster_gc);
        }
        
        //set our world boundaries
        Rectangle2D worldBoundRight = new Rectangle2D(840, 0, 1, 512);
        Rectangle2D worldBoundLeft = new Rectangle2D(145, 0, 1, 512);
        Rectangle2D worldBoundBottom = new Rectangle2D(0, 415, 1024, 1);
        Rectangle2D worldBoundTop = new Rectangle2D(0, 64, 1024, 1);
        
        
        new AnimationTimer() {
            //set the current time we started.
            private long lastNanoTime = System.nanoTime();
            private boolean hasPrinted = false;

            //what to do each cycle
            @Override
            public void handle(long currentNanoTime) {
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
                if (input.contains("LEFT")) {
                    //check if the user walks into a world boundary
                    if (player.intersects_left(worldBoundLeft)) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    //no collission continue
                    } else if (
                            player.intersects_left(sprites_still.get(3))  ||
                            player.intersects_left(sprites_still.get(4))  ||
                            player.intersects_left(sprites_still.get(5))  ||
                            player.intersects_left(sprites_still.get(6))  ||
                            player.intersects_left(sprites_still.get(7))  ||
                            player.intersects_left(sprites_still.get(9))  ||
                            player.intersects_left(sprites_still.get(10)) ||
                            player.intersects_left(sprites_still.get(11)) ||
                            player.intersects_left(sprites_still.get(12)) ||
                            player.intersects_left(sprites_still.get(13)) ||
                            player.intersects_left(sprites_still.get(14)) ||
                            player.intersects_left(sprites_still.get(15)) ||
                            player.intersects_left(sprites_still.get(16)) ||
                            player.intersects_left(sprites_still.get(17)) 
                             ){
                        player.setVelocity(0, 0);
                    }else if(game.checkExisting("librarian")){
                        if(player.intersects_left(sprites_interact.get(0))){
                            player.setVelocity(0, 0);
                        }else{
                            player.setVelocity(-100,0);
                        }
                    }else{
                        player.setVelocity(-100,0);
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_LEFT);
                }

                //check if the user wants to walk right.
                if (input.contains("RIGHT")) {
                    //check if the user walks into a world boundary
                    if (player.intersects_right(worldBoundRight)) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    } else if (
                            player.intersects_right(sprites_still.get(3))  ||
                            player.intersects_right(sprites_still.get(4))  ||
                            player.intersects_right(sprites_still.get(5))  ||
                            player.intersects_right(sprites_still.get(6))  ||
                            player.intersects_right(sprites_still.get(7))  ||
                            player.intersects_right(sprites_still.get(9))  ||
                            player.intersects_right(sprites_still.get(10)) ||
                            player.intersects_right(sprites_still.get(11)) ||
                            player.intersects_right(sprites_still.get(12)) ||
                            player.intersects_right(sprites_still.get(13)) ||
                            player.intersects_right(sprites_still.get(14)) ||
                            player.intersects_right(sprites_still.get(15)) ||
                            player.intersects_right(sprites_still.get(16)) ||
                            player.intersects_right(sprites_still.get(17)) 
                             ){
                         player.setVelocity(0, 0);
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    }else if(game.checkExisting("librarian")){
                        if(player.intersects_right(sprites_interact.get(0))){
                            player.setVelocity(0, 0);
                        }else{
                            player.setVelocity(100,0);
                        }
                    }else{
                        player.setVelocity(100,0);
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_RIGHT);
                }

               
                
                //check if the user wants to walk up.
                if (input.contains("UP")) {
                    //check if the user walks into a world boundary
                    if (player.intersects_top(worldBoundTop)) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    }else if (
                            player.intersects_top(sprites_still.get(3))  ||
                            player.intersects_top(sprites_still.get(4))  ||
                            player.intersects_top(sprites_still.get(5))  ||
                            player.intersects_top(sprites_still.get(6))  ||
                            player.intersects_top(sprites_still.get(7))  ||
                            player.intersects_top(sprites_still.get(9))  ||
                            player.intersects_top(sprites_still.get(10)) ||
                            player.intersects_top(sprites_still.get(11)) ||
                            player.intersects_top(sprites_still.get(12)) ||
                            player.intersects_top(sprites_still.get(13)) ||
                            player.intersects_top(sprites_still.get(14)) ||
                            player.intersects_top(sprites_still.get(15)) ||
                            player.intersects_top(sprites_still.get(16)) ||
                            player.intersects_top(sprites_still.get(17)) 
                            ) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    }else if(player.intersects_top(sprites_still.get(2))){
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
                                //save the game when we walk out
                                WizardOfTreldan.saveGame();
                            }
                       }
                    }else if(game.checkExisting("librarian") && player.intersects_top(sprites_interact.get(0))){
                        player.setVelocity(0, 0);
                    
                    }else{
                        player.setVelocity(0,-100);
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_UP);
                }
                
                //check if the user wants to walk down.
                if (input.contains("DOWN")) {
                    //check if the user walks into a world boundary
                    if (player.intersects_bottom(worldBoundBottom)) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        //check if the player walks into a sprite
                    }else if(
                            player.intersects_bottom(sprites_still.get(3))  ||
                            player.intersects_bottom(sprites_still.get(4))  ||
                            player.intersects_bottom(sprites_still.get(5))  ||
                            player.intersects_bottom(sprites_still.get(6))  ||
                            player.intersects_bottom(sprites_still.get(7))  ||
                            player.intersects_bottom(sprites_still.get(9))  ||
                            player.intersects_bottom(sprites_still.get(10)) ||
                            player.intersects_bottom(sprites_still.get(11)) ||
                            player.intersects_bottom(sprites_still.get(12)) ||
                            player.intersects_bottom(sprites_still.get(13)) ||
                            player.intersects_bottom(sprites_still.get(14)) ||
                            player.intersects_bottom(sprites_still.get(15)) ||
                            player.intersects_bottom(sprites_still.get(16)) ||
                            player.intersects_bottom(sprites_still.get(17)) 
                             ){
                         player.setVelocity(0, 0);
                     }else if(game.checkExisting("librarian")){
                            if(player.intersects_bottom(sprites_interact.get(0))){
                                player.setVelocity(0, 0);
                            }else{
                                player.setVelocity(0,100);
                     }
                      
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_DOWN);
                }
                
                if (menu_input.contains("E")) {
                    if (player.intersect(sprites_still.get(3))) {
                        for (String s : game.goTo(new Command(CommandWord.GO, "chest"))) {
                            infobox.appendText("\n" + s + "\n");
                        }
                        playerinventory.update(game);
                    }
                    if(player.intersect(sprites_interact.get(0))){
                           if(game.checkExisting("librarian")){ 
                            for(String s : game.goTo(new Command(CommandWord.GO, "librarian"))) {
                                infobox.appendText("\n" + s + "\n");
                            }
                          playerinventory.update(game);
                        }
                    
                           
                           
                    }
                    
                    menu_input.remove("E");
                }
                //update the players velocity
                player.update(elapsedTime);
                //clear our player
                moveable_gc.clearRect(0, 0, 1024, 512);
                
                //render our new player
                player.render(moveable_gc);
                
                monster_gc.clearRect(0, 0, 1024, 512);
                
                //check if monsters still exist in the game world
                if(game.checkExisting("librarian")){
                    sprites_interact.get(0).render(monster_gc);
                }
                
                //check if the user wants to see a menu.
                if(menu_input.contains("ESCAPE")){
                    if(!escmenu.isShown()){
                        root.getChildren().add(gameMenu);
                        escmenu.setShown(true);
                    }
                }else{
                    if(escmenu.isShown()){
                        root.getChildren().remove(gameMenu);
                        escmenu.setShown(false);
                    }
                }
                
                //check if the user wants to see a menu.
                if (menu_input.contains("I")) {
                    if (!playerinventory.isShown()) {
                        root.getChildren().add(menu);
                        playerinventory.setShown(true);
                    }
                } else if (playerinventory.isShown()) {
                    root.getChildren().remove(menu);
                    playerinventory.setShown(false);
                }
            }
                    
            public void setNewScene() {
                switch (game.getCurrentRoomId()) {
                    case 13:
                        WizardOfTreldan.setEvilWizardLairScene();
                        break;
                    
                }
            }
        }.start();
        
        System.out.println(game.getCurrentRoomId());
        
        return theScene;
    }
}
