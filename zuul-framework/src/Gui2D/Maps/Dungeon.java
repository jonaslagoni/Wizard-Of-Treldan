/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.SpriteController.Maps.Dungeon_sprites;
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
 * @author jonas
 */
public class Dungeon extends Map{
    
    // Arraylist for player movement
    private ArrayList<String> input;
    
    // ArrayList for menu key strokes.
    private ArrayList<String> menu_input;
    
    private TWoT game;
    
    private Dungeon_sprites dungeon_sprites;
    /**
     * Constructor for Dungeon
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
        
        dungeon_sprites = new Dungeon_sprites(world);
        dungeon_sprites.setDungeon_background_SingleSprites();
    }
    
    @Override
    public Scene getScene(){
        this.game = WizardOfTreldan.getGame();
        Group root = new Group();
        Scene theScene = new Scene( root );
        Canvas canvas_background = new Canvas(1024, 512);
        Canvas canvas_foreground = new Canvas(1024, 512);
        Canvas canvas_enemies = new Canvas (1024,512);
        theScene.setFill(Color.rgb(83, 83, 83));
        //set the styleScheet
        theScene.getStylesheets().add("TextAreaStyle.css");
        
        
        
        root.getChildren().add(canvas_background);
        
        //add a canvas only for the player
        Canvas player_canvas = new Canvas(1024, 512);
        //add the canvas to the group
        root.getChildren().add(canvas_enemies);
        root.getChildren().add(player_canvas);

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
        //get some of the games welcome message and add to the infobox
        HashMap<Integer, String> welcome = game.getWelcomeMessages();
        infobox.appendText(welcome.get(4) + "\n");
        
        //Menu testing start
        PlayerInventory playerinventory = new PlayerInventory(game, infobox);
        AnchorPane menu = playerinventory.getMenu();
        //menu testing done
        
        //escape menu
        GameMenu escmenu = new GameMenu();
        AnchorPane gameMenu = escmenu.getMenu();
        
        //get our player from super class since no inheritence in AnimationTimer
        PlayerSprite player = super.getPlayer();
        switch(game.getLastRoomId()){
            case 2:
                player.setPosition(325, 300);
                break;
            case 12:
                player.setPosition(700, 140);
                break;
            default:
                player.setPosition(200, 330);
        }


        //set the keylisteners to the scene.
        theScene.setOnKeyReleased(getOnKeyRelease(player));
        theScene.setOnKeyPressed(getOnKeyPress());

        //create GraphicsContext from our player_canvas
        GraphicsContext moveable_gc = player_canvas.getGraphicsContext2D();
        //create GraphicsContext from our canvas_background
        GraphicsContext dungeon_background = canvas_background.getGraphicsContext2D();
        GraphicsContext dungeon_foreground = canvas_foreground.getGraphicsContext2D();
        GraphicsContext enemiesGC = canvas_enemies.getGraphicsContext2D();
        
        //get all the sprites used in the dungeon
        List<Sprite> dungeon_background_sprites = dungeon_sprites.getDungeon_background_sprites();
        List<Sprite> dungeon_foreground_sprites = dungeon_sprites.getDungeon_foreground_sprites();
        List<Sprite> enemy_sprites = dungeon_sprites.getDungeon_enemy_sprite();
        //render all the sprites
        
        if (game.checkExisting("skeleton1")) {
            enemy_sprites.get(0).render(enemiesGC);
        }
        
        if (game.checkExisting("skeleton2")) {
            enemy_sprites.get(1).render(enemiesGC);
        }
        
        if (game.checkExisting("skeleton3")) {
            enemy_sprites.get(2).render(enemiesGC);
        }
        
        for (Sprite sprite : dungeon_background_sprites) {
            sprite.render(dungeon_background);
        }
        
        for (Sprite sprite : dungeon_foreground_sprites) {
            sprite.render(dungeon_foreground);
        }
        
        //set our world boundaries
        Rectangle2D worldBoundRight = new Rectangle2D(860, 0, 1, 512);
        Rectangle2D worldBoundLeft = new Rectangle2D(125, 0, 1, 512);
        Rectangle2D worldBoundBottom = new Rectangle2D(0, 405, 1024, 1);
        Rectangle2D worldBoundTop = new Rectangle2D(0, 59, 1024, 1);
        
        new AnimationTimer() {
            //set the current time we started.
            private long lastNanoTime = System.nanoTime();

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
                        //check if the player walks into a sprite
                    } else if (player.intersects_left(dungeon_background_sprites.get(12))
                              || player.intersects_left(dungeon_background_sprites.get(13))
                              || player.intersects_left(dungeon_background_sprites.get(14))
                              ) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    }else if (game.checkExisting("skeleton1") && player.intersects_left(enemy_sprites.get(0))) {
                            player.setVelocity(0, 0);   
                            
                    } else if (game.checkExisting("skeleton2") && player.intersects_left(enemy_sprites.get(1))) {
                            player.setVelocity(0, 0);
                                
                    } else if (game.checkExisting("skeleton3") && player.intersects_left(enemy_sprites.get(2))) {
                            player.setVelocity(0, 0);
                    } else {
                        player.setVelocity(-100, 0);
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
                    //check if the player walks into a sprite
                    } else if (player.intersects_right(dungeon_background_sprites.get(12))
                              || player.intersects_right(dungeon_background_sprites.get(13))
                              || player.intersects_right(dungeon_background_sprites.get(14))
                              ) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    } else if (game.checkExisting("skeleton1") && player.intersects_right(enemy_sprites.get(0))) {
                            player.setVelocity(0, 0);   
                            
                    } else if (game.checkExisting("skeleton2") && player.intersects_right(enemy_sprites.get(1))) {
                            player.setVelocity(0, 0);
                                
                    } else if (game.checkExisting("skeleton3") && player.intersects_right(enemy_sprites.get(2))) {
                            player.setVelocity(0, 0);
                    } else {
                        player.setVelocity(100, 0);
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
                        //check if the player walks into a sprite
                    } else if (player.intersects_top(dungeon_background_sprites.get(12))
                              || player.intersects_top(dungeon_background_sprites.get(13))
                              || player.intersects_top(dungeon_background_sprites.get(14))
                              ) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    } else if (player.intersects_top(dungeon_background_sprites.get(2))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        int oldId = game.getCurrentRoomId();
                        for (String s : game.goTo(new Command(CommandWord.GO, "pathway"))) {
                            infobox.appendText("\n" + s + "\n");
                        }
                        if (game.getCurrentRoomId() != oldId) {
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
                    } else if (game.checkExisting("skeleton1") && player.intersects_top(enemy_sprites.get(0))) {
                        player.setVelocity(0, 0);   
                    } else if (game.checkExisting("skeleton2") && player.intersects_top(enemy_sprites.get(1))) {
                        player.setVelocity(0, 0);
                    } else if (game.checkExisting("skeleton3") && player.intersects_top(enemy_sprites.get(2))) {
                        player.setVelocity(0, 0);
                    } else {
                        player.setVelocity(0, -100);
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
                    } else if (game.checkExisting("skeleton1") && player.intersects_bottom(enemy_sprites.get(0))) {
                            player.setVelocity(0, 0);   
                            
                    } else if (game.checkExisting("skeleton2") && player.intersects_bottom(enemy_sprites.get(1))) {
                            player.setVelocity(0, 0);
                                
                    } else if (game.checkExisting("skeleton3") && player.intersects_bottom(enemy_sprites.get(2))) {
                            player.setVelocity(0, 0);
                    }
                    else {
                        player.setVelocity(0, 100);
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_DOWN);
                }
                
                if (menu_input.contains("E")) {
                    if (player.intersect(enemy_sprites.get(0))) {
                        for (String s : game.goTo(new Command(CommandWord.GO, "skeleton1"))) {
                            infobox.appendText("\n" + s + "\n");
                        }
                        playerinventory.update(game);
                    }
                    if (player.intersect(enemy_sprites.get(1))) {
                        for (String s : game.goTo(new Command(CommandWord.GO, "skeleton2"))) {
                            infobox.appendText("\n" + s + "\n");
                        }
                        playerinventory.update(game);
                    }
                    if (player.intersect(enemy_sprites.get(2))) {
                        for (String s : game.goTo(new Command(CommandWord.GO, "skeleton3"))) {
                            infobox.appendText("\n" + s + "\n");
                        }
                        playerinventory.update(game);
                    }
                    menu_input.remove("E");
                }
                //update the players velocity
                player.update(elapsedTime);
                //clear our player
                moveable_gc.clearRect(0, 0, 1024, 512);
                //render our new player
                player.render(moveable_gc);

                enemiesGC.clearRect(0, 0, 1024, 512);
                if(game.checkExisting("skeleton1")){
                    enemy_sprites.get(0).render(enemiesGC);
                }
                if(game.checkExisting("skeleton2")){
                    enemy_sprites.get(1).render(enemiesGC);
                }
                if(game.checkExisting("skeleton3")){
                    enemy_sprites.get(2).render(enemiesGC);
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
                    case 12:
                        WizardOfTreldan.setLibraryScene();
                        break;
                    
                }
            }
        }.start();
        
        return theScene;
    }
}
