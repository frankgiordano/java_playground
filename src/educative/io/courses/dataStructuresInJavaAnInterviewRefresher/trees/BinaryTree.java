package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.trees;

public class BinaryTree {

    private Node root;

    public BinaryTree() {
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

    private boolean isEmpty() {
        return this.root == null;
    }

}
