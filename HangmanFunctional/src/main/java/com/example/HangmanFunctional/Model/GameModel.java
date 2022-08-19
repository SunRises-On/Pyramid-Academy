package com.example.HangmanFunctional.Model;


import com.example.HangmanFunctional.Hangman.Game;

import java.io.IOException;
import java.util.List;

public class GameModel {

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
    public String getLastMiss(){
        return game.getLastMiss();
    }
    public List<Character> getWord(){
        return game.getWord();
    }
    //get player action(buttons)
    //update all
    //message(String s)
}
