import java.util.Random;

public class Helper implements Commons {
    //If board position is not occupied. Starter position is valid
    public static int[] starterPosition (Dimension dimension){
        //get x, y
        int[] position = new int[]{1,1};
        while (true){
            position[0] = getRandomNum(0,BOARD_WIDTH-1); //x rows
            position[1] = getRandomNum(0,BOARD_HEIGHT-1); //y columns
            boolean isClear = dimension.isFree(position);
            if(isClear == true) {break;}
        }
        return position;
    }
    public static int getRandomNum(int min, int max){

        Random rand = new Random();
        int randomNum = min + rand.nextInt((max - min) + 1); //nextInt is better than nextDouble
        return randomNum;
    }
}
