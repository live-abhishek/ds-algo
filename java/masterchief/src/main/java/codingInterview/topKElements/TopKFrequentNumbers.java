package codingInterview.topKElements;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentNumbers {
    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
//        Map<Integer, Long> freqMap = Arrays.stream(nums)
//                .boxed()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i : nums){
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else {
                if (entry.getValue() > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }
        List<Integer> topNumbers = minHeap.stream().map(e -> e.getKey()).collect(Collectors.toList());
        return topNumbers;
    }

    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}
