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
public class Haycart  extends Abstract_sprite{
    /**
     * Sets the Candle sprite
     */
    @Override
    public void setSprite(){
        super.getSprite().setSpritePosX(223);
        super.getSprite().setSpritePosY(634);
        super.getSprite().setSprite_width(80);
        super.getSprite().setSprite_height(55);
        super.getSprite().setWidth(80);
        super.getSprite().setHeight(55);
    }
}
