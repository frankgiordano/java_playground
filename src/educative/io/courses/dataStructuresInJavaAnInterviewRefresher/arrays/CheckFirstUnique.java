package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.arrays;

import java.util.HashMap;
import java.util.Map;

/* 
* Challenge 6: First Non-Repeating Integer in an Array
*
* Given an array, find the first integer which is unique in the array. 
* Unique means the number does not repeat and appears only once in the whole array. 
*
* author francesco giordano
*/
public class CheckFirstUnique {

    // brute force O(n^) time
    public static int findFirstUnique(int[] arr) {
        boolean isRepeat = false;

        for (int i = 0; i < arr.length; i++) {

            for (int k = 0; k < arr.length; k++) {

                if (arr[i] == arr[k] && i != k)
                    isRepeat = true;

            }

            if (isRepeat == false)
                return arr[i];

            isRepeat = false;
        }
        return -1;
    }

    // using java'a map interface..
    public static int findFirstUnique2(int[] arr) { // O(n) time

        Map<Integer, Integer> nums = new HashMap<Integer, Integer>();

        if (arr == null)
            return 0;

        int result = 0;

        for (int num : arr) {
            if (nums.containsKey(num)) {
                int count = nums.get(num);
                nums.put(num, ++count);
            } else {
                nums.put(num, 1);
            }
        }

        for (int num : arr) {
            int count = nums.get(num);
            if (count == 1)
                return num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 9, 2, 3, 2, 6, 6 };
        System.out.println(CheckFirstUnique.findFirstUnique(arr));
    }

}