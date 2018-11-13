package algo;

import java.util.stream.IntStream;

public class SqrtDecomposition {
    private int[] arr;
    private int[] blocks;
    private int blockLen;

    public SqrtDecomposition(int[] arr){
        this.arr = arr;
        preprocessing();
    }

    private void preprocessing() {
        blockLen = (int) Math.sqrt(arr.length) + 1;
        blocks = new int[blockLen];
        IntStream.range(0, blockLen).
                forEach(i-> blocks[i / blockLen] += arr[i]);
    }

    private int getSum(int l, int r) {
        int sum = 0;
        for (int i = l; i < r + 1; ) {
            if (i % blockLen == 0 && i + blockLen - 1 <= r) {
                sum += blocks[i / blockLen];
                i += blockLen;
            } else {
                sum += arr[i];
                ++i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 8, 6, 7, 9, 4};
        SqrtDecomposition sqrtD = new SqrtDecomposition(arr);
        int sum = sqrtD.getSum(0, arr.length - 1);
        System.out.println(sum);
    }
}
