package com.manju.java8.l5;

import com.manju.java8.l5.model.Dish;
import com.manju.java8.l5.model.Type;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreams {
    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("french fries", true, 530, Type.OTHER));

        int calories = menu.stream()
                           .map(Dish::getCalories)
                           .reduce(0, Integer::sum);
        //issue above is auto boxing and unboxing with Integer
        //below does not work since map return Stream and sum is applied only on Integer but not wrappers
//        int calories = menu.stream()
//                           .map(Dish::getCalories)
//                           .sum();
//        Primitive stream specializations IntStream, DoubleStream, and LongStream,
// 1.MAPPING TO A NUMERIC STREAM
//        OptionalInt maxCalories = menu.stream()
//                .mapToInt(Dish::getCalories)
//                .max();

//      2. CONVERTING BACK TO A STREAM OF OBJECTS

//        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
//        Stream<Integer> stream = intStream.boxed();

//        3.DEFAULT VALUES: OPTIONALINT

//        OptionalInt maxCalories = menu.stream()
//                                      .mapToInt(Dish::getCalories)
//                                      .max();
//        System.out.println(maxCalories);
//        int max = maxCalories.orElse(1);
//        System.out.println(max);

//        4. Numeric ranges
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                                         .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());

//        Stream.iterate(new int[]{0, 1},
//                        t -> new int[]{t[1],t[0] + t[1]})
//                .limit(10)
//                .map(t -> t[0])
//                .forEach(System.out::println);


    }
}
