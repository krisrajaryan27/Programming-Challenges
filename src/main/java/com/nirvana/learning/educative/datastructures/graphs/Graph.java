package com.nirvana.learning.educative.datastructures.graphs;

import com.nirvana.learning.educative.datastructures.linkedlist.DoublyLinkedListWithTail;

public class Graph {
    int vertices; //Total number of vertices in graph
    DoublyLinkedListWithTail<Integer>[] adjacencyList; //An array of linked lists to store adjacent vertices.

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new DoublyLinkedListWithTail[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new DoublyLinkedListWithTail<>();
        }
    }

    //Adds an Edge from source vertex to destination vertex
    public void addEdge(int source, int destination) {
        this.adjacencyList[source].insertAtEnd(destination);

        //for undirected graph uncomment the line below
        //this.adjacencyList[destination].insertAtEnd(source);
    }

    //Prints Graph (Adjaceny List)
    public void printGraph() {
        System.out.println(">>Adjacency List of Directed Graph<<");
        for (int i = 0; i < vertices; i++) {
            if (adjacencyList[i] != null) {
                System.out.print("|" + i + "| => ");

                DoublyLinkedListWithTail<Integer>.Node temp = adjacencyList[i].getHeadNode();
                while (temp != null) {
                    System.out.print("[" + temp.data + "] -> ");
                    temp = temp.nextNode;
                }
                System.out.println("null");
            } else {

                System.out.println("|" + i + "| => " + "null");
            }
        }
    }


}
