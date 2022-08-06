import java.lang.reflect.Array;
import java.util.ArrayList;

public interface Inventory {
   // int maxWeight = 0;
    //holds all money
    int money = 0;
    //hold all inventory objects
    ArrayList<Object> inventory = new ArrayList<>();


    //return money
    default Integer getMoney (int money){
        return null;
    }

    //searches inventory of object and returns it
    default Object searchInventory(ArrayList<Object> inventory) {
        return null;
    }

    //searches inventory and removes object and returns inventory
    default ArrayList<Object> removeItem(ArrayList<Object> inventory, Object obj){
        return null;
    }
    //add item to inventory
    default ArrayList<Object> addItem(ArrayList<Object> inventory, Object obj){
        return null;
    }


}
