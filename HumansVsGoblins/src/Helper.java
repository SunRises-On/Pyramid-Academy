import java.util.List;
import java.util.Random;
//Helper function contains game logic.
public class Helper implements Commons {
    //If board position is not occupied. Starter position is valid
    public static int[] starterPosition (Dimension dimension){
        //get x, y
        int[] position = new int[]{1,1};
        while (true){
            position[0] = getRandomNum(0,BOARD_WIDTH-1); //x rows
            position[1] = getRandomNum(0,BOARD_HEIGHT-1); //y columns
            boolean isClear = dimension.isFree(position);
            if(isClear) {break;}
        }
        return position;
    }
    public static int getRandomNum(int min, int max){

        Random rand = new Random();
        return min + rand.nextInt((max - min) + 1);
    }

    public static int getGoblinIndexAtPos(List<Goblins> goblinsList , int[] pos){
        int index = -1;
        for(Goblins goblins : goblinsList){
            int[] arr =  goblins.getPos();
            if(arr[0]== pos[0] && arr[1] == pos[1]){
                index = goblinsList.indexOf(goblins);
            }
        }
        if(index == -1){
            System.out.println("Error in Helper.getGoblinIndex");
        }
        return index;
    }
    public static void setSpriteDead(Sprite sprite){
        sprite.setIsVisible(false);
        sprite.setDead(true);
    }
    public static void handleGoblinAttack(int index, List<Goblins> goblins, Humans humans){

        int min = 1;
        int max = 10;
        int attackMultiplier = getRandomNum(min, max);

        int def = humans.getDefense();
        int hp = humans.getHealth();
        int atk = goblins.get(index).getAttack() ;
        atk *= attackMultiplier; //multiple goblin attack by multipler

        System.out.println("Goblin tries Clobber!");
        atk -= def;
        if(atk > 0){
            hp -= atk;
            humans.setHealth(hp);
            if(humans.getHealth() < 0){
                System.out.println("Goblin hits for " + atk +" Atk.");
                System.out.println("You are dead.");
                Helper.setSpriteDead(humans);
            }else{
                System.out.println("Goblin hits for " + atk +" Atk. You have "+ hp +" HP left.");
            }
        }else{
            System.out.println("Goblin attack fails!");
        }
        System.out.println();
    }
    public static void handleHumanAttack(int index, List<Goblins> goblins, Humans humans){

        int min = 1;
        int max = 3;
        int attackMultiplier = getRandomNum(min, max);

        int atk = humans.getAttack();
        int hp = goblins.get(index).getHealth();
        atk *= attackMultiplier;

        hp -= atk;
        goblins.get(index).setHealth(hp);
        if( hp <= 0){
            System.out.println("You hit for " + atk + " Atk. Goblin dies.");
            Helper.setSpriteDead(goblins.get(index));
        }else{
            System.out.println("You hit for " + atk + " Atk. Goblin has "+ hp +" HP left.");

        }
        System.out.println();
    }

}
