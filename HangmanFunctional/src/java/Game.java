package java;

import java.util.*;

public class Game{
    public Boolean isComplete;
    public ArrayList<String> screen;
    //set up new game
    public void initialize(){

        Scan scanFile = new Scan();
        //get hangman new word
        String word = scanFile.scanWordFile();
        //System.out.println("Answer = "+word);

        Player newGame = new Player(word);
        isComplete = false;
        screen = new ArrayList<>();
        play(newGame); //loop to play
    }
    //Play the game
    public void play(Player player){
        int flag = 0;
        Scanner sc = new Scanner(System.in);
        UI(player, flag);
        flag = 1; //printed welcome message
        //While game is not over loop
        while(!isComplete){

            UI( player, flag);
            //Guess a letter
            guess(player, sc);
            //check if completed the game
            gameOver(player);
        }
        //Game is over, check if player won;
        flag = wonOrLoss(player);
        //Print the winning or losing message
        UI(player, flag);
        //printed separate messages ask if the player wants to continue
        startAgain(sc);
    }
    public void UI(Player player, int flag){

        if(flag <3 && flag>0) {
            printHangman(player.getMiss()); // print hangman
        }

        switch (flag) {
            case 0->screen.add("HANGMAN"); //first message of game
            case 1 -> { //play(), still playing game
                gameOver(player);
                if (isComplete) {
                    return;
                }
                String missing = "Missed letters: " +trim(player.getPlayerMisses()); //get missing letters
                String progress = trim(player.getSecretWord()); //get current progress
                Collections.addAll(screen, "", missing, "", progress);
            }
            case 2 -> //play() print losing message
                    Collections.addAll(screen, "", "Max number of guesses!", "", "GameOver!");
            case 3 -> //play() print winning message
                    screen.add("Yes! The secret word is " + player.getHangmanWord() + "! You have won!");
            case 4-> //handleInput()
                    Collections.addAll(screen,"","Guess a letter.","");
            case 5-> //startAgain()
                    screen.add("Do you want to play again? (yes or no).");
        }
        printArray(screen); //print menu
    }
    //Method to find out if game is won.
    public void gameOver(Player player){
        isComplete = (player.getMiss() == player.getMaxNumberMisses() || player.getHit() == player.getHangmanWord().length());
    }
    //Trim brackets and commas.
    public String trim(ArrayList<String> arr){
        //replace brackets and commas with ""
        return Arrays.toString(arr.toArray()).replace("[","").replace(",","").replace("]","");
    }
    //Print hangman, depending on number of misses.
    public void printHangman(int miss){
        //create a basic hangman
        Collections.addAll(screen," +---+","","     |","","     |","","     |","","    ===");

        switch(miss) {
            case 3, 4, 5, 6, 7: screen.set(6, " |   |");
            case 2: screen.set(4, " |   |");
            case 1: screen.set(2, " O   |");
        }
        switch (miss) {
            case 4->screen.set(4, "\\|   |");
            case 5, 6, 7 -> screen.set(4, "\\|/  |");
        }
        switch (miss) { //enhanced switch -> will break
            case 6 -> screen.set(7, "/");
            case 7 -> screen.set(7, "/ \\");
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
    public void guess(Player player, Scanner sc) {

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
            guess(player, sc); //restart player guess
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
        UI(null ,4);
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
        ListIterator<String> iterator = player.getHangmanArray().listIterator();
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
        if((player.getPlayerMisses().size() == player.getMaxNumberMisses())){ //if player lost return flag = 2
            return 2;
        }
        return 3;
    }
    //Ask if the player wants to play again.
    public void startAgain(Scanner sc){
        String yes = "yes";
        String no= "no";
        UI(null, 5);

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
