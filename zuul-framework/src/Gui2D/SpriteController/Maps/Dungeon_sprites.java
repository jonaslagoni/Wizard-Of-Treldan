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
        
        // START OF TILESET
        
        List<SingleSprite> dungeonTilesetList = new ArrayList();
        dungeonTilesetList.add(world.getGround_sprite().getStone_floor_1());
        dungeonTilesetList.add(world.getGround_sprite().getStone_floor_2());
        dungeonTilesetList.add(world.getGround_sprite().getStone_floor_3());
        
        Sprite dungeonTileset = new Groupsprite_random(dungeonTilesetList);
        dungeonTileset.setPosition(157,120);
        dungeonTileset.setSize(710, 304);
        spriteList.add(dungeonTileset);
        
        // END OF TILESET
        
        // START OF WALL

        List<SingleSprite> dungeonWALLList = new ArrayList();
        dungeonWALLList.add(world.getStructure_sprites().getStone_wall_NW());
        dungeonWALLList.add(world.getStructure_sprites().getStone_wall_N());
        dungeonWALLList.add(world.getStructure_sprites().getStone_wall_NE());
        dungeonWALLList.add(world.getStructure_sprites().getStone_wall_E());
        dungeonWALLList.add(world.getStructure_sprites().getStone_wall_SE());
        dungeonWALLList.add(world.getStructure_sprites().getStone_wall_S());
        dungeonWALLList.add(world.getStructure_sprites().getStone_wall_SW());
        dungeonWALLList.add(world.getStructure_sprites().getStone_wall_W());
        Sprite dungeonWALLCircle = new Groupsprite_circle(dungeonWALLList);
        dungeonWALLCircle.setPosition(125, 60);
        dungeonWALLCircle.setSize(768, 384);
        spriteList.add(dungeonWALLCircle);
        
        // END OF WALL
        
        // START OF LIBARY ENTRANCE
        
        Sprite libaryDoor = world.getMisc_sprites().getDoor_metal();
        libaryDoor.setPosition(700, 75);
        libaryDoor.setSize(32, 48);
        spriteList.add(libaryDoor);
        
        // END OF LIBARY ENTRANCE
        
        // START OF MISC
        
        Sprite torch1 = world.getMisc_sprites().getTorch_wall();
        torch1.setPosition(670, 80);
        torch1.setSize(16, 38);
        spriteList.add(torch1);
        
        Sprite torch2 = world.getMisc_sprites().getTorch_wall();
        torch2.setPosition(746, 80);
        torch2.setSize(16, 38);
        spriteList.add(torch2);
        
        Sprite hangingSkeleton1 = world.getMisc_sprites().getSkeleton_hanging();
        hangingSkeleton1.setPosition(500, 80);
        hangingSkeleton1.setSize(32, 45);
        spriteList.add(hangingSkeleton1);
        
        Sprite hangingSkeleton2 = world.getMisc_sprites().getSkeleton_hanging();
        hangingSkeleton2.setPosition(400, 80);
        hangingSkeleton2.setSize(32, 45);
        spriteList.add(hangingSkeleton2);
        
        Sprite hangingSkeleton3 = world.getMisc_sprites().getSkeleton_hanging();
        hangingSkeleton3.setPosition(300, 80);
        hangingSkeleton3.setSize(32, 45);
        spriteList.add(hangingSkeleton3);
        
        Sprite hangingSkeleton4 = world.getMisc_sprites().getSkeleton_hanging();
        hangingSkeleton4.setPosition(200, 80);
        hangingSkeleton4.setSize(32, 45);
        spriteList.add(hangingSkeleton4);
        
        List<SingleSprite> bonePileList1 = new ArrayList();
        bonePileList1.add(world.getMisc_sprites().getSkeleton_bones_pile());
        
        Sprite bonePileRow = new Groupsprite_random(bonePileList1);
        bonePileRow.setSize(128, 128);
        bonePileRow.setPosition(160, 290);
        spriteList.add(bonePileRow);
        
        Sprite SpiderWebUPPERLEFT1 = world.getMisc_sprites().getSpiderWeb_UPPER_LEFT();
        SpiderWebUPPERLEFT1.setSize(32, 23);
        SpiderWebUPPERLEFT1.setPosition(156, 122);
        spriteList.add(SpiderWebUPPERLEFT1);
        
        Sprite SpiderWebLOWERRIGHT1 = world.getMisc_sprites().getSpiderWeb_LOWER_RIGHT();
        SpiderWebLOWERRIGHT1.setSize(24, 32);
        SpiderWebLOWERRIGHT1.setPosition(838, 389);
        spriteList.add(SpiderWebLOWERRIGHT1);
        
        Sprite cellWall1 = world.getMisc_sprites().getCell_ironbar_straight();
        cellWall1.setSize(10, 100);
        cellWall1.setPosition(265, 73);
        spriteList.add(cellWall1);
        
        Sprite cellWall2 = world.getMisc_sprites().getCell_ironbar_straight();
        cellWall2.setSize(10, 100);
        cellWall2.setPosition(365, 73);
        spriteList.add(cellWall2);
        
        Sprite cellWall3 = world.getMisc_sprites().getCell_ironbar_straight();
        cellWall3.setSize(10, 100);
        cellWall3.setPosition(460, 73);
        spriteList.add(cellWall3);
        
        // END OF MISC
        
        // Enemies START
        
        List<SingleSprite> enemies = new ArrayList();
        
        Sprite skeleton1 = world.getMisc_sprites().getEnemy_Skeleton();
        Sprite skeleton2 = world.getMisc_sprites().getEnemy_Skeleton();
        Sprite skeleton3 = world.getMisc_sprites().getEnemy_Skeleton();
        
        skeleton1.setSize(30, 47);
        skeleton1.setPosition(250, 250);
        
        skeleton2.setSize(30, 47);
        skeleton2.setPosition(350, 250);
        
        skeleton3.setSize(30, 47);
        skeleton3.setPosition(450, 250);
        
        spriteList.add(skeleton1);
        spriteList.add(skeleton2);
        spriteList.add(skeleton3);
        
        enemies.add((SingleSprite)skeleton1);
        enemies.add((SingleSprite)skeleton2);
        enemies.add((SingleSprite)skeleton3);
        
        // Enemies END
        
    }

    /**
     * 
     * @return 
     */
    public List<Sprite> getSpriteList() {
        return spriteList;
    }
}