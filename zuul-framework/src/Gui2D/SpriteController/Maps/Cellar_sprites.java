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
public class Cellar_sprites{
    //list of grass sprites this map uses
    private List<SingleSprite> celler_grass_singlesprites;
    private List<SingleSprite> cellar_stone_walls;
    private SpriteController world;
    
    //contains all the sprites kept in the background
    private List<Sprite> cellar_background_sprites;
    
    public Cellar_sprites(SpriteController world){
        cellar_background_sprites = new ArrayList();
        cellar_stone_walls = new ArrayList();
        celler_grass_singlesprites = new ArrayList();
        this.world = world;
    }
    
    public void setCellar_background_SingleSprites(){
        
            
            celler_grass_singlesprites.add(world.getGround_sprite().getStone_floor_1());
            celler_grass_singlesprites.add(world.getGround_sprite().getStone_floor_2());
            celler_grass_singlesprites.add(world.getGround_sprite().getStone_floor_3());
            
            Sprite random_group_grass = new Groupsprite_random(celler_grass_singlesprites);
            random_group_grass.setPosition(0, 0);
            random_group_grass.setSize(1024, 512);
            cellar_background_sprites.add(random_group_grass);
            
            Sprite hay_bed = world.getMisc_sprites().getHay_bed();
            hay_bed.setPosition(32, 64);
            cellar_background_sprites.add(hay_bed);
            
            
            cellar_stone_walls.add(world.getStructure_sprites().getStone_wall_NW());
            cellar_stone_walls.add(world.getStructure_sprites().getStone_wall_N());
            cellar_stone_walls.add(world.getStructure_sprites().getStone_wall_NE());
            cellar_stone_walls.add(world.getStructure_sprites().getStone_wall_E());
            cellar_stone_walls.add(world.getStructure_sprites().getStone_wall_SE());
            cellar_stone_walls.add(world.getStructure_sprites().getStone_wall_S());
            cellar_stone_walls.add(world.getStructure_sprites().getStone_wall_SW());
            cellar_stone_walls.add(world.getStructure_sprites().getStone_wall_W());
            Sprite stone_walls = new Groupsprite_circle(cellar_stone_walls);
            stone_walls.setPosition(0, 0);
            stone_walls.setSize(512, 256);
            cellar_background_sprites.add(stone_walls);
                    
                    
            Sprite torch = world.getMisc_sprites().getTorch_wall();
            torch.setPosition(100, 10);
            torch.setSize(torch.getWidth()/1.3, torch.getHeight()/1.3);
            cellar_background_sprites.add(torch);
            
            Sprite door = world.getMisc_sprites().getDoor_metal();
            door.setPosition(330, 20);
            cellar_background_sprites.add(door);

    }

    /**
     * @return the cellar_background_sprites
     */
    public List<Sprite> getCellar_background_sprites() {
        return cellar_background_sprites;
    }
}
