package com.manju.java8.parallelAndAsync;

import com.manju.java8.collectors.model.Gender;
import com.manju.java8.collectors.Person;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.util.List.of;

public class ParallelTest {
    public static void main(String[] args) throws Exception {
        //imperative
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //  Martin Fowler : Collection Pipeline Pattern
        //  find the total of double of even numbers

//        int total = 0;
//        for (int e : numbers) {
//            if (e % 2 == 0) {
//                total += e * 2;
//            }
//        }
//        System.out.println("Total : " + total);
//        System.out.println(numbers.stream()
//                                  .filter(e -> e % 2 == 0)
//                                  .mapToInt(e -> e * 2)
//                                  .sum());

        // imperative style has accidental complexity
        // functional style is less complexity and supports parallelism
        // before java8 threads does synchronize and suffer model
        // parallel as a master switch

//        numbers.stream()
//               .map(e -> transform(e))
//               .forEach(System.out::println);

//        print(numbers);
        // imperative style the structure os sequential is very different from concurrent code

        //**  using stream both the structure is same.
//        print(numbers.parallelStream());

        // we solve one and create new :)
        // Java 1 Threads creates -- it is not a lightweight
        // Java 5 - creates ExecutorServices -- problem Pool induced deadlock
        // Workstealing -- fork join pool
        // Java7 - FJP
        // java8 uses FJP for parallel stream.
//        printOrder(numbers.parallelStream());

        // parallel and filter
//        numbers.parallelStream()
//               .filter(ParallelTest::check)
//               .forEachOrdered(e -> {
//               });

        //parallel and reduce
//        System.out.println(
//                numbers.stream()
//                       .reduce(0, (total, e) -> add(total, e)));
        //** parallel with reduce will not work

//        System.out.println(
//                numbers.parallelStream()
//                       .reduce(0, (total, e) -> add(total, e)));

//        System.out.println(
//                numbers.parallelStream()
//                       .reduce(30, (total, e) -> add(total, e)));
        //  reduce will not take initial value, it takes an identity value
        //  int+identity is 0  x+0 =0
        //  int*identity is 1 x*1 =1
        //  what we work with should be a monoid

        // ### Formula
// when we use parallel, how many threads we can use ?
// how many threads can i create ? is a bad question.

// How many threads should I create ?
// How much should food should I eat ? bad question

// Computation intensive vs. IO intensive
// Computation intensive ==> For Computation intensive  Threads <= no of cores.
// IO intensive ==> For IO intensive  Threads > no of cores. #T <=  (# of cores/(1-blocking factor))   where  0<= blocking factor<1
        // Default Size
//        System.out.println("Cores : " + Runtime.getRuntime()
//                                               .availableProcessors());
//        System.out.println("Default pool : " + ForkJoinPool.commonPool());
//o/p
//        Cores : 8
//        Default pool : java.util.concurrent.ForkJoinPool@7adf9f5f[Running, parallelism = 7, size = 0, active = 0, running = 0, steals = 0, tasks = 0, submissions = 0]
// in default pool is 7, becuase "main" thread is not considered here.
//        numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
//                                11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
//        numbers.parallelStream()
//               .map(e -> transform(e))
//               .forEach(e -> {
//               });

// how do you configure --  -Djava.util.concurrent.ForkJoinPool.common.paralleslism=100
        // for Computation intensive should not be created threads more than the cores

//        numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
//                                11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

//        process(numbers.stream()
//                       .map(e -> transform(e)));

//        process(numbers.parallelStream()
//                       .map(e -> transform(e)));

        // Does it mean always mean fast ?

//        System.out.println(
//                createPersons().stream()
//                               .filter(person -> person.getAge() > 30)
//                               .filter(person -> person.getGender() == Gender.FEMALE)
//                               .map(Person::getName)
//                               .findFirst()
//                               .orElse("no one found"));

//        System.out.println(
//                createPersons().parallelStream()
//                               .filter(person -> person.getAge() > 30)
//                               .filter(person -> person.getGender() == Gender.FEMALE)
//                               .map(Person::getName)
//                               .findFirst()// is always ordered
//                               .orElse("no one found"));

//        System.out.println(
//                createPersons().parallelStream()
//                               .filter(person -> person.getAge() > 30)
//                               .filter(person -> person.getGender() == Gender.FEMALE)
//                               .map(Person::getName)
//                               .findAny() // is not ordered
//                               .orElse("no one found"));

// parallel will waste more resources
        System.out.println(
                createPersons().stream()
                               .filter(person -> person.getAge() > 30)
                               .filter(person -> person.getGender() == Gender.FEMALE)
                               .map(Person::getName)
                               .findAny() // is not ordered
                               .orElse("no one found"));
    }

    private static void process(Stream<Integer> stream) throws Exception {
        ForkJoinPool pool = new ForkJoinPool(100);
        pool.submit(() -> stream.forEach(e -> {
        }));
        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);
    }

    private static Integer add(Integer a, Integer b) {
        int result = a + b;
        System.out.println("a=" + a + ", b=" + b + ", r=" + result + "," + Thread.currentThread());
        return result;
    }

    private static boolean check(int e) {
        System.out.println("c: " + e + "--" + Thread.currentThread());
        sleep(1000);
        return true;
    }

    private static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void print(List<Integer> numbers) {
        numbers.parallelStream()
               .map(e -> transform(e))
               .forEach(System.out::println);
    }

    private static void print(Stream<Integer> stream) {
        stream.parallel()
              .map(e -> transform(e))
              .forEach(System.out::println);
    }

    private static void printOrder(Stream<Integer> stream) {
        stream.parallel()
              .map(e -> transform(e))
              .forEachOrdered(System.out::println);
    }

    @SneakyThrows
    private static int transform(Integer e) {
        System.out.println(Thread.currentThread()
                                 .getName() + " : " + e);
        sleep(1000);
        return e * 1;
    }

    private static List<Person> createPersons() {
        return of(new Person("Manju", 37, Gender.MALE),
                  new Person("Ram", 40, Gender.MALE),
                  new Person("Raj", 8, Gender.MALE),
                  new Person("Mohan", 23, Gender.MALE),
                  new Person("Mohan", 40, Gender.MALE),
                  new Person("Madhav", 29, Gender.MALE),
                  new Person("Madhav", 41, Gender.MALE),
                  new Person("Roja", 50, Gender.FEMALE),
                  new Person("Ramani", 32, Gender.FEMALE));
    }
}
