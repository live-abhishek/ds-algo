package hackerrank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BricksGame {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        sc = new Scanner(new FileInputStream(BricksGame.class.getClassLoader()
                .getResource("BricksGame/input.txt").getFile()));
        int n = sc.nextInt();
        IntStream.range(0, n).forEach(i -> solveTC());
        sc.close();
    }

    private static void solveTC(){
        int n = sc.nextInt();
        int[] arr = IntStream.range(0, n).map(i -> sc.nextInt()).toArray();
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = arr[1] + dp[0];
        dp[2] = arr[2] + dp[1];
        IntStream.range(3, n).forEach(i -> {
            dp[i] = getMax(
                    getMin(getDP(i-2, arr), getDP(i-3, arr), getDP(i-4, arr)),
                    getMin(getDP(i-3, arr), getDP(i-4, arr), getDP(i-5, arr)),
                    getMin(getDP(i-4, arr), getDP(i-5, arr), getDP(i-6, arr))
            );
        });
        System.out.println(dp[n-1]);
    }

    private static int getMax(int a, int b, int c){
        return Integer.max(a , Integer.max(b, c));
    }

    private static int getMin(int a, int b, int c){
        return Integer.min(a, Integer.min(b, c));
    }

    private static int getDP(int i, int[] arr){
        return i >= 0 ? arr[i] : 0;
    }


}
