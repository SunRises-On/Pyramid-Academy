import Items.*;
import Items.Equipment.*;
import Items.Equipment.Basic.*;

import java.util.ArrayList;

public class Humans extends Sprite implements Commons, Inventory{
    private ArrayList<Object> inventory;
    private Integer money;
    private Armour helmet;
    private Armour breastplate;
    private Armour boots;
    private Armour gauntlet;
    private Armour pants;
    private Weapon sword;

    private int health;
    private int attack;
    private int defense;
    private final String human = "h";
    Humans(){

    }
    Humans(int xPos, int yPos){
        Armour basicBoots = new BasicBoots(true);
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
        this.money = 0;
        setImage(human);
        setX(xPos);
        setY(yPos);
    }

    /****************************************************************
     *  position
     *
     *
     ****************************************************************/
    public void act(char c){
        if(c == 'N'){ //y axis
            y += 1;
            if( y >= BOARD_WIDTH-1){
                y = BOARD_WIDTH-1;
            }
        }
        else if (c == 'S'){
            y -= 1;
            if( y <= 1){
                y = 1;
            }
        }
        else if (c == 'E'){ // x axis
            x += 1;
            if( x >= BOARD_WIDTH-1){
                x = BOARD_WIDTH-1;
            }
        }
        else if (c == 'W'){
            x -= 1;
            if ( x <= 1){
                x = 1;
            }
        }

    }
    /****************************************************************
     *   Health Attack
     *
     *
     ****************************************************************/
     public void setHealth (int newHealth){
         this.health = newHealth;
     }
     public int getHealth () { return health;}
    /****************************************************************
     *   Armour and Weapon
     *
     *
     ****************************************************************/



    /****************************************************************
     *  Attack and defense
     *
     *
     ****************************************************************/
    public void setDefense(Armour getBoots, Armour getBreastplate, Armour getGauntlet, Armour getHelmet, Armour getPants){
        this.defense = getBoots.getDefense() + getBreastplate.getDefense() + getGauntlet.getDefense() + getHelmet.getDefense() + getPants.getDefense();
    }
    public void setAttack(Weapon weapon){
            this.attack = weapon.getAttack();
    }
    public Integer getAttack (){return attack;}
    public Integer getDefense(){ return defense; }


    /****************************************************************
     * Money and Inventory
     *
     *
     ****************************************************************/
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
}
