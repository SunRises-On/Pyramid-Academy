package com.example.HangmanFunctional.Hangman;
//Miss, the value is the index value for miss
// in GameController.

public enum Miss {
    Zero(-1),
    One(0),
    Two(1),
    Three(2),
    Four(3),
    Five(4),
    Six(5);

    private static Miss[] vals = values();
    public final int value;
    private final static int maxMissIndex = 5;
    private Miss(int value){
        this.value = value;
    }
    /**********************************************
     This method allows us to start the enum iteration
     over and get 1 from 8%7.
     this.ordinal() = the position of the constant
     *********************************************/
    public Miss next(){
        return vals[(this.ordinal()+1)%vals.length];
    }
    public int getMaxIndex(){ return maxMissIndex;}
}