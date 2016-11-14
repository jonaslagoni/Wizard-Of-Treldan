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
public class Rock_Wall_LEFT extends Abstract_sprite{
    /**
     * Sets the Rock_Wall_Front sprite
     */
    @Override
    public void setSprite(){
        super.getSprite().setSpritePosX(970);
        super.getSprite().setSpritePosY(397);
        super.getSprite().setSprite_width(13);
        super.getSprite().setSprite_height(65);
        super.getSprite().setWidth(13);
        super.getSprite().setHeight(65);
    }
}
