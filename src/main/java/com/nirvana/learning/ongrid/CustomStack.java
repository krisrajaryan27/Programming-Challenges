package com.nirvana.learning.ongrid;

import java.util.ArrayList;
import java.util.List;

public class CustomStack {
    // Min - smallest element from stack
    // Push
    // Pop
    // Peek

    private List<Integer> list = new ArrayList<>();
    private List<Integer> minList = new ArrayList<>();
    private int data;
    private int count;
    private int min;

    public CustomStack() {
        this.count = 0;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void push(int num) { // 1 4 7 8
        if (list.isEmpty()) {
            min = num;
            minList.add(num); //1
        } else {
            if (min > num) {
                min = num;
            }
            minList.add(min); // 1 1 1 1
        }
        count++;
        list.add(num); //1 4 7 8
    }

    public int pop() {
        if (list.isEmpty()) {
            return -1;
        } else {
            count--;
            int index = list.size() - 1;
            if (index >= 1) {
                min = minList.get(index - 1);
                minList.remove(index);
            }
            int num = list.remove(index);
            if (list.isEmpty()) {
                minList = new ArrayList<>();
            }
            return num;
        }
    }

    public int peek() {
        return list.get(list.size() - 1);
    }

    public int minimum() {
        return min;
    }

    public void printList() {
        System.out.println("Actual List: ");
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println("");
    }

    public void printMinList() {
        System.out.println("Min List: ");
        for (int num : minList) {
            System.out.print(num + " ");
        }
        System.out.println("");
    }
}

class CustomStackDemo {
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack();
        customStack.push(3);
        customStack.push(7);
        customStack.push(1);
        customStack.push(4);

        customStack.printList();
        customStack.printMinList();


        System.out.println(customStack.peek());
        System.out.println(customStack.minimum());
        System.out.println(customStack.pop());

        customStack.printList();
        customStack.printMinList();

        System.out.println(customStack.peek());
        System.out.println(customStack.minimum());
        System.out.println(customStack.pop());

        customStack.printList();
        customStack.printMinList();

        System.out.println(customStack.peek());
        System.out.println(customStack.minimum());
        System.out.println(customStack.pop());

        customStack.printList();
        customStack.printMinList();

        System.out.println(customStack.peek());
        System.out.println(customStack.minimum());
        System.out.println(customStack.pop());

        customStack.printList();
        customStack.printMinList();


    }
}

