package leetcode;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            boolean isBad = isBadVersion(m);
            if (isBad) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    /**
     * This is dummy api, actual version is implemented in the question.
     * @param version
     * @return
     */
    boolean isBadVersion(int version) {
        return false;
    }
}
