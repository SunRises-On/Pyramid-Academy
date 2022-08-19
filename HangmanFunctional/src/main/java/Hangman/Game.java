package Hangman;

import java.util.ArrayList;
import Model.*;

public class Game {
    public GameModel gameRender;
    private String gameGuess;

    public ArrayList<String> screen;
    public Boolean isDone;
    public Word word;
    public Miss miss;

    public Game(GameModel render){
        gameRender = render;
        gameGuess = "";
        Scan scanFile = new Scan();
        //get hangman new word
        String str = scanFile.scanWordFile();
        str = "abc";
        word = new Word(str);
        screen = new ArrayList<>();
        miss = Miss.Zero;
        int letterNum = word.getStr().length();
    }


    public void setGameGuess(String gameGuess) {
        this.gameGuess = gameGuess;
    }

    public Boolean hitOrMiss( String str){
        Boolean isHit = false;
        Boolean isLetter = false;
        Boolean isDuplicate = false;

        isLetter = verifyStr(str);

        if(isLetter){
            //change to letter
            String letter = str.substring(0,1);
            //isHit =

            //isDuplicate =

            //if hit and duplicate, isHit = false
            if(isHit && isDuplicate){
                isHit = false;
            }else{
                //update word.addLetterHit()
                word.addLetterHit(letter);
                //update word.userView of hangman word
            }
        }


        return isHit;
    }
    public Boolean verifyStr( String str){

        return false;
    }
}