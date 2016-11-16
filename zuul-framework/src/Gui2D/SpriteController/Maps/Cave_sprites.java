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
public class Cave_sprites{
    private SpriteController world;
    
    
    private List<Sprite> spriteList;
    
    public Cave_sprites(SpriteController world){
        this.world = world;
        this.spriteList = new ArrayList();
    }
    
    public void setCave_background_SingleSprites(){
        
        List<SingleSprite> caveGroundList = new ArrayList();
        caveGroundList.add(world.getGround_sprite().getStone_dark_1());
        caveGroundList.add(world.getGround_sprite().getStone_dark_2());
        
        Sprite caveGround1 = new Groupsprite_random(caveGroundList);
        caveGround1.setSize(1024,512);
        caveGround1.setPosition(0,0);
        spriteList.add(caveGround1);
        
        // START OF WALL

        List<SingleSprite> cave_WESTWALLList = new ArrayList();
        
        cave_WESTWALLList.add(world.getMisc_sprites().getBig_Rock());
        
        Sprite cave_WESTWALL = new Groupsprite_random(cave_WESTWALLList);
        cave_WESTWALL.setSize(13, 350);
        cave_WESTWALL.setPosition(205, 65);
        spriteList.add(cave_WESTWALL);
        
        List<SingleSprite> cave_NORTHWALLList = new ArrayList();
        
        cave_NORTHWALLList.add(world.getMisc_sprites().getRock_Wall_Front());
        
        Sprite cave_NORTHWALL = new Groupsprite_random(cave_NORTHWALLList);
        cave_NORTHWALL.setSize(1100, 65);
        cave_NORTHWALL.setPosition(0, 0);
        spriteList.add(cave_NORTHWALL);
        
        List<SingleSprite> cave_SOUTHWALLList = new ArrayList();
        
        cave_SOUTHWALLList.add(world.getMisc_sprites().getBig_Rock());
        
        Sprite cave_SOUTHWALL = new Groupsprite_random(cave_SOUTHWALLList);
        cave_SOUTHWALL.setSize(567, 65);
        cave_SOUTHWALL.setPosition(205, 420);
        spriteList.add(cave_SOUTHWALL);
        
        List<SingleSprite> cave_EASTWALLList = new ArrayList();
        
        cave_EASTWALLList.add(world.getMisc_sprites().getBig_Rock());
        
        Sprite cave_EASTWALL = new Groupsprite_random(cave_EASTWALLList);
        cave_EASTWALL.setSize(13, 395);
        cave_EASTWALL.setPosition(760, 60);
        spriteList.add(cave_EASTWALL);
        
        
        // START OF MISC ITEMS

        Sprite cave_exit = world.getMisc_sprites().getCaveExit();
        cave_exit.setPosition(692, 340);
        spriteList.add(cave_exit);
        
        Sprite gruuls_Lair_Entrance = world.getMisc_sprites().getBig_Cave_Entrance();
        gruuls_Lair_Entrance.setPosition(420, -10);
        spriteList.add(gruuls_Lair_Entrance);
        
        List<SingleSprite> randomVanitySpritesList1 = new ArrayList();
        randomVanitySpritesList1.add(world.getGround_sprite().getStone_dark_1());
        randomVanitySpritesList1.add(world.getGround_sprite().getStone_dark_2());
        randomVanitySpritesList1.add(world.getMisc_sprites().getCave_Spikes());
        
        Sprite randomVanitySprites1 = new Groupsprite_random(randomVanitySpritesList1);
        randomVanitySprites1.setSize(200, 375);
        randomVanitySprites1.setPosition(0, 68);
        spriteList.add(randomVanitySprites1);
        
        List<SingleSprite> randomVanitySpritesList2 = new ArrayList();
        randomVanitySpritesList2.add(world.getGround_sprite().getStone_dark_1());
        randomVanitySpritesList2.add(world.getGround_sprite().getStone_dark_2());
        randomVanitySpritesList2.add(world.getMisc_sprites().getCave_Spikes());
        
        Sprite randomVanitySprites2 = new Groupsprite_random(randomVanitySpritesList2);
        randomVanitySprites2.setSize(182, 375);
        randomVanitySprites2.setPosition(830, 68);
        spriteList.add(randomVanitySprites2);
        
        List<SingleSprite> randomVanitySpritesList3 = new ArrayList();
        randomVanitySpritesList3.add(world.getGround_sprite().getStone_dark_1());
        randomVanitySpritesList3.add(world.getGround_sprite().getStone_dark_2());
        randomVanitySpritesList3.add(world.getMisc_sprites().getCave_Spikes());
        
        Sprite randomVanitySprites3 = new Groupsprite_random(randomVanitySpritesList3);
        randomVanitySprites3.setSize(1024, 32);
        randomVanitySprites3.setPosition(0, 478);
        spriteList.add(randomVanitySprites3);
        
    }

    /**
     * @return the gruulslair_background_sprites
     */
    public List<Sprite> getCave_background_sprites() {
        return spriteList;
    }

   
    
}
