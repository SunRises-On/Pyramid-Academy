package com.example.hangmanfunctional;
import Render.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {
    @FXML
    TextField text;
    @FXML
    Label label_One;
    @FXML
    Label label_Two;
    @FXML
    Label label_Three;
    @FXML
    Label label_Four;
    @FXML
    Label label_Five;
    @FXML
    Label label_Six;
    @FXML
    Label label_word;
    @FXML
    ImageView image;
    GameRender render;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public GameController(GameRender gameRender )  {

        render = gameRender;


        //all missing labels are NOT Visible at start
        label_One.setVisible(false);
        label_Two.setVisible(false);
        label_Three.setVisible(false);
        label_Four.setVisible(false);
        label_Five.setVisible(false);
        label_Six.setVisible(false);

    }

    public void getText(ActionEvent event)throws IOException{
        String guessC = text.getText();
        render.setGuessR(guessC);

    }

    //updaate all
    // all buttons
    //messages?
}
