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
public class Big_Rock extends Abstract_sprite{
    /**
     * Sets the Big_Rock sprite
     */
    @Override
    public void setSprite(){
        super.getSprite().setSpritePosX(2);
        super.getSprite().setSpritePosY(547);
        super.getSprite().setSprite_width(61);
        super.getSprite().setSprite_height(45);
        super.getSprite().setWidth(61);
        super.getSprite().setHeight(45);
    }
}
