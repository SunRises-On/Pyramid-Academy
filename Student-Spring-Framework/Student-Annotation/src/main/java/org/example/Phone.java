package org.example;


import org.springframework.stereotype.Component;


public class Phone {
    private String mob;

    public Phone(String mob){
        this.mob = mob;
    }
    @Override
    public String toString(){
        return mob;
    }
}
