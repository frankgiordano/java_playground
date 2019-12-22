package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.heap;

import java.util.Arrays;

/*
Challenge 2: Find the k Smallest Elements in an Array
If you are given an array and any number "k", can you write a code to find 
the "k" smallest elements using a Min Heap?

author: francesco giordano
*/
public class CheckSmall {

    public static int[] findKSmallest(int[] arr, int k) {
        int size = arr.length;

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = CheckSmall.removeMin(arr, size--);
        }

        return result;
    }

    private static int removeMin(int[] arr, int size) {
        CheckSmall.buildMinHeap(arr, size);
        int result = arr[0];
        arr[0] = arr[size - 1];
        return result;
    }

    private static void buildMinHeap(int[] arr, int size) {
        for (int i = (size - 1) / 2; i >= 0; i--) {
            CheckSmall.minHeapify(arr, i, size);
        }
    }

    private static void minHeapify(int[] heapArr, int index, int heapSize) {
        int min = index;

        while (min < (heapSize) / 2) {
            int left = (2 * index) + 1;
            int right = (2 * index) + 2;

            if (left < heapSize && heapArr[left] < heapArr[min])
                min = left;

            if (right < heapSize && heapArr[right] < heapArr[min])
                min = right;

            if (min != index) {
                int tmp = heapArr[index];
                heapArr[index] = heapArr[min];
                heapArr[min] = tmp;
                index = min;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {

        int[] heapArray = { 56, 12, 9, 8, 7, 4, 3, 2, 1 };
        int[] heapArray2 = { 9, 4, 7, 1, -2, 6, 5 };

        System.out.println("Array = " + Arrays.toString(heapArray));
        int[] result = CheckSmall.findKSmallest(heapArray, 3);
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
        System.out.println();
        System.out.println("Array = " + Arrays.toString(heapArray2));
        int[] result2 = CheckSmall.findKSmallest(heapArray2, 3);
        for (int i = 0; i < result2.length; i++)
            System.out.println(result2[i]);
    }

}