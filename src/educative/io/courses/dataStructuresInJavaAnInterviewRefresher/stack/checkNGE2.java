package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.stack;

/**
 * Next Greater Element
 * 
 * Implement nextGreaterElement() to find the next greater element of each element of an array.
 * 
 * Solution uses a stack implemention.
 * 
 */
public class checkNGE2 {

    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        int resultIndex = 0;
        myStack s = new myStack(arr.length);
        int element;
        int next;

        s.push(arr[0]);

        for (int i = 0; i < arr.length; i++) {
            next = arr[i];

            if (!s.isEmpty()) {

                element = s.pop();

                while (element < next) {
                    // System.out.println(element + " --> " + next);
                    result[resultIndex++] = next;
                    if (s.isEmpty())
                        break;
                    element = s.pop();
                }

                if (element > next)
                    s.push(element);
            }

            s.push(next);
        }

        while (!s.isEmpty()) {
            element = s.pop();
            next = -1;
            // System.out.println(element + " --> " + next);
            result[resultIndex++] = next;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4,6,3,2,8,1};
        int[] result = nextGreaterElement(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " --> " + result[i]);
        } 
    }
}