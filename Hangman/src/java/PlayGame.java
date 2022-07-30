
public class PlayGame {

    public void Start(){

        System.out.println("We are playing Hangman.");


        FindWord scanFile = new FindWord();
        //get hangman new word
        String word = scanFile.scanWordFile();


        Game newGame = new Game(word);
    }

}
