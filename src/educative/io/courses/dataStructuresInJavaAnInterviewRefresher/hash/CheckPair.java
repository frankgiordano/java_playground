package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.hash;

import java.util.HashMap;
import java.util.Map;

/*
Challenge 5: Find two pairs in an Array such that a+b = c+d

If you are given an array, can you find two pairs such that their sum is equal? 
A solution is placed in the "solution" section to help you, but we would suggest 
you try to solve it on your own first.

author: francesco giordano
*/
class CheckPair {

    public static String findPair(int[] arr) {
        // time O(n2)
        String result = "";

        Map<Integer, String> map = new HashMap<Integer, String>();

        for (int i = 0; i < arr.length; i++) {
            int first = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int second = arr[j];
                int sum = first + second;
                String value = "{" + first + "," + second + "}";
                if (!map.containsKey(sum)) {
                    map.put(sum, value);
                } else {
                    // current one and the one in the map
                    result += map.get(sum);
                    result += "," + value;
                    return result;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 1, 12, 9};
        System.out.println(CheckPair.findPair(arr));
    }

}