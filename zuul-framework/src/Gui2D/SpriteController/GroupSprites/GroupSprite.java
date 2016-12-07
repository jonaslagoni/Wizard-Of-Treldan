/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.GroupSprites;

import Gui2D.SpriteController.SingleSprite.SingleSprite;
import Gui2D.SpriteController.Sprite;
import java.util.ArrayList;
import java.util.List;
/**
 * Abstract class for GroupSprites
 * @author jonas
 */
public abstract class GroupSprite extends Sprite{
    private List<SingleSprite> sprites;
    
    /**
     * Creates the object from a single SingleSprites
     * @param sprites 
     */
    public GroupSprite(SingleSprite sprites) {
        this.sprites = new ArrayList();
        this.sprites.add(sprites);
        super.setPosition(0, 0);
    }
    
    /**
     * Creates the object from a list of SingleSprites
     * @param sprites 
     */
    public GroupSprite(List<SingleSprite> sprites) {
        this.sprites = sprites;
        super.setPosition(0, 0);
    }
    
    /**
     * @return the sprites
     */
    public List<SingleSprite> getSprites() {
        return sprites;
    }

    /**
     * @param sprites the sprites to set
     */
    public void setSprites(List<SingleSprite> sprites) {
        this.sprites = sprites;
    }
}
