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
public class Village_guard  extends Abstract_sprite{
    /**
     * Sets the Candle sprite
     */
    @Override
    public void setSprite(){
        super.getSprite().setSpritePosX(159);
        super.getSprite().setSpritePosY(875);
        super.getSprite().setSprite_width(35);
        super.getSprite().setSprite_height(51);
        super.getSprite().setWidth(35);
        super.getSprite().setHeight(51);
    }
}
