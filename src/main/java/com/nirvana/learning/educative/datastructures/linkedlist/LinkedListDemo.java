package com.nirvana.learning.educative.datastructures.linkedlist;

public class LinkedListDemo {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        for (int i = 1; i <= 6; i++) {
            sll.insertionAtTail(i); // inserting value at the tail of the list
        }
        sll.printList();

        System.out.println(sll.searchNode(3));

        sll.deleteAtHead();
        sll.printList();
        sll.insertionAfter(3, 6);
        sll.insertionAtTail(2);
        sll.insertionAtTail(1);

        sll.printList();

        System.out.println(sll.length());
        //reverseSinglyLinkedList(sll);
        sll.printList();
        System.out.println(detectLoopInLinkedList(sll));
        System.out.println(findMiddle(sll));
        removeDuplicatesBrute(sll);
        sll.printList();
        System.out.println("\n");

//        DoublyLinkedListWithTail<Integer> list = new DoublyLinkedListWithTail<>();
//        for (int i = 0; i <= 3; i++) {
//            list.insertAtHead(i); //inserting 0 to 3 at start
//        }
//        System.out.println("After inserting 0 to 3 at start :");
//        list.printList();
//        for (int i = 5; i <= 10; i++) {
//            list.insertAtEnd(i); //inserting 5 to 10 at end
//        }
//        System.out.println("\n After inserting 5 to 10 at end :");
//        list.printList();

        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> result;
        for (int i = 1; i <= 6; i++) {
            list1.insertionAtTail(i);
        }
        for (int i = 1; i <= 8; i += 2) {
            list2.insertionAtTail(i);
        }
        list1.printList();
        list2.printList();
        result = union(list1, list2);
        result.printList();
        result = intersection(list1, list2);
        result.printList();

        int nthValueFromEnd = (int) nthElementFromEnd(list1, 3);
        System.out.println(nthValueFromEnd);

    }


    //Reverse a SinglyLinkedList
    public static <T> void reverseSinglyLinkedList(SinglyLinkedList<T> list) {
        SinglyLinkedList<T>.Node prev = null;
        SinglyLinkedList<T>.Node current = list.headNode;
        SinglyLinkedList<T>.Node next = null;
        while (current != null) {
            next = current.nextNode;
            current.nextNode = prev;
            prev = current;
            current = next;
        }
        list.headNode = prev;
        list.printList();
    }

    //Detect loop in SinglyLinkedList
    public static <T> boolean detectLoopInLinkedList(SinglyLinkedList<T> list) {
        SinglyLinkedList<T>.Node slow = list.headNode;
        SinglyLinkedList<T>.Node fast = list.headNode;
        while (slow != null && fast != null && fast.nextNode != null) {
            fast = fast.nextNode.nextNode;
            slow = slow.nextNode;
            if (slow.equals(fast)) {
                return true;
            }
        }
        return false;
    }

    //Find the Middle Value of a Linked List
    public static <T> Object findMiddle(SinglyLinkedList<T> list) {
        SinglyLinkedList<T>.Node slow = list.headNode;
        SinglyLinkedList<T>.Node fast = list.headNode;
        while (slow != null && fast != null && fast.nextNode != null) {
            fast = fast.nextNode.nextNode;
            if (fast != null) {
                slow = slow.nextNode;
            }
        }
        return slow.data;
    }

    //Remove Duplicates from a Linked List - Using two loops
    public static <T> void removeDuplicatesBrute(SinglyLinkedList<T> list) {
        SinglyLinkedList<T>.Node first = list.headNode;
        SinglyLinkedList<T>.Node second = null;
        while (first != null && first.nextNode != null) {
            second = first;
            while (second.nextNode != null) {
                if (first.data.equals(second.nextNode.data)) {
                    second.nextNode = second.nextNode.nextNode;
                } else {
                    second = second.nextNode;
                }
            }
            first = first.nextNode;
        }
    }

    //performs union of two lists
    public static <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T>.Node first = list1.headNode;
        SinglyLinkedList<T>.Node second = list2.headNode;
        SinglyLinkedList<T> result = new SinglyLinkedList<>();
        while (first != null || second != null) {
            if (first != null) {
                if (first.data.equals(second.data)) {
                    result.insertionAtTail(first.data);
                    first = first.nextNode;
                    second = second.nextNode;
                } else {
                    result.insertionAtTail(first.data);
                    first = first.nextNode;
                }
            } else {
                result.insertionAtTail(second.data);
                second = second.nextNode;
            }
        }
        return result;
    }

    public static <T> SinglyLinkedList<T> unionOptimized(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {

        //if one of the list is empty then return the other list
        if (list1.isEmpty())
            return list2;
        if (list2.isEmpty())
            return list1;

        //take the head of the first list
        SinglyLinkedList<T>.Node last = list1.getHeadNode();
        //traverse it to the last element
        while (last.nextNode != null) {
            last = last.nextNode;
        }
        //attach the last element of list1 to head of list2
        last.nextNode = list2.getHeadNode();
        //remove duplicates that might have been added now
        list1.removeDuplicatesWithHashing(); //complexity of this function is O(n)

        return list1;
    }

    public static <T> boolean contains(SinglyLinkedList<T> list, T data) {
        SinglyLinkedList<T>.Node current = list.getHeadNode();
        while (current != null) {
            if (current.data.equals(data))
                return true;
            current = current.nextNode;
        }
        return false;
    }

    //performs intersection between list
    public static <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<>();
        SinglyLinkedList<T>.Node firstNode = list1.headNode;
        SinglyLinkedList<T>.Node secondNode;
        while (firstNode != null) {
            secondNode = list2.headNode;
            while (secondNode != null) {
                if (firstNode.data.equals(secondNode.data)) {
                    result.insertionAtTail(firstNode.data);
                }
                secondNode = secondNode.nextNode;
            }
            firstNode = firstNode.nextNode;
        }
        return result;
    }

    public static <T> SinglyLinkedList<T> intersectionOptimised(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        if (list1.isEmpty())
            return result;
        if (list2.isEmpty())
            return result;
        SinglyLinkedList<T>.Node current = list1.getHeadNode();

        while (current != null) {
            if (contains(list2, current.data)) {
                result.insertionAtHead(current.data);
            }
            current = current.nextNode;
        }
        return result;
    }

    //Return the Nth node from End
    public static <T> Object nthElementFromEnd(SinglyLinkedList<T> list, int n) {
        int size = list.getSize();
        n = size - n + 1; //we can use the size variable to calculate distance from start
        if (size == 0 || n > size) {
            return null; //returns null if list is empty or n is greater than size
        }
        SinglyLinkedList<T>.Node current = list.getHeadNode();
        int count = 1;
        //traverse until count is not equal to n
        while (current != null) {
            if (count == n)
                return current.data;
            count++;
            current = current.nextNode;
        }
        return null;
    }
}
