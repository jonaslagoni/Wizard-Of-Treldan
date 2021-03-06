/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.SpriteController.Maps.Cave_sprites;
import Gui2D.SpriteController.SingleSprite.PlayerSprite;
import Gui2D.SpriteController.Sprite;
import Gui2D.SpriteController.SpriteController;
import Gui2D.WizardOfTreldan;
import TWoT.Command;
import TWoT.CommandWord;
import TWoT.TWoT;
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
public class Cave extends PlayableMaps {

    // Arraylist for player movement
    private ArrayList<String> input;
    // ArrayList for menu key strokes.
    private ArrayList<String> menu_input;
    //global game object
    private TWoT game;
    private Cave_sprites cave_sprites;

    /**
     * Constructor for Cave
     *
     * @param world SpriteController
     */
    public Cave(SpriteController world) {
        //init our super constructor
        super();
        cave_sprites = new Cave_sprites(world);
        cave_sprites.setCave_background_SingleSprites();
    }

    /**
     * @return the cave scene
     */
    @Override
    public Scene getScene() {
        // Link our globals to super class user inputs since no inheritence in AnimationTimer
        input = super.getInput();
        menu_input = super.getMenu_input();
        game = WizardOfTreldan.getGame();

        //main group
        Group root = new Group();
        Scene theScene = new Scene(root);
        Canvas canvas_background = new Canvas(1024, 512);
        Canvas enemy_canvas = new Canvas(1024, 512);
        theScene.setFill(Color.rgb(83, 83, 83));
        //set the styleScheet
        theScene.getStylesheets().add("TextAreaStyle.css");

        root.getChildren().add(canvas_background);

        //add a canvas only for the player
        Canvas player_canvas = new Canvas(1024, 512);
        //add the canvas to the group
        root.getChildren().add(enemy_canvas);
        root.getChildren().add(player_canvas);

        Canvas foreground_canvas = new Canvas(1024, 512);
        root.getChildren().add(foreground_canvas);

        //minimap ontop of everything else
        MiniMap miniMap = new MiniMap(game);
        //get the group of canvases from minimap object
        Group miniMapGroup = miniMap.getMinimap();
        //update the minimap correctly with the player canvas size
        miniMap.updateMiniMap(1024.0, 512.0);
        //add the group to the root group
        root.getChildren().add(miniMapGroup);

        //esc menu
        GameMenu escmenu = new GameMenu();
        AnchorPane gameMenu = escmenu.getMenu();

        /**
         * TextArea used to give the user more information about the game. What
         * to do and and what happens.
         */
        TextArea infobox = Infobox.getInfoBox();
        //adding stackPane with the textarea component.
        StackPane infoboxPane = new StackPane(infobox);
        infoboxPane.setPrefSize(300, 150);
        infoboxPane.relocate(0, 362);
        root.getChildren().add(infoboxPane);
        //get some of the games welcome message and add to the infobox
        HashMap<Integer, String> welcome = game.getWelcomeMessages();
        infobox.appendText(welcome.get(3) + "\n");

        //Menu testing start
        PlayerInventory playerinventory = new PlayerInventory(game, infobox);
        AnchorPane menu = playerinventory.getMenu();
        //menu testing done

        //get our player from super class since no inheritence in AnimationTimer
        PlayerSprite player = super.getPlayer();
        switch (game.getLastRoomId()) {
            case 6:
                player.setPosition(650, 345);
                break;
            case 9:
                player.setPosition(476, 50);
                break;
            default:
                player.setPosition(100, 100);
                break;
        }
        //set the keylisteners to the scene.
        theScene.setOnKeyReleased(getOnKeyRelease(player));
        theScene.setOnKeyPressed(getOnKeyPress());

        //create GraphicsContext from our player_canvas
        GraphicsContext moveable_gc = player_canvas.getGraphicsContext2D();
        //create GraphicsContext from our canvas_background
        GraphicsContext cave_background = canvas_background.getGraphicsContext2D();
        //create GraphicsContext for our enemies
        GraphicsContext enemiesGC = enemy_canvas.getGraphicsContext2D();

        //get all the sprites used in the cave
        List<Sprite> sprites_background = cave_sprites.getCave_background_sprites();
        // get all enemy sprites used in cave
        List<Sprite> enemy_sprites = cave_sprites.getEnemy_sprites();

        //render all the sprites
        if (game.checkExisting("troll1")) {
            enemy_sprites.get(0).render(enemiesGC);
        }
        if (game.checkExisting("troll2")) {
            enemy_sprites.get(1).render(enemiesGC);
        }
        if (game.checkExisting("troll3")) {
            enemy_sprites.get(2).render(enemiesGC);
        }

        for (Sprite sprite : sprites_background) {
            sprite.render(cave_background);
        }

        //set our world boundaries
        Rectangle2D worldBoundRight = new Rectangle2D(766, 0, 1, 512);
        Rectangle2D worldBoundLeft = new Rectangle2D(230, 0, 1, 512);
        Rectangle2D worldBoundBottom = new Rectangle2D(0, 410, 1024, 1);
        Rectangle2D worldBoundTop = new Rectangle2D(0, 0, 1024, 1);

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

                // <editor-fold defaultstate="collapsed" desc=" LEFT INPUT ">
                //now check for the users input
                //check if the user wants to walk left.
                if (input.contains("LEFT")) {
                    //check if the user walks into a world boundary
                    if (player.intersects_left(worldBoundLeft)) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        //check if the player walks into a sprite
                    } else if (player.intersects_left(sprites_background.get(5))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);

                    } else if (game.checkExisting("troll1") && player.intersects_left(enemy_sprites.get(0))) {
                        player.setVelocity(0, 0);

                    } else if (game.checkExisting("troll2") && player.intersects_left(enemy_sprites.get(1))) {
                        player.setVelocity(0, 0);

                    } else if (game.checkExisting("troll3") && player.intersects_left(enemy_sprites.get(2))) {
                        player.setVelocity(0, 0);

                    } else {
                        player.setVelocity(-100, 0);
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_LEFT);
                }

                // </editor-fold>
                // <editor-fold defaultstate="collapsed" desc=" RIGHT INPUT ">
                //check if the user wants to walk right.
                if (input.contains("RIGHT")) {
                    //check if the user walks into a world boundary
                    if (player.intersects_right(worldBoundRight)) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        //check if the player walks into a sprite
                    } else if (player.intersects_right(sprites_background.get(5))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    } else if (game.checkExisting("troll1") && player.intersects_right(enemy_sprites.get(0))) {
                        player.setVelocity(0, 0);

                    } else if (game.checkExisting("troll2") && player.intersects_right(enemy_sprites.get(1))) {
                        player.setVelocity(0, 0);

                    } else if (game.checkExisting("troll3") && player.intersects_right(enemy_sprites.get(2))) {
                        player.setVelocity(0, 0);

                    } else {
                        player.setVelocity(100, 0);
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_RIGHT);
                }

                // </editor-fold>
                // <editor-fold defaultstate="collapsed" desc=" UP INPUT ">
                //check if the user wants to walk up.
                if (input.contains("UP")) {
                    //check if the user walks into a world boundary
                    if (player.intersects_top(worldBoundTop)) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        //check if the player walks into a sprite
                    } else if (game.checkExisting("troll1") && player.intersects_top(enemy_sprites.get(0))) {
                        player.setVelocity(0, 0);

                    } else if (game.checkExisting("troll2") && player.intersects_top(enemy_sprites.get(1))) {
                        player.setVelocity(0, 0);

                    } else if (game.checkExisting("troll3") && player.intersects_top(enemy_sprites.get(2))) {
                        player.setVelocity(0, 0);
                    } else if (player.intersects_top(sprites_background.get(5))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        if (!game.checkExisting("troll1") && !game.checkExisting("troll2") && !game.checkExisting("troll3")) {
                            int oldId = game.getCurrentRoomId();
                            for (String s : game.goTo(new Command(CommandWord.GO, "forest"))) {
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
                        }
                    } else if (player.intersects_top(sprites_background.get(6))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        if (!game.checkExisting("troll1") && !game.checkExisting("troll2") && !game.checkExisting("troll3")) {
                            int oldId = game.getCurrentRoomId();
                            for (String s : game.goTo(new Command(CommandWord.GO, "lair"))) {
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
                        }
                    } else {
                        player.setVelocity(0, -100);
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_UP);
                }

                // </editor-fold>
                // <editor-fold defaultstate="collapsed" desc=" DOWN INPUT ">
                //check if the user wants to walk down.
                if (input.contains("DOWN")) {
                    //check if the user walks into a world boundary
                    if (player.intersects_bottom(worldBoundBottom)) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        //check if the player walks into a sprite
                    } else if (player.intersects_bottom(sprites_background.get(5))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);

                    } else if (game.checkExisting("troll1") && player.intersects_bottom(enemy_sprites.get(0))) {
                        player.setVelocity(0, 0);

                    } else if (game.checkExisting("troll2") && player.intersects_bottom(enemy_sprites.get(1))) {
                        player.setVelocity(0, 0);

                    } else if (game.checkExisting("troll3") && player.intersects_bottom(enemy_sprites.get(2))) {
                        player.setVelocity(0, 0);

                    } else {
                        player.setVelocity(0, 100);
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_DOWN);
                }

                // </editor-fold>
                //check if the user wants to interact
                if (menu_input.contains("E")) {
                    if (game.checkExisting("troll1") && player.intersect(enemy_sprites.get(0))) {
                        for (String s : game.goTo(new Command(CommandWord.GO, "troll1"))) {
                            infobox.appendText("\n" + s + "\n");
                        }
                        playerinventory.update(game);
                    } else if (game.checkExisting("troll2") && player.intersect(enemy_sprites.get(1))) {
                        for (String s : game.goTo(new Command(CommandWord.GO, "troll2"))) {
                            infobox.appendText("\n" + s + "\n");
                        }
                        playerinventory.update(game);
                    } else if (game.checkExisting("troll3") && player.intersect(enemy_sprites.get(2))) {
                        for (String s : game.goTo(new Command(CommandWord.GO, "troll3"))) {
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

                //clear and rerender monsters
                enemiesGC.clearRect(0, 0, 1024, 512);
                if (game.checkExisting("troll1")) {
                    enemy_sprites.get(0).render(enemiesGC);
                }
                if (game.checkExisting("troll2")) {
                    enemy_sprites.get(1).render(enemiesGC);
                }
                if (game.checkExisting("troll3")) {
                    enemy_sprites.get(2).render(enemiesGC);
                }

                //check if the user wants to see a menu.
                if (menu_input.contains("ESCAPE")) {
                    if (!escmenu.isShown()) {
                        root.getChildren().add(gameMenu);
                        escmenu.setShown(true);
                    }
                } else if (escmenu.isShown()) {
                    root.getChildren().remove(gameMenu);
                    escmenu.setShown(false);
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

                //update the player on the minimaps position
                miniMap.updateMiniMap_player(player.getPositionX(), player.getPositionY());
            }

            /**
             * Sets the new scene depending on the room id.
             */
            public void setNewScene() {
                switch (game.getCurrentRoomId()) {
                    case 9:
                        WizardOfTreldan.setGruulsLairScene();
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
