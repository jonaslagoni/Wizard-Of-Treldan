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
public class Cave_Boulder extends Abstract_sprite {

    /**
     * Sets the Cave_Boulder sprite
     */
    @Override
    public void setSprite() {
        super.getSprite().setSpritePosX(821);
        super.getSprite().setSpritePosY(212);
        super.getSprite().setSprite_width(64);
        super.getSprite().setSprite_height(32);
        super.getSprite().setWidth(64);
        super.getSprite().setHeight(32);
    }
}
