package com.nirvana.learning.educative.datastructures.trees;

public class CheckIfTreeIsBST {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.setLeftChild(new Node(2));
        tree.root.setRightChild(new Node(5));
        tree.root.getLeftChild().setLeftChild(new Node(1));
        tree.root.getLeftChild().setRightChild(new Node(3));

        System.out.print("Tree : ");
        tree.printTree(tree.getRoot());

        System.out.println("\nChecking if Binary Tree is BST:" + checkBST(tree.root));

        BinaryTree tree1 = new BinaryTree();
        tree1.root = new Node(7);
        tree1.root.setLeftChild(new Node(9));
        tree1.root.setRightChild(new Node(6));
        tree1.root.getLeftChild().setLeftChild(new Node(4));
        tree1.root.getLeftChild().setRightChild(new Node(3));

        System.out.print("Tree : ");
        tree.printTree(tree1.getRoot());

        System.out.println("\nChecking if Binary Tree is BST:" + checkBST(tree1.root));
    }

    public static boolean checkBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBST(Node node, int min, int max) {
        if (node == null) return true;
        if (node.getData() <= min || node.getData() >= max) return false;
        return isBST(node.getLeftChild(), min, node.getData())
                && isBST(node.getRightChild(), node.getData(), max);
    }
}

class BinaryTree {
    Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void printTree(Node current) {
        if (current == null) return;
        System.out.print(current.getData() + ",");
        printTree(current.getLeftChild());
        printTree(current.getRightChild());
    }
}

