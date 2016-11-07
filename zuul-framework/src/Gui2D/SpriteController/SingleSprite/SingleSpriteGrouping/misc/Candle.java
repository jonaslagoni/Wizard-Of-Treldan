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
public class Candle  extends Abstract_sprite{
    /**
     * Sets the Candle sprite
     */
    public void setSprite(){
        super.getSprite().setSpritePosX(828);
        super.getSprite().setSpritePosY(10);
        super.getSprite().setSprite_width(6);
        super.getSprite().setSprite_height(25);
        super.getSprite().setWidth(6);
        super.getSprite().setHeight(25);
    }
}
