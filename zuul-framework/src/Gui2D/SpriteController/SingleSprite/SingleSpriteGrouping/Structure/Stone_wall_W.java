/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping.Structure;

import Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping.Abstract_sprite;

/**
 *
 * @author jonas
 */
public class Stone_wall_W  extends Abstract_sprite{
    /**
     * Sets the Candle sprite
     */
    @Override
    public void setSprite(){
        super.getSprite().setSpritePosX(897);
        super.getSprite().setSpritePosY(73);
        super.getSprite().setSprite_width(64);
        super.getSprite().setSprite_height(64);
        super.getSprite().setWidth(64);
        super.getSprite().setHeight(64);
    }
}
