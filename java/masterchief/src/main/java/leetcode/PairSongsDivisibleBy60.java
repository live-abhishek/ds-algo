package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairSongsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            int t = time[i] % 60;
            if (!map.containsKey(t)) {
                map.put(t, new ArrayList<>());
            }
            map.get(t).add(i);
        }
        int ans = 0;
        for (Integer key : map.keySet()) {
            if (key > 30) {
                continue;
            }
            if (key == 30 || key == 0) {
                ans += nC2(map.get(key).size());
            } else {
                int l1 = map.get(key).size();
                int l2 = map.getOrDefault(60-key, new ArrayList<>()).size();
                ans += l1 * l2;
            }
        }
        return ans;
    }

    private int nC2(int n) {
        return (n * (n-1)) / 2;
    }

    public static void main(String[] args) {
        PairSongsDivisibleBy60 p = new PairSongsDivisibleBy60();
        int[] arr = {30,20,150,100,40};
        int a = p.numPairsDivisibleBy60(arr);
        System.out.println(a);
    }
}
