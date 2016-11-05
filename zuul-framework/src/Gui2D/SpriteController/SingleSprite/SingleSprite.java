package Gui2D.SpriteController.SingleSprite;

import Gui2D.SpriteController.Sprite;
import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;

public class SingleSprite extends Sprite {
    private double spritePosX;
    private double spritePosY;

    public SingleSprite() {
        super.setPosition(0,0);
        super.setSize(0, 0);
        spritePosX = 0;
        spritePosY = 0;
    }

    public SingleSprite(double sPosX, double sPosY, double sW, double sH, double w, double h, Image i) {
        super.setImage(i);
        super.setPosition(0,0);
        super.setVelocity(0, 0);
        super.setSpriteSize(sW, sH);
        super.setSize(w, h);
        spritePosX = sPosX;
        spritePosY = sPosY;
        
    }
    
    public void render(GraphicsContext gc) {
        //gc.drawImage(image, positionX, getPositionY());
        gc.drawImage(super.getImage(), getSpritePosX(), getSpritePosY(), super.getSprite_width(), super.getSprite_height(), super.getPositionX(), super.getPositionY(), super.getWidth(), super.getHeight());
    }

    public String toString() {
        return " Position: [" + getPositionX() + "," + getPositionY() + "]"
                + " Velocity: [" + getVelocityX() + "," + getVelocityY() + "]";
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
