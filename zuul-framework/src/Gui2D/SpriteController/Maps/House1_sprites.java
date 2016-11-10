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
public class House1_sprites{
    private SpriteController world;
    private List<Sprite> house;
    
    public House1_sprites(SpriteController world){
        this.world = world;
       house = new ArrayList();
    }
    public void setHouse1_background_SingleSprites(){
        house.add(world.getMisc_sprites().getBed_hay());
        Sprite door = world.getMisc_sprites().getDoor_metal();
        door.setPosition(343, 89);
        house.add(door);
        
        List<Sprite> grrr = new ArrayList();
        house.add(world.getStructure_sprites().getStone_wall_N());
        
        
       List<SingleSprite> woof = new ArrayList();
       woof.add(world.getGround_sprite().getGrass_dark_1());
       woof.add(world.getGround_sprite().getGrass_dark_2());
       Sprite random = new Groupsprite_random(woof);
       random.setSize(1000, 400);
       random.setPosition(260, 70);
       house.add(random);
    }
    
        public List getHouse(){
        return house;
    }
            

    /**
     * @return the cellar_background_sprites
     */
    
}
