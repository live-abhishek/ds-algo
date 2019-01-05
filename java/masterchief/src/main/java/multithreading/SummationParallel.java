package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SummationParallel {
    int[] arr;
    public SummationParallel(int[] arr){
        this.arr = arr;
    }

    public int sum(){
        int splitNums = Integer.min(
                Runtime.getRuntime().availableProcessors(), arr.length);
        List<Callable<Integer>> callableList = new ArrayList<>();

        List<List<Integer>> ranges = getRanges(this.arr.length, splitNums);
        for (List<Integer> range : ranges) {
            Callable<Integer> callable = (() -> IntStream
                    .rangeClosed(range.get(0), range.get(1))
                    .map(i -> SummationParallel.this.arr[i])
                    .sum());
            callableList.add(callable);
        }
        ExecutorService threadPool = Executors.newFixedThreadPool(splitNums);
        List<Future<Integer>> futures = callableList.stream().map(threadPool::submit)
                .collect(Collectors.toList());
        int sum = 0;
        for (Future<Integer> future : futures) {
            try {
                sum += future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        // closing the threadpool
        threadPool.shutdown();
        return sum;
    }

    /**
     * Helper method to calculate the ranges of each split
     * @param arrSize
     * @param splitNums
     * @return
     */
    public List<List<Integer>> getRanges(int arrSize, int splitNums){
        int splitSize = arrSize/splitNums;
        List<List<Integer>> lists = new ArrayList<>();
        // find all but last range
        for (int splitNum = 0; splitNum < splitNums - 1; splitNum++) {
            int startIdx = splitNum * splitSize;
            int endIdx = startIdx + splitSize - 1;
            lists.add(List.of(startIdx, endIdx));
        }
        // last range; calculated differently because this range will consist
        // rest of the remaining element of the array
        lists.add(List.of((splitNums-1) * splitSize, arrSize - 1));
        return lists;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
//        int[] arr = {1, 2};
        SummationParallel summationParallel = new SummationParallel(arr);
        int ans = summationParallel.sum();
        System.out.println(ans);
    }
}
