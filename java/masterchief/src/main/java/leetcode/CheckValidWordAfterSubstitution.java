package leetcode;

public class CheckValidWordAfterSubstitution {
    public boolean isValid(String S) {
        if (S.length() == 0 || S.length() % 3 != 0) {
            return false;
        }
        String lastString = new String(S);
        while (!S.isEmpty()) {
            S = S.replace("abc", "");
            if (S.equals(lastString)) {
                break; // no substring was removed
            }
            lastString = S;
        }
        return S.isEmpty();
    }
}
