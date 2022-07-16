package com.manju.java8.l2.manager;

import com.manju.java8.l2.functional.AppleGreenColorPredicate;
import com.manju.java8.l2.functional.AppleHeavyWeightPredicate;
import com.manju.java8.l2.model.Apple;
import com.manju.java8.l2.service.AppleService;
import com.manju.java8.l2.model.Color;

import java.util.ArrayList;
import java.util.List;

public class AppleManager2Gen {
    public static void main(String[] args) {
        AppleService service = new AppleService();

        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(Color.GREEN, 120));
        inventory.add(new Apple(Color.GREEN, 150));
        inventory.add(new Apple(Color.GREEN, 180));
        inventory.add(new Apple(Color.GREEN, 100));
        System.out.println("Green Color Apples : " + service.filterApples(inventory, new AppleGreenColorPredicate()));
        System.out.println("Heavy Apples : " + service.filterApples(inventory, new AppleHeavyWeightPredicate()));
    }
}
