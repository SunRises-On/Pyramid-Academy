public class Game {
    public String HangmanWord; //find word
    public char[] playerGuess;//array to keep track of guess

   public int maxNumberMisses; // max number of misses
    public int guesses; //number of guesses
    public int hit; //number of hits
    public int miss; // number of misses;
    //constructor
    public Game(String word){
         word = HangmanWord;
         playerGuess = new char[HangmanWord.length()];
         guesses = 0;
         maxNumberMisses = HangmanWord.length();
         hit = 0;
         miss = 0;
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
