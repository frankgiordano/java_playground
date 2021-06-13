package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.trees;
public class BinaryTree {

    private Node root;

    public BinaryTree() {
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean insert(int value) {
        if (isEmpty()) {
            this.root = new Node(value);
            return true;
        }

        Node currNode = this.root;
        while (currNode != null) {
            if (currNode.getData() > value) {

                if (currNode.getLeftChild() == null) {
                    currNode.setLeftChild(new Node(value));
                    return true;
                }
                currNode = currNode.getLeftChild();

            } else {
                if (currNode.getRightChild() == null) {
                    currNode.setRightChild(new Node(value));
                    return true;
                }
                currNode = currNode.getRightChild();
            }
        }

        return false;
    }

    public Node insertByRecursion(int value) {
        return insertByRecursion(this.root, value);
    }

    private Node insertByRecursion(Node currNode, int value) {
        if (currNode == null) {
            return new Node(value);
        }

        if (value > currNode.getData()) {
            currNode.setRightChild(insertByRecursion(currNode.getRightChild(), value));
        } else if (value < currNode.getData()) {
            currNode.setLeftChild(insertByRecursion(currNode.getLeftChild(), value));
        } else {
            return currNode;
        }

        return currNode;
    }

    public Node search(int value) {
        if (isEmpty())
            return null;

        Node currNode = this.root;

        while (currNode != null) {
            if (currNode.getData() == value)
                return currNode;

            if (currNode.getData() > value)
                currNode = currNode.getLeftChild();
            else {
                currNode = currNode.getRightChild();
            }
        }

        return null;
    }

    public Node searchByRecursion(int value) {
        if (isEmpty())
            return null;
        return searchByRecursion(this.root, value);
    }

    private Node searchByRecursion(Node currNode, int value) {

        if (currNode.getData() == value)
            return currNode;

        if (value > currNode.getData()) {
            return searchByRecursion(currNode.getRightChild(), value);
        } else {
            return searchByRecursion(currNode.getLeftChild(), value);
        }
    }

    public boolean delete(int value) {
        return delete(value, this.root);
    }

    private boolean delete(int value, Node currNode) {
        if (isEmpty())
            return false;

        Node parent = null;  // to store parent of currNode
        while (currNode != null && (currNode.getData() != value)) {
            parent = currNode;
            if (value > currNode.getData())
                currNode = currNode.getRightChild();
            else
                currNode = currNode.getLeftChild();
        }

        if (currNode == null) {
            return false;
        } else if (currNode.getLeftChild() == null && currNode.getRightChild() == null) {
            // 1. Node is a Leaf Node
            // if that leaf node is the root (a tree with just a root)
            if (root.getData() == currNode.getData()) {
                setRoot(null);
                return true;
            } else if (currNode.getData() < parent.getData()) {
                parent.setLeftChild(null);
                return true;
            } else {
                parent.setRightChild(null);
                return true;
            }
        } else if (currNode.getRightChild() == null) {
            if (root.getData() == currNode.getData()) {
                setRoot(currNode.getLeftChild());
                return true;
            } else if (currNode.getData() < parent.getData()) {
                parent.setLeftChild(currNode.getLeftChild());
                return true;
            } else {
                parent.setRightChild(currNode.getLeftChild());
                return true;
            }
        } else if (currNode.getLeftChild() == null) {
            if (root.getData() == currNode.getData()) {
                setRoot(currNode.getRightChild());
                return true;
            } else if (currNode.getData() < parent.getData()) {
                parent.setLeftChild(currNode.getRightChild());
                return true;
            } else {
                parent.setRightChild(currNode.getRightChild());
                return true;
            }
        } else {
            //Find Least Value Node in right-subtree of current Node
            Node leastNode = findLeastNode(currNode.getRightChild());
            //Set CurrentNode's Data to the least value in its right-subtree
            int temp = leastNode.getData();
            delete(temp, root);
            currNode.setData(temp);
            //Delete the leafNode which had the least value
            return true;
        }

    }

    // Helper function to find least value node in right-subtree of currentNode
    private Node findLeastNode(Node currNode) {
        Node temp = currNode;

        while (temp.getLeftChild() != null) {
            temp = temp.getLeftChild();
        }

        return temp;
    }

    //Iterative Function to insert a value in BST
    public boolean add(int value) {

        //If Tree is empty then insert Root with the given value inside Tree
        if (isEmpty()) {
            root = new Node(value);
            return true;
        }

        //Starting from root
        Node currNode = root;

        //Traversing the tree untill valid position to insert the value
        while (currNode != null) {

            Node leftChild = currNode.getLeftChild();
            Node rightChild = currNode.getRightChild();

            //If the value to insert is less than root value
            //then move to left subtree else move to right subtree of root
            //and before moving check if the subtree is null, if it's then insert the value.

            if (currNode.getData() > value) {
                if (leftChild == null) {
                    leftChild = new Node(value);
                    currNode.setLeftChild(leftChild);
                    return true;
                }
                currNode = leftChild;
            } else {
                if (rightChild == null) {
                    rightChild = new Node(value);
                    currNode.setRightChild(rightChild);
                    return true;
                }
                currNode = rightChild;
            } //end of else
        } //end of while
        return false;
    }

    //Function to check if Tree is empty or not
    public boolean isEmpty() {
        return root == null; //if root is null then it means Tree is empty
    }

    //Just for Testing purpose - pre-order Traversal
    public void printTree(Node currNode) {
        if (currNode == null)
            return;

        System.out.print(currNode.getData() + ",");
        printTree(currNode.getLeftChild());
        printTree(currNode.getRightChild());
    }

    public void inTraverse(Node root) {
        if (root == null)
            return;

        inTraverse(root.getLeftChild());
        System.out.print(root.getData() + ",");
        inTraverse(root.getRightChild());

    }

    public void postTraverse(Node root) {
        if (root == null)
            return;

        postTraverse(root.getLeftChild());
        postTraverse(root.getRightChild());
        System.out.print(root.getData() + ",");

    }

}
