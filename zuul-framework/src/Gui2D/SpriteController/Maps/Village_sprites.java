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

/**
 *
 * @author jonas
 */
public class Village_sprites{
    private SpriteController world;
    //list of sprites
    private List<Sprite> village_background_sprites;
    private List<Sprite> village_foreground_sprites;
    private List<Sprite> village_items;
    //lists of sprites
    private List<SingleSprite> village_background_ground;
    private final List<SingleSprite> village_background_grass;
    private final List<SingleSprite> village_background_trees;
    private final List<SingleSprite> village_walls;
    
    
    /**
     * Inits the lists
     * @param world 
     */
    public Village_sprites(SpriteController world){
        this.world = world;
        //initialize the arraylists();
        village_background_sprites = new ArrayList();
        village_foreground_sprites = new ArrayList();
        village_items = new ArrayList();
        village_background_ground = new ArrayList();
        village_background_grass = new ArrayList();
        village_background_trees = new ArrayList();
        village_walls = new ArrayList();
 
    }
    
    /**
     * Add sprites to the lists
     */
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
        village_background_grass.add(world.getGround_sprite().getGrass_dark_1());
        village_background_grass.add(world.getGround_sprite().getGrass_dark_2());
        village_background_grass.add(world.getGround_sprite().getGrass_dark_3());
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
        
        //animals
        Sprite animals = world.getMisc_sprites().getVillageAnimals();
        animals.setPosition(550, 64);
        village_background_sprites.add(animals);
        
        village_background_trees.add(world.getMisc_sprites().getTree1());
        Sprite village_tree_random = new Groupsprite_GroupRender(village_background_trees);
        village_tree_random.setSize(100,100);
        village_tree_random.setPosition(720, 10);
        village_tree_random.setBoundary(new Rectangle2D(village_tree_random.getPositionX(), village_tree_random.getPositionY(), village_tree_random.getWidth()+20, village_tree_random.getHeight()+130));
        village_background_sprites.add(village_tree_random);
        
        village_background_trees.add(world.getMisc_sprites().getTree1());
        Sprite village_tree_random2 = new Groupsprite_GroupRender(village_background_trees);
        village_tree_random2.setSize(100,100);
        village_tree_random2.setPosition(150, 10);
        village_tree_random2.setBoundary(new Rectangle2D(village_tree_random2.getPositionX(), village_tree_random2.getPositionY(), village_tree_random2.getWidth()+20, village_tree_random2.getHeight()+130));
        village_background_sprites.add(village_tree_random2);
        
 
        //village houses
        //#1
        Sprite house1 = world.getMisc_sprites().getHouse1();
        house1.setPosition(25, -10);
        house1.setBoundary(new Rectangle2D(house1.getPositionX(), house1.getPositionY(), house1.getWidth(), house1.getHeight()-50));
        village_background_sprites.add(house1);
        //#2
        Sprite house2 = world.getMisc_sprites().getHouse2();
        house2.setPosition(250,-40);
        house2.setBoundary(new Rectangle2D(house2.getPositionX(), house2.getPositionY(), house2.getWidth(), house2.getHeight()));
        village_background_sprites.add(house2);
        //#3
        Sprite house3 = world.getMisc_sprites().getHouse3();
        house3.setPosition(832,-5);
        house3.setBoundary(new Rectangle2D(house3.getPositionX(), house3.getPositionY(), house3.getWidth(), house3.getHeight()));
        village_background_sprites.add(house3);
        
        //set well
        Sprite well = world.getMisc_sprites().getWell();
        well.setPosition(300, 360);
        well.setBoundary(new Rectangle2D(well.getPositionX()+5, well.getPositionY()+well.getHeight()-50, well.getWidth()-20, 50));
        village_foreground_sprites.add(well);
        
        
        //axe
        Sprite axe = world.getMisc_sprites().getAxe();
        axe.setPosition(600, 220);
        village_items.add(axe);
        
        //guard
        Sprite guard = world.getMisc_sprites().getGuard();
        guard.setPosition(450, 30);
        village_background_sprites.add(guard);
        
        
        //entrance to house 1,2,3
        Sprite house1_exit = world.getMisc_sprites().getDoor_wood();
        house1_exit.setPosition(127,180);
        village_background_sprites.add(house1_exit);
        Sprite house2_exit = world.getMisc_sprites().getDoor_wood();
        house2_exit.setPosition(300,150);
        village_background_sprites.add(house2_exit);
        Sprite house3_exit = world.getMisc_sprites().getDoor_metal();
        house3_exit.setPosition(950,188);
        village_background_sprites.add(house3_exit);
        
        //exit to forest
        Sprite village_exit = world.getMisc_sprites().getDoor_metal();
        village_exit.setPosition(500,20);
        village_background_sprites.add(village_exit);
        
        //lampposts
        //#1
        Sprite lamp1_part1 = world.getMisc_sprites().getLamppost_part1();
        lamp1_part1.setPosition(250, 200+70);
        lamp1_part1.setBoundary(new Rectangle2D(lamp1_part1.getPositionX()+5, lamp1_part1.getPositionY(), lamp1_part1.getWidth()-10, lamp1_part1.getHeight()));
        village_background_sprites.add(lamp1_part1);
        Sprite lamp1_part2 = world.getMisc_sprites().getLamppost_part2();
        lamp1_part2.setPosition(250, 200);
        village_foreground_sprites.add(lamp1_part2);
        //#2
        Sprite lamp2_part1 = world.getMisc_sprites().getLamppost_part1();
        lamp2_part1.setPosition(45, 200+70);
        lamp2_part1.setBoundary(new Rectangle2D(lamp2_part1.getPositionX()+5, lamp2_part1.getPositionY(), lamp2_part1.getWidth()-10, lamp2_part1.getHeight()));
        village_background_sprites.add(lamp2_part1);
        Sprite lamp2_part2 = world.getMisc_sprites().getLamppost_part2();
        lamp2_part2.setPosition(45, 200);
        village_foreground_sprites.add(lamp2_part2);
        //#3
        Sprite lamp3_part1 = world.getMisc_sprites().getLamppost_part1();
        lamp3_part1.setPosition(460, 200+70);
        lamp3_part1.setBoundary(new Rectangle2D(lamp3_part1.getPositionX()+5, lamp3_part1.getPositionY(), lamp3_part1.getWidth()-10, lamp3_part1.getHeight()));
        village_background_sprites.add(lamp3_part1);
        Sprite lamp3_part2 = world.getMisc_sprites().getLamppost_part2();
        lamp3_part2.setPosition(460, 200);
        village_foreground_sprites.add(lamp3_part2);
        //#4
        Sprite lamp4_part1 = world.getMisc_sprites().getLamppost_part1();
        lamp4_part1.setPosition(550, 200+70);
        lamp4_part1.setBoundary(new Rectangle2D(lamp4_part1.getPositionX()+5, lamp4_part1.getPositionY(), lamp4_part1.getWidth()-10, lamp4_part1.getHeight()));
        village_background_sprites.add(lamp4_part1);
        Sprite lamp4_part2 = world.getMisc_sprites().getLamppost_part2();
        lamp4_part2.setPosition(550, 200);
        village_foreground_sprites.add(lamp4_part2);
        //#5
        Sprite lamp5_part1 = world.getMisc_sprites().getLamppost_part1();
        lamp5_part1.setPosition(750, 200+70);
        lamp5_part1.setBoundary(new Rectangle2D(lamp5_part1.getPositionX()+5, lamp5_part1.getPositionY(), lamp5_part1.getWidth()-10, lamp5_part1.getHeight()));
        village_background_sprites.add(lamp5_part1);
        Sprite lamp5_part2 = world.getMisc_sprites().getLamppost_part2();
        lamp5_part2.setPosition(750, 200);
        village_foreground_sprites.add(lamp5_part2);
        
        //messageboard
        Sprite board = world.getMisc_sprites().getVillage_MessageBoard();
        board.setPosition(400, 250);
        village_background_sprites.add(board);
        
        //dead body
        Sprite body1 = world.getMisc_sprites().getBlood_bodydead();
        body1.setPosition(300, 300);
        village_background_sprites.add(body1);
        
        Sprite blood6 = world.getMisc_sprites().getBlood2();
        blood6.setPosition(700, 240);
        village_background_sprites.add(blood6);
        
        //dead body2
        Sprite body2 = world.getMisc_sprites().getBlood_bodyparts_leg();
        body2.setPosition(700, 240);
        village_background_sprites.add(body2);
        
        Sprite blood7 = world.getMisc_sprites().getBlood2();
        blood7.setPosition(860, 255);
        village_background_sprites.add(blood7);
        
        //dead body2
        Sprite body3 = world.getMisc_sprites().getBlood_bodyparts_head();
        body3.setPosition(870, 250);
        village_background_sprites.add(body3);
        
        //blood1
        Sprite blood1 = world.getMisc_sprites().getBlood3();
        blood1.setPosition(200, 240);
        village_background_sprites.add(blood1);
        
        //blood2
        Sprite blood2 = world.getMisc_sprites().getBlood1();
        blood2.setPosition(100, 350);
        village_background_sprites.add(blood2);
        
        //blood3
        Sprite blood3 = world.getMisc_sprites().getBlood2();
        blood3.setPosition(360, 320);
        village_background_sprites.add(blood3);
        
        //blood3
        Sprite blood4 = world.getMisc_sprites().getBlood3();
        blood4.setPosition(600, 290);
        village_background_sprites.add(blood4);
        
        //blood2
        Sprite blood5 = world.getMisc_sprites().getBlood1();
        blood5.setPosition(800, 400);
        village_background_sprites.add(blood5);
        
        
        
        
    }

    /**
     * @return the village_background_sprites
     */
    public List<Sprite> getVillage_background_sprites() {
        return village_background_sprites;
    }

    /**
     * @return the village_foreground_sprites
     */
    public List<Sprite> getVillage_foreground_sprites() {
        return village_foreground_sprites;
    }

    /**
     * @param village_foreground_sprites the village_foreground_sprites to set
     */
    public void setVillage_foreground_sprites(List<Sprite> village_foreground_sprites) {
        this.village_foreground_sprites = village_foreground_sprites;
    }

    /**
     * @return the village_items
     */
    public List<Sprite> getVillage_items() {
        return village_items;
    }
    
}
