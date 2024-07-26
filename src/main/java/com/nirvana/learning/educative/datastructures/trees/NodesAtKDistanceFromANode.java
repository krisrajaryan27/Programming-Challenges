package com.nirvana.learning.educative.datastructures.trees;

public class NodesAtKDistanceFromANode {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        /* Let us construct the tree shown in above diagram */
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        Node target = tree.root.left.right;
        tree.printKDistanceNode(tree.root, target, 2);
    }

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        void printKDistanceNodeDown(Node node, int k) {
            //Base case
            if (node == null || k < 0) return;
            if (k == 0) {
                System.out.println(node.data);
                return;
            }
            printKDistanceNodeDown(node.left, k - 1);
            printKDistanceNodeDown(node.right, k - 1);
        }

        int printKDistanceNode(Node node, Node target, int k) {
            if (node == null) return -1;
            if (node == target) {
                printKDistanceNodeDown(node, k);
                return 0;
            }
            //Recur for left subtree
            int dl = printKDistanceNode(node.left, target, k);
            //Check if target node is found in left subtree
            if (dl != -1) {
                //If root is at k distance from target, print root
                //Note dl is the distance of root's left child from target
                if (dl + 1 == k) {
                    System.out.println(node.data);
                } else {
                    // Else go to right subtree and print all k-dl-2 distant nodes
                    // Note that the right child is 2 edges away from left child
                    printKDistanceNodeDown(node.right, k - dl - 2);
                }
                // Add 1 to the distance and return value for parent calls
                return 1 + dl;
            }
            // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
            // Note that we reach here only when node was not found in left
            // subtree
            int dr = printKDistanceNode(node.right, target, k);
            if (dr != -1) {
                if (dr + 1 == k) {
                    System.out.print(node.data);
                } else
                    printKDistanceNodeDown(node.left, k - dr - 2);
                return 1 + dr;
            }

            // If target was neither present in left nor in right subtree
            return -1;
        }
    }

}
