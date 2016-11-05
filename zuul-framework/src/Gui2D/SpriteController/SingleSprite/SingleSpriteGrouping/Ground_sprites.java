/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping;

import Gui2D.SpriteController.SingleSprite.SingleSprite;
import Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping.Ground.*;

/**
 *
 * @author jonas
 */
public class Ground_sprites {
    private SingleSprite stone_light_1, stone_light_2, stone_light_3;
    
    private SingleSprite stone_dark_1, stone_dark_2, stone_dark_3;
    
    private SingleSprite grass_light_1, grass_light_2, grass_light_3;
    
    private SingleSprite grass_flowers_1, grass_flowers_2, grass_flowers_3;
    
    private SingleSprite grass_dark_1, grass_dark_2, grass_dark_3;
    
    /**
     * Creates all the ground sprites
     */
    public Ground_sprites(){
        //sets the light stones sprites
        stone_light_1 = new Stone_light_1().getSprite();
        stone_light_2 = new Stone_light_2().getSprite();
        stone_light_3 = new Stone_light_3().getSprite();
        
        //set the dark stones sprites
        stone_dark_1 = new Stone_dark_1().getSprite();
        stone_dark_2 = new Stone_dark_2().getSprite();
        stone_dark_3 = new Stone_dark_3().getSprite();
        
        //sets the light grass sprites
        grass_light_1 = new Grass_light_1().getSprite();
        grass_light_2 = new Grass_light_2().getSprite();
        grass_light_3 = new Grass_light_3().getSprite();
        
        //sets the dark grass sprites
        grass_dark_1 = new Grass_dark_1().getSprite();
        grass_dark_2 = new Grass_dark_2().getSprite();
        grass_dark_3 = new Grass_dark_3().getSprite();
        
        //sets the grass flower sprites
        grass_flowers_1 = new Grass_flower_1().getSprite();
        grass_flowers_2 = new Grass_flower_2().getSprite();
        grass_flowers_3 = new Grass_flower_3().getSprite();
    }

    /**
     * @return the stone_light_1
     */
    public SingleSprite getStone_light_1() {
        return stone_light_1;
    }

    /**
     * @return the stone_light_2
     */
    public SingleSprite getStone_light_2() {
        return stone_light_2;
    }

    /**
     * @return the stone_light_3
     */
    public SingleSprite getStone_light_3() {
        return stone_light_3;
    }

    /**
     * @return the stone_dark_1
     */
    public SingleSprite getStone_dark_1() {
        return stone_dark_1;
    }

    /**
     * @return the stone_dark_2
     */
    public SingleSprite getStone_dark_2() {
        return stone_dark_2;
    }

    /**
     * @return the stone_dark_3
     */
    public SingleSprite getStone_dark_3() {
        return stone_dark_3;
    }

    /**
     * @return the grass_light_1
     */
    public SingleSprite getGrass_light_1() {
        return grass_light_1;
    }

    /**
     * @return the grass_light_2
     */
    public SingleSprite getGrass_light_2() {
        return grass_light_2;
    }

    /**
     * @return the grass_light_3
     */
    public SingleSprite getGrass_light_3() {
        return grass_light_3;
    }

    /**
     * @return the grass_flowers_1
     */
    public SingleSprite getGrass_flowers_1() {
        return grass_flowers_1;
    }

    /**
     * @return the grass_flowers_2
     */
    public SingleSprite getGrass_flowers_2() {
        return grass_flowers_2;
    }

    /**
     * @return the grass_flowers_3
     */
    public SingleSprite getGrass_flowers_3() {
        return grass_flowers_3;
    }

    /**
     * @return the grass_dark_1
     */
    public SingleSprite getGrass_dark_1() {
        return grass_dark_1;
    }

    /**
     * @return the grass_dark_2
     */
    public SingleSprite getGrass_dark_2() {
        return grass_dark_2;
    }

    /**
     * @return the grass_dark_3
     */
    public SingleSprite getGrass_dark_3() {
        return grass_dark_3;
    }
}

