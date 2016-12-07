/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping;

import Gui2D.SpriteController.SingleSprite.SingleSprite;
import Gui2D.SpriteController.SpriteController;

/**
 *
 * @author jonas
 */
public abstract class Abstract_sprite {
    // Our sprite
    public SingleSprite sprite;
    
    /**
     * Abstract constructor
     */
    public Abstract_sprite(){
        sprite = new SingleSprite();
        sprite.setImage(SpriteController.getSPRITESHEET());
        setSprite();
    }
    /**
     * Must have a setSprite method.
     */
    public abstract void setSprite();
    
    /**
     * Get the sprite variable
     * @return 
     */
    public SingleSprite getSprite(){
        return sprite;
    }
    
}
