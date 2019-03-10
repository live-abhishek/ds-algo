package leetcode;

public class StringWithoutAAAOrBBB {
    public String strWithout3a3b(int A, int B) {
        // m = main, o = other
        char m, o;
        // mc = main count, oc = other count
        int mc, oc;
        if(A > B){
            m = 'a';
            o = 'b';
            mc = A;
            oc = B;
        } else {
            m = 'b';
            o = 'a';
            mc = B;
            oc = A;
        }
        StringBuilder sb = new StringBuilder();
        while (mc > 0 || oc > 0) {
            int mainTimes = Integer.min(2, mc);
            for (int i = 0; i < mainTimes; i++) {
                sb.append(Character.toString(m));
            }
            mc -= mainTimes;
            int otherTimes = Integer.min(1, oc);
            for (int i = 0; i < otherTimes; i++) {
                sb.append(Character.toString(o));
            }
            oc -= otherTimes;
        }
        return sb.toString();
    }
}
