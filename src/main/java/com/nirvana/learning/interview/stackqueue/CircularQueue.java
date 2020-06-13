package com.nirvana.learning.interview.stackqueue;

public class CircularQueue<T> {

    private int QUEUE_LENGTH;
    private T[] data = null;
    private int top = -1;
    private int end = -1;

    public CircularQueue(int size) {
        this.QUEUE_LENGTH = size;
        data = (T[]) new Object[QUEUE_LENGTH];
    }

    public static void main(String[] args) {
        CircularQueue<Integer> circularQueue = new CircularQueue<Integer>(5);
        circularQueue.offer(1);
        circularQueue.offer(2);
        circularQueue.offer(3);
        System.out.println(circularQueue.poll());
        circularQueue.offer(4);
        circularQueue.offer(5);
        System.out.print(circularQueue.isFull());
        circularQueue.offer(6);
        System.out.print(circularQueue.isFull());

        while (!circularQueue.isEmpty()) {
            System.out.println(circularQueue.poll());
        }
    }

    public void offer(T t) {
        if (top == -1) {
            data[0] = t;
            top = 0;
            end = 0;
        } else if (top == (end + 1) % QUEUE_LENGTH) {
            throw new IllegalArgumentException();
        } else {
            end = (end + 1) % QUEUE_LENGTH;
            data[end] = t;
        }
    }

    public T top() {
        if (top == -1) {
            throw new IllegalArgumentException();
        } else {
            return data[top];
        }
    }

    public T poll() {
        if (top == -1) {
            throw new IllegalArgumentException();
        } else if (top == end) {
            T t = data[top];
            top = -1;
            end = -1;
            return t;
        } else {
            T t = data[top];
            top = (top + 1) % QUEUE_LENGTH;
            return t;
        }

    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == (end + 1) % QUEUE_LENGTH;
    }
}
