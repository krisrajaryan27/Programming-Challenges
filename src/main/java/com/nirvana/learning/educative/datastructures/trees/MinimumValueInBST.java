package com.nirvana.learning.educative.datastructures.trees;

/**
 * Given the root to a binary search tree, write a function to
 * find the minimum value in that tree. A solution is placed in the "solution"
 * section to help you, but we would suggest you try to solve it on your own first.
 *
 * @author Krishna Verma
 */
public class MinimumValueInBST {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(6);
        binarySearchTree.add(4);
        binarySearchTree.add(9);
        binarySearchTree.add(2);
        binarySearchTree.add(5);
        binarySearchTree.add(8);
        binarySearchTree.add(12);
        binarySearchTree.add(10);
        binarySearchTree.add(14);

        System.out.println(findMinRecursively(binarySearchTree.getRoot()));
        System.out.println(findMin(binarySearchTree.getRoot()));

    }

    //Recursive Solution to findMin in BST
    public static int findMinRecursively(Node root) {
        if (root == null) {
            return -1;
        }
        if (root.getLeftChild() == null) {
            return root.getData();
        }
        return findMinRecursively(root.getLeftChild());
    }

    //Iterative Solution to findMin in BST
    public static int findMin(Node root) {
        // Keep traversing (in order) towards left till you reach leaf node,
        //and then return leaf node's value
        if (root == null) {
            return -1;
        }
        while (root.getLeftChild() != null) {
            root = root.getLeftChild();
        }
        return root.getData();
    }
}
