/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * using http://gaurav.munjal.us/Universal-LPC-Spritesheet-Character-Generator/
 */
package JavaFX;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author jonas
 */
public class PlayerSprite {
    private Image image;
    private double positionX;
    private double positionY;
    private double velocityX;
    private double velocityY;
    private double width;
    private double height;
    private Direction direction;
    private int animationCounter;
    private int animationDelay;
    public PlayerSprite() {
        positionX = 0;
        positionY = 0;
        velocityX = 0;
        velocityY = 0;
        direction = Direction.STANDSTILL;
        animationCounter = 3;
        animationDelay = 1;
    }
    
    public enum Direction {
        STANDSTILL, WALK_UP, WALK_LEFT, WALK_RIGHT, WALK_DOWN;
    }
    
    public void setImage(Image i) {
        image = i;
        setWidth(i.getWidth());
        setHeight(i.getHeight());
    }

    public void setImage(String filename) {
        Image i = new Image(filename);
        setImage(i);
    }

    public void setPosition(double x, double y) {
        positionX = x;
        positionY = y;
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
        positionX += getVelocityX() * time;
        positionY += getVelocityY() * time;
    }

    public void render(GraphicsContext gc) {
        //gc.drawImage(image, positionX, getPositionY());
        if(getDirection().equals(Direction.STANDSTILL)){
            gc.drawImage(getImage(), 8+(64*0), 8+(64*2), 64, 64, positionX, positionY, 64, 64);
        }else if(getDirection().equals(Direction.WALK_DOWN)){
            gc.drawImage(getImage(), 8+(64*animationCounter), 8+(64*10), 64, 64, positionX, positionY, 64, 64);
        }else if(getDirection().equals(Direction.WALK_LEFT)){
            gc.drawImage(getImage(), 8+(64*animationCounter), 8+(64*9), 64, 64, positionX, positionY, 64, 64);
        }else if(getDirection().equals(Direction.WALK_UP)){
            gc.drawImage(getImage(), 8+(64*animationCounter), 8+(64*8), 64, 64, positionX, positionY, 64, 64);
        }else if(getDirection().equals(Direction.WALK_RIGHT)){
            gc.drawImage(getImage(), 8+(64*animationCounter), 8+(64*11), 64, 64, positionX, positionY, 64, 64);
        }
        if(animationCounter != 8){
            if(animationDelay == 4){
                animationCounter++;
                animationDelay = 0;
            }else{
                animationDelay++;
            }
        }else{
            animationCounter = 1;
        }
        
    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D(positionX, getPositionY(), getWidth(), getHeight());
    }

    public boolean intersects(SingleSprite s) {
        return s.getBoundary().intersects(this.getBoundary());
    }

    public String toString() {
        return " Position: [" + positionX + "," + getPositionY() + "]"
                + " Velocity: [" + getVelocityX() + "," + getVelocityY() + "]";
    }

    /**
     * @return the positionY
     */
    public double getPositionY() {
        return positionY;
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
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
