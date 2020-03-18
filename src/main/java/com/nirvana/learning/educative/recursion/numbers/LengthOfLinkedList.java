package com.nirvana.learning.educative.recursion.numbers;


import com.nirvana.learning.datastructures.LinkedList;

public class LengthOfLinkedList {
    /* Returns count of nodes in linked list Iteratively*/
    public static int lengthOfListIterative(LinkedList.Node head) {
        int count = 0;
        LinkedList.Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    /* Returns count of nodes in linked list Recursively*/
    public static int lengthOfListRecursive(LinkedList.Node head) {
        // Write your code here
        // Modify the return statement according to your code
        if (head == null) return 0;
        return 1 + lengthOfListRecursive(head.next);
    }

    public static void main(String[] args) {
        /* Start with the empty list */
        LinkedList list = new LinkedList();
        LinkedList.insertIntoLinkedList(list, 1);
        LinkedList.insertIntoLinkedList(list, 3);
        LinkedList.insertIntoLinkedList(list, 1);
        LinkedList.insertIntoLinkedList(list, 2);
        LinkedList.insertIntoLinkedList(list, 1);

        System.out.println("Count of nodes iteratively is = " + lengthOfListIterative(LinkedList.head));
        System.out.println("Count of nodes recursively is = " + lengthOfListRecursive(LinkedList.head));
    }
}
