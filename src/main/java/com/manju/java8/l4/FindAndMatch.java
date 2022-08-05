package com.manju.java8.l4;

import com.manju.java8.l4.model.Dish;
import com.manju.java8.l4.model.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FindAndMatch {
    public static void main(String[] args) {
/*
    Another common data processing idiom is finding whether some elements in a set of
    data match a given property. The Streams API provides such facilities through the
    allMatch, anyMatch, noneMatch, findFirst, and findAny methods of a stream.
 */

        List<Dish> menu = new ArrayList<>();
        menu.add(new Dish("Upma", true, 250, Type.OTHER));
        menu.add(new Dish("Dosa", true, 380, Type.OTHER));
        menu.add(new Dish("Idly", true, 350, Type.OTHER));
        menu.add(new Dish("Mutton", false, 480, Type.OTHER));
        menu.add(new Dish("Fish", false, 450, Type.OTHER));
        menu.add(new Dish("Checkin", false, 550, Type.OTHER));

//        1. AnyMatch

//        if(menu.stream().anyMatch(Dish::isVegetarian)) {
//            System.out.println("The menu is (somewhat) vegetarian friendly!!");
//        }

//        2. allMatch
//        boolean isHealthy = menu.stream().allMatch(dish -> dish.getCalories() < 1000);
//        System.out.println("Is Healthy Menu : "+isHealthy);

//         3. NONEMATCH
//        boolean isHealthy = menu.stream().noneMatch(dish -> dish.getCalories() < 1000);
//        System.out.println("Is Non Healthy Menu : "+isHealthy);
//-------------------------------------------------------------------------------------------
//        short-circuiting findAny, findFirst
//-------------------------------------------------------------------------------------------
//        Optional<Dish> vegDish = menu.stream().filter(Dish::isVegetarian).findAny();
//        System.out.println(vegDish);
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(dish -> System.out.println(dish.getName()));


    }
}
