
import java.util.*;

public class main {
    public static void main (String [] args){

        final String[] script = {"You are in a land full of dragons. In front of you,"
                ,"you see two caves. In one cave, the dragon is friendly"
                ,"and will share his treasure with you. The other dragon"
                ,"is greedy and hungry and will eat you on sight."
                ,"Which cave will you go into? (1 or 2)"};

        final String[] optionOne = {"You approach the cave..."
                ,"It is dark and spooky..."
                ,"A large dragon jumps out in front of you! He opens his jaws and ..."
                ,"Gobbles you down in one bite!"};
        final String[] optionTwo = {"Success! The dragon is friendly and shares his treasure!"};

        Scanner sc = new Scanner(System.in);


        for(String s : script){
            System.out.println(s);
        }
        // scanner get user input
        int choice = 0;

        //Added try catch block for Project 3
        while(!sc.hasNextInt()) {  //if scanner doesn't have int repeat
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                sc.next(); //advance past bad input
                System.out.println("Error! Input only numbers.");
            }
        }
        choice = sc.nextInt(); //scanner has int next proceed


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
