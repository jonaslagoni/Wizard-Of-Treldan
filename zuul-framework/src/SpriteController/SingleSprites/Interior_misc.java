/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpriteController.SingleSprites;

import SpriteController.SingleSprite;
import SpriteController.SpriteGenerator;

/**
 *
 * @author jonas
 */
public class Interior_misc {
    private SingleSprite hay_bed;
    public Interior_misc(){
        hay_bed = new SingleSprite();
        hay_bed.setImage(SpriteGenerator.getBuildingSheet());
        hay_bed.setSpritePosX(355);
        hay_bed.setSpritePosY(656);
        hay_bed.setSpriteHeight(81);
        hay_bed.setSpriteWidth(56);
        hay_bed.setWidth(56);
        hay_bed.setHeight(81);
    }

    /**
     * @return the hay_bed
     */
    public SingleSprite getHay_bed() {
        return hay_bed;
    }
}
