package org.example;

import org.example.Main;

public class Person {

    int age;
    String name;


    public static void main(String[] args) {


        Person nelka = new Person();
        nelka.name = "Nelka";
        nelka.age = 28;

        Person max = new Person();
        max.name = "Max";
        max.age = 5;


        System.out.println(nelka.name);
        System.out.println(nelka.age);

        System.out.println(max.name);
        System.out.println(max.age);

    }


}
