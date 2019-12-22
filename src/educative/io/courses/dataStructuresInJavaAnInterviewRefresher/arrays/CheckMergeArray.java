package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.arrays;

/*
* Challenge 2 : Merge Two Sorted Arrays
*
* Given two sorted arrays, merge them into one array which should also be sorted.
*
* author: francesco giordano
*/
public class CheckMergeArray {

    public static int[] mergeArrays(int[] arr1, int[] arr2) {

        if (arr1 == null || arr2 == null)
            return null;

        int[] result = new int[arr1.length + arr2.length];

        int indexArr1 = 0;
        int indexArr2 = 0;
        int resultIndex = 0;

        while (indexArr1 < arr1.length && indexArr2 < arr2.length) {
            if (arr1[indexArr1] < arr2[indexArr2]) {
                result[resultIndex] = arr1[indexArr1];
                indexArr1++;
                resultIndex++;
            }
            else {
                result[resultIndex] = arr2[indexArr2];
                indexArr2++;
                resultIndex++;
            }
        }

        while (indexArr2 < arr2.length) {
            result[resultIndex] = arr2[indexArr2];
            resultIndex++;
            indexArr2++;
        }

        while (indexArr1 < arr1.length) {
            result[resultIndex] = arr2[indexArr1];
            resultIndex++;
            indexArr1++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5};
        int[] arr2 = {2, 6, 7, 8};
        int[] result;

        result = CheckMergeArray.mergeArrays(arr1, arr2);
        for (int num: result) 
            System.out.println(num);
    }

}