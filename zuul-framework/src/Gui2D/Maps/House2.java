/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.SpriteController.Maps.House2_sprites;
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

public class House2 extends Map{
    
    // Arraylist for player movement
    private ArrayList<String> input;
    
    // ArrayList for menu key strokes.
    private ArrayList<String> menu_input;
    
    
    private TWoT game;
    private House2_sprites house_sprites;
    /**
     * Constructor for Cellar
     * @param world 
     */
    public House2(SpriteController world){
        //init our super constructor
        super();
        
        //set the world constructor
        input = super.getInput();
        menu_input = super.getMenu_input();
        
        house_sprites = new House2_sprites(world);
        house_sprites.setHouse2_background_SingleSprites();
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
        
        Canvas canvas_background = new Canvas(350, 250);
        //relocate the canvas so its centered.
        canvas_background.relocate(337, 75);
        root.getChildren().add(canvas_background);
        
        
        //add a canvas only for the stranger
        Canvas stranger_canvas = new Canvas(350, 250);
        //relocate the canvas
        stranger_canvas.relocate(337, 75);
        //add the canvas to the group
        root.getChildren().add(stranger_canvas);
        
        //add a canvas only for the player
        Canvas player_canvas = new Canvas(350, 250);
        //relocate the canvas
        player_canvas.relocate(337, 75);
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
        infobox.appendText(welcome.get(3) + "\n");

        //Inventory Menu
        PlayerInventory playerinventory = new PlayerInventory(game, infobox);
        AnchorPane menu = playerinventory.getMenu();
        
        //escape menu
        GameMenu escmenu = new GameMenu();
        AnchorPane gameMenu = escmenu.getMenu();


        //get our player from super class since no inheritence in AnimationTimer
        PlayerSprite player = super.getPlayer();
        player.setPosition(170, 50);

        //set the keylisteners to the scene.
        theScene.setOnKeyReleased(getOnKeyRelease(player));
        theScene.setOnKeyPressed(getOnKeyPress());
        
        
        //add graphicscontext to each canvas
        GraphicsContext background_gc = canvas_background.getGraphicsContext2D();
        //create GraphicsContext from our player_canvas
        GraphicsContext moveable_gc = player_canvas.getGraphicsContext2D();
        //create GraphicsContext from our player_canvas
        GraphicsContext stranger_gc = stranger_canvas.getGraphicsContext2D();
                
        //generate all the background sprites
        List<Sprite> sprites_still = house_sprites.getHouse2();
        for(Sprite sprite : sprites_still){
            sprite.render(background_gc);
        }
            
        //stranger sprite
        Sprite stranger_sprite = house_sprites.getStranger_sprite();
        if(game.checkExisting("stranger")){
            stranger_sprite.render(stranger_gc);
        }
        
        //set our world boundaries
        Rectangle2D worldBoundRight = new Rectangle2D(350, 0, 1, 300);
        Rectangle2D worldBoundLeft = new Rectangle2D(0, 0, 1, 300);
        Rectangle2D worldBoundBottom = new Rectangle2D(0, 220, 400, 1);
        Rectangle2D worldBoundTop = new Rectangle2D(0, 0, 400, 1);
             
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
                    //no collission continue
                    }else if (player.intersects_left(sprites_still.get(1))
                            || player.intersects_left(sprites_still.get(4))
                            || player.intersects_left(sprites_still.get(5))
                            || player.intersects_left(sprites_still.get(6))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    }else if(game.checkExisting("stranger") && player.intersects_left(stranger_sprite)){
                        player.setVelocity(0, 0);
                    }else{
                        player.setVelocity(-100,0);
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
                    }else if (player.intersects_right(sprites_still.get(1))
                            || player.intersects_right(sprites_still.get(4))
                            || player.intersects_right(sprites_still.get(5))
                            || player.intersects_right(sprites_still.get(6))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    }else if(game.checkExisting("stranger") && player.intersects_right(stranger_sprite)){
                        player.setVelocity(0, 0);
                    }else{
                        player.setVelocity(100,0);
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
                    }else if (player.intersects_top(sprites_still.get(1))
                            || player.intersects_top(sprites_still.get(4))
                            || player.intersects_top(sprites_still.get(5))
                            || player.intersects_top(sprites_still.get(6))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    }else if(player.intersects_top(sprites_still.get(3))){
                        //Reset the velocity
                        player.setVelocity(0, 0);
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
                    }else if(game.checkExisting("stranger") && player.intersects_top(stranger_sprite)){
                        player.setVelocity(0, 0);
                    }else{
                        player.setVelocity(0,-100);
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
                    }else if (player.intersects_bottom(sprites_still.get(3))
                            || player.intersects_bottom(sprites_still.get(4))
                            || player.intersects_bottom(sprites_still.get(5))
                            || player.intersects_bottom(sprites_still.get(6))) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    }else if(game.checkExisting("stranger") && player.intersects_bottom(stranger_sprite)){
                        player.setVelocity(0, 0);
                    }else {
                        player.setVelocity(0, 100);
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_DOWN);
                }

                // </editor-fold>
                
                if (menu_input.contains("E")) {
                    if(player.intersect(sprites_still.get(6))){
                        for(String s : game.goTo(new Command(CommandWord.GO, "wardrobe"))) {
                            infobox.appendText("\n" + s + "\n");
                        }
                        playerinventory.update(game);
                    }
                    
                    if(player.intersect(sprites_still.get(5))){
                        for(String s : game.goTo(new Command(CommandWord.GO, "table"))) {
                            infobox.appendText("\n" + s + "\n");
                        }
                        playerinventory.update(game);
                    }
                    
                    if(player.intersect(sprites_still.get(4))){
                        for(String s : game.goTo(new Command(CommandWord.GO, "bed"))) {
                            infobox.appendText("\n" + s + "\n");
                        }
                        playerinventory.update(game);
                    }
                    
                    if(game.checkExisting("stranger") && player.intersect(stranger_sprite)){
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        game.goTo(new Command(CommandWord.GO, "stranger"));
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
                    
                    menu_input.remove("E");
                }
                //update the players velocity
                player.update(elapsedTime);
                //clear our player
                moveable_gc.clearRect(0, 0, 400, 300);
                //render our new player
                player.render(moveable_gc);
                
                
                stranger_gc.clearRect(0, 0, 400, 300);
                if(game.checkExisting("stranger")){
                    stranger_sprite.render(stranger_gc);
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
                    case 2:
                        WizardOfTreldan.setVillageScene();
                        break;
                    case 11:
                        WizardOfTreldan.setDungeonScene();
                        break;
                }
            }
        }.start();
        return theScene;
    }
}
