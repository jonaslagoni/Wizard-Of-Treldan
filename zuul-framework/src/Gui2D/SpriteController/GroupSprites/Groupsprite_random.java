/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.GroupSprites;

import Gui2D.SpriteController.SingleSprite.SingleSprite;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author jonas
 */
public class Groupsprite_random extends GroupSprite {

    /**
     * Create object with a SingleSprite
     *
     * @param sprites single SingeSprite
     */
    public Groupsprite_random(SingleSprite sprites) {
        super(sprites);
    }

    /**
     * Create object with List of SingleSprite
     *
     * @param sprites list of SingleSprite
     */
    public Groupsprite_random(List<SingleSprite> sprites) {
        super(sprites);
    }

    /**
     * costum render function
     *
     * @param gc GraphicsContext what to render on
     */
    @Override
    public void render(GraphicsContext gc) {
        int sprite_number = 0;
        SingleSprite singleSprite = getSprites().get(sprite_number);
        //gc.drawImage(image, positionX, getPositionY());
        double renderCounterHeight = Math.round(super.getHeight() / singleSprite.getHeight());
        double renderCounterWidth = Math.round(super.getWidth() / singleSprite.getWidth());
        for (int i = 0; i < renderCounterHeight; i++) {
            for (int k = 0; k < renderCounterWidth; k++) {
                sprite_number = (int) Math.round((Math.random() * (getSprites().size() - 1)));
                singleSprite = getSprites().get(sprite_number);
                gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSprite_width(), singleSprite.getSprite_height(), getPositionX() + (singleSprite.getWidth() * k), getPositionY() + (singleSprite.getHeight() * i), singleSprite.getWidth(), singleSprite.getHeight());
            }
            gc.drawImage(singleSprite.getImage(), singleSprite.getSpritePosX(), singleSprite.getSpritePosY(), singleSprite.getSprite_width(), singleSprite.getSprite_height(), getPositionX(), getPositionY() + (singleSprite.getHeight() * i), singleSprite.getWidth(), singleSprite.getHeight());
        }

    }
}
