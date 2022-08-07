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
        if(x >= BOARD_WIDTH || y>= BOARD_HEIGHT){
           //throw an exception
        }
        if(x < 0 || y < 0){
            //throw an exception
        }
        Character c = screen.get(x).get(y);
        if(c != '0'){
            return false;
        }

        return true;
    }
    public boolean setIndex (int[] pos, Character image){
        int x = pos[0];
        int y = pos[1];
        int i = 0;
        screen.get(y).set(x, image);
        return true;
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