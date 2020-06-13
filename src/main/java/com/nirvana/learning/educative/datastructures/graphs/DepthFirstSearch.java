package com.nirvana.learning.educative.datastructures.graphs;

import com.nirvana.learning.educative.datastructures.linkedlist.DoublyLinkedListWithTail;
import com.nirvana.learning.educative.datastructures.stack.Stack;

public class DepthFirstSearch {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        System.out.println(dfsTraversal(graph, 0));
    }

    //Depth First Traversal of Graph g from source vertex
    private static String dfsTraversal(Graph graph, int source) {
        StringBuilder result = new StringBuilder();
        int vertices = graph.vertices;

        //Boolean Array to hold the history of visited nodes (by default-false)
        //Make a node visited whenever you push it into stack
        boolean[] visited = new boolean[vertices];
        //Create Stack for Dept First Traversal and push source in it
        Stack<Integer> stack = new Stack<>(vertices);

        stack.push(source);
        //Traverse while stack is not empty
        while (!stack.isEmpty()) {

            //Pop a vertex/node from stack and add it to result
            int currentNode = stack.pop();

            result.append(currentNode);
            //Visit the node
            visited[currentNode] = true;

            //Get adjacent vertices to the currentNode from the array,
            // and if they are not already visited then push them in the stack
            DoublyLinkedListWithTail<Integer>.Node temp = null;
            if (graph.adjacencyList[currentNode] != null)
                temp = graph.adjacencyList[currentNode].headNode;

            while (temp != null) {
                if (!visited[temp.data]) {
                    stack.push(temp.data);
                }
                temp = temp.nextNode;
            }
        }//end of while
        return result.toString();
    }
}
