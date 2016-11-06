package Gui2D.SpriteController.SingleSprite;

import Gui2D.SpriteController.Sprite;
import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;

public class SingleSprite extends Sprite {
    //position of the sprite
    private double spritePosX;
    private double spritePosY;

    /**
     *  constructor sets the position and size of the super class
     *  Then sets a standard sprite position
     */
    public SingleSprite() {
        super.setPosition(0,0);
        super.setSize(0, 0);
        spritePosX = 0;
        spritePosY = 0;
    }

    /**
     * Sets all the necessary variables 
     * @param sPosX
     * @param sPosY
     * @param sW
     * @param sH
     * @param w
     * @param h
     * @param i 
     */
    public SingleSprite(double sPosX, double sPosY, double sW, double sH, double w, double h, Image i) {
        super.setImage(i);
        super.setPosition(0,0);
        super.setVelocity(0, 0);
        super.setSpriteSize(sW, sH);
        super.setSize(w, h);
        spritePosX = sPosX;
        spritePosY = sPosY;
        
    }
    
    /**
     * renders the sprite to the canvas's graphic context
     * @param gc 
     */
    public void render(GraphicsContext gc) {
        //gc.drawImage(image, positionX, getPositionY());
        gc.drawImage(super.getImage(), getSpritePosX(), getSpritePosY(), super.getSprite_width(), super.getSprite_height(), super.getPositionX(), super.getPositionY(), super.getWidth(), super.getHeight());
    }

    /**
     * Custom toString return position and velocity of the singlesprite
     * @return 
     */
    public String toString() {
        return " Position: [" + super.getPositionX() + "," + super.getPositionY() + "]"
                + " Velocity: [" + super.getVelocityX() + "," + super.getVelocityY() + "]";
    }

    /**
     * @return the spritePosX
     */
    public double getSpritePosX() {
        return spritePosX;
    }

    /**
     * @param spritePosX the spritePosX to set
     */
    public void setSpritePosX(double spritePosX) {
        this.spritePosX = spritePosX;
    }

    /**
     * @return the spritePosY
     */
    public double getSpritePosY() {
        return spritePosY;
    }

    /**
     * @param spritePosY the spritePosY to set
     */
    public void setSpritePosY(double spritePosY) {
        this.spritePosY = spritePosY;
    }
}
