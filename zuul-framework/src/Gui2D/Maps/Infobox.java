/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import javafx.scene.control.TextArea;

/**
 *
 * @author Lagoni
 */
public class Infobox {
    /**
     * Returns the TextArea used to indicate actions in the game
     * @return TextArea infobox
     */
    public static TextArea getInfoBox(){
        TextArea infobox = new TextArea();
        infobox.prefHeight(200);
        infobox.prefWidth(150);
        infobox.setOpacity(0.5);
        infobox.setWrapText(true);
        infobox.setEditable(false);
        infobox.setFocusTraversable(false);
        return infobox;
    }
}
