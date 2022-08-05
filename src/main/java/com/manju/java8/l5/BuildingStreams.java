package com.manju.java8.l5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStreams {
    public static void main(String[] args) {

        // 1. Stream.Of
        Stream<String> stream = Stream.of("Modern ", "Java ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);
        // 2.Stream.ofNullable
        Stream<String> homeValueStream
                = Stream.ofNullable(System.getProperty("home"));
        // 3. Streams from Arrays
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        // 4. Streams from functions: creating infinite streams!
//        The Streams API provides two static methods to generate a stream from a function:
//        Stream.iterate and Stream.generate.These two operations let you create what we
//        call an infinite stream,
        Stream.iterate(0, n -> n + 2)
              .limit(10)
              .forEach(System.out::println);
//        5. Fibonaci series
        Stream.iterate(new int[]{0, 1},
                       t -> new int[]{t[1],t[0] + t[1]})
              .limit(10)
              .map(t -> t[0])
              .forEach(System.out::println);
//        How does it work? iterate needs a lambda to specify the successor element. In the
//        case of the tuple (3, 5) the successor is (5, 3+5) = (5, 8). The next one is (8, 5+8).
//        Can you see the pattern? Given a tuple, the successor is (t[1], t[0] + t[1]). This is
//        what the following lambda specifies: t -> new int[]{t[1],t[0] + t[1]}. By running
//        this code you’ll get the series (0, 1), (1, 1), (1, 2), (2, 3), (3, 5), (5, 8), (8, 13), (13,
//                21). . . . Note that if you wanted to print the normal Fibonacci series, you could use
//        a map to extract only the first element of each tuple:


//        The generate method will use the given supplier and repeatedly call the getAsInt
//                method

        IntSupplier fib = new IntSupplier(){
            private int previous = 0;
            private int current = 1;
            public int getAsInt(){
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);

    }
}
