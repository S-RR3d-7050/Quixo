package com.example.projet.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {

    @FXML
    private void jouerContreIA(ActionEvent event) throws IOException {
        try {
            // Load view.fxml using a reliable path
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projet/view.fxml"));

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
        // Code for starting the game against another human
        // You can open a new window or modify the current scene
        try {
            // Load view.fxml using a reliable path
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projet/viewHumain.fxml"));

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
