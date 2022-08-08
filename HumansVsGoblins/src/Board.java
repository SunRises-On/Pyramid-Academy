import java.util.ArrayList;
import java.util.List;

public class Board implements  Commons{
    private List<Goblins> goblins = new ArrayList<>();
    private Humans humans;

    private Dimension d;

    private int deaths = 0;

    private boolean inGame = true;
    private boolean haveWon = true;

    public Board(){
        d = new Dimension();
        gameInit();
    }
    public void gameInit(){
        //initalize players and goblins
        goblins = new ArrayList<>();
        for(int i = 0; i <= NUMBER_OF_GOBLINS ; ++i){
            int[] pos = new int[]{0,0};
            pos = Helper.starterPosition(d);
            if (i == 0){
                humans = new Humans(pos);
                d.setIndex(pos, humans.getImage());
            }
            else{
                Goblins g = new Goblins(pos);
                goblins.add(g);
                d.setIndex(pos, g.getImage());
            }
        }
        d.printDimension();
        System.exit(1);

    }
    public void drawGoblins(){
        for(Goblins goblin  : goblins){
            if(goblin.getIsDead()){
                int[] arr = new int[]{2};
                arr[0] = goblin.getX();
                arr[1] = goblin.getY();
                d.setIndexBlank(arr);
                goblins.remove(goblin);
            }
        }
    }
    public void drawPlayer(){
        if (humans.getIsVisible()){
            int[] arr = new int[]{2};
            arr[0] = humans.getX();
            arr[1] = humans.getY();
            d.setIndex(arr, humans.getImage());
        }
        if(humans.getIsDead()){
            humans.die();
            haveWon = false;
            inGame = false;

        }
    }
    public void gameOver(){
        if(haveWon){
            System.out.println("You have won");
        }else{
            System.out.println("You lost.");
        }
        System.out.println("Do you want to play again?");
    }
    public void humansMovement(){
        //get input
        //check if input is useful
        //if useful set space to blank
        //set human to new position

        //check if space contains goblin
        // if it contains goblin do combat
        //combat uses goblin health,attack
        //human attack, defense, health
        // do set visible and set dead
        //for goblin and human
    }
    public void animationCycle(){
        if (deaths == NUMBER_OF_GOBLINS){
            inGame = false;
            System.out.println("You have defeated the goblins!");
        }
        d.printDimension();
        humansMovement();


    }
    public void paint(){
        if(inGame){
            drawGoblins();
            drawPlayer();
        }
    }

    public void run(){
        
        while(inGame){
            paint();
            animationCycle();
        }
        gameOver();
    }

}
