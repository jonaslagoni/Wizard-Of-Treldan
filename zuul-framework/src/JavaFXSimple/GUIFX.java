/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFXSimple;

import TWoT_test.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Mathias
 */
public class GUIFX extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start (Stage primaryStage) {
        
        primaryStage.setTitle("The Wizard of Treldan");
        
        Button button_inventory = new Button();
        Button button_help = new Button();
        Button button_exit = new Button();
        
        button_inventory.setText("Inventory");
        button_help.setText("Help");
        button_exit.setText("Exit");
        
        button_inventory.setMaxWidth(90);
        button_help.setMaxWidth(90);
        button_exit.setMaxWidth(90);
        
        DropShadow shade = new DropShadow();
        button_inventory.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                button_inventory.setEffect(shade);
            }
        });
        button_help.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                button_help.setEffect(shade);
            }
        });
        button_exit.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                button_exit.setEffect(shade);
            }
        });
        button_inventory.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                button_inventory.setEffect(null);
            }
        });
        button_help.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                button_help.setEffect(null);
            }
        });
        button_exit.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                button_exit.setEffect(null);
            }
        });
        
        VBox root = new VBox(10);
        root.getChildren().addAll(button_inventory, button_help, button_exit);
        root.setLayoutX(422);
        Scene scene1 = new Scene(root, 512, 288);
        
        primaryStage.setScene(scene1);
        primaryStage.show();
        
        
    }
}
