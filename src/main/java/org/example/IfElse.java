package org.example;

import java.sql.SQLOutput;

public class IfElse {

    public static void main(String[] args) {

        int age = 21;

        if (age > 18){
            System.out.println("Don`t drink, old pig");
        } else if (age == 18){
            System.out.println("Hey, don`t drink, pig");
        } else {
            System.out.println("Especially don`t drink, small pig");
        }



        String song = "Am i your fire?";

        if (song != "true"){
            System.out.println("Tell me why???");
        }else{
            System.out.println("Thank you:)");
        }



    }

}
