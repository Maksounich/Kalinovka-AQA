package org.example;

import static org.example.StaticAndFinal.barbie;

public class Main {

    public static void main(String[] args) {
/*
        System.out.println("Tell me why");
        System.out.println("Ain't nothin' but a heartache");

        System.out.print("I believe i can fly");
        System.out.println(" i believe i can touch the sky");

        byte oneByte = 1;
        short twoByte = 2;
        int fourByte = 4;
        long eightByte = 8;

        float fourByteWithDot = 4.89f;
        double eightByteWithDot = 8.38;

        char oneByteCharter = 36;

        boolean OneByteFalseOrTreu = true;

        System.out.println (oneByte);
        System.out.println (twoByte);
        System.out.println (fourByte);
        System.out.println (eightByte);

        System.out.println (fourByteWithDot);
        System.out.println (eightByteWithDot);

        System.out.println (oneByteCharter);

        System.out.println (OneByteFalseOrTreu);


*/

        int j = StaticAndFinal.barbie (9, 6);
        System.out.println(j);

        //Метод не має модифікатор Static, тому неможливо визвати його без створення екземпляру
        // int m = StaticAndFinal.ken (5, 2);
        // System.out.println(m);

        int m = StaticAndFinal.ken (5, 2);
        System.out.println(m);

        // Неможливо змінити значення y, бо клас StaticAndFinal має модифікатор final
       // StaticAndFinal.y = 6;

    }
}

