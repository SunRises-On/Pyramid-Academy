package Items.Equipment.Basic;

import Items.Equipment.Weapon;

public class BasicSword implements Weapon {
    private String name;
    private String description;
    private int attack;
    private Boolean isWorn;
    public BasicSword(){
        this.name = "Basic Sword";
        this.description = "Well it's a sword at least.";
        this.attack = 5;
        this.isWorn = false;
    }
    public BasicSword(Boolean changeIsWorn){
        this();
        this.isWorn = changeIsWorn;
    }
    public void setWorn(Boolean worn) {
        isWorn = worn;
    }
    public int getAttack() {
        return attack;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Boolean getIsWorn(){
        return isWorn;
    }
}
