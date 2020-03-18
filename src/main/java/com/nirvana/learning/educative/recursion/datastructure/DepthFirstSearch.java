package com.nirvana.learning.educative.recursion.datastructure;

import java.util.LinkedList;

/**
 * Depth First Search is a method used to traverse and search all nodes in a graph.
 * The algorithm allows us to determine if two nodes, node A and node B, have a path between them.
 * This process starts from the root node and then traverses all through that branch
 * until it reaches the leaf, the last node with no other children, and then backtracks.
 * This continues until all nodes have been traversed.
 */
public class DepthFirstSearch {

    public static void main(String[] args) {
        System.out.println("Your DFS path is: ");

        int nVertices = 6;

        Graph g = new Graph(nVertices);

        g.addEgde(0, 1);
        g.addEgde(0, 2);
        g.addEgde(1, 3);
        g.addEgde(1, 4);
        g.addEgde(2, 5);

        // Root node given as argument to the function
        g.DFSRecursion(0);
    }

    static class Graph {
        int numVertices;
        LinkedList<Integer>[] tempList;

        Graph(int numVertices) {
            this.numVertices = numVertices;
            tempList = new LinkedList[numVertices];
            for (int i = 0; i < numVertices; i++) {
                tempList[i] = new LinkedList<>();
            }
        }

        // Method to add an edge between 2 nodes in the Graph
        // fromNode 2 toNode 5 ==> 2 -> 5
        public void addEgde(int fromNode, int toNode) {
            tempList[fromNode].addFirst(toNode);
        }

        public void DFSRecursion(int startVertex) {
            boolean[] visitedArr = new boolean[numVertices];
            dfs(startVertex, visitedArr);
        }

        // DFS Recursion takes place here
        public void dfs(int start, boolean[] visitedArr) {
            visitedArr[start] = true;

            System.out.print(start + " ");

            for (int i = 0; i < tempList[start].size(); i++) {
                int toNode = tempList[start].get(i);
                if (!visitedArr[toNode])
                    dfs(toNode, visitedArr);
            }
        }
    }
}
