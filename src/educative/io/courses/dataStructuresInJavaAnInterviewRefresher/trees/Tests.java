package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.trees;

public class Tests {

    public static void main(String[] args) {

        BinaryTree btree = new BinaryTree();
        btree.insert(6);
        btree.insert(4);
        btree.insert(2);
        btree.insert(5);
        btree.insert(9);
        btree.insert(8);
        btree.insert(12);

        System.out.println("Found 2 " +
                (btree.search(2) != null ? (btree.search(2).getData() == 2) : "false"));
        System.out.println("Found 21 " +
                (btree.search(21) != null ? (btree.search(21).getData() == 21) : "false"));
        btree.printTree(btree.getRoot());
        System.out.println();
        btree.inTraverse(btree.getRoot());
        System.out.println();
        btree.postTraverse(btree.getRoot());
    }

}
