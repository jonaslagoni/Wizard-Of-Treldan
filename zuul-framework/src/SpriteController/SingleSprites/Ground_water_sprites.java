/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpriteController.SingleSprites;

import SpriteController.SingleSprite;
import SpriteController.Sprite;
import SpriteController.SpriteGenerator;

/**
 *
 * @author jonas
 */
public class Ground_water_sprites {
    private SingleSprite ground_water1, ground_water2, ground_water3, ground_water4;
    private SingleSprite ground_water_grassEdge_NW, ground_water_grassEdge_N, ground_water_grassEdge_NE, ground_water_grassEdge_E, ground_water_grassEdge_SE, ground_water_grassEdge_S, ground_water_grassEdge_SW, ground_water_grassEdge_W;
    
    public Ground_water_sprites(){
        ground_water1 = new SingleSprite();
        ground_water1.setImage(SpriteGenerator.getSpriteSheet());
        ground_water1.setSpritePosX(736.0);
        ground_water1.setSpritePosY(544.0);
        ground_water1.setSpriteHeight(32);
        ground_water1.setSpriteWidth(32);
        ground_water1.setWidth(32);
        ground_water1.setHeight(32);
        
        ground_water2 = new SingleSprite();
        ground_water2.setImage(SpriteGenerator.getSpriteSheet());
        ground_water2.setSpritePosX(704.0);
        ground_water2.setSpritePosY(544.0);
        ground_water2.setSpriteHeight(32);
        ground_water2.setSpriteWidth(32);
        ground_water2.setWidth(32);
        ground_water2.setHeight(32);
        
        ground_water3 = new SingleSprite();
        ground_water3.setImage(SpriteGenerator.getSpriteSheet());
        ground_water3.setSpritePosX(672.0);
        ground_water3.setSpritePosY(544.0);
        ground_water3.setSpriteHeight(32);
        ground_water3.setSpriteWidth(32);
        ground_water3.setWidth(32);
        ground_water3.setHeight(32);
        
        ground_water4 = new SingleSprite();
        ground_water4.setImage(SpriteGenerator.getSpriteSheet());
        ground_water4.setSpritePosX(224.0);
        ground_water4.setSpritePosY(384.0);
        ground_water4.setSpriteHeight(32);
        ground_water4.setSpriteWidth(32);
        ground_water4.setWidth(32);
        ground_water4.setHeight(32);
        
        ground_water_grassEdge_NW = new SingleSprite();
        ground_water_grassEdge_NW.setImage(SpriteGenerator.getSpriteSheet());
        ground_water_grassEdge_NW.setSpritePosX(192.0);
        ground_water_grassEdge_NW.setSpritePosY(352.0);
        ground_water_grassEdge_NW.setSpriteHeight(32);
        ground_water_grassEdge_NW.setSpriteWidth(32);
        ground_water_grassEdge_NW.setWidth(32);
        ground_water_grassEdge_NW.setHeight(32);
        
        ground_water_grassEdge_N = new SingleSprite();
        ground_water_grassEdge_N.setImage(SpriteGenerator.getSpriteSheet());
        ground_water_grassEdge_N.setSpritePosX(224.0);
        ground_water_grassEdge_N.setSpritePosY(352.0);
        ground_water_grassEdge_N.setSpriteHeight(32);
        ground_water_grassEdge_N.setSpriteWidth(32);
        ground_water_grassEdge_N.setWidth(32);
        ground_water_grassEdge_N.setHeight(32);
        
        ground_water_grassEdge_NE = new SingleSprite();
        ground_water_grassEdge_NE.setImage(SpriteGenerator.getSpriteSheet());
        ground_water_grassEdge_NE.setSpritePosX(256.0);
        ground_water_grassEdge_NE.setSpritePosY(352.0);
        ground_water_grassEdge_NE.setSpriteHeight(32);
        ground_water_grassEdge_NE.setSpriteWidth(32);
        ground_water_grassEdge_NE.setWidth(32);
        ground_water_grassEdge_NE.setHeight(32);
        
        ground_water_grassEdge_E = new SingleSprite();
        ground_water_grassEdge_E.setImage(SpriteGenerator.getSpriteSheet());
        ground_water_grassEdge_E.setSpritePosX(256.0);
        ground_water_grassEdge_E.setSpritePosY(384.0);
        ground_water_grassEdge_E.setSpriteHeight(32);
        ground_water_grassEdge_E.setSpriteWidth(32);
        ground_water_grassEdge_E.setWidth(32);
        ground_water_grassEdge_E.setHeight(32);
        
        ground_water_grassEdge_SE = new SingleSprite();
        ground_water_grassEdge_SE.setImage(SpriteGenerator.getSpriteSheet());
        ground_water_grassEdge_SE.setSpritePosX(256.0);
        ground_water_grassEdge_SE.setSpritePosY(416.0);
        ground_water_grassEdge_SE.setSpriteHeight(32);
        ground_water_grassEdge_SE.setSpriteWidth(32);
        ground_water_grassEdge_SE.setWidth(32);
        ground_water_grassEdge_SE.setHeight(32);
        
        ground_water_grassEdge_S = new SingleSprite();
        ground_water_grassEdge_S.setImage(SpriteGenerator.getSpriteSheet());
        ground_water_grassEdge_S.setSpritePosX(224.0);
        ground_water_grassEdge_S.setSpritePosY(416.0);
        ground_water_grassEdge_S.setSpriteHeight(32);
        ground_water_grassEdge_S.setSpriteWidth(32);
        ground_water_grassEdge_S.setWidth(32);
        ground_water_grassEdge_S.setHeight(32);
        
        ground_water_grassEdge_SW = new SingleSprite();
        ground_water_grassEdge_SW.setImage(SpriteGenerator.getSpriteSheet());
        ground_water_grassEdge_SW.setSpritePosX(192.0);
        ground_water_grassEdge_SW.setSpritePosY(416.0);
        ground_water_grassEdge_SW.setSpriteHeight(32);
        ground_water_grassEdge_SW.setSpriteWidth(32);
        ground_water_grassEdge_SW.setWidth(32);
        ground_water_grassEdge_SW.setHeight(32);
        
        ground_water_grassEdge_W = new SingleSprite();
        ground_water_grassEdge_W.setImage(SpriteGenerator.getSpriteSheet());
        ground_water_grassEdge_W.setSpritePosX(192.0);
        ground_water_grassEdge_W.setSpritePosY(384.0);
        ground_water_grassEdge_W.setSpriteHeight(32);
        ground_water_grassEdge_W.setSpriteWidth(32);
        ground_water_grassEdge_W.setWidth(32);
        ground_water_grassEdge_W.setHeight(32);
    }

    /**
     * @return the ground_water1
     */
    public SingleSprite getGround_water1() {
        return ground_water1;
    }

    /**
     * @return the ground_water2
     */
    public SingleSprite getGround_water2() {
        return ground_water2;
    }

    /**
     * @return the ground_water3
     */
    public SingleSprite getGround_water3() {
        return ground_water3;
    }

    /**
     * @return the ground_water4
     */
    public SingleSprite getGround_water4() {
        return ground_water4;
    }

    /**
     * @return the ground_water_grassEdge_NW
     */
    public SingleSprite getGround_water_grassEdge_NW() {
        return ground_water_grassEdge_NW;
    }

    /**
     * @return the ground_water_grassEdge_N
     */
    public SingleSprite getGround_water_grassEdge_N() {
        return ground_water_grassEdge_N;
    }

    /**
     * @return the ground_water_grassEdge_NE
     */
    public SingleSprite getGround_water_grassEdge_NE() {
        return ground_water_grassEdge_NE;
    }

    /**
     * @return the ground_water_grassEdge_E
     */
    public SingleSprite getGround_water_grassEdge_E() {
        return ground_water_grassEdge_E;
    }

    /**
     * @return the ground_water_grassEdge_SE
     */
    public SingleSprite getGround_water_grassEdge_SE() {
        return ground_water_grassEdge_SE;
    }

    /**
     * @return the ground_water_grassEdge_S
     */
    public SingleSprite getGround_water_grassEdge_S() {
        return ground_water_grassEdge_S;
    }

    /**
     * @return the ground_water_grassEdge_SW
     */
    public SingleSprite getGround_water_grassEdge_SW() {
        return ground_water_grassEdge_SW;
    }

    /**
     * @return the ground_water_grassEdge_W
     */
    public SingleSprite getGround_water_grassEdge_W() {
        return ground_water_grassEdge_W;
    }

}
