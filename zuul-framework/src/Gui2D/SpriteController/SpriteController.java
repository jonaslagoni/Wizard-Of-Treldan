/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController;

import Gui2D.SpriteController.Maps.Cellar_sprites;
import Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping.*;
import javafx.scene.image.Image;

/**
 *
 * @author jonas
 */
public class SpriteController {
    //The spritesheet used for all the sprites
    private static final Image SPRITESHEET = new Image("spriteSheet.png");
    private static final Image PLAYER_SPRITESHEET = new Image("player.png");
    
    //all ground sprites
    private Ground_sprites ground_sprite;
    //all misc sprites
    private Misc_sprites misc_sprites;
    //all water sprites
    private Water_sprites water_sprites;
    //all structure sprites
    private Structure_sprites structure_sprites;
    
    public SpriteController(){
        //Lets start by init every single sprite in the game so everything is ready to use
        initSingleSprites();
    }
    
    public void initSingleSprites(){
        ground_sprite = new Ground_sprites();
        misc_sprites = new Misc_sprites();
        water_sprites = new Water_sprites();
        structure_sprites = new Structure_sprites();
    }

    /**
     * @return the ground_sprite
     */
    public Ground_sprites getGround_sprite() {
        return ground_sprite;
    }

    /**
     * @return the misc_sprites
     */
    public Misc_sprites getMisc_sprites() {
        return misc_sprites;
    }

    /**
     * @return the water_sprites
     */
    public Water_sprites getWater_sprites() {
        return water_sprites;
    }
    
    /**
     * @return the SPRITESHEET
     */
    public static Image getSPRITESHEET() {
        return SPRITESHEET;
    }

    /**
     * @return the PLAYER_SPRITESHEET
     */
    public static Image getPLAYER_SPRITESHEET() {
        return PLAYER_SPRITESHEET;
    }

    /**
     * @return the structure_sprites
     */
    public Structure_sprites getStructure_sprites() {
        return structure_sprites;
    }

}
