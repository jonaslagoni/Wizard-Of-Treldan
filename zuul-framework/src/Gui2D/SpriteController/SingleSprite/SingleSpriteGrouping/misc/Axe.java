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
public class Axe  extends Abstract_sprite{
    /**
     * Sets the Candle sprite
     */
    @Override
    public void setSprite(){
        super.getSprite().setSpritePosX(198);
        super.getSprite().setSpritePosY(840);
        super.getSprite().setSprite_width(26);
        super.getSprite().setSprite_height(30);
        super.getSprite().setWidth(26);
        super.getSprite().setHeight(30);
    }
}