package com.manju.java8.l5;

import java.util.List;
import java.util.Optional;

public class ReducingTest {
    public static void main(String[] args) {

//reduce takes two arguments:
//   An initial value, here 0.
//   A BinaryOperator<T> to combine two elements and produce a new value; here
//        you use the lambda (a, b) -> a + b.
        List<Integer> numbers = List.of(4, 2,3);
        int sum = numbers.stream()
                         .reduce(0, (a, b) -> a + b);
        System.out.println(sum);
        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(product);
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
    }
}
