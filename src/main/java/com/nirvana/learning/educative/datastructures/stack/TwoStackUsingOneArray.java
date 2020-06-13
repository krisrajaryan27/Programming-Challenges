package com.nirvana.learning.educative.datastructures.stack;

//You can either divide array in two halves or start stacks at extreme ends.
//We'll use the second technique to solve this problem.
//Top of Stack 1 start from extreme left of array i.e top1 = 0;
//Top of Stack 2 start from extreme right of array i.e top2 = size - 1
public class TwoStackUsingOneArray<V> {
    int top1, top2; //Store top value indices of Stack 1 and Stack 2
    private int maxSize;
    private V[] array;


    @SuppressWarnings("unchecked")
    public TwoStackUsingOneArray(int max_size) {
        this.maxSize = max_size;
        array = (V[]) new Object[max_size];//type casting Object[] to V[]
        top1 = -1;
        top2 = max_size;
    }

    // Driver program to test twoStack class
    public static void main(String[] args) {
        TwoStackUsingOneArray<Integer> ts = new TwoStackUsingOneArray(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        System.out.println("Popped element from stack1 is: " + ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from stack2 is:" + ts.pop2());
    }

    //insert at top of first stack
    public void push1(V value) {
        // There is at least one empty space for
        // new element
        if (top1 < top2 - 1) {
            top1++;
            array[top1] = value;
        } else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }

    }

    //insert at top of second stack
    public void push2(V value) {
        // There is at least one empty space for
        // new element
        if (top1 < top2 - 1) {
            top2--;
            array[top2] = value;
        } else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }

    }

    //remove and return value from top of first stack
    public V pop1() {
        if (top1 >= 0) {
            V value = array[top1];
            top1--;
            return value;
        } else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return null;
    }

    //remove and return value from top of second stack
    public V pop2() {
        if (top2 < maxSize) {
            V value = array[top2];
            top2++;
            return value;
        } else {
            System.out.println("Stack Underflow");
            System.exit(1);

        }
        return null;
    }
}
