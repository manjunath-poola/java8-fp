 package com.manju.java8.comepletablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest {

    public static CompletableFuture<Integer> create() {
        return CompletableFuture.supplyAsync(() -> compute());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Futures -- Callable will return a Future object, when we invoke future.get() will make that block
        // Javascript used a callbacks for Async callbacks, but these are lacks the consistency. errors vs data which comes first.
        // for getting data you will be calling callback-->callback-->callback which makes you callback hell :(
        //  Javascript moved to Promises resolve,reject or be pending

//        Stream  -- has a dataflow, what is something goes wrong ? good luck :( no way to resolve
//    **  Promises has two channels to handle this will be 0 or 1 data.
//                              data    --------->
//                              error   --------->  (treat error as another form of data)
//                              errors are first class citizens
//            -----f-------f----------f------------------------------------------------------
//                          \        /
//            ----------------f-----f--------------------------------------------------------
//        reactive channels does the same, but it will be having 3 channels stream of data, 0-many data

//        Java has Promises -- which is CompletableFuture,
//         CompletableFuture has Stages
//          one stage completes and another stage may run

// Famous or popular functional interfaces
//        Supplier<T>  T get()  -- never takes anything always returns (mother love) -- factories
//        Predicate<T> boolean test(T); -- used in filter
//        Function<T,R> R apply(T)   -- used in map
//        Consumer<T> void accept(T), takes and data it wnot return -- forEach

//        ? why these are here, because it relates in CompletableFuture
// Promises deals with 0 or 1
//        CompletableFuture<Integer> future = create();
//        CompletableFuture<Void> voidCompletableFuture = future.thenAccept(data -> System.out.println(data));
        // since it returns void we can not use the again thenAccept
//        voidCompletableFuture.thenRun(() -> {
//                                 System.out.println("Never dies");
//                             })
//                             .thenRun(() -> {
//                                 System.out.println("Never dies...1");
//                             })
//                             .thenRun(() -> {
//                                 System.out.println("Never dies...2");
//                             })
//                             .thenRun(() -> {
//                                 System.out.println("Never dies...3");
//                             })
//                             .thenRun(() -> {
//                                 System.out.println("Never dies...4");
//                             });


        //thannable -- then means after finishing accept the result
        //  thenAccept returns CompletableFuture
//        System.out.println("Got it...!!");
//        System.out.println(create().get());//bad idea, do not use this
//        System.out.println(create().getNow(0));//bad idea, do not use this
//        System.out.println("here....!!");
//        create().thenAccept(data -> printIt(data));

//        System.out.println("Main : " + Thread.currentThread());
//        CompletableFuture<Integer> future = create();
//        sleep(100);
//        future.thenAccept(data -> printIt(data));
//        System.out.println("Here...");

//        create().thenAccept(data -> System.out.println(data)) // step 1 data writing db or network call
//                .thenRun(() -> System.out.println("Went well...!!!"));

//Stream                    CompletableFuture
// pipeline                 pipeline
// lazy                     lazy
// 0,1 or more data         0 or 1
// only data channel       data channel and error channel
// forEach                 thenAccept
// map                     thenApply
//exceptions oops          error channel

//        create().thenApply(data -> data * 10)
//                .thenAccept(data -> System.out.println(data)) // step 1 data writing db or network call
//                .thenRun(() -> System.out.println("Went well...!!!"));

//        CompletableFuture<Integer> future =
//                new CompletableFuture<Integer>();

//        future
//                .thenApply(data -> data * 2)
//                .thenApply(data -> data + 1)
//                .thenAccept(data -> System.out.println(data));
//        System.out.println("Built the pipeline...");
//        sleep(1000);
//        future.complete(2);
//        sleep(1000);

// Exceptions handling
//        build().thenApply(data -> data * 2)
//               .exceptionally(throwable -> handle1(throwable))
//               .thenAccept(data -> System.out.println(data))
//               .exceptionally(throwable -> handle(throwable));
//        (return)..(blowup)                             (return)
//        ---f----f--f                        ------------f-----------  thens
//                    \                     / return
//                     --------f----f-----f                         exceptional
//                             blowup

//        build().thenApply(data -> data * 2)
//               .exceptionally(throwable -> handle2(throwable))
//               .thenAccept(data -> System.out.println(data))
//               .exceptionally(throwable -> handle(throwable));

        ///complete Exceptionally -- will make you call the catch execution makes go through.
//        CompletableFuture<Integer> future = new CompletableFuture<>();
//        future.thenApply(data -> data * 2)
//              .exceptionally(throwable -> handle2(throwable))
//              .thenApply(data -> data + 1)
//              .thenAccept(data -> System.out.println(data));
//        System.out.println("Built the pipeline...");
//        sleep(1000);
////        future.complete(2);
//        future.completeExceptionally(new RuntimeException("do not tell the boss"));
//        sleep(1000);
// ** CompletableFuture States
// 1. Pending,
// 2. Resolved (final)
// 3. Rejected (final)
// ** how long CompletableFuture can be in Pending state. Both in life and programming never do something without timeout.
// Java-9 we have 2 methods 1. completeOnTimeout() 2.orTimeout

//        CompletableFuture<Integer> future = new CompletableFuture<>();
//        future.thenApply(data -> data * 2)
//              .exceptionally(throwable -> handle2(throwable))
//              .thenApply(data -> data + 1)
//              .thenAccept(data -> System.out.println(data));
//        System.out.println("Built the pipeline...");
//        sleep(1000);
//        future.complete(2);
//        future.completeOnTimeout(0, 2, TimeUnit.SECONDS);
//        future.orTimeout(2, TimeUnit.SECONDS);
//        sleep(1000);
//        future.complete(2);

// Javascript the(e==>func(e)), fun can return data or may return Promise
// if data is returned it is warpped into a promise.
//  if promise is returned then that is returned from then
//        Javascript deals with dynamic type but not Java
// combine vs compose

        System.out.println("<<< DONE >>>");

    }

    private static Integer handle2(Throwable throwable) {
        System.out.println("Got recovered Throwable : " + throwable);
        return 0;
    }

    private static Void handle(Throwable throwable) {
        System.out.println("Throwable : " + throwable);
        throw new RuntimeException("Beyond all hope...!!!!");
    }

    private static int handle1(Throwable throwable) {
        System.out.println("Throwable : " + throwable);
        return -1;
    }

    public static CompletableFuture<Integer> build() {
        return CompletableFuture.supplyAsync(() -> compute1());
    }

    private static void printIt(Integer data) {
        System.out.println(data + ", " + Thread.currentThread());
    }

    static int compute() {
//        System.out.println("Compute : " + Thread.currentThread());
//        sleep(1000);
        return 2;
    }

    static int computeNew() {
        throw new RuntimeException();
//        return 2;
    }

    static int compute1() {
//        throw new RuntimeException();
        return 2;
    }

    private static void sleep(int i) {
        try {
            Thread.currentThread()
                  .sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

