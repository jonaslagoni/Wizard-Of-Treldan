/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping.Ground;

import Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping.Abstract_sprite;

/**
 *
 * @author Mads
 */
public class Stone_Tile extends Abstract_sprite{
    /**
     * Sets the Stone_Tile sprite
     */
    @Override
    public void setSprite(){
        super.getSprite().setSpritePosX(353);
        super.getSprite().setSpritePosY(41);
        super.getSprite().setSprite_width(31);
        super.getSprite().setSprite_height(32);
        super.getSprite().setWidth(31);
        super.getSprite().setHeight(32);
    }
}
