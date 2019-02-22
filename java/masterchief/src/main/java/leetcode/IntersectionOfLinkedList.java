package leetcode;

public class IntersectionOfLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);
        // if listA's size if greater than listB
        // then swap headA with headB
        if (sizeA > sizeB) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }
        // from this point onwards, listA will be smaller than listB
        int diff = Math.abs(sizeA - sizeB);
        while (diff > 0) {
            diff--;
            headB = headB.next;
        }
        while (headA != headB && headA != null) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }
}
