package leetcode;

public class AddTwoNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // this is an extraneous node
        ListNode res = new ListNode(0);
        ListNode p = l1, q = l2, curRes = res;
        int c = 0; // carry
        while(p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + c;
            c = (x + y + c) / 10;
            curRes.next = new ListNode(sum % 10);
            curRes = curRes.next;
            if(p != null){
                p = p.next;
            }
            if(q != null){
                q = q.next;
            }
        }
        if(c > 0){
            curRes.next = new ListNode(c);
        }
        // sanitize
        res = res.next;
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode (int x) {
        val = x;
    }
}
