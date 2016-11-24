/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.SpriteController.Maps.Cave_sprites;
import Gui2D.SpriteController.Maps.WizardHouse_sprites;
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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
/**
 *
 * @author jonas
 */
public class WizardHouse extends Map{
    
    // Arraylist for player movement
    private ArrayList<String> input;
    
    // ArrayList for menu key strokes.
    private ArrayList<String> menu_input;
    
    private TWoT game;
    
    private WizardHouse_sprites wizardHouse_sprites;
    /**
     * Constructor for Cave
     * @param world 
     */
    public WizardHouse(SpriteController world){
        //init our super constructor
        super();
        
        //set the ArrayList's from the super class Map
        super.setInput(new ArrayList<String>());
        super.setMenu_input(new ArrayList<String>());
        
        // Link our globals to super class user inputs since no inheritence in AnimationTimer
        input = super.getInput();
        menu_input = super.getMenu_input();
        
        wizardHouse_sprites = new WizardHouse_sprites(world);
        wizardHouse_sprites.setWizardHouse_background_SingleSprites();
    }
    
    @Override
    public Scene getScene(){
        this.game = WizardOfTreldan.getGame();
        Group root = new Group();
        Scene theScene = new Scene( root );
        Canvas canvas_background = new Canvas(1024, 512);
        Canvas canvas_interactables = new Canvas(1024, 512);
        theScene.setFill(Color.rgb(83, 83, 83));
        //set the styleScheet
        theScene.getStylesheets().add("TextAreaStyle.css");
        
        root.getChildren().add(canvas_background);
        
        //add a canvas only for the player
        Canvas player_canvas = new Canvas(1024, 512);
        //add the canvas to the group
        root.getChildren().add(player_canvas);
        root.getChildren().add(canvas_interactables);

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
        infobox.appendText(welcome.get("getRooms") + "\n");
        
        //Menu testing start
        PlayerInventory playerinventory = new PlayerInventory(game, infobox);
        AnchorPane menu = playerinventory.getMenu();
        //menu testing done
        
        //get our player from super class since no inheritence in AnimationTimer
        PlayerSprite player = super.getPlayer();
        player.setPosition(505, 110);

        //set the keylisteners to the scene.
        theScene.setOnKeyReleased(getOnKeyRelease(player));
        theScene.setOnKeyPressed(getOnKeyPress());

        //create GraphicsContext from our player_canvas
        GraphicsContext moveable_gc = player_canvas.getGraphicsContext2D();
        //create GraphicsContext from our canvas_background
        GraphicsContext wizardHouse_background = canvas_background.getGraphicsContext2D();
        
        GraphicsContext wizardHouse_interactables = canvas_interactables.getGraphicsContext2D();
        
        //get all the sprites used in the wizardHouse
        List<Sprite> sprites_interactables = wizardHouse_sprites.getWizardHouse_interactable_sprites();
        List<Sprite> sprites_background = wizardHouse_sprites.getWizardHouse_background_sprites();
        //render all the sprites

        
        for (Sprite sprite : sprites_background) {
            sprite.render(wizardHouse_background);
        }
        
        for (Sprite sprite : sprites_interactables) {
            sprite.render(wizardHouse_interactables);
        }
        
        //set our world boundaries
        Rectangle2D worldBoundRight = new Rectangle2D(766, 0, 1, 512);
        Rectangle2D worldBoundLeft = new Rectangle2D(222, 0, 1, 512);
        Rectangle2D worldBoundBottom = new Rectangle2D(0, 370, 1024, 1);
        Rectangle2D worldBoundTop = new Rectangle2D(0, 63, 1024, 1);
        
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
                    } else if (player.intersects_left(sprites_background.get(7))
                            || player.intersects_left(sprites_background.get(6))
                            || player.intersects_left(sprites_background.get(7))
                            || player.intersects_left(sprites_background.get(8))
                            || player.intersects_left(sprites_background.get(9))
                            || player.intersects_left(sprites_background.get(10))
                            || player.intersects_left(sprites_background.get(11))
                            || player.intersects_left(sprites_background.get(12))
                            || player.intersects_left(sprites_background.get(13))
                            || player.intersects_left(sprites_interactables.get(0))
                              ) {
                        //Reset the velocity
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
                    } else if (player.intersects_right(sprites_background.get(7))
                            || player.intersects_right(sprites_background.get(8))
                            || player.intersects_right(sprites_background.get(9))
                            || player.intersects_right(sprites_background.get(10))
                            || player.intersects_right(sprites_background.get(11))
                            || player.intersects_right(sprites_background.get(12))
                            || player.intersects_right(sprites_background.get(13))
                            || player.intersects_right(sprites_background.get(3))
                            || player.intersects_right(sprites_background.get(1))
                            || player.intersects_right(sprites_interactables.get(0))
                              ) {
                        //Reset the velocity
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
                    } else if (player.intersects_top(sprites_background.get(4))
                            || player.intersects_top(sprites_background.get(7))
                            || player.intersects_top(sprites_background.get(8))
                            || player.intersects_top(sprites_background.get(9))
                            || player.intersects_top(sprites_background.get(10))
                            || player.intersects_top(sprites_background.get(11))
                            || player.intersects_top(sprites_background.get(12))
                            || player.intersects_top(sprites_background.get(13))
                            || player.intersects_top(sprites_background.get(3))
                            || player.intersects_top(sprites_interactables.get(0))
                              ) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    
                    } else if (player.intersects_top(sprites_background.get(2))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        //go to house1
                        game.goTo(new Command(CommandWord.GO, "door"));
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
                    } else if (player.intersects_bottom(sprites_background.get(6))
                            || player.intersects_bottom(sprites_background.get(5))
                            || player.intersects_bottom(sprites_background.get(1))
                            || player.intersects_bottom(sprites_interactables.get(0))
                              ) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    
                    } else {
                        player.setVelocity(0, 100);
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_DOWN);
                }
                
                if (menu_input.contains("E")) {
                    if (player.intersect(sprites_interactables.get(0))) {
                        for (String s : game.goTo(new Command(CommandWord.GO, "wizard"))) {
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
                    case 6:
                        WizardOfTreldan.setForestScene();
                        break;
                }
            }
        }.start();
        
        return theScene;
    }
}
