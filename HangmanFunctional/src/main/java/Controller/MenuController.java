package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;


public class MenuController {
    @FXML
    ImageView hangmanImage;
    @FXML
    Button startButton;
    @FXML
    Button scoreButton;
    @FXML
    Label titleLabel;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void login (ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EnterName.fxml"));
        root = loader.load();

        EnterNameController controller = loader.getController();

        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
