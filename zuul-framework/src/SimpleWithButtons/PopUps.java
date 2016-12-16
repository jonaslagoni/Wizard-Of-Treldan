/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleWithButtons;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Mathias
 */
public class PopUps {

    /**
     * Uses title, and message to construct the window
     *
     * @param title String
     * @param message String
     */
    public static void display(String title, String message) {

        /**
         * creates new stage
         */
        Stage window = new Stage();

        window.getIcons().add(new Image("icon.png"));

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);

        Button closeButton = new Button("Understood.");
        closeButton.setOnAction((ActionEvent e) -> {
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene howToPlay = new Scene(layout);
        window.setScene(howToPlay);
        window.showAndWait();
    }

}
