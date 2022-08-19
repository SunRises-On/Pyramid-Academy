package Hangman;

import java.util.ArrayList;
import Render.*;

public class Game {
    public GameRender gameRender;
    private String gameGuess;

    public ArrayList<String> screen;
    public Boolean isDone;
    public Word word;
    public Miss miss;

    public Game(GameRender render){
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
        play();
    }

    public void play(){
        //here we go
        //1. make a guess
        Character letter = ' ';
        if(gameGuess!= ""){
            //verify guess
            //check if hit

        }

        gameGuess = "";
        //check if game is over
    }
    //pubic void printHangman
    // is replaced by miss
  //  public Character getGuess(String verify){
    //    Character c = ' ';
        //validate string
        //len to 0

      //  return c;
   // }

    public void setGameGuess(String gameGuess) {
        this.gameGuess = gameGuess;
    }
}