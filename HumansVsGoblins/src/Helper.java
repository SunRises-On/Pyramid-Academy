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
            if(isClear == true) {break;}
        }
        return position;
    }
    public static int getRandomNum(int min, int max){

        Random rand = new Random();
        int randomNum = min + rand.nextInt((max - min) + 1); //nextInt is better than nextDouble
        return randomNum;
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

        int def = humans.getDefense();
        int hp = humans.getHealth();
        int attack = goblins.get(index).getAttack();

        System.out.println("Goblin tries attacks with " + attack + " damage.");
        attack -= def;
        if(attack > 0){
            System.out.println("Goblin attacks with " + attack +" damage.");
            hp -= attack;
            humans.setHealth(hp);
            if(humans.getHealth() < 0){
                System.out.println("You are dead.");
                Helper.setSpriteDead(humans);
            }else{
                System.out.println("Health = "+hp + ".");
            }
        }else{
            System.out.println("Goblin attack fails!");
        }
    }
    public static void handleHumanAttack(int index, List<Goblins> goblins, Humans humans){
        int attack = humans.getAttack();
        int hp = goblins.get(index).getHealth();

        hp -= attack;
        goblins.get(index).setHealth(hp);
        if( hp <= 0){
            System.out.println("You attack with " + attack + " damage. Goblin dies.");
            Helper.setSpriteDead(goblins.get(index));
        }else{
            System.out.println("You attack with " + attack + " Damage. Goblin has "+ hp +" HP left.");

        }
    }

}
