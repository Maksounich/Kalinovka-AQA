package org.example;


import java.util.SimpleTimeZone;

public class Constructors {

    public static void main(String[] args) {
    Human human1 = new Human("Bob", 3);
    human1.say("Mike", 56);


    Box box1 = new Box();
    int result = box1.volume(10,2,3);
    System.out.println("The volume of this box is " + result);
    }


}



class Human {
    public String name;
    public int age;
//конструктор за замовченням
public Human (){
    System.out.println("hi from the first constructor, the empty one");
}
//якщо в параметри ввести строкові дані
public Human (String name){
    System.out.println("hi from the second constructor, the string one");
    this.name = name;
}


    public Human (String name, int age){
    System.out.println("hi from the third constructor. I`m " + name + " and i already have been alive for " + age + " years");
    this.name = name;
    this.age = age;
}

    public void say (String name, int age){
        System.out.println("My name is " + name + " and i am " + age);
    }


}


class Box {

    public int volume (int height, int width, int length){

    int volume = height * width * length;
    return volume;
    }


}