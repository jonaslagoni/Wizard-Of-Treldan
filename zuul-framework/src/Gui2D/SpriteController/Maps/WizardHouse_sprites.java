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
    
    private List<Sprite> background_sprites;
    private List<Sprite> foreground_sprites;
    
    public WizardHouse_sprites(SpriteController world){
        this.world = world;
        this.background_sprites = new ArrayList();
        this.foreground_sprites = new ArrayList();
    }
    
    public void setWizardHouse_background_SingleSprites(){
        
        // START OF WIZARDHOUSE BACKGROUND
        
        List<SingleSprite> wizardHouseFloorList = new ArrayList();
        wizardHouseFloorList.add(world.getGround_sprite().getWood_dark());
        
        Sprite wizardHouseFloor = new Groupsprite_random(wizardHouseFloorList);
        wizardHouseFloor.setSize(512, 256);
        wizardHouseFloor.setPosition(256, 128);
        background_sprites.add(wizardHouseFloor);
        
        // END OF WIZARDHOUSE BACKGROUND
        
        // START OF MISC ITEMS
        
        Sprite wizardBed = world.getMisc_sprites().getNice_Bed();
        wizardBed.setSize(48, 81);
        wizardBed.setPosition(250, 200);
        background_sprites.add(wizardBed);
        
        Sprite door = world.getMisc_sprites().getDoor_wood();
        door.setSize(32, 48);
        door.setPosition(150, 300);
        background_sprites.add(door);
        
        Sprite chest = world.getMisc_sprites().getChestClosed();
        chest.setSize(32, 32);
        chest.setPosition(300, 400);
        background_sprites.add(chest);
        
        Sprite alchemyTable = world.getMisc_sprites().getAlchemy_Table();
        alchemyTable.setSize(64, 60);
        alchemyTable.setPosition(200, 100);
        background_sprites.add(alchemyTable);
        
        Sprite treeBundle = world.getMisc_sprites().getTree_Bundle();
        treeBundle.setSize(52, 55);
        treeBundle.setPosition(500, 200);
        background_sprites.add(treeBundle);
        
        Sprite sacks = world.getMisc_sprites().getSacks_1();
        sacks.setSize(64, 63);
        sacks.setPosition(300, 100);
        background_sprites.add(sacks);
        
        Sprite bookshelf5 = world.getMisc_sprites().getBookshelf_1();
        bookshelf5.setSize(64, 69);
        bookshelf5.setPosition(250, 100);
        background_sprites.add(bookshelf5);
        
        Sprite bookshelf4 = world.getMisc_sprites().getBookshelf_1();
        bookshelf4.setSize(64, 69);
        bookshelf4.setPosition(250, 100);
        background_sprites.add(bookshelf4);
        
        Sprite bookshelf3 = world.getMisc_sprites().getBookshelf_1();
        bookshelf3.setSize(64, 69);
        bookshelf3.setPosition(250, 100);
        background_sprites.add(bookshelf3);
        
        Sprite bookshelf2 = world.getMisc_sprites().getBookshelf_1();
        bookshelf2.setSize(64, 69);
        bookshelf2.setPosition(250, 100);
        background_sprites.add(bookshelf2);
        
        Sprite bookshelf1 = world.getMisc_sprites().getBookshelf_1();
        bookshelf1.setSize(64, 69);
        bookshelf1.setPosition(250, 100);
        background_sprites.add(bookshelf1);
        
        // END OF MISC ITEMS
        
    }

    public List<Sprite> getWizardHouse_background_sprites() {
        return background_sprites;
    }
    
    public List<Sprite> getWizardHouse_foreground_sprites() {
        return foreground_sprites;
    }
    
}
