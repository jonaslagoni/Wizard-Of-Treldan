/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpriteController.GroupSprites;

import SpriteController.SingleSprite;
import SpriteController.Sprite;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author jonas
 */
public class Groupsprite_circle  extends Sprite{
    private List<SingleSprite> sprites;
    
    public Groupsprite_circle(SingleSprite sprites) {
        this.sprites = new ArrayList<SingleSprite>();
        this.sprites.add(sprites);
        setPosition(0, 0);
    }
    
    public Groupsprite_circle(List<SingleSprite> sprites) {
        this.sprites = sprites;
        setPosition(0, 0);
    }

    public Rectangle2D getBoundary(){
        return new Rectangle2D(getPositionX()+35, getPositionY()+10, getWidth()-55, getHeight()-65);
    }
    
    public void render(GraphicsContext gc) {
        if(sprites.size() >= 8){
            int counter = 0, posX = (int)getPositionX(), posY = (int)getPositionY();
            SingleSprite lastSingleSprite = new SingleSprite();
            for(SingleSprite singleSprite: sprites){
                switch(counter){
                    case 0: //NW
                        gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSpriteWidth(), singleSprite.getSpriteHeight(), posX, posY, singleSprite.getWidth(), singleSprite.getHeight());
                        posX += singleSprite.getWidth();
                        break;
                    case 1: //N
                        for(int i = 0; i <= this.getWidth()-lastSingleSprite.getWidth()*3; i += singleSprite.getWidth()){
                            gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSpriteWidth(), singleSprite.getSpriteHeight(), posX, posY, singleSprite.getWidth(), singleSprite.getHeight());
                            posX += singleSprite.getWidth();
                        }
                        break;
                    case 2: //NE
                        gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSpriteWidth(), singleSprite.getSpriteHeight(), posX, posY, singleSprite.getWidth(), singleSprite.getHeight());
                        posY += singleSprite.getHeight();
                        break;
                    case 3: //E
                        for(int i = 0; i <= this.getHeight()-lastSingleSprite.getHeight()*3; i += singleSprite.getHeight()){
                            gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSpriteWidth(), singleSprite.getSpriteHeight(), posX, posY, singleSprite.getWidth(), singleSprite.getHeight());
                            posY += singleSprite.getHeight();
                        }
                        break;
                    case 4: //SE
                        gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSpriteWidth(), singleSprite.getSpriteHeight(), posX, posY, singleSprite.getWidth(), singleSprite.getHeight());
                        posX -= singleSprite.getWidth();
                        break;
                    case 5: //S
                        for(int i = 0; i <= this.getWidth()-lastSingleSprite.getWidth()*3; i += singleSprite.getWidth()){
                            gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSpriteWidth(), singleSprite.getSpriteHeight(), posX, posY, singleSprite.getWidth(), singleSprite.getHeight());
                            posX -= singleSprite.getWidth();
                        }
                        break;
                    case 6: //SW
                        gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSpriteWidth(), singleSprite.getSpriteHeight(), posX, posY, singleSprite.getWidth(), singleSprite.getHeight());
                        posY -= singleSprite.getHeight();
                        break;
                    case 7: //W
                        for(int i = 0; i <= this.getHeight()-lastSingleSprite.getHeight()*3; i += singleSprite.getHeight()){
                            gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSpriteWidth(), singleSprite.getSpriteHeight(), posX, posY, singleSprite.getWidth(), singleSprite.getHeight());
                            posY -= singleSprite.getHeight();
                        }
                        break;
                    case 8: //CENTER
                        posX = (int)this.getPositionX()+32;
                        posY = (int)this.getPositionY()+32;
                        for(int i = 0; i <= this.getHeight()-lastSingleSprite.getHeight()*3; i += singleSprite.getHeight()){
                            for(int k = 0; k <= this.getWidth()-lastSingleSprite.getHeight()*3; k += singleSprite.getWidth()){
                                gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSpriteWidth(), singleSprite.getSpriteHeight(), posX, posY, singleSprite.getWidth(), singleSprite.getHeight());
                                posX += singleSprite.getWidth();
                            } 
                            posX = (int)this.getPositionX()+32;
                            gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSpriteWidth(), singleSprite.getSpriteHeight(), posX, posY, singleSprite.getWidth(), singleSprite.getHeight());
                            posY += singleSprite.getHeight();
                        }
                        break;
                }
                counter++;
                lastSingleSprite = singleSprite;
            }
        }
    }
    /**
     * @return the sprites
     */
    public List<SingleSprite> getSprites() {
        return sprites;
    }
}
