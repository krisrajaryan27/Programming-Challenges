package com.nirvana.learning.educative.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary search tree, find its size.
 */
public class BinaryTreeSize {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(6);
        binarySearchTree.add(4);
        binarySearchTree.add(9);
        binarySearchTree.add(5);
        binarySearchTree.add(2);
        binarySearchTree.add(8);
        binarySearchTree.add(12);
        System.out.println(sizeLevelOrder(binarySearchTree.getRoot()));
        System.out.println(sizeRecursive(binarySearchTree.getRoot()));

    }

    public static int sizeLevelOrder(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            count++;
            if (temp.getLeftChild() != null) {
                queue.offer(temp.getLeftChild());
            }
            if (temp.getRightChild() != null) {
                queue.offer(temp.getRightChild());
            }
        }
        return count;
    }

    public static int sizeRecursive(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSubTreeSize = root.getLeftChild() == null ? 0 : sizeRecursive(root.getLeftChild());
        int rightSubTreeSize = root.getRightChild() == null ? 0 : sizeRecursive(root.getRightChild());
        return 1 + leftSubTreeSize + rightSubTreeSize;
    }
}
