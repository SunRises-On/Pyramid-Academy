

import java.util.*;

public class main {
    public static void main (String[] args){
        int max = 20;
        int min = 1;

        Scanner sc = new Scanner(System.in);
        String name = getName(sc);

        //get random number in range of 1 - 20
        System.out.println("Well, "+ name +", I am thinking of a number between 1 and 20");
        System.out.println("Take a guess");

        int random = 0;
        random = getRandom(max, min);

        int guess = 0;

        playGame( guess, random, name, sc);

    }

    static String getName(Scanner scan){
        String s = "";
        try {
            System.out.println("Hello! What is your name?");
            s = scan.nextLine();
        } catch (Exception e){
            System.out.println("Error at user name input!");
        }
        return s;
    }
    //method to get random number in between range of max and min
    static int getRandom(int max, int min){
        int random;
        Random rand = new Random();
        //rand.nextInt(10) will have a range of 0-9
        // So max-min to find the range of numbers then + 1 and min.
        random = rand.nextInt((max - min) + 1) + min;
        return random;
    }
    //method to play game
    static void playGame(int guess, int random, String name, Scanner sc){
        // loop until user guess random number
        while(true){
            ++guess;
            int choice = makeGuess(sc);

            if(choice == random){
                System.out.println("Good job, "+name+"! You guessed my number in "+guess+" guesses!");
                System.out.println("Would you like to play again? (y or n)");
                char c = 'a';

                c = playAgain(c, sc);
                if(c == 'y'){
                    //call main if user wants a new game
                    main(null);
                }
                else{
                    System.out.println("Game Over.");
                    break;
                }

            }
            else if (choice > random){
                System.out.println("Your guess is too high.");
                System.out.println("Take a guess.");
            }
            else {
                System.out.println("Your guess is too low.");
                System.out.println("Take a guess");
            }

            if(guess ==6){
                System.out.println("Game over. Only 6 guesses allowed");
                break;
            }
        }
    }

    //method to make guesses
    static int makeGuess(Scanner sc){
        int choice = 0;
        //Catch wrong input exceptions.
        while(!sc.hasNextInt()){
            try{
                choice = sc.nextInt();
            }catch (Exception e){
                sc.next(); // advance past bad input
                System.out.println("Error! Input only numbers");
            }
        }
        choice = sc.nextInt(); // scanner has int skip while block

        return choice;
    }
    //method to get input for play again question
    static char playAgain(char c, Scanner sc){

        try {
            c = sc.next().charAt(0);
        }catch (Exception e){
            sc.next();
            System.out.println("Error! Input only letters!");
        }
        return c;
    }
}
