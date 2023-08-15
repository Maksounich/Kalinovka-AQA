package org.example;

public class Array {

    public static void main(String[] args) {
/*
        int [] numbers = new int [3];
        numbers [0] = 36;
        numbers [1] = 28;
        numbers [2] = 4;

        System.out.println(numbers [0]);
        System.out.println(numbers [1]);
        System.out.println(numbers [2]);



        int [] numbers = {5,6,8};

        numbers [1] = 57;

        System.out.println(numbers [0]);
        System.out.println(numbers [1]);
        System.out.println(numbers [2]);

*/

        String[] summer = {"june", "july", "august"};

        for (int i = 0; i < summer.length; i++) {

        System.out.println(summer[i]);

        }


        String[] spring = new String[3];
        spring [0] = "march";
        spring [1] = "april";
        spring [2] = "may";

        for (int month = 0; month < spring.length; month++) {

            System.out.println(spring[month]);

        }


    }


}