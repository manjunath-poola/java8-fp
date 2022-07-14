package com.manju.java8.part2.functional;

import com.manju.java8.part2.model.Apple;
import com.manju.java8.part2.model.Color;

public class AppleGreenColorPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }
}