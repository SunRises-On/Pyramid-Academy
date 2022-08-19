package Hangman;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private String str;
    private List<String> correctList;
    private List<String> mistakeList;
    private List<Character> userView;

    public Word(String newWord){
        this.str = newWord;
        correctList = new ArrayList<>(str.length());
        mistakeList = new ArrayList<>();
        int len = str.length();
        userView = new ArrayList<>(len);

    }
    public String getStr(){
        return str;
    }

    public Boolean checkForHit( String s ){
        if(str.contains(s)){
            return true;
        }
        return false;
    }
    public Boolean checkForDuplicate(String s){
        if(correctList.contains(s)){
            return true;
        }
        return false;
    }
    public void addLetterHit( String s ){
        correctList.add(s);
    }
}
