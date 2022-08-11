package com.manju.java8.collectors;

import jdk.dynalink.Operation;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.List.*;
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
//        List<Person> persons = createPersons();
//        Map<String, Integer> countByName = persons.stream()
//                                                  .collect(groupingBy(Person::getName, collectingAndThen(counting(), Long::intValue)));
//        System.out.println(countByName);

        //reduce -- reduce,collect, sum
//        List<Person> persons = createPersons();
//        System.out.println(persons.stream()
//                                  .mapToInt(Person::getAge)
//                                  .sum());
//min
//        List<Person> persons = createPersons();
//                System.out.println(persons.stream()
//                                  .mapToInt(Person::getAge)
//                                  .min());

//        List<Person> persons = createPersons();
//        System.out.println(persons.stream()
//                                  .mapToInt(Person::getAge)
//                                  .max());
        // maxBy
//        List<Person> persons = createPersons();
//        System.out.println(persons.stream()
//                                  .collect(maxBy(Comparator.comparing(Person::getAge))));

        //minBy
//        List<Person> persons = createPersons();
//        System.out.println(persons.stream()
//                                  .collect(minBy(Comparator.comparing(Person::getAge))));

        //collect max age by name

//        List<Person> persons = createPersons();
//        String maxPersonName = persons.stream()
//                                      .collect(collectingAndThen(maxBy(Comparator.comparing(Person::getAge)), person -> person.map(Person::getName)
//        System.out.println(maxPersonName);

// filtering

//map vs mapping
        //map -- will be done by the stream
        //mapping will be done at reduce operation

// filtering -- also same as mapping -:( it is added in java 11

//        System.out.println(createPersons().stream()
//                                          .collect(groupingBy(Person::getAge, mapping(Person::getName,
//                                                                                      filtering(name -> name.length() > 4, toList())))));
// teeing
// goruping mapping (Function ,Collector)
// collectingAndThen(Collector,Function)
// teeing((Collector,Collector,Operation)
// Operation -- BiOperator

// flatMapping
//flatMap
        List<Integer> numbers = of(1, 2, 3);
//        1-1 function
//        numbers.stream()
//               .map(e -> e * 2)
//               .collect(toList());
        //Stream<T>.map(f11)==>Stream<R>
//        1-many function
//        System.out.println(
//                numbers.stream()
//                       .map(e -> List.of(e - 1, e + 2))
//                       .collect(toList()));
//  Stream<T>.map(f11)==>Stream<List<R>>
        //Stream<T>.??(f1n)==>Stream<R> what we want

//        numbers.stream()
//               .flatMap(e -> List.of(e - 1, e + 1)
//                                 .stream())
//               .collect(toList());

//        Stream
//                .map(Function<T,R>)==>Stream<R>
//        .flatMap(Function<T,Stream<R>>) ==>Stream<R>

//        1-1  Stream<T> to Stream<R> use map
//        1-many  Stream<T> to Stream<Collection<R>> use map
//        1-many  Stream<T> to Stream<R> use flatmap

        // flatMap during collect
//        System.out.println(createPersons().stream()
//                                          .map(Person::getName)
//                                          .flatMap(name -> Stream.of(name.split("")))
//                                          .collect(toList()));
//        System.out.println(createPersons().stream()
//                                          .collect(groupingBy(Person::getAge, mapping(Person::getName, toList()))));

//        System.out.println(createPersons().stream()
//                                          .collect(groupingBy(Person::getAge, mapping(person -> person.getName()
//                                                                                                      .split(""), toList()))));

//        System.out.println(createPersons().stream()
//                                          .collect(groupingBy(Person::getAge, flatMapping(person -> Stream.of(person.getName()
//                                                                                                                    .split("")), toList()))));


        System.out.println(createPersons().stream()
                                          .collect(groupingBy(Person::getAge,
                                                              mapping(person -> person.getName()
                                                                                      .toUpperCase(),
                                                                      flatMapping(name -> Stream.of(name.split("")), toList())))));

//reduce - sum,max,min,reduce,collect
//        collect(Collector) Collectors is util we can use toList better to use toUnmodifiableList, toUnmodifiableSet,toUnmodifiableMap
        //partitioningBy -- takes collection splits by two.
        //groupingBy
        //groupingBy(Function<T,R>)
        //groupingBy(Function,Collector)
        //mappingBy(Function,Collector)
        //collectingAndThen(Collector,Function)
        //teeing(Collector,Collector,Operator)
    }

    private static List<Person> createPersons() {
        return of(new Person("Manju", 37),
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
