package com.nirvana.learning.interview.linkedlist;

/**
 * http://www.geeksforgeeks.org/given-linked-list-line-segments-remove-middle-points/
 *
 * @author Krishna Verma
 * Test cases:
 * 0 or more nodes
 * All points are edge of line segments so nothing gets removed
 * One long line so all points in between get removed
 */

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class RemoveMiddleElementsOfLineSegment {

    public static void main(String[] args) {
        Node head1 = null;

        LinkedList ll = new LinkedList();
        head1 = ll.addNode(1, head1, new Point(0, 10));
        head1 = ll.addNode(2, head1, new Point(1, 10));
        head1 = ll.addNode(3, head1, new Point(5, 10));
        head1 = ll.addNode(4, head1, new Point(7, 10));
        head1 = ll.addNode(5, head1, new Point(7, 5));
        head1 = ll.addNode(6, head1, new Point(20, 5));
        head1 = ll.addNode(7, head1, new Point(40, 5));
        head1 = ll.addNode(8, head1, new Point(40, 8));

        RemoveMiddleElementsOfLineSegment rme = new RemoveMiddleElementsOfLineSegment();
        rme.remove(head1);
        ll.printList(head1);
    }

    public void remove(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node curr = head;
        Node next = head.next;
        Node nextNext = head.next.next;
        while (nextNext != null) {

            Point pcurr = (Point) curr.obj;
            Point pnext = (Point) nextNext.obj;
            if (pcurr.x == pnext.x || pcurr.y == pnext.y) {
                curr.next = nextNext;
                next = nextNext;
                nextNext = nextNext.next;
            } else {
                curr = curr.next;
                next = next.next;
                nextNext = nextNext.next;
            }

        }
    }
}
