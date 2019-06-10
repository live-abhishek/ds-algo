package codingInterview.twoHeaps;

import java.util.PriorityQueue;

public class SlidingWindowMedian {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            addNum(nums[i]);
            if(i >= k - 1){ // or i - k + 1 >= 0
                result[i - k + 1] = getMedian();
                removeNum(nums[i - k + 1]);
            }
        }
        return result;
    }

    private void addNum(int num){
        if (maxHeap.isEmpty() || maxHeap.peek() > num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        reBalance();
    }

    private void removeNum(int num) {
        if (maxHeap.peek() >= num) {
            maxHeap.remove(num);
        } else {
            minHeap.remove(num);
        }
        reBalance();
    }

    private void reBalance(){
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    private double getMedian(){
        if (maxHeap.size() == minHeap.size()) {
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        } else {
            return maxHeap.peek();
        }
    }


    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }
}
