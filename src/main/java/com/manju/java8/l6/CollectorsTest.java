package com.manju.java8.l6;

import com.manju.java8.l4.model.Dish;
import com.manju.java8.l4.model.Type;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

enum CaloricLevel {DIET, NORMAL, FAT}

public class CollectorsTest {
    public static void main(String[] args) {
        List<Dish> menu = asList(
                new Dish("pork", false, 800, Type.MEAT),
                new Dish("beef", false, 700, Type.MEAT),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("french fries", true, 530, Type.OTHER),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("season fruit", true, 120, Type.OTHER),
                new Dish("pizza", true, 550, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("salmon", false, 450, Type.FISH));

//        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
//        Optional<Dish> mostCalorieDish = menu.stream()
//                                             .collect(maxBy(dishCaloriesComparator));
//        System.out.println(mostCalorieDish);
//        double avgCalories =
//                menu.stream()
//                    .collect(averagingInt(Dish::getCalories));
//        System.out.println(avgCalories);


        /*
                an accumulator starting from an initial value (in this case the value is 0).
                The Collectors.summingLong and Collectors.summingDouble methods behave
                exactly the same way and can be used where the field to be summed is respectively a
                long or a double.

                A Collectors.averaging-Int, together with its averagingLong and averagingDouble counterparts, is also available
                to calculate the average of the same set of numeric values:
         */

//        IntSummaryStatistics menuStatistics =
//                menu.stream()
//                    .collect(summarizingInt(Dish::getCalories));
//        System.out.println(menuStatistics);

        /*
            usual, there are corresponding summarizingLong and summarizingDouble factory
            methods with associated types LongSummaryStatistics and DoubleSummary-
            Statistics. These are used when the property to be collected is a primitive-type long
            or a double.
         */
//        String shortMenu = menu.stream()
//                               .map(Dish::getName)
//                               .collect(joining());
//        System.out.println(shortMenu);
//        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
//                                                                 .collect(
//                                                                         groupingBy(dish -> {
//                                                                             if (getCalories() <= 400)
//                                                                                 return CaloricLevel.DIET;
//                                                                             else if (getCalories() <= 700)
//                                                                                 return CaloricLevel.NORMAL;
//                                                                             else return CaloricLevel.FAT;
//                                                                         }));
//        System.out.println(dishesByCaloricLevel);

/*
        let’s say the ones with more than 500 calories. You may argue that
        in this case you could apply this filtering predicate before the grouping like the
        following:
 */
//        Map<Type, List<Dish>> caloricDishesByType =
//                menu.stream()
//                    .filter(dish -> dish.getCalories() > 500)
//                    .collect(groupingBy(Dish::getType));
//        System.out.println(caloricDishesByType);
//
// {OTHER=[Dish(name=french fries, vegetarian=true, calories=530, type=OTHER), Dish(name=pizza, vegetarian=true, calories=550, type=OTHER)],
//MEAT=[Dish(name=pork, vegetarian=false, calories=800, type=MEAT), Dish(name=beef, vegetarian=false, calories=700, type=MEAT)]}
// with above approach we will mising of type FISH though it is catageroy

/*
    Collectors class overloads the groupingBy factory method, with one
variant also taking a second argument of type Collector along with the usual classification
function. In this way, it’s possible to move the filtering predicate inside this second
Collector, as follows:

 */

//        Map<Type, List<Dish>> caloricDishesByType =
//                menu.stream()
//                    .collect(groupingBy(Dish::getType,
//                                        filtering(dish -> dish.getCalories() > 500, toList())));
//        System.out.println(caloricDishesByType);
        //groups all types though there is no matches in that.
//        {
//            OTHER=[Dish(name=french fries, vegetarian=true, calories=530, type=OTHER), Dish(name=pizza, vegetarian=true, calories=550, type=OTHER)],
//            FISH=[],
//            MEAT=[Dish(name=pork, vegetarian=false, calories=800, type=MEAT), Dish(name=beef, vegetarian=false, calories=700, type=MEAT)]
//        }


//        Map<Type, List<String>> dishNamesByType =
//                menu.stream()
//                    .collect(groupingBy(Dish::getType,
//                                        mapping(Dish::getName, toList())));
//        System.out.println(dishNamesByType);


        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));

//        Map<Type, Set<String>> dishNamesByType =
//                menu.stream()
//                    .collect(groupingBy(Dish::getType,
//                                        flatMapping(dish -> dishTags.get(dish.getName())
//                                                                    .stream(),
//                                                    toSet())));
//
//        System.out.println(dishNamesByType);
//        Map<Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
//                menu.stream().collect(
//                        groupingBy(Dish::getType,
//                                   groupingBy(dish -> {
//                                       if (dish.getCalories() <= 400) return CaloricLevel.DIET;
//                                       else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
//                                       else return CaloricLevel.FAT;
//                                   } )
//                        )
//                );
//        System.out.println(dishesByTypeCaloricLevel);
/*
    {MEAT={ NORMAL=[Dish(name=beef, vegetarian=false, calories=700, type=MEAT)],
		DIET=[Dish(name=chicken, vegetarian=false, calories=400, type=MEAT)],
		FAT=[Dish(name=pork, vegetarian=false, calories=800, type=MEAT)]},
    OTHER={NORMAL=[Dish(name=french fries, vegetarian=true, calories=530, type=OTHER), Dish(name=pizza, vegetarian=true, calories=550, type=OTHER)],
	   DIET=[Dish(name=rice, vegetarian=true, calories=350, type=OTHER), Dish(name=season fruit, vegetarian=true, calories=120, type=OTHER)]},
    FISH={NORMAL=[Dish(name=salmon, vegetarian=false, calories=450, type=FISH)], DIET=[Dish(name=prawns, vegetarian=false, calories=300, type=FISH)]}}
 */

//        6.3.3 Collecting data in subgroups

//        Map<Type, Long> typesCount = menu.stream()
//                                         .collect(groupingBy(Dish::getType, counting()));
//        System.out.println(typesCount);

/*        highest-calorie dish in the menu to achieve a similar result, but now classified by
        the type of dish:
*/
//        Map<Type, Optional<Dish>> mostCaloricByType =
//                menu.stream()
//                    .collect(groupingBy(Dish::getType,
//                                        maxBy(comparingInt(Dish::getCalories))));
//        System.out.println(mostCaloricByType);

//        Listing 6.3 Finding the highest-calorie dish in each subgroup
//        Map<Type, Dish> mostCaloricByType =
//                menu.stream()
//                    .collect(groupingBy(Dish::getType,
//                                        collectingAndThen(
//                                                maxBy(comparingInt(Dish::getCalories)),
//                                                Optional::get)));
//        System.out.println(mostCaloricByType);

        Map<Type, Integer> totalCaloriesByType =
                menu.stream()
                    .collect(groupingBy(Dish::getType,
                                        summingInt(Dish::getCalories)));

        System.out.println(totalCaloriesByType);
    }
}


