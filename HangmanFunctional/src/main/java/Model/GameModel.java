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
    public Boolean[] getAction(String s){

        Boolean[] hitAndDup = new Boolean[2];
        hitAndDup = game.hitOrMiss(s);

        return hitAndDup;
    }
    //get Game index
    public int getMissIndex(){
        return game.getMissIndex();
    }
    //get player action(buttons)
    //update all
    //message(String s)
}
