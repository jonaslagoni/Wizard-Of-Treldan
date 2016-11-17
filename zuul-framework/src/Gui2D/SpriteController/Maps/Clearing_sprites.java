/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.Maps;

import Gui2D.SpriteController.GroupSprites.Groupsprite_GroupRender;
import Gui2D.SpriteController.GroupSprites.Groupsprite_circle;
import Gui2D.SpriteController.GroupSprites.Groupsprite_random;
import Gui2D.SpriteController.SingleSprite.SingleSprite;
import Gui2D.SpriteController.Sprite;
import Gui2D.SpriteController.SpriteController;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Rectangle2D;


public class Clearing_sprites{
private SpriteController world;
//list containing all sprites for the room
private List<Sprite> clearing_background_sprites;
private List<Sprite> clearing_foreground_sprites;

//lists of treeline
private final List<SingleSprite> clearing_tree_walls_RIGHT;
private final List<SingleSprite> clearing_tree_walls_LEFT;
private final List<SingleSprite> clearing_tree_walls_TOP;
private final List<SingleSprite> clearing_tree_walls_BOTTOM;
//lists containing individual sprites   
private final List<SingleSprite> clearing_grass_singlesprites;
private final List<SingleSprite> clearing_ruins_singlesprites;
private final List<SingleSprite> clearing_pathway_sprites;
    
    
    public Clearing_sprites(SpriteController world){
        //initialize world + list of spritess
        this.world = world;
        clearing_background_sprites = new ArrayList();
        clearing_foreground_sprites = new ArrayList();
        
        //initialize treeline
        clearing_tree_walls_RIGHT = new ArrayList();
        clearing_tree_walls_LEFT = new ArrayList();
        clearing_tree_walls_TOP = new ArrayList();
        clearing_tree_walls_BOTTOM = new ArrayList();
        
        //initialize misc
        clearing_grass_singlesprites = new ArrayList();
        clearing_ruins_singlesprites = new ArrayList();
        clearing_pathway_sprites = new ArrayList();
        
        
    }
    
    public void setClearing_background_sprites(){
 
            //BACKGROUND GRASS
            clearing_grass_singlesprites.add(world.getGround_sprite().getGrass_light_1());
            clearing_grass_singlesprites.add(world.getGround_sprite().getGrass_light_2()); 
            clearing_grass_singlesprites.add(world.getGround_sprite().getGrass_flower_2());
            Sprite clearing_group_grass = new Groupsprite_random(clearing_grass_singlesprites);
            clearing_group_grass.setPosition(0, 0);
            clearing_group_grass.setSize(800, 400);
            clearing_background_sprites.add(clearing_group_grass);
            
            //RUINS FLOOR
            clearing_ruins_singlesprites.add(world.getGround_sprite().getStone_ruins_floor_1());
            clearing_ruins_singlesprites.add(world.getGround_sprite().getStone_ruins_floor_2());
            clearing_ruins_singlesprites.add(world.getGround_sprite().getStone_ruins_floor_3());
            Sprite clearing_group_ruins = new Groupsprite_random(clearing_ruins_singlesprites);
            clearing_group_ruins.setPosition(450, 100);
            clearing_group_ruins.setSize(200, 200);
            clearing_background_sprites.add(clearing_group_ruins);
            
            //TREELINE TOP
            clearing_tree_walls_TOP.add(world.getMisc_sprites().getTree1());
            Sprite clearing_wall_tree_random_TOP = new Groupsprite_GroupRender(clearing_tree_walls_TOP);
            clearing_wall_tree_random_TOP.setPosition(0,-80);
            clearing_wall_tree_random_TOP.setSize(800,30);
            clearing_background_sprites.add(clearing_wall_tree_random_TOP);
            
             //TREELINE RIGHT
            clearing_tree_walls_RIGHT.add(world.getMisc_sprites().getTree1());
            Sprite clearing_wall_tree_random_RIGHT = new Groupsprite_GroupRender(clearing_tree_walls_RIGHT);
            clearing_wall_tree_random_RIGHT.setPosition(650,-50);
            clearing_wall_tree_random_RIGHT.setSize(100,400);
            clearing_background_sprites.add(clearing_wall_tree_random_RIGHT);
            
            //TREELINE LEFT
            clearing_tree_walls_LEFT.add(world.getMisc_sprites().getTree1());
            Sprite clearing_wall_tree_random_LEFT = new Groupsprite_GroupRender(clearing_tree_walls_LEFT);
            clearing_wall_tree_random_LEFT.setPosition(-100, -100);
            clearing_wall_tree_random_LEFT.setSize(150,400);
            clearing_background_sprites.add(clearing_wall_tree_random_LEFT);
            
            //TREELINE BOTTOM
            clearing_tree_walls_BOTTOM.add(world.getMisc_sprites().getTree1());
            Sprite clearing_wall_tree_random_BOTTOM = new Groupsprite_GroupRender(clearing_tree_walls_BOTTOM);
            clearing_wall_tree_random_BOTTOM.setPosition(0,300);
            clearing_wall_tree_random_BOTTOM.setSize(800,100);
            clearing_background_sprites.add(clearing_wall_tree_random_BOTTOM);
            
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| MISC |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
          
            //PATHWAY
            clearing_pathway_sprites.add(world.getGround_sprite().getCobblestone_light());
            Sprite clearing_group_pathway = new Groupsprite_random(clearing_pathway_sprites);
            clearing_group_pathway.setPosition(205, 86);
            clearing_group_pathway.setSize(64, 128);
            clearing_background_sprites.add(clearing_group_pathway);
            
        
            //EXIT
            Sprite exit = world.getMisc_sprites().getClearingExit();
            exit.setPosition(222,50);
            clearing_background_sprites.add(exit);
            
            //RUIN PILLARS
            //#1
            Sprite ruins1 = world.getMisc_sprites().getRuins_pillar_1();
            ruins1.setPosition(450,40);
            ruins1.setBoundary(new Rectangle2D(ruins1.getPositionX()+126,ruins1.getPositionY()+66,ruins1.getWidth(),ruins1.getHeight()));
            clearing_background_sprites.add(ruins1);
            //#2
            Sprite ruins2 = world.getMisc_sprites().getBoulder_dark_large();
            ruins2.setPosition(440,250);
            clearing_background_sprites.add(ruins2);
            //#3
            Sprite ruins3 = world.getMisc_sprites().getRuins_pillar_3();
            ruins3.setPosition(610,200);
            clearing_background_sprites.add(ruins3);
            //#4
            Sprite ruins4 = world.getMisc_sprites().getRuins_pillar_2();
            ruins4.setPosition(610,40);
            clearing_background_sprites.add(ruins4);
       
            //ENEMY
            Sprite unicorn = world.getMisc_sprites().getUnicorner();
            unicorn.setPosition(500,100);
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

    public List<Sprite> getClearing_background_sprites(){
       return clearing_background_sprites; 
    }
    public List<Sprite> getClearing_foreground_sprites(){
        return clearing_foreground_sprites;
    }

}
