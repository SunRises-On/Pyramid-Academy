package com.example.HangmanFunctional.Score;

public class GameSave {
    private int score;
    private String name;
    GameSave(int newScore, String newName){
        this.score = newScore;
        this.name = newName;
    }

    public int getScore(){ return score; }
    public String getName(){ return name;}
    @Override
    public String toString(){
        return name + " " +score;
    }
}
