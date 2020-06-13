package com.nirvana.learning.interview.linkedlist;

/**
 * http://www.geeksforgeeks.org/delete-nodes-which-have-a-greater-value-on-right-side/
 * Test cases
 * Sorted list
 * reverse sorted list
 * 0 1 or more nodes in the list
 */
public class DeleteNodeWithGreaterValueOnRight {

    private int maxFound = Integer.MIN_VALUE;

    public static void main(String[] args) {
        DeleteNodeWithGreaterValueOnRight dng = new DeleteNodeWithGreaterValueOnRight();
        LinkedList ll = new LinkedList();
        Node head = null;
        head = ll.addNode(12, head);
        head = ll.addNode(15, head);
        head = ll.addNode(10, head);
        head = ll.addNode(11, head);
        head = ll.addNode(5, head);
        head = ll.addNode(6, head);
        head = ll.addNode(2, head);
        head = ll.addNode(3, head);
        head = dng.deleteNodes(head);
        ll.printList(head);
    }

    public Node deleteNodes(Node head) {
        if (head == null) {
            return null;
        }
        Node nextNode = deleteNodes(head.next);
        if (head.data > maxFound) {
            maxFound = head.data;
        }
        if (maxFound > head.data) {
            return nextNode;
        }
        head.next = nextNode;
        return head;
    }
}
