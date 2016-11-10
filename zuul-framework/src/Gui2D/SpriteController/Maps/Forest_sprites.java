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
        roadMain.setPosition(190, 0);
        spriteList.add(roadMain);
        
        List<SingleSprite> roadWizardHouseList = new ArrayList();
        roadWizardHouseList.add(world.getGround_sprite().getStone_dark_3());
        
        Sprite roadWizardHouse = new Groupsprite_random(roadWizardHouseList);
        
        roadWizardHouse.setSize(96, 160);
        roadWizardHouse.setPosition(286, 190);
        spriteList.add(roadWizardHouse);
        
        List<SingleSprite> roadWizardHouseList2 = new ArrayList();
        roadWizardHouseList2.add(world.getGround_sprite().getStone_dark_3());
        
        Sprite roadWizardHouse2 = new Groupsprite_random(roadWizardHouseList2);
        
        roadWizardHouse2.setSize(64, 64);
        roadWizardHouse2.setPosition(382, 285);
        spriteList.add(roadWizardHouse2);
        
        List<SingleSprite> roadClearingList = new ArrayList();
        roadClearingList.add(world.getGround_sprite().getStone_dark_3());
        
        Sprite roadClearing = new Groupsprite_random(roadClearingList);
        
        roadClearing.setSize(96, 256);
        roadClearing.setPosition(286, 672);
        spriteList.add(roadClearing);
        
        // END OF ROADS
        
        // START OF MISC ITEMS
        
        List<SingleSprite> bushRow1List = new ArrayList();
        bushRow1List.add(world.getMisc_sprites().getBush());
        
        Sprite bushRow1 = new Groupsprite_random(bushRow1List);
        
        bushRow1.setSize(188, 80);
        bushRow1.setPosition(270, 0);
        spriteList.add(bushRow1);
        
        List<SingleSprite> bushRow2List = new ArrayList();
        bushRow2List.add(world.getMisc_sprites().getBush());
        
        Sprite bushRow2 = new Groupsprite_random(bushRow2List);
        
        bushRow2.setSize(376, 80);
        bushRow2.setPosition(270, 290);
        spriteList.add(bushRow2);
        
        Sprite caveEntrance = world.getMisc_sprites().getCaveExit();
        caveEntrance.setPosition(704, 148);
        spriteList.add(caveEntrance);
        
        List<SingleSprite> forestBigTreeStumpList = new ArrayList();
        forestBigTreeStumpList.add(world.getMisc_sprites().getBig_Tree_Stump());
        
        Sprite forestBigTreeStump = new Groupsprite_random(forestBigTreeStumpList);
        
        forestBigTreeStump.setSize(150, 41);
        forestBigTreeStump.setPosition(445, 190);
        spriteList.add(forestBigTreeStump);
        
        Sprite forest1 = new Groupsprite_GroupRender(world.getMisc_sprites().getTree1());
        forest1.setPosition(-100, -154);
        forest1.setSize(650, 200);
        spriteList.add(forest1);
            
        Sprite forest2 = new Groupsprite_GroupRender(world.getMisc_sprites().getTree1());
        forest2.setPosition(720, -140);
        forest2.setSize(225, 600);
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
