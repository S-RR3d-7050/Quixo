package com.example.projet.Controller;

import com.example.projet.Model.ModeJeu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControlleurMenu {

    // Set the game mode
    public ModeJeu modeJeu = new ModeJeu();

    /*
    @FXML
    private void jouerContreIA(ActionEvent event) throws IOException {
        try {
            // Load view.fxml using a reliable path
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projet/view.fxml"));
            // Set Also the game mode
            modeJeu.setMode(1);
            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            // Handle loading errors gracefully
            System.err.println("Failed to load view.fxml: " + e.getMessage());
            // You might want to display an error message to the user here
        }
    }
*/
    @FXML
    private void jouerContreIA(ActionEvent event) throws IOException {
        try {
            // Load view.fxml using a reliable path
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projet/view/view.fxml"));
            Parent root = loader.load();

            // Create an instance of your controller
            Controller controller = loader.getController();

            // Set the game mode
            modeJeu.setMode(2);

            // Pass the modeJeu to the controller
            controller.setModeJeu(modeJeu);  // Assuming your controller has a method named setModeJeu()

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            // Handle loading errors gracefully
            System.err.println("Failed to load view.fxml: " + e.getMessage());
            // You might want to display an error message to the user here
        }
    }

    @FXML
    private void jouerContreHumain(ActionEvent event) {
        try {
            // Load view.fxml using a reliable path
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projet/view/view.fxml"));
            Parent root = loader.load();

            // Create an instance of your controller
            Controller controller = loader.getController();

            // Set the game mode
            modeJeu.setMode(1);

            // Pass the modeJeu to the controller
            controller.setModeJeu(modeJeu);  // Assuming your controller has a method named setModeJeu()

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            // Handle loading errors gracefully
            System.err.println("Failed to load view.fxml: " + e.getMessage());
            // You might want to display an error message to the user here
        }
    }
}
