import java.util.Arrays;

public class Game{

    //set up new game
    public void initialize(){

        System.out.println("We are playing Hangman.");


        Scan scanFile = new Scan();
        //get hangman new word
        String word = scanFile.scanWordFile();

        Player newGame = new Player(word);

        //game is initialized go to rounds....
        play(newGame);
    }
    //Play the game
    public void play(Player player){
        Boolean isComplete = false;

        //While game is not over loop
        while(!isComplete){
            //Call printHangman

            //check if game is over
            isComplete = gameOver(player);
            //Game isn't over print...
            printHangman(player.getMiss());

            System.out.println("");
            //print missing letters
            missingLetters(player);
            System.out.println("");
            //print spaces or letters of Hangman word
            spaceOrLetters(player);


        }
        //Game is over

        //if game is over
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
    public void missingLetters(Player player){
        //replace brackets and commas with ""
        String str = Arrays.toString(player.playerMisses.toArray()).replace("[","").replace(",","").replace("]","");

        System.out.println("Missed letters: "+ str);
    }
    //Print spaces or letters
    public void spaceOrLetters(Player player){

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



}
