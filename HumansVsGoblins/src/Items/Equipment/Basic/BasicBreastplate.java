package Items.Equipment.Basic;

import Items.Equipment.Armour;

public class BasicBreastplate implements Armour {
    private String name;
    private String description;
    private int defense;
    private Boolean isWorn;
    public BasicBreastplate(){
        this.name = "Basic Breastplate";
        this.description = "Won't protect much.";
        this.defense =  3;
        this.isWorn = false;
    }
    public BasicBreastplate(Boolean changeIsWorn){
        this();
        this.isWorn = changeIsWorn;
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
