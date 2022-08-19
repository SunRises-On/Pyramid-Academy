package Hangman;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Word {
    private String str;
    private final char[] wordArr;
    private List<String> correctList;
    private List<String> mistakeList;
    private List<Character> userView;

    public Word(String newWord){
        this.str = newWord;
        int len = str.length();
        wordArr = new char[len];
        for(int i = 0 ; i< len ; i++){
            wordArr[i] = str.charAt(i);
        }
        correctList = new ArrayList<>(len);
        mistakeList = new ArrayList<>();
        userView = new ArrayList<>(len);
        for(Character c : userView){
            userView.add('_');
        }

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
    public void addLetterMiss( String s){
        mistakeList.add(s);
    }
    /****************************************
      Function will search for char position
      in char[] of hangman word. When found
      replace index with char
      **************************************/
    public void updateUserView( String s){
        char l = s.charAt(0); /*convert to char*/
        int index = 0;
        for(char c : wordArr){
            if(c == l){
                userView.set(index,c);
            }
            index++;
        }
    }
    public String getLastMiss(){
        return mistakeList.get( mistakeList.size()-1);
    }
    public List<Character> getUserWord(){
        return userView;
    }
}
