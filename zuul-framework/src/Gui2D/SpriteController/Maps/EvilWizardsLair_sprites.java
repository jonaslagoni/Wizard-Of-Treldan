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
        
        List<SingleSprite> backgroundCastleFloorList = new ArrayList();
        backgroundCastleFloorList.add(world.getGround_sprite().getEvilWizardsLair_1());
        backgroundCastleFloorList.add(world.getGround_sprite().getEvilWizardsLair_2());
        
        Sprite backgroundCastleFloor = new Groupsprite_random(backgroundCastleFloorList);
        backgroundCastleFloor.setSize(1024, 512);
        backgroundCastleFloor.setPosition(0, 0);
        spriteList.add(backgroundCastleFloor);
        
        //STAGE
        Sprite stage = world.getMisc_sprites().getEvilWizardsLair_Stage();
        stage.setPosition(430,156);
        spriteList_foreground.add(stage);
        
        //ENEMY DUDE
        Sprite enemy = world.getMisc_sprites().getWizard_evil_battle();
        enemy.setPosition(450,110);
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
