package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SummationParallel {
    int[] arr;
    int numTasks;
    public SummationParallel(int[] arr, int numTasks){
        this.arr = arr;
        this.numTasks = numTasks;
    }

    public int sum(){
        List<Callable<Integer>> callableList = getTasks();
        ExecutorService threadPool = Executors.newFixedThreadPool(this.numTasks);
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

    private List<Callable<Integer>> getTasks(){
        List<Callable<Integer>> callableList = new ArrayList<>();

        int splitSize = (int)Math.ceil((double)this.arr.length / this.numTasks);

        for (int i = 0; i < this.numTasks; i++) {
            int low = i * splitSize;
            int high = Integer.min((i+1)*splitSize, this.arr.length);
            Callable<Integer> callable = (() -> IntStream.range(low, high)
                    .map(j -> SummationParallel.this.arr[j])
                    .sum());
            callableList.add(callable);
        }
        return callableList;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
//        int[] arr = {1, 2};
        int numThreads = Integer.min(
                Runtime.getRuntime().availableProcessors(), arr.length);
        SummationParallel summationParallel = new SummationParallel(arr, numThreads);
        int ans = summationParallel.sum();
        System.out.println(ans);
    }
}
