package org.example;

import java.util.*;

public class Main implements Generics<Long, Boolean>{
    public static void main(String[] args) {
        //Terminal Operations:
        //collect()
        //count()
        //TODO: TEST max()
        //TODO: TEST anyMatch()
        //reduce()
        //TODO: TEST findAny()
        //TODO: TEST forEach()
        List<String> listOfString = new ArrayList<>();

        //Intermediate Operations
        //map()
        List<Integer> integerList =  Arrays.asList(1, 2, 4, 5, 6, 7);
        System.out.println("Map: "+ integerList.stream()
                .map(num -> num*3).toList());

        //filter()
        //sorted()
        System.out.println("Sorted : " + integerList.stream().filter(num -> num%2==0).
                sorted(Integer::compareTo)
                .toList());

        System.out.println("Reduce : "+ integerList.stream().filter(num -> num%2==0)
                .reduce(0, Integer::sum));
        //TODO: TEST limit()
        //TODO: TEST skip()
        //TODO: TEST peek()
        //TODO: TEST distinct()

        //flatMap()
        List<List<Integer>> listOfIntegerList =  Arrays.asList(
                Arrays.asList(1, 2, 4, 5, 6),
                Arrays.asList(3, 5, 6, 7, 5),
                Arrays.asList(6, 3, 6, 2));
        System.out.println("Nested arrayList before flatMap: "+ listOfIntegerList);
        System.out.println("flatmap element Count: "+ listOfIntegerList
                .stream().flatMap(Collection::stream)
                .count());

        //TODO: READ about method reference ::
        System.out.println("flatmap: "+ listOfIntegerList
                .stream().flatMap(Collection::stream)
                .toList());

        System.out.println("flatmap IntelliJ's method: "+ listOfIntegerList
                .stream().mapToLong(Collection::size)
                .sum());

        //Arrays.asList(), asList(T t) is a method from the Arrays class
        Arrays.asList(1, 3, 5, 5, 6, 5);


        //ArrayList<>() is a constructor from the Arrays class
        List<String> listString = new ArrayList<>();
    }

//    TODO: Create a phonebook(containing individual contact info i.e.
//     Phone number, email, address, telephone number with 2 search implementation
//     1. Search by name (returns the data of people with the same name)
//     2. Search by number(returns a specific person's data)
//     NOTE: Make your code DRY and employ proper space complexity

    // TODO: Read up on LinkedList

    @Override
    public Long save(Long aLong, Boolean aBoolean) {
        return null;
    }
}