package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.arrays;

/*
 * Challenge 5 : Find Minimum Value in Array
 *
 * Given an array of size "n", can you find the minimum value in the array?
 *
 * author francesco giordano
 */
public class CheckMinimum {

    public static int findMinimum(int[] arr) {  // O(n)
        if (arr == null) {
            return 0;
        }

        int min = arr[0];
        for (final int j : arr) {
            if (j < min) {
                min = j;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 10};
        System.out.println(findMinimum(arr));
    }

}