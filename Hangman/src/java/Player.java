import java.util.ArrayList;

public class Player{
    public String HangmanWord; //find word
    ArrayList<String> secretWord = new ArrayList<>();
    public char[] correctGuesses;//array to keep track of guess
    //Arraylist to keep track of misses
    ArrayList<String> playerMisses = new ArrayList<>();
   public static int maxNumberMisses = 7; // max number of misses
    public int guesses; //number of guesses
    public int hit; //number of hits
    public int miss; // number of misses;
    //constructor
    public Player(String word){
         word = HangmanWord;
         guesses = 0;
         hit = 0;
         miss = 0;
         //add an underscore to secretWord for each letter of "word".
         for(int i = 0; i< word.length(); ++i){
             secretWord.add("_");
         }
    }





    //get methods
    public int getGuesses() {
        return guesses;
    }
    public int getMaxNumberMisses(){
        return maxNumberMisses;
    }
    public int getHit(){
        return getHit();
    }
    public int getMiss(){
        return getMiss();
    }
}
