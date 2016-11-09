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
public class Forest_sprites{
    private SpriteController world;
    
    private List<Sprite> spriteList;
    
    public Forest_sprites(SpriteController world){
        this.world = world;
        this.spriteList = new ArrayList();
    }
    
    public void setForest_background_SingleSprites(){
        
        // Reference START
        
        spriteList.add(world.getMisc_sprites().getHay_bed());
        
        Sprite door = world.getMisc_sprites().getDoor_metal();
        door.setPosition(100, 200);
        spriteList.add(door);
        
        Sprite nWall = world.getStructure_sprites().getStone_wall_N();
        nWall.setPosition(500, 250);
        spriteList.add(nWall);
        
        Sprite eWall = world.getStructure_sprites().getStone_wall_E();
        eWall.setPosition(530, 350);
        spriteList.add(eWall);
        
        Sprite neWall = world.getStructure_sprites().getStone_wall_NE();
        neWall.setPosition(520, 200);
        spriteList.add(neWall);
        
        
        // Reference END
        
        Sprite roadPIECE1 = world.getGround_sprite().getStone_light_3();
        roadPIECE1.setPosition(400, 100);
        spriteList.add(roadPIECE1);
        
        List<SingleSprite> roadList = new ArrayList();
        roadList.add(world.getGround_sprite().getStone_dark_1());
        roadList.add(world.getGround_sprite().getStone_dark_1());
        
        Sprite randomRoad1 = new Groupsprite_random(roadList);
        
        randomRoad1.setSize(96, 96);
        randomRoad1.setPosition(190, 0);
        spriteList.add(randomRoad1);
        
        Sprite bush1 = world.getMisc_sprites().getBush();
        bush1.setPosition(500, 100);
        spriteList.add(bush1);
    }

    public List<Sprite> getSpriteList() {
        return spriteList;
    }
    
}
