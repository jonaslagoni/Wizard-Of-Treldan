/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Lagoni
 */
public class GameMenu {
    private AnchorPane gameMenu;
    private boolean shown;
    
    /**
     * PlayerInventory object
     */
    public GameMenu(){
        gameMenu = new AnchorPane();
        gameMenu.setPrefSize(1024, 512);
        
        
        //adding a canvas for drawing image
        Canvas canvas_movealbe_sprites = new Canvas( 1024, 512 );
        GraphicsContext background_context = canvas_movealbe_sprites.getGraphicsContext2D();
        //set our  menu image
        background_context.drawImage(new Image("menu_background.png"), 0, 0);
        gameMenu.getChildren().add(canvas_movealbe_sprites);
        
        Label controlsMOVING = new Label();
        controlsMOVING.setPrefSize(400, 50);
        controlsMOVING.relocate(710, 50);
        controlsMOVING.setFont(new Font("Verdana",20));
        controlsMOVING.setText("Use Arrow Keys to move");
        controlsMOVING.setTextFill(Color.WHITE);
        gameMenu.getChildren().add(controlsMOVING);
        
        Label controlsESC = new Label();
        controlsESC.setPrefSize(400, 50);
        controlsESC.relocate(710, 100);
        controlsESC.setFont(new Font("Verdana",20));
        controlsESC.setText("Press ESCAPE to exit game");
        controlsESC.setTextFill(Color.WHITE);
        gameMenu.getChildren().add(controlsESC);
        
        Label controlsINTERACT = new Label();
        controlsINTERACT.setPrefSize(400, 50);
        controlsINTERACT.relocate(710, 150);
        controlsINTERACT.setFont(new Font("Verdana",20));
        controlsINTERACT.setText("Use \"E\" to interact");
        controlsINTERACT.setTextFill(Color.WHITE);
        gameMenu.getChildren().add(controlsINTERACT);
        
        Label controlsINVENTORY = new Label();
        controlsINVENTORY.setPrefSize(400, 50);
        controlsINVENTORY.relocate(710, 200);
        controlsINVENTORY.setFont(new Font("Verdana",20));
        controlsINVENTORY.setText("Use \"I\" to display inventory");
        controlsINVENTORY.setTextFill(Color.WHITE);
        gameMenu.getChildren().add(controlsINVENTORY); 
        
        Pane anchorpane = new Pane();
        anchorpane.setPrefSize(768, 512);
        Button exit = new Button();
        exit.setText("Exit Game");
        exit.setFont(new Font("Tahoma", 20));
        exit.setPrefSize(150, 50);
        exit.relocate(100, 150);
        exit.addEventHandler(MouseEvent.MOUSE_CLICKED, 
            new EventHandler<MouseEvent>() {
                @Override 
                public void handle(MouseEvent e) {
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                            System.exit(0);
                        }
                    });
                }
        });
        anchorpane.getChildren().add(exit);
        gameMenu.getChildren().add(anchorpane);
        
    }

    /**
     * @return the menu
     */
    public AnchorPane getMenu() {
        return gameMenu;
    }
    
    /**
     * @return the shown
     */
    public boolean isShown() {
        return shown;
    }

    /**
     * @param shown the shown to set
     */
    public void setShown(boolean shown) {
        this.shown = shown;
    }
}
