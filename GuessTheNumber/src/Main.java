import java.util.*;

public class Main {
    public static void main (String[] args){
        int max = 20;
        int min = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Hello! What is your name?");

        String name = sc.nextLine();

        //get random number in range of 0 - 20
        System.out.println("Well, "+ name +", I am thinking of a number between 1 and 20");
        System.out.println("Take a guess");


        int random = (int) ((Math.random() * (max -min)) + min);
        int guess = 0;
        // loop until user guess random number
        while(true){
            ++guess;
            int choice = sc.nextInt();
            if(choice == random){
                System.out.println("Good job, "+name+"! You guessed my number in "+guess+" guesses!");
                System.out.println("Would you like to play again? (y or n)");
                char c = sc.next().charAt(0);
                if(c == 'y'){
                    //call main if user wants a new game
                    main(null);
                }
                else{
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
        }
    }
}
