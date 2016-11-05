/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping;

import Gui2D.SpriteController.SingleSprite.SingleSprite;
import Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping.Water.*;

/**
 *
 * @author jonas
 */
public class Water_sprites {
    private SingleSprite water_1, water_2, water_3, water_4;
    private SingleSprite water_grass_edge_NW, water_grass_edge_N, water_grass_edge_NE, water_grass_edge_E, water_grass_edge_SE, water_grass_edge_S, water_grass_edge_SW, water_grass_edge_W;
    
    public Water_sprites(){
        water_1 = new Water_1().getSprite();
        water_2 = new Water_2().getSprite();
        water_3 = new Water_3().getSprite();
        water_4 = new Water_4().getSprite();
        
        water_grass_edge_NW = new Water_grass_edge_NW().getSprite();
        water_grass_edge_N = new Water_grass_edge_N().getSprite();
        water_grass_edge_NE = new Water_grass_edge_NE().getSprite();
        water_grass_edge_E = new Water_grass_edge_E().getSprite();
        water_grass_edge_SE = new Water_grass_edge_SE().getSprite();
        water_grass_edge_S = new Water_grass_edge_S().getSprite();
        water_grass_edge_SW = new Water_grass_edge_SW().getSprite();
        water_grass_edge_W = new Water_grass_edge_W().getSprite();
    }

    /**
     * @return the water_1
     */
    public SingleSprite getWater_1() {
        return water_1;
    }

    /**
     * @return the water_2
     */
    public SingleSprite getWater_2() {
        return water_2;
    }

    /**
     * @return the water_3
     */
    public SingleSprite getWater_3() {
        return water_3;
    }

    /**
     * @return the water_4
     */
    public SingleSprite getWater_4() {
        return water_4;
    }

    /**
     * @return the water_grass_edge_NW
     */
    public SingleSprite getWater_grass_edge_NW() {
        return water_grass_edge_NW;
    }

    /**
     * @return the water_grass_edge_N
     */
    public SingleSprite getWater_grass_edge_N() {
        return water_grass_edge_N;
    }

    /**
     * @return the water_grass_edge_NE
     */
    public SingleSprite getWater_grass_edge_NE() {
        return water_grass_edge_NE;
    }

    /**
     * @return the water_grass_edge_E
     */
    public SingleSprite getWater_grass_edge_E() {
        return water_grass_edge_E;
    }

    /**
     * @return the water_grass_edge_SE
     */
    public SingleSprite getWater_grass_edge_SE() {
        return water_grass_edge_SE;
    }

    /**
     * @return the water_grass_edge_S
     */
    public SingleSprite getWater_grass_edge_S() {
        return water_grass_edge_S;
    }

    /**
     * @return the water_grass_edge_SW
     */
    public SingleSprite getWater_grass_edge_SW() {
        return water_grass_edge_SW;
    }

    /**
     * @return the water_grass_edge_W
     */
    public SingleSprite getWater_grass_edge_W() {
        return water_grass_edge_W;
    }
}
