module com.example.hangmanfunctional {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hangmanfunctional to javafx.fxml;
    exports com.example.hangmanfunctional;
}