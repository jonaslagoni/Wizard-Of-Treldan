/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpriteController;

import SpriteController.GroupSprites.Groupsprite_random;
import JavaFX.TestFXGui;
import SpriteController.Sprites.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jonas
 */
public class SpriteGenerator extends TestFXGui{
    //The spritesheet
    private static String spriteSheet = "terrain_atlas.png";
    private static int sprite_width = 32;
    private static int sprite_height = 32;
    
    //all sprites generated in this world
    private List<Sprite> spriteList_still;
    private List<Sprite> spriteList_moveable;
    private List<Sprite> menu_sprites;
    
    //All normal sprites
    //all ground water sprites
    private Ground_water_sprites ground_water_sprites;
    //all ground grass sprites
    private Ground_grass_sprites ground_grass_sprites;
    //all ground stone sprites
    private Ground_stone_sprites ground_stone_sprites;
    
    //All group ground sprites
    private List<SingleSprite> ALL_ground_grass_sprites;
    private List<SingleSprite> ALL_ground_stone_sprites;
    private List<SingleSprite> ALL_ground_water_sprites;
    
    /**
     * 
     * @param gc 
     */
    public SpriteGenerator(){
        spriteList_still = new ArrayList();
        spriteList_moveable = new ArrayList();
        menu_sprites = new ArrayList();
        
        //init all normal tiles
        initSprites();
        
        //init all group tiles
        initGroupSprites();
        
        Sprite test_group = new Groupsprite_random(ALL_ground_water_sprites);
        ((Groupsprite_random)test_group).setPosition(0, 0);
        ((Groupsprite_random)test_group).setHeight(512);
        ((Groupsprite_random)test_group).setWidth(1024);
        spriteList_still.add(test_group);
        
        Sprite grass_group = new Groupsprite_random(getGround_water_sprites());
        ((Groupsprite_random)grass_group).setPosition(128, 256);
        ((Groupsprite_random)grass_group).setHeight(256);
        ((Groupsprite_random)grass_group).setWidth(512);
        spriteList_moveable.add(grass_group);
        
        Sprite gass_group = new Groupsprite_random(getGround_grass_sprites());
        ((Groupsprite_random)gass_group).setPosition(0, 0);
        ((Groupsprite_random)gass_group).setHeight(512);
        ((Groupsprite_random)gass_group).setWidth(1024);
        menu_sprites.add(gass_group);
    }
    
    
    /**
     * Here goes all group sprites
     */
    
    public void initGroupSprites(){
        initALL_ground_stone_sprites();
        initALL_ground_grass_sprites();
        initALL_ground_water_sprites();
    }

    /**
     * All light stone
     */
    public void initALL_ground_stone_sprites(){
        ALL_ground_stone_sprites = new ArrayList();
        ALL_ground_stone_sprites.add(ground_stone_sprites.getGround_stone_dark1());
        ALL_ground_stone_sprites.add(ground_stone_sprites.getGround_stone_dark2());
        ALL_ground_stone_sprites.add(ground_stone_sprites.getGround_stone_dark3());
        ALL_ground_stone_sprites.add(ground_stone_sprites.getGround_stone_light1());
        ALL_ground_stone_sprites.add(ground_stone_sprites.getGround_stone_light2());
        ALL_ground_stone_sprites.add(ground_stone_sprites.getGround_stone_light3());
    }
    /**
     * Init a group
     */
    public void initALL_ground_grass_sprites(){
        ALL_ground_grass_sprites = new ArrayList();
        ALL_ground_grass_sprites.add(ground_grass_sprites.getGround_grass1());
        ALL_ground_grass_sprites.add(ground_grass_sprites.getGround_grass2());
        ALL_ground_grass_sprites.add(ground_grass_sprites.getGround_grass3());
        ALL_ground_grass_sprites.add(ground_grass_sprites.getGround_grass_dark1());
        ALL_ground_grass_sprites.add(ground_grass_sprites.getGround_grass_dark2());
        ALL_ground_grass_sprites.add(ground_grass_sprites.getGround_grass_dark3());
        ALL_ground_grass_sprites.add(ground_grass_sprites.getGround_grass_flowers1());
        ALL_ground_grass_sprites.add(ground_grass_sprites.getGround_grass_flowers2());
        ALL_ground_grass_sprites.add(ground_grass_sprites.getGround_grass_flowers3());
    }
    /**
     * 
     */
    public void initALL_ground_water_sprites(){
        ALL_ground_water_sprites = new ArrayList();
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water1());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water2());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water3());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_dirtEdge_E());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_dirtEdge_N());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_dirtEdge_NE());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_dirtEdge_NW());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_dirtEdge_S());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_dirtEdge_SE());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_dirtEdge_SW());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_dirtEdge_W());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_grassEdge_E());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_grassEdge_N());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_grassEdge_NE());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_grassEdge_NW());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_grassEdge_S());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_grassEdge_SE());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_grassEdge_SW());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_grassEdge_W());
    }

    
/**
 * Here goes all the normal sprites.
 */
    /**
     * Init all sprites that are avaliable
     */
    public void initSprites(){
        initGroundWaterSprites();
        initGroundGrassSprites();
        initGroundStoneSprites();
    }
    
    /**
     * Init all grass sprites
     */
    public void initGroundGrassSprites(){
        ground_grass_sprites = new Ground_grass_sprites();
    }
    
    /**
     * Init all stone sprites
     */
    public void initGroundStoneSprites(){
        ground_stone_sprites = new Ground_stone_sprites();
    }

    /**
     * Init all water sprites
     */
    public void initGroundWaterSprites(){
        ground_water_sprites = new Ground_water_sprites();
    }
    
    
    /**
     * 
     * @return 
     */
    public List<Sprite> getStillSprites(){
        return getSpriteList_still();
    }
    /**
     *  Get the list of moveable sprites
     * @return 
     */
    public List<Sprite> getMoveableSprites(){
        return getSpriteList_moveable();
    }
    
    
    
    /*
     * This is where all theg generated get and setters are.
     */
   
    /**
     * @return the spriteSheet
     */
    public static String getSpriteSheet() {
        return spriteSheet;
    }
}