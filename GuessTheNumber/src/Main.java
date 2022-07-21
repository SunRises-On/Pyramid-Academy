import java.util.*;

public class Main {
    public static void main (String[] args){
        int max = 20;
        int min = 0;

        Scanner sc = new Scanner(System.in);
        String name = "";

        try {
            System.out.println("Hello! What is your name?");
            name = sc.nextLine();
        } catch (Exception e){
            System.out.println("Error at user name input!");
        }

        //get random number in range of 0 - 20
        System.out.println("Well, "+ name +", I am thinking of a number between 1 and 20");
        System.out.println("Take a guess");

        Random rand = new Random();
        //rand.nextInt(10) will have a range of 0-9
        // So max-min to find the range of numbers then + 1 and min.
        int random = rand.nextInt((max - min) + 1) + min;
        int guess = 0;
        // loop until user guess random number
        while(true){
            ++guess;
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

            if(choice == random){
                System.out.println("Good job, "+name+"! You guessed my number in "+guess+" guesses!");
                System.out.println("Would you like to play again? (y or n)");
                char c = 'a';

                try {
                    c = sc.next().charAt(0);
                }catch (Exception e){
                    sc.next();
                    System.out.println("Error! Input only letters!");
                }

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
            else if (choice < random){
                System.out.println("Your guess is too low.");
                System.out.println("Take a guess");
            }

            if(guess ==6){
                System.out.println("Game over. Only 6 guesses allowed");
                break;
            }
        }
    }
}
