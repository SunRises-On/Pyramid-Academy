public class Goblins extends Sprite{
    //private Loot loot;
    private final Character goblin = 'g';
    public Goblins(int[] pos){
        this.x = pos[0];
        this.y = pos[1];
        //Random rand = new Random( 1-4)
        //goblin will drop random loot on death
        //this.loot = new Loot();
        setImage(goblin);
    }
}
