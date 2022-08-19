package Model;

import Controller.GameController;
import Hangman.*;

import java.io.IOException;

public class GameModel {

    String guessR;
    int missR;


    public Game game;

    public GameModel( )throws IOException{
        game = new Game(this);

    }
    //get action hit or miss
    public Boolean getAction(String s){
        Boolean doAction = false;
        doAction = game.hitOrMiss(s);

        return doAction;
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
