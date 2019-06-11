package codingInterview.twoPointers;

public class PairWithTargetSum {
    public static int[] search(int[] arr, int targetSum) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if(arr[i] + arr[j] < targetSum) i++;
            else if(arr[i] + arr[j] > targetSum) j--;
            else return new int[]{i, j};
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
