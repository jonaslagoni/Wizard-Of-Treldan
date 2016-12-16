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
public class DeadGoblin extends Abstract_sprite {

    /**
     * Sets the Candle sprite
     */
    @Override
    public void setSprite() {
        super.getSprite().setSpritePosX(1175);
        super.getSprite().setSpritePosY(342);
        super.getSprite().setSprite_width(48);
        super.getSprite().setSprite_height(45);
        super.getSprite().setWidth(48);
        super.getSprite().setHeight(45);
    }
}
