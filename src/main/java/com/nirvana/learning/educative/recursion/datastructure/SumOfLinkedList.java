package com.nirvana.learning.educative.recursion.datastructure;

public class SumOfLinkedList {
    static int sumOfLinkedList(Node head) {
        if (head == null) {
            return 0;
        }
        return head.data + sumOfLinkedList(head.next);
    }

    static Node insertAtHead(Node temp_head, int new_value) {
        Node new_Node = new Node();
        new_Node.data = new_value;
        new_Node.next = (temp_head);
        (temp_head) = new_Node;
        return temp_head;
    }

    public static void main(String[] args) {
        // Empty Linked List
        Node head = null;

        // Linked List = 1->2->3->4->5
        head = insertAtHead(head, 5);
        head = insertAtHead(head, 4);
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);

        // Print the original Linked List
        System.out.println("Linked List: ");
        for (Node i = head; i != null; i = i.next) {
            System.out.print(i.data + " ");
        }

        int sum = sumOfLinkedList(head);

        System.out.println(" ");
        System.out.println("Sum: " + sum);

    }

    static class Node {
        int data;
        Node next;
    }
}
