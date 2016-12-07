/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.Maps;

import Gui2D.SpriteController.GroupSprites.Groupsprite_circle;
import Gui2D.SpriteController.GroupSprites.Groupsprite_random;
import Gui2D.SpriteController.SingleSprite.SingleSprite;
import Gui2D.SpriteController.Sprite;
import Gui2D.SpriteController.SpriteController;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mads B
 */
public class House1_sprites{
    private SpriteController world;
    private final List<Sprite> house1_background_sprites;
    private final List<Sprite> house1_monster_sprites;
    private Sprite stranger_sprite;
    private final List<SingleSprite> house1_background_walls;
    private final List<SingleSprite> house1_background_floor;
    
    /**
     * Sets the sprites for this map
     * @param world 
     */
    public House1_sprites(SpriteController world){
        this.world = world;
        house1_background_sprites = new ArrayList();
        house1_monster_sprites = new ArrayList();
        house1_background_walls = new ArrayList();
        house1_background_floor = new ArrayList();
        
    }
    
    /**
     * Set all the sprites to the arraylist
     */
    public void setHouse1_background_SingleSprites(){
        //floor
        house1_background_floor.add(world.getGround_sprite().getWood_light_2());
        Sprite house_floor = new Groupsprite_random(house1_background_floor);
        house_floor.setSize(375,250);
        house_floor.setPosition(0, 0);
        house1_background_sprites.add(house_floor);
       
        
        //walls
        house1_background_walls.add(world.getStructure_sprites().getStone_wall_NW());
        house1_background_walls.add(world.getStructure_sprites().getStone_wall_N());
        house1_background_walls.add(world.getStructure_sprites().getStone_wall_NE());
        house1_background_walls.add(world.getStructure_sprites().getStone_wall_E());
        house1_background_walls.add(world.getStructure_sprites().getStone_wall_SE());
        house1_background_walls.add(world.getStructure_sprites().getStone_wall_S());
        house1_background_walls.add(world.getStructure_sprites().getStone_wall_SW());
        house1_background_walls.add(world.getStructure_sprites().getStone_wall_W());
        Sprite house_walls_circle = new Groupsprite_circle(house1_background_walls);
        house_walls_circle.setPosition(0, 0);
        house_walls_circle.setSize(400, 300);
        house1_background_sprites.add(house_walls_circle);
        
        //exit
        Sprite exit = world.getMisc_sprites().getDoor_wood();
        exit.setPosition(175, 20);
        house1_background_sprites.add(exit);
        //bed
        Sprite bed = world.getMisc_sprites().getInterior_doublebed();
        bed.setPosition(30,50);
        house1_background_sprites.add(bed);
        //chest
        Sprite chest = world.getMisc_sprites().getChestClosed();
        chest.setPosition(35,125);
        house1_background_sprites.add(chest);
        
        //kitchen
        Sprite kitchen = world.getMisc_sprites().getInterior_kitchen();
        kitchen.setPosition(255,50);
        house1_background_sprites.add(kitchen);
        
        //shelf
        Sprite bookshelf = world.getMisc_sprites().getBookshelf_1();
        bookshelf.setPosition(80,10);
        house1_background_sprites.add(bookshelf);
        
        
        //enemy
        Sprite enemy = world.getMisc_sprites().getEnemy_Skeleton();
        enemy.setPosition(200,150);
        house1_monster_sprites.add(enemy);
        
        
        Sprite stranger = world.getMisc_sprites().getNPC_stranger();
        stranger.setPosition(100, 50);
        stranger_sprite = stranger;
        
        
    }
    
    /**
     * @return the background sprites
     */
    public List<Sprite> getHouse1(){
        return house1_background_sprites;
    }

    /**
     * @return the house1_monster_sprites
     */
    public List<Sprite> getHouse1_monster_sprites() {
        return house1_monster_sprites;
    }

    /**
     * @return the stranger_sprite
     */
    public Sprite getStranger_sprite() {
        return stranger_sprite;
    }
}
