/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.SpriteController.Maps.EvilWizardsLair_sprites;
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
/**
 *
 * @author Mads
 */
public class EvilWizardsLair extends PlayableMaps{
    // Arraylist for player movement
    private ArrayList<String> input;
    // ArrayList for menu key strokes.
    private ArrayList<String> menu_input;
    private EvilWizardsLair_sprites evilWizardsLair_sprites;
    private TWoT game;
    
    /**
     * Constructor for EvilWizardsLair
     * @param world 
     */
    public EvilWizardsLair(SpriteController world){
        //init our super constructor
        super();
        
        evilWizardsLair_sprites = new EvilWizardsLair_sprites(world);
        evilWizardsLair_sprites.setEvilWizardsLair_background_SingleSprites();
    }
    
    /**
     * gets the EvilWizardsLair scene
     * @return 
     */
    @Override
    public Scene getScene(){
        
        // Link our globals to super class user inputs since no inheritence in AnimationTimer
        input = super.getInput();
        menu_input = super.getMenu_input();
        
        //initialize game
        this.game = WizardOfTreldan.getGame();
        //new group
        Group root = new Group();
        //set new scene
        Scene theScene = new Scene( root );
        
        
        // Needs to be rendered in the background (has to not be visible)
        // add canvas for boundriesFIX
        Canvas boundriesFix_canvas = new Canvas(1024,512);
        // add canvas to group
        root.getChildren().add(boundriesFix_canvas);
        
        //add a canvas only for the player lava
        Canvas lava_canvas = new Canvas(1024, 512);
        //add the canvas to the group
        root.getChildren().add(lava_canvas);
        
        //add the canvas for backgroundsprites
        Canvas background = new Canvas(1024, 512);
        theScene.getStylesheets().add("TextAreaStyle.css");
        //add the canvas to the group
        root.getChildren().add( background );
        
        //add a canvas only for the player
        Canvas monster_canvas = new Canvas(1024, 512);
        //add the canvas to the group
        root.getChildren().add(monster_canvas);
        
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
        root.getChildren().add( miniMapGroup );
        
        GraphicsContext boundriesFIX_gc = boundriesFix_canvas.getGraphicsContext2D();
        GraphicsContext moveable_gc = player_canvas.getGraphicsContext2D();
        GraphicsContext background_gc = background.getGraphicsContext2D();
        GraphicsContext monster_gc = monster_canvas.getGraphicsContext2D();
        GraphicsContext lava_gc = lava_canvas.getGraphicsContext2D();
        
         //escape menu start
        GameMenu escmenu = new GameMenu();
        AnchorPane gameMenu = escmenu.getMenu();
        //escape menu stop
        
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
        theScene.getStylesheets().add("TextAreaStyle.css");
        
        //get some of the games welcome message and add to the infobox
        HashMap<Integer, String> welcome = game.getWelcomeMessages();
        infobox.appendText(welcome.get(3) + "\n");
        
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
        
        // spritelist of boundries fix
        List<Sprite> spriteList_boundriesFIX = evilWizardsLair_sprites.getSpriteList_BoundriesFIX();
         //spritelist of background sprites
        List<Sprite> spriteList = evilWizardsLair_sprites.getSpriteList();
         //spritelist of lava sprites
        List<Sprite> spriteList_lava = evilWizardsLair_sprites.getSpriteList_lava();
        //spritelist of foreground sprites
        List<Sprite > spriteList_foreground = evilWizardsLair_sprites.getSpriteList_monsters();
        
        // render boundries (shouldn't be seen)
        for (Sprite boundries_sprites : spriteList_boundriesFIX) {
            boundries_sprites.render(boundriesFIX_gc);
        }
        
        // render everything in spriteList
        for (Sprite background_sprites : spriteList) {
            background_sprites.render(background_gc);
        }
        //render the lava once
        spriteList_lava.get(0).render(lava_gc);
        //render monsters
        if(game.checkExisting("wizard")){
            spriteList_foreground.get(0).render(monster_gc);
        }
        if(game.checkExisting("minion1")){
            spriteList_foreground.get(1).render(monster_gc);
        }
        if(game.checkExisting("minion2")){
            spriteList_foreground.get(2).render(monster_gc);
        }
        
        new AnimationTimer() {
            //set the current time we started.
            private long lastNanoTime = System.nanoTime();
            private int lavaCounter = 0;
            //what to do each cycle
            @Override
            public void handle(long currentNanoTime) {
                if(!game.checkExisting("wizard") && game.getCurrentRoomId() == 13){
                    //write to highscore
                    game.writeHighScore();
                    //remove all the inputs
                    input.removeAll(input);
                    //stop this AnimationTimer
                    this.stop();
                    //clear the textarea
                    infobox.clear();
                    //remove the input
                    menu_input.remove("E");
                    //set the menu as a scene instead.
                    WizardOfTreldan.setFinishScene();
                        
                }
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
                    if (player.intersects_left(worldBoundLeft)){
                        //Reset the velocity
                        player.setVelocity(0, 0);
                        //check if the player walks into a sprite
                    }else if(game.checkExisting("wizard") && player.intersects_left(spriteList_foreground.get(0))){
                        player.setVelocity(0,0);
                    }else if(game.checkExisting("minion1") && player.intersects_left(spriteList_foreground.get(1))){
                        player.setVelocity(0,0);
                    }else if(game.checkExisting("minion2") && player.intersects_left(spriteList_foreground.get(2))){
                        player.setVelocity(0,0);
                    }else if (player.intersects_left(spriteList_boundriesFIX.get(3)) ||
                            player.intersects_left(spriteList_boundriesFIX.get(0))) {
                        player.setVelocity(0,0);
                    }else {
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
                    if (player.intersects_right(worldBoundRight))
                            {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    //check if the player walks into a sprite
                    }else if(game.checkExisting("wizard") && player.intersects_right(spriteList_foreground.get(0))){
                        player.setVelocity(0,0);
                    }else if(game.checkExisting("minion1") && player.intersects_right(spriteList_foreground.get(1))){
                        player.setVelocity(0,0);
                    }else if(game.checkExisting("minion2") && player.intersects_right(spriteList_foreground.get(2))){
                        player.setVelocity(0,0);
                    }else if (player.intersects_right(spriteList_boundriesFIX.get(2)) ||
                            player.intersects_right(spriteList_boundriesFIX.get(1))) {
                        player.setVelocity(0,0);
                    }else {
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
                    }else if(game.checkExisting("wizard") && player.intersects_top(spriteList_foreground.get(0))){
                        player.setVelocity(0,0);
                    }else if(game.checkExisting("minion1") && player.intersects_top(spriteList_foreground.get(1))){
                        player.setVelocity(0,0);
                    }else if(game.checkExisting("minion2") && player.intersects_top(spriteList_foreground.get(2))){
                        player.setVelocity(0,0);
                    }else {
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
                    if (player.intersects_bottom(worldBoundBottom))
                            {
                        //Reset the velocity
                        player.setVelocity(0, 0);
                    }else if(game.checkExisting("wizard") && player.intersects_bottom(spriteList_foreground.get(0))){
                        player.setVelocity(0,0);
                    }else if(game.checkExisting("minion1") && player.intersects_bottom(spriteList_foreground.get(1))){
                        player.setVelocity(0,0);
                    }else if(game.checkExisting("minion2") && player.intersects_bottom(spriteList_foreground.get(2))){
                        player.setVelocity(0,0);
                    }else if (player.intersects_bottom(spriteList_boundriesFIX.get(0)) ||
                            player.intersects_bottom(spriteList_boundriesFIX.get(1))) {
                        player.setVelocity(0,0);
                    }else {
                        player.setVelocity(0, 100);
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_DOWN);
                }
                
                // </editor-fold>
                
                //check if the user wants to interact
                if (menu_input.contains("E")) {
                    if(game.checkExisting("minion1") && player.intersect(spriteList_foreground.get(1))){
                        for(String s : game.goTo(new Command(CommandWord.GO, "minion1"))) {
                            infobox.appendText("\n" + s + "\n");
                        }
                        playerinventory.update(game);
                    }
                    if(game.checkExisting("minion2") && player.intersect(spriteList_foreground.get(2))){
                        for(String s : game.goTo(new Command(CommandWord.GO, "minion2"))) {
                            infobox.appendText("\n" + s + "\n");
                        }
                        playerinventory.update(game);
                    }
                    if(game.checkExisting("wizard")){
                        if(player.intersect(spriteList_foreground.get(0))){
                            if(!game.checkExisting("minion2") && !game.checkExisting("minion1") ){
                                for(String s : game.goTo(new Command(CommandWord.GO, "wizard"))) {
                                    infobox.appendText("\n" + s + "\n");
                                }
                                playerinventory.update(game);
                            }else{
                                if(player.intersect(spriteList_foreground.get(0))){
                                    infobox.appendText("\n"+ "Foolish mortal! you need to get rid of my minions first in order to defeat me!");
                                }
                            }
                        }
                    }
                    
                    menu_input.remove("E");
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
                
                //render lava in each 50 frame
                if(lavaCounter != 50){
                    lavaCounter++;
                }else{
                    lava_gc.clearRect(0, 0, 1024, 512);
                    spriteList_lava.get(0).render(lava_gc);
                    lavaCounter = 0;
                }
                
                //clear monsters
                monster_gc.clearRect(0, 0, 1024, 512);
                
                //render monsters
                if(game.checkExisting("wizard")){
                    spriteList_foreground.get(0).render(monster_gc);
                }
                
                if(game.checkExisting("minion1")){
                    spriteList_foreground.get(1).render(monster_gc);
                    
                }
                if(game.checkExisting("minion2")){
                    spriteList_foreground.get(2).render(monster_gc);
                    
                }
                
                //update the player on the minimaps position
                miniMap.updateMiniMap_player(player.getPositionX(), player.getPositionY());
            }
                    
            /**
             * Sets the new scene depending on the room id.
             */  
            public void setNewScene() {
                switch (game.getCurrentRoomId()) {
                    case 14:
                        WizardOfTreldan.setFinishScene();
                        break;
                    
                }
            }
    
        }.start();
        return theScene;
    }
}
