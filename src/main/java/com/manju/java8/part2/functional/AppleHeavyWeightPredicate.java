package com.manju.java8.part2.functional;

import com.manju.java8.part2.model.Apple;

public class AppleHeavyWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}