import java.util.*;

public class Game{
    public Boolean isComplete;
    //set up new game
    public void initialize(){

        System.out.println("We are playing Hangman.");

        Scan scanFile = new Scan();
        //get hangman new word
        String word = scanFile.scanWordFile();
        System.out.println("Answer = "+word);
      //  String word = "apple";
        Player newGame = new Player(word);
        isComplete = false;
        //game is initialized go to rounds....
        play(newGame);
    }
    //Play the game
    public void play(Player player){
        int flag = 1;
        Scanner sc = new Scanner(System.in);
        ArrayList<String> screen = new ArrayList<>();
        //While game is not over loop
        while(!isComplete){

            menu( player, screen, flag);
            //Guess a letter
            playerGuess(player, sc);
            //check if completed the game
            gameOver(player);
        }
        //Game is over, check if player won;
        flag = wonOrLoss(player);
        //Print the winning or losing message
        menu(player, screen, flag);
        //printed separate messages ask if the player wants to continue
        startAgain(sc);
    }
    public void menu(Player player, ArrayList<String> screen, int flag){

        if(flag <3) {
            printHangman(player.getMiss()); // print hangman
        }

        switch(flag){
            case 1: //still playing print missing letters and progress so far
                gameOver(player);
                if(isComplete){
                    return;
                }
                String missing = trim(player.getPlayerMisses()); //get missing letters
                String progress = "Missed letters: "+ trim(player.getSecretWord()); //get current progress
                Collections.addAll(screen,"",missing,"",progress);
                break;
            case 2: //print losing message
                Collections.addAll(screen,"","Max number of guesses!","","GameOver!");
                break;
            case 3: //print winning message
                screen.add("Yes! The secret word is "+ player.HangmanWord + "! You have won!");
                break;
        }
        printArray(screen); //print menu
    }
    //Method to find out if game is won.
    public void gameOver(Player player){
        isComplete = (player.miss == player.maxNumberMisses || player.hit == player.HangmanWord.length());
    }
    //Trim brackets and commas.
    public String trim(ArrayList<String> arr){
        //replace brackets and commas with ""
        return Arrays.toString(arr.toArray()).replace("[","").replace(",","").replace("]","");
    }
    //Print hangman, depending on number of misses.
    public void printHangman(int miss){
        ArrayList<String> screen = new ArrayList<>();

        //create a basic hangman
        Collections.addAll(screen," +---+","","     |","","     |","","     |","","    ===");

        switch(miss) {
            case 4:
                screen.add(4, "\\|  |");
            case 3:
                screen.set(6, " |   |");
            case 2, 5, 6, 7:
                screen.set(4, " |   |");
            case 1:
                screen.set(2, " O   |");
                break;
        }
        switch(miss) {
            case 5, 6, 7:
                screen.add(4, "\\|/  |");
        }
        switch(miss){
            case 6:
                screen.set(7,"/");
                break;
            case 7:
                screen.set(7,"/ \\");
        }
        printArray(screen);
    }
    //Print and clear array
    public void printArray( ArrayList<String> ar){
        for(String str: ar){
            System.out.println(str);
        }
        ar.clear();
    }
    //Handle player guess
    public void playerGuess( Player player, Scanner sc) {

        //handle guess input
        char letter = handleInput(player, sc);
        String str = "" + letter;//convert letter to string
        str = str.toLowerCase();
        //Check if letter has already been guessed
        boolean isGuessed = player.getPlayerMisses().contains(str);
        if(!isGuessed){ //check if it has successfully been guessed
            isGuessed = player.getSecretWord().contains(str);
        }
        if(isGuessed){
            System.out.println("You have already guessed that letter. Choose again.");
            playerGuess(player, sc); //restart player guess
        }else{
            boolean isHit = player.getHangmanArray().contains(str);
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
        return ( c >= 'a' && c<= 'z') || (c >= 'A' && c<= 'Z');
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
                player.updateHit(); //We've found a hit
                player.updateSecretArray(i,s); //update secret Array with found letter(s)
            }
            ++i;
        }
    }
    //Update Player Object with won or lose of game and update flag
    public int wonOrLoss(Player player){
        boolean won = (!(player.playerMisses.size() == player.getMaxNumberMisses()));
        player.updateWon(won);

        if(!won){ //if player lost return flag = 2
            return 2;
        }
        return 3;
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
