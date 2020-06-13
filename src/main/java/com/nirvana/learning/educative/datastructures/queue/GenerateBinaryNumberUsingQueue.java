package com.nirvana.learning.educative.datastructures.queue;

public class GenerateBinaryNumberUsingQueue {
    public static void main(String[] args) {
        String[] output = findBin(5);
        for (int i = 0; i < output.length; i++)
            System.out.print(output[i] + " ");
        System.out.println();
    }

    //1.Start with Enqueuing 1.
    //2.Dequeue a number from queue and append 0 to it and enqueue it back to queue.
    //3.Perform step 2 but with appending 1 to the origional number and enqueue back to queue.
    //Size of Queue should be 1 more than number because for a single number we're enqueing two
    public static String[] findBin(int number) {
        String[] result = new String[number];
        Queue<String> queue = new Queue<>(number + 1);

        queue.enqueue("1");

        for (int i = 0; i < number; i++) {
            result[i] = queue.dequeue();
            String s1 = result[i] + "0";
            String s2 = result[i] + "1";
            queue.enqueue(s1);
            queue.enqueue(s2);
        }

        return result; //For number = 3 , result = {"1","10","11"};
    }
}
