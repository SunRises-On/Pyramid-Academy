package com.example.HangmanFunctional.Model;

import com.example.HangmanFunctional.Hangman.Game;
import com.example.HangmanFunctional.Score.ScoreSystem;

public class GameModel {

    public Game game;
    public ScoreSystem score;
    public GameModel( ){
        game = new Game(this);
        score = new ScoreSystem(this);
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
    public String getWord(){
        return game.getWord();
    }
    public Boolean checkIsGameOver(){
        return game.checkIsGameOver();
    }
    public Boolean getWonOrLost(){
        return game.checkWon();
    }
    public int getMissNum(){
        return game.missNum();
    }
    public void setScore(String n) {
        int value = getMissNum();
        score.calculateScore(value, n);
    };
    //get player action(buttons)
    //update all
    //message(String s)
}
