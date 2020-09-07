package com.nirvana.learning.educative.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
 * https://www.hackerrank.com/challenges/tree-top-view/problem
 * Prints the top view of a binary tree
 *
 * @author Krishna Verma
 */
public class BinaryTreeView {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.setLeftChild(new Node(2));
        tree.root.setRightChild(new Node(5));
        tree.root.getLeftChild().setLeftChild(new Node(1));
        tree.root.getLeftChild().setRightChild(new Node(3));
        printTopViewOfTree(tree.root);

    }


    public static void printTopViewOfTree(Node root) {
        //took a queue - similar to BFS approach
        Queue<QueueNode> queue = new LinkedList<>();

        //Taking a TreeMap<first, second>
        //first - stores the level of the node
        //second - stores the node.data
        TreeMap<Integer, Integer> map = new TreeMap<>();
        //why TreeMap? Because I want the nodes to be sorted from leftmost to rightmost

        //start (since root, level = 0)
        queue.add(new QueueNode(root, 0));

        while (!queue.isEmpty()) {
            //remove element from queue
            QueueNode tempNode = queue.poll();
            //if the level of this node has never been reached before -> visible in top view
            if (!map.containsKey(tempNode.horizontalDistance)) {
                map.put(tempNode.horizontalDistance, tempNode.node.getData());
            }

            //add node's descendants
            //all left child node levels = node.level - 1
            //all right child node levels = node.level + 1
            if (tempNode.node.getLeftChild() != null) {
                queue.add(new QueueNode(tempNode.node.getLeftChild(), tempNode.horizontalDistance - 1));
            }
            if (tempNode.node.getRightChild() != null) {
                queue.add(new QueueNode(tempNode.node.getRightChild(), tempNode.horizontalDistance + 1));
            }
        }
        //since already sorted (cuz TreeMap), print from left to right
        for (Integer value : map.values()) {
            System.out.print(value + " ");
        }
    }
}

//new class to store level of each node along with the node
class QueueNode {
    Node node;
    int horizontalDistance;

    public QueueNode(Node node, int horizontalDistance) {
        this.node = node;
        this.horizontalDistance = horizontalDistance;
    }
}

