package com.nirvana.learning.educative.datastructures.linkedlist;

import java.util.HashSet;

public class SinglyLinkedList<T> {
    public Node headNode; //head node of the linked list
    public int size;      //size of the list

    //constructor
    public SinglyLinkedList() {
        headNode = null;
        size = 0;
    }

    public Node getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node headNode) {
        this.headNode = headNode;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //Helper Function that checks if List is empty or not
    public boolean isEmpty() {
        return headNode == null;
    }

    //1.Insertion at head - Inserts new data at the start of the linked list
    public void insertionAtHead(T data) {
        //Creating a new node and assigning it the new data value
        Node newNode = new Node();
        newNode.data = data;
        //Linking head to the newNode's nextNode
        newNode.nextNode = headNode;
        headNode = newNode;
        size++;
    }

    //2. Insertion at tail - Inserts new data at the end of the linked list
    public void insertionAtTail(T data) {
        //if the list is empty then call insertATHead()
        if (isEmpty()) {
            insertionAtHead(data);
            return;
        }
        //Creating a new Node with value data
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null;

        Node last = headNode;
        //iterate to the last element
        while (last.nextNode != null) {
            last = last.nextNode;
        }
        //make newNode the next element of the last node
        last.nextNode = newNode;
        size++;
    }

    //3. Insertion after - Inserts new data after the specific value of the linked list
    public void insertionAfter(T data, T previous) {
        Node newNode = new Node();
        newNode.data = data;
        Node currentNode = this.headNode;
        if (isEmpty()) {
            insertionAtHead(data);
            return;
        }
        while (currentNode != null && !currentNode.data.equals(previous)) {
            currentNode = currentNode.nextNode;
        }
        if (currentNode != null) {
            newNode.nextNode = currentNode.nextNode;
            currentNode.nextNode = newNode;
        }
        size++;
    }

    //4. Searching for a node
    public boolean searchNode(T data) {
        if (isEmpty()) {
            return false;
        }
        //Start from first element
        Node current = this.headNode;
        //Traverse the list till you reach end
        while (current != null) {
            if (current.data.equals(data)) {
                return true; //value found
            }
            current = current.nextNode;
        }
        return false; //value not found
    }

    public void deleteAtHead() {
        if (isEmpty()) return;
        headNode = headNode.nextNode;
        size--;
    }

    //5. Deletion at head - This type of deletion is used when your list is ordered
    // And you want to implement a priority queue–via a linked list-- to keep track of all the elements

    //6. Delete by value
    public void deleteByValue(T data) {
        //if empty then simply return
        if (isEmpty())
            return;
        //Start from head node
        Node currentNode = this.headNode;
        Node prevNode = null; //previous node starts from null
        if (currentNode.data.equals(data)) {
            //data is at head so delete from head
            deleteAtHead();
            return;
        }
        //traverse the list searching for the data to delete
        while (currentNode != null) {
            //node to delete is found
            if (data.equals(currentNode.data)) {
                if (prevNode != null) {
                    prevNode.nextNode = currentNode.nextNode;
                }
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        size--;
    }

    //7.Delete at End of LinkedList
    public void deleteAtEnd() {
        if (isEmpty())
            return;
        Node prevNode = this.headNode;
        Node currentNode = prevNode.nextNode;
        while (currentNode.nextNode != null) {
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        prevNode.nextNode = null;
        size--;
    }

    // Helper Function to printList
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : ");
        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }
        System.out.println(temp.data.toString() + " -> null");
    }

    public int length() {
        if (isEmpty()) {
            return 0;
        }
        int count = 0;
        Node currentNode = this.headNode;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.nextNode;
        }
        return count;
    }

    public void removeDuplicatesWithHashing() {
        Node current = this.headNode;
        Node prevNode = this.headNode;
        //will store all the elements that we observe once
        HashSet<T> visitedNodes = new HashSet<>();

        if (!isEmpty() && current.nextNode != null) {
            while (current != null) {
                //check if already visited then delete this node
                if (visitedNodes.contains(current.data)) {
                    //deleting the node by undating the pointer of previous node
                    prevNode.nextNode = current.nextNode;
                    current = current.nextNode;
                } else {
                    //if node was not already visited then add it to the visited set
                    visitedNodes.add(current.data);
                    //moving on to next element in the list
                    prevNode = current;
                    current = current.nextNode;
                }
            }
        }
    }

    //Node inner class for SLL
    public class Node {
        public T data; //Data to store (could be int, string, Object etc)
        public Node nextNode; //Pointer to next node in list

    }

}
