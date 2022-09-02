package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Student {
        private int id;
        private String name;
        @Autowired
        private List<Phone> ph;
        @Autowired
        private Address add;

        @Autowired
        public Student(int id, String name, List<Phone> ph, Address add){
            this.id = id;
            this.name = name;
            this.ph = ph;
            this.add = add;
        }

        public void rollCall(){
            System.out.println("I'm doing roll call.");
            System.out.println("Student = " + name + " ID = " + id
            + " Phones = " + ph + " " +add );
        }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ph=" + ph +
                ", add=" + add +
                '}';
    }
}
