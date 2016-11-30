/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.SpriteController.Maps.Village_sprites;
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
public class Village extends Map {

    // Arraylist for player movement
    private ArrayList<String> input;

    // ArrayList for menu key strokes.
    private ArrayList<String> menu_input;

    private TWoT game;
    private Village_sprites villageSprites;

    /**
     * Constructor for Cellar
     *
     * @param world
     */
    public Village(SpriteController world) {
        //init our super constructor
        super();

        // Link our globals to super class user inputs since no inheritence in AnimationTimer
        input = super.getInput();
        menu_input = super.getMenu_input();

        villageSprites = new Village_sprites(world);
        villageSprites.setVillage_background_SingleSprites();
    }

    public Scene getScene() {
        this.game = WizardOfTreldan.getGame();
        //add group
        Group root = new Group();
        //set the scene
        Scene theScene = new Scene(root);
        //set background color
        theScene.setFill(Color.rgb(83, 83, 83));
        //set the styleScheet
        theScene.getStylesheets().add("TextAreaStyle.css");

        //set canvas of our background
        Canvas village_background = new Canvas(1024, 512);
        //add the canvas to the group
        root.getChildren().add(village_background);
        
        //set canvas of our items
        Canvas village_items = new Canvas(1024, 512);
        //add the canvas to the group
        root.getChildren().add(village_items);

        //add a canvas only for the player
        Canvas player_canvas = new Canvas(1024, 512);
        //add the canvas to the group
        root.getChildren().add(player_canvas);

        //set canvas of our foreground
        Canvas village_foreground = new Canvas(1024, 512);
        //add the canvas to the group
        root.getChildren().add(village_foreground);


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

        //Inventory Menu
        PlayerInventory playerinventory = new PlayerInventory(game, infobox);
        AnchorPane menu = playerinventory.getMenu();
        
        //Escape Menu
        GameMenu escmenu = new GameMenu();
        AnchorPane gameMenu = escmenu.getMenu();

        //get our player from super class since no inheritence in AnimationTimer
        PlayerSprite player = super.getPlayer();
        switch(game.getLastRoomId()){
            case 3:
                player.setPosition(960, 270);
                break;
            case 4:
                player.setPosition(290, 180);
                break;
            case 5:
                player.setPosition(120, 225);
                break;
            case 6:
                player.setPosition(488, 50);
                break;
            case 1:
                player.setPosition(700, 400);
                break;
            default:
                player.setPosition(700, 400);
                break;
        }

        //set the keylisteners to the scene.
        theScene.setOnKeyReleased(getOnKeyRelease(player));
        theScene.setOnKeyPressed(getOnKeyPress());

        //create GraphicsContext from our player_canvas
        GraphicsContext moveable_gc = player_canvas.getGraphicsContext2D();
        //create GraphicsContext from our canvas_background
        GraphicsContext background_gc = village_background.getGraphicsContext2D();
        //create GraphicsContext from our canvas_foreground
        GraphicsContext foreground_gc = village_foreground.getGraphicsContext2D();
        //create GraphicsContext from our canvas_items
        GraphicsContext interact_gc = village_items.getGraphicsContext2D();

        //get all the sprites which can be picked up
        List<Sprite> sprites_interact = villageSprites.getVillage_items();
        if(game.checkExisting("axe")){
            sprites_interact.get(0).render(interact_gc);
        }
        
        //get all the sprites used in the village
        List<Sprite> sprites_still = villageSprites.getVillage_background_sprites();
        //render all the sprites
        for (Sprite sprite : sprites_still) {
            sprite.render(background_gc);
        }

        //get all the sprites used in the village
        List<Sprite> sprites_foreground = villageSprites.getVillage_foreground_sprites();
        //render all the sprites
        for (Sprite sprite : sprites_foreground) {
            sprite.render(foreground_gc);
        }

        //add a color overlay to the foreground canvas
        foreground_gc.setFill(Color.rgb(0, 0, 0, 0.5));
        foreground_gc.fillRect(0, 0, 1024, 512);
        
        //set our world boundaries
        Rectangle2D worldBoundRight = new Rectangle2D(995, 0, 1, 512);
        Rectangle2D worldBoundLeft = new Rectangle2D(-2, 0, 1, 512);
        Rectangle2D worldBoundBottom = new Rectangle2D(0, 477, 1024, 1);
        Rectangle2D worldBoundTop = new Rectangle2D(0, 0, 1024, 1);

        new AnimationTimer() {
            //set the current time we started.
            private long lastNanoTime = System.nanoTime();
            private boolean hasPrinted_door2 = false;
            private boolean hasPrinted_door3 = false;

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
                    } else if (player.intersects_left(sprites_foreground.get(0))
                            || player.intersects_left(sprites_still.get(7))
                            || player.intersects_left(sprites_still.get(8))
                            || player.intersects_left(sprites_still.get(9))
                            || player.intersects_left(sprites_still.get(10))
                            || player.intersects_left(sprites_still.get(11))
                            || player.intersects_left(sprites_still.get(12))
                            || player.intersects_left(sprites_still.get(13))
                            || player.intersects_left(sprites_still.get(19))
                            || player.intersects_left(sprites_still.get(20))
                            || player.intersects_left(sprites_still.get(21))
                            || player.intersects_left(sprites_still.get(22))
                            || player.intersects_left(sprites_still.get(18))
                            || player.intersects_left(sprites_still.get(23))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    } else if (player.intersects_left(sprites_foreground.get(0))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    //if no colission
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
                    //check if the player walks into a sprite
                    } else if (player.intersects_right(sprites_foreground.get(0))
                            || player.intersects_right(sprites_still.get(7))
                            || player.intersects_right(sprites_still.get(8))
                            || player.intersects_right(sprites_still.get(9))
                            || player.intersects_right(sprites_still.get(10))
                            || player.intersects_right(sprites_still.get(11))
                            || player.intersects_right(sprites_still.get(12))
                            || player.intersects_right(sprites_still.get(13))
                            || player.intersects_right(sprites_still.get(19))
                            || player.intersects_right(sprites_still.get(20))
                            || player.intersects_right(sprites_still.get(21))
                            || player.intersects_right(sprites_still.get(22))
                            || player.intersects_right(sprites_still.get(18))
                            || player.intersects_right(sprites_still.get(23))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    } else if (player.intersects_right(sprites_foreground.get(0))) {
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
                        //check if the player walks into a sprite
                    } else if (player.intersects_top(sprites_foreground.get(0))
                            || player.intersects_top(sprites_still.get(7))
                            || player.intersects_top(sprites_still.get(8))
                            || player.intersects_top(sprites_still.get(9))
                            || player.intersects_top(sprites_still.get(10))
                            || player.intersects_top(sprites_still.get(11))
                            || player.intersects_top(sprites_still.get(12))
                            || player.intersects_top(sprites_still.get(13))
                            || player.intersects_top(sprites_still.get(19))
                            || player.intersects_top(sprites_still.get(20))
                            || player.intersects_top(sprites_still.get(21))
                            || player.intersects_top(sprites_still.get(22))
                            || player.intersects_top(sprites_still.get(18))
                            || player.intersects_top(sprites_still.get(23))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    } else if (player.intersects_top(sprites_foreground.get(0))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        //check if the player walks into house1
                    } else if (player.intersects_top(sprites_still.get(14))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        //go to house1
                        game.goTo(new Command(CommandWord.GO, "house3"));
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
                    //if collission to house2
                    } else if (player.intersects_top(sprites_still.get(15))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        if (!hasPrinted_door2) {
                            int oldId = game.getCurrentRoomId();
                            for (String s : game.goTo(new Command(CommandWord.GO, "house2"))) {
                                infobox.appendText("\n" + s + "\n");
                            }
                            hasPrinted_door2 = true;
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
                        }
                    //if colission with house 3
                    }else if (player.intersects_top(sprites_still.get(16))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        game.goTo(new Command(CommandWord.GO, "house1"));
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
                    //check collision with forrest door
                    }else if (player.intersects_top(sprites_still.get(17))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        if (game.checkExisting("forest")) {
                            game.goTo(new Command(CommandWord.GO, "forest"));
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
                        //check if the player walks into a sprite
                    } else if (player.intersects_bottom(sprites_foreground.get(0))
                            || player.intersects_bottom(sprites_still.get(7))
                            || player.intersects_bottom(sprites_still.get(8))
                            || player.intersects_bottom(sprites_still.get(9))
                            || player.intersects_bottom(sprites_still.get(10))
                            || player.intersects_bottom(sprites_still.get(11))
                            || player.intersects_bottom(sprites_still.get(12))
                            || player.intersects_bottom(sprites_still.get(13))
                            || player.intersects_bottom(sprites_still.get(19))
                            || player.intersects_bottom(sprites_still.get(20))
                            || player.intersects_bottom(sprites_still.get(21))
                            || player.intersects_bottom(sprites_still.get(22))
                            || player.intersects_bottom(sprites_still.get(18))
                            || player.intersects_bottom(sprites_still.get(23))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    } else if (player.intersects_bottom(sprites_foreground.get(0))) {
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
                    if(game.checkExisting("axe")){
                        if (player.intersect(sprites_interact.get(0))) {
                            for (String s : game.goTo(new Command(CommandWord.GO, "axe"))) {
                                infobox.appendText("\n" + s + "\n");
                            }
                            playerinventory.update(game);
                        }
                    }
                    if (player.intersect(sprites_still.get(13))) {
                        for (String s : game.goTo(new Command(CommandWord.GO, "guard"))) {
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

                interact_gc.clearRect(0, 0, 1024, 512);
                //render pickup items
                if(game.checkExisting("axe")){
                    sprites_interact.get(0).render(interact_gc);
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
                    case 3:
                        WizardOfTreldan.setHouse1Scene();
                        break;
                    case 4:
                        WizardOfTreldan.setHouse2Scene();
                        break;
                    case 5:
                        WizardOfTreldan.setHouse3Scene();
                        break;
                    case 6:
                        WizardOfTreldan.setForestScene();
                        break;
                }
            }
        }.start();

        return theScene;
    }
}
