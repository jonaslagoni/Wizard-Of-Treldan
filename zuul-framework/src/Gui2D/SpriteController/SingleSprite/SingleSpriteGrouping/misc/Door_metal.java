/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping.misc;

import Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping.Abstract_sprite;
import Gui2D.SpriteController.SpriteGenerator;

/**
 *
 * @author jonas
 */
public class Door_metal extends Abstract_sprite {    
    /**
     * Sets the metal door sprite
     */
    public void setSprite(){
        super.getSpriteVariable().setSpritePosX(711);
        super.getSpriteVariable().setSpritePosY(8);
        super.getSpriteVariable().setSprite_width(32);
        super.getSpriteVariable().setSprite_height(48);
        super.getSpriteVariable().setWidth(32);
        super.getSpriteVariable().setHeight(48);
    }
}
