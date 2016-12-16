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
public class Enemy_imp1 extends Abstract_sprite {

    /**
     * Sets the Candle sprite
     */
    @Override
    public void setSprite() {
        super.getSprite().setSpritePosX(1218);
        super.getSprite().setSpritePosY(416);
        super.getSprite().setSprite_width(50);
        super.getSprite().setSprite_height(50);
        super.getSprite().setWidth(50);
        super.getSprite().setHeight(50);
    }
}
