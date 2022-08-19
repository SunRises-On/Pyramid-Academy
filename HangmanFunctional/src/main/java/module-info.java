module com.example.HangmanFunctional {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.HangmanFunctional.Controller to javafx.fxml;
    exports com.example.HangmanFunctional.Controller ;
}