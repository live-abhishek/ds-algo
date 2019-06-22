package dpInterview.knapsack;

import java.util.Arrays;

public class Knapsack {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
//        return knapsackDp(profits, weights, capacity);
//        return knapsackDpMemoryOptimized(profits, weights, capacity);
        return knapsackDpMemoryOptimizedBetter(profits, weights, capacity);
    }

    private int knapsackRecursive(int[] profits, int[] weights, int capacity){
        return -1;
    }

    private int knapsackDpTopDown(int[] profits, int[] weights, int capacity){
        return -1;
    }

    private int knapsackDp(int[] profits, int[] weights, int capacity){
        // basic choices
        if (capacity < 1 || profits.length == 0 || profits.length != weights.length) {
            return 0;
        }
        int n = weights.length;
        int[][] dp = new int[n][capacity + 1];

        for (int i = 0; i < weights.length; i++) {
            dp[i][0] = 0;
        }

        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c) {
                dp[0][c] = profits[0];
            }
        }

        for (int i = 1; i < weights.length; i++) {
            for (int c = 1; c <= capacity; c++) {
                int w = weights[i];
                if (w > c) {
                    dp[i][c] = dp[i-1][c];
                } else {
                    dp[i][c] = Integer.max(dp[i-1][c], dp[i-1][c - w] + profits[i]);
                }
            }
        }
        printValue(dp, weights, profits, capacity);
        return dp[weights.length - 1][capacity];
    }

    private int knapsackDpMemoryOptimized(int[] profits, int[] weights, int capacity){
        int[][] dp = new int[2][capacity + 1];
        dp[0][0] = dp[1][0] = 0;
        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c) {
                dp[0][c] =  profits[0];
            }
        }

        for (int i = 1; i < weights.length; i++) {
            for (int c = 1; c <= capacity; c++) {
                int w = weights[i];
                if (w > c) {
                    dp[i%2][c] = dp[(i-1)%2][c];
                } else {
                    dp[i%2][c] = Integer.max(dp[(i-1)%2][c], profits[i] + dp[(i-1)%2][c - w]);
                }
            }
        }
        return dp[(weights.length - 1)%2][capacity];
    }

    private int knapsackDpMemoryOptimizedBetter(int[] profits, int[] weights, int capacity){
        if (capacity < 0 || weights.length < 1 || profits.length != weights.length) {
            return -1;
        }

        int n = weights.length;
        int[] dp = new int[capacity + 1];
        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c) {
                dp[c] =  profits[0];
            }
        }
        for(int i = 1; i < n; i++) {
            for (int c = capacity; c > 0; c--) {
                int w = weights[i];
                if (w > c) {
                    dp[c] = dp[c];
                } else {
                    dp[c] = Integer.max(dp[c], profits[i] + dp[c - w]);
                }
            }
        }
        return dp[capacity];
    }

    private void printValue(int[][] dp, int[] weights, int[] profits, int capacity) {
        int wts = weights.length;
        int totalProfit = dp[wts - 1][capacity];
        for (int i = wts - 1; i > 0; i--) {
            if(totalProfit != dp[i-1][capacity]){
                System.out.print(" " + weights[i]);
                capacity -= weights[i];
                totalProfit -= profits[i];
            }
        }
        if(totalProfit != 0){
            System.out.print(" " + weights[0]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
