package leetcode;

public class RemoveNthNodeFromEnd {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head;
        for (int i = 1; i <= n; i++) {
            front = front.next;
        }
        if (front == null) {
            head = head.next;
            return head;
        }
        ListNode back = head;
        while (front.next != null) {
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return head;
    }
}
