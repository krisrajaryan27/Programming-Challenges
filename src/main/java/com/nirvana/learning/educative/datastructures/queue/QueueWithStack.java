package com.nirvana.learning.educative.datastructures.queue;


import com.nirvana.learning.educative.datastructures.stack.Stack;

public class QueueWithStack<V> {
    private int maxSize;
    private int front;
    private int rear;
    private Stack<V> stack1;
    private Stack<V> stack2;

    public QueueWithStack(int maxSize) {
        this.maxSize = maxSize;
        front = -1;
        rear = maxSize;
        stack1 = new Stack<>(maxSize);
        stack2 = new Stack<>(maxSize);
        // Write -- Your -- Code
    }

    //1. Making Enqueue Operation Costly -- O(n)
    public void enqueueM1(V value) {
        // Write -- Your -- Code
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        front++;
    }

    //1. Dequeue - O(1)
    public V dequeueM1() {
        // Write -- Your -- Code
        if (stack1.isEmpty()) {
            System.out.println("Queue is empty");
            System.exit(0);
        }
        return stack1.pop();
    }

    //2. Making Dequeue Costly i.e Enqueue - O(1)
    public void enqueueM2(V value) {
        stack1.push(value);
    }

    // Dequeue - Amortized O(1)
    public V dequeueM2() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        /* Move elements from stack1 to stack 2 only if
        stack2 is empty */
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


    public boolean isEmpty() {
        //Write -- Your -- Code
        return stack1.isEmpty();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
}
