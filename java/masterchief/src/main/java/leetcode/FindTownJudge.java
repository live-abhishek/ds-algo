package leetcode;

public class FindTownJudge {
    public int findJudge(int N, int[][] trust) {
        // tf =trust factor
        int[] tf = new int[N];
        int[] saw = new int[N];
        for (int[] tr : trust) {
            int truster = tr[0];
            int trusted = tr[1];
            tf[trusted - 1] += 1;
            saw[truster -1] += 1;
        }
        int num = 0;
        int judge = 0;
        for (int i = 0; i < tf.length; i++) {
            if (saw[i] == 0 && tf[i] == N - 1) {
                num++;
                judge = i + 1;
            }
        }
        return num == 1 ? judge : -1;
    }
}
