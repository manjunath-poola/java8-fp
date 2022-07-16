package com.manju.java8.l3;

import java.util.function.Function;

public class FunctionTest {
    static int count=0;//static can be used in lambda's
    public static void main(String[] args) {
//        Object o = () -> { System.out.println("Tricky example"); };
        Runnable o = () -> { System.out.println("Tricky example"); };
        int portNumber = 1337; // if local variable wants use then it should be a final
        Runnable r = () -> System.out.println(portNumber);


    }
}
