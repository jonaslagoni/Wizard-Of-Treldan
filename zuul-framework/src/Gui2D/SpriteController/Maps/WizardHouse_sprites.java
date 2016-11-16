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
 * @author Mads
 */
public class WizardHouse_sprites{
    private SpriteController world;
    
    private List<Sprite> spriteList;
    
    public WizardHouse_sprites(SpriteController world){
        this.world = world;
        this.spriteList = new ArrayList();
    }
    
    public void setWizardHouse_background_SingleSprites(){
        
        // START OF WIZARDHOUSE BACKGROUND
        
        List<SingleSprite> wizardHouseFloorList = new ArrayList();
        wizardHouseFloorList.add(world.getGround_sprite().getWood_dark());
        
        Sprite wizardHouseFloor = new Groupsprite_random(wizardHouseFloorList);
        wizardHouseFloor.setSize(512, 256);
        wizardHouseFloor.setPosition(256, 128);
        spriteList.add(wizardHouseFloor);
        
        // END OF WIZARDHOUSE BACKGROUND
        
        // START OF MISC ITEMS
        
        Sprite wizardBed = world.getMisc_sprites().getNice_Bed_FacingDown();
        wizardBed.setSize(48, 81);
        wizardBed.setPosition(720, 300);
        spriteList.add(wizardBed);
        
        Sprite alchemyTable = world.getMisc_sprites().getAlchemy_Table();
        alchemyTable.setSize(64, 60);
        alchemyTable.setPosition(260, 100);
        spriteList.add(alchemyTable);
        
        Sprite exitWizardHouse = world.getMisc_sprites().getDoor_wood();
        exitWizardHouse.setSize(32, 48);
        exitWizardHouse.setPosition(512, 80);
        spriteList.add(exitWizardHouse);
        
        Sprite chest = world.getMisc_sprites().getChestClosed();
        chest.setSize(32, 32);
        chest.setPosition(736, 128);
        spriteList.add(chest);
        
        Sprite treeBundle = world.getMisc_sprites().getTree_Bundle();
        treeBundle.setSize(52, 55);
        treeBundle.setPosition(260, 325);
        spriteList.add(treeBundle);
        
        Sprite sacks = world.getMisc_sprites().getSacks_1();
        sacks.setSize(64, 63);
        sacks.setPosition(320, 320);
        spriteList.add(sacks);
        
        Sprite bookShelf6 = world.getMisc_sprites().getBookShelf_1();
        bookShelf6.setSize(64, 69);
        bookShelf6.setPosition(660, 83);
        spriteList.add(bookShelf6);
        
        Sprite bookShelf5 = world.getMisc_sprites().getBookShelf_1();
        bookShelf5.setSize(64, 69);
        bookShelf5.setPosition(625, 83);
        spriteList.add(bookShelf5);
        
        Sprite bookShelf4 = world.getMisc_sprites().getBookShelf_1();
        bookShelf4.setSize(64, 69);
        bookShelf4.setPosition(590, 83);
        spriteList.add(bookShelf4);
        
        Sprite bookShelf3 = world.getMisc_sprites().getBookShelf_1();
        bookShelf3.setSize(64, 69);
        bookShelf3.setPosition(555, 83);
        spriteList.add(bookShelf3);
        
        Sprite bookShelf2 = world.getMisc_sprites().getBookShelf_1();
        bookShelf2.setSize(64, 69);
        bookShelf2.setPosition(416, 83);
        spriteList.add(bookShelf2);
        
        Sprite bookShelf1 = world.getMisc_sprites().getBookShelf_1();
        bookShelf1.setSize(64, 69);
        bookShelf1.setPosition(352, 83);
        spriteList.add(bookShelf1);
        
        // END OF MISC ITEMS
        
    }

    public List<Sprite> getSpriteList() {
        return spriteList;
    }
    
}
