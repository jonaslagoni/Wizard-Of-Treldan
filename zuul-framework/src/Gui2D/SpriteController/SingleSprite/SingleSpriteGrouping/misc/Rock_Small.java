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
public class Rock_Small extends Abstract_sprite {

    /**
     * Sets the Rock_Small sprite
     */
    @Override
    public void setSprite() {
        super.getSprite().setSpritePosX(37);
        super.getSprite().setSpritePosY(528);
        super.getSprite().setSprite_width(15);
        super.getSprite().setSprite_height(11);
        super.getSprite().setWidth(15);
        super.getSprite().setHeight(11);
    }
}
