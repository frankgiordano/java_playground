package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.stack;

/**
 * Next Greater Element
 * 
 * Implement nextGreaterElement() to find the next greater element of each element of an array.
 * 
 * The following methods below provide a brute force implementation taking O(n*n) time, one using
 * a while loop and the other using inner for loops.
 * 
 * author Francesco Giordano
 */
public class CheckNGE {

    public static int[] nextGreaterElement (int[] arr) {

        int arrSize = arr.length;
        int[] result = new int[arrSize];
        int current = arr[0];
        int next = arr[1];

        int i = 0;   // for result
        int j = 0;   // for current
        int k = 1;   // for next
        while (i < arrSize) {
            
            if (current < next) {
                result[i++] = next;
                current = arr[++j];
            } else {
                if (k == arrSize-1) {
                    result[i++] = -1;
                    if (j == arrSize-1)
                        continue;
                    current = arr[++j];
                } else {
                    next = arr[++k];
                }         
            }
        }

        return result;
    }

    public static int[] nextGreaterElement2 (int[] arr) {

        int arrSize = arr.length;
        int[] result = new int[arrSize];
        int current;
        int next;

        // for loop for current
        for (int i = 0; i < arrSize; i++) {
            current = arr[i];
            // for loop for finding and setting next
            for (int j = i+1; j <= arrSize; j++) {
                if (j == arrSize) {
                    result[i] = -1;
                    break;
                }
                next = arr[j];
                if (current < next) {
                    result[i] = next;
                    break;
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4,6,3,2,8,1};
        int[] result = CheckNGE.nextGreaterElement(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " --> " + result[i]);
        } 
        System.out.println("");
        result = CheckNGE.nextGreaterElement2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " --> " + result[i]);
        } 
    }

}

