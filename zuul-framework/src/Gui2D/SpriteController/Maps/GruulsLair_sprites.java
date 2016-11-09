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
        
        // WALL BEGIN
        
        List<SingleSprite> gruulsLairEASTWALLList = new ArrayList();
        gruulsLairEASTWALLList.add(world.getMisc_sprites().getCave_Spikes());
        
        Sprite gruulsLairEASTWALL = new Groupsprite_random(gruulsLairEASTWALLList);
        gruulsLairEASTWALL.setSize(32, 448);
        gruulsLairEASTWALL.setPosition(24, 598);
        spriteList.add(gruulsLairEASTWALL);
        
        List<SingleSprite> gruulsLairWESTWALLList = new ArrayList();
        gruulsLairWESTWALLList.add(world.getMisc_sprites().getCave_Spikes());
        
        Sprite gruulsLairWESTWALL = new Groupsprite_random(gruulsLairWESTWALLList);
        gruulsLairWESTWALL.setSize(32, 448);
        gruulsLairWESTWALL.setPosition(24, 375);
        spriteList.add(gruulsLairWESTWALL);
        
        List<SingleSprite> gruulsLairNORTHWALLList = new ArrayList();
        gruulsLairNORTHWALLList.add(world.getMisc_sprites().getCave_Boulder());
        
        Sprite gruulsLairNORTHWALL = new Groupsprite_random(gruulsLairNORTHWALLList);
        gruulsLairNORTHWALL.setSize(192, 32);
        gruulsLairNORTHWALL.setPosition(26, 407);
        spriteList.add(gruulsLairNORTHWALL);
        
        Sprite gruulsLairSOUTHWALLBoulder1 = world.getMisc_sprites().getCave_Boulder();
        gruulsLairSOUTHWALLBoulder1.setPosition(415, 440);
        spriteList.add(gruulsLairSOUTHWALLBoulder1);
        
        Sprite gruulsLairSOUTHWALLBoulder2 = world.getMisc_sprites().getCave_Boulder();
        gruulsLairSOUTHWALLBoulder2.setPosition(530, 440);
        spriteList.add(gruulsLairSOUTHWALLBoulder2);
        
        // WALL END
        
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