package hackerrank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.IntStream;

public class NikitaAndTheGame {
    static PrintStream out;
    static Scanner sc;

    public static void main(String[] args) throws FileNotFoundException {
        out = System.out;
        sc = new Scanner(System.in);
        sc = new Scanner(new FileInputStream(NikitaAndTheGame.class.getClassLoader().getResource("NikitaAndTheGame/input.txt").getFile()));

        int tcCount = sc.nextInt();
        for(int i = 0; i < tcCount; i++){
            solveTC();
        }
        sc.close();
    }

    static void solveTC(){
        int size = sc.nextInt();
        long[] arr = new long[size];
        IntStream.range(0, size).forEach(i ->arr[i] = sc.nextInt());

        long[] prefixSum = new long[size];
        prefixSum[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            prefixSum[i] = arr[i] + prefixSum[i-1];
        }

        int count = 0;
        // if all the elements are 0; found by checking the last element of prefix sum
        if (prefixSum[size - 1] == 0){
            count = size - 1;
            out.println(count);
            return;
        } else {
            int stId = 0;
            int endId = size;
            while(true){
                long low = stId == 0 ? 0 : prefixSum[stId - 1];
                long high = prefixSum[endId-1];
                long diff = high - low;
                if(diff % 2 == 0){
                    long mid = (low + high) >>> 1;
                    int midId = binarySearch(prefixSum, stId, endId, mid);
                    if(midId >= 0){
                        count++;
                        int leftSubArraySize = midId + 1 - stId;
                        int rightSubArraySize = endId - midId - 1;
                        if (leftSubArraySize >= rightSubArraySize){
                            endId = midId+1; // select the left sub array
                        } else {
                            stId = midId + 1; // select the right sub array
                        }
                    } else {
                        break; // could not find value for partitioning
                    }
                } else {
                    break;
                }
            }
            out.println(count);
        }
    }

    static int binarySearch(long[] arr, int fromIndex, int toIndex, long key){
        int low = fromIndex;
        int hi = toIndex;
        int found = -1;

        while( low <= hi ){
            int mid = (low + hi) >>> 1;
            long midVal = arr[mid];

            if(midVal < key){
                low = mid + 1;
            } else if(midVal > key){
                hi = mid - 1;
            } else {
                found = mid;
                // For first occurance
                low = mid + 1;
                // For last occurance
                // hi = mid - 1;
            }
        }
        return found;
    }
}
