import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Scanner;

public class Game{

    //set up new game
    public void initialize(){

        System.out.println("We are playing Hangman.");

        Scan scanFile = new Scan();
        //get hangman new word
        String word = scanFile.scanWordFile();
        System.out.println("Answer = "+word);
      //  String word = "apple";
        Player newGame = new Player(word);

        //game is initialized go to rounds....
        play(newGame);
    }
    //Play the game
    public void play(Player player){
        Boolean isComplete = false;
        Boolean playerWon = false;
        Scanner sc = new Scanner(System.in);
        //While game is not over loop
        while(!isComplete){
            //Call print Hangman
            printHangman(player.getMiss());
            //check if game is over if we have lost the game
            isComplete = gameOver(player);

            System.out.println();
            //print missing letters
            printMissingLetters(player);
            //print progress of Hangman word
            printProgress(player);
            //Guess a letter
            playerGuess(player, sc);
            //check if completed the game
            isComplete = gameOver(player);
        }

        //Game is over, check if player won;
        playerWon = wonOrLoss(player);
        //if player didn't win print hangman
        if(!playerWon) {
            printHangman(player.getMiss());
        }
        //Print the winning or losing message
        winningMessage(playerWon, player);

        //printed separate messages ask if the player wants to continue
        startAgain(sc);
    }
    //Method to find out if game is won.
    public Boolean gameOver(Player player){
        return (player.miss == player.maxNumberMisses || player.hit == player.HangmanWord.length());
    }
    //Print missing letters from Object player
    public void printMissingLetters(Player player){
        //replace brackets and commas with ""
        String str = Arrays.toString(player.playerMisses.toArray()).replace("[","").replace(",","").replace("]","");
        System.out.println();
        System.out.println("Missed letters: "+ str);
    }
    //Print progress on guessing secret word.
    public void printProgress(Player player){
        //replace brackets and commas with ""
        String str = Arrays.toString(player.secretWord.toArray()).replace("[","").replace(",","").replace("]","");
        System.out.println();
        System.out.println(str);
    }
    //Print hangman, depending on number of misses.
    public void printHangman(int miss){
        ArrayList<String> screen = new ArrayList<>();
        for(int i = 0 ; i <= 9 ; ++i){
            screen.add("");
        }

        screen.set(0," +---+");//index 0
        //index 2
        String line2 = miss > 0 ? (" O   |") :("     |");
        screen.set(2,line2);

        if(miss<2){
            screen.set(4,"     |");
        }else if (miss <4) {
            screen.set(4," |   |");
        }else if (miss == 4){
            screen.set(4, "\\|  |");
        }else{
            screen.set(4,"\\|/  |");
        }
        String index6 = miss < 3 ?"     |" :" |   |" ;
        screen.set(6,index6);

        if(miss == 6){
            screen.set(7,"/");
        }else if (miss == 7){
            screen.set(7,"/ \\");
        }
        screen.set(8,"    ===");
        for(String str : screen){
            System.out.println(str);
        }
    }
    //Handle player guess
    public void playerGuess( Player player, Scanner sc) {

        //handle guess input
        char letter = handleInput(player, sc);
        String str = "" + letter;//convert letter to string
        //Check if letter has already been guessed
        Boolean isGuessed = isMissRepeated(letter, player);
        isGuessed = isHitRepeated(letter, player);
        if(isGuessed){
            System.out.println("You have already guessed that letter. Choose again.");
            playerGuess(player, sc); //restart player guess
        }else{
            Boolean isHit = correctGuess(str, player);
            if(!isHit){ //incorrect guess
                updateMiss(str, player);
            }else{ //correct guess
                updateHit(str, player);
            }
        }

    }
    //Handle and input player input into Player object.
    public char handleInput(Player player, Scanner sc){
        
        char c = 'a';
        System.out.println();
        System.out.println("Guess a letter.");
        System.out.println();
        try{
            c = sc.next().charAt(0);//get next char
            Boolean correct = isLetter(c);//check if it's a letter

            if(!correct){
                System.out.println("Only input letters a-z and A-Z.");
                handleInput(player, sc);
            }

        }catch (Exception e){
            System.out.println("Error in Game.handleInput() method!");
            System.exit(1);
        }
        return c;
    }
    //check if char is a letter
    private Boolean isLetter(char c){
        return ( c >= 'a' && c<= 'z') ||
                (c >= 'A' && c<= 'Z');
    }
    //Check if letter ha been guessed.
    public Boolean isMissRepeated(char l, Player player){
        String str = ""+l;
        str = str.toLowerCase();

        for(String element : player.getPlayerMisses()){
            //== tests for reference equality (whether they are the same object
            //.equals() tests for value equality
            if(element.equals(str)){
                return true;
            }
        }
        return false;
    }
    public Boolean isHitRepeated(char l, Player player){
        String str = ""+l;
        str = str.toLowerCase();
        for(String element : player.getSecretWord() ){
            if(element.equals(str)){
                return true;
            }
        }
        return false;
    }
    //Check if guess is a hit
    public Boolean correctGuess (String s, Player player){

        for(String element: player.getHangmanArray() ){
            if(element.equals(s)){
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
    // if (condition)  is true return false.
    public Boolean wonOrLoss(Player player){
        return !(player.playerMisses.size() == player.getMaxNumberMisses());
    }
    //Print the win or loss screen.
    public void winningMessage(Boolean won, Player player ){
        //print lose message
        if(!won){
            System.out.println();
            System.out.println("Max number of guesses!");
            System.out.println();
            System.out.println("Game Over!");
        } else{ //print win message
            System.out.println("Yes! The secret word is "+ player.HangmanWord + "! You have won!");
        }
    }

    //Ask if the player wants to play again.
    public void startAgain(Scanner sc){
        String yes = "yes";
        String no= "no";
        System.out.println("Do you want to play again? (yes or no).");
        //after try block scanner is closed
        try{

            String input = sc.next(); // read user input

            if(yes.equalsIgnoreCase(input)){

            }else if (no.equalsIgnoreCase(input)){
                sc.close();
                System.exit(0);
            }else{
                throw new Exception("Player input was not (yes or not).");
            }
        }catch(Exception e){
            System.out.println("Error in Game.startAgain() method!");
        }

    }
}
