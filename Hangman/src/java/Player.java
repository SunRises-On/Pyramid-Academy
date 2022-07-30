import java.util.ArrayList;

public class Player{
    public String HangmanWord; //find word
    //ArrayList to compare values
    public ArrayList<String> hangmanArray = new ArrayList<>();
    public ArrayList<String> secretWord = new ArrayList<>();

    //Arraylist to keep track of misses
    public ArrayList<String> playerMisses = new ArrayList<>();
   public static final int maxNumberMisses = 7; // max number of misses
    public int guesses; //number of guesses
    public int hit; //number of hits
    public int miss; // number of misses;
    //constructor
    public Player(String word){
         HangmanWord = word;
         guesses = 0;
         hit = 0;
         miss = 0;
         //add an underscore to secretWord for each letter of "word".
         for(int i = 0; i< word.length()-1; ++i){
             secretWord.add("_");
             char c = word.charAt(i); //get a sing letter
             String str = ""+ c; //convert char to string
             hangmanArray.add(str);
         }
    }
    private void setGuesses(int setGuesses){
        guesses = setGuesses;
    }
    private void setHit(int setHit){
        hit = setHit;
    }
    private void setMiss(int setMiss){
        miss = setMiss;
    }
    private void setSecretWord(ArrayList<String> setSecretWord){
        secretWord = setSecretWord;
    }
    private void setPlayerMisses(ArrayList<String> setPlayerMisses){
        playerMisses = setPlayerMisses;
    }

    //get methods
    public int getGuesses() {
        return guesses;
    }
    public int getMaxNumberMisses(){
        return maxNumberMisses;
    }
    public int getHit(){
        return hit;
    }
    public int getMiss(){
        return miss;
    }
    public ArrayList<String> getSecretWord(){
        return secretWord;
    }
    public ArrayList<String> getPlayerMisses(){
        return playerMisses;
    }
    public ArrayList<String> getHangmanArray(){
        return hangmanArray;
    }
}
