/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import javafx.scene.Scene;
/**
 *
 * @author jonas
 */
public interface Map {
    //force each subclass to implement this method
    public Scene getScene();
}
