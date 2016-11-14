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
        
        roadWizardHouse.setSize(96, 256);
        roadWizardHouse.setPosition(190, 286);
        spriteList.add(roadWizardHouse);
        
        List<SingleSprite> roadWizardHouseList2 = new ArrayList();
        roadWizardHouseList2.add(world.getGround_sprite().getStone_dark_3());
        
        Sprite roadWizardHouse2 = new Groupsprite_random(roadWizardHouseList2);
        
        roadWizardHouse2.setSize(224, 64);
        roadWizardHouse2.setPosition(285, 450);
        spriteList.add(roadWizardHouse2);
        
        List<SingleSprite> roadClearingList = new ArrayList();
        roadClearingList.add(world.getGround_sprite().getStone_dark_3());
        
        Sprite roadClearing = new Groupsprite_random(roadClearingList);
        
        roadClearing.setSize(96, 256);
        roadClearing.setPosition(672, 286);
        spriteList.add(roadClearing);
        
        List<SingleSprite> roadCaveList = new ArrayList();
        roadCaveList.add(world.getGround_sprite().getStone_dark_3());
        
        Sprite roadCave = new Groupsprite_random(roadCaveList);
        
        roadCave.setSize(96, 256);
        roadCave.setPosition(672, 30);
        spriteList.add(roadCave);
        
        // END OF ROADS
        
        // CAVE ENTRANCE START
        
        List<SingleSprite> caveEntranceWallList = new ArrayList();
        caveEntranceWallList.add(world.getMisc_sprites().getRock_Wall_Front());
        
        Sprite caveEntranceWall = new Groupsprite_random(caveEntranceWallList);
        caveEntranceWall.setSize(129, 65);
        caveEntranceWall.setPosition(670, -10);
        spriteList.add(caveEntranceWall);
        
        Sprite caveEntrance = world.getMisc_sprites().getCaveExit();
        caveEntrance.setSize(32, 43);
        caveEntrance.setPosition(710, 12);
        spriteList.add(caveEntrance);
        
        // CAVE ENTRANCE END
        
        // TREE BACKGROUND START
        
        Sprite forest1 = new Groupsprite_GroupRender(world.getMisc_sprites().getTree1());
        forest1.setPosition(-60, -155);
        forest1.setSize(730, 210);
        spriteList.add(forest1);
            
        Sprite forest2 = new Groupsprite_GroupRender(world.getMisc_sprites().getTree1());
        forest2.setPosition(740, -140);
        forest2.setSize(350, 600);
        spriteList.add(forest2);
        
        // TREE BACKGROUND END
        
        // START OF MISC ITEMS
        
        List<SingleSprite> bushRowList = new ArrayList();
        bushRowList.add(world.getMisc_sprites().getBush());
        
        Sprite bushRow = new Groupsprite_random(bushRowList);
        bushRow.setSize(94, 240);
        bushRow.setPosition(540, 270);
        spriteList.add(bushRow);
        
        List<SingleSprite> treeList = new ArrayList();
        treeList.add(world.getMisc_sprites().getTree2());
        
        Sprite tree1 = new Groupsprite_random(treeList);
        tree1.setSize(190, 234);
        tree1.setPosition(0, 265);
        spriteList.add(tree1);
        
        Sprite wizardHouse = world.getMisc_sprites().getWizardHouse();
        wizardHouse.setSize(239, 289);
        wizardHouse.setPosition(297, 163);
        spriteList.add(wizardHouse);
        
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
