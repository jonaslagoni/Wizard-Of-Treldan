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
public class Alchemy_Table extends Abstract_sprite {

    /**
     * Sets the Candle sprite
     */
    @Override
    public void setSprite() {

        super.getSprite().setSpritePosX(580);
        super.getSprite().setSpritePosY(319);
        super.getSprite().setSprite_width(64);
        super.getSprite().setSprite_height(60);
        super.getSprite().setWidth(64);
        super.getSprite().setHeight(60);
    }
}
