package com.example.HangmanFunctional.Hangman;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private String str;
    private final Character blank = '_';
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

        for(char c : wordArr){
            userView.add(blank);
        }


    }
    public Boolean checkForHit( String s ){
        return str.contains(s);
    }
    public Boolean checkForDuplicate(String s){
        return (correctList.contains(s) || mistakeList.contains(s));
    }
    public Boolean checkForBlank(){
        return userView.contains(blank);
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
        Character letter = s.charAt(0);
        int index = 0;
        for(Character c : wordArr){
            if(c == letter){
                userView.set(index,c);
            }
            index++;
        }
    }
    public String userViewToString(){
        int last = userView.size();
        int index= 0;
        StringBuilder sb = new StringBuilder();
        for( Character ch : userView){
            if(index > 0 && index < last){
                sb.append(" ");
            }
            sb.append(ch);
            index++;
        }
        return sb.toString();
    }
    public String getLastMiss(){
        return mistakeList.get( mistakeList.size()-1);
    }
    public List<Character> getUserWord(){
        return userView;
    }
}
