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
import javafx.geometry.Rectangle2D;

/**
 *
 * @author jonas
 */
public class Cave_sprites{
    private SpriteController world;
    
    
    private List<Sprite> background_sprites;
    private List<Sprite> foreground_sprites;
    
    public Cave_sprites(SpriteController world){
        this.world = world;
        this.background_sprites = new ArrayList();
        this.foreground_sprites = new ArrayList();
    }
    
    public void setCave_background_SingleSprites(){
        
        List<SingleSprite> caveGroundList = new ArrayList();
        caveGroundList.add(world.getGround_sprite().getStone_dark_1());
        caveGroundList.add(world.getGround_sprite().getStone_dark_2());
        
        Sprite caveGround1 = new Groupsprite_random(caveGroundList);
        caveGround1.setSize(1024,512);
        caveGround1.setPosition(0,0);
        background_sprites.add(caveGround1);
        
        // START OF WALL

        List<SingleSprite> cave_WESTWALLList = new ArrayList();
        
        cave_WESTWALLList.add(world.getMisc_sprites().getBig_Rock());
        
        Sprite cave_WESTWALL = new Groupsprite_random(cave_WESTWALLList);
        cave_WESTWALL.setSize(13, 350);
        cave_WESTWALL.setPosition(205, 65);
        background_sprites.add(cave_WESTWALL);
        
        List<SingleSprite> cave_NORTHWALLList = new ArrayList();
        
        cave_NORTHWALLList.add(world.getMisc_sprites().getRock_Wall_Front());
        
        Sprite cave_NORTHWALL = new Groupsprite_random(cave_NORTHWALLList);
        cave_NORTHWALL.setSize(1100, 65);
        cave_NORTHWALL.setPosition(0, 0);
        background_sprites.add(cave_NORTHWALL);
        
        List<SingleSprite> cave_SOUTHWALLList = new ArrayList();
        
        cave_SOUTHWALLList.add(world.getMisc_sprites().getBig_Rock());
        
        Sprite cave_SOUTHWALL = new Groupsprite_random(cave_SOUTHWALLList);
        cave_SOUTHWALL.setSize(567, 65);
        cave_SOUTHWALL.setPosition(205, 420);
        background_sprites.add(cave_SOUTHWALL);
        
        List<SingleSprite> cave_EASTWALLList = new ArrayList();
        
        cave_EASTWALLList.add(world.getMisc_sprites().getBig_Rock());
        
        Sprite cave_EASTWALL = new Groupsprite_random(cave_EASTWALLList);
        cave_EASTWALL.setSize(13, 395);
        cave_EASTWALL.setPosition(760, 60);
        background_sprites.add(cave_EASTWALL);
        
        
        // START OF MISC ITEMS

        Sprite cave_exit = world.getMisc_sprites().getCaveExit();
        cave_exit.setPosition(692, 340);
        cave_exit.setBoundary(new Rectangle2D(cave_exit.getPositionX(), cave_exit.getPositionY(), cave_exit.getWidth(), cave_exit.getHeight()));
        background_sprites.add(cave_exit);
        
        Sprite gruuls_Lair_Entrance = world.getMisc_sprites().getBig_Cave_Entrance();
        gruuls_Lair_Entrance.setPosition(420, -10);
        background_sprites.add(gruuls_Lair_Entrance);
        
        List<SingleSprite> randomVanitySpritesList1 = new ArrayList();
        randomVanitySpritesList1.add(world.getGround_sprite().getStone_dark_1());
        randomVanitySpritesList1.add(world.getGround_sprite().getStone_dark_2());
        randomVanitySpritesList1.add(world.getMisc_sprites().getCave_Spikes());
        
        Sprite randomVanitySprites1 = new Groupsprite_random(randomVanitySpritesList1);
        randomVanitySprites1.setSize(200, 375);
        randomVanitySprites1.setPosition(0, 68);
        background_sprites.add(randomVanitySprites1);
        
        List<SingleSprite> randomVanitySpritesList2 = new ArrayList();
        randomVanitySpritesList2.add(world.getGround_sprite().getStone_dark_1());
        randomVanitySpritesList2.add(world.getGround_sprite().getStone_dark_2());
        randomVanitySpritesList2.add(world.getMisc_sprites().getCave_Spikes());
        
        Sprite randomVanitySprites2 = new Groupsprite_random(randomVanitySpritesList2);
        randomVanitySprites2.setSize(182, 375);
        randomVanitySprites2.setPosition(830, 68);
        background_sprites.add(randomVanitySprites2);
        
        List<SingleSprite> randomVanitySpritesList3 = new ArrayList();
        randomVanitySpritesList3.add(world.getGround_sprite().getStone_dark_1());
        randomVanitySpritesList3.add(world.getGround_sprite().getStone_dark_2());
        randomVanitySpritesList3.add(world.getMisc_sprites().getCave_Spikes());
        
        Sprite randomVanitySprites3 = new Groupsprite_random(randomVanitySpritesList3);
        randomVanitySprites3.setSize(1024, 32);
        randomVanitySprites3.setPosition(0, 478);
        background_sprites.add(randomVanitySprites3);
        
        // Enemies in cave START
        
        List<SingleSprite> enemies = new ArrayList();
        
        Sprite enemy1 = world.getMisc_sprites().getEnemy_Golem();
        Sprite enemy2 = world.getMisc_sprites().getEnemy_Golem();
        Sprite enemy3 = world.getMisc_sprites().getEnemy_Golem();
        
        enemy1.setSize(43, 59);
        enemy1.setPosition(375, 100);
        
        enemy2.setSize(43, 59);
        enemy2.setPosition(475, 100);
        
        enemy3.setSize(43, 59);
        enemy3.setPosition(575, 100);
        
        foreground_sprites.add(enemy1);
        foreground_sprites.add(enemy2);
        foreground_sprites.add(enemy3);
        
        enemies.add((SingleSprite)enemy1);
        enemies.add((SingleSprite)enemy2);
        enemies.add((SingleSprite)enemy3);
        
        // Enemies in cave END
        
    }

    /**
     * @return the cave_background_sprites
     */
    public List<Sprite> getCave_background_sprites() {
        return background_sprites;
    }
    
    /**
     * 
     * @return cave_foreground_sprites
     */
    public List<Sprite> getCave_foreground_sprites() {
        return foreground_sprites;
    }
   
    
}
