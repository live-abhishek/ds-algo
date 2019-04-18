package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class VideoStitching {
    public int videoStitching(int[][] clips, int T) {
        int count = 0;
        Arrays.sort(clips, Comparator.comparing(a -> a[0]));
        int currEnd = 0;
        for (int i = 0; i < clips.length; ) {
            if (currEnd < clips[i][0]) {
                // cannot add any more clips to current selection of clips
                return -1;
            }
            int currMaxEnd = currEnd;
            while (i < clips.length && clips[i][0] <= currEnd) {
                currMaxEnd = Integer.max(currMaxEnd, clips[i][1]);
                i++;
            }
            count++;
            currEnd = currMaxEnd;
            if (currEnd >= T) {
                return count;
            }
        }
        return -1;
    }
}
