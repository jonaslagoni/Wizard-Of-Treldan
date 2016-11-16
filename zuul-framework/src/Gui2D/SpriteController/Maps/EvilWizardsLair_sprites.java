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
public class EvilWizardsLair_sprites{
    private SpriteController world;
    
    private List<Sprite> spriteList;
    
    public EvilWizardsLair_sprites(SpriteController world){
        this.world = world;
        this.spriteList = new ArrayList();
    }
    
    public void setEvilWizardsLair_background_SingleSprites(){
        
        Sprite bob = world.getGround_sprite().getGrass_light_1();
        bob.setSize(32, 32);
        bob.setPosition(128, 128);
        spriteList.add(bob);
        
    }

    public List<Sprite> getSpriteList() {
        return spriteList;
    }
    
}
