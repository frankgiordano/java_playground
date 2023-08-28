package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.hash;

import java.util.HashMap;
import java.util.Map;

/*
Challenge 6: Find if a subarray with a sum equal to 0 exists

Given an array with positive and negative integers, can you extract 
a sub-array from it which adds up to zero? A solution is placed in the 
"solution" section to help you, but we would suggest you try to solve 
it on your own first.

author: francesco giordano
*/
public class CheckSubZero {

    // author edacuative.io
    public static boolean findSubZero(int[] arr) {
        // time O(n), space O(1)
        //Use HashMap to store Sum as key and index i as value till sum has been calculated.
        //Traverse the array and return true if either 
        //arr[i] == 0 or sum == 0 or HashMap already contains the sum
        //If you completely traverse the array and havent found any of the above three
        //conditions then simply return false.
        HashMap<Integer, Integer> hMap = new HashMap<>();

        int sum = 0;

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (arr[i] == 0 || sum == 0 || hMap.get(sum) != null)
                return true;

            hMap.put(sum, i);
        }

        return false;
    }

    public static boolean findSubZero2(int[] arr) {
        // time O(n), space O(1)
        Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();

        int index = 0;
        int sum = 0;
        while (index < arr.length) {
            sum += arr[index];

            if (arr[index] == 0 || sum == 0 || sumMap.containsKey(sum))
                return true;

            sumMap.put(sum, index);

            index++;
        }

        return false;
    }

    public static boolean findSubZero3(int[] arr) {
        // time O(n2), space O(1)
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {

                sum += arr[j];

                if (sum == 0)
                    return true;

            }
            sum = 0;
        }

        return false;
    }

    public static void main(String args[]) {

        int[] arr = {6, 4, -7, 3, 12, 9};
        System.out.println(findSubZero(arr));
        System.out.println(findSubZero2(arr));
        System.out.println(findSubZero3(arr));
        int[] arr2 = {6, 4, -7};
        System.out.println(findSubZero3(arr2));

    }

}