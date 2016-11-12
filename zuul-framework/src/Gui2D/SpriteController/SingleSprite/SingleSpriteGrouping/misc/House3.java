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
public class House3  extends Abstract_sprite{
    /**
     * Sets the Candle sprite
     */
    @Override
    public void setSprite(){
        super.getSprite().setSpritePosX(614);
        super.getSprite().setSpritePosY(705);
        super.getSprite().setSprite_width(165);
        super.getSprite().setSprite_height(246);
        super.getSprite().setWidth(165);
        super.getSprite().setHeight(246);
    }
}
