package Hangman;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private String str;
    private List<String> correctList;
    private List<Character> userView;

    public Word(String newWord){
        this.str = newWord;
        correctList = new ArrayList<>(str.length());
        int len = str.length();
        userView = new ArrayList<>(len);

    }
    public String getStr(){
        return str;
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
