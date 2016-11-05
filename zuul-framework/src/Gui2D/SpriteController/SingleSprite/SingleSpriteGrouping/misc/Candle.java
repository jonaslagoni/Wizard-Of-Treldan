/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping.misc;

import Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping.Abstract_sprite;
import Gui2D.SpriteController.SpriteGenerator;

/**
 *
 * @author jonas
 */
public class Candle  extends Abstract_sprite{
    /**
     * Sets the Candle sprite
     */
    public void setSprite(){
        super.getSpriteVariable().setSpritePosX(828);
        super.getSpriteVariable().setSpritePosY(10);
        super.getSpriteVariable().setSprite_width(6);
        super.getSpriteVariable().setSprite_height(25);
        super.getSpriteVariable().setWidth(6);
        super.getSpriteVariable().setHeight(25);
    }
}
