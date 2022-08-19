package Render;

import Hangman.*;
import com.example.hangmanfunctional.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameRender {

    String guessR;
    int missR;

    public GameController gui;
    public Game game;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public GameRender()throws IOException{
        game = new Game(this);
        gui = new GameController(this);




        paint();
    }

    public void paint(){


    }

    //render to game logic
    public void setGuessR(String guessR) {
        this.guessR = guessR;
        game.setGameGuess(guessR);
    }
    //get player action(buttons)
    //update all
    //message(String s)


}
