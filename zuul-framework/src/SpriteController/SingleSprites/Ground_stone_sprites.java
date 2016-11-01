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
    private SingleSprite stone_dark1, stone_dark2, stone_dark3;
    private SingleSprite stone_dark_wall_NW, stone_dark_wall_N, stone_dark_wall_NE, stone_dark_wall_E, stone_dark_wall_SE, stone_dark_wall_S, stone_dark_wall_SW, stone_dark_wall_W;
    
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
        ground_stone_dark1.setSpritePosX(576.0);
        ground_stone_dark1.setSpritePosY(160.0);
        ground_stone_dark1.setSpriteHeight(32);
        ground_stone_dark1.setSpriteWidth(32);
        ground_stone_dark1.setWidth(32);
        ground_stone_dark1.setHeight(32);
        
        ground_stone_dark2 = new SingleSprite();
        ground_stone_dark2.setImage(getSpriteSheet());
        ground_stone_dark2.setSpritePosX(608.0);
        ground_stone_dark2.setSpritePosY(160.0);
        ground_stone_dark2.setSpriteHeight(32);
        ground_stone_dark2.setSpriteWidth(32);
        ground_stone_dark2.setWidth(32);
        ground_stone_dark2.setHeight(32);
        
        ground_stone_dark3 = new SingleSprite();
        ground_stone_dark3.setImage(getSpriteSheet());
        ground_stone_dark3.setSpritePosX(640.0);
        ground_stone_dark3.setSpritePosY(160.0);
        ground_stone_dark3.setSpriteHeight(32);
        ground_stone_dark3.setSpriteWidth(32);
        ground_stone_dark3.setWidth(32);
        ground_stone_dark3.setHeight(32);
        
        
        
        stone_dark1 = new SingleSprite();
        stone_dark1.setImage(getSpriteSheet());
        stone_dark1.setSpritePosX(768.0);
        stone_dark1.setSpritePosY(352.0);
        stone_dark1.setSpriteHeight(32);
        stone_dark1.setSpriteWidth(32);
        stone_dark1.setWidth(32);
        stone_dark1.setHeight(32);
        
        stone_dark2 = new SingleSprite();
        stone_dark2.setImage(getSpriteSheet());
        stone_dark2.setSpritePosX(800.0);
        stone_dark2.setSpritePosY(352.0);
        stone_dark2.setSpriteHeight(32);
        stone_dark2.setSpriteWidth(32);
        stone_dark2.setWidth(32);
        stone_dark2.setHeight(32);
        
        stone_dark3 = new SingleSprite();
        stone_dark3.setImage(getSpriteSheet());
        stone_dark3.setSpritePosX(832.0);
        stone_dark3.setSpritePosY(352.0);
        stone_dark3.setSpriteHeight(32);
        stone_dark3.setSpriteWidth(32);
        stone_dark3.setWidth(32);
        stone_dark3.setHeight(32);
        
        stone_dark_wall_NW = new SingleSprite();
        stone_dark_wall_NW.setImage(getSpriteSheet());
        stone_dark_wall_NW.setSpritePosX(1064.0);
        stone_dark_wall_NW.setSpritePosY(0.0);
        stone_dark_wall_NW.setSpriteHeight(64);
        stone_dark_wall_NW.setSpriteWidth(64);
        stone_dark_wall_NW.setWidth(64);
        stone_dark_wall_NW.setHeight(64);
        
        stone_dark_wall_N = new SingleSprite();
        stone_dark_wall_N.setImage(getSpriteSheet());
        stone_dark_wall_N.setSpritePosX(1096.0);
        stone_dark_wall_N.setSpritePosY(0.0);
        stone_dark_wall_N.setSpriteHeight(64);
        stone_dark_wall_N.setSpriteWidth(64);
        stone_dark_wall_N.setWidth(64);
        stone_dark_wall_N.setHeight(64);
        
        stone_dark_wall_NE = new SingleSprite();
        stone_dark_wall_NE.setImage(getSpriteSheet());
        stone_dark_wall_NE.setSpritePosX(1128.0);
        stone_dark_wall_NE.setSpritePosY(0.0);
        stone_dark_wall_NE.setSpriteHeight(64);
        stone_dark_wall_NE.setSpriteWidth(64);
        stone_dark_wall_NE.setWidth(64);
        stone_dark_wall_NE.setHeight(64);
        
        stone_dark_wall_E = new SingleSprite();
        stone_dark_wall_E.setImage(getSpriteSheet());
        stone_dark_wall_E.setSpritePosX(1128.0);
        stone_dark_wall_E.setSpritePosY(136.0);
        stone_dark_wall_E.setSpriteHeight(64);
        stone_dark_wall_E.setSpriteWidth(64);
        stone_dark_wall_E.setWidth(64);
        stone_dark_wall_E.setHeight(64);
        
        stone_dark_wall_SE = new SingleSprite();
        stone_dark_wall_SE.setImage(getSpriteSheet());
        stone_dark_wall_SE.setSpritePosX(1128.0);
        stone_dark_wall_SE.setSpritePosY(64.0);
        stone_dark_wall_SE.setSpriteHeight(64);
        stone_dark_wall_SE.setSpriteWidth(64);
        stone_dark_wall_SE.setWidth(64);
        stone_dark_wall_SE.setHeight(64);
        
        stone_dark_wall_S = new SingleSprite();
        stone_dark_wall_S.setImage(getSpriteSheet());
        stone_dark_wall_S.setSpritePosX(1096.0);
        stone_dark_wall_S.setSpritePosY(64.0);
        stone_dark_wall_S.setSpriteHeight(64);
        stone_dark_wall_S.setSpriteWidth(64);
        stone_dark_wall_S.setWidth(64);
        stone_dark_wall_S.setHeight(64);
        
        stone_dark_wall_SW = new SingleSprite();
        stone_dark_wall_SW.setImage(getSpriteSheet());
        stone_dark_wall_SW.setSpritePosX(1064.0);
        stone_dark_wall_SW.setSpritePosY(64.0);
        stone_dark_wall_SW.setSpriteHeight(64);
        stone_dark_wall_SW.setSpriteWidth(64);
        stone_dark_wall_SW.setWidth(64);
        stone_dark_wall_SW.setHeight(64);
        
        stone_dark_wall_W = new SingleSprite();
        stone_dark_wall_W.setImage(getSpriteSheet());
        stone_dark_wall_W.setSpritePosX(1064.0);
        stone_dark_wall_W.setSpritePosY(136.0);
        stone_dark_wall_W.setSpriteHeight(64);
        stone_dark_wall_W.setSpriteWidth(64);
        stone_dark_wall_W.setWidth(64);
        stone_dark_wall_W.setHeight(64);
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

    /**
     * @return the stone_dark1
     */
    public SingleSprite getStone_dark1() {
        return stone_dark1;
    }

    /**
     * @return the stone_dark2
     */
    public SingleSprite getStone_dark2() {
        return stone_dark2;
    }

    /**
     * @return the stone_dark3
     */
    public SingleSprite getStone_dark3() {
        return stone_dark3;
    }

    /**
     * @return the stone_dark_wall_NW
     */
    public SingleSprite getStone_dark_wall_NW() {
        return stone_dark_wall_NW;
    }

    /**
     * @return the stone_dark_wall_N
     */
    public SingleSprite getStone_dark_wall_N() {
        return stone_dark_wall_N;
    }

    /**
     * @return the stone_dark_wall_NE
     */
    public SingleSprite getStone_dark_wall_NE() {
        return stone_dark_wall_NE;
    }

    /**
     * @return the stone_dark_wall_E
     */
    public SingleSprite getStone_dark_wall_E() {
        return stone_dark_wall_E;
    }

    /**
     * @return the stone_dark_wall_SE
     */
    public SingleSprite getStone_dark_wall_SE() {
        return stone_dark_wall_SE;
    }

    /**
     * @return the stone_dark_wall_S
     */
    public SingleSprite getStone_dark_wall_S() {
        return stone_dark_wall_S;
    }

    /**
     * @return the stone_dark_wall_SW
     */
    public SingleSprite getStone_dark_wall_SW() {
        return stone_dark_wall_SW;
    }

    /**
     * @return the stone_dark_wall_W
     */
    public SingleSprite getStone_dark_wall_W() {
        return stone_dark_wall_W;
    }

}
