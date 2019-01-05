package multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeSortForkJoin extends RecursiveAction {
    int[] arr;
    int low;
    int high;

    MergeSortForkJoin(int[] arr) {
        this(arr, 0, arr.length - 1);
    }
    MergeSortForkJoin(int[] arr, int low, int high) {
        this.arr = arr;
        this.low = low;
        this.high = high;
    }

    @Override
    protected void compute() {
        int size = this.high - this.low + 1;
        if (size <= 4) {
            mergeSort();
        } else {
            int mid = (this.high + this.low) / 2;
            MergeSortForkJoin task1 = new MergeSortForkJoin(this.arr, this.low, mid);
            MergeSortForkJoin task2 = new MergeSortForkJoin(this.arr,mid + 1, this.high);
            invokeAll(task1, task2);
            merge(this.low, mid, this.high);
        }
    }

    private void mergeSort() {
        mergeSort(this.low, this.high);
    }

    private void mergeSort(int low, int high){
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    private void merge(int low, int mid, int high){
        int lIdx = low;
        int rIdx = mid+1;
        int[] temp = new int[high - low + 1];
        int tIdx = 0;

        while (lIdx <= mid && rIdx <= high) {
            if (this.arr[lIdx] <= this.arr[rIdx]) {
                temp[tIdx] = this.arr[lIdx];
                lIdx++;
            } else {
                temp[tIdx] = this.arr[rIdx];
                rIdx++;
            }
            tIdx++;
        }
        while (lIdx <= mid) {
            temp[tIdx] = this.arr[lIdx];
            lIdx++;
            tIdx++;
        }
        while (rIdx <= high) {
            temp[tIdx] = this.arr[rIdx];
            rIdx++;
            tIdx++;
        }
        for (int i = 0; i < temp.length; i++) {
            this.arr[low + i] = temp[i];
        }

    }

    @Override
    public String toString() {
        return IntStream.range(0, this.arr.length)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public static void main(String[] args) {
        int[] arr = {6,5,3,1,8,7,2,4};
        ForkJoinPool forkJoinPool =
                new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        MergeSortForkJoin mergeSort = new MergeSortForkJoin(arr);
        forkJoinPool.invoke(mergeSort);
        System.out.println(mergeSort);
    }
}
