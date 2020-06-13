package com.nirvana.learning.interview.linkedlist;

/**
 * Find middle element in linklist.
 * Use two pointer approach.
 * Test cases
 * 0,1,2,3,4 and so on nodes
 *
 * @author Krishna Verma
 */
public class MiddleElementOfLinkList {

    public static void main(String[] args) {
        MiddleElementOfLinkList mle = new MiddleElementOfLinkList();
        LinkedList ll = new LinkedList();
        Node head = null;
        head = ll.addNode(1, head);
        System.out.println(mle.middle(head));
        head = ll.addNode(2, head);
        System.out.println(mle.middle(head));
        head = ll.addNode(3, head);
        System.out.println(mle.middle(head));
        head = ll.addNode(4, head);
        System.out.println(mle.middle(head));
        head = ll.addNode(5, head);
        System.out.println(mle.middle(head));
    }

    public int middle(Node head) {
        if (head == null || head.next == null) {
            return head.data;
        }

        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
