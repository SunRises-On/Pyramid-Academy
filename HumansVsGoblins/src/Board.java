import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            d.printDimension();
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
      //  d.printDimension();
       // System.exit(1);
        run();

    }
    public void drawGoblins(){
        d.printDimension();
        for(Goblins goblin  : goblins){
            int[] arr = new int[]{1,1};
            arr[0] = goblin.getX();
            arr[1] = goblin.getY();

            if(goblin.getIsVisible()){
                d.setIndex(arr, goblin.getImage());
            }
            if(goblin.getIsDead()){

                d.setIndexBlank(arr);
                goblins.remove(goblin);
            }
        }
    }
    public void drawPlayer(){
        System.out.println("we are in draw player");
        d.printDimension();
        System.out.println();
        if (humans.getIsVisible()){
            int[] arr = new int[]{1,1};
            arr[0] = humans.getX();
            arr[1] = humans.getY();
            System.out.println("Array[0] = " + arr[0] + " Array[1] = " + arr[1]);
            d.setIndex(arr, humans.getImage());
        }
        if(humans.getIsDead()){
            humans.die();
            haveWon = false;
            inGame = false;

        }
        d.printDimension();
        System.out.println("We are leaving drawPlayer");
    }
    public void gameOver(Scanner sc){
        if(haveWon){
            System.out.println("You have won");
        }else{
            System.out.println("You lost.");
        }
        System.out.println("Do you want to play again?(Yes or No)");

    }
    //Get user input, verify the input. Check if space is useful.
    public void humansMovement(Scanner sc){
        char c = 'a';
        int[] arr = new int[]{1,1};
        arr[0] = humans.getX();
        arr[1] = humans.getY();
        System.out.println("Input N,S,W, or E to move.");
        try{
            c = sc.next().charAt(0);//get next char
            switch(c){
                case 'N','S','W','E' -> humans.act(c);
                default -> {
                    System.out.println("Only input : N,S,W,or E.");
                    humansMovement(sc);
                }
            }

        }catch (Exception e){
            System.out.println("Error in Board.humansMovement().");
            System.exit(1);
        }
        if( humans.getX() == arr[0] && humans.getY() == arr[1]){
            System.out.println("Human didn't move. Try Again.");
            humansMovement(sc);
        }
        d.setIndexBlank(arr); //set old human position to blank;

    }
    public void animationCycle(Scanner sc){
        if (deaths == NUMBER_OF_GOBLINS){
            inGame = false;
            System.out.println("You have defeated the goblins!");
        }
        d.printDimension();
        System.out.println("We are in animatinCycle.");
        humansMovement(sc);
        //check if space contains goblin
        // if it contains goblin do combat
        //combat uses goblin health,attack
        //human attack, defense, health
        // do set visible and set dead
        //for goblin and human

    }
    public void paint(){
        if(inGame){
            drawGoblins();
            drawPlayer();

            d.printDimension();
            System.out.println("We are leaving paint");
        }
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        while(inGame){
            paint();
            animationCycle(sc);
        }
        gameOver(sc);
    }

}
