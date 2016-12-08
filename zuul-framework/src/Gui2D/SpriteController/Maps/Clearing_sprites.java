/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.Maps;

import Gui2D.SpriteController.GroupSprites.Groupsprite_GroupRender;
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
    private List<Sprite> clearing_interact;
    //lists of treeline
    private final List<SingleSprite> clearing_tree_walls_RIGHT;
    private final List<SingleSprite> clearing_tree_walls_LEFT;
    private final List<SingleSprite> clearing_tree_walls_TOP;
    private final List<SingleSprite> clearing_tree_walls_BOTTOM;
    //lists containing individual sprites   
    private final List<SingleSprite> clearing_grass_singlesprites;
    private final List<SingleSprite> clearing_ruins_singlesprites;
    private final List<SingleSprite> clearing_pathway_sprites;
    
    /**
     * Inits the arraylists
     * @param world 
     */
    public Clearing_sprites(SpriteController world){
        //initialize world + list of spritess
        this.world = world;
        clearing_background_sprites = new ArrayList();
        clearing_interact = new ArrayList();
        
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
    
    /**
     * 
     */
    public void setClearing_background_sprites(){
            //BACKGROUND GRASS 0
            clearing_grass_singlesprites.add(world.getGround_sprite().getGrass_light_1());
            clearing_grass_singlesprites.add(world.getGround_sprite().getGrass_light_2()); 
            clearing_grass_singlesprites.add(world.getGround_sprite().getGrass_flower_2());
            Sprite clearing_group_grass = new Groupsprite_random(clearing_grass_singlesprites);
            clearing_group_grass.setPosition(0, 0);
            clearing_group_grass.setSize(800, 400);
            clearing_background_sprites.add(clearing_group_grass);
            
            //RUINS FLOOR 1
            clearing_ruins_singlesprites.add(world.getGround_sprite().getStone_ruins_floor_1());
            clearing_ruins_singlesprites.add(world.getGround_sprite().getStone_ruins_floor_2());
            clearing_ruins_singlesprites.add(world.getGround_sprite().getStone_ruins_floor_3());
            Sprite clearing_group_ruins = new Groupsprite_random(clearing_ruins_singlesprites);
            clearing_group_ruins.setPosition(450, 100);
            clearing_group_ruins.setSize(200, 200);
            clearing_background_sprites.add(clearing_group_ruins);
            
            //TREELINE TOP 2
            clearing_tree_walls_TOP.add(world.getMisc_sprites().getTree1());
            Sprite clearing_wall_tree_random_TOP = new Groupsprite_GroupRender(clearing_tree_walls_TOP);
            clearing_wall_tree_random_TOP.setPosition(0,-80);
            clearing_wall_tree_random_TOP.setSize(800,30);
            clearing_background_sprites.add(clearing_wall_tree_random_TOP);
            
             //TREELINE RIGHT 3
            clearing_tree_walls_RIGHT.add(world.getMisc_sprites().getTree1());
            Sprite clearing_wall_tree_random_RIGHT = new Groupsprite_GroupRender(clearing_tree_walls_RIGHT);
            clearing_wall_tree_random_RIGHT.setPosition(650,-50);
            clearing_wall_tree_random_RIGHT.setSize(100,400);
            clearing_background_sprites.add(clearing_wall_tree_random_RIGHT);
            
            //TREELINE LEFT 4
            clearing_tree_walls_LEFT.add(world.getMisc_sprites().getTree1());
            Sprite clearing_wall_tree_random_LEFT = new Groupsprite_GroupRender(clearing_tree_walls_LEFT);
            clearing_wall_tree_random_LEFT.setPosition(-100, -100);
            clearing_wall_tree_random_LEFT.setSize(150,400);
            clearing_background_sprites.add(clearing_wall_tree_random_LEFT);
            
            //TREELINE BOTTOM 5
            clearing_tree_walls_BOTTOM.add(world.getMisc_sprites().getTree1());
            Sprite clearing_wall_tree_random_BOTTOM = new Groupsprite_GroupRender(clearing_tree_walls_BOTTOM);
            clearing_wall_tree_random_BOTTOM.setPosition(0,300);
            clearing_wall_tree_random_BOTTOM.setSize(800,100);
            clearing_background_sprites.add(clearing_wall_tree_random_BOTTOM);
            
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| MISC |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
          
            //PATHWAY 6
            clearing_pathway_sprites.add(world.getGround_sprite().getCobblestone_light());
            Sprite clearing_group_pathway = new Groupsprite_random(clearing_pathway_sprites);
            clearing_group_pathway.setPosition(205, 86);
            clearing_group_pathway.setSize(64, 128);
            clearing_background_sprites.add(clearing_group_pathway);
            
        
            //EXIT 7
            Sprite exit = world.getMisc_sprites().getClearingExit();
            exit.setPosition(222,50);
            exit.setBoundary(new Rectangle2D(exit.getPositionX()+126,exit.getPositionY()+66,exit.getWidth(),exit.getHeight()));
            clearing_background_sprites.add(exit);
            
            //RUIN PILLARS 
            //#1 8
            Sprite ruins1 = world.getMisc_sprites().getRuins_pillar_1();
            ruins1.setPosition(450,40);
            ruins1.setBoundary(new Rectangle2D(ruins1.getPositionX()+126,ruins1.getPositionY()+66,ruins1.getWidth(),ruins1.getHeight()));
            clearing_background_sprites.add(ruins1);
            //#2 9
            Sprite ruins2 = world.getMisc_sprites().getBoulder_dark_large();
            ruins2.setPosition(440,250);
            ruins2.setBoundary(new Rectangle2D(ruins2.getPositionX()+126,ruins2.getPositionY()+66,ruins2.getWidth(),ruins2.getHeight()));
            clearing_background_sprites.add(ruins2);
            //#3 10
            Sprite ruins3 = world.getMisc_sprites().getRuins_pillar_3();
            ruins3.setPosition(610,200);
            ruins3.setBoundary(new Rectangle2D(ruins3.getPositionX()+126,ruins3.getPositionY()+66,ruins3.getWidth(),ruins3.getHeight()));
            clearing_background_sprites.add(ruins3);
            //#4 11
            Sprite ruins4 = world.getMisc_sprites().getRuins_pillar_2();
            ruins4.setPosition(610,40);
            ruins4.setBoundary(new Rectangle2D(ruins4.getPositionX()+126,ruins4.getPositionY()+66,ruins4.getWidth(),ruins4.getHeight()));
            clearing_background_sprites.add(ruins4);
       
            //ENEMY 0
            Sprite unicorn = world.getMisc_sprites().getUnicorner();
            unicorn.setPosition(500,100);
            unicorn.setBoundary(new Rectangle2D(unicorn.getPositionX()+126,unicorn.getPositionY()+66,unicorn.getWidth()+126,unicorn.getHeight()+35));
            clearing_interact.add(unicorn);
            
            //tree 1
            Sprite tree = world.getMisc_sprites().getTree2();
            tree.setPosition(100,150);
            tree.setBoundary(new Rectangle2D(tree.getPositionX()+126,tree.getPositionY()+66,tree.getWidth(),tree.getHeight()));
            clearing_interact.add(tree);
            
            //tree 2 /cut
            Sprite tree_cutdown = world.getMisc_sprites().getTree_cutdown();
            tree_cutdown.setPosition(100,150);
            tree_cutdown.setBoundary(new Rectangle2D(tree_cutdown.getPositionX()+126,tree_cutdown.getPositionY()+66,tree_cutdown.getWidth(),tree_cutdown.getHeight()));
            clearing_interact.add(tree);
            
            
                 
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
    
    /**
     * @return the background sprites
     */
    public List<Sprite> getClearing_background_sprites(){
       return clearing_background_sprites; 
    }
    
    /**
     * @return the interact sprites
     */
    public List<Sprite> getClearing_interact(){
        return clearing_interact;
    }

}
