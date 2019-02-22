package leetcode;

public class LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) { // no node
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        return slow == fast;
    }
}
