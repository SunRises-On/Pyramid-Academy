import java.util.ArrayList;

public class Player{
    public String HangmanWord; //find word
    //ArrayList to compare values
    public ArrayList<String> hangmanArray = new ArrayList<>();
    public ArrayList<String> secretWord = new ArrayList<>();

    //Arraylist to keep track of misses
    public ArrayList<String> playerMisses = new ArrayList<>();
   public final int maxNumberMisses = 7; // max number of misses
    public int hit; //number of hits
    public int miss; // number of misses;
    public Boolean won;
    //constructor
    public Player(String word){
         HangmanWord = word.toLowerCase();
         hit = 0;
         miss = 0;
         won = false;
         //add an underscore to secretWord for each letter of "word".
         for(int i = 0; i< word.length(); ++i){
             secretWord.add("_");
             char c = word.charAt(i); //get a sing letter
             String str = ""+ c; //convert char to string
             hangmanArray.add(str);
         }
    }
    public void updateHit(){
        hit += 1;
    }
    public void updateMiss(){
        miss += 1;
    }
    public void updateMissArray(String str){

        playerMisses.add(str);
        //setPlayerMisses( playerMisses.add(str));
    }
    //Change '_' to correct letter.
    public void updateSecretArray(int index, String s){
        secretWord.set(index,s);
    }
    public void updateWon(Boolean isWon){
        won = isWon;
    }
    //get methods
    public int getMaxNumberMisses(){
        return maxNumberMisses;
    }
    public int getHit(){
        return hit;
    }
    public int getMiss(){
        return miss;
    }
    public Boolean getWon(){
        return won;
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
