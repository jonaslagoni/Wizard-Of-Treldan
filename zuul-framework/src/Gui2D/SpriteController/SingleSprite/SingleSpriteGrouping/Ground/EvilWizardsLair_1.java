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
public class EvilWizardsLair_1  extends Abstract_sprite{
    /**
     * Sets the Castle_Stone_Floor sprite
     */
    @Override
    public void setSprite(){
        super.getSprite().setSpritePosX(318);
        super.getSprite().setSpritePosY(215);
        super.getSprite().setSprite_width(32);
        super.getSprite().setSprite_height(32);
        super.getSprite().setWidth(32);
        super.getSprite().setHeight(32);
    }
}
