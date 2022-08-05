package com.manju.java8.l4;

import com.manju.java8.l4.model.Dish;
import com.manju.java8.l4.model.Type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class FilterAndMap {
    public static void main(String[] args) {
        List<Dish> menu = new ArrayList<>();
        menu.add(new Dish("Upma", true, 250, Type.OTHER));
        menu.add(new Dish("Dosa", true, 380, Type.OTHER));
        menu.add(new Dish("Idly", true, 350, Type.OTHER));
        menu.add(new Dish("Mutton", false, 480, Type.OTHER));
        menu.add(new Dish("Fish", false, 450, Type.OTHER));
        menu.add(new Dish("Checkin", false, 550, Type.OTHER));
        List<Dish> lowCaloricDishes = new ArrayList<>();
        //java 7 way
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        //sorting as java 7 way
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish dish1, Dish dish2) {
                return Integer.compare(dish1.getCalories(), dish2.getCalories());
            }
        });
        //collecting the names
        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }

        // java 8 comes here
        List<String> lowCaloricDishesName_8 = menu.stream().filter(d -> d.getCalories() < 400).sorted(comparing(Dish::getCalories)).map(Dish::getName).collect(toList());
//        Filtering

        List<Dish> vegetarianDishes = menu.stream().filter(Dish::isVegetarian).collect(toList());

    }
}
