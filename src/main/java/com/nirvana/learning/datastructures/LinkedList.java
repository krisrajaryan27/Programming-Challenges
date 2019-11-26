package com.nirvana.learning.datastructures;

public class LinkedList {
    static Node head;
    static class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list = insertIntoLinkedList(list,4);
        list = insertIntoLinkedList(list,3);
        list = insertIntoLinkedList(list,2);
        list = insertIntoLinkedList(list,1);
        list = insertIntoLinkedList(list,0);
        printLinkedList(list);
        head = reverseIteratively(list.head);
        printLinkedList(list);
        head = reverseRecursively(null,list.head);
        printLinkedList(list);


    }

    public static LinkedList insertIntoLinkedList(LinkedList list, int data){
        Node newNode = new Node(data);
        newNode.next = null;
        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while(last.next!=null){
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    public static void printLinkedList(LinkedList list){
        Node current = list.head;
        System.out.println("LinkedList: ");
        while(current!=null){
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println("");
    }

    public static Node reverseIteratively(Node node){
        Node prev = null;
        Node current = node;
        Node next;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public static Node reverseRecursively(Node prev, Node current){
        if(current.next == null){
            head =  current;
            current.next = prev;
            return null;
        }
        Node next = current.next;
        current.next = prev;
        reverseRecursively(current,next);
        return head;
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
