package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ClumsyFactorial {
    public int clumsy(int N) {
        List<Integer> bag = new ArrayList<>();
        int curr = N;
        //            *, /, +, -
        int[] sign = {0, 1, 2, 3};
        int nextSign = 0;
        for (int i = N-1; i > 0; i--) {
            switch (nextSign) {
                case 0: //multiply:
                    curr = curr * i;
                    break;
                case 1:
                    curr = curr / i;
                    break;
                case 2:
                    curr = curr + i;
                    break;
                case 3:
                    bag.add(curr);
                    curr = -i;
            }
            nextSign = (nextSign + 1) % 4;
        }
        bag.add(curr);
        int sum = 0;
        for (int n : bag) {
            sum += n;
        }
        return sum;
    }

    public static void main(String[] args) {
        ClumsyFactorial c = new ClumsyFactorial();
        int ans = c.clumsy(4);
        System.out.println(ans);
    }
}
