package Items.Equipment.Basic;

import Items.Equipment.Armour;

public class BasicBoots implements Armour {
    private String name;
    private String description;
    private int defense;
    private Boolean isWorn;
    public BasicBoots(){
        this.name = "Basic Boots";
        this.description = "A pair of well worn boots.";
        this.defense = 1;
        this.isWorn = false;
    }
    public BasicBoots(Boolean changeIsWorn){
        this.isWorn = true;
    }

    public void setWorn(Boolean worn) {
        isWorn = worn;
    }

    public int getDefense() {
        return defense;
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
    public void setIsWorm( Boolean changeIsWorn){
        this.isWorn = changeIsWorn;
    }
}
