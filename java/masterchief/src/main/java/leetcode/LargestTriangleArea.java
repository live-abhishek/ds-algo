package leetcode;

public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double ans = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    ans = Double.max(ans, area(points[i], points[j], points[k]));
                }
            }
        }
        return ans;
    }

    /**
     * Calculates area of trianlge given 3 points
     * using shoelace formula
     * @see <a href="https://en.wikipedia.org/wiki/Shoelace_formula">https://en.wikipedia.org/wiki/Shoelace_formula</a>
     * @param A Point A
     * @param B Point B
     * @param C Point C
     * @return area of triangle
     */
    private double area(int[] A, int[] B, int[] C) {
        return Math.abs(A[0] * B[1] + B[0] * C[1] + C[0] * A[1]
                - B[0] * A[1] - C[0] * B[1] - A[0] * C[1]) * 0.5;
    }
}
