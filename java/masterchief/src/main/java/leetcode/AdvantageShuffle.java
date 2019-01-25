package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AdvantageShuffle {
    static class ItemB{
        int val;
        int pos;
        ItemB(int p, int v){pos=p; val=v;}
    }

    public int[] advantageCount(int[] A, int[] B) {
        int[] ans = new int[A.length];
        Arrays.sort(A);
        PriorityQueue<ItemB> pq = new PriorityQueue<>(B.length, (a,b) -> b.val - a.val);
        // populate priority Queue
        for (int i = 0; i < B.length; i++) pq.add(new ItemB(i, B[i]));
        int currentBiggestInAIdx = A.length-1;
        int currentSmallestInAIdx = 0;
        while (!pq.isEmpty()) {
            ItemB biggestItemInB = pq.remove();
            ans[biggestItemInB.pos] = (A[currentBiggestInAIdx] > biggestItemInB.val)
                    ? A[currentBiggestInAIdx--]
                    : A[currentSmallestInAIdx++];
        }
        return ans;
    }
}
