package com.manju.java8.part2.functional;

import com.manju.java8.part2.model.Apple;

public class AppleSimpleFormatter implements AppleFormatter {
    public String accept(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}