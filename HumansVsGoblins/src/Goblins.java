import java.util.Random;

public class Goblins extends Sprite{
    //private Loot loot;
    private final Character goblin = 'g';
    private final int[] attackArr = new int[]{2,5,10};
    private int health;
    private int attack;
    public Goblins(int[] pos){
        this.x = pos[0];
        this.y = pos[1];
        //Random rand = new Random( 1-4)
        //goblin will drop random loot on death
        //this.loot = new Loot();
        setImage(goblin);
        this.health = 6;
        int r = getRandom(0, 2);
        this.attack = attackArr[r];

    }
    public int getHealth(){
        return this.health;
    }
    public int getAttack(){
        return this.attack;
    }
    public int getRandom(int min, int max){

        Random rand = new Random();
        int randomNum = min + rand.nextInt((max - min) + 1); //nextInt is better than nextDouble
        return randomNum;
    }
    public void setHealth(int h){
        this.health = h;
    }
}
