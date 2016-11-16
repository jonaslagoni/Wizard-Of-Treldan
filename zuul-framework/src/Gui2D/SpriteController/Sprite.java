/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController;

import java.awt.Rectangle;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author jonas
 */
public abstract class Sprite {
    // Our image we use as a spritesheet
    private Image image;
    
    // Position x and y
    private double positionX;
    private double positionY;
    
    // Velocity which way it should move
    private double velocityX;
    private double velocityY;
    
    //the width and height of the player sprite
    private double width;
    private double height;
    
    /**
     * The sprite width and height this is not the width and height of the image displayed.
     * This is the single sprite width and height in the sprite sheet
     */
    private double sprite_width = 64;
    private double sprite_height = 64;
    
    private Rectangle2D boundary;
    
    /**
     * Every class extended by Sprite need a render function.
     * @param gc 
     */
    public abstract void render(GraphicsContext gc);
    
    /**
     * return a normal boundary for the sprite
     * @return 
     */
    public Rectangle2D getBoundary(){
        return boundary;
    }
    
    /**
     * Set image with and Image
     * @param i 
     */
    public void setImage(Image i) {
        image = i;
    }

    /**
     * Set our image by filename
     * @param filename 
     */
    public void setImage(String filename) {
        setImage(new Image(filename));
    }
    
    /**
     * Set the spriteSize, both width and height
     * @param sprite_width
     * @param sprite_height 
     */
    public void setSpriteSize(double sprite_width, double sprite_height){
        this.setSprite_height(sprite_height);
        this.setSprite_width(sprite_width);
        updateBoundary();
    }
    
    /**
     * Set our x and y position
     * @param x
     * @param y 
     */
    public void setPosition(double x, double y) {
        setPositionX(x);
        setPositionY(y);
        updateBoundary();
    }

    /**
     * Set movement to the player so his position will change.
     * Set both for x and y.
     * @param x
     * @param y 
     */
    public void setVelocity(double x, double y) {
        setVelocityX(x);
        setVelocityY(y);
    }

    /**
     * Add movement to the player so his position will change.
     * Add both for x and y.
     * @param x
     * @param y 
     */
    public void addVelocity(double x, double y) {
        setVelocityX(getVelocityX() + x);
        setVelocityY(getVelocityY() + y);
    }

    /**
     * update our position by using the velocity and a time passed to make it smooth
     * @param time 
     */
    public void update(double time) {
        setPositionX(getPositionX() + getVelocityX() * time);
        setPositionY(getPositionY() + getVelocityY() * time);
        updateBoundary();
    }

    
    /**
     * Set both width and height
     * @param width
     * @param height 
     */
    public void setSize(double width, double height){
        this.setWidth(width);
        this.setHeight(height);
        updateBoundary();
    }
    
    /**
     * Add double to the current X position
     * @param add 
     */
    public void addPositionX(double add){
        setPositionX(getPositionX() + add);
        updateBoundary();
    }
    
    /**
     * Add double to the current Y position
     * @param add 
     */
    public void addPositionY(double add){
        setPositionY(getPositionY() + add);
        updateBoundary();
    }
    
    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @return the positionX
     */
    public double getPositionX() {
        return positionX;
    }

    /**
     * @param positionX the positionX to set
     */
    public void setPositionX(double positionX) {
        this.positionX = positionX;
        updateBoundary();
    }

    /**
     * @return the positionY
     */
    public double getPositionY() {
        return positionY;
    }

    /**
     * @param positionY the positionY to set
     */
    public void setPositionY(double positionY) {
        this.positionY = positionY;
        updateBoundary();
    }

    /**
     * @return the velocityX
     */
    public double getVelocityX() {
        return velocityX;
    }

    /**
     * @param velocityX the velocityX to set
     */
    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    /**
     * @return the velocityY
     */
    public double getVelocityY() {
        return velocityY;
    }

    /**
     * @param velocityY the velocityY to set
     */
    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
        updateBoundary();
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
        updateBoundary();
    }

    /**
     * @param sprite_width the sprite_width to set
     */
    public void setSprite_width(double sprite_width) {
        this.sprite_width = sprite_width;
    }

    /**
     * @param sprite_height the sprite_height to set
     */
    public void setSprite_height(double sprite_height) {
        this.sprite_height = sprite_height;
    }

    /**
     * @return the sprite_width
     */
    public double getSprite_width() {
        return sprite_width;
    }

    /**
     * @return the sprite_height
     */
    public double getSprite_height() {
        return sprite_height;
    }

    /**
     * @param boundary the boundary to set
     */
    public void setBoundary(Rectangle2D boundary) {
        this.boundary = boundary;
    }

    public void updateBoundary(){
        setBoundary(new Rectangle2D(getPositionX(), getPositionY(), getWidth(), getHeight()));
    }
}
