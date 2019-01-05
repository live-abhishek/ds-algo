package multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class SummationForkJoin extends RecursiveTask<Integer> {
    int[] arr;
    int low;
    int high; // exclusive
    public SummationForkJoin(int[] arr) {
        this(arr, 0, arr.length);
    }
    public SummationForkJoin(int[] arr, int low, int high) {
        this.arr = arr;
        this.low = low;
        this.high = high;
    }

    @Override
    protected Integer compute() {
        int size = this.high - this.low;
        if (size <= 2) {
            return sum();
        } else {
            int mid = (this.low + this.high) / 2;
            SummationForkJoin task1 = new SummationForkJoin(arr, this.low, mid);
            SummationForkJoin task2 = new SummationForkJoin(arr, mid, this.high);
            invokeAll(task1, task2);
            int sum1 = task1.join();
            int sum2 = task2.join();
            return sum1 + sum2;
        }
    }

    private int sum(){
        return IntStream.range(this.low, this.high).map(i-> this.arr[i]).sum();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        SummationForkJoin summationForkJoin = new SummationForkJoin(arr);
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        Integer ans = forkJoinPool.invoke(summationForkJoin);
        System.out.println(ans);
    }
}
