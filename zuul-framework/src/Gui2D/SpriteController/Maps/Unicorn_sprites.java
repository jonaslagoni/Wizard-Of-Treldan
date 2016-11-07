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
public class Unicorn_sprites{
    private SpriteController world;
    private List<Sprite> unicorn;
    
    
    public Unicorn_sprites(SpriteController world){
        this.world = world;
        unicorn = new ArrayList();
    }
    
    public void setUnicorn(){
        unicorn.add(world.getMisc_sprites().getHay_bed());
        
        //set single sprite position
        Sprite door = world.getMisc_sprites().getDoor_metal();
        door.setPosition(100, 100);
        unicorn.add(door);
        
        //set randomly generated group of sprites
        List<SingleSprite> ground = new ArrayList();
        ground.add(world.getGround_sprite().getGrass_light_1());
        ground.add(world.getGround_sprite().getGrass_flower_1());
        Sprite random = new Groupsprite_random(ground);
        random.setSize(1024, 400);
        random.setPosition(0,0);
        unicorn.add(random);
        
    }

    public List<Sprite> getUnicorn(){
       return unicorn; 
    }

}
