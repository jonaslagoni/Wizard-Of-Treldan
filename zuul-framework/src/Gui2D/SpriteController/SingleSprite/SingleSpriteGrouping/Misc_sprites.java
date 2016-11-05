/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping;

import Gui2D.SpriteController.SingleSprite.SingleSprite;
import Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping.misc.*;

/**
 *
 * @author jonas
 */
public class Misc_sprites {
    private SingleSprite candle;
    private SingleSprite door_metal;
    private SingleSprite torch_standing;
    private SingleSprite torch_wall;
    private SingleSprite hay_bed;
    
    /**
     * Creates all the misc sprites
     */
    public Misc_sprites(){
        //sets the candle sprite
        candle = new Candle().getSprite();
        
        //sets the metal door sprite
        door_metal = new Door_metal().getSprite();
        
        //sets the standing torch
        torch_standing = new Torch_standing().getSprite();
        
        //sets the wall torch
        torch_wall = new Torch_wall().getSprite();
        
        //sets the hay bed
        hay_bed = new Hay_bed().getSprite();
    }

    /**
     * @return the candle
     */
    public SingleSprite getCandle() {
        return candle;
    }

    /**
     * @return the door_metal
     */
    public SingleSprite getDoor_metal() {
        return door_metal;
    }

    /**
     * @return the torch_standing
     */
    public SingleSprite getTorch_standing() {
        return torch_standing;
    }

    /**
     * @return the torch_wall
     */
    public SingleSprite getTorch_wall() {
        return torch_wall;
    }

    /**
     * @return the hay_bed
     */
    public SingleSprite getHay_bed() {
        return hay_bed;
    }

}

