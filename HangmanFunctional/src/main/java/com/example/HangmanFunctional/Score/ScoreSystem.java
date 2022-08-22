package com.example.HangmanFunctional.Score;

import com.example.HangmanFunctional.Model.GameModel;

public class ScoreSystem {
    public GameModel gameModel;
    private ScoreFile file;

    public ScoreSystem(GameModel gameModel){
        this.gameModel = gameModel;
        file = new ScoreFile();
    }

    public void calculateScore ( int misses, String name ) throws  Exception{
        int userScore = 100;
        userScore = 100 - (10 * misses);
        String put = name + " "+ userScore;

        file.getRank(userScore, name);


    }

    //get rank
    //get file position
    //sort file
}
