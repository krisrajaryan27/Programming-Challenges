package com.nirvana.learning.educative.datastructures.linkedlist;

public class DoublyLinkedListWithTail<T> {

    //member variables
    public Node headNode;
    public Node tailNode;
    public int size;

    //constructor
    public DoublyLinkedListWithTail() {
        this.headNode = null;
        this.tailNode = null; //null initially
        this.size = 0;
    }

    //returns true if list is empty
    public boolean isEmpty() {
        //checking tailNode to make sure
        return headNode == null && tailNode == null;
    }

    //getter for headNode
    public Node getHeadNode() {
        return headNode;
    }

    //getter for tailNode
    public Node getTailNode() {
        return tailNode;
    }

    //getter for size
    public int getSize() {
        return size;
    }

    //insert at start of the list
    public void insertAtHead(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = this.headNode; //Linking newNode to head's nextNode
        newNode.prevNode = null; //it will be inserted at start so prevNode will be null
        if (!isEmpty())
            headNode.prevNode = newNode;
        else
            tailNode = newNode;
        this.headNode = newNode;
        size++;
    }

    //insert at end of the list
    public void insertAtEnd(T data) {
        if (isEmpty()) { //if list is empty then insert at head
            insertAtHead(data);
            return;
        }
        //make a new node and assign it the value to be inserted
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null; //it will be inserted at end so nextNode will be null
        newNode.prevNode = tailNode; //newNode comes after tailNode so its prevNode will be tailNode
        tailNode.nextNode = newNode; //make newNode the nextNode of tailNode
        tailNode = newNode; //update tailNode to be the newNode
        size++;
    }

    public void deleteAtHead() {
        if (isEmpty())
            return;

        headNode = headNode.nextNode;
        if (headNode == null)
            tailNode = null;
        else
            headNode.prevNode = null;
        size--;
    }

    public void deleteAtTail() {
        if (isEmpty())
            return;
        tailNode = tailNode.prevNode;
        if (tailNode == null)
            headNode = null;
        else
            tailNode.nextNode = null;
        size--;
    }

    //print list function
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : null <- ");

        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " <-> ");
            temp = temp.nextNode;
        }

        System.out.println(temp.data.toString() + " -> null");
    }

    //Node inner class for DLL
    public class Node {
        public T data;
        public Node nextNode;
        public Node prevNode;
    }
}
