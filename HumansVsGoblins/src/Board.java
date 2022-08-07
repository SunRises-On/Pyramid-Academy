import java.util.ArrayList;
import java.util.List;

public class Board implements  Commons{
    private List<Goblins> goblins = new ArrayList<>();
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
}
