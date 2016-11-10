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
public class Skeleton_hanging  extends Abstract_sprite{
    /**
     * Sets the Candle sprite
     */
    @Override
    public void setSprite(){
        super.getSprite().setSpritePosX(707);
        super.getSprite().setSpritePosY(115);
        super.getSprite().setSprite_width(32);
        super.getSprite().setSprite_height(57);
        super.getSprite().setWidth(32);
        super.getSprite().setHeight(57);
    }
}
