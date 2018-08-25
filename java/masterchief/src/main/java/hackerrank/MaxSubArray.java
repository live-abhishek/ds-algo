package hackerrank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MaxSubArray {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        sc = new Scanner(new FileInputStream(MaxSubArray.class.getClassLoader()
                .getResource("MaxSubArray/input.txt").getFile()));
        int t = sc.nextInt();
        IntStream.range(0, t).forEach(i -> solveTC());
        sc.close();
    }

    public static void solveTC(){
        int n = sc.nextInt();
        int[] array = IntStream.range(0, n).map(i -> sc.nextInt()).toArray();
        int maxSubSeqSum = maxSubSeqSum(array);
        int maxSubArraySum = maxSubArraySum(array);
        System.out.println(String.format("%d %d", maxSubArraySum, maxSubSeqSum));
    }

    public static int maxSubArraySum(int[] arr){
        int currentSum = arr[0];
        int maxSum = arr[0];
        for(int i = 1; i < arr.length; i++){
            currentSum = Integer.max(arr[i], currentSum+arr[i]);
            maxSum = Integer.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public static int maxSubSeqSum(int[] arr){
        int max = Arrays.stream(arr).max().getAsInt();
        if (max > 0) {
            return Arrays.stream(arr).filter(i -> i > 0).sum();
        } else {
            return max;
        }
    }
}
