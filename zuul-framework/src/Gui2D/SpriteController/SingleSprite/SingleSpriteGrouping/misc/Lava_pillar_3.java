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
public class Lava_pillar_3  extends Abstract_sprite{
    /**
     * Sets the Candle sprite
     */
    @Override
    public void setSprite(){
        super.getSprite().setSpritePosX(285);
        super.getSprite().setSpritePosY(309);
        super.getSprite().setSprite_width(30);
        super.getSprite().setSprite_height(70);
        super.getSprite().setWidth(30);
        super.getSprite().setHeight(70);
    }
}
