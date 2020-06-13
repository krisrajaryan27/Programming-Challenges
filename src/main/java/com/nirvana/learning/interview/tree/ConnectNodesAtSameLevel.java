package com.nirvana.learning.interview.tree;

/**
 * Date 03/24/2019
 *
 * @author Krishna Verma
 * <p>
 * Populate next pointer for each node of binary tree.
 * <p>
 * Time complexity O(n)
 * Space complexity O(1)
 * <p>
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class ConnectNodesAtSameLevel {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node root = null;
        root = bt.addNode(10, root);
        root = bt.addNode(15, root);
        root = bt.addNode(5, root);
        root = bt.addNode(7, root);
        root = bt.addNode(19, root);
        root = bt.addNode(20, root);
        root = bt.addNode(-1, root);
        root = bt.addNode(21, root);
        ConnectNodesAtSameLevel cns = new ConnectNodesAtSameLevel();

        cns.connect(root);
    }

    public void connect(Node root) {
        if (root == null) {
            return;
        }

        Node firstNode = root;
        Node prevNode = null;
        while (firstNode != null) {
            root = firstNode;
            firstNode = null;
            prevNode = null;
            while (root != null) {
                if (root.left != null) {
                    if (firstNode == null) {
                        firstNode = root.left;
                    }
                    if (prevNode != null) {
                        prevNode.next = root.left;
                    }
                    prevNode = root.left;
                }
                if (root.right != null) {
                    if (firstNode == null) {
                        firstNode = root.right;
                    }
                    if (prevNode != null) {
                        prevNode.next = root.right;
                    }
                    prevNode = root.right;
                }
                root = root.next;
            }
        }
    }
}
