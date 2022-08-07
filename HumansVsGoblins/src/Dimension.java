import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dimension extends Sprite implements Commons{
    //two dimensional array
    protected List<List<Character>> screen ;
    protected List<Character> row;
    public Dimension(){
        screen = new ArrayList<List<Character>>();
        row = new ArrayList<Character>();
        x = BOARD_WIDTH;
        y = BOARD_HEIGHT;
        //add space to row
        for(int i = 0 ; i < x  ; ++i){
            row.add('0');
        }
        //add rows
        for(int i = 0; i <y ; ++i){
            screen.add(row);
        }

    }

    public void printDimension(){
        for(List<Character> inner : screen){
            String format = Arrays.toString(inner.toArray()).replace(",","").replace("[","").replace("]","");
            System.out.println(format);
        }
    }
    public boolean isFree(int[] pos){
        int x = pos[0];
        int y = pos[1];
        int i = 0;
        Character c = screen.get(x).get(y);
        if(c != '0'){
            return false;
        }

        return true;
    }
    public void setIndex (int[] pos, Character image){
        int x = pos[0];
        int y = pos[1];
        int i = 0;
        screen.get(y).set(x, image);
    }
}


