package com.example.HangmanFunctional.Hangman;

import java.util.ArrayList;
import com.example.HangmanFunctional.Model.GameModel;

public class Game {
    public GameModel gameRender;
    public ArrayList<String> screen;
    public Boolean isDone;
    public Boolean won;
    public Word word;
    public Miss miss;

    public Game(GameModel render){
        gameRender = render;
        Scan scanFile = new Scan();
        //get hangman new word
        String str = scanFile.scanWordFile();
        str = "abc";
        word = new Word(str);
        screen = new ArrayList<>();
        miss = Miss.Zero;

    }

    public Boolean[] hitOrMiss( String str){
        Boolean isHit, isLetter, isDuplicate;
        isHit = isLetter = isDuplicate = false;
        Boolean[] hitAndDup = new Boolean[2];

        isLetter = verifyStr(str);

        if(isLetter){
            //change to letter
            String letter = str.substring(0,1).toLowerCase();

            isHit = word.checkForHit(letter);

            isDuplicate = word.checkForDuplicate(letter);
            System.out.println("Duplicate = "+isDuplicate);
            if(!isHit && !isDuplicate){
                //update Enum miss
                miss = miss.next();
                //update word.mistakeList
                word.addLetterMiss(letter);
            }
            else if(isHit && isDuplicate){
                isHit = false;
            }else if (isHit && !isDuplicate){
                //update word.addLetterHit()
                word.addLetterHit(letter);
                //update word.userView of hangman word
                word.updateUserView(letter);
            }
        }

        hitAndDup[0] = isHit;
        hitAndDup[1] = isDuplicate;
        return hitAndDup;
    }
    public Boolean verifyStr( String str){
        char c = str.charAt(0);
        return ( c >= 'a' && c<= 'z') || (c >= 'A' && c<= 'Z');
    }
    public int getMissIndex(){
        return miss.value;
    }
    public String getLastMiss(){
        return word.getLastMiss();
    }
    public String getWord(){
        return word.userViewToString();
    }

    public Boolean checkIsGameOver(){
        Boolean isMaxGuess = checkMaxMiss();
        Boolean hasBlank = checkWordNotDone();
        if(isMaxGuess){
            isDone = true;
            won = false;
            return true;
        }else{
            if(!hasBlank){
                isDone = true;
                won = true;
                return true;
            }
        }
        return false;
    }
    public Boolean checkMaxMiss(){
        int value = miss.value;
        return value == miss.getMaxIndex();
    }
    public Boolean checkWordNotDone(){
        return word.checkForBlank();
    }
    public Boolean checkWon(){
        return won;
    }
    public int missNum(){
        return miss.value+1;
    }

}