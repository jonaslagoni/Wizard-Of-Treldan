/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.SingleSprite;

import Gui2D.SpriteController.Sprite;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * PlayerSprite which is a player who can move based on as sprite sheet
 * This class functions with every sprite sheet on
 * http://gaurav.munjal.us/Universal-LPC-Spritesheet-Character-Generator/
 * @author jonas
 */
public class PlayerSprite extends Sprite{
    // Directions variable for keep controll over which direction the sprite is moving
    private Direction direction;
    
    /** 
     * Animation counter and delay for rendering purposes.
     * animationCounter is used for controlling which sprite animation we have come to.
     * animationDelay is to delay when to change the sprite animation.
     */ 
    private int animationCounter;
    private int animationDelay;
    
    
    /**
     * Constructor for player
     */
    public PlayerSprite() {
        //set position to 0 as a start
        super.setPosition(0, 0);
        
        //set velocity to 0 (we dont need to move on create)
        super.setVelocity(0, 0);
        
        
        //set our direction we are facing to standstill
        direction = Direction.STANDSTILL;
        
        //animation counter for rendering
        animationCounter = 1;
        animationDelay = 1;
    }
    
    /**
     * Our direction the player is walking.
     */
    public enum Direction {
        STANDSTILL, WALK_UP, WALK_LEFT, WALK_RIGHT, WALK_DOWN;
    }
    

    /**
     * Our render function which draws our image on the canvas's GraphicsContext
     * @param gc 
     */
    public void render(GraphicsContext gc) {
        //check which direction this object is facing.
        if(getDirection().equals(Direction.STANDSTILL)){
            //draw the animation using standstill sprite.
            gc.drawImage(getImage(), 8+(64*0), 8+(64*2), super.getSprite_width(), super.getSprite_height(), getPositionX(), getPositionY(), super.getWidth(), super.getHeight());
        }else if(getDirection().equals(Direction.WALK_DOWN)){
            //draw the sprite using walk_down animation.
            gc.drawImage(getImage(), 8+(64*animationCounter), 8+(64*10), super.getSprite_width(), super.getSprite_height(), getPositionX(), getPositionY(), super.getWidth(), super.getHeight());
        }else if(getDirection().equals(Direction.WALK_LEFT)){
            //draw the sprite using walk_left animation.
            gc.drawImage(getImage(), 8+(64*animationCounter), 8+(64*9), super.getSprite_width(), super.getSprite_height(), getPositionX(), getPositionY(), super.getWidth(), super.getHeight());
        }else if(getDirection().equals(Direction.WALK_UP)){
            //draw the sprite using walk_up animation.
            gc.drawImage(getImage(), 8+(64*animationCounter), 8+(64*8), super.getSprite_width(), super.getSprite_height(), getPositionX(), getPositionY(), super.getWidth(), super.getHeight());
        }else if(getDirection().equals(Direction.WALK_RIGHT)){
            //draw the sprite using walk_right animation.
            gc.drawImage(getImage(), 8+(64*animationCounter), 8+(64*11), super.getSprite_width(), super.getSprite_height(), getPositionX(), getPositionY(), super.getWidth(), super.getHeight());
        }
        //If the animationCounter is 8 reset back to 1 since there are no more animations after 8 sprites.
        if(animationCounter != 8){
            //only update the animationCounter each 4th times the render function is called.
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
    
    public boolean intersect(Sprite s){
        //Since the player sprite is not 100 % accurate we have to tweek its boundaries so it will look natural.
        Rectangle2D player_boundary = new Rectangle2D(getPositionX(), getPositionY(), getWidth(), getHeight());
        return player_boundary.intersects(s.getBoundary());
    }
    
    /**
     * Check if the player is intersecting N into another sprite.
     * @param s
     * @return 
     */
    public boolean intersects_top(Sprite s) {
        //Since the player sprite is not 100 % accurate we have to tweek its boundaries so it will look natural.
        Rectangle2D player_boundary = new Rectangle2D(getPositionX()+15, getPositionY()+getHeight()-22, getWidth()-47, 5);
        return player_boundary.intersects(s.getBoundary());
    }
    
    /**
     * Check if the player is intersecting S into another sprite.
     * @param s
     * @return 
     */
    public boolean intersects_bottom(Sprite s) {
        //Since the player sprite is not 100 % accurate we have to tweek its boundaries so it will look natural.
        Rectangle2D player_boundary = new Rectangle2D(getPositionX()+15, getPositionY()+getHeight()-14, getWidth()-47, 5);
        return player_boundary.intersects(s.getBoundary());
    }
    
    /**
     * Check if the player is intersecting W into another sprite.
     * @param s
     * @return 
     */
    public boolean intersects_left(Sprite s) {
        //Since the player sprite is not 100 % accurate we have to tweek its boundaries so it will look natural.
        Rectangle2D player_boundary = new Rectangle2D(getPositionX()+8, getPositionY()+getWidth()-20, 5, 10);
        return player_boundary.intersects(s.getBoundary());
    }
    
    /**
     * Check if the player is intersecting E into another sprite.
     * @param s
     * @return 
     */
    public boolean intersects_right(Sprite s) {
        //Since the player sprite is not 100 % accurate we have to tweek its boundaries so it will look natural.
        Rectangle2D player_boundary = new Rectangle2D(getPositionX()+getWidth()-30,  getPositionY()+getWidth()-20, 5, 10);
        return player_boundary.intersects(s.getBoundary());
    }
    
    /**
     * Check if the player is intersecting N into a Rectangle2D.
     * @param worldBoundary
     * @return 
     */
    public boolean intersects_top(Rectangle2D worldBoundary) {
        //Since the player sprite is not 100 % accurate we have to tweek its boundaries so it will look natural.
        Rectangle2D player_boundary = new Rectangle2D(getPositionX(), getPositionY()-20, getWidth(), getHeight());
        return player_boundary.intersects(worldBoundary);
    }
    
    /**
     * Check if the player is intersecting S into a Rectangle2D.
     * @param worldBoundary
     * @return 
     */
    public boolean intersects_bottom(Rectangle2D worldBoundary) {
        //Since the player sprite is not 100 % accurate we have to tweek its boundaries so it will look natural.
        Rectangle2D player_boundary = new Rectangle2D(getPositionX(), getPositionY(), getWidth(), getHeight()-20);
        return player_boundary.intersects(worldBoundary);
    }
    
    /**
     * Check if the player is intersecting W into a Rectangle2D.
     * @param worldBoundary
     * @return 
     */
    public boolean intersects_left(Rectangle2D worldBoundary) {
        //Since the player sprite is not 100 % accurate we have to tweek its boundaries so it will look natural.
        Rectangle2D player_boundary = new Rectangle2D(getPositionX()-25, getPositionY(), getWidth(), getHeight());
        return player_boundary.intersects(worldBoundary);
    }
    
    /**
     * Check if the player is intersecting E into a Rectangle2D.
     * @param worldBoundary
     * @return 
     */
    public boolean intersects_right(Rectangle2D worldBoundary) {
        //Since the player sprite is not 100 % accurate we have to tweek its boundaries so it will look natural.
        Rectangle2D player_boundary = new Rectangle2D(getPositionX(), getPositionY(), getWidth()-25, getHeight());
        return player_boundary.intersects(worldBoundary);
    }
    
    /**
     * Return position and velocity of the class
     * @return 
     */
    public String toString() {
        return " Position: [" + getPositionX() + "," + getPositionY() + "]"
                + " Velocity: [" + getVelocityX() + "," + getVelocityY() + "]";
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
