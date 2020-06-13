package com.nirvana.learning.educative.datastructures.linkedlist;

public class LinkedList {
    public static Node head;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list = insertIntoLinkedList(list, 4);
        list = insertIntoLinkedList(list, 3);
        list = insertIntoLinkedList(list, 2);
        list = insertIntoLinkedList(list, 1);
        list = insertIntoLinkedList(list, 0);
        printLinkedList(list);
        head = reverseIteratively(head);
        printLinkedList(list);
        head = reverseRecursively(null, head);
        printLinkedList(list);


    }

    public static LinkedList insertIntoLinkedList(LinkedList list, int data) {
        Node newNode = new Node(data);
        newNode.next = null;
        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    public static void printLinkedList(LinkedList list) {
        Node current = head;
        System.out.println("LinkedList: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    //Reverse Linked List Iteratively
    public static Node reverseIteratively(Node node) {
        Node prev = null;
        Node current = node;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    //Reverse Linked List Recursively
    public static Node reverseRecursively(Node prev, Node current) {
        if (current.next == null) {
            head = current;
            current.next = prev;
            return null;
        }
        Node next = current.next;
        current.next = prev;
        reverseRecursively(current, next);
        return head;
    }

    //Reverse a Linked List in groups of given size
    public static Node reverseLinkedListInGroups(Node head, int k) {
        Node current = head;
        Node next = null;
        Node prev = null;
        int count = 0;
        /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
       /* next is now a pointer to (k+1)th node
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
        if (next != null)
            head.next = reverseLinkedListInGroups(next, k);
        // prev is now head of input list
        return prev;
    }

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


//    public void reverseDoublyLinkedList(){
//        Node temp = null;
//        Node current = head;
//
//        /** swap next and prev for all nodes of
//         doubly linked list */
//        while (current != null) {
//            temp = current.prev;
//            current.prev = current.next;
//            current.next = temp;
//            current = current.prev;
//        }
//
//        /** Before changing head, check for the cases like empty
//         list and list with only one node */
//        if (temp != null) {
//            head = temp.prev;
//        }
//    }
}
