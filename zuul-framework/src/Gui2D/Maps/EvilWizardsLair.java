/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.SpriteController.Maps.EvilWizardsLair_sprites;
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
public class EvilWizardsLair extends Map{
    
    // Arraylist for player movement
    private ArrayList<String> input;
    
    // ArrayList for menu key strokes.
    private ArrayList<String> menu_input;
    
    private EvilWizardsLair_sprites evilWizardsLair_sprites;
    /**
     * Constructor for EvilWizardsLair
     * @param world 
     */
    private TWoT game;
    
    public EvilWizardsLair(SpriteController world){
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
        
        evilWizardsLair_sprites = new EvilWizardsLair_sprites(world);
        evilWizardsLair_sprites.setEvilWizardsLair_background_SingleSprites();
    }
    
    @Override
    public Scene getScene(){
        //initialize game
        this.game = WizardOfTreldan.getGame();
        //new group
        Group root = new Group();
        //set new scene
        Scene theScene = new Scene( root );
        //create new canvas
        Canvas background = new Canvas(1024, 512);
        //add canvas to root
        root.getChildren().add(background);

        
        Canvas player_canvas = new Canvas(1024, 512);
        
        root.getChildren().add(player_canvas);
        
        theScene.getStylesheets().add("TextAreaStyle.css");
        GraphicsContext moveable_gc = player_canvas.getGraphicsContext2D();
        GraphicsContext backgroundContext = background.getGraphicsContext2D();
        
        
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
        PlayerInventory playerinventory = new PlayerInventory(game,infobox);
        AnchorPane menu = playerinventory.getMenu();
        
        
        //get our player from super class since no inheritence in AnimationTimer
        PlayerSprite player = super.getPlayer();
        player.setPosition(526,400 );

        //set the keylisteners to the scene.
        theScene.setOnKeyReleased(getOnKeyRelease(player));
        theScene.setOnKeyPressed(getOnKeyPress());
        
        //world boundaries
        Rectangle2D worldBoundTop = new Rectangle2D(0, 40, 1024, 1);
        Rectangle2D worldBoundBottom = new Rectangle2D(0, 500, 1024, 1);
        Rectangle2D worldBoundLeft = new Rectangle2D(35,0,1,512);
        Rectangle2D worldBoundRight = new Rectangle2D(965,0,1,512);
        
        Rectangle2D worldBoundLeft2 = new Rectangle2D(0,160,440,512);    
        Rectangle2D worldBoundRight2 = new Rectangle2D(580,160,500,512);    
        
        
         //spritelist of background sprites
        List<Sprite> spriteList = evilWizardsLair_sprites.getSpriteList();
        //spritelist of foreground sprites
        List<Sprite > spriteList_foreground = evilWizardsLair_sprites.getSpriteList_Foreground();
        
        for (Sprite background_sprites : spriteList) {
            background_sprites.render(backgroundContext);
        }
        
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
                    if (player.intersects_left(worldBoundLeft) ||
                        player.intersects_left(worldBoundLeft2)){
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        //check if the player walks into a sprite
                    }
                    else if(player.intersects_left(spriteList_foreground.get(4)) ||
                              player.intersects_left(spriteList_foreground.get(5)) ||
                              player.intersects_left(spriteList_foreground.get(6))
                            ){
                        player.setVelocity(0,0);
                    }
                   
                    else {
                        player.setVelocity(-100, 0);
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_LEFT);
                }
                
                //check if the user wants to walk right.
                if (input.contains("RIGHT")) {
                    //check if the user walks into a world boundary
                    if (player.intersects_right(worldBoundRight) ||
                        player.intersects_right(worldBoundRight2))
                            {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    //check if the player walks into a sprite
                    }
                    else if(player.intersects_right(spriteList_foreground.get(4)) ||
                              player.intersects_right(spriteList_foreground.get(5)) ||
                              player.intersects_right(spriteList_foreground.get(6))
                            ){
                        player.setVelocity(0,0);
                    }
                    
                    else {
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
                    }
                    else if(player.intersects_top(spriteList_foreground.get(4)) ||
                              player.intersects_top(spriteList_foreground.get(5)) ||
                              player.intersects_top(spriteList_foreground.get(6))
                            ){
                        player.setVelocity(0,0);
                    }
                    
                    else {
                        player.setVelocity(0, -100);
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_UP);
                }
                
                //check if the user wants to walk down.
                if (input.contains("DOWN")) {
                    //check if the user walks into a world boundary
                    if (player.intersects_bottom(worldBoundBottom)||
                        player.intersects_bottom(worldBoundRight2)||
                        player.intersects_bottom(worldBoundLeft2)
                            
                            ) {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        
                        //check if the player walks into a sprite from the spriteList_foreground array
                    }else if(player.intersects_bottom(spriteList_foreground.get(4)) ||
                              player.intersects_bottom(spriteList_foreground.get(5)) ||
                              player.intersects_bottom(spriteList_foreground.get(6))
                            ){
                        player.setVelocity(0,0);
                    }
                   
                    else {
                        player.setVelocity(0, 100);
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_DOWN);
                }
                
                boolean minion1Defeated = false;
                boolean minion2Defeated = false;
                
                if (menu_input.contains("E")) {
                    if(game.checkExisting("minion1")){
                        if(player.intersect(spriteList_foreground.get(4))){
                            for(String s : game.goTo(new Command(CommandWord.GO, "minion1"))) {
                                infobox.appendText("\n" + s + "\n");
                            }
                            minion1Defeated = true;
                            playerinventory.update(game);
                        }
                    }
                    if(game.checkExisting("minion2")){
                        if(player.intersect(spriteList_foreground.get(5))){
                            for(String s : game.goTo(new Command(CommandWord.GO, "minion2"))) {
                                infobox.appendText("\n" + s + "\n");
                            }
                            minion2Defeated = true;
                            playerinventory.update(game);
                        }
                    }
                    
                    if(game.checkExisting("wizard") && minion2Defeated && minion1Defeated ){
                        if(player.intersect(spriteList_foreground.get(6))){
                            for(String s : game.goTo(new Command(CommandWord.GO, "wizard"))) {
                                infobox.appendText("\n" + s + "\n");
                            }
                            playerinventory.update(game);
                        }
                    }else{
                        infobox.appendText("\n"+ "Foolish mortal! you need to get rid of my minions first in order to defeat me!");
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
                    
    
        }.start();
        
        
        for (Sprite foreground_sprites : spriteList_foreground) {
            foreground_sprites.render(backgroundContext);
        
        }
        
        
        
        return theScene;
    }
}
