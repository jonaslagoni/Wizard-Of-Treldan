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
        gruulsLairGround.setSize(1024,512);
        gruulsLairGround.setPosition(0,0);
        spriteList.add(gruulsLairGround);
        
        // BACKGROUND END
        
        // WALL BEGIN
        
        List<SingleSprite> gruulsLairEASTWALLList = new ArrayList();
        gruulsLairEASTWALLList.add(world.getMisc_sprites().getBig_Rock());
        
        Sprite gruulsLairEASTWALL = new Groupsprite_random(gruulsLairEASTWALLList);
        gruulsLairEASTWALL.setSize(61, 475);
        gruulsLairEASTWALL.setPosition(628, 16);
        spriteList.add(gruulsLairEASTWALL);
        
        List<SingleSprite> gruulsLairWESTWALLList = new ArrayList();
        gruulsLairWESTWALLList.add(world.getMisc_sprites().getBig_Rock());
        
        Sprite gruulsLairWESTWALL = new Groupsprite_random(gruulsLairWESTWALLList);
        gruulsLairWESTWALL.setSize(61, 475);
        gruulsLairWESTWALL.setPosition(322, 16);
        spriteList.add(gruulsLairWESTWALL);
        
        List<SingleSprite> gruulsLairNORTHWALLList = new ArrayList();
        gruulsLairNORTHWALLList.add(world.getMisc_sprites().getBig_Rock());
        
        Sprite gruulsLairNORTHWALL = new Groupsprite_random(gruulsLairNORTHWALLList);
        gruulsLairNORTHWALL.setSize(244, 45);
        gruulsLairNORTHWALL.setPosition(383, 8);
        spriteList.add(gruulsLairNORTHWALL);
        
        // WALL END
        
        // MISC ITEMS START
        
        List<SingleSprite> randomVanitySpritesList1 = new ArrayList();
        randomVanitySpritesList1.add(world.getGround_sprite().getStone_dark_1());
        randomVanitySpritesList1.add(world.getGround_sprite().getStone_dark_2());
        randomVanitySpritesList1.add(world.getMisc_sprites().getCave_Spikes());
        
        Sprite randomVanitySprites1 = new Groupsprite_random(randomVanitySpritesList1);
        randomVanitySprites1.setSize(300, 375);
        randomVanitySprites1.setPosition(0, 32);
        spriteList.add(randomVanitySprites1);
        
        List<SingleSprite> randomVanitySpritesList2 = new ArrayList();
        randomVanitySpritesList2.add(world.getGround_sprite().getStone_dark_1());
        randomVanitySpritesList2.add(world.getGround_sprite().getStone_dark_2());
        randomVanitySpritesList2.add(world.getMisc_sprites().getCave_Spikes());
        
        Sprite randomVanitySprites2 = new Groupsprite_random(randomVanitySpritesList2);
        randomVanitySprites2.setSize(300, 375);
        randomVanitySprites2.setPosition(725, 64);
        spriteList.add(randomVanitySprites2);
        
        // MISC ITEMS END

    }

    /**
     * @return the gruulslair_background_sprites
     */
    public List<Sprite> getGruulsLair_background_sprites() {
        return spriteList;
    }

   
    
}