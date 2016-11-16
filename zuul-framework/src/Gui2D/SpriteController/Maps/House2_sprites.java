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
        house_floor.setSize(300,200);
        house_floor.setPosition(0, 0);
        house2_background_sprites.add(house_floor);
        
        //sacks
        Sprite sacks = world.getMisc_sprites().getSacks_1();
        sacks.setPosition(250,125);
        house2_background_sprites.add(sacks);
        
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
        house_walls_circle.setSize(350, 250);
        house2_background_sprites.add(house_walls_circle);
        
        //exit
        Sprite exit = world.getMisc_sprites().getDoor_wood();
        exit.setPosition(175, 20);
        house2_background_sprites.add(exit);
       
        //kids
        
        
        //bed
        Sprite bed = world.getMisc_sprites().getInterior_doublebed();
        bed.setPosition(30,50);
        house2_background_sprites.add(bed);
        
        //table
        Sprite table = world.getMisc_sprites().getInterior_table();
        table.setPosition(175,125);
        house2_background_sprites.add(table);
        
        //candle on table
        
        
        
        //wandrobe
        Sprite wardrobe = world.getMisc_sprites().getInterior_cupboard_facingdown_large();
        wardrobe.setPosition(258,30);
        house2_background_sprites.add(wardrobe);
        
        
        
        
        
        
        
    }
    
        public List getHouse2(){
        return house2_background_sprites;
    }
            

    /**
     * @return the cellar_background_sprites
     */
    
}