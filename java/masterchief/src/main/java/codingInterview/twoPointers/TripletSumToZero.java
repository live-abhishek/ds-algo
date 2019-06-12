package codingInterview.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            List<List<Integer>> lists = searchPair(arr, i);
            if (!lists.isEmpty()) {
                triplets.addAll(lists);
            }
        }
        return triplets;
    }

    public static List<List<Integer>> searchPair(int[] arr, int firstPos) {
        List<List<Integer>> triplets = new ArrayList<>();
        int secondPos = firstPos + 1, thirdPos = arr.length - 1;
        int remainder = -arr[firstPos];
        while (secondPos < thirdPos) {
            int newSum = arr[secondPos] + arr[thirdPos];
            if(newSum > remainder) thirdPos--;
            else if(newSum < remainder) secondPos++;
            else {
                triplets.add(Arrays.asList(arr[firstPos], arr[secondPos], arr[thirdPos]));
                secondPos++;
                thirdPos--;
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }
}
