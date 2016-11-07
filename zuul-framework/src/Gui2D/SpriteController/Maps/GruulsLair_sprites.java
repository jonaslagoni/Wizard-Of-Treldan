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
 * @author jonas
 */
public class GruulsLair_sprites{
    private SpriteController world;
    
    
    private List<Sprite> gruulslair_background_sprites;
    
    public GruulsLair_sprites(SpriteController world){
        this.world = world;
        this.gruulslair_background_sprites = new ArrayList();
    }
    
    public void setGruulsLair_background_SingleSprites(){
        
        List<SingleSprite> singleSprites = new ArrayList();
        singleSprites.add(world.getGround_sprite().getStone_dark_1());
        singleSprites.add(world.getGround_sprite().getStone_dark_2());
        
        Sprite random = new Groupsprite_random(singleSprites);
        random.setSize(512,256);
        random.setPosition(128,256);
        gruulslair_background_sprites.add(random);
        
        Sprite door = world.getMisc_sprites().getDoor_metal();
        door.setPosition(100, 24);
        gruulslair_background_sprites.add(door);
        
        Sprite chest = world.getMisc_sprites().getChestClosed();
        chest.setPosition(256, 128);
        gruulslair_background_sprites.add(chest);
        
        Sprite bmushroom = world.getMisc_sprites().getBrownMushroom();
        bmushroom.setPosition(544, 222);
        gruulslair_background_sprites.add(bmushroom);
    }

    /**
     * @return the gruulslair_background_sprites
     */
    public List<Sprite> getGruulslair_background_sprites() {
        return gruulslair_background_sprites;
    }

   
    
}
