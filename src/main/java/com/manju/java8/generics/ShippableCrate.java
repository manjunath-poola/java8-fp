package com.manju.java8.generics;

class ShippableCrate implements Shippable {
    public static <T> void sink(T t) {
    }

    public static <T> T identity(T t) {
        return t;
    }

    public void ship(Object t) {
    }
    //bad code public static T noGood(T t) { return t; }
}