import java.util.Arrays;
import java.util.ListIterator;
import java.util.Scanner;

public class Game{

    //set up new game
    public void initialize(){

        System.out.println("We are playing Hangman.");


       //// Scan scanFile = new Scan();
        //get hangman new word
    /////    String word = scanFile.scanWordFile();
        String word = "apple";
        Player newGame = new Player(word);

        //game is initialized go to rounds....
        play(newGame);
    }
    //Play the game
    public void play(Player player){
        Boolean isComplete = false;
        Boolean playerWon = false;
        //While game is not over loop
        while(!isComplete){
            //Call print Hangman
            printHangman(player.getMiss());
            //check if game is over if we have lost the game
            isComplete = gameOver(player);
            System.out.println("");
            //print missing letters
            printMissingLetters(player);
            //print progress of Hangman word
            printProgress(player);
            //Guess a letter
            playerGuess(player);
            //check if completed the game
            isComplete = gameOver(player);
        }
        //Game is over, check if player won;
        playerWon = wonOrLoss(player);

        //Print the winning or losing message
        winningMessage(playerWon, player);

        //printed separate messages ask if the player wants to continue
        startAgain(player);
    }
    //Method to find out if the game is over
    public Boolean gameOver(Player player){

        /*Game is over if player misses equals max number of misses,
          or the word has been guessed. */
        if(player.miss == player.maxNumberMisses || player.hit == player.HangmanWord.length()){
            return true;
        }

        return false;
    }
    //Print missing letters from Object player
    public void printMissingLetters(Player player){
        //replace brackets and commas with ""
        String str = Arrays.toString(player.playerMisses.toArray()).replace("[","").replace(",","").replace("]","");
        System.out.println("");
        System.out.println("Missed letters: "+ str);
    }
    //Print progress on guessing secret word.
    public void printProgress(Player player){
        //replace brackets and commas with ""
        String str = Arrays.toString(player.secretWord.toArray()).replace("[","").replace(",","").replace("]","");
        System.out.println("");
        System.out.println(str);
    }
    //Depending on the number of misses
    //print different hangman's.
    public void printHangman(int miss){
        switch (miss){
            case 0:
                System.out.println(" +---+");
                System.out.println("");
                System.out.println("     |");
                System.out.println("");
                System.out.println("     |");
                System.out.println("");
                System.out.println("     |");
                System.out.println("");
                System.out.println("    ===");
                break;
            case 1:
                System.out.println(" +---+");
                System.out.println("");
                System.out.println(" O   |");
                System.out.println("");
                System.out.println("     |");
                System.out.println("");
                System.out.println("     |");
                System.out.println("");
                System.out.println("    ===");
                break;
            case 2:
                System.out.println(" +---+");
                System.out.println("");
                System.out.println(" O   |");
                System.out.println("");
                System.out.println(" |   |");
                System.out.println("");
                System.out.println("     |");
                System.out.println("");
                System.out.println("    ===");
                break;
            case 3:
                System.out.println(" +---+");
                System.out.println("");
                System.out.println(" O   |");
                System.out.println("");
                System.out.println(" |   |");
                System.out.println("");
                System.out.println(" |   |");
                System.out.println("");
                System.out.println("    ===");
                break;
            case 4:
                System.out.println(" +---+");
                System.out.println("");
                System.out.println(" O   |");
                System.out.println("");
                System.out.println("\\|   |");
                System.out.println("");
                System.out.println(" |   |");
                System.out.println("");
                System.out.println("    ===");
                break;
            case 5:
                System.out.println(" +---+");
                System.out.println("");
                System.out.println(" O   |");
                System.out.println("");
                System.out.println("\\|/   |");
                System.out.println("");
                System.out.println(" |   |");
                System.out.println("");
                System.out.println("    ===");
                break;
            case 6:
                System.out.println(" +---+");
                System.out.println("");
                System.out.println(" O   |");
                System.out.println("");
                System.out.println("\\|/   |");
                System.out.println("");
                System.out.println(" |   |");
                System.out.println("/");
                System.out.println("    ===");
                break;
            case 7:
                System.out.println(" +---+");
                System.out.println("");
                System.out.println(" O   |");
                System.out.println("");
                System.out.println("\\|/   |");
                System.out.println("");
                System.out.println(" |   |");
                System.out.println("/ \\");
                System.out.println("    ===");
                break;
            default:
                System.out.println("Error in printHangman()");

        }

    }
    //Handle player guess
    public void playerGuess( Player player) {

        //handle guess input
        char letter = handleInput(player);
        String str = "" + letter;//convert letter to string
        //Check if letter has already been guessed
        boolean isGuessed = isRepeated(letter, player);
        if(isGuessed){
            System.out.println("You have already guessed that letter. Choose again.");
            playerGuess(player); //restart player guess
        }else{
            boolean isHit = correctGuess(str, player);
            if(!isHit){ //incorrect guess
                updateMiss(str, player);
            }else{ //correct guess
                updateHit(str, player);
            }
        }

    }
    //Handle and input player input into Player object.
    public char handleInput(Player player){
        Scanner sc = new Scanner(System.in);
        char c = ' ';
        System.out.println("");
        System.out.println("Guess a letter.");
        System.out.println("");
        try{
            c = sc.next().charAt(0);//get next char
            boolean correct = isLetter(c);//check if it's a letter

            if(!correct){
                System.out.println("Only input letters a-z and A-Z.");
                handleInput(player);
            }


        }catch (Exception e){
            System.out.println("Error in Game.handleInput() method!");
        }
        return c;
    }
    //check if char is a letter
    private boolean isLetter(char c){
        return ( c >= 'a' && c<= 'z') ||
                (c >= 'A' && c<= 'Z');
    }
    //Check if letter ha been guessed.
    public boolean isRepeated(char l, Player player){
        String str = ""+l;
        str.toLowerCase();
        //iterate through arraylist and check if letter has been guessed
        ListIterator<String> iterator = player.getPlayerMisses().listIterator();
        while (iterator.hasNext()){
            //== tests for reference equality (whether they are the same object
            //.equals() tests for value equality
            if(iterator.next().equals(str)){
                return true;
            }
        }
        return false;
    }
    //Check if guess is a hit
    public boolean correctGuess (String s, Player player){
        ListIterator<String> iterator = player.hangmanArray.listIterator();
        while(iterator.hasNext()){
            //correct guess
            if(iterator.next().equals(s)){
                return true;
            }
        }
        return false;
    }
    //Update Player methods for the miss guess.
    public void updateMiss(String s, Player player){
        player.updateMiss(); //update int miss
        player.updateMissArray(s);//update arraylist of miss characters

    }
    //Update player methods for the hit guess;
    public void updateHit(String s, Player player){
        ListIterator<String> iterator = player.hangmanArray.listIterator();
        int i = 0;
        while(iterator.hasNext()){
            if(iterator.next().equals(s)){
                player.updateHit();
                player.updateSecretArray(i,s);
            }
            ++i;
        }
    }
    //Check if the player won or loss.
    public boolean wonOrLoss(Player player){
        if(player.playerMisses.size() == player.getMaxNumberMisses()){
            return false;
        }
        return true;
    }
    //Print the win or loss screen.
    public void winningMessage(Boolean won, Player player ){
        //print lose message
        if(!won){
            System.out.println("");
            System.out.println("Max number of guesses!");
            System.out.println("");
            System.out.println("Game Over!");
        } else{ //print win message
            System.out.println("Yes! The secret word is "+ player.HangmanWord + "! You have won!");
        }
    }

    //Ask if the player wants to play again.
    public void startAgain(Player player){

        String yes = "yes";
        String no= "no";
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to play again? (yes or no).");

        try{
            String input = sc.nextLine(); // read user input
            sc.close(); // close scanner
            if(yes.equalsIgnoreCase(input)){
                initialize();

            }else if (no.equalsIgnoreCase(input)){

            }else{
                throw new Exception("Player input was not (yes or not).");
            }
        }catch(Exception e){
            System.out.println("Error in Game.startAgain() method!");
        }
    }
}
