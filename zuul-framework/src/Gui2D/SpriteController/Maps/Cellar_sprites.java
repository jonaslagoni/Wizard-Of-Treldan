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
public class Cellar_sprites extends SpriteController{
    //list of grass sprites this map uses
    private List<SingleSprite> celler_grass_singlesprites;
    
    
    //contains all the sprites kept in the background
    private List<Sprite> cellar_background_sprites;
    
    public void setCellar_background_SingleSprites(){
        cellar_background_sprites = new ArrayList();
        celler_grass_singlesprites = new ArrayList();
        
        celler_grass_singlesprites.add(super.getGround_sprite().getGrass_light_1());
        celler_grass_singlesprites.add(super.getGround_sprite().getGrass_light_2());
        celler_grass_singlesprites.add(super.getGround_sprite().getGrass_light_3());
        celler_grass_singlesprites.add(super.getGround_sprite().getGrass_flowers_1());
        
        Sprite random_group_grass = new Groupsprite_random(celler_grass_singlesprites);
        random_group_grass.setPosition(0, 0);
        random_group_grass.setSize(1024, 512);
        cellar_background_sprites.add(random_group_grass);
    }

    /**
     * @return the cellar_background_sprites
     */
    public List<Sprite> getCellar_background_sprites() {
        return cellar_background_sprites;
    }
}
