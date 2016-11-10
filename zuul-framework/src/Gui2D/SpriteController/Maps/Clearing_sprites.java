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


public class Clearing_sprites{
private SpriteController world;
private List<Sprite> clearing_background_sprites;
private List<SingleSprite> clearing_tree_walls;
private List<SingleSprite> clearing_grass_singlesprites;
    
    
    public Clearing_sprites(SpriteController world){
        this.world = world;
        clearing_background_sprites = new ArrayList();
        clearing_tree_walls = new ArrayList();
        clearing_grass_singlesprites = new ArrayList();
        
        
    }
    
    public void setClearing(){
            clearing_grass_singlesprites.add(world.getGround_sprite().getGrass_light_1());
            clearing_grass_singlesprites.add(world.getGround_sprite().getGrass_flower_1());     
            Sprite clearing_group_grass = new Groupsprite_random(clearing_grass_singlesprites);
            clearing_group_grass.setPosition(0, 0);
            clearing_group_grass.setSize(800, 400);
            clearing_background_sprites.add(clearing_group_grass);
            
            clearing_tree_walls.add(world.getMisc_sprites().getBush());
            clearing_tree_walls.add(world.getMisc_sprites().getBush());
            clearing_tree_walls.add(world.getMisc_sprites().getBush());
            clearing_tree_walls.add(world.getMisc_sprites().getBush());
            clearing_tree_walls.add(world.getMisc_sprites().getBush());
            clearing_tree_walls.add(world.getMisc_sprites().getBush());
            clearing_tree_walls.add(world.getMisc_sprites().getBush());
            clearing_tree_walls.add(world.getMisc_sprites().getBush());
            Sprite tree_walls = new Groupsprite_circle(clearing_tree_walls);
            tree_walls.setPosition(0,0);
            tree_walls.setSize(800, 400);
            clearing_background_sprites.add(tree_walls);
            
            Sprite exit = world.getMisc_sprites().getBushExit();
            exit.setPosition(375, 0);
            clearing_background_sprites.add(exit);
            
            Sprite unicorn = world.getMisc_sprites().getUnicorner();
            unicorn.setPosition(550,200);
            clearing_background_sprites.add(unicorn);
            
            
            
            
            
            

            
            
            
            
                    
            /*        
            Sprite torch = world.getMisc_sprites().getTorch_wall();
            torch.setPosition(100, 10);
            torch.setSize(torch.getWidth()/1.3, torch.getHeight()/1.3);
            clearing_background_sprites.add(torch);
            
            Sprite door = world.getMisc_sprites().getDoor_metal();
            door.setPosition(330, 20);
            clearing_background_sprites.add(door);
            */
    }

    public List<Sprite> getClearing(){
       return clearing_background_sprites; 
    }

}
