package com.manju.java8.collectors;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class CollectorTest {
    public static void main(String[] args) {
//        System.out.println(createPersons().stream()
//                                          .filter(person -> person.getAge() > 30)
//                                          .collect(Collectors.toList()));
//        System.out.println(createPersons().stream()
//                                          .map(Person::getName)
//                                          .map(String::toUpperCase)
//                                          .collect(Collectors.toList()));

        //Map name as Key and age as value immperative
//        Map<String, Integer> nameAndAge = new HashMap<>();
//        List<Person> persons = createPersons();
//        for (Person person : persons) {
//            nameAndAge.put(person.getName(), person.getAge());
//        }


//        createPersons().stream()
//                       .map(Person::getName)
//                       .collect(Collectors.toMap(keyFunction,valueFunction));
//        Map<String, Integer> nameAndAge = createPersons().stream()
//                                                         .collect(Collectors.toMap(Person::getName, Person::getAge));
//        System.out.println(nameAndAge);

//        List<Person> ages = createPersons().stream()
//                                           .collect(Collectors.toList());
//        System.out.println(ages.getClass());
        // toUnmodifiableList, toUnmodifiableSet, toUnmodifiableMap
//        List<Person> ages = createPersons().stream()
//                                           .collect(Collectors.toUnmodifiableList());
//        System.out.println(ages.getClass());

        //get the names as comma separated.

//        String names = createPersons().stream()
//                                      .map(Person::getName)
//                                      .map(String::toUpperCase)
//                                      .collect(Collectors.joining(","));
//        System.out.println(names);

        //Collector<T,A,R>
//        A--  accumulator takes the data keeps
//        T -- is data
//        R -- return type

        // if you want to get the even aged and aoo aged persons

//        List<Person> evenAged = createPersons().stream()
//                                               .filter(person -> person.getAge() % 2 == 0)
//                                               .collect(Collectors.toList());
//        List<Person> oddAged = createPersons().stream()
//                                               .filter(person -> person.getAge() % 2 != 0)
//                                               .collect(Collectors.toList());

        //single iterator by paritioningBy
//        Map<Boolean, List<Person>> paritionedMap = createPersons().stream()
//                                                                  .filter(person -> person.getAge() % 2 != 0)
//                                                                  .collect(Collectors.partitioningBy(person -> person.getAge() % 2 == 0));
//        System.out.println(paritionedMap);

        // if multiple groups you want to do
//        Map<String, List<Person>> byName = new HashMap<>();
//        List<Person> persons = createPersons();
//        for (Person person : persons) {
//            List<Person> list = null;
//            if (byName.containsKey(person.getName())) {
//                list = byName.get(person.getName());
//            } else {
//                list = new ArrayList<>();
//                byName.put(person.getName(), list);
//            }
//            list.add(person);
//        }
//        System.out.println(byName);

//        List<Person> persons = createPersons();
//        Map<String, List<Person>> namesMap = persons.stream()
//                                                    .collect(Collectors.groupingBy(Person::getName));
//        System.out.println(namesMap);

//        grouping by creates a bucket

        // ageByName

        //groupping by is overloaded which takes another collector, groupping assumes you need a set
//        List<Person> persons = createPersons();
//        Map<String, List<Integer>> nameAgeMap = persons.stream()
//                                                       .collect(Collectors.groupingBy(Person::getName, Collectors.mapping(Person::getAge, Collectors.toList())));
//        // in this example we have 3 collector we have Collector(Function,Collector(Function,Collector))
//
//        System.out.println(nameAgeMap);

////count by Name
//        List<Person> persons = createPersons();
//        Map<String, Long> countByName = persons.stream()
//                                               .collect(groupingBy(Person::getName, counting()));
//        System.out.println(countByName);

        //count want to make Integer
        //groupingBy and mapping (Function, Collector)
        // collectingAndThen (Collector, Function)
        List<Person> persons = createPersons();
        Map<String, Integer> countByName = persons.stream()
                                                  .collect(groupingBy(Person::getName, collectingAndThen(counting(), Long::intValue)));
        System.out.println(countByName);

    }

    private static List<Person> createPersons() {
        return List.of(new Person("Manju", 37),
                       new Person("Ram", 40),
                       new Person("Raj", 8),
                       new Person("Mohan", 23),
                       new Person("Mohan", 40),
                       new Person("Madhav", 29),
                       new Person("Madhav", 41),
                       new Person("Roja", 30),
                       new Person("Ramani", 12));
    }
}
