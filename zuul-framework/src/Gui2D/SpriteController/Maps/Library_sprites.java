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
import javafx.geometry.Rectangle2D;

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
    private final List<SingleSprite> LibraryWallE;
    
    
    public Library_sprites(SpriteController world){
        this.world = world;
        //inintizalise spritelists
        this.spriteList_background = new ArrayList();
        this.spriteList_foreground = new ArrayList();
        this.LibraryFloor = new ArrayList();
        this.LibraryWalls = new ArrayList();
        this.LibraryWallE = new ArrayList();
    }
    
    public void setLibrary_background_SingleSprites(){
        
        
        //floor 0 
        LibraryFloor.add(world.getGround_sprite().getCastle_Stone_Floor());
        Sprite library_floor = new Groupsprite_random(LibraryFloor);
        library_floor.setSize(730,370);
        library_floor.setPosition(0, 0);
        spriteList_background.add(library_floor);
        
        //walls 1
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
        Library_walls_circle.setSize(770, 385);
        spriteList_background.add(Library_walls_circle);
      
        
        
        
        // 2
        Sprite doorToEvilWizard = world.getMisc_sprites().getDoor_Metal_2();
        doorToEvilWizard.setPosition(400, 16);
        doorToEvilWizard.setBoundary(new Rectangle2D(doorToEvilWizard.getPositionX()+126,doorToEvilWizard.getPositionY()+66,doorToEvilWizard.getWidth(),doorToEvilWizard.getHeight()));
        spriteList_background.add(doorToEvilWizard);
        
        //enemy 3
        Sprite enemy_librarian = world.getMisc_sprites().getEnemy_librarian();
        enemy_librarian.setPosition(150,100);
        enemy_librarian.setBoundary(new Rectangle2D(enemy_librarian.getPositionX()+126,enemy_librarian.getPositionY()+66,enemy_librarian.getWidth(),enemy_librarian.getHeight()));
        spriteList_background.add(enemy_librarian);
        
        //chest 4
        Sprite chest = world.getMisc_sprites().getChestClosed();
        chest.setPosition(75,100);
        chest.setBoundary(new Rectangle2D(chest.getPositionX()+126,chest.getPositionY()+66,chest.getWidth(),chest.getHeight()));
        spriteList_background.add(chest);
        
        //MISC
        //5
        Sprite bookshelf1 = world.getMisc_sprites().getInterior_Bookshelf_double();
        bookshelf1.setPosition(32, 24);
        bookshelf1.setBoundary(new Rectangle2D(bookshelf1.getPositionX()+126,bookshelf1.getPositionY()+66,bookshelf1.getWidth(),bookshelf1.getHeight()));
        spriteList_background.add(bookshelf1);
        
        Sprite bookshelf9 = world.getMisc_sprites().getInterior_Bookshelf_single();
        bookshelf9.setPosition(700, 24);
        bookshelf9.setBoundary(new Rectangle2D(bookshelf9.getPositionX()+126,bookshelf9.getPositionY()+66,bookshelf9.getWidth(),bookshelf9.getHeight()));
        spriteList_background.add(bookshelf9);
        //6
        LibraryWallE.add(world.getMisc_sprites().getInterior_cupboard_facingdown_large());
        Sprite libarywallE = new Groupsprite_random(LibraryWallE);
        libarywallE.setPosition(30,75);
        libarywallE.setSize(32,300);
        spriteList_background.add(libarywallE);
        
        LibraryWallE.add(world.getMisc_sprites().getInterior_cupboard_facingdown_large());
        Sprite libarywallW = new Groupsprite_random(LibraryWallE);
        libarywallW.setPosition(708,75);
        libarywallW.setSize(32,300);
        spriteList_background.add(libarywallW);
        
        //7
        Sprite bookshelf2 = world.getMisc_sprites().getInterior_Bookshelf_double();
        bookshelf2.setPosition(100, 24);
        bookshelf2.setBoundary(new Rectangle2D(bookshelf2.getPositionX()+126,bookshelf2.getPositionY()+66,bookshelf2.getWidth(),bookshelf2.getHeight()));
        spriteList_background.add(bookshelf2);
        //8
        Sprite bookshelf3 = world.getMisc_sprites().getInterior_bookshelf();
        bookshelf3.setPosition(170, 24);
        bookshelf3.setBoundary(new Rectangle2D(bookshelf3.getPositionX()+126,bookshelf3.getPositionY()+66,bookshelf3.getWidth(),bookshelf3.getHeight()));
        spriteList_background.add(bookshelf3);
        //9
        Sprite bookshelf4 = world.getMisc_sprites().getInterior_Bookshelf_double();
        bookshelf4.setPosition(305, 24);
        bookshelf4.setBoundary(new Rectangle2D(bookshelf4.getPositionX()+126,bookshelf4.getPositionY()+66,bookshelf4.getWidth(),bookshelf4.getHeight()));
        spriteList_background.add(bookshelf4);
        //10
        Sprite chest2 = world.getMisc_sprites().getInterior_chest_britneyspears();
        chest2.setPosition(245, 30);
        chest2.setBoundary(new Rectangle2D(chest2.getPositionX()+126,chest2.getPositionY()+66,chest2.getWidth(),chest2.getHeight()));
        spriteList_background.add(chest2);
        //11
        Sprite bookshelf5 = world.getMisc_sprites().getInterior_Bookshelf_single();
        bookshelf5.setPosition(450, 24);
        bookshelf5.setBoundary(new Rectangle2D(bookshelf5.getPositionX()+126,bookshelf5.getPositionY()+66,bookshelf5.getWidth(),bookshelf5.getHeight()));
        spriteList_background.add(bookshelf5);
        //12
        Sprite bookshelf6 = world.getMisc_sprites().getInterior_Bookshelf_double();
        bookshelf6.setPosition(484, 24);
        bookshelf6.setBoundary(new Rectangle2D(bookshelf6.getPositionX()+126,bookshelf6.getPositionY()+66,bookshelf6.getWidth(),bookshelf6.getHeight()));
        spriteList_background.add(bookshelf6);
        //13
        Sprite bookshelf7 = world.getMisc_sprites().getInterior_Bookshelf_double();
        bookshelf7.setPosition(550, 24);
        bookshelf7.setBoundary(new Rectangle2D(bookshelf7.getPositionX()+126,bookshelf7.getPositionY()+66,bookshelf7.getWidth(),bookshelf7.getHeight()));
        spriteList_background.add(bookshelf7);
        //14
        Sprite alchemylab = world.getMisc_sprites().getAlchemy_Table();
        alchemylab.setPosition(520, 50);
        alchemylab.setBoundary(new Rectangle2D(alchemylab.getPositionX()+126,alchemylab.getPositionY()+66,alchemylab.getWidth(),alchemylab.getHeight()));
        spriteList_background.add(alchemylab);
        //15
        Sprite bookshelf8 = world.getMisc_sprites().getInterior_bookshelf();
        bookshelf8.setPosition(625, 24);
        bookshelf8.setBoundary(new Rectangle2D(bookshelf8.getPositionX()+126,bookshelf8.getPositionY()+66,bookshelf8.getWidth(),bookshelf8.getHeight()));
        spriteList_background.add(bookshelf8);
        
        
        
        
    }

    public List<Sprite> getSpriteList_foreground() {
        return spriteList_background;
    }
    public List<Sprite> getSpriteList_background(){
        return spriteList_foreground;
    }
    
    
}
