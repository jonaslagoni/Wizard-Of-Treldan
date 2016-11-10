/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.GroupSprites;

import Gui2D.SpriteController.SingleSprite.SingleSprite;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author jonas
 */
public class Groupsprite_GroupRender extends GroupSprite {
    
    public Groupsprite_GroupRender (SingleSprite sprites){
        super(sprites);
    }
    
    public Groupsprite_GroupRender (List<SingleSprite> sprites){
        super(sprites);
    }
    
    @Override
    public void render(GraphicsContext gc) {
        int sprite_number = 0;
        SingleSprite singleSprite =  getSprites().get(sprite_number);
        int current_height = 0;
        int current_width = 0;
        double randomPlacementY = 0;
        double randomPlacementX = 0;
        
        while(current_height+10 < super.getHeight()) {
            while(current_width+40 < super.getWidth()) {
                sprite_number = (int)Math.round((Math.random()*(getSprites().size()-1)));
                singleSprite =  getSprites().get(sprite_number);
                gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSprite_width(), singleSprite.getSprite_height(), getPositionX()+current_width, getPositionY()+current_height, singleSprite.getWidth(), singleSprite.getHeight());
                current_width += randomPlacementX;
                randomPlacementX = Math.random()*40+20;
            }
            current_width = (int)randomPlacementX;
            current_height += randomPlacementY;
            randomPlacementY = Math.random()*10+7;
        }
    }
    
    @Override
    public String toString() {
        return " Position: [" + getPositionX() + "," + getPositionY() + "]";
    }
    
}
