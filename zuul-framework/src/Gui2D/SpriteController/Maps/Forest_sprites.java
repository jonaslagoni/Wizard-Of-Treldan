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
import javafx.geometry.Rectangle2D;

/**
 *
 * @author jonas
 */
public class Forest_sprites{
    private SpriteController world;
    
    private List<Sprite> background_sprites;
    private List<Sprite> foreground_sprites;
    
    public Forest_sprites(SpriteController world){
        this.world = world;
        this.background_sprites = new ArrayList();
        this.foreground_sprites = new ArrayList();
    }
    
    public void setForest_background_SingleSprites(){
        
        // BOUNDRIES FOR HOUSE START
        
        List<SingleSprite> boundriesWizardHouseList = new ArrayList();
        boundriesWizardHouseList.add(world.getGround_sprite().getCastle_Stone_Floor());
        
        Sprite boundWizardHouse = new Groupsprite_random(boundriesWizardHouseList);
        boundWizardHouse.setSize(192, 128);
        boundWizardHouse.setPosition(316, 305);
        background_sprites.add(boundWizardHouse);
        
        // BOUNDRIES FOR HOUSE END
        
        // START OF FOREST BACKGROUND
        
        List<SingleSprite> forestBackground1List = new ArrayList();
        forestBackground1List.add(world.getGround_sprite().getGrass_light_1());
        forestBackground1List.add(world.getGround_sprite().getGrass_light_2());
        forestBackground1List.add(world.getGround_sprite().getGrass_light_3());
        
        Sprite forestBackground1 = new Groupsprite_random(forestBackground1List);
        
        forestBackground1.setSize(1024, 512);
        forestBackground1.setPosition(0, 0);
        background_sprites.add(forestBackground1);
        
        // END OF FOREST BACKGROUND
        
        // START OF ROADS
        
        List<SingleSprite> mainRoadList = new ArrayList();
        mainRoadList.add(world.getGround_sprite().getStone_dark_3());
        
        Sprite roadMain = new Groupsprite_random(mainRoadList);
        
        roadMain.setSize(768, 96);
        roadMain.setPosition(0, 190);
        background_sprites.add(roadMain);
        
        List<SingleSprite> roadWizardHouseList = new ArrayList();
        roadWizardHouseList.add(world.getGround_sprite().getStone_dark_3());
        
        Sprite roadWizardHouse = new Groupsprite_random(roadWizardHouseList);
        
        roadWizardHouse.setSize(96, 256);
        roadWizardHouse.setPosition(190, 286);
        background_sprites.add(roadWizardHouse);
        
        List<SingleSprite> roadWizardHouseList2 = new ArrayList();
        roadWizardHouseList2.add(world.getGround_sprite().getStone_dark_3());
        
        Sprite roadWizardHouse2 = new Groupsprite_random(roadWizardHouseList2);
        
        roadWizardHouse2.setSize(224, 64);
        roadWizardHouse2.setPosition(285, 450);
        background_sprites.add(roadWizardHouse2);
        
        List<SingleSprite> roadClearingList = new ArrayList();
        roadClearingList.add(world.getGround_sprite().getStone_dark_3());
        
        Sprite roadClearing = new Groupsprite_random(roadClearingList);
        
        roadClearing.setSize(96, 256);
        roadClearing.setPosition(672, 286);
        background_sprites.add(roadClearing);
        
        List<SingleSprite> roadCaveList = new ArrayList();
        roadCaveList.add(world.getGround_sprite().getStone_dark_3());
        
        Sprite roadCave = new Groupsprite_random(roadCaveList);
        
        roadCave.setSize(96, 256);
        roadCave.setPosition(672, 30);
        background_sprites.add(roadCave);
        
        // END OF ROADS
        
        // VILLAGE ENTRANCE START
        
        List<SingleSprite> village_entrance_trigger_List = new ArrayList();
        village_entrance_trigger_List.add(world.getGround_sprite().getCastle_Stone_Floor());
        
        Sprite village_entrance_trigger = new Groupsprite_random(village_entrance_trigger_List);
        village_entrance_trigger.setSize(32, 128);
        village_entrance_trigger.setPosition(-32, 170);
        background_sprites.add(village_entrance_trigger);
        
        // VILLAGE ENTRANCE END
        
        // CAVE ENTRANCE START
        
        List<SingleSprite> caveEntranceWallList = new ArrayList();
        caveEntranceWallList.add(world.getMisc_sprites().getRock_Wall_Front());
        
        Sprite caveEntranceWall = new Groupsprite_random(caveEntranceWallList);
        caveEntranceWall.setSize(129, 65);
        caveEntranceWall.setPosition(670, -10);
        caveEntranceWall.setBoundary(new Rectangle2D(caveEntranceWall.getPositionX(), caveEntranceWall.getPositionY() - 1, caveEntranceWall.getWidth(), caveEntranceWall.getHeight() - 1));
        background_sprites.add(caveEntranceWall);
        
        Sprite caveEntrance = world.getMisc_sprites().getCaveExit();
        caveEntrance.setSize(32, 43);
        caveEntrance.setPosition(710, 13);
        caveEntrance.setBoundary(new Rectangle2D(caveEntrance.getPositionX(), caveEntrance.getPositionY() - 1, caveEntrance.getWidth(), caveEntrance.getHeight() - 1));
        background_sprites.add(caveEntrance);
        
        // CAVE ENTRANCE END
        
        // WIZARDHOUSE ENTRANCE START
        
        List<SingleSprite> wizardHouseEntranceTriggerList = new ArrayList();
        wizardHouseEntranceTriggerList.add(world.getGround_sprite().getStone_dark_3());
        
        Sprite wizardHouseEntranceTrigger = new Groupsprite_random(wizardHouseEntranceTriggerList);
        wizardHouseEntranceTrigger.setSize(96, 32);
        wizardHouseEntranceTrigger.setPosition(385, 421);
        background_sprites.add(wizardHouseEntranceTrigger);
        
        // WIZARDHOUSE ENTRANCE END
        
        // CLEARING ENTRANCE START
        
        List<SingleSprite> clearingEntranceTriggerList = new ArrayList();
        clearingEntranceTriggerList.add(world.getGround_sprite().getCastle_Stone_Floor());
        
        Sprite clearingEntranceTrigger = new Groupsprite_random(clearingEntranceTriggerList);
        clearingEntranceTrigger.setSize(128, 32);
        clearingEntranceTrigger.setPosition(638, 512);
        background_sprites.add(clearingEntranceTrigger);
        
        // CLEARING ENTRANCE END
        
        // TREE BACKGROUND START
        
        Sprite forest1 = new Groupsprite_GroupRender(world.getMisc_sprites().getTree1());
        forest1.setPosition(-60, -155);
        forest1.setSize(730, 210);
        background_sprites.add(forest1);
            
        Sprite forest2 = new Groupsprite_GroupRender(world.getMisc_sprites().getTree1());
        forest2.setPosition(740, -140);
        forest2.setSize(350, 600);
        background_sprites.add(forest2);
        
        // TREE BACKGROUND END
        
        // START OF MISC ITEMS
        
        List<SingleSprite> bushRowList = new ArrayList();
        bushRowList.add(world.getMisc_sprites().getBush());
        
        Sprite bushRow_1 = new Groupsprite_random(bushRowList);
        bushRow_1.setSize(94, 240);
        bushRow_1.setPosition(540, 270);
        bushRow_1.setBoundary(new Rectangle2D(bushRow_1.getPositionX(), bushRow_1.getPositionY() + 15, bushRow_1.getWidth(), bushRow_1.getHeight()+ 15));
        background_sprites.add(bushRow_1);
        Sprite bushRow_2 = new Groupsprite_random(bushRowList);
        bushRow_2.setSize(94, 240);
        bushRow_2.setPosition(540, 270);
        foreground_sprites.add(bushRow_2);
        
        List<SingleSprite> treeList = new ArrayList();
        treeList.add(world.getMisc_sprites().getTree2());
        
        Sprite tree1_1 = new Groupsprite_random(treeList);
        tree1_1.setSize(190, 234);
        tree1_1.setPosition(0, 265);
        tree1_1.setBoundary(new Rectangle2D(tree1_1.getPositionX(), tree1_1.getPositionY() + 15, tree1_1.getWidth(), tree1_1.getHeight()+ 15));
        background_sprites.add(tree1_1);
        Sprite tree1_2 = new Groupsprite_random(treeList);
        tree1_2.setSize(190, 234);
        tree1_2.setPosition(0, 265);
        foreground_sprites.add(tree1_2);
        
        Sprite wizardHouse_1 = world.getMisc_sprites().getWizardHouse();
        wizardHouse_1.setPosition(297, 163);
        background_sprites.add(wizardHouse_1);
        Sprite wizardHouse_2 = world.getMisc_sprites().getWizardHouse();
        wizardHouse_2.setPosition(297, 163);
        foreground_sprites.add(wizardHouse_2);
        
        // END OF MISC ITEMS
        
        // START OF INTERACTABLE ITEMS
        
        Sprite mushroom1 = world.getMisc_sprites().getRed_mushroom();
        mushroom1.setPosition(290, 350);
        background_sprites.add(mushroom1);
        
        // END OF INTERACTABLE ITEMS
       
        
    }

    public List<Sprite> getForest_background_sprites() {
        return background_sprites;
    }
    
    public List<Sprite> getForest_foreground_sprites() {
        return foreground_sprites;
    }
    
}
