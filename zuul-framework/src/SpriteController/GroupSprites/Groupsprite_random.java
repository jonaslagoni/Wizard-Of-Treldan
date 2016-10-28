/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpriteController.GroupSprites;

import SpriteController.SingleSprite;
import SpriteController.Sprite;
import SpriteController.Sprite;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author jonas
 */
public class Groupsprite_random extends Sprite implements Groupsprite{
    private List<SingleSprite> sprites;

    public Groupsprite_random(SingleSprite sprites) {
        this.sprites = new ArrayList<SingleSprite>();
        this.sprites.add(sprites);
        setPosition(0, 0);
    }
    
    public Groupsprite_random(List<SingleSprite> sprites) {
        this.sprites = sprites;
        setPosition(0, 0);
    }

    public void render(GraphicsContext gc) {
        int sprite_number = 0;
        SingleSprite singleSprite =  getSprites().get(sprite_number);
        //gc.drawImage(image, positionX, getPositionY());
        double renderCounterHeight = Math.round(height/singleSprite.getHeight());
        double renderCounterWidth = Math.round(width/singleSprite.getWidth());
        
        for(int i = 0; i < renderCounterHeight; i++){
            for(int k = 0; k < renderCounterWidth; k++){
                sprite_number = (int)Math.round((Math.random()*(getSprites().size()-1)));
                singleSprite =  getSprites().get(sprite_number);
                gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSpriteWidth(), singleSprite.getSpriteHeight(), getPositionY()+(singleSprite.getWidth()*k), getPositionX()+(singleSprite.getHeight()*i), singleSprite.getWidth(), singleSprite.getHeight());
            }
            gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSpriteWidth(), singleSprite.getSpriteHeight(), getPositionY(), getPositionX()+(singleSprite.getHeight()*i), singleSprite.getWidth(), singleSprite.getHeight());
        }
        
    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D(getPositionX(), getPositionY(), getWidth(), getHeight());
    }


    public String toString() {
        return " Position: [" + getPositionX() + "," + getPositionY() + "]";
    }


    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the sprites
     */
    public List<SingleSprite> getSprites() {
        return sprites;
    }
}
