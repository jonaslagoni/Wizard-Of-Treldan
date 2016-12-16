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
public class Red_mushroom extends Abstract_sprite {

    /**
     * Sets the Red_mushroom sprite
     */
    @Override
    public void setSprite() {
        super.getSprite().setSpritePosX(1337);
        super.getSprite().setSpritePosY(8);
        super.getSprite().setSprite_width(28);
        super.getSprite().setSprite_height(28);
        super.getSprite().setWidth(28);
        super.getSprite().setHeight(28);
    }
}
