    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;


import Gui2D.SpriteController.Maps.Clearing_sprites;
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
public class Clearing extends Map{
    
    
    // ArrayList for menu key strokes.
    private Clearing_sprites clearing_sprites;
    private ArrayList<String> input;
    
    // ArrayList for menu key strokes.
    private ArrayList<String> menu_input;
    
    private TWoT game;
    
    /**
     * Constructor for Cellar
     * @param world 
     */
    public Clearing(SpriteController world){
        //init our super constructor
        super();
            
        
        //set the ArrayList's from the super class Map
        super.setInput(new ArrayList<String>());
        super.setMenu_input(new ArrayList<String>());
        
        // Link our globals to super class user inputs since no inheritence in AnimationTimer
        input = super.getInput();
        menu_input = super.getMenu_input();
        
        //set the rooms sprites
        clearing_sprites = new Clearing_sprites(world);
        clearing_sprites.setClearing_background_sprites();

    }
    
    public Scene getScene(){
        this.game = WizardOfTreldan.getGame();
        Group root = new Group();
        Scene theScene = new Scene( root ); 
        theScene.setFill(Color.rgb(83, 83, 83));
        Canvas canvas_background = new Canvas(730,370);
        canvas_background.relocate(126,66);
        
        //background canvas
        root.getChildren().add(canvas_background);
        //add a canvas only for the player
        Canvas player_canvas = new Canvas(1024, 512);
        //add canvas to group
        root.getChildren().add(player_canvas);
        
        //set canvas of our items
        Canvas clearing_interact = new Canvas(730, 370);
        //relocate the canvas
        clearing_interact.relocate(126, 66);
        //add the canvas to the group
        root.getChildren().add(clearing_interact);
        
        
        
        theScene.getStylesheets().add("TextAreaStyle.css");
        
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
        
        

        PlayerInventory playerinventory = new PlayerInventory(game, infobox);
        AnchorPane menu = playerinventory.getMenu();

        
        //menu testing done
        
        //get our player from super class since no inheritence in AnimationTimer
        PlayerSprite player = super.getPlayer();
        player.setPosition(322,125 );

        //set the keylisteners to the scene.
        theScene.setOnKeyReleased(getOnKeyRelease(player));
        theScene.setOnKeyPressed(getOnKeyPress());
        
        
        GraphicsContext moveable_gc = player_canvas.getGraphicsContext2D();
        GraphicsContext interact_gc = clearing_interact.getGraphicsContext2D();
        //create GraphicsContext from our player_canvas
        GraphicsContext background_gc = canvas_background.getGraphicsContext2D();
        
        
       
        //world boundaries
        Rectangle2D worldBoundTop = new Rectangle2D(0, 78, 1024, 1);
        Rectangle2D worldBoundBottom = new Rectangle2D(0, 350, 1024, 1);
        Rectangle2D worldBoundLeft = new Rectangle2D(150, 0, 1, 512);
        Rectangle2D worldBoundRight = new Rectangle2D(800, 0, 1, 512);
        
        //get all the sprites of monsters
        List<Sprite> sprites_interact = clearing_sprites.getClearing_interact();
        
            if(game.checkExisting("unicorn")){
                sprites_interact.get(0).render(interact_gc);
            }

            if(game.checkExisting("tree")){
                sprites_interact.get(1).render(interact_gc);
            }
        List<Sprite> sprites_still = clearing_sprites.getClearing_background_sprites();
        for(Sprite sprite : sprites_still){
            sprite.render(background_gc);
        }
        
        
        
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
                   
                
                        //check if the player walks into a sprite
                    }else if(player.intersects_left(sprites_still.get(8))  ||
                             player.intersects_left(sprites_still.get(9))  ||
                             player.intersects_left(sprites_still.get(10)) ||
                             player.intersects_left(sprites_still.get(11)) 
                             ){
                         player.setVelocity(0, 0);
                    }else if(game.checkExisting("unicorn")){
                        if(player.intersects_left(sprites_interact.get(0))){
                            player.setVelocity(0, 0);
                        }else{
                            player.setVelocity(-100,0);
                        }
                    }else{
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
                    }else if(player.intersects_right(sprites_still.get(8))  ||
                             player.intersects_right(sprites_still.get(9))  ||
                             player.intersects_right(sprites_still.get(10)) ||
                             player.intersects_right(sprites_still.get(11)) 
                             ){
                         player.setVelocity(0, 0);
                    }else if(game.checkExisting("unicorn")){
                        if(player.intersects_left(sprites_interact.get(0))){
                            player.setVelocity(0, 0);
                        }else{
                            player.setVelocity(-100,0);
                        }
                    }else{
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
                            //check if the player walks into the exit
                    }else if(player.intersects_top(sprites_still.get(7))){ 
                        if(!hasPrinted){
                            int oldId = game.getCurrentRoomId();
                            for(String s: game.goTo(new Command(CommandWord.GO, "exit"))){
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
                        
                        //check if the player walks into a sprite
                    }else if(player.intersects_top(sprites_still.get(8))  ||
                             player.intersects_top(sprites_still.get(9))  ||
                             player.intersects_top(sprites_still.get(10)) ||
                             player.intersects_top(sprites_still.get(11)) 
                     
                             ){
                         player.setVelocity(0, 0);
                    }else if(game.checkExisting("unicorn")){
                        if(player.intersects_left(sprites_interact.get(0))){
                            player.setVelocity(0, 0);
                        }else{
                            player.setVelocity(-100,0);
                        }
                    }else {
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
                    }else if(player.intersects_bottom(sprites_still.get(8))  ||
                             player.intersects_bottom(sprites_still.get(9))  ||
                             player.intersects_bottom(sprites_still.get(10)) ||
                             player.intersects_bottom(sprites_still.get(11)) 
                             ){
                         player.setVelocity(0, 0);
                         
                    }else if(game.checkExisting("unicorn")){
                        if(player.intersects_left(sprites_interact.get(0))){
                            player.setVelocity(0, 0);
                        }else{
                            player.setVelocity(-100,0);
                        }
                    }else{
                        player.setVelocity(0, 100);
                    }
                    //set the direction the player walks
                    player.setDirection(PlayerSprite.Direction.WALK_DOWN);
                }
            
                //interact with the world around the player
                if (menu_input.contains("E")) {
                    if (player.intersect(sprites_interact.get(0))) {
                        for (String s : game.goTo(new Command(CommandWord.GO, "unicorn"))) {
                            infobox.appendText("\n" + s + "\n");
                        }
                    
                  
                    }
                    if (player.intersect(sprites_interact.get(1))) {
                        for (String s : game.goTo(new Command(CommandWord.GO, "tree"))) {
                            infobox.appendText("\n" + s + "\n");
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
                    case 4:
                        WizardOfTreldan.setForestScene();
                        break;
                }
            }
        }.start();

        return theScene;
    }
}
