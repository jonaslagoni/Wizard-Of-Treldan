/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFX;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author jonas
 */
public class WorldGenerator extends TestFXGui{
    //The spritesheet
    private String spriteSheet = "terrain_atlas.png";
    //all sprites generated in this world
    private List<Sprite> spriteList_still;
    private List<Sprite> spriteList_moveable;
    private List<Sprite> menu_sprites;
    //All normal sprites
    private Sprite ground_grass1, ground_grass2, ground_grass3;
    private Sprite ground_stone_light1, ground_stone_light2, ground_stone_light3;
    private Sprite ground_water1, ground_water2, ground_water3;
    
    //all group sprites
    private List<SingleSprite> ground_grass_sprites, ground_light_stone_sprites, ground_water_sprites;
    /**
     * 
     * @param gc 
     */
    public WorldGenerator(){
        spriteList_still = new ArrayList();
        spriteList_moveable = new ArrayList();
        menu_sprites = new ArrayList();
        //init all normal tiles
        initSprites();
        
        //init all group tiles
        initGroupSprites();
        
        Sprite test_group = new GroupSprite(getGround_light_stone_sprites());
        ((GroupSprite)test_group).setPosition(0, 0);
        ((GroupSprite)test_group).setHeight(512);
        ((GroupSprite)test_group).setWidth(1024);
        spriteList_still.add(test_group);
        
        Sprite grass_group = new GroupSprite(getGround_water_sprites());
        ((GroupSprite)grass_group).setPosition(128, 256);
        ((GroupSprite)grass_group).setHeight(256);
        ((GroupSprite)grass_group).setWidth(512);
        spriteList_moveable.add(grass_group);
        
        Sprite gass_group = new GroupSprite(getGround_grass_sprites());
        ((GroupSprite)gass_group).setPosition(0, 0);
        ((GroupSprite)gass_group).setHeight(512);
        ((GroupSprite)gass_group).setWidth(1024);
        menu_sprites.add(gass_group);
    }
    public void initGroupSprites(){
        initGroupLightStoneSprites();
        initGroupGrassSprites();
        initGroupWaterSprites();
    }
    public void initGroupLightStoneSprites(){
        ground_light_stone_sprites = new ArrayList();
        getGround_light_stone_sprites().add((SingleSprite)getGround_stone_light1());
        getGround_light_stone_sprites().add((SingleSprite)getGround_stone_light2());
        getGround_light_stone_sprites().add((SingleSprite)getGround_stone_light3());
    }
    public void initGroupGrassSprites(){
        ground_grass_sprites = new ArrayList();
        getGround_grass_sprites().add((SingleSprite)getGround_grass1());
        getGround_grass_sprites().add((SingleSprite)getGround_grass2());
        getGround_grass_sprites().add((SingleSprite)getGround_grass3());
    }
    public void initGroupWaterSprites(){
        ground_water_sprites = new ArrayList();
        getGround_water_sprites().add((SingleSprite)getGround_water1());
        getGround_water_sprites().add((SingleSprite)getGround_water2());
        getGround_water_sprites().add((SingleSprite)getGround_water3());
    }
    public void initSprites(){
        initGrassSprites();
        initLightStoneSprites();
        initWaterSprites();
    }
    public void initGrassSprites(){
        //Grass
        ground_grass1 = new SingleSprite();
        ((SingleSprite)getGround_grass1()).setImage(getSpriteSheet());
        ((SingleSprite)getGround_grass1()).setSpritePosX(736.0);
        ((SingleSprite)getGround_grass1()).setSpritePosY(160.0);
        ((SingleSprite)getGround_grass1()).setSpriteHeight(32);
        ((SingleSprite)getGround_grass1()).setSpriteWidth(32);
        ((SingleSprite)getGround_grass1()).setWidth(32);
        ((SingleSprite)getGround_grass1()).setHeight(32);
        
        ground_grass2 = new SingleSprite();
        ((SingleSprite)getGround_grass2()).setImage(getSpriteSheet());
        ((SingleSprite)getGround_grass2()).setSpritePosX(704.0);
        ((SingleSprite)getGround_grass2()).setSpritePosY(160.0);
        ((SingleSprite)getGround_grass2()).setSpriteHeight(32);
        ((SingleSprite)getGround_grass2()).setSpriteWidth(32);
        ((SingleSprite)getGround_grass2()).setWidth(32);
        ((SingleSprite)getGround_grass2()).setHeight(32);
        
        ground_grass3 = new SingleSprite();
        ((SingleSprite)getGround_grass3()).setImage(getSpriteSheet());
        ((SingleSprite)getGround_grass3()).setSpritePosX(672.0);
        ((SingleSprite)getGround_grass3()).setSpritePosY(160.0);
        ((SingleSprite)getGround_grass3()).setSpriteHeight(32);
        ((SingleSprite)getGround_grass3()).setSpriteWidth(32);
        ((SingleSprite)getGround_grass3()).setWidth(32);
        ((SingleSprite)getGround_grass3()).setHeight(32);
    }
    public void initLightStoneSprites(){
        //Grass
        ground_stone_light1 = new SingleSprite();
        ((SingleSprite)getGround_stone_light1()).setImage(getSpriteSheet());
        ((SingleSprite)getGround_stone_light1()).setSpritePosX(544.0);
        ((SingleSprite)getGround_stone_light1()).setSpritePosY(160.0);
        ((SingleSprite)getGround_stone_light1()).setSpriteHeight(32);
        ((SingleSprite)getGround_stone_light1()).setSpriteWidth(32);
        ((SingleSprite)getGround_stone_light1()).setWidth(32);
        ((SingleSprite)getGround_stone_light1()).setHeight(32);
        
        ground_stone_light2 = new SingleSprite();
        ((SingleSprite)getGround_stone_light2()).setImage(getSpriteSheet());
        ((SingleSprite)getGround_stone_light2()).setSpritePosX(512.0);
        ((SingleSprite)getGround_stone_light2()).setSpritePosY(160.0);
        ((SingleSprite)getGround_stone_light2()).setSpriteHeight(32);
        ((SingleSprite)getGround_stone_light2()).setSpriteWidth(32);
        ((SingleSprite)getGround_stone_light2()).setWidth(32);
        ((SingleSprite)getGround_stone_light2()).setHeight(32);
        
        ground_stone_light3 = new SingleSprite();
        ((SingleSprite)getGround_stone_light3()).setImage(getSpriteSheet());
        ((SingleSprite)getGround_stone_light3()).setSpritePosX(480.0);
        ((SingleSprite)getGround_stone_light3()).setSpritePosY(160.0);
        ((SingleSprite)getGround_stone_light3()).setSpriteHeight(32);
        ((SingleSprite)getGround_stone_light3()).setSpriteWidth(32);
        ((SingleSprite)getGround_stone_light3()).setWidth(32);
        ((SingleSprite)getGround_stone_light3()).setHeight(32);
    }
    public void initWaterSprites(){
        //Grass
        ground_water1 = new SingleSprite();
        ((SingleSprite)getGround_water1()).setImage(getSpriteSheet());
        ((SingleSprite)getGround_water1()).setSpritePosX(736.0);
        ((SingleSprite)getGround_water1()).setSpritePosY(544.0);
        ((SingleSprite)getGround_water1()).setSpriteHeight(32);
        ((SingleSprite)getGround_water1()).setSpriteWidth(32);
        ((SingleSprite)getGround_water1()).setWidth(32);
        ((SingleSprite)getGround_water1()).setHeight(32);
        
        ground_water2 = new SingleSprite();
        ((SingleSprite)getGround_water2()).setImage(getSpriteSheet());
        ((SingleSprite)getGround_water2()).setSpritePosX(704.0);
        ((SingleSprite)getGround_water2()).setSpritePosY(544.0);
        ((SingleSprite)getGround_water2()).setSpriteHeight(32);
        ((SingleSprite)getGround_water2()).setSpriteWidth(32);
        ((SingleSprite)getGround_water2()).setWidth(32);
        ((SingleSprite)getGround_water2()).setHeight(32);
        
        ground_water3 = new SingleSprite();
        ((SingleSprite)getGround_water3()).setImage(getSpriteSheet());
        ((SingleSprite)getGround_water3()).setSpritePosX(672.0);
        ((SingleSprite)getGround_water3()).setSpritePosY(544.0);
        ((SingleSprite)getGround_water3()).setSpriteHeight(32);
        ((SingleSprite)getGround_water3()).setSpriteWidth(32);
        ((SingleSprite)getGround_water3()).setWidth(32);
        ((SingleSprite)getGround_water3()).setHeight(32);
    }
    public List<Sprite> getStillSprites(){
        return getSpriteList_still();
    }
    public List<Sprite> getMoveableSprites(){
        return getSpriteList_moveable();
    }

    /**
     * @return the spriteSheet
     */
    public String getSpriteSheet() {
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
     * @return the ground_grass1
     */
    public Sprite getGround_grass1() {
        return ground_grass1;
    }

    /**
     * @return the ground_grass2
     */
    public Sprite getGround_grass2() {
        return ground_grass2;
    }

    /**
     * @return the ground_grass3
     */
    public Sprite getGround_grass3() {
        return ground_grass3;
    }

    /**
     * @return the ground_stone_light1
     */
    public Sprite getGround_stone_light1() {
        return ground_stone_light1;
    }

    /**
     * @return the ground_stone_light2
     */
    public Sprite getGround_stone_light2() {
        return ground_stone_light2;
    }

    /**
     * @return the ground_stone_light3
     */
    public Sprite getGround_stone_light3() {
        return ground_stone_light3;
    }

    /**
     * @return the ground_water1
     */
    public Sprite getGround_water1() {
        return ground_water1;
    }

    /**
     * @return the ground_water2
     */
    public Sprite getGround_water2() {
        return ground_water2;
    }

    /**
     * @return the ground_water3
     */
    public Sprite getGround_water3() {
        return ground_water3;
    }

    /**
     * @return the ground_grass_sprites
     */
    public List<SingleSprite> getGround_grass_sprites() {
        return ground_grass_sprites;
    }

    /**
     * @return the ground_light_stone_sprites
     */
    public List<SingleSprite> getGround_light_stone_sprites() {
        return ground_light_stone_sprites;
    }

    /**
     * @return the ground_water_sprites
     */
    public List<SingleSprite> getGround_water_sprites() {
        return ground_water_sprites;
    }

    /**
     * @return the menu_sprites
     */
    public List<Sprite> getMenu_sprites() {
        return menu_sprites;
    }
}
