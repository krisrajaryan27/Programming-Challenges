package com.nirvana.learning.educative.datastructures.trees;

public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(6);
        binarySearchTree.add(4);
        binarySearchTree.add(9);
        binarySearchTree.add(5);
        binarySearchTree.add(2);
        binarySearchTree.add(1);
        binarySearchTree.addRecursive(8);
        binarySearchTree.addRecursive(10);
        binarySearchTree.addRecursive(12);
        binarySearchTree.addRecursive(13);
        binarySearchTree.addRecursive(15);

        System.out.print("Tree : ");
        binarySearchTree.printTree(binarySearchTree.getRoot());

        System.out.println("\nSearching Node 17:");
        Node searchResult = binarySearchTree.search(17);
        if (searchResult != null) {
            System.out.println(searchResult.getData());
        }

        System.out.println("\nSearching Node 12:");
        Node recursiveSearchResult = binarySearchTree.recursiveSearch(binarySearchTree.getRoot(), 12);
        if (recursiveSearchResult != null) {
            System.out.println(recursiveSearchResult.getData());
        }

        System.out.print("\nDeleting Node 6: ");
        binarySearchTree.delete(6, binarySearchTree.getRoot());
        binarySearchTree.printTree(binarySearchTree.getRoot());

        System.out.print("\nDeleting Node 15: ");
        binarySearchTree.delete(15, binarySearchTree.getRoot());
        binarySearchTree.printTree(binarySearchTree.getRoot());

        System.out.print("\nDeleting Node 1: ");
        binarySearchTree.delete(1, binarySearchTree.getRoot());
        binarySearchTree.printTree(binarySearchTree.getRoot());

        System.out.print("\nPreOrder Traversal of BST: ");
        binarySearchTree.traversePreOrder(binarySearchTree.getRoot());

        System.out.print("\nInOrder Traversal of BST: ");
        binarySearchTree.traverseInOrder(binarySearchTree.getRoot());

        System.out.print("\nPostOrder Traversal of BST: ");
        binarySearchTree.traversePostOrder(binarySearchTree.getRoot());

    }
}

class BinarySearchTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //Iterative function to insert a value in BST
    //O(h) - h = height of the tree. worst case O(n) in skewed BST.
    public boolean add(int value) {
        //If Tree is empty then insert Root with the given value inside Tree
        if (isEmpty()) {
            root = new Node(value);
            return true;
        }
        //Starting from root
        Node currentNode = root;

        //Traversing the tree untill valid position to insert the value
        while (currentNode != null) {
            Node leftChild = currentNode.getLeftChild();
            Node rightChild = currentNode.getRightChild();

            //If the value to insert is less than root value then move to left subtree
            //else move to right subtree of root
            //and before moving check if the subtree is null, if it's then insert the value.
            if (currentNode.getData() > value) {
                if (leftChild == null) {
                    leftChild = new Node(value);
                    currentNode.setLeftChild(leftChild);
                    return true;
                }
                currentNode = leftChild;
            } else {
                if (rightChild == null) {
                    rightChild = new Node(value);
                    currentNode.setRightChild(rightChild);
                    return true;
                }
                currentNode = rightChild;
            } //end of else
        } // end of while
        return false;
    }

    public boolean addRecursive(int value) {
        root = recursiveInsert(this.root, value);
        return true;
    }

    //Recursive function for insertion in a BST
    public Node recursiveInsert(Node currentNode, int value) {
        //Base Case
        if (currentNode == null) {
            return new Node(value);
        }
        if (value < currentNode.getData()) {
            //Iterate left sub-tree
            currentNode.setLeftChild(recursiveInsert(currentNode.getLeftChild(), value));
        } else if (value > currentNode.getData()) {
            //Iterate right sub-tree
            currentNode.setRightChild(recursiveInsert(currentNode.getRightChild(), value));
        } else {
            // Value already exists
            return currentNode;
        }

        return currentNode;
    }

    //Searches value in BST
    //1. Iterative Search
    //Either returns the Node with that value or return null
    //O(log(n)) for avg case. Worst case - O(n) in skewed BST
    public Node search(int value) {
        if (isEmpty()) return null;
        Node currentNode = this.root;
        while (currentNode != null) {
            if (currentNode.getData() == value) {
                return currentNode;
            }
            if (currentNode.getData() > value) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
        }
        System.out.println(value + " Not found in the Tree!");
        return null;
    }

    //Recursive Search in BST
    public Node recursiveSearch(Node currentNode, int value) {
        //Base Condition
        // if node is null or value is found then return node
        if (currentNode == null || currentNode.getData() == value) {
            return currentNode;
        }
        // if value is greater than node's data then search left sub-tree
        if (currentNode.getData() > value) {
            return recursiveSearch(currentNode.getLeftChild(), value);
        }
        // if value is less than node's data then search right sub-tree
        return recursiveSearch(currentNode.getRightChild(), value);
    }

    //Deletion in BST - O(h), h = height of the BST
    //1.Node is leaf node.
    //2.Node has 1 child.
    //3.Node has 2 children.
    public boolean delete(int value, Node currentNode) {
        //if root is null
        if (root == null) {
            return false;
        }
        Node parent = null; //To Store parent of currentNode
        while (currentNode != null && (currentNode.getData() != value)) {
            parent = currentNode;
            if (currentNode.getData() > value)
                currentNode = currentNode.getLeftChild();
            else
                currentNode = currentNode.getRightChild();

        }
        if (currentNode == null) {
            return false;
        } else if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            //1. Node is Leaf Node i.e No child
            //if that leaf node is the root (a tree with just root)
            if (root.getData() == currentNode.getData()) {
                setRoot(null);
                return true;
            } else {
                assert parent != null;
                if (currentNode.getData() < parent.getData()) {
                    parent.setLeftChild(null);
                    return true;
                } else {
                    parent.setRightChild(null);
                    return true;
                }
            }
        } //2. If Node has 1 child
        // If right child is null i.e have only left child
        else if (currentNode.getRightChild() == null) {
            if (root.getData() == currentNode.getData()) {
                setRoot(currentNode.getLeftChild());
                return true;
            } else {
                assert parent != null;
                if (currentNode.getData() < parent.getData()) {
                    parent.setLeftChild(currentNode.getLeftChild());
                    return true;
                } else {
                    parent.setRightChild(currentNode.getLeftChild());
                    return true;
                }
            }
        }  // If left child if null i.e have only right child
        else if (currentNode.getLeftChild() == null) {
            if (root.getData() == currentNode.getData()) {
                setRoot(currentNode.getRightChild());
                return true;
            } else {
                assert parent != null;
                if (currentNode.getData() < parent.getData()) {
                    parent.setLeftChild(currentNode.getRightChild());
                    return true;
                } else {
                    parent.setRightChild(currentNode.getRightChild());
                    return true;
                }
            }
        }
        //3. If Node has 2 children
        else {
            //Find Least Value Node in right-subtree of current Node
            Node leastNode = findLeastNode(currentNode.getRightChild());
            //Set CurrentNode's Data to the least value in its right-subtree
            int temp = leastNode.getData();
            delete(temp, root);
            currentNode.setData(temp);
            //Delete the leafNode which had the least value
            return true;
        }
    }

    //Pre-Order Traversal in BST (NLR) - O(n)
    //Prints Level By Level Order, left child before right child
    public void traversePreOrder(Node root) {
        if (root == null) return;
        System.out.print(root.getData() + ",");
        traversePreOrder(root.getLeftChild());
        traversePreOrder(root.getRightChild());
    }

    //In-Order Traversal in BST (LNR) - O(n)
    //Prints in Increasing Way i.e Sorted Order
    public void traverseInOrder(Node root) {
        if (root == null) return;
        traverseInOrder(root.getLeftChild());
        System.out.print(root.getData() + ",");
        traverseInOrder(root.getRightChild());
    }

    //Post-Order Traversal in BST (LRN) - O(n)
    //Prints children node first before parent
    public void traversePostOrder(Node root) {
        if (root == null) return;
        traversePostOrder(root.getLeftChild());
        traversePostOrder(root.getRightChild());
        System.out.print(root.getData() + ",");
    }


    //Helper Function to find the least value Node in the right sub-tree of the currentNode
    private Node findLeastNode(Node currentNode) {
        Node temp = currentNode;
        while (temp.getLeftChild() != null) {
            temp = temp.getLeftChild();
        }
        return temp;
    }

    //Helper Function to check if Tree is empty or not
    public boolean isEmpty() {
        return root == null; //if root is null then it means Tree is empty
    }

    public void printTree(Node current) {
        if (current == null) return;
        System.out.print(current.getData() + ",");
        printTree(current.getLeftChild());
        printTree(current.getRightChild());
    }
}

class Node {
    private int data;
    private Node leftChild;
    private Node rightChild;

    public Node(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
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
