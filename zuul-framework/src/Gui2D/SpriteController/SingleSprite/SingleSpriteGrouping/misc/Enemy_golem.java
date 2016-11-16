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
public class Enemy_golem  extends Abstract_sprite{
    /**
     * Sets the Candle sprite
     */
    @Override
    public void setSprite(){
        super.getSprite().setSpritePosX(1025);
        super.getSprite().setSpritePosY(400);
        super.getSprite().setSprite_width(43);
        super.getSprite().setSprite_height(59);
        super.getSprite().setWidth(43);
        super.getSprite().setHeight(59);
    }
}
