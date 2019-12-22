package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.hash;

import java.util.ArrayList;

class HashTable {
    private ArrayList<HashEntry> bucket;
    private int slots;
    private int size;

    public HashTable() {
        bucket = new ArrayList<>();
        slots = 10;
        size = 0;

        for (int i = 0; i < slots; i++)
            bucket.add(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int getIndex(String key) {

        int hashCode = key.hashCode();
        int index = hashCode % slots;

        return index;
    }

    public void insert(String key, int value) {

        int index = getIndex(key);
        HashEntry head = bucket.get(index);

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = bucket.get(index);
        HashEntry new_slot = new HashEntry(key, value);
        new_slot.next = head;
        bucket.set(index, new_slot);

        if ((1.0 * size) / slots >= 0.6) {
            ArrayList<HashEntry> temp = bucket;
            bucket = new ArrayList<>();
            slots = 2 * slots;
            size = 0;
            for (int i = 0; i < slots; i++)
                bucket.add(null);

            for (HashEntry head_Node : temp) {
                while (head != null) {
                    insert(head_Node.key, head_Node.value);
                    head_Node = head_Node.next;
                }
            }
        }
    }

    public int delete(String key) {

        // Look for the index based on key
        int b_Index = getIndex(key);

        HashEntry head = bucket.get(b_Index);

        // Search the key in slots
        HashEntry prev = null;
        while (head != null) {
            // If the key exists
            if (head.key.equals(key))
                break;

            // If the key not found yet
            prev = head;
            head = head.next;
        }

        // If the key does not exist
        if (head == null)
            return 0;

        size--;

        // Delete the value by key
        if (prev != null)
            prev.next = head.next;
        else
            bucket.set(b_Index, head.next);

        return head.value;
    }

    public int getValue(String key) {
        int index = getIndex(key);
        HashEntry head = this.bucket.get(index);

        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }

        return 0;
    }

    public static void main(String[] args) {
        HashTable table = new HashTable(); // Create a HashTable
        // Before Insertion
        System.out.println("Table Size = " + table.size());
        table.insert("This", 1); // Key-Value Pair
        table.insert("is", 2);
        table.insert("a", 3);
        table.insert("Test", 4);
        table.insert("Driver", 5);
        System.out.println("Table Size = " + table.size());
        // first search the key then delete it in the table
        // see the implementation first
        System.out.println(table.delete("is") + " : This key is deleted from table");
        System.out.println("Now Size of the table = " + table.size());
        if (table.isEmpty())
            System.out.println("Table is Empty");
        else
            System.out.println("Table is not Empty");
    }
}