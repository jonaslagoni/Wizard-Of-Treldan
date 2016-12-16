/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.SpriteController.Maps.GruulsLair_sprites;
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
public class GruulsLair extends PlayableMaps {

    // Arraylist for player movement
    private ArrayList<String> input;
    // ArrayList for menu key strokes.
    private ArrayList<String> menu_input;
    private TWoT game;
    private GruulsLair_sprites gruulsLair_sprites;

    /**
     * Constructor for Cave
     *
     * @param world SpriteController
     */
    public GruulsLair(SpriteController world) {
        //init our super constructor
        super();
        gruulsLair_sprites = new GruulsLair_sprites(world);
        gruulsLair_sprites.setGruulsLair_background_SingleSprites();
    }

    /**
     * Gets the scene for gruulslair
     *
     * @return the GruulsLair
     */
    @Override
    public Scene getScene() {
        // Link our globals to super class user inputs since no inheritence in AnimationTimer
        input = super.getInput();
        menu_input = super.getMenu_input();
        this.game = WizardOfTreldan.getGame();

        Group root = new Group();
        Scene theScene = new Scene(root);
        theScene.setFill(Color.rgb(83, 83, 83));
        //set the styleScheet
        theScene.getStylesheets().add("TextAreaStyle.css");

        Canvas canvas_background = new Canvas(1024, 512);
        root.getChildren().add(canvas_background);

        Canvas enemy_canvas = new Canvas(1024, 512);
        root.getChildren().add(enemy_canvas);

        //add a canvas only for the player
        Canvas player_canvas = new Canvas(1024, 512);
        //add the canvas to the group
        root.getChildren().add(player_canvas);

        //minimap ontop of everything else
        MiniMap miniMap = new MiniMap(game);
        //get the group of canvases from minimap object
        Group miniMapGroup = miniMap.getMinimap();
        //update the minimap correctly with the player canvas size
        miniMap.updateMiniMap(1024.0, 512.0);
        //add the group to the root group
        root.getChildren().add(miniMapGroup);

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
        player.setPosition(500, 400);

        //esc menu
        GameMenu escmenu = new GameMenu();
        AnchorPane gameMenu = escmenu.getMenu();

        //set the keylisteners to the scene.
        theScene.setOnKeyReleased(getOnKeyRelease(player));
        theScene.setOnKeyPressed(getOnKeyPress());

        //create GraphicsContext from our player_canvas
        GraphicsContext moveable_gc = player_canvas.getGraphicsContext2D();
        //create GraphicsContext from our canvas_background
        GraphicsContext cave_background = canvas_background.getGraphicsContext2D();
        // create GraphicsContext for our monsters in gruulsLair
        GraphicsContext enemiesGC = enemy_canvas.getGraphicsContext2D();

        //get all the sprites used in the cave
        List<Sprite> enemy_sprites = gruulsLair_sprites.getGruulsLair_enemy_sprites();
        List<Sprite> sprites_background = gruulsLair_sprites.getGruulsLair_background_sprites();

        //render all the sprites
        if (game.checkExisting("gruul")) {
            enemy_sprites.get(0).render(enemiesGC);
        }

        for (Sprite sprite : sprites_background) {
            sprite.render(cave_background);
        }

        //set our world boundaries
        Rectangle2D worldBoundRight = new Rectangle2D(628, 0, 1, 512);
        Rectangle2D worldBoundLeft = new Rectangle2D(345, 0, 1, 512);
        Rectangle2D worldBoundBottom = new Rectangle2D(0, 520, 1024, 1);
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
                    } else if (game.checkExisting("gruul") && player.intersects_left(enemy_sprites.get(0))) {
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
                    } else if (game.checkExisting("gruul") && player.intersects_right(enemy_sprites.get(0))) {
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
                    } else if (game.checkExisting("gruul") && player.intersects_top(enemy_sprites.get(0))) {
                        player.setVelocity(0, 0);

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
                    } else if (game.checkExisting("gruul") && player.intersects_bottom(enemy_sprites.get(0))) {
                        player.setVelocity(0, 0);

                    } else if (player.intersects_top(sprites_background.get(4))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        //go to house1
                        game.goTo(new Command(CommandWord.GO, "cave"));
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
                        player.setVelocity(0, 100);
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_DOWN);
                }

                // </editor-fold>
                //check if the user wants to interact
                if (menu_input.contains("E")) {
                    if (game.checkExisting("gruul") && player.intersect(enemy_sprites.get(0))) {
                        for (String s : game.goTo(new Command(CommandWord.GO, "gruul"))) {
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
                if (game.checkExisting("gruul")) {
                    enemy_sprites.get(0).render(enemiesGC);
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
                    case 8:
                        WizardOfTreldan.setCaveScene();
                        break;
                }
            }
        }.start();
        return theScene;
    }
}
