package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.stack;

/**
 * Next Greater Element
 * 
 * Implement nextGreaterElement() to find the next greater element of each element of an array.
 * 
 * Solution uses a stack implemention.
 * 
 */
public class checkNGE3 {

    public static int[] nextGreaterElement(int[] arr) {
        myStack s = new myStack(arr.length);
        int[] result = new int[arr.length];
        int resultIndex = 0;
        int next;

        for (int i = 0; i < arr.length; i++) {

            next = arr[i];

            if (s.top() == -1) 
                s.push(next);
            else {
                while (s.top() != -1 && s.top() < next) {
                    s.pop();
                    result[resultIndex++] = next;
                }
                s.push(next);
            }
        }

        while (!s.isEmpty()) {
            s.pop();
            result[resultIndex++] = -1;
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