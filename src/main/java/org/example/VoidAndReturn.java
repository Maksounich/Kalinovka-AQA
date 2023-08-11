package org.example;

public class VoidAndReturn {

    public static void main(String[] args) {

        int suma = Suma(11, 26);
        System.out.println(suma);

        String tellMeWhy1 = Song1 ();
        System.out.println(tellMeWhy1);

        String tellMeWhy2 = Song2 ();
        System.out.println(tellMeWhy2);

        Nothing ();

    }

    public static int Suma(int a, int b) {

        int sumaAB = a + b;
        return sumaAB;


    }

    public static String Song1 ()
    {

        String tellMeWhy1 = "Am i your fire";
        return tellMeWhy1;

    }
    public static String Song2 ()
    {

        String tellMeWhy2 = "Your one desire";
        return tellMeWhy2;

    }

    public static void Nothing (){

        System.out.println("i believe i can fly");

    }



}








