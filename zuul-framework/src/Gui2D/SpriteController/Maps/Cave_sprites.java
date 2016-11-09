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
        caveGround1.setSize(600,340);
        caveGround1.setPosition(80,200);
        spriteList.add(caveGround1);
        
        Sprite chest = world.getMisc_sprites().getChestClosed();
        chest.setPosition(544, 128);
        spriteList.add(chest);
        
        Sprite bmushroom = world.getMisc_sprites().getBrownMushroom();
        bmushroom.setPosition(544, 222);
        spriteList.add(bmushroom);
        
        Sprite cave_exit = world.getMisc_sprites().getCaveExit();
        cave_exit.setPosition(720, 389);
        spriteList.add(cave_exit);
        
        Sprite gruuls_Lair_Entrance = world.getMisc_sprites().getCaveExit();
        gruuls_Lair_Entrance.setPosition(500, 79);
        spriteList.add(gruuls_Lair_Entrance);
        
        // START OF MISC ITEMS
        
        List<SingleSprite> cave_HoleWESTWALLList = new ArrayList();
        
        cave_HoleWESTWALLList.add(world.getMisc_sprites().getCave_Hole());
        
        Sprite cave_HoleWESTWALL = new Groupsprite_random(cave_HoleWESTWALLList);
        cave_HoleWESTWALL.setSize(81, 316);
        cave_HoleWESTWALL.setPosition(100, 200);
        spriteList.add(cave_HoleWESTWALL);
        
    }

    /**
     * @return the gruulslair_background_sprites
     */
    public List<Sprite> getCave_background_sprites() {
        return spriteList;
    }

   
    
}
