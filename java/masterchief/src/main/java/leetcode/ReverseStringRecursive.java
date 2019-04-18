package leetcode;

import java.util.Arrays;

public class ReverseStringRecursive {
    public void reverseString(char[] s) {
        recusrsiveReverse(s, 0, s.length - 1);
    }

    public void recusrsiveReverse(char[] s, int start, int end){
        if(start >= end){
            return;
        } else {
            char t = s[start];
            s[start] = s[end];
            s[end] = t;
            recusrsiveReverse(s, start+1, end-1);
        }
    }

    public static void main(String[] args) {
        ReverseStringRecursive r = new ReverseStringRecursive();
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        r.reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }
}
