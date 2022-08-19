package com.example.HangmanFunctional.Controller;

import com.example.HangmanFunctional.Model.GameModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameController {
   // @FXML
   // TextField text;
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
    @FXML
    TextField text;
    ArrayList<Label> labels;
    ArrayList<String> locations;
    Boolean isOver;
    Boolean won;
    GameModel model;
    private static final String hangmanOne= "com/example/HangmanFunctional/Hangman_1.png";
    private static final String hangmanTwo = "com/example/HangmanFunctional/Hangman_2.png";
    private static final String hangmanThree = "com/example/HangmanFunctional/Hangman_3.png";
    private static final String hangmanFour = "com/example/HangmanFunctional/Hangman_4.png";
    private static final String hangmanFive = "com/example/HangmanFunctional/Hangman_5.png";
    private static final String hangmanSix = "com/example/HangmanFunctional/Hangman_6.png";

    private Stage stage;
    private Scene scene;
    private Parent root;

    //initialize() is called once on an implementing
    //controller, when the contents of its associated
    //document is completely loaded. Allows the
    //implementing class to perform any necessary
    //post-processing on the content
    @FXML
    void initialize()throws IOException{
        model = new GameModel();
        locations = new ArrayList<>();
        labels = new ArrayList<>();
        Collections.addAll(locations, hangmanOne, hangmanTwo, hangmanThree, hangmanFour, hangmanFive, hangmanSix);
        //put labels into arraylist
        Collections.addAll(labels, label_One, label_Two, label_Three, label_Four, label_Five, label_Six);
        //all missing labels are NOT Visible at start
        for(Label l : labels){
            l.setVisible(false);
            l.setText("");
        }

    }
    @FXML
    public void getText(ActionEvent event)throws IOException{
        String guessC = text.getText();

        Boolean[] hitAndDup = new Boolean[2];
        hitAndDup = model.getAction(guessC);
        Boolean hit = hitAndDup[0];
        Boolean duplicate = hitAndDup[1];
        if(hit && !duplicate){
            //update user view word
            updateWordLabel();

        }else if (!hit && !duplicate){
            //we update label with missed letter
            updateLabelMiss();
            //we update hangman image
            changeHangmanImage();
        }
        else{
            //not hit clear text
            text.clear();
        }

        //check if game is over
       // checkIsGameOver();
        if(isOver){
            if(won){
                //special won message
            }else{
                //special lost message
            }
            //set score
        }

    }
    /*********************************************
     * This function for every new miss
     * will be called, and set new label to visible
     * and set text to last miss
     *********************************************/
    public void updateLabelMiss(){
        int index = model.getMissIndex();
        String lastMiss = model.getLastMiss();

        labels.get(index).setText(lastMiss);
        labels.get(index).setVisible(true);
    }
    public void changeHangmanImage(){
        int index = model.getMissIndex();
        Image newImage = new Image(locations.get(index));
         image.setImage(newImage);
    }
    public void updateWordLabel(){
        List<Character> word = model.getWord();

        StringBuilder sb = new StringBuilder();
        for( Character ch : word){
            sb.append(ch);
        }
        String s = sb.toString();
        label_word.setText(s);
     }
    //    //updaate all
    // all buttons
    //messages?
}
