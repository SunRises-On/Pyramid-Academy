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

    private final static Miss[] valArray = values();
    public final int value;
    private final static int maxMissIndex = 5;
    Miss(int value){
        this.value = value;
    }
    /**********************************************
     This method allows us to start the enum iteration
     over and get 1 from 8%7.
     this.ordinal() = the position of the constant
     *********************************************/
    public Miss next(){
        return valArray[(this.ordinal()+1)%valArray.length];
    }
    public int getMaxIndex(){ return maxMissIndex;}
}