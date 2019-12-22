package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.arrays;

import java.util.HashSet;
import java.util.Set;

/*
* Challenge 3: Find Two Numbers that Add up to "n"
* 
* Given an array and a number "n", find two numbers from the array that sums up to "n". 
* 
* author: francesco giordano
*/
public class CheckSum {

    public static int[] findSum(int[] arr, int n) { // n + n = O(n)

        if (arr == null)
            return null;

        int[] result = new int[2];
        Set<Integer> values = new HashSet<Integer>();

        for (int i = 0; i < arr.length; i++) {   // O(n)
            values.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {   // O(n)
            int value = n - arr[i];
            if (values.contains(value)) {  
                result[0] = arr[i];
                result[1] = value;
                return result;
            }

        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 21, 3, 14, 5, 60, 7, 6};
        arr = CheckSum.findSum(arr, 27);
        for (int num: arr) {
            System.out.print(num + " ");
        }

    }

}
