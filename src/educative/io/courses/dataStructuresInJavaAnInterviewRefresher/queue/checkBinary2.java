package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.queue;

import java.util.*;

/**
 * Generate Binary Numbers from 1 to n using a Queue
 * 
 * auther: francesco giordano
 */
class checkBinary2 {

    public String[] findBin(int number) {
        Queue<Integer> queue = new LinkedList<Integer>();
        String[] result = new String[number];

        queue.add(Integer.parseInt("1"));
        for (int i = 0; i < number; i++) {

            String bin = Integer.toString(queue.remove());
            result[i] = bin;

            if (queue.size() != number)
                queue.add(Integer.parseInt(bin + "0"));
            if (queue.size() != number)
                queue.add(Integer.parseInt(bin + "1"));
        }

        return result;
    }

    public static void main(String[] args) {

        checkBinary find = new checkBinary();

        String[] result = find.findBin(3);

        for (String s : result)
            System.out.println(s);

        result = find.findBin(5);

        System.out.println();

        for (String s : result)
            System.out.println(s);
    }
}

