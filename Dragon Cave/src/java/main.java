//package src/java/main.java;
//package java.main;

import java.util.*;

public class main {
    static final String[] script = {"You are in a land full of dragons. In front of you,"
            ,"you see two caves. In one cave, the dragon is friendly"
            ,"and will share his treasure with you. The other dragon"
            ,"is greedy and hungry and will eat you on sight."
            ,"Which cave will you go into? (1 or 2)"};

    static final String[] optionOne = {"You approach the cave..."
            ,"It is dark and spooky..."
            ,"A large dragon jumps out in front of you! He opens his jaws and ..."
            ,"Gobbles you down in one bite!"};
    static final String[] optionTwo = {"Success! The dragon is friendly and shares his treasure!"};

    public static void main (String [] args){

        Scanner sc = new Scanner(System.in);

        for(String s : script){
            System.out.println(s);
        }
        // scanner get user input
        int choice = 0;
        choice = getInput(sc);

        playGame(choice);
    }

    //method to get input from scanner
    static int getInput (Scanner sc){
        int input = -1 ;
        //Added try catch block for Project 3
        while(!sc.hasNextInt()) {  //if scanner doesn't have int repeat
            try {
                input = sc.nextInt();
            } catch (Exception e) {
                sc.next(); //advance past bad input
                System.out.println("Error! Input only numbers.");
            }
        }
        input = sc.nextInt(); //scanner has int next proceed
        return input;
    }
    //Method to play game, depending on user input of one, two or other.
    static void playGame(int choice){
        if(choice == 1){
            for(String s: optionOne){
                System.out.println(s);
            }
        }
        else if (choice == 2){
            for(String s: optionTwo){
                System.out.println(s);
            }
        }
        else{
            System.out.println("Wrong choice, start over.");
        }
    }
}
