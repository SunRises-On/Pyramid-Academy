package Items.Equipment.Basic;

import Items.Equipment.Armour;

public class BasicHelmet implements Armour {
    private String name;
    private String description;
    private int defense;
    private Boolean isWorn;
    public BasicHelmet(){
        this.name = "Basic Helmet";
        this.description = "Won't protect much.";
        this.defense = 1;
        this.isWorn = false;
    }
    public BasicHelmet(Boolean changeIsWorn){
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
