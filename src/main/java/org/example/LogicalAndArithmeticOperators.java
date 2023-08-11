package org.example;

public class LogicalAndArithmeticOperators {

    public static void main (String[] args) {


        int a = 2;
        int b = 8;
        int c = 64;
        int y = 9;

        int result1;
        int result2;
        int result3;
        int result4;
        int result5;

        result1 = a + b;
        result2 = c - b;
        result3 = a * b;
        result4 = c / b;
        result5 = c % y;

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);

        System.out.println(y % 2 == 0);
        System.out.println(y % 2 == 1);



        int x = a + b;
        int k = (x - 9) * 5;

        System.out.println(k);



        System.out.println(c > b);
        System.out.println(a < y);
        System.out.println(a == b);
        System.out.println(y >= b);
        System.out.println(c <= y);
        System.out.println(a != c);



        int boxVolume;
        int n = 5;
        int m = 6;
        int l = 7;

        boxVolume = n*m*l;

        System.out.println (boxVolume);



        int age = 100;
        //true    +   false  = false
        if (age > 4 && age < 99) {

            System.out.println("You can use lego");

        }
        else {

            System.out.println("You can`t use lego");

        }


        int volvo1 = 951;
        int volvo2 = 952;
        int volvo3 = 953;
        int volvo4 = 954;
        //  false     +      true   = true
        System.out.println(volvo1 > volvo2 || volvo3 < volvo4);
        //   false     +      false   = false
        System.out.println(volvo2 > volvo3 || volvo3 == volvo4);
        //   true     +       true   = true
        System.out.println(volvo1 != volvo2 || volvo3 < volvo4);
        System.out.println(!(volvo1 != volvo2) || volvo3 < volvo4);










    }




}
