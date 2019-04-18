package leetcode;

public class SwapParis {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode swapPairs(ListNode head) {
        head = recursiveSwap(head);
        return head;
    }

    private ListNode recursiveSwap(ListNode head){
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode lastNode = recursiveSwap(head.next.next);
            ListNode left = head;
            ListNode right = head.next;
            left.next = lastNode;
            right.next = left;
            head = right;
            return head;
        }
    }
}
