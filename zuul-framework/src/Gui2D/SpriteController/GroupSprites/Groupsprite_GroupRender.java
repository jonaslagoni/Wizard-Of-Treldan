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
        while(current_height < super.getHeight()) {
            double randomPlacementY = Math.random()*20+1;
            while(current_width < super.getWidth()) {
                double randomPlacementX = Math.random()*50+30;
                sprite_number = (int)Math.round((Math.random()*(getSprites().size()-1)));
                singleSprite =  getSprites().get(sprite_number);
                gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSprite_width(), singleSprite.getSprite_height(), getPositionX()+current_width + randomPlacementX, getPositionY()+current_height, singleSprite.getWidth(), singleSprite.getHeight());
                current_width += randomPlacementX;
            }
            current_width = 0;
            current_height += randomPlacementY;
        }
    }
    
    @Override
    public String toString() {
        return " Position: [" + getPositionX() + "," + getPositionY() + "]";
    }
    
}
