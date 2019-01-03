package multithreading;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSortParallel {
    private int[] arr;

    public MergeSortParallel(int[] arr){
        this.arr = arr;
    }

    public void parallelMergeSort(){
        parallelMergeSort(0,this.arr.length-1,
                Runtime.getRuntime().availableProcessors());
    }

    public void parallelMergeSort(int l, int h, int numThreads){
        if (numThreads <= 1) {
            mergeSort(l, h);
        } else {
            int m = (l + h) / 2;
            Thread leftSorter = new Thread(
                    () -> parallelMergeSort(l, m, numThreads/2));
            Thread rightSorter = new Thread(
                    () -> parallelMergeSort(m+1, h, numThreads/2));
            try {
                leftSorter.start();
                rightSorter.start();
                leftSorter.join();
                rightSorter.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            merge(l, m, h);
        }
    }

    private void mergeSort(int l, int h){
        if(l < h) {
            int m = (l + h) / 2;
            mergeSort(l, m);
            mergeSort(m + 1, h);
            merge(l, m, h);
        }
    }

    private void merge(int l, int m, int h){
        int[] tempArr = new int[h-l+1];
        int lIdx = l; // left sub-array start index
        int rIdx = m + 1; // right sub-array start index
        int tIdx = 0; // tempArr index
        while(lIdx <= m && rIdx <= h){
            if(this.arr[lIdx] <= this.arr[rIdx]){
                tempArr[tIdx] = this.arr[lIdx];
                lIdx++;
            } else {
                tempArr[tIdx] = this.arr[rIdx];
                rIdx++;
            }
            // inc the idx where next insertion in temp array will take place
            tIdx++;
        }
        while(lIdx <= m){
            tempArr[tIdx] = this.arr[lIdx];
            lIdx++;
            tIdx++;
        }
        while(rIdx <= h){
            tempArr[tIdx] = this.arr[rIdx];
            rIdx++;
            tIdx++;
        }
        // now copy the temp arr to original array
        for(int i = 0; i < tempArr.length; i++){
            this.arr[l+i] = tempArr[i];
        }
    }

    @Override
    public String toString() {
        return Arrays.stream(this.arr)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", ", "[","]"));
    }

    public static void main(String[] args) {
        int[] arr = {2, 10, 5, 8, 1};
        MergeSortParallel parallelMergeSort = new MergeSortParallel(arr);
        parallelMergeSort.parallelMergeSort();
        System.out.println(parallelMergeSort);
    }
}
