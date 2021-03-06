/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.SpriteController.SingleSprite.PlayerSprite;
import Gui2D.SpriteController.SpriteController;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Lagoni
 */
public abstract class PlayableMaps implements Map {

    // Our PlayerSprite 
    private PlayerSprite player;

    // Arraylist for player movement
    private ArrayList<String> input;

    // ArrayList for menu key strokes.
    private ArrayList<String> menu_input;

    /**
     * A playerable map which have a player
     */
    public PlayableMaps() {
        player = new PlayerSprite();
        player.setImage(SpriteController.getPLAYER_SPRITESHEET());
        player.setPosition(0, 0);
        player.setHeight(64);
        player.setWidth(64);

        input = new ArrayList();
        menu_input = new ArrayList();
    }

    /**
     * @param player PlayerSprite
     * @return EventHandler for keyevents on release
     */
    public EventHandler<KeyEvent> getOnKeyRelease(PlayerSprite player) {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                String code = e.getCode().toString();
                getInput().remove(code);
                if (code.equals("LEFT") || code.equals("RIGHT")) {
                    player.setVelocity(0, player.getVelocityY());
                } else if (code.equals("UP") || code.equals("DOWN")) {
                    player.setVelocity(player.getVelocityX(), 0);
                }
            }
        };
    }

    /**
     * @return EventHandler for KeyEvents on press
     */
    public EventHandler<KeyEvent> getOnKeyPress() {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                String code = e.getCode().toString();
                // only add once... prevent duplicates
                if (code.equals("I") || code.equals("E") || code.equals("ESCAPE")) {
                    if (!menu_input.contains(code)) {
                        getMenu_input().add(code);
                    } else {
                        getMenu_input().remove(code);
                    }
                }

                if (!input.contains(code)) {
                    getInput().add(code);
                }

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
     * @return the player
     */
    public PlayerSprite getPlayer() {
        return player;
    }

}
