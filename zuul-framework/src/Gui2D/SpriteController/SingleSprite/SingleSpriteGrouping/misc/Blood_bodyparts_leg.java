/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping.misc;

import Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping.Abstract_sprite;

/**
 *
 * @author Mads
 */
public class Blood_bodyparts_leg extends Abstract_sprite{
    /**
     * Sets the Candle sprite
     */
    @Override
    public void setSprite(){

        super.getSprite().setSpritePosX(300);
        super.getSprite().setSpritePosY(480);
        super.getSprite().setSprite_width(14);
        super.getSprite().setSprite_height(19);
        super.getSprite().setWidth(14);
        super.getSprite().setHeight(19);
    }
}
