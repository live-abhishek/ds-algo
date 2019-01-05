package multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class MaxFindForkJoin extends RecursiveTask<Integer> {
    int[] arr;
    int low;
    int high;

    public MaxFindForkJoin(int[] arr) {
        this(arr, 0, arr.length);
    }

    public MaxFindForkJoin(int[] arr, int low, int high) {
        this.arr = arr;
        this.low = low;
        this.high = high;
    }

    @Override
    protected Integer compute() {
        int size = this.high - this.low;
        if (size <= 2) {
            return max();
        } else {
            int mid = (this.low + this.high) / 2;
            MaxFindForkJoin task1 = new MaxFindForkJoin(this.arr, this.low, mid);
            MaxFindForkJoin task2 = new MaxFindForkJoin(this.arr, mid, this.high);
            invokeAll(task1, task2);
            int max1 = task1.join();
            int max2 = task2.join();
            return Integer.max(max1, max2);
        }
    }

    private Integer max(){
        return IntStream.range(this.low, this.high)
                .map(i-> this.arr[i])
                .max().getAsInt();
    }

    public static void main(String[] args) {
        int[] arr = {6,5,3,1,8,7,2,4};
        MaxFindForkJoin maxFind = new MaxFindForkJoin(arr);
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        Integer ans = forkJoinPool.invoke(maxFind);
        System.out.println(ans);
    }
}
