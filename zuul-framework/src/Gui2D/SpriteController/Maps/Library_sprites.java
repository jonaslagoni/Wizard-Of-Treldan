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
 * @author Mads B
 */
public class Library_sprites{
    private SpriteController world;
    
    private List<Sprite> spriteList_background;
    private List<Sprite> spriteList_foreground;
    
    private final List<SingleSprite> LibraryWalls;
    private final List<SingleSprite> LibraryFloor;
    
    
    public Library_sprites(SpriteController world){
        this.world = world;
        //inintizalise spritelists
        this.spriteList_background = new ArrayList();
        this.spriteList_foreground = new ArrayList();
        this.LibraryFloor = new ArrayList();
        this.LibraryWalls = new ArrayList();
    }
    
    public void setLibrary_background_SingleSprites(){
        
        
        //floor
        LibraryFloor.add(world.getGround_sprite().getCastle_Stone_Floor());
        Sprite library_floor = new Groupsprite_random(LibraryFloor);
        library_floor.setSize(1024,512);
        library_floor.setPosition(0, 0);
        spriteList_background.add(library_floor);
        
        //walls
        LibraryWalls.add(world.getStructure_sprites().getStone_wall_NW());
        LibraryWalls.add(world.getStructure_sprites().getStone_wall_N());
        LibraryWalls.add(world.getStructure_sprites().getStone_wall_NE());
        LibraryWalls.add(world.getStructure_sprites().getStone_wall_E());
        LibraryWalls.add(world.getStructure_sprites().getStone_wall_SE());
        LibraryWalls.add(world.getStructure_sprites().getStone_wall_S());
        LibraryWalls.add(world.getStructure_sprites().getStone_wall_SW());
        LibraryWalls.add(world.getStructure_sprites().getStone_wall_W());
        Sprite Library_walls_circle = new Groupsprite_circle(LibraryWalls);
        Library_walls_circle.setPosition(0, 0);
        Library_walls_circle.setSize(1024, 512);
        spriteList_background.add(Library_walls_circle);
        
        
        // 1
        Sprite doorToEvilWizard = world.getMisc_sprites().getDoor_Metal_2();
        doorToEvilWizard.setSize(32, 48);
        doorToEvilWizard.setPosition(512, 0);
        spriteList_foreground.add(doorToEvilWizard);
        
    }

    public List<Sprite> getSpriteList() {
        return spriteList_background;
    }
    
    
}
