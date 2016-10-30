/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpriteController.SingleSprites;

import SpriteController.SingleSprite;
import SpriteController.Sprite;
import static SpriteController.SpriteGenerator.getSpriteSheet;

/**
 *
 * @author jonas
 */
public class Ground_stone_sprites {
    private SingleSprite ground_stone_light1, ground_stone_light2, ground_stone_light3;
    private SingleSprite ground_stone_dark1, ground_stone_dark2, ground_stone_dark3;
    
    public Ground_stone_sprites(){
        ground_stone_light1 = new SingleSprite();
        ground_stone_light1.setImage(getSpriteSheet());
        ground_stone_light1.setSpritePosX(544.0);
        ground_stone_light1.setSpritePosY(160.0);
        ground_stone_light1.setSpriteHeight(32);
        ground_stone_light1.setSpriteWidth(32);
        ground_stone_light1.setWidth(32);
        ground_stone_light1.setHeight(32);
        
        ground_stone_light2 = new SingleSprite();
        ground_stone_light2.setImage(getSpriteSheet());
        ground_stone_light2.setSpritePosX(512.0);
        ground_stone_light2.setSpritePosY(160.0);
        ground_stone_light2.setSpriteHeight(32);
        ground_stone_light2.setSpriteWidth(32);
        ground_stone_light2.setWidth(32);
        ground_stone_light2.setHeight(32);
        
        ground_stone_light3 = new SingleSprite();
        ground_stone_light3.setImage(getSpriteSheet());
        ground_stone_light3.setSpritePosX(480.0);
        ground_stone_light3.setSpritePosY(160.0);
        ground_stone_light3.setSpriteHeight(32);
        ground_stone_light3.setSpriteWidth(32);
        ground_stone_light3.setWidth(32);
        ground_stone_light3.setHeight(32);
        
        
        ground_stone_dark1 = new SingleSprite();
        ground_stone_dark1.setImage(getSpriteSheet());
        ground_stone_dark1.setSpritePosX(592.0);
        ground_stone_dark1.setSpritePosY(176.0);
        ground_stone_dark1.setSpriteHeight(32);
        ground_stone_dark1.setSpriteWidth(32);
        ground_stone_dark1.setWidth(32);
        ground_stone_dark1.setHeight(32);
        
        ground_stone_dark2 = new SingleSprite();
        ground_stone_dark2.setImage(getSpriteSheet());
        ground_stone_dark2.setSpritePosX(624.0);
        ground_stone_dark2.setSpritePosY(176.0);
        ground_stone_dark2.setSpriteHeight(32);
        ground_stone_dark2.setSpriteWidth(32);
        ground_stone_dark2.setWidth(32);
        ground_stone_dark2.setHeight(32);
        
        ground_stone_dark3 = new SingleSprite();
        ground_stone_dark3.setImage(getSpriteSheet());
        ground_stone_dark3.setSpritePosX(656.0);
        ground_stone_dark3.setSpritePosY(176.0);
        ground_stone_dark3.setSpriteHeight(32);
        ground_stone_dark3.setSpriteWidth(32);
        ground_stone_dark3.setWidth(32);
        ground_stone_dark3.setHeight(32);
    }

    /**
     * @return the ground_stone_light1
     */
    public SingleSprite getGround_stone_light1() {
        return ground_stone_light1;
    }

    /**
     * @return the ground_stone_light2
     */
    public SingleSprite getGround_stone_light2() {
        return ground_stone_light2;
    }

    /**
     * @return the ground_stone_light3
     */
    public SingleSprite getGround_stone_light3() {
        return ground_stone_light3;
    }

    /**
     * @return the ground_stone_dark1
     */
    public SingleSprite getGround_stone_dark1() {
        return ground_stone_dark1;
    }

    /**
     * @return the ground_stone_dark2
     */
    public SingleSprite getGround_stone_dark2() {
        return ground_stone_dark2;
    }

    /**
     * @return the ground_stone_dark3
     */
    public SingleSprite getGround_stone_dark3() {
        return ground_stone_dark3;
    }

}
