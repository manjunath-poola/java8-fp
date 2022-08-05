package com.manju.java8.generics;

import com.manju.java8.generics.models.Robot;

class ShippableRobotCrate implements Shippable<Robot> {
    public void ship(Robot t) {
    }
}