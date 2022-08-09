import java.util.Random;

public class Goblins extends Sprite{
    //private Loot loot;
    private final Character goblin = 'g';
    private int health;
    private int attack;
    public Goblins(int[] pos){
        this.x = pos[0];
        this.y = pos[1];
        //goblin will drop random loot on death
        //this.loot = new Loot();
        setImage(goblin);
        this.health = 6;
        this.attack = 10;

    }
    public int getHealth(){
        return this.health;
    }
    public int getAttack(){
        return this.attack;
    }

    public void setHealth(int h){
        this.health = h;
    }
}
