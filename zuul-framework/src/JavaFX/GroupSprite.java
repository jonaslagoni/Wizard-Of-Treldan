/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFX;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author jonas
 */
public class GroupSprite extends Sprite{
    private List<SingleSprite> sprites = new ArrayList();
    private double positionX;
    private double positionY;
    private double width;
    private double height;

    public GroupSprite(SingleSprite sprites) {
        this.sprites.add(sprites);
        positionX = 0;
        positionY = 0;
    }
    
    public GroupSprite(List<SingleSprite> sprites) {
        this.sprites = sprites;
        positionX = 0;
        positionY = 0;
    }

    public void setPosition(double x, double y) {
        positionX = x;
        positionY = y;
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
     * @return the positionY
     */
    public double getPositionY() {
        return positionY;
    }

    /**
     * @return the positionX
     */
    public double getPositionX() {
        return positionX;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
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
