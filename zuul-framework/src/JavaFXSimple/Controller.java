/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFXSimple;

import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Mathias
 */
public class Controller {
    
        private GUIFX gui;
        
    public Controller() {
        GUIFX gui = new GUIFX();
        
        
        DropShadow shade = new DropShadow();
        gui.getRoot().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                gui.getRoot().setEffect(shade);
            }
        });
        
        gui.getRoot().addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            gui.getRoot().setEffect(null);
        });
        button_help.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            button_help.setOnAction(value);
        });
    }
}
