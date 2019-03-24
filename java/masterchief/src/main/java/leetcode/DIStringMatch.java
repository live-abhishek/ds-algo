package leetcode;

public class DIStringMatch {
    public int[] diStringMatch(String S) {
        int[] res = new int[S.length() + 1];
        int I = 0;
        int D = S.length();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                res[i] = I++;
            } else {
                res[i] = D--;
            }
        }
        res[res.length - 1] = I;
        return res;
    }
}
