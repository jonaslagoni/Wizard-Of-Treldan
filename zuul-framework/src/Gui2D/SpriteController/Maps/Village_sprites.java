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
    
    
    
    public Village_sprites(SpriteController world){
        this.world = world;
        //initialize the arraylists();
        village_background_sprites = new ArrayList();
        village_background_ground = new ArrayList();
        village_background_grass = new ArrayList();
        village_background_fence = new ArrayList();
 
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
        
        //patwhay
        village_background_ground.add(world.getGround_sprite().getTile_light_1());
        village_background_ground.add(world.getGround_sprite().getTile_light_2());
        village_background_ground.add(world.getGround_sprite().getTile_light_3());
        Sprite village_background_random_pathway = new Groupsprite_random(village_background_ground);
        village_background_random_pathway.setPosition(480,0 );
        village_background_random_pathway.setSize(64,300);
        village_background_sprites.add(village_background_random_pathway);
        
        
        
        //fence
        village_background_fence.add(world.getStructure_sprites().getWood_fence_NW());
        village_background_fence.add(world.getStructure_sprites().getWood_fence_N());
        village_background_fence.add(world.getStructure_sprites().getWood_fence_NE());
        village_background_fence.add(world.getStructure_sprites().getWood_fence_E());
        village_background_fence.add(world.getStructure_sprites().getWood_fence_SE());
        village_background_fence.add(world.getStructure_sprites().getWood_fence_S());
        village_background_fence.add(world.getStructure_sprites().getWood_fence_SE());
        village_background_fence.add(world.getStructure_sprites().getWood_fence_W());
        Sprite fence1 = new Groupsprite_circle(village_background_fence);
        fence1.setPosition(550,0 );
        fence1.setSize(280, 280);
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
        house3.setPosition(850,0);
        village_background_sprites.add(house3);
        
        //set well
        Sprite well = world.getMisc_sprites().getWell();
        well.setPosition(256, 300);
        village_background_sprites.add(well);
        
        
        //pathway to house1
        
        //pathway to house2
        
        //axe
        
        //guard
        
        //entrance to house 1,2,3
        
        
        
    }

    /**
     * @return the village_background_sprites
     */
    public List<Sprite> getVillage_background_sprites() {
        return village_background_sprites;
    }
    
}
