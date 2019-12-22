package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.arrays;

/*
* Challenge 10: Rearrange Sorted Array in Max/Min Form
*
* Arrange elements in such a way that the maximum element appears at first, then minimum at second, 
* then second maximum at the third position and second minimum at fourth and so on.
*
* author francesco giordano 
*/
class CheckMaxMin {

    /*
     * using a odd and even technique
     */
    public static void minMax(int[] arr) {
        // time O(n), space O(n)
        int[] result = new int[arr.length];
        int start = 0;
        int end = arr.length - 1;
        int index = 0;

        while (start != end) {
            if (index == 0) { // edge case handle first as even number use end pointer
                result[index] = arr[end];
                index++;
                end--;
            } else if (index % 2 != 0) { // odd number use start pointer
                result[index] = arr[start];
                index++;
                start++;
            } else { // even number use end pointer
                result[index] = arr[end];
                index++;
                end--;
            }
        }

        result[index] = arr[start];

        for (int i = 0; i < arr.length; i++)
            arr[i] = result[i];
    }

    public static void maxMin(int[] arr) {
        // time O(n), space O(n)
        if (arr == null)
            return;

        int size = arr.length;

        int[] result = new int[size];

        int indexResult = 0;
        for (int i = 0, j = size - 1; i < j; i++, j--) {
            result[indexResult] = arr[j];
            result[indexResult + 1] = arr[i];
            indexResult = indexResult + 2;
        }

        for (int i = 0; i < size; i++) {
            arr[i] = result[i];
        }
    }

    public static void maxMin2(int[] arr) {
        // time O(n), space O(n)
        if (arr == null)
            return;

        int size = arr.length;

        int[] result = new int[size];

        int i = 0;
        int start = 0;
        int end = size - 1;
        boolean switcher = true;

        while (start <= end) {
            if (switcher) {
                result[i++] = arr[end--];
                switcher = false;
            } else {
                result[i++] = arr[start++];
                switcher = true;
            }
        }

        for (int k = 0; k < size; k++) {
            arr[k] = result[k];
        }
    }

    public static void maxMin3(int[] arr) {
        // time O(n) space O(1)
        // author educative.io
        int maxIdx = arr.length - 1;
        int minIdx = 0;
        int maxElem = arr[maxIdx] + 1; // store maximum element of array
        for (int i = 0; i < arr.length; i++) {
            // at even indices we will store maximum elements
            if (i % 2 == 0) {
                arr[i] += (arr[maxIdx] % maxElem) * maxElem;
                maxIdx -= 1;
            } else { // at odd indices we will store minimum elements
                arr[i] += (arr[minIdx] % maxElem) * maxElem;
                minIdx += 1;
            }
        }
        // dividing with maxElem to get original values.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / maxElem;
        }
    }

    public static void main(String args[]) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 8, 10 };
        CheckMaxMin.maxMin(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int[] arr2 = { 1, 2, 3, 4, 5, 6, 8, 10 };
        CheckMaxMin.maxMin(arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        int[] arr3 = { 1, 2, 3, 4, 5, 6, 8, 10 };
        CheckMaxMin.maxMin2(arr3);
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
        System.out.println();
        int[] arr4 = { 1, 2, 3, 4, 5 };
        CheckMaxMin.maxMin3(arr4);
        for (int i = 0; i < arr4.length; i++) {
            System.out.print(arr4[i] + " ");
        }
    }

}