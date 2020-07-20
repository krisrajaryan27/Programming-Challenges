package com.nirvana.learning.educative.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees
 * Given the root to a Binary Search Tree, write a function to find the height of the tree.
 *
 * @author Krishna Verma
 * @date 18th July 2020
 */
public class HeightOfBSTTree {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(3);
        binarySearchTree.add(5);
        binarySearchTree.add(2);
        binarySearchTree.add(1);
        binarySearchTree.add(4);
        binarySearchTree.add(6);
        binarySearchTree.add(7);
        binarySearchTree.printTree(binarySearchTree.getRoot());
        System.out.println("\nHeight of the BST:");
        System.out.println(heightRecursively(binarySearchTree.getRoot()));
        System.out.println(height(binarySearchTree.getRoot()));
    }

    //Recursive Way
    //The Height of binary tree with single node is taken as zero.
    public static int heightRecursively(Node root) {
        if (root == null || (root.getLeftChild() == null && root.getRightChild() == null)) {
            return 0;
        }
        int heightLeftSubTree = heightRecursively(root.getLeftChild());
        int heightRightSubTree = heightRecursively(root.getRightChild());
        return 1 + Math.max(heightLeftSubTree, heightRightSubTree);
    }

    public static int findHeight(Node root) {
        //Base case, leaf nodes have 0 height
        if (root == null) return -1;
        else {
            return 1 + Math.max(findHeight(root.getLeftChild()), findHeight(root.getRightChild()));
            // Find Height of left subtree right subtree
            // Return greater height value of left or right subtree (plus 1)
        }
    }

    //Iterative Way using Queues.
    public static int height(Node root) {
        if (root == null || (root.getLeftChild() == null && root.getRightChild() == null)) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;
        while (true) {
            int nodeCount = queue.size();
            if (nodeCount == 0) {
                return height - 1;
            }
            height++;
            while (nodeCount > 0) {
                Node newNode = queue.peek();
                queue.remove();
                assert newNode != null;
                if (newNode.getLeftChild() != null) {
                    queue.add(newNode.getLeftChild());
                }
                if (newNode.getRightChild() != null) {
                    queue.add(newNode.getRightChild());
                }
                nodeCount--;
            }
        }

    }

}
