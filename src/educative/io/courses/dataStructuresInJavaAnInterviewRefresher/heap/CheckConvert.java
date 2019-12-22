package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.heap;

import java.util.Arrays;

/*
Challenge 1: Convert a Max-Heap to a Min-Heap
If you are given a Max Heap, can you convert it into a Min Heap?

author: francesco giordano
*/
public class CheckConvert {

    public static String convertMax(int[] maxHeap) {
        String result = "";

        CheckConvert.buildMinHeap(maxHeap);
        result = Arrays.toString(maxHeap).replaceAll("\\s", "");

        return result;
    }

    public static void buildMinHeap(int[] arr) {
        int size = arr.length;

        for (int i = (size - 1) / 2; i >= 0; i--) {
            CheckConvert.minHeapify(arr, i, size);
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

        System.out.println("Max heap = " + Arrays.toString(heapArray));
        System.out.println("Convert min heap = " + CheckConvert.convertMax(heapArray));
    }

}