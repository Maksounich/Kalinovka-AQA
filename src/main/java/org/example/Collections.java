package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Collections {

    public static void main (String[] args) {

        List<String> animals = Arrays.asList("cat", "dog");

        List<String> filteredAnimal = animals.stream()
                .filter(animal -> animal.endsWith("c"))
                .collect(Collectors.toList());

        System.out.println(filteredAnimal);





        List<Integer> number = new ArrayList<>();

        number.add(1);
        number.add(2);
        number.add(4);
        number.add(3);

        Optional<Integer> minNumber = number.stream()
                .min(Integer::compareTo);

        System.out.println(minNumber);


//        Optional<Integer> maxNumber = number.stream()
//                .max(Integer::compareTo);
//
//        System.out.println(maxNumber);
//
//        List<Integer> filteredNumber = number.stream()
//                .sorted()
//                .collect(Collectors.toList());
//
//        System.out.println(filteredNumber);





        List<Object> shakeItOff = new ArrayList<>();

        shakeItOff.add(1);
        shakeItOff.add("Shake it off");
        shakeItOff.add(true);
        shakeItOff.add(23.5648);
        shakeItOff.add(true);

        List<Object> filteredShakeItOff = shakeItOff.stream()
                .distinct()
                .collect(Collectors.toList());


        System.out.println(filteredShakeItOff);




        List<String> color = new LinkedList<>();

        color.add("red");
        color.add("blue");
        color.add("purple");
        color.add("yellow");

        color.stream()
                .forEach(System.out::println);



//
//        Set <String> season = new HashSet <>();
//
//        season.add("winter");
//        season.add("spring");
//        season.add("summer");
//        season.add("autumn");
//
//        System.out.println(season);
//
//
//
        Set <String> drinks = new LinkedHashSet <>();

        drinks.add("sprite");
        drinks.add("coca-cola");
        drinks.add("pepsi");
        drinks.add("fanta");
        drinks.add("fanta");


        System.out.println(drinks);

//
//        Set <String> cocaCola = new TreeSet <>();
//
//        cocaCola.add("light");
//        cocaCola.add("zero");
//        cocaCola.add("normal");
//
//        for (String drink : cocaCola) {
//            System.out.println(drink);
//        }
//
//
//
//        Set <Integer> year = new TreeSet <>();
//
//        year.add(2018);
//        year.add(951);
//        year.add(347);
//        year.add(347);
//
//        System.out.println(year);
//
//


        Map <String, Integer> hello = new HashMap <>();

        hello.put("It`s me", 1);
        hello.put("I was wondering ", 2);
        hello.put("if after all these years you'd like to meet", 3);

        Map<Integer, List<String>> groupedByLength = hello.keySet().stream()
                .collect(Collectors.groupingBy(s -> s.length()));

        System.out.println(groupedByLength);


//
//        Map <String, Integer> bye = new LinkedHashMap <>();
//
//        bye.put("good", 1);
//        bye.put("not good", 3);
//        bye.put("bad", 2);
//
//        System.out.println(bye);
//
//
//
//        Map <Integer, String> numbers = new TreeMap<>();
//
//        numbers.put(1, "bad");
//        numbers.put(3, "not bad");
//        numbers.put(2, "very bad");
//
//        System.out.println(numbers);
//


        List<Integer> lala = new ArrayList<>();

        lala.add(1252);
        lala.add(2525);
        lala.add(42582);
        lala.add(33663);

        boolean anyLala = lala.stream()
 //               .anyMatch(n -> n % 2 == 0);
//                  .allMatch(n -> n % 2 == 0);
                .noneMatch(n -> n % 2 == 0);


        System.out.println(anyLala);



//Виведіть всі парні числа із цього списку
        List<Integer> chukas = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> filteredChukas = chukas.stream()
                .filter(chuka -> chuka % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(filteredChukas);



//Створіть новий список, де всі рядки перетворені на верхній регістр
        List<String> food = Arrays.asList("apple", "banana", "cherry");
        List <String> filteredFood = food.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(filteredFood);

//Виведіть всі НЕ парні числа із цього списку
        List<Integer> bumbas = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List <Integer> filteredBumbas = bumbas.stream()
                .filter(bumba -> bumba % 2 != 0)
                .collect(Collectors.toList());

        System.out.println(filteredBumbas);


//Пошук найдовшого рядка у списку
        List<String> likeIt = Arrays.asList("apple", "banana", "cherry bomb");
        Optional<String> filteredLikeIt = likeIt.stream()
                        .max((a,b) -> Integer.compare(a.length(), b.length()));



        System.out.println("Longest word: " + filteredLikeIt);




//Обчислення суми чисел зі списку

        List<Integer> numbs = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int numb = numbs.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum of all numbers from list: " + numb);


        List<Integer> nombs = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        OptionalDouble nomb = nombs.stream()
                .mapToInt(Integer::intValue)
                .average();


        System.out.println("Average value of  all numbers from list: " + nomb);



//        Пошук першого рядка, що починається на певну літеру

        List<String> words = Arrays.asList("apple", "banana", "cherry");

        List<String> filteredWord = words.stream()
                .filter(word -> word.startsWith("b"))
                .collect(Collectors.toList());

        System.out.println(filteredWord);



        List <String> olenka = Arrays.asList("");
        

    }

}
