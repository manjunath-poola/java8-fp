package com.manju.java8.generics.types;

import java.util.ArrayList;
import java.util.List;

class BirdManager {
    static class Bird {
    }

    static class Sparrow extends Bird {
    }


    public static void main(String[] args) {
        List<? extends Bird> birds = new ArrayList<Bird>();
//        birds.add(new Sparrow()); // DOES NOT COMPILE
//        birds.add(new Bird()); // DOES NOT COMPILE
    }
}