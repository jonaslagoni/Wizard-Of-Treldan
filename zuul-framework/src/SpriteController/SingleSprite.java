package SpriteController;

import SpriteController.Sprite;
import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Rectangle2D;

public class SingleSprite extends Sprite {

    private Image image;
    private double velocityX;
    private double velocityY;
    private double spritePosX;
    private double spritePosY;
    private double spriteWidth;
    private double spriteHeight;

    public SingleSprite() {
        setPosition(0,0);
        velocityX = 0;
        velocityY = 0;
        spritePosX = 0;
        spritePosY = 0;
    }

    public void setImage(Image i) {
        image = i;
        setWidth(i.getWidth());
        setHeight(i.getHeight());
        setSpriteHeight(i.getHeight());
        setSpriteWidth(i.getWidth());
    }

    public void setImage(String filename) {
        Image i = new Image(filename);
        setImage(i);
    }

    public void setVelocity(double x, double y) {
        velocityX = x;
        velocityY = y;
    }

    public void addVelocity(double x, double y) {
        velocityX += x;
        velocityY += y;
    }

    public void update(double time) {
        addPositionX(getVelocityX() * time);
        addPositionY(getVelocityY() * time);
    }

    public void render(GraphicsContext gc) {
        //gc.drawImage(image, positionX, getPositionY());
        gc.drawImage(getImage(), spritePosX, spritePosY, getSpriteWidth(), getSpriteHeight(), getPositionX(), getPositionY(), getWidth(), getHeight());
    }

    public boolean intersects(SingleSprite s) {
        return s.getBoundary().intersects(this.getBoundary());
    }

    public String toString() {
        return " Position: [" + getPositionX() + "," + getPositionY() + "]"
                + " Velocity: [" + getVelocityX() + "," + getVelocityY() + "]";
    }
    /**
     * @return the velocityX
     */
    public double getVelocityX() {
        return velocityX;
    }

    /**
     * @return the velocityY
     */
    public double getVelocityY() {
        return velocityY;
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

    /**
     * @return the spriteWidth
     */
    public double getSpriteWidth() {
        return spriteWidth;
    }

    /**
     * @param spriteWidth the spriteWidth to set
     */
    public void setSpriteWidth(double spriteWidth) {
        this.spriteWidth = spriteWidth;
    }

    /**
     * @return the spriteHeight
     */
    public double getSpriteHeight() {
        return spriteHeight;
    }

    /**
     * @param spriteHeight the spriteHeight to set
     */
    public void setSpriteHeight(double spriteHeight) {
        this.spriteHeight = spriteHeight;
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

}
