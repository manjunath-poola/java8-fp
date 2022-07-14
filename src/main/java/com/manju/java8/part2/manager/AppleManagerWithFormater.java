package com.manju.java8.part2.manager;

import com.manju.java8.part2.functional.AppleFancyFormatter;
import com.manju.java8.part2.functional.AppleSimpleFormatter;
import com.manju.java8.part2.model.Apple;
import com.manju.java8.part2.model.Color;
import com.manju.java8.part2.service.AppleService;

import java.util.ArrayList;
import java.util.List;

public class AppleManagerWithFormater {
    public static void main(String[] args) {
        AppleService service = new AppleService();

        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(Color.GREEN, 120));
        inventory.add(new Apple(Color.GREEN, 150));
        inventory.add(new Apple(Color.GREEN, 180));
        inventory.add(new Apple(Color.GREEN, 100));
        service.prettyPrintApple(inventory, new AppleFancyFormatter());
        service.prettyPrintApple(inventory, new AppleSimpleFormatter());

    }
}
