package com.nirvana.learning.educative.datastructures.linkedlist;

public class DetectLoopAndRemoveInLinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new LinkedList.Node(50);
        list.head.next = new LinkedList.Node(20);
        list.head.next.next = new LinkedList.Node(15);
        list.head.next.next.next = new LinkedList.Node(4);
        list.head.next.next.next.next = new LinkedList.Node(10);

        // Creating a loop for testing
        list.head.next.next.next.next.next = list.head.next.next;
        detectAndRemoveLoop(list.head);
        System.out.println("Linked List after removing loop : ");
        printList(list.head);
    }

    // Function that detects loop in the list
    private static void detectAndRemoveLoop(LinkedList.Node node)
    {

        // If list is empty or has only one node
        // without loop
        if (node == null || node.next == null)
            return;

        LinkedList.Node slow = node, fast = node;

        // Move slow and fast 1 and 2 steps
        // ahead respectively.
        slow = slow.next;
        fast = fast.next.next;

        // Search for loop using slow and fast pointers
        while (fast != null && fast.next != null) {
            if (slow == fast)
                break;

            slow = slow.next;
            fast = fast.next.next;
        }

        /* If loop exists */
        if (slow == fast) {
            slow = node;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }

            /* since fast->next is the looping point */
            fast.next = null; /* remove loop */
        }
    }

    // Function to print the linked list
    private static void printList(LinkedList.Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("\n");
    }
}
