package hackerearth.capillary_18_10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.LongStream;

public class MaximumSum {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {
        sc = new Scanner(new FileInputStream(MaximumSum.class.getClassLoader()
                .getResource("hackerearth/capillary-18-10/MaximumSum.txt").getFile()));
            int n = sc.nextInt();
        long[] arr = LongStream.range(0, n).map(i -> sc.nextLong()).toArray();
        long ans = calc(n, arr);
        System.out.println(ans);
    }

    private static long calc(int n, long[] arr) {
        // s = start index
        // e = end index (used in inner loop)
        Set<Long> uniques = new HashSet<>();
        for(int s = 0; s < arr.length; s++){
            // for each sub array starting from i
            // calculate the max sub array sum
            // in sub array between index s & e
            // and then add that max sub array sum to uniques
            long maxSum = arr[s];
            long currSum = arr[s];
            uniques.add(maxSum);
            for(int e = s+1; e < arr.length; e++){ // e = end index
                currSum = Long.max(arr[e], currSum+arr[e]);
                maxSum = Long.max(maxSum, currSum);
                uniques.add(maxSum);
            }
        }
        return uniques.stream().mapToLong(i -> i).sum();
    }
}
