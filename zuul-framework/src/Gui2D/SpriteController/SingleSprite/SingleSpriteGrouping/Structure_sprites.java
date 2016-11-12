/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping;
import Gui2D.SpriteController.SingleSprite.SingleSprite;
import Gui2D.SpriteController.SingleSprite.SingleSpriteGrouping.Structure.*;
/**
 *
 * @author Lagoni
 */
public class Structure_sprites {
    /**
     * 
     * @return the singlesprite of the stone_wall_E
     */
    public SingleSprite getStone_wall_E(){
        return new Stone_wall_E().getSprite();
    }
    
    /**
     * 
     * @return the singlesprite of the stone_wall_N
     */
    public SingleSprite getStone_wall_N(){
        return new Stone_wall_N().getSprite();
    }
    
    /**
     * 
     * @return the singlesprite of the stone_wall_NE
     */
    public SingleSprite getStone_wall_NE(){
        return new Stone_wall_NE().getSprite();
    }
    
    /**
     * 
     * @return the singlesprite of the stone_wall_NW
     */
    public SingleSprite getStone_wall_NW(){
        return new Stone_wall_NW().getSprite();
    }
    
    /**
     * 
     * @return the singlesprite of the stone_wall_S
     */
    public SingleSprite getStone_wall_S(){
        return new Stone_wall_S().getSprite();
    }
    
    /**
     * 
     * @return the singlesprite of the stone_wall_SE
     */
    public SingleSprite getStone_wall_SE(){
        return new Stone_wall_SE().getSprite();
    }
    
    /**
     * 
     * @return the singlesprite of the stone_wall_SW
     */
    public SingleSprite getStone_wall_SW(){
        return new Stone_wall_SW().getSprite();
    }
    
    /**
     * 
     * @return the singlesprite of the stone_wall_W
     */
    public SingleSprite getStone_wall_W(){
        return new Stone_wall_W().getSprite();
    }
    
    //wood fence
    public SingleSprite getWood_fence_W(){
        return new Wood_fence_W().getSprite();
    }
    public SingleSprite getWood_fence_N(){
        return new Wood_fence_N().getSprite();
    }
    public SingleSprite getWood_fence_E(){
        return new Wood_fence_E().getSprite();
    }
    public SingleSprite getWood_fence_S(){
        return new Wood_fence_S().getSprite();
    }
    public SingleSprite getWood_fence_NW(){
        return new Wood_fence_NW().getSprite();
    }
    public SingleSprite getWood_fence_NE(){
        return new Wood_fence_NE().getSprite();
    }
    public SingleSprite getWood_fence_SW(){
        return new Wood_fence_SW().getSprite();
    }
    public SingleSprite getWood_fence_SE(){
        return new Wood_fence_SE().getSprite();
    }
}
