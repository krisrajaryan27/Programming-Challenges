package com.nirvana.learning.educative.recursion.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * A Binary Search Tree (BST) is a hierarchical data structure that consists of vertices connected through edges.
 * The value of the left node is less than the value of the parent node, and the value of the right node is
 * greater than the value of the parent node.
 */

class Node {
    int data;
    Node leftChild;
    Node rightChild;

    public Node(int data) {
        this.data = data;
        leftChild = null;
        rightChild = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}

public class BinarySearchTree {
    //Variables
    private Node root;

    public static void main(String[] args) {

        BinarySearchTree bsT = new BinarySearchTree();
        bsT.insert(6);
        bsT.insert(4);
        bsT.insert(8);
        bsT.insert(5);
        bsT.insert(2);
        bsT.insert(8);
        bsT.insert(12);
        bsT.insert(10);
        bsT.insert(14);
        bsT.printTree(bsT.getRoot());

    }

    //Getter for Root
    public Node getRoot() {
        return root;
    }

    //Setter for root
    public void setRoot(Node root) {
        this.root = root;
    }

    //Recursive function to insert a value in BST
    public Node recursive_insert(Node currentNode, int value) {

        //Base Case
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.getData()) {
            //Iterate left sub-tree
            currentNode.setLeftChild(recursive_insert(currentNode.getLeftChild(), value));
        } else if (value > currentNode.getData()) {
            //Iterate right sub-tree
            currentNode.setRightChild(recursive_insert(currentNode.getRightChild(), value));
        } else {
            // value already exists
            return currentNode;
        }

        return currentNode;
    }

    //Function to call recursive insert
    public boolean insert(int value) {

        root = recursive_insert(this.root, value);
        return true;
    }

    //Function to check if Tree is empty or not
    public boolean isEmpty() {
        return root == null; //if root is null then it means Tree is empty
    }

    //Just for Testing purpose
    public void printTree(Node current) {

        if (current == null) return;

        System.out.print(current.getData() + ",");
        printTree(current.getLeftChild());
        printTree(current.getRightChild());

    }

    public int getSize() {
        return getSizeRecursive(this.root);
    }

    private int getSizeRecursive(Node current) {
        return current == null ? 0 : getSizeRecursive(current.getLeftChild()) + 1 + getSizeRecursive(current.getRightChild());
    }

    //Function to find an element in BST.
    public boolean containsNode(int value) {
        return containsNodeRecursive(this.root, value);
    }

    public boolean containsNodeRecursive(Node currentNode, int value) {
        if (currentNode == null) {
            return false;
        }
        if (value == currentNode.getData()) {
            return true;
        }
        return value < currentNode.getData() ? containsNodeRecursive(currentNode.getLeftChild(), value)
                : containsNodeRecursive(currentNode.getRightChild(), value);
    }

    //Function to delete an element in BST

    public void delete(int value) {
        setRoot(deleteRecursive(this.root, value));
    }

    public Node deleteRecursive(Node currentNode, int value) {
        if (currentNode == null) {
            return null;
        }
        if (value == currentNode.getData()) {
            // Case 1: no children
            if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
                return null;
            }

            // Case 2: only 1 child
            if (currentNode.getRightChild() == null) {
                return currentNode.getLeftChild();
            }

            if (currentNode.getLeftChild() == null) {
                return currentNode.getRightChild();
            }

            // Case 3: 2 children
            int smallestValue = findSmallestValue(currentNode.getRightChild());
            currentNode.setData(smallestValue);
            currentNode.setRightChild(deleteRecursive(currentNode.getRightChild(), smallestValue));
            return currentNode;
        }
        if (value < currentNode.getData()) {
            currentNode.setLeftChild(deleteRecursive(currentNode.getLeftChild(), value));
        }
        currentNode.setRightChild(deleteRecursive(currentNode.getRightChild(), value));
        return currentNode;
    }

    private int findSmallestValue(Node root) {
        return root.getLeftChild() == null ? root.getData() : findSmallestValue(root.getLeftChild());
    }

    //Depth First Search - Goes deep in every child before going to next sibling

    // 1. InOrder - LNR
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.getLeftChild());
            System.out.println(" " + node.getData());
            traverseInOrder(node.getRightChild());
        }
    }

    //InOrder Without Recursion
    public void traverseInOrderIteratively(Node node) {
        Stack<Node> stack = new Stack<>();
        Node current = node;
        stack.push(node);
        while (!stack.isEmpty()) {
            while (current.getLeftChild() != null) {
                current = current.getLeftChild();
                stack.push(current);
            }
            current = stack.pop();
            visit(current.getData());
            if (current.getRightChild() != null) {
                current = current.getRightChild();
                stack.push(current);
            }
        }
    }

    private void visit(int value) {
        System.out.print(" " + value);
    }

    // 2. PreOrder - NLR
    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.println(" " + node.getData());
            traversePreOrder(node.getLeftChild());
            traversePreOrder(node.getRightChild());
        }
    }

    public void traversePreOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            current = stack.pop();
            visit(current.getData());

            if (current.getRightChild() != null)
                stack.push(current.getRightChild());

            if (current.getLeftChild() != null)
                stack.push(current.getLeftChild());
        }
    }

    // 3. PostOrder - LRN
    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.getLeftChild());
            traversePostOrder(node.getRightChild());
            System.out.println(" " + node.getData());
        }
    }

    public void traversePostOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<>();
        Node prev = this.root;
        Node current;
        stack.push(this.root);

        while (!stack.isEmpty()) {
            current = stack.peek();
            boolean hasChild = (current.getLeftChild() != null || current.getRightChild() != null);
            boolean isPrevLastChild = (prev == current.getRightChild() ||
                    (prev == current.getLeftChild() && current.getRightChild() == null));

            if (!hasChild || isPrevLastChild) {
                current = stack.pop();
                visit(current.getData());
                prev = current;
            } else {
                if (current.getRightChild() != null) {
                    stack.push(current.getRightChild());
                }
                if (current.getLeftChild() != null) {
                    stack.push(current.getLeftChild());
                }
            }
        }
    }

    //Breadth First Search - Also called as Level Order Traversal
    // Visits all the nodes of a level before moving to next level.

    public void traverseLevelOrder(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(node);
        while (!nodes.isEmpty()) {
            Node current = nodes.remove();
            System.out.println(" " + current.getData());
            if (current.getLeftChild() != null) {
                nodes.add(current.getLeftChild());
            }
            if (current.getRightChild() != null) {
                nodes.add(current.getRightChild());
            }
        }
    }


}



