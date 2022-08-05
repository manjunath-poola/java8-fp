package com.manju.java8.generics.types;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SoundManager {
    public static void main(String[] args) {
//        List<String> strings = new ArrayList<String>();
//        strings.add("tweet");
//        List<Object> objects = new ArrayList<Object>(strings);
//        addSound(strings);
//        addSound(objects);

        List<? super IOException> exceptions = new ArrayList<Exception>();
//        exceptions.add(new Exception());
        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());


    }

//    public static void  addSound(List<?> list) {
//        list.forEach(System.out::println);
////        list.add("quack"); // since immutal we can not add anything here
//    }
//    public static void addSound(List<? extends Object> list)
//    {
//        for (Object o : list) {
//            System.out.println(o);
//        }
//        list.add("quack"); // since immutal we can not add anything here
//    }
//    public static void addSound(List<Object> list)
//    {
//        list.add("quack");
//    }
    public static void addSound(List<? super String> list) {
        list.add("quack");
    }
}
