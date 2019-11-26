package com.nirvana.learning.collections;

/**
 * @author KrishnaV on 05/11/19
 * @project Programming-Challenges
 */
public class Product {
    private String item;
    private Integer weight;

    public Product(String item, Integer weight) {
        this.item = item;
        this.weight = weight;
    }

    public String getItem() {
        return item;
    }


    public Integer getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Product{" +
                "item='" + item + '\'' +
                ", weight=" + weight +
                '}';
    }
}
