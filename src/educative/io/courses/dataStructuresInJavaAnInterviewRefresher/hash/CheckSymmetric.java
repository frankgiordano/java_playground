package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.hash;

import java.util.HashMap;
import java.util.Map;

/*
Challenge 3: Find symmetric pairs in an Array

If you are given a two-dimensional array, can you find a symmetric pair in that array?
A solution is placed in the "solution" section to help you, but we would suggest you
try to solve it on your own first.

author: francesco giordano
*/
class CheckSymmetric {

    public static String findSymmetric(int[][] arr) {
        // time O(n) and same for space 
        String result = "";

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            int first = arr[i][0];
            int second = arr[i][1];

            if (map.containsKey(second) != false && map.get(second) == first) {
                result += "{"+second+","+first+"}";
            } else {
                map.put(first, second);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arr = { {1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5} };
        System.out.println(CheckSymmetric.findSymmetric(arr));
    }

}