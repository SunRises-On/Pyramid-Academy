public class Goblins extends Sprite{
    //private Loot loot;
    private final String goblin = "g";
    public Goblins(int xPos, int yPos){
        this.x = xPos;
        this.y = yPos;
        //Random rand = new Random( 1-4)
        //goblin will drop random loot on death
        //this.loot = new Loot();
        setImage(goblin);
    }
}
