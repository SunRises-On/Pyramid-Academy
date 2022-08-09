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
        goblins = new ArrayList<>();
        for(int i = 0; i <= NUMBER_OF_GOBLINS ; ++i){
            int[] pos = Helper.starterPosition(d);
            if (i == 0){
                humans = new Humans(pos);
                d.setIndex(pos, humans.getImage());
                System.out.println(humans.toString());
            }
            else{
                Goblins g = new Goblins(pos);
                goblins.add(g);
                d.setIndex(pos, g.getImage());
                if(i == 1) {
                    System.out.println("Basic goblin stats. " + g.toString());
                }
            }
        }
        run();
    }
    public void drawGoblins(){
        for(Goblins g  : goblins){
            int[] arr = g.getPos();

            if(g.getIsVisible()){
                d.setIndex(arr, g.getImage());
            }
            if(g.getIsDead()){
                d.setIndexBlank(arr);
                goblins.remove(g);
                break;
            }
        }
    }
    public void drawPlayer(){

        if (humans.getIsVisible()){
            int[] arr = humans.getPos();
            d.setIndex(arr, humans.getImage());
        }
        if(humans.getIsDead()){
            humans.die();
            haveWon = false;
            inGame = false;
        }
    }
    public void gameOver(Scanner sc){
        sc.close();
        if(haveWon){
            System.out.println("You have won");
            System.exit(2);
        }else{
            System.out.println("You lost.");
            System.exit(3);
        }

    }
    //Get user input, verify the input. Check if space is useful.
    public void humansMovement(Scanner sc){
        char c;
        int[] arr = humans.getPos();
        System.out.println("Input n,s,w, or e to move.");
        try{
            c = sc.next().charAt(0);//get next char
            switch(c){
                case 'n','s','w','e' -> humans.act(c);
                default -> {
                    System.out.println("Only input : n,s,w,or e.");
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
    //Check if space contains goblin
    public boolean startCombat(){
        int[] arr = humans.getPos();
        boolean isFree = d.isFree(arr);
        Character c = goblins.get(0).getImage();
        if(!isFree){
            Character charFind = d.getIndexImage(arr);
            if(charFind == c){
                return true;
            }
        }
        return false;
    }
    //Do combat, combat uses math.random differently for human and goblin
    public void combat(){
        int[] arr = humans.getPos();
        int index = Helper.getGoblinIndexAtPos(goblins, arr);

        Helper.handleGoblinAttack(index, goblins, humans);

        if( !humans.getIsDead()){
            Helper.handleHumanAttack(index, goblins, humans);
            if(goblins.get(index).getIsDead()){
                deaths++;
            }
        }

        if( !goblins.get(index).getIsDead() && !humans.getIsDead()){
            combat();
        }
    }

    public void animationCycle(Scanner sc){
        boolean collision;

        d.printDimension();

        humansMovement(sc);

        collision = startCombat();

        if(collision){
            combat();
        }
    }
    public void isPlayerInGame (){

        if (deaths == NUMBER_OF_GOBLINS){
            inGame = false;
            System.out.println("You have defeated the goblins!");
        }
        if(humans.getIsDead()){
            inGame = false;
            haveWon = false;
        }
    }
    public void paint(){
        drawGoblins();
        drawPlayer();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        while(inGame){
            paint();
            animationCycle(sc);
            isPlayerInGame();
        }
        gameOver(sc);

    }
}
