package com.manju.java8.collectors;

import com.manju.java8.collectors.model.Gender;

import java.util.List;

import static java.util.List.of;

public class StreamTest {
    public static void main(String[] args) {
        // 1. filter
//        createPersons().stream()
//                       .filter(person -> person.getAge() > 30)
//                       .forEach(System.out::println);

        // 2. Map
//        createPersons().stream()
//                       .map(Person::getName)
//                       .forEach(System.out::println);
        // 3. reduce
//        createPersons().stream()
//                       .map(Person::getAge)
//                       .reduce(0, (total, age) -> total + age);
//                       .reduce(0, (total, age) -> Integer.sum(total, age));
//                       .reduce(0, Integer::sum);
        // reduce can return to collection as well

// OOP -- Polymorphsim
// FP -- Functional Composition + Lazy evaluation
// Pure function returns same value any no of times
// we call it with same input - idempotency

// 1. Pure function do not change anything
//// 2. Pure function do not depend on anything that may possibly change

        // should not use mutable code in the streams
//        Example  for `Wrong way, avoid the shared mutablity
//        List<String> names = new ArrayList<>();
//        createPersons().stream()
//                       .map(Person::getName)
//                       .reduce(0, (total, age) -> total + age);
//                       .reduce(0, (total, age) -> Integer.sum(total, age));
//                       .forEach(name -> names.add(name));
//        System.out.println(names); // [Manju, Ram, Raj, Mohan, Madhav, Roja, Ramani]
// here parallelStream will have problem with shared mutable object
//        createPersons().parallelStream()
//                       .map(Person::getName)
//                       .forEach(name -> names.add(name));
//        System.out.println(names); //[Madhav,  Ramani, Roja, Manju, Ram, Raj]

//        ArrayList<String> namesOfOlderThan30 = createPersons().stream()
//                                                              .filter(person -> person.getAge() > 30)
//                                                              .map(Person::getName)
//                                                              .map(String::toUpperCase)
//                                                              .reduce(
//                                                                      new ArrayList<String>(),
//                                                                      (names3, name) -> {
//                                                                          names3.add(name);
//                                                                          return names3;
//                                                                      },
//                                                                      (names1, names2) -> {
//                                                                          names1.addAll(names2);
//                                                                          return names1;
//                                                                      }
//                                                              );
//        System.out.println(namesOfOlderThan30);

//        List<String> namesOfOlderThan30 = createPersons().stream()
//                                                         .filter(person -> person.getAge() > 30)
//                                                         .map(Person::getName)
//                                                         .map(String::toUpperCase)
//                                                         .collect(Collectors.toList());
//        System.out.println(namesOfOlderThan30);

// collect is a reduce operations


    }

    private static List<Person> createPersons() {
        return of(new Person("Manju", 37, Gender.MALE),
                  new Person("Ram", 40, Gender.MALE),
                  new Person("Raj", 8, Gender.MALE),
                  new Person("Mohan", 23, Gender.MALE),
                  new Person("Mohan", 40, Gender.MALE),
                  new Person("Madhav", 29, Gender.MALE),
                  new Person("Madhav", 41, Gender.MALE),
                  new Person("Roja", 32, Gender.FEMALE),
                  new Person("Ramani", 12, Gender.FEMALE));
    }
}
