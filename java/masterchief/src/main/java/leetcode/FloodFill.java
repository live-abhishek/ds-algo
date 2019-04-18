package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        image[sr][sc] = newColor;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            if (r > 0 && image[r-1][c] == oldColor) {
                image[r - 1][c] = newColor;
                q.offer(new int[]{r - 1, c});
            }
            if (r < image.length - 1 && image[r + 1][c] == oldColor) {
                image[r +1][c] = newColor;
                q.offer(new int[]{r + 1, c});
            }
            if (c > 0 && image[r][c - 1] == oldColor) {
                image[r][c - 1] = newColor;
                q.offer(new int[]{r, c - 1});
            }
            if (c < image[0].length - 1 && image[r][c + 1] == oldColor) {
                image[r][c + 1] = newColor;
                q.offer(new int[]{r, c + 1});
            }
//            if (r > 0 && c > 0 && image[r - 1][c - 1] == oldColor) {
//                image[r - 1][c - 1] = newColor;
//                q.offer(new int[]{r - 1, c - 1});
//            }
//            if (r > 0 && c < image[0].length - 1 && image[r - 1][c + 1] == oldColor) {
//                image[r - 1][c + 1] = newColor;
//                q.offer(new int[]{r - 1, c + 1});
//            }
//            if (r < image.length - 1 && c > 0 && image[r + 1][c - 1] == oldColor) {
//                image[r + 1][c - 1] = newColor;
//                q.offer(new int[]{r + 1, c - 1});
//            }
//            if (r < image.length - 1 && c < image[0].length - 1 && image[r + 1][c + 1] == oldColor) {
//                image[r + 1][c + 1] = newColor;
//                q.offer(new int[]{r + 1, c + 1});
//            }
        }
        return image;
    }
}
