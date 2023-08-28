package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.arrays;

/*
 * Challenge 3: Find Two Numbers that Add up to "n"
 *
 * Given an array and a number "n", find two numbers from the array that sums up to "n".
 *
 * author: francesco giordano
 */
public class CheckSum {

    public static int[] findSum(int[] arr, int n) {
        // brute force O(n2)
        // arr = 1, 2, 3, 4, 78, 99
        // n = 100
        // 100 - 1 = 99 check for 99 in arr in outer loop
        // if found then arr[i] and arr[j] added to result and return
        if (arr == null) {
            return null;
        }

        int[] result = new int[2];

        for (final int k : arr) {
            int difference = n - k;
            for (final int i : arr) {
                if (difference == i) {
                    result[0] = k;
                    result[1] = i;
                    return result;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 21, 3, 14, 5, 60, 7, 6};
        arr = CheckSum.findSum(arr, 27);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
