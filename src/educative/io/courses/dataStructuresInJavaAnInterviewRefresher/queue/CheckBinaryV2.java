package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Generate Binary Numbers from 1 to n using a Queue
 * <p>
 * auther: francesco giordano
 */
public class CheckBinaryV2 {

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
        CheckBinaryV2 find = new CheckBinaryV2();

        String[] result = find.findBin(3);

        for (String s : result)
            System.out.println(s);

        result = find.findBin(5);

        System.out.println();

        for (String s : result)
            System.out.println(s);
    }
}

