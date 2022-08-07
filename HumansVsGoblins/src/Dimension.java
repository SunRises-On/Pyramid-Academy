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
        int rowSet = pos[0]; // x
        int column = pos[1]; // y 
        Character c = screen.get(column).get(rowSet);
        if(c != '0'){
            return false;
        }

        return true;
    }
    public void setIndex (int[] pos, Character image){
        int rowSet = pos[0]; // x
        int column = pos[1]; // y
        screen.get(column).set(rowSet, image);
    }

    public Character getIndexImage(int[] pos){
        Character c = ' ';


        return c;
    }
}


