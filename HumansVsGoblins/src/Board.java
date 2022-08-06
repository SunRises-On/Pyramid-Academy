public class Board implements  Commons{
    private Goblins goblin1;
    private Goblins goblin2;
    private Goblins goblin3;
    private Goblins goblin4;
    private Humans humans;

    private Dimension d;

    private int deaths = 0;

    private boolean playing = true;
    private boolean haveWon = true;

    public Board(){
        d = new Dimension();
        gameInit();
    }
    public void gameInit(){

    }
}
