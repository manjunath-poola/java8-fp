package com.manju.java8.generics;

import java.util.ArrayList;
import java.util.List;

public class LegacyAutoboxing {
    public static void main(String[] args) {
//        java.util.List numbers = new java.util.ArrayList();
//        numbers.add(5);
//        int result = numbers.get(0); // DOES NOT COMPILE
        List<?> l3 = new ArrayList<String>();
        List<? extends Exception> l1 = new ArrayList<RuntimeException>();
        List<? super Exception> l2 = new ArrayList<Object>();

        List<String> keywords = new ArrayList<>();
        keywords.add("java");
//        printList(keywords); // DOES NOT COMPILE

        List<Integer> numbers = new ArrayList<>();
        numbers.add(new Integer(42));
//        List<Object> objects = numbers; // DOES NOT COMPILE
//        objects.add("forty two");
        System.out.println(numbers.get(1));
//        List<Object> l11 = new ArrayList<String>();  // does not compile

        Integer[] numbers1 = {Integer.valueOf(42)};
        Object[] objects = numbers1;
        objects[0] = "forty two";
    }

    public static void printList(List<Object> list) {
        for (Object x : list) System.out.println(x);
    }
}