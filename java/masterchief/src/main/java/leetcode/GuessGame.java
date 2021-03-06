package leetcode;

public class GuessGame {
    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            int res = guess(m);
            if (res == 0) {
                return m;
            }
            if(res == -1){
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    /**
     * This is dummy api, actual version is implemented in the question.
     * @param num
     * @return
     */
    int guess(int num){
        return 0;
    }
}
