package com.example.HangmanFunctional.Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Scan {
    final int wordCount = 2962;

    //Method to get a random word from txt file.
    public String scanWordFile(){
        String found = "";
        int random = -1;
        random = getRandom(random);
        try{
            File text = new File("src/resource/Words.txt");
            Scanner scanner = new Scanner(text);

            int lineNumber = 1;
            while(scanner.hasNextLine() && lineNumber != random){
                found = scanner.nextLine();
                lineNumber++;
            }
            scanner.close();
        }catch( FileNotFoundException e){
            System.out.println("Hangman.Word.txt file not found");
        }


        return found;
    }
    //Get a random number in range(1, 2962).
    private int getRandom(int randomNum){

        int min = 1;
        Random rand = new Random();
        randomNum = min + rand.nextInt(( wordCount - min) + 1);
        return randomNum;
    }


}
