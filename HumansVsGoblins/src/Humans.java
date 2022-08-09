import Items.Equipment.*;
import Items.Equipment.Basic.*;

import java.util.ArrayList;

public class Humans extends Sprite implements Commons, Inventory{
    //private ArrayList<Object> inventory;
    //private Integer money;
    private Armour helmet;
    private Armour breastplate;
    private Armour boots;
    private Armour gauntlet;
    private Armour pants;
    private Weapon sword;

    private int health;
    private int attack;
    private int defense;
    private final Character human = 'h';

    Humans(int[] pos){
        Armour basicBoots =  new BasicBoots(true);
        Armour basicBreastplate = new BasicBreastplate(true);
        Armour basicGauntlet = new BasicGauntlet(true);
        Armour basicHelmet = new BasicHelmet(true);
        Armour basicPants = new BasicPants(true);
        Weapon basicSword = new BasicSword(true);
        this.boots = basicBoots;
        this.breastplate = basicBreastplate;
        this.gauntlet = basicGauntlet;
        this.helmet = basicHelmet;
        this.pants = basicPants;
        this.sword = basicSword;
        this.health = 10;
        setAttack(sword);
        setDefense(boots, breastplate, gauntlet, helmet, pants);
        //this.money = 0;
        setImage(human);
        setX(pos[0]);
        setY(pos[1]);
    }

    public void act(char c){
        if(c == 'n'){ //y-axis, the graph is flipped this.x = y-axis
            x -= 1;
            if( x < 0){
                x = 0;
            }
        }
        else if (c == 's'){
            x += 1;
            if( x >= BOARD_HEIGHT-1) {
                x = BOARD_HEIGHT - 1;
            }
        }
        else if (c == 'e'){ // x axis, this.y = x-axis
            y += 1;
            if( y >= BOARD_WIDTH-1){
                y = BOARD_WIDTH-1;
            }
        }
        else if (c == 'w'){
            y -= 1;
            if ( y < 0){
                y = 0;
            }
        }

    }
     public void setHealth (int newHealth){
         this.health = newHealth;
     }
     public int getHealth () { return health;}

    public void setDefense(Armour getBoots, Armour getBreastplate, Armour getGauntlet, Armour getHelmet, Armour getPants){
        this.defense = getBoots.getDefense() + getBreastplate.getDefense() + getGauntlet.getDefense() + getHelmet.getDefense() + getPants.getDefense();
    }

    public void setAttack(Weapon weapon){
            this.attack = weapon.getAttack();
    }
    public Integer getAttack (){return attack;}
    public Integer getDefense(){ return defense; }

    public Integer getMoney (int money){
        return null;
    }

    //searches inventory of object and returns it
    public Object searchInventory(ArrayList<Object> inventory) {
        return null;
    }
    //searches inventory and removes object and returns inventory
    public ArrayList<Object> removeItem(ArrayList<Object> inventory, Object obj){
        return null;
    }
    //add item to inventory
    public ArrayList<Object> addItem(ArrayList<Object> inventory, Object obj){
        return null;
    }
    @Override
    public String toString(){
        return "Human's health = "+health+" attack = "+ attack + " defense = " + defense + ".";
    }
}
