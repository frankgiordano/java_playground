package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.trees;

public class Tests {

    public static void main(String[] args) {

        BinaryTree btree = new BinaryTree();
        btree.insert(1);
        btree.insert(2);
        btree.insert(3);
        btree.insert(4);
        btree.insert(5);
        btree.insert(10);
        btree.insert(8);

        System.out.println("Found 2 " + (btree.search(2).getData() == 2));
        System.out.println("Found 21 " + (btree.search(2).getData() == 21));
    }

}
