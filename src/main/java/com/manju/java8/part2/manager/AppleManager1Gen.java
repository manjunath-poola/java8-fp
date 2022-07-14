package com.manju.java8.part2.manager;

import com.manju.java8.part2.model.Apple;
import com.manju.java8.part2.service.AppleService;
import com.manju.java8.part2.model.Color;

import java.util.ArrayList;
import java.util.List;

public class AppleManager1Gen {
    public static void main(String[] args) {
        AppleService service = new AppleService();

        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(Color.GREEN, 120));
        inventory.add(new Apple(Color.GREEN, 150));
        inventory.add(new Apple(Color.GREEN, 180));
        inventory.add(new Apple(Color.GREEN, 100));
        List<Apple> greenApples = service.filterApples(inventory, Color.GREEN, 0, true);
        List<Apple> heavyApples = service.filterApples(inventory, null, 150, false);
        System.out.println(greenApples);
        System.out.println(heavyApples);
    }
}
