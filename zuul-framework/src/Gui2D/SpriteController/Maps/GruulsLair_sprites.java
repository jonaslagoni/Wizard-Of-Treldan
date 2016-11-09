/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.Maps;

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
public class GruulsLair_sprites{
    private SpriteController world;
    
    
    private List<Sprite> spriteList;
    
    public GruulsLair_sprites(SpriteController world){
        this.world = world;
        this.spriteList = new ArrayList();
    }
    
    public void setGruulsLair_background_SingleSprites(){
        
        // BACKGROUND START
        
        List<SingleSprite> gruulsLairGroundList = new ArrayList();
        gruulsLairGroundList.add(world.getGround_sprite().getStone_dark_1());
        gruulsLairGroundList.add(world.getGround_sprite().getStone_dark_2());
        
        Sprite gruulsLairGround = new Groupsprite_random(gruulsLairGroundList);
        gruulsLairGround.setSize(256,450);
        gruulsLairGround.setPosition(25,375);
        spriteList.add(gruulsLairGround);
        
        // BACKGROUND END
        
        // MISC ITEMS START
        
        Sprite gruulsLair_EXIT = world.getMisc_sprites().getCaveExit();
        gruulsLair_EXIT.setPosition(487, 430);
        spriteList.add(gruulsLair_EXIT);
        
        // MISC ITEMS END
        
    }

    /**
     * @return the gruulslair_background_sprites
     */
    public List<Sprite> getGruulsLair_background_sprites() {
        return spriteList;
    }

   
    
}