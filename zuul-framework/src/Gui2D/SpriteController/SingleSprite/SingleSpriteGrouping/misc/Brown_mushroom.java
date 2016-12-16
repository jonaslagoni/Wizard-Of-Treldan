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
public class Brown_mushroom extends Abstract_sprite {

    /**
     * Sets the Candle sprite
     */
    @Override
    public void setSprite() {
        super.getSprite().setSpritePosX(1337);
        super.getSprite().setSpritePosY(39);
        super.getSprite().setSprite_width(28);
        super.getSprite().setSprite_height(27);
        super.getSprite().setWidth(28);
        super.getSprite().setHeight(27);
    }
}
