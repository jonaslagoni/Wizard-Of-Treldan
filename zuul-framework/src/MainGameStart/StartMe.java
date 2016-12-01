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
        
        //create a new button for picking the 2d gui game
        Button Gui2D = new Button();
        //set the size of the button
        Gui2D.setMinSize(300, 500);
        //set the background of the button
        Gui2D.setStyle("-fx-background-image: url('/GuiSelection/buttonBackground_GUI2D.png')");
        //set an action when the button is clicked
        Gui2D.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //close this stage
                primaryStage.close();
                //open the 2d gui
                new WizardOfTreldan().start(new Stage());
            }
        });
        //set a new action when the mouse enteres the button
        Gui2D.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //set the background of the button
                Gui2D.setStyle("-fx-background-image: url('/GuiSelection/buttonBackground_GUI2D_hover.png')");
            }
        });
        //set a new action when the mouse exits the button
        Gui2D.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //set the background of the button
                Gui2D.setStyle("-fx-background-image: url('/GuiSelection/buttonBackground_GUI2D.png')");
            }
        });
        
        
        //create a new button for picking the text based gui game
        Button GuiText = new Button();
        //set the size of the button
        GuiText.setMinSize(300, 500);
        //set the background of the button
        GuiText.setStyle("-fx-background-image: url('/GuiSelection/buttonBackground_text.png')");
        //set an action when the button is clicked
        GuiText.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                //open the gui with commands
                new SimpleWithCommands.GUIFX().start(new Stage());
            }
        });
        //set a new action when the mouse enteres the button
        GuiText.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //set the background of the button
                GuiText.setStyle("-fx-background-image: url('/GuiSelection/buttonBackground_text_hover.png')");
            }
        });
        //set a new action when the mouse exits the button
        GuiText.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //set the background of the button
                GuiText.setStyle("-fx-background-image: url('/GuiSelection/buttonBackground_text.png')");
            }
        });
        //relocate the button
        GuiText.relocate(300, 0);
        
        
        //create a new button for picking the button based gui game
        Button GuiButtons = new Button();
        //set the size of the button
        GuiButtons.setMinSize(300, 500);
        //set the background of the button
        GuiButtons.setStyle("-fx-background-image: url('/GuiSelection/buttonBackground_buttons.png')");
        //set an action when the button is clicked
        GuiButtons.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                //open the gui with buttons
                new SimpleWithButtons.GUIFX().start(new Stage());
            }
        });
        //set a new action when the mouse enteres the button
        GuiButtons.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //set the background of the button
                GuiButtons.setStyle("-fx-background-image: url('/GuiSelection/buttonBackground_buttons_hover.png')");
            }
        });
        //set a new action when the mouse exits the button
        GuiButtons.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //set the background of the button
                GuiButtons.setStyle("-fx-background-image: url('/GuiSelection/buttonBackground_buttons.png')");
            }
        });
        //relocate the button
        GuiButtons.relocate(600, 0);
        
        
        
        
        //create a new group object to hold all our buttons
        Group root = new Group();
        //add all the buttons
        root.getChildren().add(Gui2D);
        root.getChildren().add(GuiText);
        root.getChildren().add(GuiButtons);
        
        //Create a new Scene object from our group of buttons
        Scene scene = new Scene(root, 900, 539);
        
        //set the title of the stage
        primaryStage.setTitle("Wizard of Treldan");
        //set the size of the stage
        primaryStage.setWidth(900);
        primaryStage.setHeight(539);
        //Set the scene
        primaryStage.setScene(scene);
        //show the window
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
