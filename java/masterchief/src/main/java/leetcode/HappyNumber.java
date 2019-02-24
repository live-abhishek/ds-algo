package leetcode;

import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            n = getSumOfSquareOfDigits(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    private int getSumOfSquareOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            int d = num % 10;
            sum += d*d;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        new HappyNumber().isHappy(19);
    }
}
