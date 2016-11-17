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
 * @author Mads
 */
public class EvilWizardsLair_sprites{
    private SpriteController world;
    
    private List<Sprite> spriteList;
    private List<Sprite> spriteList_foreground;
    
    public EvilWizardsLair_sprites(SpriteController world){
        this.world = world;
        this.spriteList = new ArrayList();
        this.spriteList_foreground = new ArrayList();
    }
    
    public void setEvilWizardsLair_background_SingleSprites(){
        
        List<SingleSprite> backgroundLava = new ArrayList();
        backgroundLava.add(world.getGround_sprite().getLava_1());
        backgroundLava.add(world.getGround_sprite().getLava_2());
        Sprite backgroundCastleLava = new Groupsprite_random(backgroundLava);
        backgroundCastleLava.setSize(1024, 512);
        backgroundCastleLava.setPosition(0, 0);
        spriteList.add(backgroundCastleLava);
        
        List<SingleSprite> backgroundCastleFloorList = new ArrayList();
        backgroundCastleFloorList.add(world.getGround_sprite().getStone_floor_1());
        backgroundCastleFloorList.add(world.getGround_sprite().getStone_floor_2());
        backgroundCastleFloorList.add(world.getGround_sprite().getStone_floor_3());
        Sprite backgroundCastleFloor = new Groupsprite_random(backgroundCastleFloorList);
        backgroundCastleFloor.setSize(100,400);
        backgroundCastleFloor.setPosition(478, 200);
        spriteList.add(backgroundCastleFloor);
        
        //STAGE
        Sprite stage = world.getMisc_sprites().getEvilWizardsLair_Stage();
        stage.setPosition(430,50);
        spriteList_foreground.add(stage);
        
        //STAIRS
        Sprite stair = world.getMisc_sprites().getStairs_stone();
        stair.setPosition(480,190);
        spriteList_foreground.add(stair);
        
        //ENEMY DUDE
        Sprite enemy = world.getMisc_sprites().getWizard_evil_battle();
        enemy.setPosition(450,25);
        spriteList_foreground.add(enemy);
        
        
        // MISC ITEMS START
        
        
        
    }

    public List<Sprite> getSpriteList() {
        return spriteList;
    }
    
    public List<Sprite> getSpriteList_Foreground(){
        return spriteList_foreground;
    }
    
    
}
