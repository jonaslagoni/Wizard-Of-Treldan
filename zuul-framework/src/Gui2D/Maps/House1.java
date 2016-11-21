/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.SpriteController.Maps.House1_sprites;
import Gui2D.SpriteController.SingleSprite.PlayerSprite;
import Gui2D.SpriteController.Sprite;
import Gui2D.SpriteController.SpriteController;
import Gui2D.WizardOfTreldan;
import TWoT_A1.Command;
import TWoT_A1.CommandWord;
import TWoT_A1.Item;
import TWoT_A1.QuestItem;
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

public class House1 extends Map{
    
    // Arraylist for player movement
    private ArrayList<String> input;
    
    // ArrayList for menu key strokes.
    private ArrayList<String> menu_input;
    
    private TWoT game;
    private House1_sprites house_sprites;
    /**
     * Constructor for Cellar
     * @param world 
     */
    public House1(SpriteController world){
        //init our super constructor
        super();
        
        //set the world constructor
        input = super.getInput();
        menu_input = super.getMenu_input();
        
        house_sprites = new House1_sprites(world);
        house_sprites.setHouse1_background_SingleSprites();
    }
    
    @Override
    public Scene getScene(){
        this.game = WizardOfTreldan.getGame();
        Group root = new Group();
        Scene theScene = new Scene( root );
        //set background color
        theScene.setFill(Color.rgb(83, 83, 83));
        //set the styleScheet
        theScene.getStylesheets().add("TextAreaStyle.css");
        
        //canvas for backgrounds
        Canvas canvas_background = new Canvas( 512, 300);
        //relocate the canvas
        canvas_background.relocate(250, 50);
        //add canvas to the group
        root.getChildren().add(canvas_background);
        
        
        //set canvas of our items
        Canvas house1_monsters = new Canvas(512, 300);
        //relocate the canvas
        house1_monsters.relocate(250, 50);
        //add the canvas to the group
        root.getChildren().add(house1_monsters);
        
        
        //add a canvas only for the player
        Canvas player_canvas = new Canvas(512, 300);
        //relocate the canvas
        player_canvas.relocate(250, 50);
        //add the canvas to the group
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

        //get our player from super class since no inheritence in AnimationTimer
        PlayerSprite player = super.getPlayer();
        player.setPosition(100, 50);

        //set the keylisteners to the scene.
        theScene.setOnKeyReleased(getOnKeyRelease(player));
        theScene.setOnKeyPressed(getOnKeyPress());
        
        
        //add graphicscontext to each canvas
        GraphicsContext background_gc = canvas_background.getGraphicsContext2D();
        //create GraphicsContext from our monster canvas containing all
        GraphicsContext monster_gc = house1_monsters.getGraphicsContext2D();
        //create GraphicsContext from our player_canvas
        GraphicsContext moveable_gc = player_canvas.getGraphicsContext2D();
        
        //get all the sprites of monsters
        List<Sprite> sprites_interact = house_sprites.getHouse_monster_sprites();
        for(Sprite sprite : sprites_interact) {
            sprite.render(monster_gc);
        }
        
        //generate all the background sprites
        List<Sprite> sprites_still = house_sprites.getHouse();
        for(Sprite sprite : sprites_still){
            sprite.render(background_gc);
        }
            
        //set our world boundaries
        Rectangle2D worldBoundRight = new Rectangle2D(512-33, 0, 1, 250);
        Rectangle2D worldBoundLeft = new Rectangle2D(0, 0, 1, 250);
        Rectangle2D worldBoundBottom = new Rectangle2D(0, 220, 512, 1);
        Rectangle2D worldBoundTop = new Rectangle2D(0, 0, 512, 1);
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
                    //no collission continue
                    } else if (player.intersects_left(sprites_still.get(3))
                            || player.intersects_left(sprites_still.get(4))
                            || player.intersects_left(sprites_still.get(5))
                            || player.intersects_left(sprites_still.get(6))
                            || player.intersects_left(sprites_still.get(7))
                            || player.intersects_left(sprites_still.get(8))
                            || player.intersects_left(sprites_still.get(9))
                            || player.intersects_left(sprites_still.get(10))
                            || player.intersects_left(sprites_still.get(11))
                            || player.intersects_left(sprites_still.get(12))
                            || player.intersects_left(sprites_still.get(13))
                            || player.intersects_left(sprites_still.get(14))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
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
                    //if no colission
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
                    //if no colission
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
                    //if no colission
                    }else {
                        player.setVelocity(0, 100);
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_DOWN);
                }

                if (menu_input.contains("E")) {
                    
                    menu_input.remove("E");
                }
                //update the players velocity
                player.update(elapsedTime);
                //clear our player
                moveable_gc.clearRect(0, 0, 512, 300);
                //render our new player
                player.render(moveable_gc);

                monster_gc.clearRect(0, 0, 1024, 512);
                //render pickup items
                for(Sprite sprite : sprites_interact) {
                    sprite.render(monster_gc);
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
                    case 2:
                        WizardOfTreldan.setVillageScene();
                        break;
                }
            }
        }.start();
        
        return theScene;
    }
}
