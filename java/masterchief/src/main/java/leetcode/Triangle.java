package leetcode;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                Integer val = triangle.get(i).get(j);
                int b1 = triangle.get(i+1).get(j);
                int b2 = triangle.get(i+1).get(j+1);
                triangle.get(i).set(j, val + Integer.min(b1, b2));
            }
        }
        return triangle.get(0).get(0);
    }
}
