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
    private List<Sprite> background_sprites;
    private List<Sprite> foreground_sprites;
    private List<Sprite> enemy_sprites;
    
    /**
     * Inits the variables
     * @param world 
     */    
    public GruulsLair_sprites(SpriteController world){
        this.world = world;
        this.background_sprites = new ArrayList();
        this.foreground_sprites = new ArrayList();
        this.enemy_sprites = new ArrayList();
    }
    
    /**
     * Adds the sprites to the lists
     */
    public void setGruulsLair_background_SingleSprites(){
        
        // BACKGROUND START
        
        List<SingleSprite> gruulsLairGroundList = new ArrayList();
        gruulsLairGroundList.add(world.getGround_sprite().getStone_dark_1());
        gruulsLairGroundList.add(world.getGround_sprite().getStone_dark_2());
        
        Sprite gruulsLairGround = new Groupsprite_random(gruulsLairGroundList);
        gruulsLairGround.setSize(1024,512);
        gruulsLairGround.setPosition(0,0);
        background_sprites.add(gruulsLairGround);
        
        // BACKGROUND END
        
        // WALL BEGIN
        
        List<SingleSprite> gruulsLairEASTWALLList = new ArrayList();
        gruulsLairEASTWALLList.add(world.getMisc_sprites().getBig_Rock());
        
        Sprite gruulsLairEASTWALL = new Groupsprite_random(gruulsLairEASTWALLList);
        gruulsLairEASTWALL.setSize(61, 475);
        gruulsLairEASTWALL.setPosition(628, 16);
        background_sprites.add(gruulsLairEASTWALL);
        
        List<SingleSprite> gruulsLairWESTWALLList = new ArrayList();
        gruulsLairWESTWALLList.add(world.getMisc_sprites().getBig_Rock());
        
        Sprite gruulsLairWESTWALL = new Groupsprite_random(gruulsLairWESTWALLList);
        gruulsLairWESTWALL.setSize(61, 475);
        gruulsLairWESTWALL.setPosition(322, 16);
        background_sprites.add(gruulsLairWESTWALL);
        
        List<SingleSprite> gruulsLairNORTHWALLList = new ArrayList();
        gruulsLairNORTHWALLList.add(world.getMisc_sprites().getBig_Rock());
        
        Sprite gruulsLairNORTHWALL = new Groupsprite_random(gruulsLairNORTHWALLList);
        gruulsLairNORTHWALL.setSize(244, 45);
        gruulsLairNORTHWALL.setPosition(383, 8);
        background_sprites.add(gruulsLairNORTHWALL);
        
        // WALL END
        
        // EXIT START
        
        List<SingleSprite> exit_gruulsLairList = new ArrayList();
        exit_gruulsLairList.add(world.getGround_sprite().getCastle_Stone_Floor());
        
        Sprite exit_gruulsLair = new Groupsprite_random(exit_gruulsLairList);
        exit_gruulsLair.setSize(256, 32);
        exit_gruulsLair.setPosition(377, 520);
        background_sprites.add(exit_gruulsLair);
        
        // EXIT END
        
        // MISC ITEMS START
        
        List<SingleSprite> randomVanitySpritesList1 = new ArrayList();
        randomVanitySpritesList1.add(world.getGround_sprite().getStone_dark_1());
        randomVanitySpritesList1.add(world.getGround_sprite().getStone_dark_2());
        randomVanitySpritesList1.add(world.getMisc_sprites().getCave_Spikes());
        
        Sprite randomVanitySprites1 = new Groupsprite_random(randomVanitySpritesList1);
        randomVanitySprites1.setSize(300, 375);
        randomVanitySprites1.setPosition(0, 32);
        background_sprites.add(randomVanitySprites1);
        
        List<SingleSprite> randomVanitySpritesList2 = new ArrayList();
        randomVanitySpritesList2.add(world.getGround_sprite().getStone_dark_1());
        randomVanitySpritesList2.add(world.getGround_sprite().getStone_dark_2());
        randomVanitySpritesList2.add(world.getMisc_sprites().getCave_Spikes());
        
        Sprite randomVanitySprites2 = new Groupsprite_random(randomVanitySpritesList2);
        randomVanitySprites2.setSize(300, 375);
        randomVanitySprites2.setPosition(725, 64);
        background_sprites.add(randomVanitySprites2);
        
        // MISC ITEMS END

        // Enemies START
        
        List<SingleSprite> enemies = new ArrayList();
        
        Sprite gruul = world.getMisc_sprites().getEnemy_Golem();
        
        gruul.setSize(43, 59);
        gruul.setPosition(492, 75);
        
        enemy_sprites.add(gruul);
        
        enemies.add((SingleSprite)gruul);
        
        // Enemies END
        
    }

    /**
     * @return the gruulslair_background_sprites
     */
    public List<Sprite> getGruulsLair_background_sprites() {
        return background_sprites;
    }
    
    /**
     * @return the enemies.
     */
    public List<Sprite> getGruulsLair_enemy_sprites() {
        return enemy_sprites;
    }

   
    
}