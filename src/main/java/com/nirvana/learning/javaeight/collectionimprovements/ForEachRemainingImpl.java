package com.nirvana.learning.javaeight.collectionimprovements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForEachRemainingImpl {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Grapes");
        fruits.add("Orange");

        Iterator<String> iterator = fruits.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        iterator.forEachRemaining(fruit -> System.out.println(fruit));
    }
}
