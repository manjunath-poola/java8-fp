package com.manju.java8.generics;

class ShippableAbstractCrate<T> implements Shippable<T> {
    public void ship(T t) {
    }
}