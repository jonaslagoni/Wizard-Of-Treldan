/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainGameStart;

import Gui2D.WizardOfTreldan;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Lagoni
 */
public class StartMe extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button Gui2D = new Button();
        Gui2D.setMinSize(300, 500);
        Gui2D.setStyle("-fx-background-image: url('/GuiSelection/buttonBackground_GUI2D.png')");
        Gui2D.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                new WizardOfTreldan().start(new Stage());
            }
        });
        Gui2D.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Gui2D.setStyle("-fx-background-image: url('/GuiSelection/buttonBackground_GUI2D_hover.png')");
            }
        });
        Gui2D.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Gui2D.setStyle("-fx-background-image: url('/GuiSelection/buttonBackground_GUI2D.png')");
            }
        });
        
        
        
        Button GuiText = new Button();
        GuiText.setMinSize(300, 500);
        GuiText.setStyle("-fx-background-image: url('/GuiSelection/buttonBackground_text.png')");
        GuiText.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                new WizardOfTreldan().start(new Stage());
            }
        });
        GuiText.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                GuiText.setStyle("-fx-background-image: url('/GuiSelection/buttonBackground_text_hover.png')");
            }
        });
        GuiText.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                GuiText.setStyle("-fx-background-image: url('/GuiSelection/buttonBackground_text.png')");
            }
        });
        GuiText.relocate(300, 0);
        
        
        
        Button GuiButtons = new Button();
        GuiButtons.setMinSize(300, 500);
        GuiButtons.setStyle("-fx-background-image: url('/GuiSelection/buttonBackground_buttons.png')");
        GuiButtons.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                new WizardOfTreldan().start(new Stage());
            }
        });
        GuiButtons.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                GuiButtons.setStyle("-fx-background-image: url('/GuiSelection/buttonBackground_buttons_hover.png')");
            }
        });
        GuiButtons.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                GuiButtons.setStyle("-fx-background-image: url('/GuiSelection/buttonBackground_buttons.png')");
            }
        });
        GuiButtons.relocate(600, 0);
        
        
        
        
        
        Group root = new Group();
        root.getChildren().add(Gui2D);
        root.getChildren().add(GuiText);
        root.getChildren().add(GuiButtons);
        
        Scene scene = new Scene(root, 900, 539);
        
        
        primaryStage.setTitle("Wizard of Treldan");
        primaryStage.setWidth(900);
        primaryStage.setHeight(539);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
