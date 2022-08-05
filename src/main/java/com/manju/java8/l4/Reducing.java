package com.manju.java8.l4;

import com.manju.java8.l4.model.Dish;
import com.manju.java8.l4.model.Type;

import java.util.*;
import java.util.stream.IntStream;

public class Reducing {
    public static void main(String[] args) {
//        1.Reduce

/*
    reduce takes two arguments:
         An initial value, here 0.
         A BinaryOperator<T> to combine two elements and produce a new value; here
        you use the lambda (a, b) -> a + b.
 */
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

//        IntStream numberStream = Arrays.stream(new int[]{1, 2, 3});
//        int sum = numberStream.reduce(0, (a, b) -> a + b);
//        System.out.println("Sum : " + sum);

//        overloaded variant of reduce
//        OptionalInt sum = numberStream.reduce((a, b) -> (a + b));
//      2.Maximum and minimum
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println("Max : " + max.get());

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println("Min : " + min.get());
    }
}
