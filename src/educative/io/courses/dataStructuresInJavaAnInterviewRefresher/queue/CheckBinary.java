package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.queue;

/**
 * Generate Binary Numbers from 1 to n using a Queue
 * <p>
 * auther: francesco giordano
 */
public class CheckBinary {

    public String[] findBin(int number) {
        myQueue queue = new myQueue(5);
        String[] result = new String[number];

        queue.enqueue(Integer.parseInt("1"));
        for (int i = 0; i < number; i++) {

            String bin = Integer.toString(queue.dequeue());
            result[i] = bin;

            if (queue.size() != number)
                queue.enqueue(Integer.parseInt(bin + "0"));
            if (queue.size() != number)
                queue.enqueue(Integer.parseInt(bin + "1"));
        }

        return result;
    }

    public static void main(String[] args) {
        CheckBinary find = new CheckBinary();

        String[] result = find.findBin(3);

        for (String s : result)
            System.out.println(s);

        result = find.findBin(5);

        System.out.println();

        for (String s : result)
            System.out.println(s);
    }

}