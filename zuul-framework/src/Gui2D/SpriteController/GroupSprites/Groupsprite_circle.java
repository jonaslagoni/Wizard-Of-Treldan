/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.GroupSprites;

import Gui2D.SpriteController.SingleSprite.SingleSprite;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author jonas
 */
public class Groupsprite_circle extends GroupSprite{
    
    /**
     * Create object with a SingleSprite
     * @param sprites 
     */
    public Groupsprite_circle(SingleSprite sprites){
        super(sprites);
    }
    
    /**
     * Create object with List of SingleSprite
     * @param sprites 
     */
    public Groupsprite_circle(List<SingleSprite> sprites){
        super(sprites);
    }
    
    /**
     * Render function for this object.
     * This object needs atleast 8 sprites to draw
     * @param gc 
     */
    public void render(GraphicsContext gc) {
        // if there are not atleast 8 sprites cant draw
        if(super.getSprites().size() >= 8){
            //set our counter for which direction we are at.
            int counter = 0;
            //set our initial x and y position
            int posX = (int)super.getPositionX(), posY = (int)super.getPositionY();
            // keep track of our last sprite
            SingleSprite lastSingleSprite = new SingleSprite();
            
            // Go through each sprite in our list
            for(SingleSprite singleSprite: super.getSprites()){
                //which sprite are we at
                switch(counter){
                    case 0: // if NW
                        gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSprite_width(), singleSprite.getSprite_height(), posX, posY, singleSprite.getWidth(), singleSprite.getHeight());
                        
                        //add the sprite's width to x position
                        posX += singleSprite.getWidth();
                        break;
                    case 1: // if N
                        /**
                         * Go through as many times it takes before the whole width is filled except the two corners
                         */
                        for(int i = 0; i <= this.getWidth()-lastSingleSprite.getWidth()*3; i += singleSprite.getWidth()){
                            gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSprite_width(), singleSprite.getSprite_height(), posX, posY, singleSprite.getWidth(), singleSprite.getHeight());
                            
                            //add the sprite's width to x position
                            posX += singleSprite.getWidth();
                        }
                        break;
                    case 2: // if NE
                        gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSprite_width(), singleSprite.getSprite_height(), posX, posY, singleSprite.getWidth(), singleSprite.getHeight());
                        
                        // add the sprite's height to y position
                        posY += singleSprite.getHeight();
                        break;
                    case 3: // if E
                        
                        /**
                         * Go through as many times it takes before the whole height is filled except the two corners
                         */
                        for(int i = 0; i <= this.getHeight()-lastSingleSprite.getHeight()*3; i += singleSprite.getHeight()){
                            gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSprite_width(), singleSprite.getSprite_height(), posX, posY, singleSprite.getWidth(), singleSprite.getHeight());
                            
                            // add the sprite's height to y position
                            posY += singleSprite.getHeight();
                        }
                        break;
                    case 4: // if SE
                        gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSprite_width(), singleSprite.getSprite_height(), posX, posY, singleSprite.getWidth(), singleSprite.getHeight());
                        
                        //substract the sprite's width to x position
                        posX -= singleSprite.getWidth();
                        break;
                    case 5: // if S
                        /**
                         * Go through as many times it takes before the whole width is filled except the two corners
                         */
                        for(int i = 0; i <= this.getWidth()-lastSingleSprite.getWidth()*3; i += singleSprite.getWidth()){
                            gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSprite_width(), singleSprite.getSprite_height(), posX, posY, singleSprite.getWidth(), singleSprite.getHeight());
                            
                            //substract the sprite's width to x position
                            posX -= singleSprite.getWidth();
                        }
                        break;
                    case 6: // if SW
                        gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSprite_width(), singleSprite.getSprite_height(), posX, posY, singleSprite.getWidth(), singleSprite.getHeight());
                        
                        //substract the height to the y position
                        posY -= singleSprite.getHeight();
                        break;
                    case 7: // if W
                        /**
                         * Go through as many times it takes before the whole height is filled except the two corners
                         */
                        for(int i = 0; i <= this.getHeight()-lastSingleSprite.getHeight()*3; i += singleSprite.getHeight()){
                            gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSprite_width(), singleSprite.getSprite_height(), posX, posY, singleSprite.getWidth(), singleSprite.getHeight());
                            
                            //substract the height to the y position
                            posY -= singleSprite.getHeight();
                        }
                        break;
                    case 8: // if CENTER
                        posX = (int)this.getPositionX()+32;
                        posY = (int)this.getPositionY()+32;
                        for(int i = 0; i <= this.getHeight()-lastSingleSprite.getHeight()*3; i += singleSprite.getHeight()){
                            for(int k = 0; k <= this.getWidth()-lastSingleSprite.getHeight()*3; k += singleSprite.getWidth()){
                                gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSprite_width(), singleSprite.getSprite_height(), posX, posY, singleSprite.getWidth(), singleSprite.getHeight());
                                posX += singleSprite.getWidth();
                            } 
                            posX = (int)this.getPositionX()+32;
                            gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSprite_width(), singleSprite.getSprite_height(), posX, posY, singleSprite.getWidth(), singleSprite.getHeight());
                            posY += singleSprite.getHeight();
                        }
                        break;
                }
                counter++;
                lastSingleSprite = singleSprite;
            }
        }
    }
    
}
