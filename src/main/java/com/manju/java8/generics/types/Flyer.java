package com.manju.java8.generics.types;

import java.util.ArrayList;
import java.util.List;

interface Flyer {
    void fly();
}

class HangGlider implements Flyer {
    public void fly() {
    }
}

class Goose implements Flyer {
    public void fly() {
    }
}

class Manager {
    public static void main(String[] args) {
    }

    private void anyFlyer(List<Flyer> flyer) {
    }

    private void groupOfFlyers(List<? extends Flyer> flyer) {
    }
}