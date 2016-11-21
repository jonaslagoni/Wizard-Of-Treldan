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
import javafx.geometry.Rectangle2D;

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
            
        //lava floor 0 
        List<SingleSprite> backgroundLava = new ArrayList();
        backgroundLava.add(world.getGround_sprite().getLava_1());
        backgroundLava.add(world.getGround_sprite().getLava_2());
        Sprite backgroundCastleLava = new Groupsprite_random(backgroundLava);
        backgroundCastleLava.setSize(1024, 512);
        backgroundCastleLava.setPosition(0, 0);
        spriteList.add(backgroundCastleLava);
        
        //floor 1
        List<SingleSprite> backgroundCastleFloorList = new ArrayList();
        backgroundCastleFloorList.add(world.getGround_sprite().getStone_floor_1());
        backgroundCastleFloorList.add(world.getGround_sprite().getStone_floor_2());
        backgroundCastleFloorList.add(world.getGround_sprite().getStone_floor_3());
        Sprite backgroundCastleFloor = new Groupsprite_random(backgroundCastleFloorList);
        backgroundCastleFloor.setSize(100,400);
        backgroundCastleFloor.setPosition(478, 200);
        spriteList.add(backgroundCastleFloor);
        
        //floor 2
        List<SingleSprite> backgroundCastleFloorList2 = new ArrayList();
        backgroundCastleFloorList2.add(world.getGround_sprite().getStone_floor_1());
        backgroundCastleFloorList2.add(world.getGround_sprite().getStone_floor_2());
        backgroundCastleFloorList2.add(world.getGround_sprite().getStone_floor_3());
        Sprite backgroundCastleFloor2 = new Groupsprite_random(backgroundCastleFloorList2);
        backgroundCastleFloor2.setSize(400,70);
        backgroundCastleFloor2.setPosition(100, 105);
        spriteList.add(backgroundCastleFloor2);
        
        //floor 3
        List<SingleSprite> backgroundCastleFloorList3 = new ArrayList();
        backgroundCastleFloorList3.add(world.getGround_sprite().getStone_floor_1());
        backgroundCastleFloorList3.add(world.getGround_sprite().getStone_floor_2());
        backgroundCastleFloorList3.add(world.getGround_sprite().getStone_floor_3());
        Sprite backgroundCastleFloor3 = new Groupsprite_random(backgroundCastleFloorList3);
        backgroundCastleFloor3.setSize(300,70);
        backgroundCastleFloor3.setPosition(600, 105);
        spriteList.add(backgroundCastleFloor3);
        
        //STAGE 1
        Sprite stage = world.getMisc_sprites().getEvilWizardsLair_Stage();
        stage.setPosition(435,50);
        spriteList_foreground.add(stage);
        
        //STAGE 2
        Sprite stage2 = world.getMisc_sprites().getEvilWizardsLair_Stage();
        stage2.setPosition(50, 50);
        spriteList_foreground.add(stage2);
        
        //STAGE 3
        Sprite stage3 = world.getMisc_sprites().getEvilWizardsLair_Stage();
        stage3.setPosition(800,50);
        spriteList_foreground.add(stage3);
        
        //STAIRS
        Sprite stair = world.getMisc_sprites().getStairs_stone();
        stair.setPosition(480,190);
        spriteList_foreground.add(stair);
        
        //ENEMY DUDE 1   #4
        Sprite enemy = world.getMisc_sprites().getWizard_evil();
        enemy.setPosition(485,25);
        enemy.setBoundary(new Rectangle2D(enemy.getPositionX(),enemy.getPositionY(),enemy.getWidth(),enemy.getHeight()));
        spriteList_foreground.add(enemy);
        
        //abbaration 1   #5
        Sprite minion1 = world.getMisc_sprites().getEnemy_abbaration();
        minion1.setPosition(115,40);
        minion1.setBoundary(new Rectangle2D(minion1.getPositionX(),minion1.getPositionY(),minion1.getWidth(),minion1.getHeight()));
        spriteList_foreground.add(minion1);
        
        //abbaration 2   #6
        Sprite minion2 = world.getMisc_sprites().getEnemy_abbaration();
        minion2.setPosition(865, 40);
         minion2.setBoundary(new Rectangle2D(minion2.getPositionX(),minion2.getPositionY(),minion2.getWidth(),minion2.getHeight()));
        spriteList_foreground.add(minion2);
        
        // MISC ITEMS START 
        Sprite pillar1 = world.getMisc_sprites().getLava_pillar_3();
        pillar1.setPosition(300,15);
        spriteList.add(pillar1);
        
        Sprite pillar2 = world.getMisc_sprites().getLava_pillar_3();
        pillar2.setPosition(100,300);
        spriteList.add(pillar2);

        Sprite pillar3 = world.getMisc_sprites().getLava_pillar_3();
        pillar3.setPosition(600,400);
        spriteList.add(pillar3);

        Sprite pillar4 = world.getMisc_sprites().getLava_pillar_3();
        pillar4.setPosition(200,400);
        spriteList.add(pillar4);

        Sprite pillar5 = world.getMisc_sprites().getLava_pillar_3();
        pillar5.setPosition(300,240);
        spriteList.add(pillar5);

        Sprite pillar6 = world.getMisc_sprites().getLava_pillar_3();
        pillar6.setPosition(760,200);
        spriteList.add(pillar6);

        Sprite pillar7 = world.getMisc_sprites().getLava_pillar_3();
        pillar7.setPosition(900,400);
        spriteList.add(pillar7);

        Sprite pillar8 = world.getMisc_sprites().getLava_pillar_2();
        pillar8.setPosition(850,250);
        spriteList.add(pillar8);
       
      
        
       
        
    }

    public List<Sprite> getSpriteList() {
        return spriteList;
    }
    
    public List<Sprite> getSpriteList_Foreground(){
        return spriteList_foreground;
    }
    
    
}
