package com.manju.java8.l2.manager;

import com.manju.java8.l2.model.Apple;
import com.manju.java8.l2.model.Color;
import com.manju.java8.l2.service.AppleService;

import java.util.ArrayList;
import java.util.List;

public class AppleManagerFinalGen {
    public static void main(String[] args) {
        AppleService service = new AppleService();

        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(Color.GREEN, 120));
        inventory.add(new Apple(Color.GREEN, 150));
        inventory.add(new Apple(Color.GREEN, 180));
        inventory.add(new Apple(Color.GREEN, 100));
        System.out.println("Green Color Apples : " + service.filterApples(inventory, apple -> Color.GREEN.equals(apple.getColor())));
        System.out.println("Heavy Apples : " + service.filterApples(inventory, apple -> 150 < apple.getWeight()));
    }
}
