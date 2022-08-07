package Items.Equipment.Basic;

import Items.Equipment.Armour;

public class BasicBreastplate implements Armour {
    private String name;
    private String description;
    private int defense;
    private Boolean isWorn;
    BasicBreastplate(){
        this.name = "Basic Breastplate";
        this.description = "Won't protect much.";
        this.defense = 2;
        this.isWorn = false;
    }
    public BasicBreastplate(Boolean changeIsWorn){
        this.isWorn = true;
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