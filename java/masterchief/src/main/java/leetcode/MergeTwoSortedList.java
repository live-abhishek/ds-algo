package leetcode;

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode(0);
        ListNode curr = resultHead;
        while(l1 != null && l2 != null){
            if (l1.val < l2.val) {
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        return resultHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
