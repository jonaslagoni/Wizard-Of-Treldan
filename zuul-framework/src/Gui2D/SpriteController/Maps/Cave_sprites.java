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
        
        Sprite cave_exit = world.getMisc_sprites().getCaveExit();
        cave_exit.setPosition(692, 340);
        spriteList.add(cave_exit);
        
        Sprite gruuls_Lair_Entrance = world.getMisc_sprites().getCaveExit();
        gruuls_Lair_Entrance.setPosition(527, 125);
        spriteList.add(gruuls_Lair_Entrance);
        
        // START OF WALL

        List<SingleSprite> cave_HoleWESTWALLList = new ArrayList();
        
        cave_HoleWESTWALLList.add(world.getMisc_sprites().getCave_Hole());
        
        Sprite cave_HoleWESTWALL = new Groupsprite_random(cave_HoleWESTWALLList);
        cave_HoleWESTWALL.setSize(81, 316);
        cave_HoleWESTWALL.setPosition(200, 100);
        spriteList.add(cave_HoleWESTWALL);
        
        List<SingleSprite> cave_HoleNORTHWALLList1 = new ArrayList();
        
        cave_HoleNORTHWALLList1.add(world.getMisc_sprites().getCave_Hole());
        
        Sprite cave_HoleNORTHWALL1 = new Groupsprite_random(cave_HoleNORTHWALLList1);
        cave_HoleNORTHWALL1.setSize(324, 79);
        cave_HoleNORTHWALL1.setPosition(200, 100);
        spriteList.add(cave_HoleNORTHWALL1);
        
        List<SingleSprite> cave_HoleNORTHWALLList2 = new ArrayList();
        
        cave_HoleNORTHWALLList2.add(world.getMisc_sprites().getCave_Hole());
        
        Sprite cave_HoleNORTHWALL2 = new Groupsprite_random(cave_HoleNORTHWALLList2);
        cave_HoleNORTHWALL2.setSize(162, 79);
        cave_HoleNORTHWALL2.setPosition(566, 100);
        spriteList.add(cave_HoleNORTHWALL2);
        
        List<SingleSprite> cave_HoleSOUTHWALLList = new ArrayList();
        
        cave_HoleSOUTHWALLList.add(world.getMisc_sprites().getCave_Hole());
        
        Sprite cave_HoleSOUTHWALL = new Groupsprite_random(cave_HoleSOUTHWALLList);
        cave_HoleSOUTHWALL.setSize(567, 79);
        cave_HoleSOUTHWALL.setPosition(200, 415);
        spriteList.add(cave_HoleSOUTHWALL);
        
        List<SingleSprite> cave_HoleEASTWALLList = new ArrayList();
        
        cave_HoleEASTWALLList.add(world.getMisc_sprites().getCave_Hole());
        
        Sprite cave_HoleEASTWALL = new Groupsprite_random(cave_HoleEASTWALLList);
        cave_HoleEASTWALL.setSize(81, 395);
        cave_HoleEASTWALL.setPosition(730, 100);
        spriteList.add(cave_HoleEASTWALL);
        
        
        // START OF MISC ITEMS

        
    }

    /**
     * @return the gruulslair_background_sprites
     */
    public List<Sprite> getCave_background_sprites() {
        return spriteList;
    }

   
    
}
