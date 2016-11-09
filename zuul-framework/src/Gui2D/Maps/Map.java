/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.SpriteController.SingleSprite.PlayerSprite;
import Gui2D.SpriteController.SpriteController;
import TWoT_test.TWoT;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author jonas
 */
public abstract class Map {
    // Arraylist for player movement
    private ArrayList<String> input;
    
    // ArrayList for menu key strokes.
    private ArrayList<String> menu_input;
    
    // Our custom sprite generator.
    private SpriteController world;
    
    // Our PlayerSprite 
    private PlayerSprite player;
    
    public abstract javafx.scene.Scene getScene();
    
    public Map(){
        player = new PlayerSprite();
        player.setImage(SpriteController.getPLAYER_SPRITESHEET());
        player.setPosition(0, 0);
        player.setHeight(64);
        player.setWidth(64);
        
        
        //set the ArrayList'cellar_sprites from the super class Map
        input = new ArrayList();
        menu_input = new ArrayList();
    }
    /**
     * Return the player EventHandler for key release
     * @param player
     * @return 
     */
    public EventHandler<KeyEvent> getOnKeyRelease(PlayerSprite player){
        return new EventHandler<KeyEvent>(){
            public void handle(KeyEvent e){
                String code = e.getCode().toString();
                getInput().remove(code);
                if(code.equals("LEFT")){
                    player.setVelocity(0,player.getVelocityY());
                }
                if(code.equals("RIGHT")){
                    player.setVelocity(0,player.getVelocityY());
                }
                if(code.equals("UP")){
                    player.setVelocity(player.getVelocityX(),0);
                }
                if(code.equals("DOWN")){
                    player.setVelocity(player.getVelocityX(),0);
                } 
            }
        };
    }
    
    /**
     * Return the player EventHandler for key press
     * @return 
     */
    public EventHandler<KeyEvent> getOnKeyPress(){
        return new EventHandler<KeyEvent>(){
            public void handle(KeyEvent e)
            {
                String code = e.getCode().toString();
                // only add once... prevent duplicates
                
                if(code.equals("I") || code.equals("E")){
                    if(!menu_input.contains(code)){
                        getMenu_input().add(code);
                    }else{
                        getMenu_input().remove(code);
                    }
                }
            
                if ( !input.contains(code) )
                    getInput().add( code );

            }
        };
    }

    /**
     * @return the input
     */
    public ArrayList<String> getInput() {
        return input;
    }

    /**
     * @param input the input to set
     */
    public void setInput(ArrayList<String> input) {
        this.input = input;
    }

    /**
     * @return the menu_input
     */
    public ArrayList<String> getMenu_input() {
        return menu_input;
    }

    /**
     * @param menu_input the menu_input to set
     */
    public void setMenu_input(ArrayList<String> menu_input) {
        this.menu_input = menu_input;
    }

    /**
     * @return the world
     */
    public SpriteController getWorld() {
        return world;
    }

    /**
     * @param world the world to set
     */
    public void setWorld(SpriteController world) {
        this.world = world;
    }

    /**
     * @return the player
     */
    public PlayerSprite getPlayer() {
        return player;
    }
}
