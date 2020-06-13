package com.nirvana.learning.educative.datastructures.graphs;

import com.nirvana.learning.educative.datastructures.linkedlist.DoublyLinkedListWithTail;
import com.nirvana.learning.educative.datastructures.queue.Queue;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        System.out.println(bfsTraversal(graph, 0));
    }

    //Breadth First Traversal of Graph g from source vertex
    public static String bfsTraversal(Graph graph, int source) {
        StringBuilder result = new StringBuilder();
        int vertices = graph.vertices;

        //Boolean Array to hold the history of visited nodes (by default-false)
        //Make a node visited whenever you enqueue it into queue
        boolean[] visited = new boolean[vertices];

        //Create Queue for Breadth First Traversal and enqueue source in it
        Queue<Integer> queue = new Queue<>(vertices);

        queue.enqueue(source);
        visited[source] = true;

        //Traverse while queue is not empty
        while (!queue.isEmpty()) {

            //Dequeue a vertex/node from queue and add it to result
            int currentNode = queue.dequeue();

            result.append(currentNode);

            //Get adjacent vertices to the current_node from the array,
            // and if they are not already visited then enqueue them in the Queue
            DoublyLinkedListWithTail<Integer>.Node temp = null;
            if (graph.adjacencyList[currentNode] != null)
                temp = graph.adjacencyList[currentNode].headNode;

            while (temp != null) {

                if (!visited[temp.data]) {
                    queue.enqueue(temp.data);
                    visited[temp.data] = true; //Visit the current Node
                }
                temp = temp.nextNode;
            }
        }//end of while
        return result.toString();
    }
}
