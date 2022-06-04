module com.example.aircraft {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aircraft to javafx.fxml;
    exports com.example.aircraft;
}