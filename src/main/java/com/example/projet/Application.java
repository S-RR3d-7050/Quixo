package com.example.projet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public  class Application extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) throws Exception {


        //FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projet/view/menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {launch(args);

    }

}