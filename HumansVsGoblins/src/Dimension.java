import java.util.ArrayList;
import java.util.List;

public class Dimension extends Sprite implements Commons{
    //two dimensional array
    protected List<List<String>> screen ;
    protected List<String> row;
    public Dimension(){
        screen = new ArrayList<List<String>>();
        row = new ArrayList<String>();
        x = BOARD_WIDTH;
        y = BOARD_HEIGHT;
        //add space to width
        for(int i = 0 ; i < x  ; ++x){
            row.add("0");
        }
        //add rows
        for(int i = 0; i <y ; ++y){
            screen.add(row);
        }

    }
}


/*
* // Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
public class HelloWorld {
    public static void main(String[] args) {
        List<List<String>> screen = new ArrayList<List<String>>();
        List<String> row = new ArrayList<String>();
        int x = 2;
        int y = 2;

        for(int i = 0 ; i < x  ; ++i){
            row.add("0");
        }
        //add rows
        for(int i = 0; i <y ; ++i){
            screen.add(row);
        }
        for(List<String> inner : screen){
            System.out.println(Arrays.toString(screen.toArray()));
        }
        System.out.println("??????");
        //String formattedString = screen.toString().replace(",", "") .replace("[", "")  .replace("]", "") ;
      //  System.out.println(screen);
    }
}
* */