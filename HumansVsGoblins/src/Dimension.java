import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dimension extends Sprite implements Commons{
    //two dimensional array
    protected List<List<Character>> screen ;
    protected List<Character> row;
    private final Character fill = '_';
    public Dimension(){
        screen = new ArrayList<List<Character>>();

        x = BOARD_WIDTH;
        y = BOARD_HEIGHT;
        //Have to initialize each index
        for(int i = 0 ; i < x  ; ++i) {
            row = new ArrayList<>();
            for (int j = 0; j < y; j++) {
                row.add(fill);
            }
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
        Character c = screen.get(rowSet).get(column);
        if(c == fill){
            return true;
        }

        return false;
    }
    public void setIndex (int[] posNew, Character imageNew){
        int rowSet = posNew[0]; // x
        int column = posNew[1]; // y
        Character image = imageNew;

       screen.get(rowSet).set(column, image);
    }

    public Character getIndexImage(int[] pos){
        int rowSet = pos[0]; // x
        int column = pos[1]; // y
        Character c = ' ';
        c = screen.get(rowSet).get(column);

        return c;
    }
    public void setIndexBlank (int[] pos){
        setIndex(pos, this.fill);
    }
}


