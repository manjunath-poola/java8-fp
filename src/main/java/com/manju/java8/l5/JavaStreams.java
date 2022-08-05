package com.manju.java8.l5;

import com.manju.java8.l5.model.Dish;
import com.manju.java8.l5.model.Type;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class JavaStreams {
    public static void main(String[] args) {
        List<Dish> menu = new ArrayList<>();
        menu.add(new Dish("Upma", true, 250, Type.OTHER));
        menu.add(new Dish("Dosa", true, 380, Type.OTHER));
        menu.add(new Dish("Idly", true, 350, Type.OTHER));
        menu.add(new Dish("Mutton", false, 480, Type.OTHER));
        menu.add(new Dish("Fish", false, 450, Type.OTHER));
        menu.add(new Dish("Checkin", false, 550, Type.OTHER));
        List<Dish> lowCaloricDishes = new ArrayList<>();

//      1.  Filtering

//        List<Dish> vegetarianDishes = menu.stream().filter(Dish::isVegetarian).collect(toList());
//        System.out.println(vegetarianDishes);

//     2. distinct
//        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
//        numbers.stream()
//                .filter(i -> i % 2 == 0)
//                .distinct()
//                .forEach(System.out::println);

//      3. TAKEWHILE  -- if list is sorted and slice the list you need this.

        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("chicken", false, 125, Type.MEAT),
                new Dish("french fries", true, 530, Type.OTHER));

//        List<Dish> filteredMenu
//                = specialMenu.stream()
//                .filter(dish -> dish.getCalories() < 320)
//                .collect(toList());


//        List<Dish> slicedMenu1
//                = specialMenu.stream()
//                .takeWhile(dish -> dish.getCalories() < 320)
//                .collect(toList());
//        System.out.println(slicedMenu1);
//        System.out.println("Take a while: "+slicedMenu1);
//        System.out.println("Take a while end ");

//        5. DROPWHILE
        /*
        The dropWhile operation is the complement of takeWhile. It throws away the elements
        at the start where the predicate is false. Once the predicate evaluates to true it
        stops and returns all the remaining elements, and it even works if there are an infinite
        number of remaining elements!
        */
        List<Dish> slicedMenu2
                = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(toList());
        System.out.println(slicedMenu2);

//        6. Truncating a stream  limit(m)

//        List<Dish> dishes = specialMenu
//                .stream()
//                .filter(dish -> dish.getCalories() > 300)
//                .limit(3)  //limits to size
//                .collect(toList());
//        System.out.println(dishes);

//        7. Skipping elements skip(n)
        /*
            Streams support the skip(n) method to return a stream that discards the first n elements.
            If the stream has fewer than n elements, an empty stream is returned. Note that limit(n) and skip(n) are complementary!
         */

//        8. Mapping
//        List<String> dishNames = menu.stream()
//                .map(Dish::getName)
//                .collect(toList());
//        System.out.println(dishNames);
//        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
//
//        List<Integer> wordLengths = words.stream()
//                .map(String::length)
//                .collect(toList());
//
//        System.out.println(wordLengths);

//        9. Flattening
        // Incorrect use of map to find unique characters from a list of words
        List<String> words = Arrays.asList("Hello", "World");
//        List<String[]> distinctChars = words.stream()
//                .map(word -> word.split(""))
//                .distinct()
//                .collect(toList());
//        System.out.println(distinctChars);

//        10. ATTEMPT USING MAP AND ARRAYS.STREAM

//        The current solution still doesn’t work! This is because you now end up with a list of
//        streams (more precisely, List<Stream<String>>).
//        String[] arrayOfWords = {"Goodbye", "World"};
//        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
//        List<Stream<String>> dictinstChars = words.stream()
//                .map(word -> word.split(""))
//                .map(Arrays::stream)
//                .distinct()
//                .collect(toList());
//        System.out.println(dictinstChars);

//        11. USING FLATMAP
        /*
            Using the flatMap method has the effect of mapping each array not with a stream but
            with the contents of that stream. flattened into a single stream

         */
//        List<String> uniqueCharacters =
//                words.stream()
//                        .map(word -> word.split(""))
//                        .flatMap(Arrays::stream)
//                        .distinct()
//                        .collect(toList());
//        System.out.println(uniqueCharacters);

/*
        Given two lists of numbers, how would you return all pairs of numbers? For example,
                given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4),
        (3, 3), (3, 4)]. For simplicity, you can represent a pair as an array with two elements.

//  */
//        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
//        List<Integer> numbers2 = Arrays.asList(3, 4);
//        List<int[]> pairs =
//                numbers1.stream()
//                        .flatMap(i -> numbers2.stream()
//                                .map(j -> new int[]{i, j})
//                        )
//                        .collect(toList());
//        System.out.println(pairs);

    }
}
