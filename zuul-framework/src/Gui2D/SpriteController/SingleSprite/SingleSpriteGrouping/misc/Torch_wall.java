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
    @Override
    public void setSprite(){
        super.getSprite().setSpritePosX(846);
        super.getSprite().setSpritePosY(8);
        super.getSprite().setSprite_width(16);
        super.getSprite().setSprite_height(56);
        super.getSprite().setWidth(16);
        super.getSprite().setHeight(56);
    }
}
