package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterInLinkedList {
//    [9,7,6,7,6,9]
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        return nextLargerNodes(list);
    }

    public int[] nextLargerNodes(List<Integer> list) {
        int[] greaters = new int[list.size()];
        Arrays.fill(greaters, 0);
        Stack<Integer> stk = new Stack<>();
        for (int i = list.size()-1; i >= 0; i--) {
            int currNum = list.get(i);
            if (stk.isEmpty()) {
                stk.push(currNum);
                continue;
            }
            if (currNum < stk.peek()) {
                greaters[i] = stk.peek();
                stk.push(currNum);
            } else {
                while (!stk.empty() && stk.peek() <= currNum){
                    stk.pop();
                }
                if(!stk.empty()) {
                    greaters[i] = stk.peek();
                }
                stk.push(currNum);
            }
        }
        return greaters;
    }

    public static void main(String[] args) {
        NextGreaterInLinkedList n = new NextGreaterInLinkedList();
        List<Integer> list = Arrays.asList(1,7,5,1,9,2,5,1);
        int[] ans = n.nextLargerNodes(list);
        System.out.println(Arrays.toString(ans));
    }
}
