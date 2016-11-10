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
public class Dungeon_sprites {
    private SpriteController world;
    
    private List<Sprite> spriteList;
    
    public Dungeon_sprites(SpriteController world){
        this.world = world;
        this.spriteList = new ArrayList();
    }
    
    public void setDungeon_background_SingleSprites(){
        
        // START OF WALL

        List<SingleSprite> dungeonNORTHWALLList = new ArrayList();
        dungeonNORTHWALLList.add(world.getStructure_sprites().getStone_wall_N());
        
        Sprite dungeonNORTHWALL = new Groupsprite_random(dungeonNORTHWALLList);
        
        dungeonNORTHWALL.setSize(250, 125);
        dungeonNORTHWALL.setPosition(175, 500);
        spriteList.add(dungeonNORTHWALL);
        
        // END OF WALL
        
    }

    /**
     * 
     * @return 
     */
    public List<Sprite> getSpriteList() {
        return spriteList;
    }
}