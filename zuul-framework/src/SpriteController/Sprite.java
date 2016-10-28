/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpriteController;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author jonas
 */
public abstract class Sprite {
    private double positionX;
    private double positionY;
    private double width;
    private double height;
    public void setPosition(double x, double y){
        setPositionX(x);
        setPositionY(y);
    }
    public void setSize(double width, double height){
        this.setWidth(width);
        this.setHeight(height);
    }
    
    public void addPositionX(double add){
        setPositionX(getPositionX() + add);
    }
    
    public void addPositionY(double add){
        setPositionY(getPositionY() + add);
    }
    
    /**
     * 
     * @param gc 
     */
    public abstract void render(GraphicsContext gc);
    
    /**
     * 
     * @return 
     */
    public abstract Rectangle2D getBoundary();

    /**
     * @param positionX the positionX to set
     */
    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    /**
     * @param positionY the positionY to set
     */
    public void setPositionY(double positionY) {
        this.positionY = positionY;
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
     * @return the positionX
     */
    public double getPositionX() {
        return positionX;
    }

    /**
     * @return the positionY
     */
    public double getPositionY() {
        return positionY;
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
}
