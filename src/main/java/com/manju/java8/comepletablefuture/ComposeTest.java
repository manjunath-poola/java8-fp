package com.manju.java8.comepletablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class ComposeTest {
    public static void main(String[] args) {
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        numbers.stream()
////               .map(e -> fun1(e))  //fun1 is a 1-1 mapping
//               .flatMap(e -> fun2(e))//fun1 is a 1-many mapping
//               .forEach(System.out::println);
        // first name is 1-1 of a person but emails is 1-many

//        map 1-1 Stream<T> ====> Stream<Y>
//        map 1-many Stream<T> ====> Stream<List<Y>>
//        flatMap 1-many Stream<T> ====> Stream<Y> ??

//        function returns data -- map
//        function returns Stream --flatMap
// **
//        function return data -- thenAccept/thenApply
//        function returns Stream -- thenCompose
//        create(2).thenApply(data -> inc(data))
//                 .thenAccept(result -> System.out.println(result)); //==> java.util.concurrent.CompletableFuture@38af3868[Completed normally]

        create(2).thenCompose(data -> inc(data))
//                .thenApply(data -> inc(data))
                 .thenAccept(result -> System.out.println(result));
    }

    private static CompletableFuture<Integer> create(int i) {
        return CompletableFuture.supplyAsync(() -> i);
    }

    private static CompletableFuture<Integer> inc(int i) {
        return CompletableFuture.supplyAsync(() -> i + 1);
    }
//    private static int fun1(Integer e) {
//        return e * 2;
//    }
//
//    private static Stream<Integer> fun2(Integer e) {
//        return  Stream.of(new Integer[]{e - 1, e - 2});
//    }

}
