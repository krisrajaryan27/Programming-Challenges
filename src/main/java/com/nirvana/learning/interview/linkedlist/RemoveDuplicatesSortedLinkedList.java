package com.nirvana.learning.interview.linkedlist;

/**
 * <a href="http://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/">...</a>
 * Test cases
 * All duplicates
 * No duplicates
 * Duplicates only in starting
 * Duplicates only at the end
 * 0 1 or more nodes in the list
 */
public class RemoveDuplicatesSortedLinkedList {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        Node head = null;
        head = ll.addNode(1, head);
        head = ll.addNode(1, head);
        head = ll.addNode(1, head);
        head = ll.addNode(4, head);
        head = ll.addNode(4, head);
        head = ll.addNode(5, head);
        head = ll.addNode(6, head);
        head = ll.addNode(6, head);
        head = ll.addNode(6, head);
        RemoveDuplicatesSortedLinkedList rds = new RemoveDuplicatesSortedLinkedList();
        rds.removeDuplicates(head);
        ll.printList(head);
    }

    public void removeDuplicates(Node head) {
        if (head == null) {
            return;
        }
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }
}
