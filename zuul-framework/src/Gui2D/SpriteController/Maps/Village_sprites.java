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
public class Village_sprites{
    private SpriteController world;
    private List<Sprite> village_background_sprites;
    
    private List<SingleSprite> village_background_ground;
    
    
    public Village_sprites(SpriteController world){
        this.world = world;
    }
    
    public void setVillage_background_SingleSprites(){
        
    }

    /**
     * @return the village_background_sprites
     */
    public List<Sprite> getVillage_background_sprites() {
        return village_background_sprites;
    }
    
}
