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
    
    public EvilWizardsLair_sprites(SpriteController world){
        this.world = world;
        this.spriteList = new ArrayList();
    }
    
    public void setEvilWizardsLair_background_SingleSprites(){
        
        List<SingleSprite> backgroundCastleFloorList = new ArrayList();
        backgroundCastleFloorList.add(world.getGround_sprite().getCastle_Stone_Floor());
        
        Sprite backgroundCastleFloor = new Groupsprite_random(backgroundCastleFloorList);
        backgroundCastleFloor.setSize(384, 384);
        backgroundCastleFloor.setPosition(320, 144);
        spriteList.add(backgroundCastleFloor);
        
        // MISC ITEMS START
        
        
        
    }

    public List<Sprite> getSpriteList() {
        return spriteList;
    }
    
}
