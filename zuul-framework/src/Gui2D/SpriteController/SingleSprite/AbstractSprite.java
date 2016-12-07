/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.SingleSprite;

import Gui2D.SpriteController.Sprite;

/**
 *
 * @author Lagoni
 */
public abstract class AbstractSprite extends Sprite{
    
    
    /*
     * The sprite width and height this is not the width and height of the image displayed.
     * This is the single sprite width and height in the sprite sheet
     */
    private double sprite_width = 64;
    private double sprite_height = 64;    

    /**
     * @param sprite_width the sprite_width to set
     */
    public void setSprite_width(double sprite_width) {
        this.sprite_width = sprite_width;
    }

    /**
     * @param sprite_height the sprite_height to set
     */
    public void setSprite_height(double sprite_height) {
        this.sprite_height = sprite_height;
    }

    /**
     * @return the sprite_width
     */
    public double getSprite_width() {
        return sprite_width;
    }

    /**
     * @return the sprite_height
     */
    public double getSprite_height() {
        return sprite_height;
    }
    
    /**
     * Set the spriteSize, both width and height
     * @param sprite_width
     * @param sprite_height 
     */
    public void setSpriteSize(double sprite_width, double sprite_height){
        this.setSprite_height(sprite_height);
        this.setSprite_width(sprite_width);
        updateBoundary();
    }
}
