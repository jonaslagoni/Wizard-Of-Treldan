/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpriteController;

import SpriteController.SingleSprites.Ground_grass_sprites;
import SpriteController.SingleSprites.Ground_water_sprites;
import SpriteController.SingleSprites.Ground_stone_sprites;
import SpriteController.SingleSprites.Interior_misc;
import SpriteController.GroupSprites.Groupsprite_random;
import JavaFX.TestFXGui;
import SpriteController.GroupSprites.Groupsprite_circle;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jonas
 */
public class SpriteGenerator extends TestFXGui{
    //The spritesheet
    private static String spriteSheet = "terrain_atlas.png";
    private static String buildingSheet = "base_out_atlas.png";
    private static int sprite_width = 32;
    private static int sprite_height = 32;

    /**
     * @return the buildingSheet
     */
    public static String getBuildingSheet() {
        return buildingSheet;
    }
    
    //all sprites generated in this world
    private List<Sprite> spriteList_still;
    private List<Sprite> spriteList_moveable;
    private List<Sprite> menu_sprites;
    
    /**
     * Map 1
     */
    private List<Sprite> map1_sprites_still;
    private List<Sprite> village_sprites_still;
    
    //All normal sprites
    //all ground water sprites
    private Ground_water_sprites ground_water_sprites;
    //all ground grass sprites
    private Ground_grass_sprites ground_grass_sprites;
    //all ground stone sprites
    private Ground_stone_sprites ground_stone_sprites;
    //all misc sprites
    private Interior_misc interior_misc;
    
    //All group ground sprites
    private List<SingleSprite> ALL_ground_grass_sprites;
    private List<SingleSprite> ALL_ground_stone_sprites;
    private List<SingleSprite> ALL_ground_water_sprites;
    
    private List<SingleSprite> ground_water_grass_circle;
    private List<SingleSprite> ground_water_grass_circle_edge;
    private List<SingleSprite> wall_stone_circle_edge;
    private List<SingleSprite> ground_grass_random_1;
    private List<SingleSprite> ground_water_random_1;
    
    /**
     * all sprites for map 1
     */
    private List<SingleSprite> map1_ground_stones_random_1;
    
    /**
     * 
     * @param gc 
     */
    public SpriteGenerator(){
        spriteList_still = new ArrayList();
        spriteList_moveable = new ArrayList();
        menu_sprites = new ArrayList();
        map1_sprites_still = new ArrayList();
        
        //init all normal tiles
        initSprites();
        
        //init all group tiles
        initGroupSprites();
        
        
        setMap1();
        
        Sprite test_group = new Groupsprite_random(ground_grass_random_1);
        ((Groupsprite_random)test_group).setPosition(0, 0);
        ((Groupsprite_random)test_group).setHeight(512);
        ((Groupsprite_random)test_group).setWidth(1024);
        spriteList_still.add(test_group);
        
        Sprite grass_group = new Groupsprite_circle(ground_water_grass_circle_edge);
        ((Groupsprite_circle)grass_group).setPosition(256, 128);
        ((Groupsprite_circle)grass_group).setHeight(256);
        ((Groupsprite_circle)grass_group).setWidth(512);
        spriteList_still.add(grass_group);
        
        Sprite water_group = new Groupsprite_random(ground_water_random_1);
        ((Groupsprite_random)water_group).setPosition(160, 288);
        ((Groupsprite_random)water_group).setHeight(192);
        ((Groupsprite_random)water_group).setWidth(448);
        spriteList_moveable.add(water_group);
        
        Sprite circle = new Groupsprite_circle(ground_water_grass_circle);
        ((Groupsprite_circle)circle).setPosition(0, 0);
        ((Groupsprite_circle)circle).setHeight(512);
        ((Groupsprite_circle)circle).setWidth(1024);
        menu_sprites.add(circle);
    }
    
    public void setMap1(){
        
        Sprite floor = new Groupsprite_random(map1_ground_stones_random_1);
        ((Groupsprite_random)floor).setPosition(0, 0);
        ((Groupsprite_random)floor).setHeight(256+128);
        ((Groupsprite_random)floor).setWidth(512+128);
        map1_sprites_still.add(floor);
        
        Sprite haystack = interior_misc.getHay_bed();
        haystack.setPosition(250, 100);
        haystack.setHeight(80);
        haystack.setWidth(56);
        map1_sprites_still.add(haystack);
        
        Sprite stone_wall_edge = new Groupsprite_circle(wall_stone_circle_edge);
        ((Groupsprite_circle)stone_wall_edge).setPosition(0, 0);
        ((Groupsprite_circle)stone_wall_edge).setHeight(256+128);
        ((Groupsprite_circle)stone_wall_edge).setWidth(512+128);
        map1_sprites_still.add(stone_wall_edge);
        
        
        Sprite torch = interior_misc.getTorch();
        torch.setPosition(100, 20);
        torch.setHeight(38);
        torch.setWidth(18);
        map1_sprites_still.add(torch);
        
        
        Sprite metalDoor = interior_misc.getMetalDoor();
        metalDoor.setPosition(200, 15);
        map1_sprites_still.add(metalDoor);
        
        
        Sprite metalDoor2 = interior_misc.getMetalDoor();
        metalDoor2.setPosition(400, 15);
        map1_sprites_still.add(metalDoor2);
    }
    
    public void setVillage(){
        
    }
    /**
     * Here goes all group sprites
     */
    
    public void initGroupSprites(){
        initALL_ground_stone_sprites();
        initALL_ground_grass_sprites();
        initALL_ground_water_sprites();
        initWaterGrassCircle();
        initGround_grass_random_1();
        initGround_water_random_1();
        initMap1_sprites_still();
        initWaterGrassCircleEdge();
        initWall_stone_circle_edge();
    }
    public void initWall_stone_circle_edge(){
        
        wall_stone_circle_edge = new ArrayList();
        wall_stone_circle_edge.add(ground_stone_sprites.getStone_dark_wall_NW());
        wall_stone_circle_edge.add(ground_stone_sprites.getStone_dark_wall_N());
        wall_stone_circle_edge.add(ground_stone_sprites.getStone_dark_wall_NE());
        wall_stone_circle_edge.add(ground_stone_sprites.getStone_dark_wall_E());
        wall_stone_circle_edge.add(ground_stone_sprites.getStone_dark_wall_SE());
        wall_stone_circle_edge.add(ground_stone_sprites.getStone_dark_wall_S());
        wall_stone_circle_edge.add(ground_stone_sprites.getStone_dark_wall_SW());
        wall_stone_circle_edge.add(ground_stone_sprites.getStone_dark_wall_W());
    }
    public void initGround_grass_random_1(){
        ground_grass_random_1 = new ArrayList();
        ground_grass_random_1.add(ground_grass_sprites.getGround_grass1());
        ground_grass_random_1.add(ground_grass_sprites.getGround_grass2());
        ground_grass_random_1.add(ground_grass_sprites.getGround_grass3());
        ground_grass_random_1.add(ground_grass_sprites.getGround_grass_flowers1());
        ground_grass_random_1.add(ground_grass_sprites.getGround_grass_flowers2());
        ground_grass_random_1.add(ground_grass_sprites.getGround_grass_flowers3());
    }
    public void initMap1_sprites_still(){
        map1_ground_stones_random_1 = new ArrayList();
        SingleSprite s = ground_stone_sprites.getStone_dark1();
        SingleSprite s2 = ground_stone_sprites.getStone_dark2();
        SingleSprite s3 = ground_stone_sprites.getStone_dark3();
        map1_ground_stones_random_1.add(s);
        map1_ground_stones_random_1.add(s2);
        map1_ground_stones_random_1.add(s3);
    }
    public void initGround_water_random_1(){
        ground_water_random_1 = new ArrayList();
        ground_water_random_1.add(ground_water_sprites.getGround_water1());
        ground_water_random_1.add(ground_water_sprites.getGround_water2());
        ground_water_random_1.add(ground_water_sprites.getGround_water3());
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
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_grassEdge_E());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_grassEdge_N());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_grassEdge_NE());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_grassEdge_NW());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_grassEdge_S());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_grassEdge_SE());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_grassEdge_SW());
        ALL_ground_water_sprites.add(ground_water_sprites.getGround_water_grassEdge_W());
    }

    public void initWaterGrassCircle(){
        ground_water_grass_circle = new ArrayList();
        ground_water_grass_circle.add(ground_water_sprites.getGround_water_grassEdge_NW());
        ground_water_grass_circle.add(ground_water_sprites.getGround_water_grassEdge_N());
        ground_water_grass_circle.add(ground_water_sprites.getGround_water_grassEdge_NE());
        ground_water_grass_circle.add(ground_water_sprites.getGround_water_grassEdge_E());
        ground_water_grass_circle.add(ground_water_sprites.getGround_water_grassEdge_SE());
        ground_water_grass_circle.add(ground_water_sprites.getGround_water_grassEdge_S());
        ground_water_grass_circle.add(ground_water_sprites.getGround_water_grassEdge_SW());
        ground_water_grass_circle.add(ground_water_sprites.getGround_water_grassEdge_W());
        ground_water_grass_circle.add(ground_water_sprites.getGround_water4());
    }
    
    public void initWaterGrassCircleEdge(){
        ground_water_grass_circle_edge = new ArrayList();
        ground_water_grass_circle_edge.add(ground_water_sprites.getGround_water_grassEdge_NW());
        ground_water_grass_circle_edge.add(ground_water_sprites.getGround_water_grassEdge_N());
        ground_water_grass_circle_edge.add(ground_water_sprites.getGround_water_grassEdge_NE());
        ground_water_grass_circle_edge.add(ground_water_sprites.getGround_water_grassEdge_E());
        ground_water_grass_circle_edge.add(ground_water_sprites.getGround_water_grassEdge_SE());
        ground_water_grass_circle_edge.add(ground_water_sprites.getGround_water_grassEdge_S());
        ground_water_grass_circle_edge.add(ground_water_sprites.getGround_water_grassEdge_SW());
        ground_water_grass_circle_edge.add(ground_water_sprites.getGround_water_grassEdge_W());
    }
/**
 * Here goes all the normal sprites.
 */
    /**
     * Init all sprites that are avaliable
     */
    public void initSprites(){
        ground_grass_sprites = new Ground_grass_sprites();
        ground_stone_sprites = new Ground_stone_sprites();
        ground_water_sprites = new Ground_water_sprites();
        interior_misc = new Interior_misc();
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

    /**
     * @return the spriteList_still
     */
    public List<Sprite> getSpriteList_still() {
        return spriteList_still;
    }

    /**
     * @return the spriteList_moveable
     */
    public List<Sprite> getSpriteList_moveable() {
        return spriteList_moveable;
    }

    /**
     * @return the menu_sprites
     */
    public List<Sprite> getMenu_sprites() {
        return menu_sprites;
    }

    /**
     * @return the map1_sprites_still
     */
    public List<Sprite> getMap1_sprites_still() {
        return map1_sprites_still;
    }

    /**
     * @return the village_sprites_still
     */
    public List<Sprite> getVillage_sprites_still() {
        return village_sprites_still;
    }
}