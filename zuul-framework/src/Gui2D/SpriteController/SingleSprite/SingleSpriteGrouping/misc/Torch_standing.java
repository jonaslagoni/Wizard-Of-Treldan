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
public class Torch_standing extends Abstract_sprite {

    /**
     * Sets the Torch standing sprite
     */
    @Override
    public void setSprite() {
        super.getSprite().setSpritePosX(877);
        super.getSprite().setSpritePosY(16);
        super.getSprite().setSprite_width(8);
        super.getSprite().setSprite_height(74);
        super.getSprite().setWidth(8);
        super.getSprite().setHeight(74);
    }
}
