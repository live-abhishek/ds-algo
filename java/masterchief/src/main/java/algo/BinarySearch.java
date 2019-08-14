package algo;

import java.util.Arrays;

public class BinarySearch {
    public static int lowerBound(int[] arr, int key){
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (key <= arr[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static int upperBound(int[] arr, int key) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (key < arr[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 4, 4, 5, 5, 8, 9};
        System.out.println("Actual array is: " + Arrays.toString(arr));
        System.out.println("Searching for 3 - lowerBound  : " + lowerBound(arr, 3));
        System.out.println("Searching for 3 - in-built    : " + Arrays.binarySearch(arr, 3));
        System.out.println("Searching for 3 - lowerBound+1: " + lowerBound(arr, 3+1));
        System.out.println("Searching for 3 - upperBound  : " + upperBound(arr, 3));
        System.out.println("Searching for 4 - lowerBound  : " + lowerBound(arr, 4));
        System.out.println("Searching for 4 - in-built    : " + Arrays.binarySearch(arr, 4));
        System.out.println("Searching for 4 - lowerBound+1: " + lowerBound(arr, 4+1));
        System.out.println("Searching for 4 - upperBound  : " + upperBound(arr, 4));
        System.out.println("Searching for 6 - lowerBound  : " + lowerBound(arr, 6));
        System.out.println("Searching for 6 - in-built    : " + Arrays.binarySearch(arr, 6));
        System.out.println("Searching for 6 - lowerBound+1: " + lowerBound(arr, 6+1));
        System.out.println("Searching for 6 - upperBound  : " + upperBound(arr, 6));
        arr = new int[]{0, 1, 2, 3};
        System.out.println(lowerBound(arr, 2));
    }
}
