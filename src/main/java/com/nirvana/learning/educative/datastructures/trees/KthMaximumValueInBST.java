package com.nirvana.learning.educative.datastructures.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root to a binary search tree--a number "k"
 * Write a function to find the kth maximum value in that tree.
 * Hint: Inorder Traversal of BST results in a sorted array list.
 *
 * @author Krishna Verma
 */
public class KthMaximumValueInBST {
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

        System.out.println(findKthMaxM1(binarySearchTree.getRoot(), 3));
        System.out.println(findKthMaxM2(binarySearchTree.getRoot(), 3));
    }

    public static int findKthMaxM1(Node root, int k) {
        if (root == null) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list.get(list.size() - k);
    }

    private static List<Integer> inOrderTraversal(Node root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        inOrderTraversal(root.getLeftChild(), list);
        list.add(root.getData());
        inOrderTraversal(root.getRightChild(), list);
        return list;
    }

    public static int findKthMaxM2(Node root, int k) {

        //Perform In-Order Traversal to get sorted array. (ascending order)
        //Return value at index [length - k]
        StringBuilder result = new StringBuilder(); //StringBuilder is mutable
        inOrderTraversal(root, result);

        String[] array = result.toString().split(","); //Spliting String into array of strings
        if ((array.length - k) >= 0) return Integer.parseInt(array[array.length - k]);

        return -1;
    }

    //Helper recursive function to traverse tree using inorder traversal
    //and return result in StringBuilder
    public static StringBuilder inOrderTraversal(Node root, StringBuilder result) {
        if (root.getLeftChild() != null) {
            inOrderTraversal(root.getLeftChild(), result);
        }
        result.append(root.getData()).append(",");
        if (root.getRightChild() != null) {
            inOrderTraversal(root.getRightChild(), result);
        }
        return result;
    }

    static int counter; //global count variable

    //used as a wrapper for the recursive algorithm
    public static int findKthMax(Node root, int k) {
        counter = 0;
        Node node = findKthMaxRecursive(root, k);
        if (node != null)
            return node.getData();
        return -1;
    }

    public static Node findKthMaxRecursive(Node root, int k) {
        if (root == null) {
            return null;
        }
        //Recursively reach the right-most node (which has the highest value)
        Node node = findKthMaxRecursive(root.getRightChild(), k);

        if (counter != k) {
            //Increment counter if kth element is not found
            counter++;
            node = root;
        }
        //Base condition reached as kth largest is found
        if (counter == k) {
            return node;
        } else {
            //Traverse left child if kth element is not reached
            return findKthMaxRecursive(root.getLeftChild(), k);
        }
    }
}
