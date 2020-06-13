package com.nirvana.learning.interview.linkedlist;


import com.nirvana.learning.educative.datastructures.linkedlist.LinkedList;

public class AddTwoNumbersLinkedList {

    public static void main(String[] args) {
        LinkedList.Node first = new LinkedList.Node(4);
        LinkedList.Node first1 = new LinkedList.Node(6);
        LinkedList.Node first2 = new LinkedList.Node(5);
        first.next = first1;
        first1.next = first2;
        LinkedList.Node second = new LinkedList.Node(3);
        LinkedList.Node second1 = new LinkedList.Node(4);
        LinkedList.Node second2 = new LinkedList.Node(6);
        LinkedList.Node second3 = new LinkedList.Node(1);
        second.next = second1;
        second1.next = second2;
        second2.next = second3;
        LinkedList.Node result = addTwoNumbers(first, second);
        printList(result);

    }

    public static void printList(LinkedList.Node headNode) {
        if (isEmpty(headNode)) {
            System.out.println("List is Empty!");
            return;
        }

        LinkedList.Node temp = headNode;
        System.out.print("List : ");
        while (temp.next != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data + " -> null");
    }

    public static boolean isEmpty(LinkedList.Node headNode) {
        return headNode == null;
    }

    public static LinkedList.Node addTwoNumbers(LinkedList.Node first, LinkedList.Node second) {
        LinkedList.Node dummyHead = new LinkedList.Node(0);
        LinkedList.Node p = first, q = second, current = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.data : 0;
            int y = (q != null) ? q.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new LinkedList.Node(sum % 10);
            current = current.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            current.next = new LinkedList.Node(carry);
        }
        return dummyHead.next;
    }
}
