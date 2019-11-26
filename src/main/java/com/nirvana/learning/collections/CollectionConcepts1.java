package com.nirvana.learning.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author KrishnaV on 05/11/19
 * @project Programming-Challenges
 */
public class CollectionConcepts1 {
    public static void main(String[] args) {
        Product door = new Product("Wooden Door", 35);
        Product floorPanel = new Product("Floor Panel", 25);
        Product window = new Product("Glass Window", 10);

        Collection<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);
        final Iterator<Product> productIterator = products.iterator();
        while (productIterator.hasNext()){
            Product product = productIterator.next();
            System.out.println(product);
        }
    }
}
