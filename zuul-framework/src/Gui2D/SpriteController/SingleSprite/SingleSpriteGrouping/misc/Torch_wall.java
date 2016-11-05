/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping.misc;

import Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping.Abstract_sprite;

/**
 *
 * @author jonas
 */
public class Torch_wall extends Abstract_sprite {
    /**
     * Sets the torch wall sprite
     */
    public void setSprite(){
        super.getSpriteVariable().setSpritePosX(846);
        super.getSpriteVariable().setSpritePosY(8);
        super.getSpriteVariable().setSprite_width(16);
        super.getSpriteVariable().setSprite_height(56);
        super.getSpriteVariable().setWidth(16);
        super.getSpriteVariable().setHeight(56);
    }
}
