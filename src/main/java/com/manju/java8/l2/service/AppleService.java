package com.manju.java8.l2.service;

import com.manju.java8.l2.functional.AppleFormatter;
import com.manju.java8.l2.functional.ApplePredicate;
import com.manju.java8.l2.model.Apple;
import com.manju.java8.l2.model.Color;

import java.util.ArrayList;
import java.util.List;

public class AppleService {

    // when users wants filter only color
    public List<Apple> filterApples(List<Apple> apples, String color) {
        List<Apple> filtered = new ArrayList<>();
        for (Apple apple : apples) {
            if (color.equals(apple.getColor())) {
                filtered.add(apple);
            }
        }
        return apples;
    }

    // when users wants filter only weight
    public List<Apple> filterApples(List<Apple> apples, double weight) {
        List<Apple> filtered = new ArrayList<>();
        for (Apple apple : apples) {
            if (weight < apple.getWeight()) {
                filtered.add(apple);
            }
        }
        return apples;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }
    // both the methods only difference is if condition, can we use the behaviour as parameter ?? yes we can by using the behaviour.

    //with new version of filters
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory,
                                        AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }
}
