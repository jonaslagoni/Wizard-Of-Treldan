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
        
        cave_WESTWALLList.add(world.getMisc_sprites().getRock_Wall_LEFT());
        
        Sprite cave_WESTWALL = new Groupsprite_random(cave_WESTWALLList);
        cave_WESTWALL.setSize(13, 316);
        cave_WESTWALL.setPosition(200, 100);
        spriteList.add(cave_WESTWALL);
        
        List<SingleSprite> cave_NORTHWALLList1 = new ArrayList();
        
        cave_NORTHWALLList1.add(world.getMisc_sprites().getRock_Wall_Front());
        
        Sprite cave_NORTHWALL1 = new Groupsprite_random(cave_NORTHWALLList1);
        cave_NORTHWALL1.setSize(559, 65);
        cave_NORTHWALL1.setPosition(200, 100);
        spriteList.add(cave_NORTHWALL1);
        
        List<SingleSprite> cave_SOUTHWALLList = new ArrayList();
        
        cave_SOUTHWALLList.add(world.getMisc_sprites().getRock_Wall_Front());
        
        Sprite cave_SOUTHWALL = new Groupsprite_random(cave_SOUTHWALLList);
        cave_SOUTHWALL.setSize(567, 65);
        cave_SOUTHWALL.setPosition(200, 415);
        spriteList.add(cave_SOUTHWALL);
        
        List<SingleSprite> cave_EASTWALLList = new ArrayList();
        
        cave_EASTWALLList.add(world.getMisc_sprites().getRock_Wall_RIGHT());
        
        Sprite cave_EASTWALL = new Groupsprite_random(cave_EASTWALLList);
        cave_EASTWALL.setSize(13, 395);
        cave_EASTWALL.setPosition(760, 100);
        spriteList.add(cave_EASTWALL);
        
        
        // START OF MISC ITEMS

        Sprite cave_exit = world.getMisc_sprites().getCaveExit();
        cave_exit.setPosition(692, 340);
        spriteList.add(cave_exit);
        
        Sprite gruuls_Lair_Entrance = world.getMisc_sprites().getCaveExit();
        gruuls_Lair_Entrance.setPosition(527, 125);
        spriteList.add(gruuls_Lair_Entrance);
        
        
    }

    /**
     * @return the gruulslair_background_sprites
     */
    public List<Sprite> getCave_background_sprites() {
        return spriteList;
    }

   
    
}
