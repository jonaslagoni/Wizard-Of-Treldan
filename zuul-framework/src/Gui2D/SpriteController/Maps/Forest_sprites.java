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
        
        // START OF FOREST BACKGROUND
        
        List<SingleSprite> forestBackground1List = new ArrayList();
        forestBackground1List.add(world.getGround_sprite().getGrass_light_1());
        forestBackground1List.add(world.getGround_sprite().getGrass_light_2());
        forestBackground1List.add(world.getGround_sprite().getGrass_light_3());
        
        Sprite forestBackground1 = new Groupsprite_random(forestBackground1List);
        
        forestBackground1.setSize(1024, 512);
        forestBackground1.setPosition(0, 0);
        spriteList.add(forestBackground1);
        
        // END OF FOREST BACKGROUND
        
        // START OF ROADS
        
        List<SingleSprite> mainRoadList = new ArrayList();
        mainRoadList.add(world.getGround_sprite().getStone_dark_3());
        
        Sprite roadMain = new Groupsprite_random(mainRoadList);
        
        roadMain.setSize(768, 96);
        roadMain.setPosition(190, 0);
        spriteList.add(roadMain);
        
        List<SingleSprite> roadWizardHouseList = new ArrayList();
        roadWizardHouseList.add(world.getGround_sprite().getStone_dark_3());
        
        Sprite roadWizardHouse = new Groupsprite_random(roadWizardHouseList);
        
        roadWizardHouse.setSize(96, 224);
        roadWizardHouse.setPosition(286, 190);
        spriteList.add(roadWizardHouse);
        
        List<SingleSprite> roadClearingList = new ArrayList();
        roadClearingList.add(world.getGround_sprite().getStone_dark_3());
        
        Sprite roadClearing = new Groupsprite_random(roadClearingList);
        
        roadClearing.setSize(96, 224);
        roadClearing.setPosition(286, 672);
        spriteList.add(roadClearing);
        
        List<SingleSprite> roadCaveList = new ArrayList();
        roadCaveList.add(world.getGround_sprite().getStone_dark_3());
        
        Sprite roadCave = new Groupsprite_random(roadCaveList);
        
        roadCave.setSize(96, 96);
        roadCave.setPosition(96, 672);
        spriteList.add(roadCave);
        
        Sprite roadCaveTile1 = world.getGround_sprite().getStone_dark_3();
        roadCaveTile1.setPosition(704, 64);
        spriteList.add(roadCaveTile1);
        
        Sprite roadCaveTile2 = world.getGround_sprite().getStone_dark_1();
        roadCaveTile2.setPosition(704, 32);
        spriteList.add(roadCaveTile2);
        
        // END OF ROADS
        
        // START OF MISC ITEMS
        
        List<SingleSprite> bushRow1List = new ArrayList();
        bushRow1List.add(world.getMisc_sprites().getBush());
        
        Sprite bushRow1 = new Groupsprite_random(bushRow1List);
        
        bushRow1.setSize(64, 320);
        bushRow1.setPosition(100, 770);
        spriteList.add(bushRow1);
        
        Sprite bush1 = world.getMisc_sprites().getBush();
        bush1.setPosition(500, 110);
        spriteList.add(bush1);
        
        Sprite bush2 = world.getMisc_sprites().getBush();
        bush2.setPosition(410, 110);
        spriteList.add(bush2);
        
        Sprite bushCaveEntrance1 = world.getMisc_sprites().getBush();
        bushCaveEntrance1.setPosition(615, 4);
        spriteList.add(bushCaveEntrance1);
        
        Sprite bushCaveEntrance2 = world.getMisc_sprites().getBush();
        bushCaveEntrance2.setPosition(732, 4);
        spriteList.add(bushCaveEntrance2);
        
        Sprite caveEntrance = world.getMisc_sprites().getCaveExit();
        caveEntrance.setPosition(704, 0);
        spriteList.add(caveEntrance);
        
        List<SingleSprite> forestTreeList1 = new ArrayList();
        forestTreeList1.add(world.getMisc_sprites().getTree1());
        
        Sprite forestTrees1 = new Groupsprite_random(forestTreeList1);
        
        forestTrees1.setSize(671, 128);
        forestTrees1.setPosition(40, 0);
        spriteList.add(forestTrees1);
        
        // END OF MISC ITEMS
        
    }

    public List<Sprite> getSpriteList() {
        return spriteList;
    }
    
}
