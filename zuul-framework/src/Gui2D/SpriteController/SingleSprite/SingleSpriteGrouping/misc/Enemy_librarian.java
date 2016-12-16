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
public class Enemy_librarian extends Abstract_sprite {

    /**
     * Sets the Candle sprite
     */
    @Override
    public void setSprite() {

        super.getSprite().setSpritePosX(571);
        super.getSprite().setSpritePosY(577);
        super.getSprite().setSprite_width(25);
        super.getSprite().setSprite_height(48);
        super.getSprite().setWidth(25);
        super.getSprite().setHeight(48);
    }
}
