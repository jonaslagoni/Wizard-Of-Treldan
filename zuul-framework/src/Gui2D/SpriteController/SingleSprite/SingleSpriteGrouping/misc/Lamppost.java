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
public class Lamppost  extends Abstract_sprite{
    /**
     * Sets the Candle sprite
     */
    @Override
    public void setSprite(){
        super.getSprite().setSpritePosX(155);
        super.getSprite().setSpritePosY(709);
        super.getSprite().setSprite_width(20);
        super.getSprite().setSprite_height(111);
        super.getSprite().setWidth(20);
        super.getSprite().setHeight(111);
    }
}
