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
    /**
     * @return the candle
     */
    public SingleSprite getCandle() {
        return new Candle().getSprite();
    }
    
    public SingleSprite getChestClosed(){
        return new Chest_closed().getSprite();
    }
    
    public SingleSprite getCaveExit(){
        return new Cave_exit().getSprite();
    }
    
    public SingleSprite getBrownMushroom(){
        return new Brown_mushroom().getSprite();
    }

    /**
     * @return the door_metal
     */
    public SingleSprite getDoor_metal() {
        return new Door_metal().getSprite();
    }

    /**
     * @return the torch_standing
     */
    public SingleSprite getTorch_standing() {
        return new Torch_standing().getSprite();
    }

    /**
     * @return the torch_wall
     */
    public SingleSprite getTorch_wall() {
        return new Torch_wall().getSprite();
    }

    /**
     * @return the hay_bed
     */
    public SingleSprite getHay_bed() {
        return new Hay_bed().getSprite();
    }
    public SingleSprite getBush() {
        return new Bush().getSprite();
    }
}

