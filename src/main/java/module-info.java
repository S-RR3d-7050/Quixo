module com.example.projet {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projet to javafx.fxml;
    exports com.example.projet;
    exports com.example.projet.Controller;
    opens com.example.projet.Controller to javafx.fxml;
}