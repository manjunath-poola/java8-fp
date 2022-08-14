package com.manju.java8.comepletablefuture;

import java.util.concurrent.CompletableFuture;

public class CombineTest {
    public static void main(String[] args) {
        create(2).thenCombine(create(5), (r1, r2) -> r1 + r2)
                 .thenAccept(data -> System.out.println(data));
//        combine is zipping method to combine the future objects


    }

    private static CompletableFuture<Integer> create(int i) {
        return CompletableFuture.supplyAsync(() -> i);
    }
}
