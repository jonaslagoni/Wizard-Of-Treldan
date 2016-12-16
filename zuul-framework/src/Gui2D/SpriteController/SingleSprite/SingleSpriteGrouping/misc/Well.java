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
public class Well extends Abstract_sprite {

    /**
     * Sets the Candle sprite
     */
    @Override
    public void setSprite() {
        super.getSprite().setSpritePosX(8);
        super.getSprite().setSpritePosY(701);
        super.getSprite().setSprite_width(105);
        super.getSprite().setSprite_height(128);
        super.getSprite().setWidth(105);
        super.getSprite().setHeight(128);
    }
}
