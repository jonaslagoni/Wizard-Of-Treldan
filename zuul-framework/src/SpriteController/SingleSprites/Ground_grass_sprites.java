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
public class Ground_grass_sprites {
    private SingleSprite ground_grass1, ground_grass2, ground_grass3;
    private SingleSprite ground_grass_dark1, ground_grass_dark2, ground_grass_dark3;
    private SingleSprite ground_grass_flowers1, ground_grass_flowers2, ground_grass_flowers3;
    
    public Ground_grass_sprites(){
        //Grass
        ground_grass1 = new SingleSprite();
        ground_grass1.setImage(getSpriteSheet());
        ground_grass1.setSpritePosX(736.0);
        ground_grass1.setSpritePosY(160.0);
        ground_grass1.setSpriteHeight(32);
        ground_grass1.setSpriteWidth(32);
        ground_grass1.setWidth(32);
        ground_grass1.setHeight(32);
        
        ground_grass2 = new SingleSprite();
        ground_grass2.setImage(getSpriteSheet());
        ground_grass2.setSpritePosX(704.0);
        ground_grass2.setSpritePosY(160.0);
        ground_grass2.setSpriteHeight(32);
        ground_grass2.setSpriteWidth(32);
        ground_grass2.setWidth(32);
        ground_grass2.setHeight(32);
        
        ground_grass3 = new SingleSprite();
        ground_grass3.setImage(getSpriteSheet());
        ground_grass3.setSpritePosX(672.0);
        ground_grass3.setSpritePosY(160.0);
        ground_grass3.setSpriteHeight(32);
        ground_grass3.setSpriteWidth(32);
        ground_grass3.setWidth(32);
        ground_grass3.setHeight(32);
        
        ground_grass_dark1 = new SingleSprite();
        ground_grass_dark1.setImage(getSpriteSheet());
        ground_grass_dark1.setSpritePosX(192.0);
        ground_grass_dark1.setSpritePosY(928.0);
        ground_grass_dark1.setSpriteHeight(32);
        ground_grass_dark1.setSpriteWidth(32);
        ground_grass_dark1.setWidth(32);
        ground_grass_dark1.setHeight(32);
        
        ground_grass_dark2 = new SingleSprite();
        ground_grass_dark2.setImage(getSpriteSheet());
        ground_grass_dark2.setSpritePosX(224.0);
        ground_grass_dark2.setSpritePosY(928.0);
        ground_grass_dark2.setSpriteHeight(32);
        ground_grass_dark2.setSpriteWidth(32);
        ground_grass_dark2.setWidth(32);
        ground_grass_dark2.setHeight(32);
        
        ground_grass_dark3 = new SingleSprite();
        ground_grass_dark3.setImage(getSpriteSheet());
        ground_grass_dark3.setSpritePosX(256.0);
        ground_grass_dark3.setSpritePosY(928.0);
        ground_grass_dark3.setSpriteHeight(32);
        ground_grass_dark3.setSpriteWidth(32);
        ground_grass_dark3.setWidth(32);
        ground_grass_dark3.setHeight(32);
        
        ground_grass_flowers1 = new SingleSprite();
        ground_grass_flowers1.setImage(getSpriteSheet());
        ground_grass_flowers1.setSpritePosX(672.0);
        ground_grass_flowers1.setSpritePosY(352.0);
        ground_grass_flowers1.setSpriteHeight(32);
        ground_grass_flowers1.setSpriteWidth(32);
        ground_grass_flowers1.setWidth(32);
        ground_grass_flowers1.setHeight(32);
        
        
        ground_grass_flowers2 = new SingleSprite();
        ground_grass_flowers2.setImage(getSpriteSheet());
        ground_grass_flowers2.setSpritePosX(704.0);
        ground_grass_flowers2.setSpritePosY(352.0);
        ground_grass_flowers2.setSpriteHeight(32);
        ground_grass_flowers2.setSpriteWidth(32);
        ground_grass_flowers2.setWidth(32);
        ground_grass_flowers2.setHeight(32);
        
        ground_grass_flowers3 = new SingleSprite();
        ground_grass_flowers3.setImage(getSpriteSheet());
        ground_grass_flowers3.setSpritePosX(736.0);
        ground_grass_flowers3.setSpritePosY(352.0);
        ground_grass_flowers3.setSpriteHeight(32);
        ground_grass_flowers3.setSpriteWidth(32);
        ground_grass_flowers3.setWidth(32);
        ground_grass_flowers3.setHeight(32);
    }

    /**
     * @return the ground_grass1
     */
    public SingleSprite getGround_grass1() {
        return ground_grass1;
    }

    /**
     * @return the ground_grass2
     */
    public SingleSprite getGround_grass2() {
        return ground_grass2;
    }

    /**
     * @return the ground_grass3
     */
    public SingleSprite getGround_grass3() {
        return ground_grass3;
    }

    /**
     * @return the ground_grass_dark1
     */
    public SingleSprite getGround_grass_dark1() {
        return ground_grass_dark1;
    }

    /**
     * @return the ground_grass_dark2
     */
    public SingleSprite getGround_grass_dark2() {
        return ground_grass_dark2;
    }

    /**
     * @return the ground_grass_dark3
     */
    public SingleSprite getGround_grass_dark3() {
        return ground_grass_dark3;
    }

    /**
     * @return the ground_grass_flowers1
     */
    public SingleSprite getGround_grass_flowers1() {
        return ground_grass_flowers1;
    }

    /**
     * @return the ground_grass_flowers2
     */
    public SingleSprite getGround_grass_flowers2() {
        return ground_grass_flowers2;
    }

    /**
     * @return the ground_grass_flowers3
     */
    public SingleSprite getGround_grass_flowers3() {
        return ground_grass_flowers3;
    }

}
