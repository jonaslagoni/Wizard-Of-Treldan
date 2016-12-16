package Gui2D.SpriteController.SingleSprite;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

public class SingleSprite extends AbstractSprite {

    //position of the sprite
    private double spritePosX;
    private double spritePosY;

    /**
     * constructor sets the position and size of the super class Then sets a
     * standard sprite position
     */
    public SingleSprite() {
        super.setPosition(0, 0);
        super.setSize(0, 0);
        spritePosX = 0;
        spritePosY = 0;
    }

    /**
     * Sets all the necessary variables for a singlesprite
     *
     * @param sPosX position x
     * @param sPosY position y
     * @param sW sprite width
     * @param sH sprite height
     * @param w width of the display
     * @param h height of the display
     * @param i the image
     */
    public SingleSprite(double sPosX, double sPosY, double sW, double sH, double w, double h, Image i) {
        super.setImage(i);
        super.setPosition(0, 0);
        super.setVelocity(0, 0);
        super.setSize(w, h);
        super.setSpriteSize(sW, sH);
        spritePosX = sPosX;
        spritePosY = sPosY;
        super.setBoundary(new Rectangle2D(super.getPositionX(), super.getPositionY(), super.getWidth(), super.getHeight()));
    }

    /**
     * Sets all the necessary variables for a singlesprite including custom
     * boundary
     *
     * @param sPosX position x
     * @param sPosY position y
     * @param sW sprite width
     * @param sH sprite height
     * @param w width of the display
     * @param h height of the display
     * @param i the image
     * @param boundary costum boundary
     */
    public SingleSprite(double sPosX, double sPosY, double sW, double sH, double w, double h, Image i, Rectangle2D boundary) {
        super.setImage(i);
        super.setPosition(0, 0);
        super.setVelocity(0, 0);
        super.setSize(w, h);
        super.setSpriteSize(sW, sH);
        spritePosX = sPosX;
        spritePosY = sPosY;
        super.setBoundary(boundary);
    }

    /**
     * renders the sprite to the canvas's graphic context
     *
     * @param gc GraphicsContext to render on
     */
    @Override
    public void render(GraphicsContext gc) {
        //gc.drawImage(image, positionX, getPositionY());
        gc.drawImage(super.getImage(), getSpritePosX(), getSpritePosY(), getSprite_width(), getSprite_height(), super.getPositionX(), super.getPositionY(), super.getWidth(), super.getHeight());
    }

    /**
     * Custom toString return position and velocity of the singlesprite
     *
     * @return String
     */
    @Override
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
