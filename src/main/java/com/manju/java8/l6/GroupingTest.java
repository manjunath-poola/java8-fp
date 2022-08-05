package com.manju.java8.l6;

import com.manju.java8.l4.model.Dish;
import com.manju.java8.l4.model.Type;
import com.manju.java8.l6.model.Transaction;

import static java.util.stream.Collectors.*;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;

public class GroupingTest {
    public static void main(String[] args) {
//        List<Transaction> transactions = new ArrayList<>();
//
//        Map<Currency, List<Transaction>> transactionsByCurrencies =
//                transactions.stream().collect(groupingBy(Transaction::getCurrency));

        List<Dish> menu = asList(
                new Dish("pork", false, 800, Type.MEAT),
                new Dish("beef", false, 700, Type.MEAT),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("french fries", true, 530, Type.OTHER),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("season fruit", true, 120, Type.OTHER),
                new Dish("pizza", true, 550, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("salmon", false, 450, Type.FISH));
        //find count
        long count = menu.stream()
                         .collect(counting());
        long howManyDishes = menu.stream()
                                 .count();

        //find max and min value
//        max calories dish
//        Optional<Dish> maxCalDish = menu.stream()
//                                        .max((l, r) -> l.getCalories() - r.getCalories());
//        System.out.println(maxCalDish);

        //by using Collectors
//        Comparator<Dish> dishMaxComparator = Comparator.comparing(Dish::getCalories);
//        Optional<Dish> optionalDish = menu.stream()
//                                          .collect(maxBy(dishMaxComparator));
//        System.out.println(optionalDish);
//minBy
        Comparator<Dish> dishMaxComparator = Comparator.comparing(Dish::getCalories);
        Optional<Dish> optionalDish = menu.stream()
                                          .collect(minBy(dishMaxComparator));
        System.out.println(optionalDish);
    }
}
