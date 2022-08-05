package com.manju.java8.l5;

import com.manju.java8.l5.model.Trader;
import com.manju.java8.l5.model.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PracticeAll {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));
//        1 Find all transactions in the year 2011 and sort them by value (small to high).
//        List<Transaction> filteredTrancations = transactions.stream()
//                .filter(transaction -> 2011 == transaction.getYear())
//                .sorted(Comparator.comparing(Transaction::getValue))
//                .collect(Collectors.toList());
//        System.out.println(filteredTrancations);


//        2 What are all the unique cities where the traders work?
//        List<String> distinctTraders = transactions.stream()
//                .map(Transaction::getTrader)
//                .map(Trader::getCity)
//                .distinct()
//                .collect(Collectors.toList());
//        System.out.println(distinctTraders);

//        3 Find all traders from Cambridge and sort them by name.
//        List<Trader> traders = transactions.stream()
//                .filter(transaction -> "Cambridge".equalsIgnoreCase(transaction.getTrader().getCity()))
//                .distinct()
//                .map(Transaction::getTrader)
//                .sorted(comparing(Trader::getName))
//                .collect(toList());
//        System.out.println(traders);


//        4 Return a string of all traders’ names sorted alphabetically.
//        String tradersName =
//                transactions.stream()
//                        .map(transaction -> transaction.getTrader().getName())
//                        .distinct()
//                        .sorted()
//                        .reduce("", (n1, n2) -> n1 + n2);
//        System.out.println(tradersName);
//        String tradersName = transactions.stream()
//                .map(transaction -> transaction.getTrader().getName())
//                .distinct()
//                .sorted()
//                .collect(joining(","));
//        System.out.println(tradersName);

//        5 Are any traders based in Milan?
//        boolean isMilanBased = transactions.stream()
//                .anyMatch(transaction -> "Milan".equalsIgnoreCase(transaction.getTrader().getCity()));
//        System.out.println("Milan Based : "+isMilanBased);

//        6 Print the values of all transactions from the traders living in Cambridge.
//        transactions.stream()
//                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
//                .map(Transaction::getValue)
//                .forEach(System.out::println);

//        7 What’s the highest value of all the transactions?

//        Optional<Integer> maxVal = transactions.stream()
//                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
//                .max(comparing(Transaction::getValue))
//                .map(Transaction::getValue);
//        System.out.println(maxVal);

//        Optional<Integer> highestValue =
//                transactions.stream()
//                        .map(Transaction::getValue)
//                        .reduce(Integer::max);
//        System.out.println(highestValue);

//        8 Find the transaction with the smallest value.
//        Optional<Transaction> minValue =
//                transactions.stream()
//                        .reduce(Integer::min);

        Optional<Transaction> minValue =
                transactions.stream()
                        .reduce((t1, t2) ->
                                t1.getValue() < t2.getValue() ? t1 : t2);

        System.out.println(minValue);

    }
}
