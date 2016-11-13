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
 * @author jonas
 */
public class Village_sprites{
    private SpriteController world;
    //list of sprites
    private List<Sprite> village_background_sprites;
   
    //lists of sprites
    private List<SingleSprite> village_background_ground;
    private final List<SingleSprite> village_background_grass;
    private final List<SingleSprite> village_background_fence;
    private final List<SingleSprite> village_walls;
    
    
    
    public Village_sprites(SpriteController world){
        this.world = world;
        //initialize the arraylists();
        village_background_sprites = new ArrayList();
        village_background_ground = new ArrayList();
        village_background_grass = new ArrayList();
        village_background_fence = new ArrayList();
        village_walls = new ArrayList();
 
    }
    
    public void setVillage_background_SingleSprites(){
       
        //tiles
        village_background_ground.add(world.getGround_sprite().getTile_light_1());
        village_background_ground.add(world.getGround_sprite().getTile_light_2());
        village_background_ground.add(world.getGround_sprite().getTile_light_3());
        Sprite village_background_random = new Groupsprite_random(village_background_ground);
        village_background_random.setPosition(0, 0);
        village_background_random.setSize(1024, 512);
        village_background_sprites.add(village_background_random);
        
        //grass
        village_background_grass.add(world.getGround_sprite().getGrass_light_1());
        village_background_grass.add(world.getGround_sprite().getGrass_light_2());
        village_background_grass.add(world.getGround_sprite().getGrass_flower_1());
        village_background_grass.add(world.getGround_sprite().getGrass_flower_2());
        Sprite village_grass_background_random = new Groupsprite_random(village_background_grass);
        village_grass_background_random.setPosition(0,0);
        village_grass_background_random.setSize(1024,300);
        village_background_sprites.add(village_grass_background_random);
        
        //pathway
        village_background_ground.add(world.getGround_sprite().getTile_light_1());
        village_background_ground.add(world.getGround_sprite().getTile_light_2());
        village_background_ground.add(world.getGround_sprite().getTile_light_3());
        Sprite village_background_random_pathway = new Groupsprite_random(village_background_ground);
        village_background_random_pathway.setPosition(480,0 );
        village_background_random_pathway.setSize(64,300);
        village_background_sprites.add(village_background_random_pathway);
        
        
       
        //pathway to house1
        village_background_ground.add(world.getGround_sprite().getTile_light_1());
        village_background_ground.add(world.getGround_sprite().getTile_light_2());
        village_background_ground.add(world.getGround_sprite().getTile_light_3());
        Sprite village_background_random_house1 = new Groupsprite_random(village_background_ground);
        village_background_random_house1.setPosition(100,160 );
        village_background_random_house1.setSize(64,130);
        village_background_sprites.add(village_background_random_house1);
        //pathway to house2
        village_background_ground.add(world.getGround_sprite().getTile_light_1());
        village_background_ground.add(world.getGround_sprite().getTile_light_2());
        village_background_ground.add(world.getGround_sprite().getTile_light_3());
        Sprite village_background_random_house2 = new Groupsprite_random(village_background_ground);
        village_background_random_house2.setPosition(280,160 );
        village_background_random_house2.setSize(64,130);
        village_background_sprites.add(village_background_random_house2);
        //pathway to house3
        village_background_ground.add(world.getGround_sprite().getTile_light_1());
        village_background_ground.add(world.getGround_sprite().getTile_light_2());
        village_background_ground.add(world.getGround_sprite().getTile_light_3());
        Sprite village_background_random_house3 = new Groupsprite_random(village_background_ground);
        village_background_random_house3.setPosition(930,160 );
        village_background_random_house3.setSize(64,130);
        village_background_sprites.add(village_background_random_house3);
        
        //walls
        village_walls.add(world.getStructure_sprites().getStone_wall_NW());
        village_walls.add(world.getStructure_sprites().getStone_wall_N());
        village_walls.add(world.getStructure_sprites().getStone_wall_NE());
        village_walls.add(world.getStructure_sprites().getStone_wall_E());
        village_walls.add(world.getStructure_sprites().getStone_wall_SE());
        village_walls.add(world.getStructure_sprites().getStone_wall_S());
        village_walls.add(world.getStructure_sprites().getStone_wall_SW());
        village_walls.add(world.getStructure_sprites().getStone_wall_W());
        Sprite village_walls_circle = new Groupsprite_circle(village_walls);
        village_walls_circle.setPosition(0, 0);
        village_walls_circle.setSize(1024, 512);
        village_background_sprites.add(village_walls_circle);
        
        //fence
        village_background_fence.add(world.getStructure_sprites().getWood_fence_NW());
        village_background_fence.add(world.getStructure_sprites().getWood_fence_N());
        village_background_fence.add(world.getStructure_sprites().getWood_fence_NE());
        village_background_fence.add(world.getStructure_sprites().getWood_fence_E());
        village_background_fence.add(world.getStructure_sprites().getWood_fence_SE());
        village_background_fence.add(world.getStructure_sprites().getWood_fence_S());
        village_background_fence.add(world.getStructure_sprites().getWood_fence_SW());
        village_background_fence.add(world.getStructure_sprites().getWood_fence_W());
        Sprite fence1 = new Groupsprite_circle(village_background_fence);
        fence1.setPosition(550,50 );
        fence1.setSize(200, 100);
        village_background_sprites.add(fence1);
        
 
        //village houses
        //#1
        Sprite house1 = world.getMisc_sprites().getHouse1();
        house1.setPosition(25, -10);
        village_background_sprites.add(house1);
        //#2
        Sprite house2 = world.getMisc_sprites().getHouse2();
        house2.setPosition(250,-40);
        village_background_sprites.add(house2);
        //#3
        Sprite house3 = world.getMisc_sprites().getHouse3();
        house3.setPosition(832,-5);
        village_background_sprites.add(house3);
        
        //set well
        Sprite well = world.getMisc_sprites().getWell();
        well.setPosition(400, 350);
        village_background_sprites.add(well);
        
        
        //axe
        Sprite axe = world.getMisc_sprites().getAxe();
        axe.setPosition(100, 400);
        village_background_sprites.add(axe);
        
        //guard
        Sprite guard = world.getMisc_sprites().getGuard();
        guard.setPosition(464, 30);
        village_background_sprites.add(guard);
        
        
        //entrance to house 1,2,3
        Sprite house1_exit = world.getMisc_sprites().getDoor_wood();
        house1_exit.setPosition(127,175);
        village_background_sprites.add(house1_exit);
        Sprite house2_exit = world.getMisc_sprites().getDoor_wood();
        house2_exit.setPosition(300,147);
        village_background_sprites.add(house2_exit);
        Sprite house3_exit = world.getMisc_sprites().getDoor_metal();
        house3_exit.setPosition(950,185);
        village_background_sprites.add(house3_exit);
        
        //exit to forest
        Sprite village_exit = world.getMisc_sprites().getDoor_metal();
        village_exit.setPosition(500,20);
        village_background_sprites.add(village_exit);
        
        
        
    }

    /**
     * @return the village_background_sprites
     */
    public List<Sprite> getVillage_background_sprites() {
        return village_background_sprites;
    }
    
}
