package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.hash;

import java.util.HashSet;
import java.util.Set;

/*
Challenge 10: Find Two Numbers that Add up to "n"

Given an array and a number "n", find two numbers from the array that sums up to "n". Implement your
solution in Java and see if your output matches with the correct output.

author: francesco giordano
*/
public class CheckSum {

    public static int[] findSum(int[] arr, int n) {
        // Entire method run in O(n) + O(n) = O(2n) = O(n)
        // arr = 1, 2, 3, 4, 78, 99
        // n = 100
        // 100 - arr[0] 1 == 99, is 99 in arr ? yes
        // return arr[0] and 99 in hashset..

        if (arr == null)
            return null;

        int[] result = new int[2];
        Set<Integer> values = new HashSet<>();

        // O(n)
        for (int i = 0; i < arr.length; i++)
            values.add(arr[i]);

        // O(n)
        for (int i = 0; i < arr.length; i++) {
            int difference = n - arr[i];
            if (values.contains(difference)) {
                result[0] = arr[i];
                result[1] = difference;
                return result;
            }
        }

        return result;
    }

    public static int[] findSum2(int[] arr, int n) {
        // solution with one loop..
        if (arr == null)
            return null;

        int[] result = new int[2];
        Set<Integer> values = new HashSet<>();

        // O(n)
        for (int i = 0; i < arr.length; i++) {
            int difference = n - arr[i];
            if (values.contains(difference)) {
                result[0] = arr[i];
                result[1] = difference;
                return result;
            } else {
                values.add(arr[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4,78, 99, 98, 2 };
        arr = CheckSum.findSum(arr, 100);
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
        int[] arr2 = { 1, 2, 3, 4,78, 99, 98, 2 };
        arr2 = CheckSum.findSum2(arr2, 100);
        for (int i = 0; i < arr2.length; i++)
            System.out.println(arr2[i]);
    }

}
