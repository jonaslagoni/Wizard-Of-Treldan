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
public class House2_sprites{
    
    private SpriteController world;
    private final List<Sprite> house2_background_sprites;
    
    private final List<SingleSprite> house2_background_walls;
    private final List<SingleSprite> house2_background_floor;
    
    
    public House2_sprites(SpriteController world){
        this.world = world;
        house2_background_sprites = new ArrayList();
        house2_background_walls = new ArrayList();
        house2_background_floor = new ArrayList();
        
    }
    public void setHouse2_background_SingleSprites(){
        //floor
        house2_background_floor.add(world.getGround_sprite().getWood_light_2());
        Sprite house_floor = new Groupsprite_random(house2_background_floor);
        house_floor.setSize(512,250);
        house_floor.setPosition(0, 0);
        house2_background_sprites.add(house_floor);
        
        //walls
        house2_background_walls.add(world.getStructure_sprites().getStone_wall_NW());
        house2_background_walls.add(world.getStructure_sprites().getStone_wall_N());
        house2_background_walls.add(world.getStructure_sprites().getStone_wall_NE());
        house2_background_walls.add(world.getStructure_sprites().getStone_wall_E());
        house2_background_walls.add(world.getStructure_sprites().getStone_wall_SE());
        house2_background_walls.add(world.getStructure_sprites().getStone_wall_S());
        house2_background_walls.add(world.getStructure_sprites().getStone_wall_SW());
        house2_background_walls.add(world.getStructure_sprites().getStone_wall_W());
        Sprite house_walls_circle = new Groupsprite_circle(house2_background_walls);
        house_walls_circle.setPosition(0, 0);
        house_walls_circle.setSize(512, 300);
        house2_background_sprites.add(house_walls_circle);
        
        
        //exit
        Sprite exit = world.getMisc_sprites().getDoor_wood();
        exit.setPosition(170,20);
        house2_background_sprites.add(exit);
        
        //zombie
        
        //woman
        
        //health potion
        
        //bed
        Sprite bed = world.getMisc_sprites().getInterior_doublebed();
        bed.setPosition(430, 45);
        house2_background_sprites.add(bed);
        
        //fireplace
        Sprite fireplace = world.getMisc_sprites().getInterior_fireplace();
        fireplace.setPosition(360,5);
        house2_background_sprites.add(fireplace);
        
        //cupboard
        Sprite cupboard = world.getMisc_sprites().getInterior_cupboard();
        cupboard.setPosition(49, 20);
        house2_background_sprites.add(cupboard);
        
        //shelf
        Sprite shelf = world.getMisc_sprites().getInterior_shelf_1();
        shelf.setPosition(280,15);
        house2_background_sprites.add(shelf);
        
        //table
        Sprite table = world.getMisc_sprites().getInterior_table_long();
        table.setPosition(250,175);
         house2_background_sprites.add(table);
         
        
         //sacks
         Sprite sacks = world.getMisc_sprites().getSacks_1();
         sacks.setPosition(32, 170);
         house2_background_sprites.add(sacks);
         
        
        
        
        
    }
    
        public List getHouse2(){
        return house2_background_sprites;
    }
            

    /**
     * @return the cellar_background_sprites
     */
    
}