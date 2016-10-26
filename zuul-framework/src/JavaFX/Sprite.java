/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFX;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author jonas
 */
public abstract class Sprite {
    abstract void setPosition(double x, double y);
    abstract void render(GraphicsContext gc);
    abstract Rectangle2D getBoundary();
    abstract double getPositionX();
    abstract double getPositionY();
}
