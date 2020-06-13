package com.nirvana.learning.educative.datastructures.queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(5);
        System.out.print("You have successfully created a Queue!");

        if (queue.isEmpty())
            System.out.print("Queue is empty.");
        else
            System.out.print("Queue is not empty.");

        System.out.printf("%n");

        if (queue.isFull())
            System.out.print("Queue is full.");
        else
            System.out.print("Queue is not full.");

        //equeue 2 4 6 8 10 at the end
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(6);
        queue.enqueue(8);
        queue.enqueue(10);
        //dequeue 2 elements from the start
        queue.dequeue();
        queue.dequeue();
        //enqueue 12 and 14 at the end
        queue.enqueue(12);
        queue.enqueue(14);

        System.out.println("Queue:");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}
