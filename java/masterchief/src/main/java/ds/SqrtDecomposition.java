package ds;

public class SqrtDecomposition {
    int[] blocks;
    int[] arr;
    int blockSize;

    SqrtDecomposition(int[] arr) {
        this.arr = arr;
        blockSize = (int)Math.ceil(Math.sqrt(arr.length));
        int numBlocks = blockSize; // this is redundant
        this.blocks = new int[numBlocks];
        for (int i = 0; i < arr.length; i++) {
            this.blocks[i / blockSize] += arr[i];
        }
    }

    /**
     * get sum between l & r inclusive. 0 based index
     * @param l
     * @param r
     * @return
     */
    public int getSum(int l, int r) {
        int sum = 0;
        int leftBlock = l / blockSize;
        int rightBlock = r / blockSize;
        if (leftBlock == rightBlock) {
            for (int i = l; i < r + 1; i++) {
                sum += this.arr[i];
            }
        } else {
            int firstBlockEndPos = (leftBlock + 1) * blockSize;
            for (int i = l; i < firstBlockEndPos; i++) {
                sum += this.arr[i];
            }
            for (int i = leftBlock + 1; i < rightBlock - 1; i++) {
                sum += this.blocks[i];
            }
            int lastBlockStartPos = rightBlock * blockSize;
            for (int i = lastBlockStartPos; i < r + 1; i++) {
                sum += this.arr[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 7, 5, 2, 6, 3, 1, 8, 3};
        SqrtDecomposition sqrt = new SqrtDecomposition(arr);
        int ans = sqrt.getSum(2, 4);
        System.out.println(ans);
    }
}
