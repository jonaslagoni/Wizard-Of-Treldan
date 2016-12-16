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
public class Enemy_abbaration extends Abstract_sprite {

    /**
     * Sets the Candle sprite
     */
    @Override
    public void setSprite() {
        super.getSprite().setSpritePosX(412);
        super.getSprite().setSpritePosY(446);
        super.getSprite().setSprite_width(46);
        super.getSprite().setSprite_height(87);
        super.getSprite().setWidth(46);
        super.getSprite().setHeight(87);
    }
}
