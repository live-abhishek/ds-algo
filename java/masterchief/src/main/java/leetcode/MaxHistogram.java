package leetcode;

import java.util.Stack;

public class MaxHistogram {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> s = new Stack<>();
        int max = 0;
        int i = 0;
        while (i < height.length) {
            if (s.isEmpty() || height[i] >= height[s.peek()]) {
                s.push(i++);
            } else {
                int top = s.pop();
                int area = height[top] * (s.empty() ? i : i - s.peek() - 1);
                max = Integer.max(max, area);
            }
        }

        while (!s.isEmpty()) {
            int top = s.pop();
            int area = height[top] * (s.empty() ? i : i - s.peek() - 1);
            max = Integer.max(max, area);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxHistogram m = new MaxHistogram();
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        int ans = m.largestRectangleArea(arr);
        System.out.println(ans);
    }
}
