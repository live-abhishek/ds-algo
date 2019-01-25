package leetcode;

import java.util.Arrays;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        int[][] pointsWithDist = new int[points.length][3];
        for(int i = 0; i < points.length; i++){
            int[] point = points[i];
            pointsWithDist[i] = calcDist(point);
        }
        Arrays.sort(pointsWithDist, (a, b) -> a[2] - b[2]);
        int[][] ansPoints = new int[K][2];
        for (int i = 0; i < K; i++) {
            int[] ansPoint = new int[2];
            ansPoint[0] = pointsWithDist[i][0];
            ansPoint[1] = pointsWithDist[i][1];
            ansPoints[i] = ansPoint;
        }
        return ansPoints;
    }

    private int[] calcDist(int[] point) {
        return new int[] {point[0], point[1], point[0]*point[0] + point[1]*point[1]};
    }
}
