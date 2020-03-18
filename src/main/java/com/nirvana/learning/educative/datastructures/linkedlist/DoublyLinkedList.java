package com.nirvana.learning.educative.datastructures.linkedlist;

public class DoublyLinkedList<T> {
    public Node headNode;
    public int size;

    public DoublyLinkedList() {
        this.headNode = null;
    }

    //checks if the list is empty
    public boolean isEmpty() {
        return headNode == null; //is empty
//is not empty
    }

    public void insertAtHead(T data) {
        //create node and put in the data
        Node newNode = new Node();
        newNode.data = data;
        // Make next of new node as head and previous as NULL
        newNode.nextNode = this.headNode;
        newNode.prevNode = null;
        //Change previous of head node to new node
        if (headNode != null)
            headNode.prevNode = newNode;
        this.headNode = newNode;
        size++;
    }

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

    //deletes the first element
    public void deleteAtHead() {
        //if list is empty do nothing
        if (isEmpty())
            return;

        //if List is not empty then link head to the
        //nextElement of firstElement.
        headNode = headNode.nextNode;
        headNode.prevNode = null;
        size--;
    }

    public void deleteByValue(T data) {
        //if empty then simply return
        if (isEmpty())
            return;

        //Start from head node
        Node currentNode = this.headNode;

        if (currentNode.data.equals(data)) {
            //data is at head so delete from head
            deleteAtHead();
            return;
        }
        //traverse the list searching for the data to delete
        while (currentNode != null) {
            //node to delete is found
            if (data.equals(currentNode.data)) {
                currentNode.prevNode.nextNode = currentNode.nextNode;
                if (currentNode.nextNode != null)
                    currentNode.nextNode.prevNode = currentNode.prevNode;
                size--;
            }
            currentNode = currentNode.nextNode;
        }
    }

    public class Node<T> {
        public T data; //Stores data
        public Node nextNode; //Stores pointer to next element
        public Node prevNode; //Stores pointer to previous element
    }
}
