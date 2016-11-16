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
public class Library_sprites{
    private SpriteController world;
    
    private List<Sprite> spriteList;
    
    public Library_sprites(SpriteController world){
        this.world = world;
        this.spriteList = new ArrayList();
    }
    
    public void setLibrary_background_SingleSprites(){
        
        List<SingleSprite> backgroundLibraryFloorList = new ArrayList();
        backgroundLibraryFloorList.add(world.getGround_sprite().getCastle_Stone_Floor());
        
        Sprite backgroundLibraryFloor = new Groupsprite_random(backgroundLibraryFloorList);
        backgroundLibraryFloor.setSize(1024, 468);
        backgroundLibraryFloor.setPosition(0, 48);
        spriteList.add(backgroundLibraryFloor);
        
        Sprite doorToEvilWizard = world.getMisc_sprites().getDoor_Metal_2();
        doorToEvilWizard.setSize(32, 48);
        doorToEvilWizard.setPosition(512, 0);
        spriteList.add(doorToEvilWizard);
        
    }

    public List<Sprite> getSpriteList() {
        return spriteList;
    }
    
}
