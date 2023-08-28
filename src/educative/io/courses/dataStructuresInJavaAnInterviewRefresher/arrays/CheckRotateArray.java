package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.arrays;

/*
 * Challenge 8: Right Rotate the Array by One Index
 *
 * Given an array, can you rotate its elements by one index from right to left?
 *
 * author francesco giordano
 */
public class CheckRotateArray {

    public static void rotateArray(int[] arr) {
        int temp = arr[arr.length - 1];

        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        CheckRotateArray.rotateArray(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}