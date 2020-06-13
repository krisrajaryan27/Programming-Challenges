package com.nirvana.learning.educative.datastructures.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueImpl {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Krishna");
        queue.add("Pooja");
        queue.add("Rajat");
        queue.add("Shubham");
        System.out.println(queue.remove()); //Krishna
        System.out.println(queue.remove()); //Pooja
        System.out.println(queue.peek()); //Rajat
        System.out.println(queue.remove()); //Rajat


    }
}
