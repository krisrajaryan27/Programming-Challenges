package com.nirvana.learning.interview.linkedlist;

/**
 * Design your implementation of the linked list.
 * You can choose to use a singly or doubly linked list.
 * <p>
 * A node in a singly linked list should have two attributes: val and next.
 * val is the value of the current node, and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list,
 * you will need one more attribute prev to indicate the previous node in the linked list.
 * Assume all nodes in the linked list are 0-indexed.
 * <p>
 * Implement the MyLinkedList class:
 * <p>
 * MyLinkedList() Initializes the MyLinkedList object.
 * <p>
 * int get(int index) Get the value of the indexth node in the linked list.
 * If the index is invalid, return -1.
 * <p>
 * void addAtHead(int val) Add a node of value val before the first element of the linked list.
 * After the insertion, the new node will be the first node of the linked list.
 * <p>
 * void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * <p>
 * void addAtIndex(int index, int val) Add a node of value val before the indexth
 * node in the linked list. If index equals the length of the linked list,
 * the node will be appended to the end of the linked list.
 * If index is greater than the length, the node will not be inserted.
 * <p>
 * void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * Output
 * [null, null, null, null, 2, null, 3]
 * <p>
 * Explanation
 * <p>
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
 * myLinkedList.get(1);              // return 2
 * myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
 * myLinkedList.get(1);              // return 3
 * <p>
 * Constraints:
 * <p>
 * 0 <= index, val <= 1000
 * <p>
 * Please do not use the built-in LinkedList library.
 * <p>
 * At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.
 * <p>
 * <a href="https://leetcode.com/explore/learn/card/linked-list/209/singly-linked-list/1290/">Leetcode</a>
 */
public class MyLinkedList {
    private static Node head; // Head of the linked list
    private static int size; // Size of the linked list
    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);           // Linked list: 1
        myLinkedList.addAtTail(3);           // Linked list: 1 -> 3
        myLinkedList.addAtIndex(1, 2);       // Linked list: 1 -> 2 -> 3
        System.out.println(myLinkedList.get(1)); // Output: 2
        myLinkedList.deleteAtIndex(1);       // Linked list: 1 -> 3
        System.out.println(myLinkedList.get(1)); // Output: 3
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1; // Invalid index
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next; // Traverse to the index
        }
        return current.value; // Return the value at the index
    }

    /**
     * Add a node of value val before the first element of the linked list.
     */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head; // Point new node to the current head
        head = newNode; // Update head to the new node
        size++; // Increment size
    }

    /**
     * Append a node of value val as the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode; // If the list is empty, new node becomes the head
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next; // Traverse to the end
            }
            current.next = newNode; // Link the new node at the end
        }
        size++; // Increment size
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;  // Invalid index
        }

        if (index == 0) {
            addAtHead(val); // If index is 0, add at head
        } else {
            Node newNode = new Node(val);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next; // Traverse to the node before the index
            }
            newNode.next = current.next; // Link the new node
            current.next = newNode; // Insert the new node
            size++; // Increment size
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return; // Invalid index
        }

        if (index == 0) {
            head = head.next; // Update head if deleting the first node
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next; // Traverse to the node before the index
            }
            current.next = current.next.next; // Bypass the node to delete it
        }
        size--;

    }

    // Node class for the linked list
    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }


}
