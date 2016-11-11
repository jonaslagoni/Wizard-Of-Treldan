/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.Maps;

import Gui2D.SpriteController.GroupSprites.Groupsprite_random;
import Gui2D.SpriteController.GroupSprites.Groupsprite_GroupRender;
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
        roadMain.setPosition(0, 190);
        spriteList.add(roadMain);
        
        List<SingleSprite> roadWizardHouseList = new ArrayList();
        roadWizardHouseList.add(world.getGround_sprite().getStone_dark_3());
        
        Sprite roadWizardHouse = new Groupsprite_random(roadWizardHouseList);
        
        roadWizardHouse.setSize(96, 160);
        roadWizardHouse.setPosition(190, 286);
        spriteList.add(roadWizardHouse);
        
        List<SingleSprite> roadWizardHouseList2 = new ArrayList();
        roadWizardHouseList2.add(world.getGround_sprite().getStone_dark_3());
        
        Sprite roadWizardHouse2 = new Groupsprite_random(roadWizardHouseList2);
        
        roadWizardHouse2.setSize(64, 64);
        roadWizardHouse2.setPosition(285, 382);
        spriteList.add(roadWizardHouse2);
        
        List<SingleSprite> roadClearingList = new ArrayList();
        roadClearingList.add(world.getGround_sprite().getStone_dark_3());
        
        Sprite roadClearing = new Groupsprite_random(roadClearingList);
        
        roadClearing.setSize(96, 256);
        roadClearing.setPosition(672, 286);
        spriteList.add(roadClearing);
        
        // END OF ROADS
        
        // START OF MISC ITEMS
        
        List<SingleSprite> bushRow1List = new ArrayList();
        bushRow1List.add(world.getMisc_sprites().getBush());
        
        Sprite bushRow1 = new Groupsprite_random(bushRow1List);
        
        bushRow1.setSize(188, 80);
        bushRow1.setPosition(0, 270);
        spriteList.add(bushRow1);
        
        List<SingleSprite> bushRow2List = new ArrayList();
        bushRow2List.add(world.getMisc_sprites().getBush());
        
        Sprite bushRow2 = new Groupsprite_random(bushRow2List);
        
        bushRow2.setSize(376, 80);
        bushRow2.setPosition(290, 270);
        spriteList.add(bushRow2);
        
        // CAVE ENTRANCE START
        
        Sprite bushCaveEntrance5 = world.getMisc_sprites().getBush();
        bushCaveEntrance5.setPosition(678, -36);
        spriteList.add(bushCaveEntrance5);
        
        Sprite bushCaveEntrance4 = world.getMisc_sprites().getBush();
        bushCaveEntrance4.setPosition(678, -6);
        spriteList.add(bushCaveEntrance4);
        
        Sprite bushCaveEntrance3 = world.getMisc_sprites().getBush();
        bushCaveEntrance3.setPosition(678, 24);
        spriteList.add(bushCaveEntrance3);
        
        
        Sprite bushCaveEntrance2 = world.getMisc_sprites().getBush();
        bushCaveEntrance2.setPosition(678, 54);
        spriteList.add(bushCaveEntrance2);
        
        Sprite bushCaveEntrance1 = world.getMisc_sprites().getBush();
        bushCaveEntrance1.setPosition(678, 84);
        spriteList.add(bushCaveEntrance1);
        
        Sprite caveEntrance = world.getMisc_sprites().getBushExit();
        caveEntrance.setPosition(678, 114);
        spriteList.add(caveEntrance);
        
        // CAVE ENTRANCE END
        
        List<SingleSprite> forestBigTreeStumpList = new ArrayList();
        forestBigTreeStumpList.add(world.getMisc_sprites().getBig_Tree_Stump());
        
        Sprite forestBigTreeStump = new Groupsprite_random(forestBigTreeStumpList);
        
        forestBigTreeStump.setSize(150, 41);
        forestBigTreeStump.setPosition(190, 445);
        spriteList.add(forestBigTreeStump);
        
        Sprite forest1 = new Groupsprite_GroupRender(world.getMisc_sprites().getTree1());
        forest1.setPosition(-60, -155);
        forest1.setSize(730, 210);
        spriteList.add(forest1);
            
        Sprite forest2 = new Groupsprite_GroupRender(world.getMisc_sprites().getTree1());
        forest2.setPosition(740, -140);
        forest2.setSize(350, 600);
        spriteList.add(forest2);
        
        // END OF MISC ITEMS
        
        // START OF INTERACTABLE ITEMS
        
        Sprite mushroom1 = world.getMisc_sprites().getRed_mushroom();
        mushroom1.setPosition(290, 350);
        spriteList.add(mushroom1);
        
        // END OF INTERACTABLE ITEMS
       
        
    }

    public List<Sprite> getSpriteList() {
        return spriteList;
    }
    
}
