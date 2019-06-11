package codingInterview.twoPointers;

import java.util.Arrays;

public class RemoveDuplicates {
    public static int remove(int[] arr) {
        int i = 1, j = 1;
        int count = 1;
        while (j < arr.length) {
            if (arr[j] != arr[j-1]) {
                arr[i] = arr[j];
                i++;
                count++;
            }
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(RemoveDuplicates.remove(arr));
        System.out.println(Arrays.toString(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(RemoveDuplicates.remove(arr));
        System.out.println(Arrays.toString(arr));
    }
}
